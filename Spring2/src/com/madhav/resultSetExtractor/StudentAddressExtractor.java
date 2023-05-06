package com.madhav.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressExtractor implements ResultSetExtractor<HashMap<String, List<String>>> {

	@Override
	public HashMap<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		HashMap<String, List<String>> hm = new HashMap<>();
		while(rs.next()) {
			List<String> sl = hm.get(rs.getString("STUDENT_ADDR"));
			
			if(sl == null) {
				ArrayList<String> newsl =  new ArrayList<>();
				newsl.add(rs.getString("STUDENT_NAME"));
				
				hm.put(rs.getString("STUDENT_ADDR"), newsl);
			} else {
				hm.get(rs.getString("STUDENT_ADDR")).add(rs.getString("STUDENT_NAME"));
			}
		}
		
		return hm;
	}

}
