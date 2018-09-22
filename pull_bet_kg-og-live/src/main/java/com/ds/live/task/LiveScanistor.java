package com.ds.live.task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ds.live.service.DsLiveServiceImp;
import com.ds.live.until.PropsUtil;
import com.kg.live.entity.ApiInfoEntity;

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
		logger.info(">>>>>>>>>>>>>初始化配置信息");
		String reportUrl = PropsUtil.getProperty("report_url").trim();
		String agent = PropsUtil.getProperty("agent").trim();
		String liveKey = PropsUtil.getProperty("live_key").trim();
		logger.info("ds开始进入OG网站拉取数据.....");
		//各个代理网站开始拉取
		new Thread(new LiveTask(liveService,reportUrl,siteIdMap,agent,liveKey)).start();
	}

}
