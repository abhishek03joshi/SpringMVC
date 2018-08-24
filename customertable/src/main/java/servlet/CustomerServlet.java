package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.*;
import dao.CustomerDAO;
import beans.Customer;


/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CustomerDAO cusdao;
	private static String INSERT_OR_EDIT = "/customerform.jsp";
	private static String LIST_CUSTOMERS = "/customerlist.jsp";
	private static String SEARCH = "/searchcustomer.jsp";
	
	
	public void init() {
		String jdbcURL=getServletContext().getInitParameter("jdbcURL");//servlet reads the parameter values defined in web.xml. 
		String jdbcUsername=getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword=getServletContext().getInitParameter("jdbcPassword");
		
		cusdao= new CustomerDAO(jdbcURL,jdbcUsername,jdbcPassword);
		
		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action=request.getParameter("action");
		
		System.out.println(action);
		
		try {
			if(action.equalsIgnoreCase("delete"))
			{
				int custid= Integer.parseInt(request.getParameter("id"));
				cusdao.deleteCustomer(custid);
				forward = LIST_CUSTOMERS;
				request.setAttribute("customers",cusdao.listAllCustomers());
			}
			else if (action.equalsIgnoreCase("edit")) {
				forward=INSERT_OR_EDIT;
				int custid=Integer.parseInt(request.getParameter("id"));
				Customer customer  = cusdao.getCustomer(custid);
				request.setAttribute("customer", customer);
				
			}
			
			else if (action.equalsIgnoreCase("listCustomers")) {
				forward = LIST_CUSTOMERS;
				System.out.println("********listCustomer() called******");;
				request.setAttribute("customers", cusdao.listAllCustomers());
				System.out.println(cusdao.listAllCustomers());
			}
			
			else if (action.equalsIgnoreCase("search")) {
				forward=SEARCH;
				String strmobile = request.getParameter("mobile");
				Customer customer  = cusdao.getCustomer(strmobile);
				request.setAttribute("customer", customer);
			}
			else {
	            forward = INSERT_OR_EDIT;
	        }
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	        
	        
		}
		
		
		catch(SQLException ex)
		{
			throw new ServletException(ex);
		}
			
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Customer customer = new Customer();
		
		//customer.setID(request.getParameter("ID"));
		customer.setName(request.getParameter("name"));
		customer.setMobile(request.getParameter("mobile"));
		
		String cusid = "";
        cusid = request.getParameter("id");
        
        if(cusid == null || cusid.isEmpty() || cusid=="") {
        	try {
        		cusdao.insertCustomer(customer);
        	}
        	catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
        
        else {
        	
        	int cid;
        	
        	cid=Integer.parseInt(request.getParameter("id"));
        	customer.setId(cid);
        	
        	try {
        		cusdao.updateCustomer(customer);
        	}
        	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_CUSTOMERS);
        try {
			request.setAttribute("customers", cusdao.listAllCustomers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
    }
        
        
        
}


