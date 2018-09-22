package com.ds.live.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.onetwo.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ds.live.until.DateUtils;
import com.ds.live.until.LiveConfig;
import com.ds.live.until.RequestUtil;
import com.ds.temp.entity.TempAuditTotal;
import com.ds.temp.entity.TempAuditTotalExample;
import com.ds.temp.entity.TempAuditTotalExample.Criteria;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.M8SportEntity;
import com.kg.live.entity.M8SportEntityExample;
import com.kg.live.mapper.M8SportEntityMapper;

/**
 *
 * @author worf
 * @date 2018年4月18日 下午4:01:00
 */
public class H8RequestService implements Runnable {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
	private ApiInfoEntity api;
	private CountDownLatch cdl;

	private M8SportEntityMapper m8SportMapper;
	private TempAuditTotalMapper tempAuditTotalMapper;

	public H8RequestService(M8SportEntityMapper m8SportMapper, TempAuditTotalMapper tempAuditTotalMapper,
			ApiInfoEntity api, CountDownLatch cdl) {
		super();
		this.api = api;
		this.cdl = cdl;
		this.m8SportMapper = m8SportMapper;
		this.tempAuditTotalMapper = tempAuditTotalMapper;
	}

	@Override
	public void run() {
		try {
			Integer siteId = api.getSiteId();
			String siteName = api.getSiteName();
			String reportUrl = api.getReporturl();// 视讯请求地址
			String agent = api.getAgent();
			String secret = api.getLiveKey();// srcret
			logger.info("开始拉取网站id：" + siteId + ",网站名称：" + siteName + ",视讯请求地址：" + reportUrl + ",请求agent:" + agent
					+ ",secret:" + secret);
			getBet(siteId, siteName, reportUrl, agent, secret);
		} catch (Exception e) {
			logger.error("run error", e);
		} finally {
			logger.info("{}拉取完成", api.getSiteId());
			cdl.countDown();
		}
	}

