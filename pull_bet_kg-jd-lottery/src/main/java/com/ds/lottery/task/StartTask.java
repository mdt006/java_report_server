package com.ds.lottery.task;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ds.lottery.common.BaseCommon;
import com.ds.lottery.service.DsLotteryServiceImp;
import com.ds.lottery.vo.GameTypeVo;
import com.kg.live.entity.LotteryInfoEntity;

@Component
public class StartTask {
	private Logger logger = LoggerFactory.getLogger(StartTask.class);
	@Autowired
	private DsLotteryServiceImp lotteryService;
	
	@PostConstruct
	public void startPullData() {
		BaseCommon.initGameName();
		logger.info("初始化平台名称完成：{},{},{},{}",BaseCommon.KIND_NAME_SSC,BaseCommon.KIND_NAME_HK,BaseCommon.KIND_NAME_PC28,BaseCommon.KIND_NAME_DSPT);
		loadLotteryInfoMap();
		loadOutGameCodeMap();
	}
	
	@Scheduled(cron="0 0/1 * * * ? ")
	public void loadLotteryInfoMap(){
		List<LotteryInfoEntity> lotteryInfoList = lotteryService.getDbLotteryInfoList();
		for(LotteryInfoEntity o: lotteryInfoList){
			if(!BaseCommon.LOT_INFO_MAP.containsKey(o.getSiteid())){
				logger.info("启动新的拉取配置线程：{}",o.getSiteid());
				new Thread(new LotteryTask(lotteryService,o)).start();
			}
			BaseCommon.LOT_INFO_MAP.put(o.getSiteid(), o);
		}
		for(Map.Entry<Integer,LotteryInfoEntity> map: BaseCommon.LOT_INFO_MAP.entrySet()){
			boolean del=true;
			for(LotteryInfoEntity o: lotteryInfoList){
				if(map.getKey().equals(o.getSiteid())){//如果未被删除
					del=false;
					break;
				}
			}
			if(del){//配置已在数据库中删除
				BaseCommon.LOT_INFO_MAP.remove(map.getKey());
			}
		}
		
		logger.info("加载拉取配置{},{}",BaseCommon.LOT_INFO_MAP.size(),BaseCommon.LOT_INFO_MAP);
	}
	
	@Scheduled(cron="0 0/5 * * * ? ")
	public void loadOutGameCodeMap(){
		Map<String,GameTypeVo> gameTypeVoMap = lotteryService.getGameType(12,BaseCommon.GAME_KIND_LIST);
		for(Map.Entry<String,GameTypeVo> map: gameTypeVoMap.entrySet()){
				BaseCommon.OUTCODE_GAME_MAP.put(map.getKey(), map.getValue());
		}
		for(Map.Entry<String,GameTypeVo> map: BaseCommon.OUTCODE_GAME_MAP.entrySet()){//删除已不存在数据库的配置
			if(!gameTypeVoMap.containsKey(map.getKey())){
				BaseCommon.OUTCODE_GAME_MAP.remove(map.getKey());
			}
		}
		logger.info("加载outgamecodeMap:{}",BaseCommon.OUTCODE_GAME_MAP);
	}
	
	
}
