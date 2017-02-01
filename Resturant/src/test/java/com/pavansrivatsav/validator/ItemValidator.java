package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.util.ValidationUtil;

public class ItemValidator {

	FoodItem item = new FoodItem();

	public void itemValidation(FoodItem item) throws ValidationException {

		if (item == null) {

			throw new ValidationException(" Invalid operation ");

		}
	}

	public void idValidator(Integer id) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(id)) {

			throw new ValidationException(" Invalid Id ");

		}
	}

	public void itemValidator(String item) throws ValidationException {

		if (ValidationUtil.isInvalidString(item)) {

			throw new ValidationException(" Invalid Item Entry");

		}
	}

	public void priceValidator(Integer price) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(price)) {

			throw new ValidationException("Invalid Price entered");

		}

	}

	public void validateInsert(FoodItem item) throws ValidationException {

		itemValidation(item);
		idValidator(item.getId());
		itemValidator(item.getName());
		priceValidator(item.getPrice());
	}

	public void validateUpdate(FoodItem item) throws ValidationException {

		itemValidation(item);
		idValidator(item.getId());
		itemValidator(item.getName());

	}

	public void validateDelete(FoodItem item) throws ValidationException {

		itemValidation(item);
		itemValidator(item.getName());
	}

}
