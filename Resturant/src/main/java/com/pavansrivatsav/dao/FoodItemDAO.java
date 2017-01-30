/* Here involves the operations on DB as insert , select ,update , etc. */

package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.util.ConnectionUtil;

public class FoodItemDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public static final Logger logger = Logger.getLogger(FoodItemDAO.class.getName());

	public void insert(final FoodItem fitem) {
		final String sql = "insert into food_items(ID,ITEM,PRICE) values(?,?,?)";
		final Object[] params = { fitem.getId(), fitem.getName(), fitem.getPrice() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.SEVERE, "No of rows inserted " + rows);
	}

	public void update(final FoodItem fitem) {

		final String sql = "update food_items set ITEM=? where id=? ";
		final Object[] params = { fitem.getName(), fitem.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows update " + rows);
	}

	public void delete(final String name) {

		final String sql = "delete from food_items where ITEM=?";
		final int rows = jdbcTemplate.update(sql, name);
		logger.log(Level.INFO, "No of rows deleted : " + rows);
	}

	public List<FoodItem> select() {

		final String sql = "select ID,ITEM,PRICE from food_items";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			FoodItem fi = new FoodItem();
			fi.setId(rs.getInt("ID"));
			fi.setName(rs.getString("ITEM"));
			fi.setPrice(rs.getInt("PRICE"));
			return fi;
		});

	}

	/* Functions */

	public String itemPrice(String itemName) {
		final String sql = "SELECT CHECK_PRICE_ITEM(?)";
		Object[] params = { itemName };
		// String item = jdbcTemplate.queryForObject(sql, params, String.class);
		return jdbcTemplate.queryForObject(sql, params, String.class);
	}

	public Boolean itemValid(String item) {

		String sql = "select ITEM_VALIDATION(?)";
		Object[] params = { item };
		// Boolean itemValid = jdbcTemplate.queryForObject(sql, params,
		// Boolean.class);
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);
	}

}