	public void getBet(Integer siteId, String siteName, String reportUrl, String agent, String secret) {
		try {
			String param = "agent=" + agent + "&secret=" + secret + "&action=fetch";
			Thread.sleep((int) (Math.random() * 5) * 1000);
			String result = RequestUtil.sendGet(reportUrl, param);
			result = StringUtils.replace(result, "&", "<![CDATA[&]]>");
			result=new String(result.getBytes(),"UTF-8");
			logger.info("网站名称：" + siteName + ",result:" + result);
			// 开始解析结果
			Document document = DocumentHelper.parseText(result);
			Element root = document.getRootElement();
			Element errcodeE = (Element) root.selectSingleNode("//errcode");
			String errcode = errcodeE.getText();
			if (!errcode.equals("0")) {
				logger.info("errcode：" + errcode);
				Element errtextE = (Element) root.selectSingleNode("//errtext");
				logger.info("errtext:" + errtextE.getText());
				return;
			}
			// 解析xml文件
			List<Element> ticketList = root.selectNodes("//result//ticket");
			List<Long> fidList = new ArrayList<Long>();
			//
			for (Element e : ticketList) {

				String id = e.elementText("id");
				M8SportEntity m8Sport = getM8SportByBetId(id, siteId);
				boolean updateflag = false;
				if (m8Sport != null) {
					updateflag = true;
				} else {
					m8Sport = new M8SportEntity();
				}
				Long fid = Long.valueOf(e.elementText("fid"));
				fidList.add(fid);
				m8Sport.setFetchId(fid);
				m8Sport.setAway(e.elementText("away"));
				m8Sport.setBetAmount(new BigDecimal(e.elementText("b")).setScale(2, BigDecimal.ROUND_HALF_UP));
				m8Sport.setBetId(e.elementText("id"));
				m8Sport.setCommission(new BigDecimal(e.elementText("c")).setScale(2, BigDecimal.ROUND_HALF_UP));
				// m8Sport.setCommissionAmount(new
				// BigDecimal(e.elementText("a")).setScale(2,
				// BigDecimal.ROUND_HALF_UP));
				/*********************************/
				// 有效投注额的计算方法
				BigDecimal commissionTem = new BigDecimal(e.elementText("a")).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal winAmount = new BigDecimal(e.elementText("w")).setScale(2, BigDecimal.ROUND_HALF_UP);

				logger.info("注单号：" + m8Sport.getBetId() + "原有效金额投注额：" + commissionTem.toString());
				if (winAmount.doubleValue() < 0) {
					// 小于0，有效投注金额就等于派彩金额的绝对值（比如下注100，金额-56，有效投注额就等于56）
					m8Sport.setCommissionAmount(
							new BigDecimal(-winAmount.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
				} else if (winAmount.doubleValue() >= 0) {
					// 如果大于0，派彩金额大于下注金额，则有效投注额为下注金额，
					if (winAmount.compareTo(m8Sport.getBetAmount()) > 0) {
						m8Sport.setCommissionAmount(m8Sport.getBetAmount());
					} else {
						m8Sport.setCommissionAmount(winAmount);
					}
				}

				/*********************************/

				// m8Sport.setCreateTime(new Date());
				m8Sport.setFirstLastGoal(e.elementText("flg"));
				m8Sport.setGame(e.elementText("game"));
				m8Sport.setHalf(Byte.valueOf(e.elementText("half")));
				m8Sport.setHome(e.elementText("home"));
				m8Sport.setHtscore(e.elementText("htscore"));
				m8Sport.setInfo(e.elementText("info"));
				m8Sport.setIp(e.elementText("ip"));
				m8Sport.setLastModifyTime(DateUtils.getGMT4date(e.elementText("t")));
				m8Sport.setLeague(e.elementText("league"));
				m8Sport.setMatchdate(e.elementText("matchdate"));
				m8Sport.setOdds(new BigDecimal(e.elementText("odds")).setScale(3, BigDecimal.ROUND_HALF_UP));
				m8Sport.setResult(e.elementText("res"));//// P:NotMatchOver
														//// WA:WinAll
														//// LA:LostAll
														//// WH:WinHalf
														//// LH:LostHalf
														//// D:Draw（和局）
				m8Sport.setRunscore(e.elementText("runscore"));
				m8Sport.setScore(e.elementText("score"));
				m8Sport.setSide(e.elementText("side"));
				m8Sport.setSiteId(siteId);
				m8Sport.setSportstype(Integer.valueOf(e.elementText("sportstype")));
				m8Sport.setStatus(e.elementText("status"));
				m8Sport.setTransactionDate(DateUtil.addHours(format.parse(e.elementText("trandate")), -12));
				m8Sport.setUsername(e.elementText("u"));
				m8Sport.setWinAmount(new BigDecimal(e.elementText("w")).setScale(2, BigDecimal.ROUND_HALF_UP));
				String payoffStr = e.elementText("w");

				// 先判断是不是注单有效(status:N:Auto-Accept, A:Accepted, R:Reject,
				// C:Cancel,RG:RejectGoal,RP:RejectPenalty,RR:RejectRedCard)
				// 只有N和A是有效的注单，其他都是无效
				String status = m8Sport.getStatus();
				if (StringUtils.isNotBlank(status) && (status.equals("N") || status.equals("A"))) {
					// 在判断是不是比赛已经结束了 // P:NotMatchOver WA:WinAll LA:LostAll
					// WH:WinHalf LH:LostHalf D:Draw（和局）
					String res = m8Sport.getResult();
					if (StringUtils.isNotBlank(res) && !res.equals("P")) {
						if (StringUtils.isNotBlank(payoffStr)) {
							Double d = Double.valueOf(payoffStr);
							if (d > 0) {
								m8Sport.setWinLoseType(LiveConfig.LIVE_RESULT_TYPE_WIN);
							} else if (d < 0) {
								m8Sport.setWinLoseType(LiveConfig.LIVE_RESULT_TYPE_LOSE);
							} else {
								m8Sport.setWinLoseType(LiveConfig.LIVE_RESULT_TYPE_HE);
							}
						}
					}
				} else {
					m8Sport.setWinLoseType(LiveConfig.LIVE_RESULT_TYPE_CANCEL);
				}
				;
				m8Sport.setWorkdate(format.parse(e.elementText("workdate")));
				// m8Sport.setWorkdate(DateUtil.addHours(format.parse(e.elementText("workdate")),
				// -12));
				m8Sport.setAwayName(setHomeAwayName(reportUrl, m8Sport.getAway(), agent, secret));
				m8Sport.setHomeName(setHomeAwayName(reportUrl, m8Sport.getHome(), agent, secret));
				m8Sport.setLeagueName(setLeagueName(reportUrl, m8Sport.getLeague(), agent, secret));

				if (updateflag) {// 更新
					m8Sport.setUpdateTime(new Date());
					m8SportMapper.updateByPrimaryKey(m8Sport);
					logger.info(siteName + "更新注单:" + m8Sport.getBetId());
				} else {
					m8Sport.setCreateTime(new Date());
					m8SportMapper.insert(m8Sport);
					logger.info(siteName + " 插入注单:" + m8Sport.getBetId());
				}

				// by jackson
				logger.info("temp_audit_total start");
				int liveId = 13;// 表示h8体育
				TempAuditTotalExample example = new TempAuditTotalExample();
				Criteria createCriteria = example.createCriteria();
				createCriteria.andOrderNoEqualTo(id);
				createCriteria.andLiveIdEqualTo(liveId);
				List<TempAuditTotal> list = this.tempAuditTotalMapper.selectByExample(example);
				TempAuditTotal record = list == null || list.size() == 0 ? null : list.get(0);
				if (record == null) {// insert
					record = new TempAuditTotal();
					record.setBetTime(DateUtil.addHours(format.parse(e.elementText("trandate")), -12));
					record.setSiteId(siteId);
					record.setUsername(e.elementText("u"));
					record.setLiveId(liveId);
					record.setOrderNo(id);
					record.setPayAmount(new BigDecimal(e.elementText("w")).setScale(2, BigDecimal.ROUND_HALF_UP));
					record.setBetAmount(new BigDecimal(e.elementText("b")).setScale(2, BigDecimal.ROUND_HALF_UP));
					record.setValidAmount(m8Sport.getCommissionAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
					record.setCreateTime(new Date());
					record.setType(2);
					this.tempAuditTotalMapper.insert(record);
				} else {// update
					record.setBetTime(DateUtil.addHours(format.parse(e.elementText("trandate")), -12));
					record.setSiteId(siteId);
					record.setUsername(e.elementText("u"));
					record.setLiveId(liveId);
					record.setOrderNo(id);
					record.setPayAmount(new BigDecimal(e.elementText("w")).setScale(2, BigDecimal.ROUND_HALF_UP));
					record.setBetAmount(new BigDecimal(e.elementText("b")).setScale(2, BigDecimal.ROUND_HALF_UP));
					record.setValidAmount(m8Sport.getCommissionAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
					record.setUpdateTime(new Date());
					this.tempAuditTotalMapper.updateByPrimaryKey(record);
				}
				logger.info("temp_audit_total end");
			} // end for each

//			// 插入成功调用mark_fetch
//			String fetchIds = getFetchIds(fidList);
//			if (StringUtils.isNotBlank(fetchIds)) {
//				String markFetch = "agent=" + agent + "&secret=" + secret + "&action=mark_fetched" + "&fetch_ids="
//						+ fetchIds;
//				String markFetchResult = RequestUtil.sendGet(reportUrl, markFetch);
//				logger.info("网站名称：" + siteName + ",markFetchResult:" + markFetchResult);
//			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("网站：" + siteName + "拉取数据发生异常，异常信息：" + e.getMessage());
		}
		logger.info("网站：" + siteName + "拉取数据成功.....");
	}

	private String setHomeAwayName(String reportUrl, String awayhomeId, String agent, String secret) throws Exception {
		if (StringUtils.isBlank(awayhomeId)) {
			return null;
		}
		String param = "agent=" + agent + "&secret=" + secret + "&action=team&team_id=" + awayhomeId;
		String result = RequestUtil.sendGet(reportUrl, param);
		result = StringUtils.replace(result, "&", "<![CDATA[&]]>");
		// 开始解析结果
		Document document = DocumentHelper.parseText(result);
		Element root = document.getRootElement();
		Element errcodeE = (Element) root.selectSingleNode("//errcode");
		String errcode = errcodeE.getText();
		if (!errcode.equals("0")) {
			logger.info("errcode：" + errcode);
			Element errtextE = (Element) root.selectSingleNode("//errtext");
			logger.info("errtext:" + errtextE.getText());
			return null;
		} else {
			// 解析xml文件
			List<Element> list = root.selectNodes("//result//name//lang");
			for (Element element : list) {
				String lang = element.getTextTrim();
				if (lang.equals("zh-CN")) {
					Element cntxt = (Element) element.getParent().selectSingleNode("txt");
					return cntxt.getText();
				}
			}
		}

		return null;
	}

	private String setLeagueName(String reportUrl, String league, String agent, String secret) throws Exception {
		if (StringUtils.isBlank(league)) {
			return null;
		}
		String param = "agent=" + agent + "&secret=" + secret + "&action=league&league_id=" + league;
		String result = RequestUtil.sendGet(reportUrl, param);
		result = StringUtils.replace(result, "&", "<![CDATA[&]]>");
		
		// 开始解析结果
		Document document = DocumentHelper.parseText(result);
		Element root = document.getRootElement();
		Element errcodeE = (Element) root.selectSingleNode("//errcode");
		String errcode = errcodeE.getText();
		if (!errcode.equals("0")) {
			logger.info("errcode：" + errcode);
			Element errtextE = (Element) root.selectSingleNode("//errtext");
			logger.info("errtext:" + errtextE.getText());
			return null;
		} else {
			// 解析xml文件
			List<Element> list = root.selectNodes("//result//name//lang");
			for (Element element : list) {
				String lang = element.getTextTrim();
				if (lang.equals("zh-CN")) {
					Element cntxt = (Element) element.getParent().selectSingleNode("txt");
					return cntxt.getText();
				}
			}
		}
		return null;
	}

	private M8SportEntity getM8SportByBetId(String betId, Integer siteId) {
		M8SportEntityExample e = new M8SportEntityExample();
		e.createCriteria().andBetIdEqualTo(betId).andSiteIdEqualTo(siteId);
		List<M8SportEntity> list = m8SportMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public String getFetchIds(List<Long> fetchList) {
		if (fetchList == null || fetchList.size() < 1) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < fetchList.size(); i++) {
			if (i == 0) {
				sb.append(fetchList.get(i));
			} else {
				sb.append(",").append(fetchList.get(i));
			}
		}
		return sb.toString();
	}

}
