package question.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import question.model.dao.QuestionDAO;
import question.model.vo.Question;
import review.model.vo.PageInfo;

public class QuestionService {
	private QuestionDAO qDAO = new QuestionDAO();

	public int getUserListCount(String memberId) {
		Connection conn = getConnection();
		
		int listCount = qDAO.getUserListCount(conn, memberId);
		
		close(conn);
		
		return listCount;
	}
	
	public int getAdminListCount() {
		Connection conn = getConnection();
		
		int listCount = qDAO.getAdminListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Question> selectAdminList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Question> list = qDAO.selectAdminList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Question> selectUserList(PageInfo pi, String memberId) {
		Connection conn = getConnection();
		
		ArrayList<Question> list = qDAO.selectUserList(conn, pi, memberId);
		
		close(conn);
		
		return list;
	}

	public int insertQuestion(Question q) {
		Connection conn = getConnection();
		
		int result = qDAO.insertQuestion(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateAnswer(Question q) {
		Connection conn = getConnection();
		
		int result = qDAO.updateAnswer(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}



	
	
}
