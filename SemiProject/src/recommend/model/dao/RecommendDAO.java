package recommend.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import review.model.dao.ReviewDAO;

public class RecommendDAO {
	private Properties prop = null;
	
	public RecommendDAO() {
		prop = new Properties();
		String fileName = ReviewDAO.class.getResource("/sql/recommend/recommend-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int addRecomm(Connection conn, int rNo, String cId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("addInfoRecomm");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			pstmt.setString(2, cId);
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
