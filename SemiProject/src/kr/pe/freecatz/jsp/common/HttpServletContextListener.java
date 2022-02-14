package kr.pe.freecatz.jsp.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class HttpServletContextListener
 *
 */
@WebListener
public class HttpServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public HttpServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        ScheduleRegister sr = new ScheduleRegister();
        sr.execute();
    }
	
}
