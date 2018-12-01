package com.web.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.PathParam;

@Path("/fetchCurrentBid")
public class FetchBidService {
	
	@Path("/fetchBid")
	@Produces("application/json")
	@GET
	public Response fetchBid() {
		
		JSONArray profileArray = null;
		ClientResponse restResponse = null;
		
		try {

			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8082/Bid_Microservice/fetchCurrentBid/fetchBid");
			
			restResponse = webResource
					.accept("application/json")
					.get(ClientResponse.class);
			profileArray = new JSONArray(restResponse.getEntity(String.class));
			
			if (restResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + restResponse.getStatus());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(profileArray.toString()).build();
	}
}
