package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class ModifyFormServlet
 */
@WebServlet("/modifyForm.info")
public class ModifyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberId = ((Member)(request.getSession().getAttribute("loginUser"))).getMemberId();
		
		Member m = new MemberService().selectMember(memberId);

		String page = null;
		if(m != null) {
			request.setAttribute("m", m);
			page = "WEB-INF/views/member/modifyInfo.jsp";
			
		} else {
			request.setAttribute("msg", "회원 정보 로딩 실패");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
