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

@Path("/updateUserPassword")
public class UpdatePasswordMicro {
	@Path("/updatePassword")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	
	public Response updatePass(MultivaluedMap<String, String> formParam) {
		
		String user_name = String.valueOf(formParam.getFirst("user_name"));
		String user_pass = String.valueOf(formParam.getFirst("user_pass"));
				
		try {
			DBQuery.insertResult("update access set password = '" +  user_pass + "' where username = '" + user_name + "'");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return Response.ok().entity(String.valueOf(true)).build();
	}
	
}
