package member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class FindPwd
 */
@WebServlet("/inputId.lo")
public class inputIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		int result = new MemberService().selectId(memberId);
		
			if(result > 0) {
				request.setAttribute("memberId", memberId);
				request.getRequestDispatcher("WEB-INF/views/member/sendPwd.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "해당 학번 정보 없음");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
