package register.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import book.model.service.BookService;
import book.model.vo.Book;
import common.MyFileRenamePolicy;
import photo.model.vo.Photo;

/**
 * Servlet implementation class RegisterBookFormServlet
 */
@WebServlet("/register.bo")
public class RegisterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024*1024*10; 
			String root = request.getSession().getServletContext().getRealPath("/"); 
			String savePath = root + "image/";
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs(); 
			}
			
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy()); 

			Enumeration<String> files = multiRequest.getFileNames(); 
			String name = files.nextElement();

			String saveFiles = multiRequest.getFilesystemName(name);
			String originFiles = multiRequest.getOriginalFileName(name); 
			
			String title = multiRequest.getParameter("bookTitle");
			String author = multiRequest.getParameter("author");
			String publisher = multiRequest.getParameter("publisher");
			int category = Integer.parseInt(multiRequest.getParameter("category"));
			String bookInfo = multiRequest.getParameter("bookInfo");
			String refer = multiRequest.getParameter("refer");
			Date releaseDate = Date.valueOf(multiRequest.getParameter("releaseDate"));
			
			int n1 = (int)(Math.random() * (999 - 100 + 1)) + 100;
			int n2 = (int)(Math.random() * (9999 - 1000 + 1)) + 1000;
			char eng = 0;
			if((int)(Math.random()*10) % 2 == 0) {
				eng = (char)((int)(Math.random()*26)+97); 
			} else {
				eng =(char)((int)(Math.random()*26)+65);
			}
			
			String bookNo = category + "." + n1 + eng + n2;
			
			
			Book b = new Book(bookNo, title, category, author, publisher, null, 0, null, bookInfo, refer, releaseDate);
			
			Photo p = new Photo();
			p.setBookNo(bookNo);
			p.setFilePath(savePath);
			p.setOriginName(originFiles);
			p.setChangeName(saveFiles);
			
			
			int result = new BookService().insertThumbnail(b, p);
			
			if(result >= 2) {
				response.sendRedirect("ownBookList.li");
			} else {
				request.setAttribute("msg", "도서 등록 실패");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
				
				File fail = new File(savePath + saveFiles);
				fail.delete();
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
