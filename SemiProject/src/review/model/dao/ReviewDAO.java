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

import review.model.vo.PageInfo;
import review.model.vo.Review;
public class ReviewDAO {
	
	private Properties prop = null;
	
	public ReviewDAO() {
		prop = new Properties();
		String fileName = ReviewDAO.class.getResource("/sql/review/review-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Review> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = null;
		
		String query = prop.getProperty("selectReviewList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Review>();
			
			while(rset.next()) {
				Review r = new Review(rset.getInt("review_no"),
									  rset.getString("book_title"),
									  rset.getString("review_title"),
									  rset.getString("review_cont"),
									  rset.getDate("review_date"),
									  rset.getInt("views"),
									  rset.getString("MEMBER_NAME"),
									  rset.getString("STATUS"));
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		int listCount = -1;	//�о�������ϸ� -1��ȯ
		
		String query = prop.getProperty("getListCount");
		
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				//listCount = rset.getInt("COUNT(*)");
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public int updateCount(Connection conn, int rId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateViewCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Review selectBoard(Connection conn, int rId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		
		String query = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				r = new Review(rset.getInt("review_no"),
							  rset.getString("book_title"),
							  rset.getString("review_title"),
							  rset.getString("review_cont"),
							  rset.getDate("review_date"),
							  rset.getInt("views"),
							  rset.getString("member_name"),
							  rset.getString("member_id"),
							  rset.getString("status"),
							  rset.getInt("recommend"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return r;
	}

	public int insertReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setString(3, r.getReviewWriter());
			pstmt.setString(4, r.getBookName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateReview");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setString(3, r.getBookName());
			pstmt.setInt(4, r.getReviewNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteReview(Connection conn, int rId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rId);
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int getRecommendCount(Connection conn, String cId, int rNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = -1;
		
		String query = prop.getProperty("getRecommCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			pstmt.setString(2, cId);
			
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

	public int addRecomm(Connection conn, int rNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("addRecomm");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteReviewAdmin(Connection conn, int rNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReviewAdmin");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
