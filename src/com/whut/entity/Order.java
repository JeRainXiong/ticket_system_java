package com.whut.entity;

import java.util.Date;

public class Order{
    private int orderId;
    private int userId;
    private int concertId;
    private int ticketId;
    private int ticketTypeId;
    private String realname;
    private String idCard;
    private String tel;
    private float amount;
    private int paymentState;
    private Date createTime;
    private Date finishTime;
    private int orderState;
    private String orderToken;
    
    
	public Order() {}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public int getPaymentState() {
		return paymentState;
	}


	public void setPaymentState(int paymentState) {
		this.paymentState = paymentState;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getFinishTime() {
		return finishTime;
	}


	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}


	public int getOrderState() {
		return orderState;
	}


	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}


	public String getOrderToken() {
		return orderToken;
	}


	public void setOrderToken(String orderToken) {
		this.orderToken = orderToken;
	}


    public int getConcertId() {
        return concertId;
    }


    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }


    public int getTicketId() {
        return ticketId;
    }


    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    public int getTicketTypeId() {
        return ticketTypeId;
    }


    public void setTicketTypeId(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }


    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", userId=" + userId + ", concertId=" + concertId + ", ticketId="
                + ticketId + ", ticketTypeId=" + ticketTypeId + ", realname=" + realname + ", idCard=" + idCard
                + ", tel=" + tel + ", amount=" + amount + ", paymentState=" + paymentState + ", createTime="
                + createTime + ", finishTime=" + finishTime + ", orderState=" + orderState + ", orderToken="
                + orderToken + "]";
    }


    public Order(int orderId, int userId, int concertId, int ticketId, int ticketTypeId, String realname, String idCard,
            String tel, float amount, int paymentState, Date createTime, Date finishTime, int orderState,
            String orderToken) {
        super();
        this.orderId = orderId;
        this.userId = userId;
        this.concertId = concertId;
        this.ticketId = ticketId;
        this.ticketTypeId = ticketTypeId;
        this.realname = realname;
        this.idCard = idCard;
        this.tel = tel;
        this.amount = amount;
        this.paymentState = paymentState;
        this.createTime = createTime;
        this.finishTime = finishTime;
        this.orderState = orderState;
        this.orderToken = orderToken;
    }



	
}