package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.FoodItemDAO;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.validator.FoodItemValidator;

public class FoodItemService {

	private FoodItemValidator foodItemValidator = new FoodItemValidator();

	public void insert(FoodItem item) throws ServiceException {

		FoodItemDAO idao = new FoodItemDAO();
		try {
			foodItemValidator.validateInsert(item);

			idao.insert(item);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not insert items");
		}

	}

	public void update(FoodItem item) throws ServiceException {

		FoodItemDAO idao = new FoodItemDAO();
		try {
			foodItemValidator.validateUpdate(item);

			idao.update(item);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not update items");
		}

	}

	public void delete(FoodItem item) throws ServiceException {

		FoodItemDAO idao = new FoodItemDAO();
		try {
			foodItemValidator.validateDelete(item);

			idao.delete(item.getName());
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not delete items");
		}

	}

	public Integer itemPriceFn(String name) throws ServiceException {
		FoodItemDAO fidao = new FoodItemDAO();

		try {
			foodItemValidator.validateItemPriceFn(name);

			// fidao.itemPrice(name);

		} catch (ValidationException e) {
			throw new ServiceException("Could not call function");
		}
		return fidao.itemPrice(name);

	}

}
