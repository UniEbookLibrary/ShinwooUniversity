package kr.pe.freecatz.jsp.common;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import kr.pe.freecatz.jsp.schedule.DefaultSchedule;

public class ScheduleRegister {

	 public ScheduleRegister() {

	    }

	    public void execute() {

	        try {
	            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

	            scheduler.scheduleJob(
	                    newJob(DefaultSchedule.class)
	                            .withIdentity("defaultSchedule", Scheduler.DEFAULT_GROUP)
	                            .build(),
	                    newTrigger()
	                            .withIdentity("defaultTrgger", Scheduler.DEFAULT_GROUP)
	                            .withSchedule(cronSchedule("00 30 11 * * ?"))	// 크론표현식, 매일 00시 실행
	                            .build());
	            
	            scheduler.start();

	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
}