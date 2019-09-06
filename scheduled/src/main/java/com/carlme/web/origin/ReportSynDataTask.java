package com.carlme.web.origin;

import org.springframework.stereotype.Component;

import java.util.TimerTask;

@Component
public class ReportSynDataTask extends TimerTask {

	public void run() {
		//定时任务执行..
		System.out.println("run...");
	}

}
