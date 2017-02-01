package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Seat;
import com.pavansrivatsav.util.ValidationUtil;

public class SeatValidator {

	public void seatValidation(Seat s) throws ValidationException {

		ValidationUtil.isInvalidObject(s, "Invalid Operaton");
	}

	public void idValidator(Integer id) throws ValidationException {
		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void seatNoValidator(Integer seat) throws ValidationException {

		ValidationUtil.isInvalidNumber(seat, "Invalid seat no");
	}

	public void statusValidator(Boolean status) throws ValidationException {

		ValidationUtil.isValidBoolean(status, "Invalid status");
	}

	public void insert(Seat s) throws ValidationException {

		seatValidation(s);
		idValidator(s.getId());
		seatNoValidator(s.getSeatNo());
		statusValidator(s.getStatus());
	}

	public void update(Seat s) throws ValidationException {
		seatValidation(s);
		idValidator(s.getId());
		statusValidator(s.getStatus());

	}

	public void delete(Seat s) throws ValidationException {

		seatValidation(s);
		idValidator(s.getId());
	}

}
