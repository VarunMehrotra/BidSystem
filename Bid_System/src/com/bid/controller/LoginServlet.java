package com.bid.controller;

import com.bid.bean.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginBean bean = new LoginBean();
		bean.setName(username);
		bean.setPassword(password);
		request.setAttribute("bean",bean);

		Boolean status = false;
		try {
			 
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8081/Bid_WebService/loginservices/checkuservalidity");
			MultivaluedMap formData = new MultivaluedMapImpl();
			formData.add("username", username);
			formData.add("password", password);
			ClientResponse restResponse = webResource
			    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			    .post(ClientResponse.class, formData);
			
			if (restResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
 
			String statusString = restResponse.getEntity(String.class);
			status = Boolean.parseBoolean(statusString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(status){
			HttpSession session = request.getSession();
			session.setAttribute("USER", username);
			RequestDispatcher rd = request.getRequestDispatcher("welcome-page.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
