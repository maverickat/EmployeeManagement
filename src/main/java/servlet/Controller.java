package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.Regulation;
import model.User;
import util.CommentManage;
import util.RegulationManage;
import util.UserManage;
/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManage usermanager = null;
	RegulationManage regulationmanager = null;
	CommentManage commentmanager = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			helper(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	public void helper(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		String param = request.getParameter("action");
		if(param==null) {
			authenticate(request,response);
		}
		else if(request.getSession().getAttribute("id")!=null) {
			if(param!=null && param.equals("add_comment")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("Comment.jsp");
	            dispatch.forward(request, response);
			}
			else if(param!=null && param.equals("delete_comment")){
				String commentid = request.getParameter("commentid");
				if(commentid != null){
					commentmanager = new CommentManage();
					commentmanager.deleteComment(commentid);
				}          
				getUser(request,response);
				getRegulation(request, response);
				getComment(request, response);
				request.setAttribute("user",(usermanager.getUser((String)request.getSession().getAttribute("id"))));
				RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");//to do
	            dispatch.forward(request, response);		
			}
			else if(param!=null && param.equals("save_comment")){
				Comment comment = new Comment();
				comment.setDetails(request.getParameter("details"));
				comment.setCreateDate(new Date());
				comment.setRegulationid(request.getParameter("regulationid"));
				comment.setCommentid(request.getParameter("commentid"));
				comment.setUserid((String)(request.getSession(false).getAttribute("id")));
				commentmanager = new CommentManage();
				commentmanager.createComment(comment);
				getUser(request,response);
				getRegulation(request, response);
				getComment(request, response);
				request.setAttribute("user",(usermanager.getUser((String)request.getSession().getAttribute("id"))));
				RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");//to do
	            dispatch.forward(request, response);
				
			}
			else if(param!=null && param.equals("add_regulation")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("Regulation.jsp");
	            dispatch.forward(request, response);
			}
			else if(param!=null && param.equals("delete_regulation")){
				String regulationid = request.getParameter("regulationid");
				if(regulationid != null){
					regulationmanager = new RegulationManage();
					regulationmanager.deleteRugulation(regulationid);
				}          
				getUser(request,response);
				getRegulation(request, response);
				getComment(request, response);
				request.setAttribute("user",(usermanager.getUser((String)request.getSession().getAttribute("id"))));
				RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");//to do
	            dispatch.forward(request, response);		
			}
			else if(param!=null && param.equals("save_regulation")){
				Regulation regulation = new Regulation();
				regulation.setDetails(request.getParameter("details"));
				regulation.setCreateDate(new Date());
				regulation.setDepartment(request.getParameter("department"));
				regulation.setRegulationid(request.getParameter("regulationid"));
				regulationmanager = new RegulationManage();
				regulationmanager.createRegulation(regulation);
				getUser(request,response);
				getRegulation(request, response);
				getComment(request, response);
				request.setAttribute("user",(usermanager.getUser((String)request.getSession().getAttribute("id"))));
				RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");//to do
	            dispatch.forward(request, response);
				
			}
			else if(param!=null && param.equals("add_user")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("User.jsp");//to do
	            dispatch.forward(request, response);
			}
			else if(param!=null && param.equals("delete_user")){
				String userid = request.getParameter("userid");
				if(userid != null){
					usermanager = new UserManage();
					usermanager.deleteUser(userid);
				}          
				getUser(request,response);
				getRegulation(request, response);
				getComment(request, response);
				request.setAttribute("user",(usermanager.getUser((String)request.getSession().getAttribute("id"))));
				RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");//to do
	            dispatch.forward(request, response);		
			}
			else if(param!=null && param.equals("save_user")){
				
				User user = new User();
				user.setFname(request.getParameter("fname"));
				user.setLname(request.getParameter("lname"));
				user.setPhone(request.getParameter("phone"));
				user.setEmail(request.getParameter("email"));
				user.setRole(request.getParameter("role"));
				user.setUserid(request.getParameter("userid"));
				user.setPassword(request.getParameter("password"));
				if(usermanager.getUser(user.getUserid()).getPassword()==null) {
					usermanager.createUser(user);
				}
				else {
					usermanager.UpdateUser(user);
				}
				getUser(request,response);
				getRegulation(request, response);
				getComment(request, response);
				request.setAttribute("user",(usermanager.getUser((String)request.getSession().getAttribute("id"))));
				RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");//to do
	            dispatch.forward(request, response);
			}
			else if(param!=null && param.equals("logout")){
				HttpSession session=request.getSession();
	            session.invalidate();
				response.sendRedirect("index.jsp");
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
	}
	
	public void authenticate(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException, SQLException{
		User user = new User();
		user.setRole("admin");
		user.setUserid(request.getParameter("uid"));
		user.setPassword(request.getParameter("pwd"));
		
		usermanager = new UserManage();
		
		Boolean checkLogin = usermanager.Login(user);
		if(checkLogin) {
			request.setAttribute("user",user);
			HttpSession session=request.getSession();  
	        session.setAttribute("id",user.getUserid());
	        getUser(request,response);
			getRegulation(request, response);
			getComment(request, response);
	        RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");//to do
            dispatch.forward(request, response);
		}
		else{
			response.sendRedirect("index.jsp");
		}
	}

	private void getComment(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// TODO Auto-generated method stub
		commentmanager = new CommentManage();
		List<Comment> CommentList = commentmanager.getAllComment();
		request.setAttribute("commentList", CommentList);	
	}

	private void getRegulation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		regulationmanager = new RegulationManage();
		List<Regulation> RegulationList = regulationmanager.getAllRegulation();
		request.setAttribute("regulationList", RegulationList);	
		
	}

	private void getUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		List<User> UserList = usermanager.getAllUsers();
		request.setAttribute("userList", UserList);		
	}
}
