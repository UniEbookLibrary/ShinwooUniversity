package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;

import static common.CreateTempPwd.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.FindPwdInfo;

/**
 * Servlet implementation class FindPwd
 */
@WebServlet("/sendPwd.lo")
public class SendPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String inputEmail = request.getParameter("inputEmail");
		String tempPwd = getRandomPassword(10);
		
		String encPwd = null;
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = tempPwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			encPwd = Base64.getEncoder().encodeToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		FindPwdInfo fpi = new FindPwdInfo(memberId, inputEmail, encPwd);
		int correctEmail = new MemberService().correctEmail(fpi);
		
		if(correctEmail > 0) {
			String recevier = inputEmail; 
			String title = "[ShinwooUniversity] 임시 비밀번호 발급 안내";
			String content = "임시 비밀번호는 <strong>" + tempPwd + "</strong> 입니다.<br>임시 비밀번호로 로그인하여 비밀번호 변경 뒤 서비스 이용 가능합니다.";
			String host = "smtp.naver.com";
			String sender = "testmail3@naver.com"; 
			String senderPwd = "dkssudgktpdy"; 
			
			Properties prop = new Properties();
			prop.setProperty("mail.smtp.host", host);
			prop.setProperty("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(prop, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(sender, senderPwd); 
				}
			});
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(sender));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recevier)); 
				message.setSubject(title);
				message.setText(content, "UTF-8", "html"); 
				
				Transport.send(message); 
				
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
				int upResult = new MemberService().updateTempPwd(fpi);
				
				if(upResult > 0) {
					request.getRequestDispatcher("WEB-INF/views/member/lastLogin.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "회원 정보의 이메일과 다른 이메일을 입력함");
					request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
				}
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
