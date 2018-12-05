package com.micro.service;

import java.sql.ResultSet;
import com.micro.dao.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import com.micro.dao.DBQuery;
import org.json.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Path("/fetchCurrentBid")
public class FetchBidMicro {
	@Path("/fetchBid")
    @Produces("application/json")
	@GET
	public Response fetchProfile() throws JSONException{
		JSONArray profileArray = new JSONArray();
		JSONObject obj = new JSONObject();
		
		try {
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        String currentTime = sdf.format(cal.getTime());
	        String[] minute = currentTime.split(":");
	        int min = Integer.parseInt(minute[1]);
	        
	        String time = minute[0] + ":" + ((min/15) * 15) + ":00";
	        
	        System.out.println(time);
			ResultSet rs = DBQuery.getResult("select itemID, itemTitle, itemDesc, biddingPrice, file from item where auctionTime = '" + time + "' and marker = 'false'");
			
			while(rs.next()) {	
				
				ResultSet result = DBQuery.getResult("select biddingPrice from bid where itemID = '" + rs.getString("itemTitle") + "'");
				
				obj.put("itemTitle", rs.getString("itemTitle"));
				obj.put("itemDesc", rs.getString("itemDesc"));
				obj.put("initialBid", rs.getString("biddingPrice"));
				
				if (!result.next() ) {
					obj.put("biddingPrice", rs.getString("biddingPrice"));
				} 
				else {
					while(result.next()) {
						obj.put("biddingPrice", result.getString("biddingPrice"));
					}
				}
				obj.put("file", rs.getString("file"));
			}
			profileArray.put(obj);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return Response.status(200).entity(profileArray.toString()).build();
	}
}
