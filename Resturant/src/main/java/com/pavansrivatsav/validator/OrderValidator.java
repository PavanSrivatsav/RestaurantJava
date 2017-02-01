package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Order;
import com.pavansrivatsav.util.ValidationUtil;

public class OrderValidator {

	public void orderValidation(Order o) throws ValidationException {

		ValidationUtil.isInvalidObject(o, "Invalid Operation");
	}

	public void idValidator(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void seatValidator(Integer seat) throws ValidationException {
		ValidationUtil.isInvalidNumber(seat, "Invalid Seat no");
	}

	public void statusValidator(String status) throws ValidationException {

		ValidationUtil.isInvalidString(status, "Invalid Status");
	}

	public void validateInsert(Order o) throws ValidationException {

		orderValidation(o);
		idValidator(o.getId());
		seatValidator(o.getSeatObj().getSeatNo());
		statusValidator(o.getStatus());
	}

	public void validateUpdate(Order o) throws ValidationException {

		orderValidation(o);
		seatValidator(o.getSeatObj().getSeatNo());
		statusValidator(o.getStatus());
	}

	public void validateDelete(Order o) throws ValidationException {

		orderValidation(o);
		seatValidator(o.getId());
	}

}
