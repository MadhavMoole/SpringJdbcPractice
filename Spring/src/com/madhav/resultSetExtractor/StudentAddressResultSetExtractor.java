package com.madhav.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		Map<String, List<String>> hm = new HashMap<>();
		while(rs.next()) {
			List<String> sl = hm.get(rs.getString(2));
			if(sl == null) {
				ArrayList<String> newsl = new ArrayList<>();
				newsl.add(rs.getString(1));
				hm.put(rs.getString(2), newsl);
			} else {
				hm.get(rs.getString(2)).add(rs.getString(1));
			}
		}
		return hm;
	}

}
