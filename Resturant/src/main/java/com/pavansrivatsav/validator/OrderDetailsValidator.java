package com.pavansrivatsav.validator;

import java.time.LocalDateTime;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.OrderDetails;
import com.pavansrivatsav.util.ValidationUtil;

public class OrderDetailsValidator {

	public void orderDetailsValid(OrderDetails ord) throws ValidationException {

		ValidationUtil.isInvalidObject(ord, "Invalid Operation");
	}

	public void idValidator(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void orderIdValidator(Integer ordId) throws ValidationException {
		ValidationUtil.isInvalidNumber(ordId, "Invalid order id");
	}

	public void itemValidator(Integer itemId) throws ValidationException {

		ValidationUtil.isInvalidNumber(itemId, "Invalid Item id");
	}

	public void quantityValidator(Integer quantity) throws ValidationException {

		ValidationUtil.isInvalidNumber(quantity, "Invalid quantity entered");
	}

	public void statusValidator(String status) throws ValidationException {
		ValidationUtil.isInvalidString(status, "Invalid Status");
	}

	public void timevalidator(LocalDateTime time) throws ValidationException {
		ValidationUtil.isValidDateTime(time, "Invalid Time Stamp");
	}

	public void insert(OrderDetails o) throws ValidationException {

		orderDetailsValid(o);
		idValidator(o.getId());
		orderIdValidator(o.getOr().getId());
		itemValidator(o.getFi().getId());
		quantityValidator(o.getQuantity());
		statusValidator(o.getStatus());
		timevalidator(o.getTimeOfOrder());
	}

	public void update(OrderDetails o) throws ValidationException {

		orderDetailsValid(o);
		orderIdValidator(o.getOr().getId());
		itemValidator(o.getFi().getId());
		statusValidator(o.getStatus());
	}

	public void delete(OrderDetails o) throws ValidationException {

		orderDetailsValid(o);
		orderIdValidator(o.getOr().getId());

	}
}
