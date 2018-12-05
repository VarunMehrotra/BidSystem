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
import org.json.*;
import org.json.simple.parser.*; 

@Path("/bidConsumerService")
public class BidConsumerMicro {
	@Path("/bidConsumer")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void bidConsumer(String str) {
		try {
			JSONObject json = new JSONObject(str);

			String username = json.getString("username");
			String newBidValue = json.getString("newBidValue");
			String itemName = json.getString("itemName");

			System.out.println("1 :    " + username + " " + newBidValue + " " + itemName);

			ResultSet rs = DBQuery.getResult("select itemID from item where itemTitle = '" + itemName + "'");
			String itemID = "";

			while(rs.next()) {	
				itemID = rs.getString("itemID");
			}

			DBQuery.insertBid(username, Integer.parseInt(itemID), Float.parseFloat(newBidValue));

			ResultSet result = DBQuery.getResult("select biddingPrice from bidresult where itemID = '" + Integer.parseInt(itemID) + "'");
			float biddingPrice = 0;

			if (!result.next() ) {
				DBQuery.insertResult("insert into bidresult values ('" + username + "','" + Integer.parseInt(itemID) + "','" + Float.parseFloat(newBidValue) + "')");
			} 
			else {
				while(result.next()) {	
					biddingPrice = result.getFloat("biddingPrice");
				}

				if(biddingPrice < Float.parseFloat(newBidValue)) {
					DBQuery.insertResult("update bidresult set biddingPrice = '" + Float.parseFloat(newBidValue) + "' where itemID = '" + Integer.parseInt(itemID) + "'");
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
