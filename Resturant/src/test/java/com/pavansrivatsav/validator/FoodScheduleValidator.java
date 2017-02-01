package com.pavansrivatsav.validator;

import java.time.LocalTime;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.FoodSchedule;
import com.pavansrivatsav.util.ValidationUtil;

public class FoodScheduleValidator {

	public void FoodScheduleValidation(FoodSchedule sche) throws ValidationException {

		ValidationUtil.isInvalidObject(sche, "Invalid operation");

	}

	public void IdValidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid Id");
	}

	public void foodTypeValidator(String foodType) throws ValidationException {

		ValidationUtil.isInvalidString(foodType, "Invalid Food type");
	}

	public void timeValidator(LocalTime timeStart) throws ValidationException {

		ValidationUtil.isInvalidTime(timeStart, "Invalid Time");
	}

	public void validateInsert(FoodSchedule sche) throws ValidationException {

		FoodScheduleValidation(sche);
		IdValidation(sche.getId());
		foodTypeValidator(sche.getFoodType());
		timeValidator(sche.getStartTime());
		timeValidator(sche.getEndTime());
	}

	public void validateUpdate(FoodSchedule sche) throws ValidationException {

		FoodScheduleValidation(sche);
		timeValidator(sche.getStartTime());
		timeValidator(sche.getEndTime());
		IdValidation(sche.getId());
	}

	public void validateDelete(FoodSchedule sche) throws ValidationException {

		FoodScheduleValidation(sche);
		IdValidation(sche.getId());
	}
}
