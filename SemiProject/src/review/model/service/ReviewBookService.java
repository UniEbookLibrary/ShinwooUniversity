package review.model.service;
import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.*;
import review.model.dao.ReviewBookDAO;
import review.model.vo.ReviewBook;
public class ReviewBookService {
	private ReviewBookDAO rbDAO = new ReviewBookDAO();

	public ReviewBook selectReviewBook(int rId) {
		Connection conn = getConnection();
		
		ReviewBook rb = rbDAO.selectReviewBook(conn, rId);
		
		close(conn);
		
		
		return rb;
	}

	public ArrayList<ReviewBook> selectBookList() {
		Connection conn = getConnection();
		
		ArrayList<ReviewBook> list = rbDAO.selectBookList(conn);
		
		close(conn);
		
		return list;
	}
}
