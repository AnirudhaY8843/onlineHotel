package model;

import java.sql.Date;

public class BookingDTO {
	private int bId;
	private int BookingNo;
	private int uId;
	
	private Date date;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getBookingNo() {
		return BookingNo;
	}
	public void setBookingNo(int bookingNo) {
		BookingNo = bookingNo;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	

}
