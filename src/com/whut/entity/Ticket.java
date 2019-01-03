package com.whut.entity;

import java.util.Date;

public class Ticket{
    private int ticketId;
    private int orderId;
    private int seatStaticId;
    private int ticketTypeId;
    private int concertId;
    private String concertName;
    private Date concertTime;
    private String concertAddr;
    private int userId;
    private String idCard;
    private String realName;
    private Date createTime;
    private int ticketState;
    private String checkCode;
    private String ticketToken;
    
    Ticket(){};
    
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", orderId=" + orderId + ", seatStaticId=" + seatStaticId + ", ticketTypeId="
				+ ticketTypeId + ", concertId=" + concertId + ", concertName=" + concertName + ", concertTime="
				+ concertTime + ", concertAddr=" + concertAddr + ", userId=" + userId + ", idCard=" + idCard
				+ ", realName=" + realName + ", createTime=" + createTime + ", ticketState=" + ticketState
				+ ", checkCode=" + checkCode + ", ticketToken=" + ticketToken + "]";
	}
	public Ticket(int ticketId, int orderId, int seatStaticId, int ticketTypeId, int concertId, String concertName,
			Date concertTime, String concertAddr, int userId, String idCard, String realName, Date createTime,
			int ticketState, String checkCode, String ticketToken) {
		super();
		this.ticketId = ticketId;
		this.orderId = orderId;
		this.seatStaticId = seatStaticId;
		this.ticketTypeId = ticketTypeId;
		this.concertId = concertId;
		this.concertName = concertName;
		this.concertTime = concertTime;
		this.concertAddr = concertAddr;
		this.userId = userId;
		this.idCard = idCard;
		this.realName = realName;
		this.createTime = createTime;
		this.ticketState = ticketState;
		this.checkCode = checkCode;
		this.ticketToken = ticketToken;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getSeatStaticId() {
		return seatStaticId;
	}
	public void setSeatStaticId(int seatStaticId) {
		this.seatStaticId = seatStaticId;
	}
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
	public String getConcertAddr() {
		return concertAddr;
	}
	public void setConcertAddr(String concertAddr) {
		this.concertAddr = concertAddr;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getTicketState() {
		return ticketState;
	}
	public void setTicketState(int ticketState) {
		this.ticketState = ticketState;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public String getTicketToken() {
		return ticketToken;
	}
	public void setTicketToken(String ticketToken) {
		this.ticketToken = ticketToken;
	}

    
}