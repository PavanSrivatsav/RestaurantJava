package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.OrderDetailsDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.OrderDetails;
import com.pavansrivatsav.validator.OrderDetailsValidator;

public class OrderDetailsService {

	OrderDetailsValidator orderDetailsValidator = new OrderDetailsValidator();

	public void insert(OrderDetails od) throws ServiceException {
		OrderDetailsDAO ordao = new OrderDetailsDAO();
		try {
			orderDetailsValidator.insert(od);

			ordao.insert(od);
		} catch (ValidationException e) {
			throw new ServiceException("could not insert", e);
		}
	}

	public void update(OrderDetails od) throws ServiceException {
		OrderDetailsDAO ordao = new OrderDetailsDAO();
		try {
			orderDetailsValidator.update(od);

			ordao.update(od);
		} catch (ValidationException e) {
			throw new ServiceException("could not update", e);
		}
	}

	public void delete(OrderDetails od) throws ServiceException {
		OrderDetailsDAO ordao = new OrderDetailsDAO();
		try {
			orderDetailsValidator.delete(od);

			ordao.delete(od.getId());
		} catch (ValidationException e) {
			throw new ServiceException("could not delete", e);
		}
	}
}
