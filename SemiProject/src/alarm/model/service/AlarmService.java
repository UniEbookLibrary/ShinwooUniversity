package alarm.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import alarm.model.dao.AlarmDAO;
import alarm.model.vo.Alarm;
import bookRental.model.vo.BookRental;
import review.model.vo.ReviewBook;

public class AlarmService {
   
   private AlarmDAO aDAO = new AlarmDAO();

   public ArrayList<Alarm> selectAlarm(String mId) {
      Connection conn = getConnection();
      
      ArrayList<Alarm> alist = aDAO.selectAlarm(conn, mId);
      
      close(conn);
      
      return alist;
   }

   public int confirmAlarm(int alarmNo) {
      Connection conn = getConnection();
      
      int result = aDAO.confirmAlarm(conn, alarmNo);
      
      if(result > 0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
   }

   public int returnAlarm(ArrayList<BookRental> list) {
      Connection conn = getConnection();
      
      int result = aDAO.returnAlarm(conn, list);
      
      if(result == list.size()) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
   }
   
   public int insertAlarm1(String writer, String bookName) {
      Connection conn = getConnection();
      
      int result = aDAO.insertAlarm1(conn, writer, bookName);
      
      
      
      if(result > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
   }
   public int insertAlarm2(String writer, String bookName) {
      Connection conn = getConnection();
      
      int result = aDAO.insertAlarm2(conn, writer, bookName);
      
      
      
      if(result > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
      
   }

public int getAlarmCount(String userId) {
	 Connection conn = getConnection();
     
	 int count = aDAO.getAlarmCount(conn, userId);
     
     close(conn);
     
     return count;
}
}