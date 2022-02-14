package book.model.dao;

import static common.JDBCTemplate.close;

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
import photo.model.vo.Photo;
import review.model.vo.PageInfo;

public class BookDAO {
	private Properties prop = null;
	
	public BookDAO() {
		prop = new Properties();
		
		String fileName = BookDAO.class.getResource("/sql/book/book-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public int insertBook(Connection conn, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBook");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, b.getBookNo());
			pstmt.setString(2, b.getBookTitle());
			pstmt.setInt(3, b.getCategory());
			pstmt.setString(4, b.getAuthor());
			pstmt.setString(5, b.getPublisher());
			pstmt.setString(6, b.getBookInfo());
			pstmt.setString(7, b.getRefer());
			pstmt.setDate(8, b.getReleaseDate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int insertPhoto(Connection conn, Photo p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPhoto");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getBookNo());
			pstmt.setString(2, p.getOriginName());
			pstmt.setString(3, p.getChangeName());
			pstmt.setString(4, p.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
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


	public ArrayList<Book> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = null;
		
		String query = prop.getProperty("selectBookList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Book>();
			while(rset.next()) {
				Book b = new Book(rset.getString("BOOK_NO"),
								  rset.getString("BOOK_TITLE"),
								  rset.getInt("CATEGORY_NO"),
								  rset.getString("AUTHOR"),
								  rset.getString("PUBLISHER"),
								  rset.getDate("REG_DATE"),
								  rset.getInt("RENT_TOTAL"),
								  rset.getString("OWN_YN"),
								  rset.getString("BOOK_INFO"),
								  rset.getString("REFER"),
								  rset.getDate("RELEASE_DATE"),
								  rset.getString("CATEGORY_NAME"));
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


	public int deleteBook(Connection conn, String[] bNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBook");
		
		try {
			for(int i = 0; i < bNo.length; i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, bNo[i]);
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getSearchAllListCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getSearchAllListCount");
		String newKey = "%" + keyword + "%";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newKey);
			pstmt.setString(2, newKey);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int getSearchTitleListCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getSearchTitieListCount");
		String newKey = "%" + keyword + "%";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newKey);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int getSearchAuthorListCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getSearchAuthorListCount");
		String newKey = "%" + keyword + "%";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newKey);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}


	public ArrayList<Book> selectSearchAllList(Connection conn, PageInfo pi, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = null;
		
		String query = prop.getProperty("selectSearchAllList");
		String newKey = "%" + keyword + "%";
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newKey);
			pstmt.setString(2, newKey);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Book>();
			while(rset.next()) {
				Book b = new Book(rset.getString("BOOK_NO"),
								  rset.getString("BOOK_TITLE"),
								  rset.getInt("CATEGORY_NO"),
								  rset.getString("AUTHOR"),
								  rset.getString("PUBLISHER"),
								  rset.getDate("REG_DATE"),
								  rset.getInt("RENT_TOTAL"),
								  rset.getString("OWN_YN"),
								  rset.getString("BOOK_INFO"),
								  rset.getString("REFER"),
								  rset.getDate("RELEASE_DATE"),
								  rset.getString("CATEGORY_NAME"));
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
	
	public ArrayList<Book> selectSearchTitleList(Connection conn, PageInfo pi, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = null;
		
		String query = prop.getProperty("selectSearchTitleList");
		String newKey = "%" + keyword + "%";
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newKey);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Book>();
			while(rset.next()) {
				Book b = new Book(rset.getString("BOOK_NO"),
						rset.getString("BOOK_TITLE"),
						rset.getInt("CATEGORY_NO"),
						rset.getString("AUTHOR"),
						rset.getString("PUBLISHER"),
						rset.getDate("REG_DATE"),
						rset.getInt("RENT_TOTAL"),
						rset.getString("OWN_YN"),
						rset.getString("BOOK_INFO"),
						rset.getString("REFER"),
						rset.getDate("RELEASE_DATE"),
						rset.getString("CATEGORY_NAME"));
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
	
	public ArrayList<Book> selectSearchAuthorList(Connection conn, PageInfo pi, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = null;
		
		String query = prop.getProperty("selectSearchAuthorList");
		String newKey = "%" + keyword + "%";
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newKey);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Book>();
			while(rset.next()) {
				Book b = new Book(rset.getString("BOOK_NO"),
						rset.getString("BOOK_TITLE"),
						rset.getInt("CATEGORY_NO"),
						rset.getString("AUTHOR"),
						rset.getString("PUBLISHER"),
						rset.getDate("REG_DATE"),
						rset.getInt("RENT_TOTAL"),
						rset.getString("OWN_YN"),
						rset.getString("BOOK_INFO"),
						rset.getString("REFER"),
						rset.getDate("RELEASE_DATE"),
						rset.getString("CATEGORY_NAME"));
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
