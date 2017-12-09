package com.databasedesign.dao;

import com.databasedesign.main.*;
import com.databasedesign.operation.*;

public class CellBean {

	int pageNo;
	short payLoadSize;
	PayloadBean payloadBean;
	short location;
	int row;
	
	public short getPayLoadSize() {
		return payLoadSize;
	}
	public void setPayLoadSize(short payLoadSize) {
		this.payLoadSize = payLoadSize;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public PayloadBean getPayload() {
		return payloadBean;
	}
	public void setPayload(PayloadBean payloadBean) {
		this.payloadBean = payloadBean;
	}
	public short getLocation() {
		return location;
	}
	public void setLocation(short location) {
		this.location = location;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
