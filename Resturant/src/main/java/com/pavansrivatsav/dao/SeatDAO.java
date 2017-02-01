package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.Seat;
import com.pavansrivatsav.util.ConnectionUtil;

public class SeatDAO {

	public static final Logger logger = Logger.getLogger(SeatDAO.class.getName());

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void insert(final Seat st) {

		final String sql = "insert into seats(ID,SEAT_NO,STATUS) values(?,?,?)";
		final Object[] params = { st.getId(), st.getSeatNo(), st.getStatus() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows inserted : " + rows);

	}

	public void update(final Seat st) {

		final String sql = "update seats set STATUS=? where ID=?";
		final Object[] params = { st.getStatus(), st.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows updated : " + rows);

	}

	public void delete(final Integer id) {

		final String sql = "delete from seats where ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, "No of rows deleted : " + rows);
	}

	List<Seat> select() {

		final String sql = "select ID,SEAT_NO,STATUS from seats";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {

			Seat st = new Seat();
			st.setId(rs.getInt("ID"));
			st.setSeatNo(rs.getInt("SEAT_NO"));
			st.setStatus(rs.getBoolean("STATUS"));
			return st;

		});
	}

	public Boolean seatAvil(Integer seat) {

		String sql = "select CHECK_SEAT_AVAILABILITY(?)";
		Object[] params = { seat };
		// Boolean st = jdbcTemplate.queryForObject(sql, params, Boolean.class);
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);
	}
}
