package com.example.App;

import java.io.Serializable;
import java.sql.Timestamp;

public class TrapDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private Timestamp time;
	private String ipaddress;
	private String PDU;
	
	public TrapDTO() {
		ID=0;
		ipaddress="";
		PDU="";
	}
	public TrapDTO(int ID, String ipaddress, String PDU, Timestamp time){
		this.ID = ID;
		this.time = time;
		this.ipaddress = ipaddress;
		this.PDU = PDU;
		}
	
	
	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getPDU() {
		return PDU;
	}

	public void setPDU(String pDU) {
		this.PDU = pDU;
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Trap [ID=" + ID + ", time=" + time + ", ipaddress=" + ipaddress + ", PDU=" + PDU + "]";
	}
	
}
