package com.pavansrivatsav.dao;

import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.FoodSchedule;
import com.pavansrivatsav.service.FoodScheduleService;
import com.pavansrivatsav.validator.FoodScheduleValidator;

public class TestFoodScheduleDAO {

	public static final Logger logger = Logger.getLogger(TestFoodScheduleDAO.class.getName());

	public static void main(String[] args) throws ServiceException, ValidationException {

		FoodSchedule fs = new FoodSchedule(); // diff name
		FoodScheduleDAO fsdao = new FoodScheduleDAO(); // same name

		/* Insert */
		fs.setId(5);
		fs.setFoodType("Midnight");
		fs.setStartTime(LocalTime.parse("23:00:00"));
		fs.setEndTime(LocalTime.parse("04:00:00"));

		fsdao.insert(fs);

		/* Update */

		fs.setStartTime(LocalTime.parse("00:00:00"));
		fs.setEndTime(LocalTime.parse("24:00:00"));
		fs.setId(6);

		fsdao.update(fs);

		/* Delete */

		fsdao.delete(6);

		/* Select */

		List<FoodSchedule> fsclist = fsdao.select();
		for (FoodSchedule i : fsclist) {

			System.out.println(i);
		}

		/* Functions */

		String checkTime = fsdao.breakTime();
		logger.log(Level.INFO, checkTime);

		Boolean isValid = fsdao.validSession();
		logger.log(Level.INFO, "Valid Session: %s", isValid);

		/* Validation */

		FoodScheduleService fss = new FoodScheduleService();
		fs.setId(-1);
		fs.setFoodType("Midnight");
		fs.setStartTime(LocalTime.parse("23:00:00"));
		fs.setEndTime(LocalTime.parse("04:00:00"));
		FoodScheduleValidator valid = new FoodScheduleValidator();

		valid.validateInsert(fs);
		fss.insert(fs);

	}

}
