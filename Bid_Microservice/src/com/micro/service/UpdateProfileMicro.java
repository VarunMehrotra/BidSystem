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

@Path("/updateUserProfile")
public class UpdateProfileMicro {
	@Path("/updateProfile")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	
	public Response updatePass(MultivaluedMap<String, String> formParam) {
		
		String username = String.valueOf(formParam.getFirst("username"));
		String name = String.valueOf(formParam.getFirst("name"));
		
		String phone = String.valueOf(formParam.getFirst("phone"));
		String email = String.valueOf(formParam.getFirst("email"));
		String address = String.valueOf(formParam.getFirst("address"));
				
		try {
			DBQuery.insertResult("delete from user where username =  '" + username + "'");
			DBQuery.insertResult("insert into user values('" + username + "','" + name + "','" + email + "','"  + phone +  "','"  + address + "')");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return Response.ok().entity(String.valueOf(true)).build();
	}
	
}
