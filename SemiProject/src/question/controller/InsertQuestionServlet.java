package question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.vo.Member;
import question.model.service.QuestionService;
import question.model.vo.Question;

/**
 * Servlet implementation class QuestionWriteServlet
 */
@WebServlet("/questionWrite.in")
public class InsertQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quest_cont = request.getParameter("qstContent");
		String quest_Id = ((Member)request.getSession().getAttribute("loginUser")).getMemberId();
		
		Question q = new Question();
		q.setQuest_cont(quest_cont);
		q.setQuest_Id(quest_Id);
		
		int result = new QuestionService().insertQuestion(q);
		
		if(result > 0) {
			response.sendRedirect("questionList.li");
		} else {
			request.setAttribute("msg", "1:1 문의 작성 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
