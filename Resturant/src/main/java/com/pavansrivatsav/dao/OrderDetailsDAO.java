package com.pavansrivatsav.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.modal.Order;
import com.pavansrivatsav.modal.OrderDetails;
import com.pavansrivatsav.util.ConnectionUtil;

public class OrderDetailsDAO {

	public static final Logger logger = Logger.getLogger(OrderDetailsDAO.class.getName());

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void insert(OrderDetails ord) {

		final String sql = "insert into order_details(ID,ORDER_ID,ITEM_ID,QUANTITY,STATUS,TIME_OF_ORDER) values(?,?,?,?,?,?)";
		final Object[] params = { ord.getId(), ord.getOr().getId(), ord.getFi().getId(), ord.getQuantity(),
				ord.getStatus(), ord.getTimeOfOrder() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows inserted : " + rows);

	}

	public void update(OrderDetails ord) {

		final String sql = "update order_details set STATUS=? where ORDER_ID=? AND ITEM_ID=?";
		final Object[] params = { ord.getStatus(), ord.getOr().getId(), ord.getFi().getId() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows updated : " + rows);
	}

	public void delete(Integer ordid) {

		final String sql = "delete from order_details where ORDER_ID=?";
		final int rows = jdbcTemplate.update(sql, ordid);
		logger.log(Level.INFO, "No of rows deleted : " + rows);
	}

	public List<OrderDetails> select() {

		final String sql = "select ID,ITEM_ID,ORDER_ID,QUANTITY,STATUS,TIME_OF_ORDER from order_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final OrderDetails ord = new OrderDetails();
			final FoodItem fi = new FoodItem();
			final Order or = new Order();

			ord.setId(rs.getInt("ID"));

			fi.setId(rs.getInt("ITEM_ID"));
			ord.setFi(fi);

			or.setId(rs.getInt("ORDER_ID"));
			ord.setOr(or);

			ord.setQuantity(rs.getInt("QUANTITY"));
			ord.setStatus(rs.getString("STATUS"));
			ord.setTimeOfOrder(rs.getTimestamp("TIME_OF_ORDER").toLocalDateTime());
			return ord;

		});
	}
	/* Procedures */

	public Map<String, Object> takeOrder(String item, String quantity, int seat) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("TAKE_ORDER").declareParameters(
				new SqlParameter("items", Types.LONGVARCHAR), new SqlParameter("quantity", Types.LONGVARCHAR),
				new SqlParameter("seatNo", Types.INTEGER));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("seatNo", seat).addValue("items", item)
				.addValue("quantity", quantity);
		Map<String, Object> execute = call.execute(in);
		return execute;

	}

	public Map<String, Object> cancelFullOrder(Integer orderId) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("CANCEL_FULL_ORDER")
				.declareParameters(new SqlParameter("orderId", Types.INTEGER));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("orderId", orderId);
		Map<String, Object> execute = call.execute(in);
		return execute;
	}

	public Map<String, Object> cancelOrder(String item, Integer orderNo, Integer quantity) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("CANCEL_ORDER").declareParameters(
				new SqlParameter("itemName", Types.VARCHAR), new SqlParameter("orderNo", Types.INTEGER),
				new SqlParameter("quantity", Types.INTEGER));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("itemName", item).addValue("orderNo", orderNo)
				.addValue("quantity", quantity);
		Map<String, Object> execute = call.execute(in);
		return execute;
	}

}
