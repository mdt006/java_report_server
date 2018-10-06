package com.ds.live.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ds.live.until.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.live.entity.BBINGameVo;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;

@Service
public class NewManLiveService {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private BaseService baseService;
	private List<ApiInfoEntity> aipInfoList;

	public void manGetRecord(String date,String starttime,String endtime,int page,int pagelimit, ApiInfoEntity api) {
		Integer siteId = api.getSiteId();
		String siteName = api.getSiteName();
		//String reportUrl = "http://180.150.154.97:8080/dtbbinrecordapi/game/bbin/api/";// 视讯请求地址
		String reportUrl =  BBINCommon.URL;
		String uppername = api.getLiveKey();// bb视讯上级代理
		logger.info("开始拉取网站id：" + siteId + ",网站名称：" + siteName + ",视讯请求地址：" + reportUrl + ",请求liveKey:" + uppername);

		getBet(date,starttime,endtime,page,pagelimit, siteId, siteName, reportUrl, uppername);
		//糖果派对注单拉取
		getSweetBet(date,starttime,endtime,page,pagelimit, siteId, siteName, reportUrl, uppername);
		//糖果派对2注单拉取
		getSweetBetTwo(date,starttime,endtime,page,pagelimit, siteId, siteName, reportUrl, uppername);
		getLianhuanBet(date,starttime,endtime,page,pagelimit, siteId, siteName, reportUrl, uppername);
	}

