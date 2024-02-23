package com.example.App;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TrapMapper implements RowMapper<TrapDTO>{
public TrapDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
TrapDTO trap = new TrapDTO();
trap.setID(rs.getInt("ID"));
trap.setIpaddress(rs.getString("ipaddress"));
trap.setPDU(rs.getString("PDU"));
trap.setTime(rs.getTimestamp("time"));
return trap;
}
}

