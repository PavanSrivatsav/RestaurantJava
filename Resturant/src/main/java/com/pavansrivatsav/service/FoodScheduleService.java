package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.FoodScheduleDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.FoodSchedule;
import com.pavansrivatsav.validator.FoodScheduleValidator;

public class FoodScheduleService {

	private FoodScheduleValidator scheValidator = new FoodScheduleValidator();

	public void insert(FoodSchedule fsche) throws ServiceException {

		FoodScheduleDAO fscdao = new FoodScheduleDAO();
		try {
			scheValidator.validateInsert(fsche);

			fscdao.insert(fsche);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not insert schedule");
		}

	}

	public void update(FoodSchedule fsche) throws ServiceException {

		FoodScheduleDAO fscdao = new FoodScheduleDAO();
		try {
			scheValidator.validateUpdate(fsche);

			fscdao.update(fsche);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not update schedule");
		}

	}

	public void delete(FoodSchedule fsche) throws ServiceException {

		FoodScheduleDAO fscdao = new FoodScheduleDAO();
		try {
			scheValidator.validateDelete(fsche);

			fscdao.delete(fsche.getId());
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not delete schedule");
		}

	}
}
