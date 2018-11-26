package com.micro.service;

import com.micro.dao.*;
import java.text.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

@Path("/postItem")
public class postItemMicro {
	@Path("/item")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	
	public Response checkUsername(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		
		String file = formParam.getFirst("file");
		String itemName = String.valueOf(formParam.getFirst("item"));
		String description = String.valueOf(formParam.getFirst("description"));
		float price = Float.parseFloat(String.valueOf(formParam.getFirst("price")));
		String date = String.valueOf(formParam.getFirst("date"));
		String time = String.valueOf(formParam.getFirst("time"));
		String user = String.valueOf(formParam.getFirst("user"));
		
		
		try {
			DBQuery.insertItem(user, itemName, description, price, date, time, file);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return Response.ok().entity(String.valueOf(true)).build();
	}
	
}
