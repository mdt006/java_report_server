package com.ds.live.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.dao.DsLiveDao;
import com.ds.live.task.LiveScanistor;
import com.ds.live.until.LiveConfig;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.entity.LotteryConfig;
import com.kg.live.entity.LotteryConfigExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.kg.live.mapper.DsLiveEntityMapper;
import com.kg.live.mapper.DsLotteryBetEntityMapper;
import com.kg.live.mapper.DsLottoBetEntityMapper;
import com.kg.live.mapper.LotteryConfigMapper;

/**
 * 
*    
* 项目名称：kg-ds-live   
* 类名称：DsLiveServiceImp   
* 类描述：   
* 创建人：光光   
* 创建时间：2015年5月10日 下午7:47:48   
* 修改人：光光   
* 修改时间：2015年5月10日 下午7:47:48   
* 修改备注：   
* @version    
*
 */
@Service
public class DsLiveServiceImp {
	final static Logger logger = Logger.getLogger(DsLiveServiceImp.class);
	@Autowired
	private DsLiveEntityMapper liveMapper;
	
	@Autowired
	private DsLottoBetEntityMapper lottoBetMapper;
	
	@Autowired
	private DsLotteryBetEntityMapper lotteryBetMapper;
	
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private DsLiveDao liveDao;
	@Autowired
	private LiveScanistor liveScanistor;
	@Autowired
	private LotteryConfigMapper lotteryConfigMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	//ds相关配置参数
	private List<ApiInfoEntity> aipInfoList;
	
	private List<LotteryConfig> lotteryConfigList;
	
	private boolean runningFlag = false;//多线程已经否是已经在运行
	
	//已经停止运行的线程数量
	public static AtomicInteger stopCount = new AtomicInteger(); 
	
	//统计ds代理网站的数量
	private static Integer listSize=0;
	
	private boolean isRunning = false;
	
	/**
	 * ds厅拉取数据
	 */
//	@PostConstruct
	public void startGetRecord(){
		logger.info("初始化DS视讯配置信息.......");
		if(isRunning){
			logger.info("程序正在正常运行,无须重新进入.....");
			return;
		}
		isRunning = true;
		logger.info("已再次进入...................");
		initApiInfoList();
		while(true){
			//开始程序运行，多线程此时并未运行
			if(!runningFlag){
				if(aipInfoList == null || aipInfoList.size() == 0){
					logger.info("DS视讯配置信息为空,请先配置apiinfo，程序稍后将重新获取");
					try {
						Thread.sleep(1000*60);//休眠1分钟
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					initApiInfoList();//重新获取配置信息(单)
				}else{
					//list不为空，配置正常（多线程）
					logger.info("开始拉取DS厅视讯注单.......");
					liveScanistor.start();
					//多线程已经开始运行
					runningFlag = true;
				}
				
			}else{//多线程已经在运行
				//运行过程中判断是否有新增修改配置
				//已经有新增修改配置
				if(aipInfoList == null || aipInfoList.size() == 0){
					logger.info("配置文件有修改，已准备获取新的配置文件，开始停止多线程.......");
					//必须等当前所有多线程停止，然后开始重新分配线程
					Integer oldListSize = listSize;
					//等待其他线程是否运行完成,当相等时，说明已经停止
					while(stopCount.intValue()!=oldListSize){
						logger.info("一共有"+oldListSize+"个线程，"+"多线程已停止数量："+stopCount.intValue()+",请稍等....");
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					logger.info("多线程已完全停止，开始重新读取配置文件.....");
					runningFlag = false;
					stopCount.set(0);//重置多线程计数为0
					initApiInfoList();
					
				}else{
					//没有新增修改配置,不用做任何事情:休眠1分钟
					try {
						logger.info("程序正常运行，主线程休眠1分钟.....");
						Thread.sleep(1000*60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	public void initApiInfoList(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.DS_KKW_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		aipInfoList = apiInfoMapper.selectByExample(e);
		listSize = aipInfoList == null?0:aipInfoList.size();
		logger.info("重新获取list，并设置listSize");
		LotteryConfigExample ex = new LotteryConfigExample();
		ex.createCriteria().andStateEqualTo(50);
		lotteryConfigList = lotteryConfigMapper.selectByExample(ex);
		
	}
	/**
	 * 获取数据库最新配置
	 * @return
	 */
	public List<ApiInfoEntity> getDbApiInfoList(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.DS_KKW_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		return apiInfoMapper.selectByExample(e);
		
	}
	public List<ApiInfoEntity> getAipInfoList() {
		return aipInfoList;
	}
	public void setAipInfoList(List<ApiInfoEntity> aipInfoList) {
		this.aipInfoList = aipInfoList;
	}
	public DsLiveEntityMapper getLiveMapper() {
		return liveMapper;
	}
	public void setLiveMapper(DsLiveEntityMapper liveMapper) {
		this.liveMapper = liveMapper;
	}
	public DsLiveDao getLiveDao() {
		return liveDao;
	}
	public void setLiveDao(DsLiveDao liveDao) {
		this.liveDao = liveDao;
	}
	public DsLottoBetEntityMapper getLottoBetMapper() {
		return lottoBetMapper;
	}
	public void setLottoBetMapper(DsLottoBetEntityMapper lottoBetMapper) {
		this.lottoBetMapper = lottoBetMapper;
	}
	public DsLotteryBetEntityMapper getLotteryBetMapper() {
		return lotteryBetMapper;
	}
	public void setLotteryBetMapper(DsLotteryBetEntityMapper lotteryBetMapper) {
		this.lotteryBetMapper = lotteryBetMapper;
	}
	public TempAuditTotalMapper getTempAuditTotalMapper() {
		return tempAuditTotalMapper;
	}
	public LotteryConfigMapper getLotteryConfigMapper() {
		return lotteryConfigMapper;
	}
	public void setLotteryConfigMapper(LotteryConfigMapper lotteryConfigMapper) {
		this.lotteryConfigMapper = lotteryConfigMapper;
	}
	public List<LotteryConfig> getLotteryConfigList() {
		return lotteryConfigList;
	}
	public void setLotteryConfigList(List<LotteryConfig> lotteryConfigList) {
		this.lotteryConfigList = lotteryConfigList;
	}
	
	
}
