package com.web.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.bid.controller.Date;
import com.bid.controller.Part;
import com.bid.controller.Time;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.PathParam;

@Path("/postItemServices")
public class postItemService {
	@Path("/item")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response isValidUser(MultivaluedMap<String, ItemBean> formParam) {
		boolean response = false;
		boolean status = false;
		ClientResponse restResponse = null;
		
		MultivaluedMap fp = new MultivaluedMapImpl();
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8082/Bid_Microservice/postItem/item");
			
			ItemBean bean = formParam.getFirst("bean");
						
			fp.add("bean",bean);
			
			restResponse = webResource
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.post(ClientResponse.class, fp);

			if (restResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}

			String statusString = restResponse.getEntity(String.class);
			status = Boolean.parseBoolean(statusString);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		//if(!status) {
			return Response.ok().entity(String.valueOf(status)).build();
		//}
		
	}

	@Path("/availableusername/{username}")
	@GET
	public String availableUsername(@PathParam("username") String username) {

		return username + " is not available. Please consider " + username + "_001";
	}
}
