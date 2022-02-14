package recommend.model.service;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import recommend.model.dao.RecommendDAO;

public class RecommendService {
	private RecommendDAO rcDAO = new RecommendDAO();

	
	public int addInfoRec(String cId, int rNo) {
		Connection conn = getConnection();
		
		int result = rcDAO.addRecomm(conn, rNo, cId);
		
		close(conn);
		return result;
	}
	
	
}
