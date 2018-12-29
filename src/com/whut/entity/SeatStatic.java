package com.whut.entity;

 public class SeatStatic{
    private int seatStaticId;
    private int venueId;
    private int row;
    private int colmn;
    private int seatLevel;
    private String entrance;
	@Override
	public String toString() {
		return "SeatStatic [seatStaticId=" + seatStaticId + ", venueId=" + venueId + ", row=" + row + ", colmn=" + colmn
				+ ", seatLevel=" + seatLevel + ", entrance=" + entrance + "]";
	}
	public SeatStatic(int seatStaticId, int venueId, int row, int colmn, int seatLevel, String entrance) {
		super();
		this.seatStaticId = seatStaticId;
		this.venueId = venueId;
		this.row = row;
		this.colmn = colmn;
		this.seatLevel = seatLevel;
		this.entrance = entrance;
	}
	public int getSeatStaticId() {
		return seatStaticId;
	}
	public void setSeatStaticId(int seatStaticId) {
		this.seatStaticId = seatStaticId;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColmn() {
		return colmn;
	}
	public void setColmn(int colmn) {
		this.colmn = colmn;
	}
	public int getSeatLevel() {
		return seatLevel;
	}
	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}
	public String getEntrance() {
		return entrance;
	}
	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

    
    
    
}