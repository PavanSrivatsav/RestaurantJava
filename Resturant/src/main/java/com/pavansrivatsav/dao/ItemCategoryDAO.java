package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.modal.FoodSchedule;
import com.pavansrivatsav.modal.ItemCategory;
import com.pavansrivatsav.util.ConnectionUtil;

public class ItemCategoryDAO {

	public static final Logger logger = Logger.getLogger(ItemCategoryDAO.class.getName());

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void insert(final ItemCategory icat) {

		final String sql = "insert into items_category(ID,FOOD_ITEM_ID,FOOD_CATEGORY_ID,QUANTITY) values(?,?,?,?)";
		final Object[] params = { icat.getId(), icat.getFood().getId(), icat.getFoodSchedule().getId(),
				icat.getQuantity() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows inserted : " + rows);

	}

	public void update(final ItemCategory ic) {

		final String sql = "update items_category set FOOD_CATEGORY_ID = ? where ID=?";
		final Object[] params = { ic.getFoodSchedule().getId(), ic.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows updated :" + rows);
	}

	public void delete(final int id) {

		final String sql = "delete from items_category where ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, "No of rows deleted : " + rows);

	}

	public List<ItemCategory> select() {

		final String sql = "select ID,FOOD_ITEM_ID,FOOD_CATEGORY_ID,QUANTITY from items_category";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final ItemCategory itmcc = new ItemCategory();
			final FoodItem fi = new FoodItem();
			final FoodSchedule fsc = new FoodSchedule();

			itmcc.setId(rs.getInt("ID"));

			fi.setId(rs.getInt("FOOD_ITEM_ID"));
			itmcc.setFood(fi);

			fsc.setId(rs.getInt("FOOD_CATEGORY_ID"));
			itmcc.setFoodSchedule(fsc);

			itmcc.setQuantity(rs.getInt("QUANTITY"));

			return itmcc;

		});

	}

	public Boolean quantityAvil(String item, Integer quantity) {

		String sql = "SELECT CHECK_QUANTITY_AVILABILITY(?,?)";
		Object[] params = { item, quantity };
		// Boolean quantityFn = jdbcTemplate.queryForObject(sql, params,
		// Boolean.class);
		return jdbcTemplate.queryForObject(sql, params, Boolean.class);

	}

}
