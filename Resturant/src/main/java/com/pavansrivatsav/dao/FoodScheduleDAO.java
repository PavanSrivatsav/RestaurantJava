package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavansrivatsav.modal.FoodSchedule;
import com.pavansrivatsav.util.ConnectionUtil;

public class FoodScheduleDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public static final Logger logger = Logger.getLogger(FoodScheduleDAO.class.getName());

	public void insert(final FoodSchedule fsched) {

		final String sql = "insert into food_schedule (ID,FOOD_TYPE,TIME_START,TIME_END) values(?,?,?,?)";
		final Object[] params = { fsched.getId(), fsched.getFoodType(), fsched.getStartTime(), fsched.getEndTime() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows inserted : " + rows);
	}

	public void update(final FoodSchedule fsched) {

		final String sql = "update food_schedule set TIME_START=? , TIME_END=? where ID=?";
		final Object[] params = { fsched.getStartTime(), fsched.getEndTime(), fsched.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No of rows updated :" + rows);
	}

	public void delete(final Integer id) {
		final String sql = "delete from Food_schedule where id=?";
		final int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, "No of rows deleted : " + rows);
	}

	public List<FoodSchedule> select() {

		final String sql = "select ID,FOOD_TYPE,TIME_START,TIME_END from food_schedule";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			FoodSchedule fsc = new FoodSchedule();
			fsc.setId(rs.getInt("ID"));
			fsc.setFoodType(rs.getString("FOOD_TYPE"));
			fsc.setStartTime(rs.getTime("TIME_START").toLocalTime());
			fsc.setEndTime(rs.getTime("TIME_END").toLocalTime());
			return fsc;

		});
	}

	/* Functions */

	public String breakTime() {
		final String sql = "select CHECK_BREAK_TIME()";
		// String checkTime = jdbcTemplate.queryForObject(sql, String.class);
		return jdbcTemplate.queryForObject(sql, String.class);
	}

	public Boolean validSession() {
		final String sql = "select IS_VALID_SESSION()";
		Boolean validSession = jdbcTemplate.queryForObject(sql, Boolean.class);
		return validSession;
	}

}
