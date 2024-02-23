package com.example.App;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

  
@Repository
public class TrapDAO implements TrapDAOInterface{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
    public List<TrapDTO> readTraps(){
    	String sql = "select * from trap;";
    	TrapMapper mapper = new TrapMapper();
    	List<TrapDTO> subjects = this.jdbcTemplate.query(sql, mapper);
    	return subjects;
    	}
    public List<TrapDTO> searchbyID(int ID) {
    	String sql = "select * from trap where ID = ?;";
    	TrapMapper mapper = new TrapMapper();
    	return jdbcTemplate.query(sql, mapper,ID);
    }
    public boolean deleteTrap(int ID) {
    	String sql = "DELETE FROM trap WHERE id = ?";
    	int trap = this.jdbcTemplate.update(sql, ID);
    	if (trap == 0) {
    	  return false;
    	  }
    	else {
    		return true;
    	}
    	
    }
    public List<TrapDTO> searchbyIp(String ipaddress) {
    	String sql = "select * from trap where ipaddress = ?;";
    	TrapMapper mapper = new TrapMapper();
    	return jdbcTemplate.query(sql, mapper,ipaddress);
    }

    public void insertTrap(TrapDTO trap) {
		String sql= "insert into trap (ipaddress,PDU)values (?,?)";
		this.jdbcTemplate.update( sql, trap.getIpaddress(), trap.getPDU());
    }
    public TrapDTO searchTrap(int ID){
    	String sql = "select * from trap where ID = ?;";
    	TrapMapper mapper = new TrapMapper();
    	List<TrapDTO> trap = this.jdbcTemplate.query(sql, mapper, ID);
    	if(trap.isEmpty())return null;
    	else return trap.get(0);
    }
	
}