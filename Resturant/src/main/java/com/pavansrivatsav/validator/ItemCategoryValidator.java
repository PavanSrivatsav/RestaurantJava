package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.ItemCategory;
import com.pavansrivatsav.util.ValidationUtil;

public class ItemCategoryValidator {

	public void ItemCatrgoryValidation(ItemCategory itc) throws ValidationException {

		ValidationUtil.isInvalidObject(itc, "Invalid Operation");
	}

	public void IdValidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void foodItemIdValidation(Integer foodItemId) throws ValidationException {

		ValidationUtil.isInvalidNumber(foodItemId, "Invalid FoodItemId");
	}

	public void foodCategoryIdValidation(Integer foodCategoryId) throws ValidationException {

		ValidationUtil.isInvalidNumber(foodCategoryId, "Invalid FoodCategory ID");
	}

	public void quantityValidation(Integer quantity) throws ValidationException {

		ValidationUtil.isInvalidNumber(quantity, "Invalid Quantity");
	}

	public void validateInsert(ItemCategory itc) throws ValidationException {

		ItemCatrgoryValidation(itc);
		IdValidation(itc.getId());
		foodItemIdValidation(itc.getFood().getId());
		foodCategoryIdValidation(itc.getFoodSchedule().getId());
		quantityValidation(itc.getQuantity());
	}

	public void validateUpdate(ItemCategory itc) throws ValidationException {

		ItemCatrgoryValidation(itc);
		IdValidation(itc.getId());
		foodCategoryIdValidation(itc.getFoodSchedule().getId());
	}

	public void validateDelete(ItemCategory itc) throws ValidationException {

		ItemCatrgoryValidation(itc);
		IdValidation(itc.getId());
	}
}
