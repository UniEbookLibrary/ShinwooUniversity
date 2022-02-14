package review.model.dao;
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

import review.model.vo.ReviewBook;

public class ReviewBookDAO {
	private Properties prop = null;
	
	public ReviewBookDAO() {
		prop = new Properties();
		String fileName = ReviewDAO.class.getResource("/sql/review/reviewBook-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ReviewBook selectReviewBook(Connection conn, int rId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReviewBook rb = null;
		
		String query = prop.getProperty("selectReviewBook");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				rb = new ReviewBook(rset.getString("book_no"),
									rset.getString("book_title"),
									rset.getString("category_name"),
									rset.getString("author"),
									rset.getString("img"),
									rset.getString("publisher"),
									rset.getDate("release_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rb;
	}

	public ArrayList<ReviewBook> selectBookList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<ReviewBook> list = null;
		
		String query = prop.getProperty("selectBookList");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<ReviewBook>();
			while(rset.next()) {
				ReviewBook rb = new ReviewBook(rset.getString("book_no"),
									rset.getString("book_title"),
									rset.getString("category_name"),
									rset.getString("author"),
									rset.getString("img"),
									rset.getString("publisher"));
				
				list.add(rb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
}
