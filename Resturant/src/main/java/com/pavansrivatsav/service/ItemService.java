package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.FoodItemDAO;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.validator.ItemValidator;

public class ItemService {

	private ItemValidator itemValidator = new ItemValidator();

	public void insert(FoodItem item) throws ServiceException {

		FoodItemDAO idao = new FoodItemDAO();
		try {
			itemValidator.validateInsert(item);

			idao.insert(item);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not insert items");
		}

	}

	public void update(FoodItem item) throws ServiceException {

		FoodItemDAO idao = new FoodItemDAO();
		try {
			itemValidator.validateUpdate(item);

			idao.update(item);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not update items");
		}

	}

	public void delete(FoodItem item) throws ServiceException {

		FoodItemDAO idao = new FoodItemDAO();
		try {
			itemValidator.validateDelete(item);

			idao.delete(item.getName());
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not delete items");
		}

	}
}
