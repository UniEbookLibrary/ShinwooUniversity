package review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recommend.model.service.RecommendService;
import review.model.service.ReviewService;

/**
 * Servlet implementation class CheckRecommendServlet
 */
@WebServlet("/checkRecommend.rv")
public class CheckRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckRecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cId = request.getParameter("cId");
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		int result = 0;
		
		int checkRecomm = new ReviewService().getRecommendCount(cId, rNo);
		
		if(checkRecomm == 0) {		//댓글작성 가능하면
			int tempResult = new ReviewService().addRecomm(rNo);	//추천수 1누적
			if(tempResult == 1) {
				int tempResult2 = new RecommendService().addInfoRec(cId, rNo);	//추천테이블에 데이터 추가
				if(tempResult2 == 1) {
					result = 1;
				}
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
