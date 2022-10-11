

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		String login=request.getParameter("login");
		String register=request.getParameter("register");
		String update=request.getParameter("update");
		String delete=request.getParameter("delete");
		Info i=new Info();
		Connection con=new Connection();
		if(login!=null)
		{
			i.setUsername(username);
			i.setPassword(password);
			login=null;
			try {
				int value=con.Login(i);
				if(value!=0)
				response.sendRedirect("HomePage.jsp");
				else
					response.sendRedirect("Register.jsp");
				
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		if(register!=null)
		{
			i.setUsername(username);
			i.setPassword(password);
			register=null;
			try {
				int value=con.Register(i);
				if(value!=0)
				response.sendRedirect("HomePage.jsp");
				else
					response.sendRedirect("Error.jsp");	
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		if(update!=null)
		{
			i.setUsername(username);
			i.setPassword(password);
			update=null;
			try {
				int value=con.Update(i);
				if(value!=0)
				response.sendRedirect("HomePage.jsp");
				else
					response.sendRedirect("Error.jsp");	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(delete!=null)
		{
			i.setPassword(password);
			update=null;
			try {
				int value=con.Delete(i);
				if(value!=0)
				response.sendRedirect("HomePage.jsp");
				else
					response.sendRedirect("Error.jsp");	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
