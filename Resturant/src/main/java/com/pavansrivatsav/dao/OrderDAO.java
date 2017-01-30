package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.Order;
import com.pavansrivatsav.modal.Seat;
import com.pavansrivatsav.util.ConnectionUtil;

public class OrderDAO {

	public static final Logger logger = Logger.getLogger(OrderDAO.class.getName());

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	Seat seat = new Seat();

	public void insert(final Order or) {

		final String sql = "insert into Orders (ID,SEAT_NO,STATUS) values(?,?,?)";
		final Object[] params = { or.getId(), or.getSeatObj().getSeatNo(), or.getStatus() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows inserted : " + rows);

	}

	public void update(final Order or) {

		final String sql = "update orders set STATUS=? where SEAT_NO=?";
		final Object[] params = { or.getStatus(), or.getSeatObj().getSeatNo() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows update : " + rows);
	}

	public void delete(final Integer id) {

		final String sql = "delete from orders where ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, "No of rows deleted : " + rows);
	}

	public List<Order> select() {

		final String sql = "select ID,SEAT_NO,STATUS from orders";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Order ord = new Order();
			final Seat st = new Seat();

			ord.setId(rs.getInt("ID"));

			st.setSeatNo(rs.getInt("SEAT_NO"));
			ord.setSeatObj(st);

			ord.setStatus(rs.getString("STATUS"));
			return ord;

		});

	}

	public Boolean invalidEntry(String item, String quantity) {

		String sql = "select INVALID_ORDER_ENTRY(?,?)";
		Object[] params = { item, quantity };
		// Boolean invalidEnty = jdbcTemplate.queryForObject(sql, params,
		// Boolean.class);
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);
	}

	public Boolean maxLength(String item, String quantity) {

		String sql = "select ORDER_MAX_LENGTH(?,?)";
		Object[] params = { item, quantity };
		// Boolean maxLengt = jdbcTemplate.queryForObject(sql, params,
		// Boolean.class);
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);
	}

}
