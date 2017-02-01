package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.ItemRestriction;
import com.pavansrivatsav.util.ValidationUtil;

public class ItemRestrictionValidator {

	ValidationUtil validationUtil = new ValidationUtil();

	public void ItemRestricValidation(ItemRestriction itr) throws ValidationException {

		if (itr == null) {

			throw new ValidationException(" Invalid operation ");

		}
	}

	public void IdValidation(Integer id) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(id)) {

			throw new ValidationException("Invalid id");
		}
	}

	public void ItemCountRestricValidation(Integer itcr) throws ValidationException {

		if (ValidationUtil.isInvalidNumber(itcr)) {

			throw new ValidationException("Invalid restriction count");
		}
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
