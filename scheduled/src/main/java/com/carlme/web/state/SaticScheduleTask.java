package com.carlme.web.state;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 静态定时任务
 * 显然，使用@Scheduled 注解很方便，但缺点是当我们调整了执行周期的时候，需要重启应用才能生效，这多少有些不方便。
 * <p>
 * Cron表达式参数分别表示：
 * <p>
 * 秒（0~59） 例如0/5表示每5秒
 * 分（0~59）
 * 时（0~23）
 * 日（0~31）的某天，需计算
 * 月（0~11）
 * 周几（ 可填1-7 或 SUN/MON/TUE/WED/THU/FRI/SAT）
 *
 * @Scheduled：除了支持灵活的参数表达式cron之外，还支持简单的延时操作，例如 fixedDelay ，fixedRate 填写相应的毫秒数即可。
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
	//3.添加定时任务
	@Scheduled(cron = "0/5 * * * * ?")
	//或直接指定时间间隔，例如：5秒
	//@Scheduled(fixedRate=5000)
	private void configureTasks() {
		System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	}
}