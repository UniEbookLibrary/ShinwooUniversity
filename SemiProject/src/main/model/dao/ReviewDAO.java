package main.model.dao;

	import static common.JDBCTemplate.close;

	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.Properties;

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

		public ArrayList<Review> selectList(Connection conn) {
			Statement stmt = null;
			ResultSet rset = null;
			ArrayList<Review> list = null;
			
			String query = prop.getProperty("selectMainReviewList");
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				list = new ArrayList<Review>();
				
				while(rset.next()) {
					Review r = new Review();
					r.setReviewNo(rset.getInt("review_no"));
					r.setReviewTitle(rset.getString("review_title"));
					r.setBookName(rset.getString("book_title"));
					r.setReviewDate(rset.getDate("review_date"));
					r.setReviewWriter(rset.getString("member_name"));
					r.setViews(rset.getInt("views"));		
							 
					
					list.add(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			return list;
		}
	
}
