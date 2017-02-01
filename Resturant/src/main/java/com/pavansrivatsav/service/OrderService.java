package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.OrderDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.Order;
import com.pavansrivatsav.validator.OrderValidator;

public class OrderService {

	OrderValidator orderValidator = new OrderValidator();

	public void insert(Order o) throws ServiceException {
		OrderDAO odao = new OrderDAO();
		try {
			orderValidator.validateInsert(o);
			odao.insert(o);
		} catch (ValidationException e) {
			throw new ServiceException("could not insert", e);
		}
	}

	public void update(Order o) throws ServiceException {
		OrderDAO odao = new OrderDAO();
		try {
			orderValidator.validateUpdate(o);
			odao.insert(o);
		} catch (ValidationException e) {
			throw new ServiceException("could not update", e);
		}
	}

	public void delete(Order o) throws ServiceException {
		OrderDAO odao = new OrderDAO();
		try {
			orderValidator.validateDelete(o);
			odao.insert(o);
		} catch (ValidationException e) {
			throw new ServiceException("could not delete", e);
		}
	}

}
