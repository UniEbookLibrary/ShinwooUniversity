package search.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.vo.Book;
import review.model.vo.PageInfo;
import search.model.dao.CategoryDAO;
import search.model.dao.SearchDAO;

public class CategoryService {

	private CategoryDAO cDAO = new CategoryDAO(); 
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new SearchDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Book> selectSearchBookList100(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList100(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList200(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList200(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList300(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList300(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList400(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList400(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList500(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList500(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList600(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList600(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList700(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList700(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList800(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList800(conn, pi);
		
		close(conn);
		
		return cList;
	}
	public ArrayList<Book> selectSearchBookList900(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = cDAO.selectSearchBookList900(conn, pi);
		
		close(conn);
		
		return cList;
	}

}
