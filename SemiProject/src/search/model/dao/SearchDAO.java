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


public class SearchDAO {
	private Properties prop = null;
	
		public SearchDAO() {
		prop = new Properties();
			
		String fileName = SearchDAO.class.getResource("/sql/search/search-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Book> selectSearchBookList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		ArrayList<Book> list = null;
		
		String query = prop.getProperty("selectSearchList");
		
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
				b.setChangeName(rset.getString("change_name"));
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

	public ArrayList<Book> selectCategoryList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		ArrayList<Book> cList = null;
		
		String query = prop.getProperty("selectCategoryList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			cList = new ArrayList<Book>();
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
				cList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
		return cList;
	}

	public int deleteBook(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBook");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Book> selectSearchBookList200(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = null;
		
		String query = prop.getProperty("selectSearchList");
		
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

	public int getListCount(Connection conn, int categoryNo) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      int listCount = -1;
	      
	      String query = prop.getProperty("getCateListCount");
	   
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, categoryNo);
	         
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            listCount = rset.getInt(1);
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return listCount;
	}

	public ArrayList<Book> selectSearchBookList(Connection conn, PageInfo pi, int categoryNo) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		ArrayList<Book> list = null;
		
		String query = prop.getProperty("selectCateSearchList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
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
				b.setChangeName(rset.getString("change_name"));
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

	public int getListCount(Connection conn, String category, String kword) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      int listCount = -1;
	      String query = null;
	      String keyword = "%" + kword + "%";
	      
	      if(category.equals("book_title")) {
	    	  query = prop.getProperty("getSearchBListCount");
	      }else {
	    	  query = prop.getProperty("getSearchAListCount");
	      }
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, keyword);
	         
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            listCount = rset.getInt(1);
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return listCount;
	}

	public ArrayList<Book> selectSearchBookList(Connection conn, PageInfo pi, String category, String kword) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		ArrayList<Book> list = null;
		String query = null;
		
		
		if(category.equals("book_title")) {
			query = prop.getProperty("selectKeywordBSearchList");
		}else {
			query = prop.getProperty("selectKeywordASearchList");
		}
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		System.out.println(startRow);
		System.out.println(endRow);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + kword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
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
				b.setChangeName(rset.getString("change_name"));
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

	public int getListCount(Connection conn, String kword) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      int listCount = -1;
	      String query = null;
	      String keyword = "%" + kword + "%";
	      query = prop.getProperty("getSearchCombineCount");
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, keyword);
	         
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            listCount = rset.getInt(1);
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return listCount;
	}

	public ArrayList<Book> selectSearchBookList(Connection conn, PageInfo pi, String kword) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		ArrayList<Book> list = null;
		String query = null;
		
		
		query = prop.getProperty("selectCombineSearchList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		System.out.println(startRow);
		System.out.println(endRow);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + kword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			pstmt.setString(4, "%" + kword + "%");
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
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
