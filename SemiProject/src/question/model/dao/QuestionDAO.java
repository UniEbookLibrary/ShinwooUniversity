package question.model.dao;

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

import question.model.vo.Question;
import review.model.vo.PageInfo;

public class QuestionDAO {
	
	private Properties prop = null;
	
	public QuestionDAO() {
		prop = new Properties();
		
		String fileName = QuestionDAO.class.getResource("/sql/question/question-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getUserListCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getUserListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
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
	
	public int getAdminListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getAdminListCount");
		
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


	public ArrayList<Question> selectAdminList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Question> list = null;
		
		String query = prop.getProperty("selectAdminList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Question>();
			
			while(rset.next()) {
				Question q = new Question(rset.getInt("QUEST_NO"),
										  rset.getString("QUEST_CONT"),
										  rset.getDate("QUEST_DATE"),
										  rset.getString("ANSWER"),
										  rset.getString("QUEST_ID"),
										  rset.getString("ANS_ID"),
										  rset.getString("ANS_YN"),
										  rset.getString("MEMBER_NAME"));
				list.add(q);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Question> selectUserList(Connection conn, PageInfo pi, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Question> list = null;
		
		String query = prop.getProperty("selectUserList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberId);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Question>();
			
			while(rset.next()) {
				Question q = new Question(rset.getInt("QUEST_NO"),
										  rset.getString("QUEST_CONT"),
										  rset.getDate("QUEST_DATE"),
										  rset.getString("ANSWER"),
										  rset.getString("QUEST_ID"),
										  rset.getString("ANS_ID"),
										  rset.getString("ANS_YN"),
										  rset.getString("MEMBER_NAME"));
				list.add(q);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertQuestion(Connection conn, Question q) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertQuestion");	
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, q.getQuest_cont());
			pstmt.setString(2, q.getQuest_Id());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateAnswer(Connection conn, Question q) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateAnswer");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, q.getAnswer());
			pstmt.setString(2, q.getAns_Id());
			pstmt.setInt(3, q.getQuest_No());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	
}
