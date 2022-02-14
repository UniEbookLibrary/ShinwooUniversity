package search.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.vo.Book;
import review.model.vo.PageInfo;
import search.model.dao.SearchDAO;
import search.model.vo.SearchBook;

public class SearchService {

	private SearchDAO sDAO = new SearchDAO(); 
	
	public ArrayList<Book> selectSearchBookList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> list = sDAO.selectSearchBookList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new SearchDAO().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Book> selectSearchCategorykList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = sDAO.selectCategoryList(conn, pi);
		
		close(conn);
		
		return cList;
	}

	public int deleteBook(int bId) {
		Connection conn = getConnection();
		
		int result = sDAO.deleteBook(conn, bId);
		
		if(result >  0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Book> selectSearchBookList100(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Book> cList = sDAO.selectSearchBookList200(conn, pi);
		
		close(conn);
		
		return cList;
	}

	public int getListCount(int categoryNo) {
		Connection conn = getConnection();
		int listCount = new SearchDAO().getListCount(conn, categoryNo);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Book> selectSearchBookList(PageInfo pi, int categoryNo) {
		Connection conn = getConnection();
		ArrayList<Book> list = sDAO.selectSearchBookList(conn, pi, categoryNo);
		
		close(conn);
		
		return list;
	}

	public int getListCount(String category, String kword) {
		Connection conn = getConnection();
		int listCount = new SearchDAO().getListCount(conn, category, kword);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Book> selectSearchBookList(PageInfo pi, String category, String kword) {
		Connection conn = getConnection();
		ArrayList<Book> list = sDAO.selectSearchBookList(conn, pi, category, kword);
		
		close(conn);
		
		return list;
	}

	public int getListCount(String kword) {
		Connection conn = getConnection();
		int listCount = new SearchDAO().getListCount(conn, kword);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Book> selectSearchBookList(PageInfo pi, String kword) {
		Connection conn = getConnection();
		ArrayList<Book> list = sDAO.selectSearchBookList(conn, pi, kword);
		
		close(conn);
		
		return list;
	}


}
