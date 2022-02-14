package review.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import review.model.dao.ReviewDAO;
import review.model.vo.PageInfo;
import review.model.vo.Review;

public class ReviewService {
	private ReviewDAO rDAO = new ReviewDAO();
	
	public ArrayList<Review> selectReviewList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = rDAO.selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = rDAO.getListCount(conn);
		
		close(conn);
		
		
		return listCount;
	}

	public Review selectReview(int rId, String upd) {
		Connection conn = getConnection();
		
		int result = 0;
		if(!(upd != null && upd.equals("Y"))) {
			result = rDAO.updateCount(conn, rId);
		}
		
		Review r = rDAO.selectBoard(conn, rId);
		
		if(result > 0 && r!= null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return r;
	}

	public int insertReview(Review r) {
		Connection conn = getConnection();
		
		int result = rDAO.insertReview(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int updateReview(Review r) {
		Connection conn = getConnection();
		
		int result = rDAO.updateReview(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		

		return result;
	}

	public int deleteReview(int rId) {
		Connection conn = getConnection();
		
		int result = rDAO.deleteReview(conn, rId);
		
		if(result >  0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int getRecommendCount(String cId, int rNo) {
		Connection conn = getConnection();
		
		int recommCount = rDAO.getRecommendCount(conn, cId, rNo);
		
		close(conn);
		return recommCount;
	}

	public int addRecomm(int rNo) {
		Connection conn = getConnection();
		
		int result = rDAO.addRecomm(conn, rNo);
		
		close(conn);
		return result;
	}

	public int deleteReviewAdmin(int rNo) {
		Connection conn = getConnection();
		
		int result = rDAO.deleteReviewAdmin(conn, rNo);
		
		close(conn);
		return result;
	}


}
