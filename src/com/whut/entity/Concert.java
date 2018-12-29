package com.whut.entity;

import java.util.Date;

public class Concert{
    private int concertId;
    private String concertName;
    private Date concertTime;
    private String concertStar;
    private String concertAddr;
    private String concertImg;
    private String concertDecription;
    private float concertLowerPrice;
	public int getConcertId() {
		return concertId;
	}
	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}
	public String getConcertName() {
		return concertName;
	}
	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}
	public Date getConcertTime() {
		return concertTime;
	}
	public void setConcertTime(Date concertTime) {
		this.concertTime = concertTime;
	}
	public String getConcertStar() {
		return concertStar;
	}
	public void setConcertStar(String concertStar) {
		this.concertStar = concertStar;
	}
	public String getConcertAddr() {
		return concertAddr;
	}
	public void setConcertAddr(String concertAddr) {
		this.concertAddr = concertAddr;
	}
	public String getConcertImg() {
		return concertImg;
	}
	public void setConcertImg(String concertImg) {
		this.concertImg = concertImg;
	}
	public String getConcertDecription() {
		return concertDecription;
	}
	public void setConcertDecription(String concertDecription) {
		this.concertDecription = concertDecription;
	}
	public float getConcertLowerPrice() {
		return concertLowerPrice;
	}
	public void setConcertLowerPrice(float concertLowerPrice) {
		this.concertLowerPrice = concertLowerPrice;
	}
	public Concert(int concertId, String concertName, Date concertTime, String concertStar, String concertAddr,
			String concertImg, String concertDecription, float concertLowerPrice) {
		super();
		this.concertId = concertId;
		this.concertName = concertName;
		this.concertTime = concertTime;
		this.concertStar = concertStar;
		this.concertAddr = concertAddr;
		this.concertImg = concertImg;
		this.concertDecription = concertDecription;
		this.concertLowerPrice = concertLowerPrice;
	}
    
	public Concert() {}
	@Override
	public String toString() {
		return "Concert [concertId=" + concertId + ", concertName=" + concertName + ", concertTime=" + concertTime
				+ ", concertStar=" + concertStar + ", concertAddr=" + concertAddr + ", concertImg=" + concertImg
				+ ", concertDecription=" + concertDecription + ", concertLowerPrice=" + concertLowerPrice + "]";
	}
	
    
}