	private void getBet(String date,String starttime,String endtime,int page,int pagelimit,
						Integer siteId, String siteName, String reportUrl, String uppernameKey) {
		try {
			logger.info("网站名称：" + siteName + "bbin机率正式开始拉取数据......");
			String uppername = uppernameKey; // 必须
			String rounddate = date;
			logger.info("网站名称：" + siteName + "bbin机率拉取日期" + rounddate);

			int gamekind = LiveConfig.BBIN_GAME_KIND_JL; // 机率
//			int page = 1;
//			int pagelimit = LiveConfig.BBIN_PAGE_LIMIT; // 200

			for (int j = page; j <= page; j++) {// int j=page
				// 只有初始化的时候执行一次，此后将不再赋值
				// 随机修几秒
				Thread.sleep((int) (Math.random() * 10) * 1000);
				// kkw910+BETRECORD_KEY+时间
				/*String tempParam = LiveConfig.BBIN_LIVE_WEBSITE + LiveConfig.BBIN_BETRECORD_KEY
						+ BBINDateUtils.getGMT4Date(new Date());
				logger.info("网站：" + siteName + "bbin 机率请求参数tempParam::" + tempParam + "::请求时间时间rounddate:" + rounddate);

				String param = "website=" + LiveConfig.BBIN_LIVE_WEBSITE + "&uppername=" + uppername + "&rounddate="
						+ rounddate + "&starttime="+starttime + "&endtime=" +endtime+ "&gamekind=" + gamekind + "&page="
						+ j + "&pagelimit=" + pagelimit + "&key=" + DataUtils.randomString(7)
						+ DataUtils.toMD5(tempParam) + DataUtils.randomString(2);*/
				String param = assemblyParam(uppername, rounddate, pagelimit, gamekind, j);

				logger.info("网站：" + siteName + "bbin机率正式拉取参数 param:" + param);
				JSONObject obj = null;
				try {
					obj = JSONObject.parseObject(WebHTTPUtils.sendPost1(reportUrl + "BetRecord", param));
				} catch (Exception e) {
					logger.info("网站：" + siteName + "此次请求失败.....");
					j--;
					Thread.sleep(1000 * 60);
					continue;
				}

				logger.info("网站：" + siteName + "bbin机率请求路径:" + reportUrl + "BetRecord?" + param);
				if (obj.containsKey("result")) {
					if (obj.getBoolean("result")) {
						List<BBINGameVo> dataList=JSONArray.parseArray(obj.getString("data"), BBINGameVo.class);
						if (obj.containsKey("pagination")) {
							JSONObject jo = JSONObject.parseObject(obj.getString("pagination"));
							page = jo.getIntValue("TotalPage");
						}
						insertUpdateDb(dataList, siteId.intValue(), uppername);
					} // end result = true
					else {
						logger.info("网站：" + siteName + "请求api为false,稍后将重试，返回信息为：" + obj.getString("result"));
						// 没有结果当前页不能增加
						break;
					}
				} // end obj.has("result")

			} // end forech page

			// 设置map
		} catch (Exception e) {
			e.printStackTrace();
			try {
				logger.info("网站：" + siteName + "bbin 正式环境拉取数据异常，线程降休眠1分钟:" + e.getMessage());
				Thread.sleep(1000 * 60 * 2);//
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("网站：" + siteName + "bbin 正式环境拉取一次数据完成");
	}

	private void getSweetBet(String date,String starttime,String endtime,int page,int pagelimit, Integer siteId, String siteName, String reportUrl, String uppernameKey) {
		try {
			logger.info("网站名称：" + siteName + "bbin机率 糖果派对 正式开始拉取数据......");
			String uppername = uppernameKey; // 必须
			String rounddate = date;
			logger.info("网站名称：" + siteName + "bbin机率糖果派对拉取日期" + rounddate);

			int gamekind = LiveConfig.BBIN_GAME_KIND_JL; // 机率
//			int page = 1;
//			int pagelimit = LiveConfig.BBIN_PAGE_LIMIT; // 200

			for (int j = page; j <= page; j++) {// int j=page
				// 只有初始化的时候执行一次，此后将不再赋值
				// 随机修几秒
				Thread.sleep((int) (Math.random() * 10) * 1000);
				// kkw910+BETRECORD_KEY+时间
				/*String tempParam = LiveConfig.BBIN_LIVE_WEBSITE + LiveConfig.BBIN_BETRECORD_KEY
						+ BBINDateUtils.getGMT4Date(new Date());
				logger.info(
						"网站：" + siteName + "bbin 机率糖果派对请求参数tempParam::" + tempParam + "::请求时间时间rounddate:" + rounddate);

				String param = "website=" + LiveConfig.BBIN_LIVE_WEBSITE + "&uppername=" + uppername + "&rounddate="
						+ rounddate + "&starttime="+starttime + "&endtime="+endtime + "&gamekind=" + gamekind
						+ "&subgamekind=2" + "&page=" + j + "&pagelimit=" + pagelimit + "&key="
						+ DataUtils.randomString(7) + DataUtils.toMD5(tempParam) + DataUtils.randomString(2);*/
				String param = assemblyParam(uppername, rounddate, pagelimit, gamekind, j);

				logger.info("网站：" + siteName + "bbin机率糖果派对正式拉取参数 param:" + param);
				JSONObject obj = null;
				try {
					obj = JSONObject.parseObject(WebHTTPUtils.sendPost1(reportUrl + "BetRecord", param));
				} catch (Exception e) {
					logger.info("网站：" + siteName + "此次请求失败.....");
					j--;
					Thread.sleep(1000 * 60);
					continue;
				}

				logger.info("网站：" + siteName + "bbin机率糖果派对请求路径:" + reportUrl + "BetRecord?" + param);
				if (obj.containsKey("result")) {
					if (obj.getBoolean("result")) {
						List<BBINGameVo> dataList=JSONArray.parseArray(obj.getString("data"), BBINGameVo.class);
						if (obj.containsKey("pagination")) {
							JSONObject jo = JSONObject.parseObject(obj.getString("pagination"));
							page = jo.getIntValue("TotalPage");
						}
						insertUpdateDb(dataList, siteId.intValue(), uppername);
					} // end result = true
					else {
						logger.info("网站：" + siteName + "请求api为false,糖果派对,稍后将重试，返回信息为：" + obj.getString("result"));
						// 没有结果当前页不能增加
						break;
					}
				} // end obj.has("result")

			} // end forech page
		} catch (Exception e) {
			e.printStackTrace();
			try {
				logger.info("网站：" + siteName + "bbin 正式环境拉取糖果派对数据异常，线程降休眠1分钟:" + e.getMessage());
				Thread.sleep(1000 * 60 * 2);//
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("网站：" + siteName + "bbin 正式环境糖果派对拉取一次数据完成");
	}

	/*糖果派对2*/
	private void getSweetBetTwo(String date,String starttime,String endtime,int page,int pagelimit, Integer siteId, String siteName, String reportUrl, String uppernameKey) {
		try {
			logger.info("网站名称：" + siteName + "bbin机率 糖果派对2 正式开始拉取数据......");
			String uppername = uppernameKey; // 必须
			String rounddate = date;
			logger.info("网站名称：" + siteName + "bbin机率糖果派对2拉取日期" + rounddate);

			int gamekind = LiveConfig.BBIN_GAME_KIND_JL; // 机率
//			int page = 1;
//			int pagelimit = LiveConfig.BBIN_PAGE_LIMIT; // 200

			for (int j = page; j <= page; j++) {// int j=page
				// 只有初始化的时候执行一次，此后将不再赋值
				// 随机修几秒
				Thread.sleep((int) (Math.random() * 10) * 1000);
				// kkw910+BETRECORD_KEY+时间
			/*	String tempParam = LiveConfig.BBIN_LIVE_WEBSITE + LiveConfig.BBIN_BETRECORD_KEY
						+ BBINDateUtils.getGMT4Date(new Date());
				logger.info(
						"网站：" + siteName + "bbin 机率糖果派对2请求参数tempParam::" + tempParam + "::请求时间时间rounddate:" + rounddate);

				String param = "website=" + LiveConfig.BBIN_LIVE_WEBSITE + "&uppername=" + uppername + "&rounddate="
						+ rounddate + "&starttime="+starttime + "&endtime="+endtime + "&gamekind=" + gamekind
						+ "&subgamekind=5" + "&page=" + j + "&pagelimit=" + pagelimit + "&key="
						+ DataUtils.randomString(7) + DataUtils.toMD5(tempParam) + DataUtils.randomString(2);*/
				String param = assemblyParam(uppername, rounddate, pagelimit, gamekind, j);

				logger.info("网站：" + siteName + "bbin机率糖果派对2正式拉取参数 param:" + param);
				JSONObject obj = null;
				try {
					obj = JSONObject.parseObject(WebHTTPUtils.sendPost1(reportUrl + "BetRecord", param));
				} catch (Exception e) {
					logger.info("网站：" + siteName + "此次请求失败.....");
					j--;
					Thread.sleep(1000 * 60);
					continue;
				}

				logger.info("网站：" + siteName + "bbin机率糖果派对2请求路径:" + reportUrl + "BetRecord?" + param);
				if (obj.containsKey("result")) {
					if (obj.getBoolean("result")) {
						List<BBINGameVo> dataList=JSONArray.parseArray(obj.getString("data"), BBINGameVo.class);
						if (obj.containsKey("pagination")) {
							JSONObject jo = JSONObject.parseObject(obj.getString("pagination"));
							page = jo.getIntValue("TotalPage");
						}
						insertUpdateDb(dataList, siteId.intValue(), uppername);
					} // end result = true
					else {
						logger.info("网站：" + siteName + "请求api为false,糖果派对2,稍后将重试，返回信息为：" + obj.getString("result"));
						// 没有结果当前页不能增加
						break;
//						j--;
//						Thread.sleep((int) (Math.random() * 10) * 1000);
					}
				} // end obj.has("result")

			} // end forech page
		} catch (Exception e) {
			e.printStackTrace();
			try {
				logger.info("网站：" + siteName + "bbin 正式环境拉取糖果派对2数据异常，线程降休眠1分钟:" + e.getMessage());
				Thread.sleep(1000 * 60 * 2);//
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("网站：" + siteName + "bbin 正式环境糖果派对2拉取一次数据完成");
	}
	private void getLianhuanBet(String date,String starttime,String endtime,int page,int pagelimit, Integer siteId, String siteName, String reportUrl, String uppernameKey) {
		try {
			this.logger.info("网站名称：" + siteName + "bbin机率 连环夺宝 正式开始拉取数据......");
			String uppername = uppernameKey;
			String rounddate = date;
			this.logger.info("网站名称：" + siteName + "bbin机率连环夺宝拉取日期" + rounddate);

			int gamekind = LiveConfig.BBIN_GAME_KIND_JL.intValue();
//			int page = 1;
//			int pagelimit = LiveConfig.BBIN_PAGE_LIMIT.intValue();
			for (int j = page; j <= page; j++) {
				Thread.sleep((int) (Math.random() * 10.0D) * 1000);

			/*	String tempParam = "kkw910Z9e9k82Y" + BBINDateUtils.getGMT4Date(new Date());
				this.logger.info(
						"网站：" + siteName + "bbin 机率连环夺宝请求参数tempParam::" + tempParam + "::请求时间时间rounddate:" + rounddate);

				String param = "website=kkw910&uppername=" + uppername + "&rounddate=" + rounddate
						+ "&starttime="+starttime + "&endtime="+endtime + "&gamekind=" + gamekind + "&subgamekind=3"
						+ "&page=" + j + "&pagelimit=" + pagelimit + "&key=" + DataUtils.randomString(7)
						+ DataUtils.toMD5(tempParam) + DataUtils.randomString(2);*/
				String param = assemblyParam(uppername, rounddate, pagelimit, gamekind, j);

				this.logger.info("网站：" + siteName + "bbin机率连环夺宝正式拉取参数 param:" + param);
				JSONObject obj = null;
				try {
					obj = JSONObject.parseObject(WebHTTPUtils.sendPost1(reportUrl + "BetRecord", param));
				} catch (Exception e) {
					this.logger.info("网站：" + siteName + "此次请求失败.....");
					j--;
					Thread.sleep(60000L);
					continue;
				}
				this.logger.info("网站：" + siteName + "bbin机率连环夺宝请求路径:" + reportUrl + "BetRecord?" + param);
				if (obj.containsKey("result")) {
					if (obj.getBoolean("result")) {
						List<BBINGameVo> dataList=JSONArray.parseArray(obj.getString("data"), BBINGameVo.class);
						if (obj.containsKey("pagination")) {
							JSONObject jo = JSONObject.parseObject(obj.getString("pagination"));
							page = jo.getIntValue("TotalPage");
						}
						insertUpdateDb(dataList, siteId.intValue(), uppername);
					} else {
						this.logger.info("网站：" + siteName + "请求api为false,连环夺宝,稍后将重试，返回信息为：" + obj.getString("result"));

						j--;
						Thread.sleep((int) (Math.random() * 10.0D) * 1000);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				this.logger.info("网站：" + siteName + "bbin 正式环境拉取连环夺宝数据异常，线程降休眠1分钟:" + e.getMessage());
				Thread.sleep(120000L);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		this.logger.info("网站：" + siteName + "bbin 正式环境连环夺宝拉取一次数据完成");
	}

	private void insertUpdateDb(List<BBINGameVo> dataList, int siteId, String uppername) throws Exception {
		baseService.saveDataList(dataList, siteId, uppername);
	}

	public void initapiInfoList() {
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.BBIN_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		aipInfoList = apiInfoMapper.selectByExample(e);
		logger.info("读取api_list完成......");
	}

	public List<ApiInfoEntity> getAipInfoList() {
		return aipInfoList;
	}

	public void setAipInfoList(List<ApiInfoEntity> aipInfoList) {
		this.aipInfoList = aipInfoList;
	}

	private String assemblyParam(String uppername, String rounddate, int pagelimit, int gamekind, int j) throws UnsupportedEncodingException {
/*		StringBuffer sb = new StringBuffer();
		//sb.append("website="+LiveConfig.BBIN_LIVE_WEBSITE);
		sb.append("&uppername="+uppername);
		sb.append("&rounddate="+rounddate);
		sb.append("&starttime=00:00:00");
		sb.append("&endtime=23:59:59");
		sb.append("&gamekind="+gamekind);
		sb.append("&page="+j);
		sb.append("&pagelimit="+pagelimit);
		String key = EncryptUtils.encrypt(sb.toString(),BBINUtils.USERKEY);
		sb.append("&key="+key);
		return sb.toString();*/
		Map<String,String> paramMap = new TreeMap<String,String>(){{
			put("uppername",uppername);
			put("rounddate",rounddate);
			put("starttime","00:00:00");
			put("endtime","23:59:59");
			put("gamekind",gamekind+"");
			put("page", j+"");
			put("pagelimit", pagelimit+"");
		}};
		String param = BBINCommon.mapToString(paramMap);
		String key = EncryptUtils.encrypt(param,BBINCommon.USERKEY);
		param+="&key="+key;
		return param;
	}
}
