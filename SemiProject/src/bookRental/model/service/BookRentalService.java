package bookRental.model.service;
import java.sql.Connection;
import java.util.ArrayList;

import bookRental.model.dao.BookRentalDAO;
import bookRental.model.vo.BookRental;
import review.model.vo.PageInfo;
import review.model.vo.Review;

import static common.JDBCTemplate.*;
public class BookRentalService {
	private BookRentalDAO brDAO = new BookRentalDAO();

	public int getListCount(String user) {
		Connection conn = getConnection();
		
		int listCount = brDAO.getListCount(conn, user);
		
		close(conn);
		return listCount;
	}

	public ArrayList<BookRental> selectRentalList(PageInfo pi, String user) {
		Connection conn = getConnection();
		
		ArrayList<BookRental> list = brDAO.selectRentalList(conn, pi, user);
		
		close(conn);
		
		return list;
	}

	public int returnBook(int rentCode) {
		Connection conn = getConnection();
		
		int result = brDAO.returnBook(conn, rentCode);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int changeDate(int rentCode) {
		Connection conn = getConnection();
		
		int result = brDAO.changeDate(conn, rentCode);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int returnBookAuto() {
		Connection conn = getConnection();
		
		int result = brDAO.returnBookAuto(conn);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<BookRental> selectMyRental(String memberId) {
		Connection conn = getConnection();
		
		ArrayList<BookRental> list = brDAO.selectMyRental(conn, memberId);
		
		close(conn);
		
		return list;
	}

	public ArrayList<BookRental> selectReturnInfo() {
		Connection conn = getConnection();
		
		ArrayList<BookRental> list = brDAO.selectReturnInfo(conn);
		
		close(conn);
		
		return list;
	}


	
}
