package com.ds.live.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ds.live.service.DsLiveServiceImp;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.MGGameConfig;
import com.kg.live.entity.MGGameConfigExample;
import com.kg.live.mapper.MGGameConfigMapper;

/**
 * 
*    
* 项目名称：kg-ds-live   
* 类名称：LiveScanistor   
* 类描述：   扫描拉取类
* 创建人：光光   
* 创建时间：2015年5月10日 下午8:59:23   
* 修改人：光光   
* 修改时间：2015年5月10日 下午8:59:23   
* 修改备注：   
* @version    
*
 */
@Component
public class LiveScanistor implements Runnable{
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private DsLiveServiceImp liveService;
	@Autowired
	private MGGameConfigMapper mgConfigMapper;
	public void start() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		List<ApiInfoEntity> apiInfoList = liveService.getAipInfoList();
		Map<String,Integer> siteIdMap = new HashMap<String,Integer>();
		for (ApiInfoEntity api : apiInfoList) {
			siteIdMap.put(api.getPrefix(), api.getSiteId());
		}
		//初始化MG配置信息
		List<MGGameConfig> configList = getMGConfigList();
		
		logger.info("开始进入各个网站拉取数据.....");
//		//各个代理网站开始拉取
		for (MGGameConfig config : configList) {
			new Thread(new LiveTask(liveService,config,siteIdMap)).start();
		}
		
	}
	private List<MGGameConfig> getMGConfigList(){
		MGGameConfigExample e = new MGGameConfigExample();
		e.createCriteria().andStateEqualTo(50);
		return mgConfigMapper.selectByExample(e);
	}

}
