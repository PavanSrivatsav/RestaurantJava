package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.util.ValidationUtil;

public class FoodItemValidator {

	FoodItem item = new FoodItem();

	public void itemValidation(FoodItem item) throws ValidationException {

		ValidationUtil.isInvalidObject(item, "Invalid Operation");
	}

	public void idValidator(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void itemValidator(String item) throws ValidationException {

		ValidationUtil.isInvalidString(item, "Invalid Item Entry");
	}

	public void priceValidator(Integer price) throws ValidationException {

		ValidationUtil.isInvalidNumber(price, "Invalid Price Entered");
	}

	public void validateItemPriceFn(String name) throws ValidationException { // function
		ValidationUtil.isInvalidString(name, "Invalid item ");
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
