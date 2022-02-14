package book.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.dao.BookDetailDAO;
import book.model.vo.Book;
import book.model.vo.BookDetail;

public class BookDetailService {
	private BookDetailDAO bDAO = new BookDetailDAO();

	public BookDetail selectBook(String bNo) {
		Connection conn = getConnection();
		
		BookDetail b = null;
		
		b = bDAO.selectBook(conn, bNo);
		
		if(b != null) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return b;
	}

	public int currBorrow(String bNo) {
		Connection conn = getConnection();
		int result = bDAO.currBorrow(conn, bNo);
		
		close(conn);
		return result;
	}

	public int returnCheck(String rId, String bNo) {
		Connection conn = getConnection();
		int result = bDAO.returnCheck(conn, rId, bNo);
		
		close(conn);
		return result;
	}

	public int RentalBook(String rId, String bNo) {
		Connection conn = getConnection();
		int result = bDAO.rentalBook(conn, rId, bNo);
		
		if(result > 0) {
			bDAO.upTotal(conn, bNo);
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<BookDetail> popularList() {
		Connection conn = getConnection();
		ArrayList<BookDetail> list = bDAO.popularList(conn);
		
		if(list != null) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return list;
	}

	public ArrayList<BookDetail> recentList() {
		Connection conn = getConnection();
		ArrayList<BookDetail> list = bDAO.recentList(conn);
		
		if(list != null) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return list;
	}

}
