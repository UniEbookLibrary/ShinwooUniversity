package search.model.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import book.model.vo.Book;
import oracle.jdbc.proxy.annotation.Pre;
import review.model.vo.PageInfo;


public class CategoryDAO {
	private Properties prop = null;
	
		public CategoryDAO() {
		prop = new Properties();
			
		String fileName = SearchDAO.class.getResource("/sql/search/category-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
		public int getListCount(Connection conn) {
			Statement stmt = null;
			ResultSet rset = null;
			int listCount = 0;
			
			String query = prop.getProperty("getListCount");
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			return listCount;
		}

		public ArrayList<Book> selectSearchBookList100(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList100");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					b.setCategory(rset.getInt("category_no"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
					
			return list;
		}
		public ArrayList<Book> selectSearchBookList200(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList200");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Book> selectSearchBookList300(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList300");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Book> selectSearchBookList400(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList400");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Book> selectSearchBookList500(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList500");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Book> selectSearchBookList600(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList600");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Book> selectSearchBookList700(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList700");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Book> selectSearchBookList800(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList800");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Book> selectSearchBookList900(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null; 
			ResultSet rset = null;
			ArrayList<Book> list = null;
			
			String query = prop.getProperty("selectCateList900");
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book b = new Book();
					b.setBookNo(rset.getString("book_no"));
					b.setBookTitle(rset.getString("book_title"));
					b.setAuthor(rset.getString("author"));
					b.setPublisher(rset.getString("publisher"));
					b.setRentTotal(rset.getInt("rent_total"));
					b.setOwnYN(rset.getString("own_yn"));
					b.setBookInfo(rset.getString("book_info"));
					b.setReleaseDate(rset.getDate("release_date"));
					list.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
}