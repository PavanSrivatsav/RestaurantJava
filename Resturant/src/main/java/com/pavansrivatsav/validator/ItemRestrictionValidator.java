package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.ItemRestriction;
import com.pavansrivatsav.util.ValidationUtil;

public class ItemRestrictionValidator {

	ValidationUtil validationUtil = new ValidationUtil();

	public void ItemRestricValidation(ItemRestriction itr) throws ValidationException {

		ValidationUtil.isInvalidObject(itr, "Invalid Object");
	}

	public void IdValidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void ItemCountRestricValidation(Integer count) throws ValidationException {

		ValidationUtil.isInvalidNumber(count, "Invalid Restriction Count");
	}

	public void validateInsert(ItemRestriction itr) throws ValidationException {

		ItemRestricValidation(itr);
		IdValidation(itr.getId());
		ItemCountRestricValidation(itr.getItemCount());
	}

	public void validateUpdate(ItemRestriction itr) throws ValidationException {

		ItemRestricValidation(itr);
		IdValidation(itr.getId());
		ItemCountRestricValidation(itr.getItemCount());
	}

	public void validateDelete(ItemRestriction itr) throws ValidationException {

		ItemRestricValidation(itr);
		IdValidation(itr.getId());
	}

}
