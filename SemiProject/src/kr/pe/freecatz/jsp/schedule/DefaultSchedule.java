package kr.pe.freecatz.jsp.schedule;

import java.util.ArrayList;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import alarm.model.service.AlarmService;
import alarm.model.vo.Alarm;
import bookRental.model.service.BookRentalService;
import bookRental.model.vo.BookRental;

public class DefaultSchedule implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	int result = new BookRentalService().returnBookAuto();						//기한이 지난 책들을 반납
    	ArrayList<BookRental> list = new BookRentalService().selectReturnInfo();	//자동으로 반납된 책들을 객체에 저장
    	int result1 = new AlarmService().returnAlarm(list);							//해당 객체들의 정보로 알림 테이블에 추가
    	if(result == 1 && result1 == list.size()) {
    		System.out.println("대출기한이 지난 책들이 성공적으로 반납되었습니다.");
    	}else {
    		System.out.println("책들이 반납되지 않았거나 반납할 책이 없습니다.");
    	}
    }
}