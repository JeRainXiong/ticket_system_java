package com.whut.entity;

import java.util.Date;

public class Order{
    private int orderId;
    private int userId;

    private String realname;
    private String idCard;
    private String tel;
    private float amount;
    private int paymentStatus;
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


	public int getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
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


	public Order(int orderId, int userId, String realname, String idCard, String tel, float amount, int paymentStatus,
			Date createTime, Date finishTime, int orderState, String orderToken) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.realname = realname;
		this.idCard = idCard;
		this.tel = tel;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.createTime = createTime;
		this.finishTime = finishTime;
		this.orderState = orderState;
		this.orderToken = orderToken;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", realname=" + realname + ", idCard=" + idCard
				+ ", tel=" + tel + ", amount=" + amount + ", paymentStatus=" + paymentStatus + ", createTime="
				+ createTime + ", finishTime=" + finishTime + ", orderState=" + orderState + ", orderToken="
				+ orderToken + "]";
	}
	
	
}