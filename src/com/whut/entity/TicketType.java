package com.whut.entity;

import java.util.Date;

public class TicketType{
    private int ticketTypeId;
    private int concertId;
    private String concert;
    private Date concertTime;
    private int seatLevel;
    private float unitPrice;
    private int totalNum;
    private int restNum;
	public int getTicketTypeId() {
		return ticketTypeId;
	}
	public void setTicketTypeId(int ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}
	public int getConcertId() {
		return concertId;
	}
	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}
	public String getConcert() {
		return concert;
	}
	public void setConcert(String concert) {
		this.concert = concert;
	}
	public Date getConcertTime() {
		return concertTime;
	}
	public void setConcertTime(Date concertTime) {
		this.concertTime = concertTime;
	}
	public int getSeatLevel() {
		return seatLevel;
	}
	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getRestNum() {
		return restNum;
	}
	public void setRestNum(int restNum) {
		this.restNum = restNum;
	}
	public TicketType(int ticketTypeId, int concertId, String concert, Date concertTime, int seatLevel, float unitPrice,
			int totalNum, int restNum) {
		super();
		this.ticketTypeId = ticketTypeId;
		this.concertId = concertId;
		this.concert = concert;
		this.concertTime = concertTime;
		this.seatLevel = seatLevel;
		this.unitPrice = unitPrice;
		this.totalNum = totalNum;
		this.restNum = restNum;
	}
    public TicketType() {}
	@Override
	public String toString() {
		return "TicketType [ticketTypeId=" + ticketTypeId + ", concertId=" + concertId + ", concert=" + concert
				+ ", concertTime=" + concertTime + ", seatLevel=" + seatLevel + ", unitPrice=" + unitPrice
				+ ", totalNum=" + totalNum + ", restNum=" + restNum + "]";
	}
    
}