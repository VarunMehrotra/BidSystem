package com.micro.service;

import com.micro.dao.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

@Path("/loginmicro")
public class LoginMicro {
	@Path("/checkDb")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	
	public Response checkDB(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		String user = formParam.getFirst("username");
		String pass = formParam.getFirst("password");
		
		try {
			ResultSet rs = DBQuery.getResult("select password from access where username='" + user + "'");
			String p = "";
			
			while(rs.next()) {
				p = rs.getString("password");
			}
			if(pass.equals(p)){
				response = true;
			}
			else{
				response = false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(response);
		return Response.ok().entity(String.valueOf(response)).build();
	}
}
