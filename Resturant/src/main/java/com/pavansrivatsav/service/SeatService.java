package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.SeatDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Seat;
import com.pavansrivatsav.validator.SeatValidator;

public class SeatService {
	SeatValidator seatValidator = new SeatValidator();

	public void insert(Seat s) throws ServiceException {
		SeatDAO sdao = new SeatDAO();
		try {
			seatValidator.insert(s);

			sdao.insert(s);
		} catch (ValidationException e) {
			throw new ServiceException("could not insert", e);
		}
	}

	public void update(Seat s) throws ServiceException {
		SeatDAO sdao = new SeatDAO();
		try {
			seatValidator.update(s);

			sdao.update(s);
		} catch (ValidationException e) {
			throw new ServiceException("could not update", e);
		}
	}

	public void delete(Seat s) throws ServiceException {
		SeatDAO sdao = new SeatDAO();
		try {
			seatValidator.delete(s);

			sdao.delete(s.getId());
		} catch (ValidationException e) {
			throw new ServiceException("could not delete", e);
		}
	}
}
