package com.ds.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.ds.task.AGCommonJob;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		AGCommonJob agJob =  (AGCommonJob) event.getApplicationContext().getBean("AGCommonJob");
		agJob.exec();
	}

}
