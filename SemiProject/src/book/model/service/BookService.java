package book.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.dao.BookDAO;
import book.model.vo.Book;
import photo.model.vo.Photo;
import review.model.vo.PageInfo;

public class BookService {
	
	private BookDAO bkDAO = new BookDAO();

	public int insertThumbnail(Book b, Photo p) {
		Connection conn = getConnection();
		
		int result1 = bkDAO.insertBook(conn, b);
		int result2 = bkDAO.insertPhoto(conn, p);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 + result2;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = bkDAO.getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Book> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Book> list = bkDAO.selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int deleteBook(String[] bNo) {
		Connection conn = getConnection();
		
		int result = bkDAO.deleteBook(conn, bNo);
		if(result >= bNo.length) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int getSearchAllListCount(String keyword) {
		Connection conn = getConnection();
		
		int listCount = bkDAO.getSearchAllListCount(conn, keyword);
		
		close(conn);
		
		return listCount;
	}
	
	public int getSearchTitleListCount(String keyword) {
		Connection conn = getConnection();
		
		int listCount = bkDAO.getSearchTitleListCount(conn, keyword);
		
		close(conn);
		
		return listCount;
	}
	
	public int getSearchAuthorListCount(String keyword) {
		Connection conn = getConnection();
		
		int listCount = bkDAO.getSearchAuthorListCount(conn, keyword);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Book> selectSearchAllList(PageInfo pi, String keyword) {
		Connection conn = getConnection();
		
		ArrayList<Book> list = bkDAO.selectSearchAllList(conn, pi, keyword);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Book> selectSearchTitleList(PageInfo pi, String keyword) {
		Connection conn = getConnection();
		
		ArrayList<Book> list = bkDAO.selectSearchTitleList(conn, pi, keyword);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Book> selectSearchAuthorList(PageInfo pi, String keyword) {
		Connection conn = getConnection();
		
		ArrayList<Book> list = bkDAO.selectSearchAuthorList(conn, pi, keyword);
		
		close(conn);
		
		return list;
	}




}
