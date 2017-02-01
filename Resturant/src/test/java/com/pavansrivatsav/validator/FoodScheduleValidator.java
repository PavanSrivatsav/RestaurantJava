package com.pavansrivatsav.validator;

import java.time.LocalTime;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.FoodSchedule;
import com.pavansrivatsav.util.ValidationUtil;

public class FoodScheduleValidator {

	ValidationUtil validationUtil = new ValidationUtil();

	public void FoodScheduleValidation(FoodSchedule sche) throws ValidationException {

		if (sche == null) {

			throw new ValidationException(" Invalid operation ");

		}
	}

	public void IdValidation(Integer id) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(id)) {

			throw new ValidationException("Invalid id");
		}
	}

	public void foodTypeValidator(String foodType) throws ValidationException {

		if (ValidationUtil.isInvalidString(foodType)) {

			throw new ValidationException(" Invalid food type");

		}
	}

	public void timeValidator(LocalTime timeStart) throws ValidationException {

		if (ValidationUtil.isInvalidString(timeStart)) {

			throw new ValidationException("Invalid time");

		}

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
