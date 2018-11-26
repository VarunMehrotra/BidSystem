package com.bid.controller;

import com.bid.bean.*;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
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
import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.Part;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/postItem")
@MultipartConfig(fileSizeThreshold = 1024*1024*10, 	// 10 MB 
					maxFileSize = 1024*1024*50,      	// 50 MB
					maxRequestSize = 1024*1024*100) 
public class postItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public postItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		String itemName = request.getParameter("item");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String date = request.getParameter("available-date");
		String time = request.getParameter("available-time");
		Part filePart = request.getPart("file-upload"); 
		InputStream inputStream = null;
		
		if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();
        }
		
		byte[] bytes = IOUtils.toByteArray(inputStream);
		String file = Base64.getEncoder().encodeToString(bytes);
		
	    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    //InputStream fileContent = filePart.getInputStream();
		HttpSession session = request.getSession();
		String username = String.valueOf(session.getAttribute("USER"));
		
//		ItemBean bean = new ItemBean();
//		bean.setItemName(itemName);
//		bean.setDescription(description);
//		bean.setPrice(price);
//		bean.setDate(date);
//		bean.setTime(time);
//		bean.setFilePart(filePart);
//		bean.setUsername(username);
//		request.setAttribute("bean",bean);
		
		Boolean status = false;
		try {
			
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8081/Bid_WebService/postItemServices/item");
			MultivaluedMap formData = new MultivaluedMapImpl();
			formData.add("file", file);
			formData.add("user", username);
			formData.add("item", itemName);
			formData.add("description", description);
			formData.add("price", price);
			formData.add("date", date);
			formData.add("time", time);
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
			RequestDispatcher rd = request.getRequestDispatcher("postItem.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
