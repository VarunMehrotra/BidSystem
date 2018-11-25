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

@Path("/postItem")
public class postItemMicro {
	@Path("/item")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	
	public Response checkUsername(MultivaluedMap<String, ItemBean> formParam) {
		boolean response = false;
		
		ItemBean itemBean = formParam.getFirst("bean");
		String username = itemBean.getUsername();
		String itemName = itemBean.getItemName();
		String description = itemBean.getDescription();
		float price =  Float.parseFloat(itemBean.getPrice());
		Date date = itemBean.getDate();
		Time time = itemBean.getTime();
		Part filePart = itemBean.getFilePart();
		
		try {
		   DBQuery.insertResult("insert into item values('" + username + "','" + itemName + "','" + description + "','" + price + "','" + date + "','" + time + "','" + filePart + "','false'" + ")");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return Response.ok().entity(String.valueOf(true)).build();
	}
	
}
