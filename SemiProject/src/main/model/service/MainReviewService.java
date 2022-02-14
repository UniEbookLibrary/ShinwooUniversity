package main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import main.model.dao.ReviewDAO;

import static common.JDBCTemplate.*;
import review.model.vo.Review;

public class MainReviewService {
	
	private ReviewDAO rDAO = new ReviewDAO();

	public ArrayList<Review> selectList() {
			Connection conn = getConnection();
			
			ArrayList<Review> list = rDAO.selectList(conn);
			
			
			if(list != null) {
				commit(conn);
			}else {
				rollback(conn);
			}
				close(conn);
				
			
			return list;
			
			
		}
		
}


