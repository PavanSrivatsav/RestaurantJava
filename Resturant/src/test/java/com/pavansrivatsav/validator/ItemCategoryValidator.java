package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.ItemCategory;
import com.pavansrivatsav.util.ValidationUtil;

public class ItemCategoryValidator {

	ValidationUtil validationUtil = new ValidationUtil();

	public void ItemCatrgoryValidation(ItemCategory itc) throws ValidationException {

		if (itc == null) {

			throw new ValidationException(" Invalid operation ");

		}
	}

	public void IdValidation(Integer id) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(id)) {

			throw new ValidationException("Invalid id");
		}
	}

	public void foodItemIdValidation(Integer foodItemId) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(foodItemId)) {

			throw new ValidationException("Invalid foodItemId");
		}
	}

	public void foodCategoryIdValidation(Integer foodCategoryId) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(foodCategoryId)) {

			throw new ValidationException("Invalid foodCategoryId");
		}
	}

	public void quantityValidation(Integer quantity) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(quantity)) {

			throw new ValidationException("Invalid quantity");
		}
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
