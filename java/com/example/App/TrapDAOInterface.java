package com.example.App;

import java.util.List;

public interface TrapDAOInterface {
	public List<TrapDTO> readTraps();
	public void insertTrap(TrapDTO trap);
	public TrapDTO searchTrap(int ID);
	public List<TrapDTO> searchbyIp(String ipaddress);
	public List<TrapDTO> searchbyID(int ID);
	boolean deleteTrap(int ID);
}
