package com.whut.entity;

public class Seat{
    private int seatId;
    private int concertId;
    private int seatStaticId;
    private int seatLevel;
    private int seatState;
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getConcertId() {
		return concertId;
	}
	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}
	public int getSeatStaticId() {
		return seatStaticId;
	}
	public void setSeatStaticId(int seatStaticId) {
		this.seatStaticId = seatStaticId;
	}
	public int getSeatLevel() {
		return seatLevel;
	}
	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}
	public int getSeatState() {
		return seatState;
	}
	public void setSeatState(int seatState) {
		this.seatState = seatState;
	}
	public Seat(int seatId, int concertId, int seatStaticId, int seatLevel, int seatState) {
		super();
		this.seatId = seatId;
		this.concertId = concertId;
		this.seatStaticId = seatStaticId;
		this.seatLevel = seatLevel;
		this.seatState = seatState;
	}
    public Seat() {}
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", concertId=" + concertId + ", seatStaticId=" + seatStaticId + ", seatLevel="
				+ seatLevel + ", seatState=" + seatState + "]";
	}
    
}