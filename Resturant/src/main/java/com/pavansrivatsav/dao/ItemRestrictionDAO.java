package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.ItemRestriction;
import com.pavansrivatsav.util.ConnectionUtil;

public class ItemRestrictionDAO {

	public static final Logger logger = Logger.getLogger(ItemRestrictionDAO.class.getName());

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void insert(final ItemRestriction ir) {

		final String sql = "insert into items_restriction (ID,ITEM_COUNT) values (?,?)";
		final Object[] params = { ir.getId(), ir.getItemCount() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows inserted : " + rows);

	}

	public void update(final ItemRestriction ir) {

		final String sql = "update items_restriction set ITEM_COUNT=? where id=?";
		final Object[] params = { ir.getItemCount(), ir.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows update = " + rows);

	}

	public void delete(final int id) {

		final String sql = "delete from items_restriction where id=?";
		final int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, "No of rows deleted : " + rows);
	}

	List<ItemRestriction> select() {

		final String sql = "select ID,ITEM_COUNT from items_restriction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			ItemRestriction ir = new ItemRestriction();
			ir.setId(rs.getInt("ID"));
			ir.setItemCount(rs.getInt("ITEM_COUNT"));
			return ir;
		});

	}

}
