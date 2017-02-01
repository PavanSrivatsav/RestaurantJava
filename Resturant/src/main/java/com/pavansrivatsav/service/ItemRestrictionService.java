package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.ItemRestrictionDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.ItemRestriction;
import com.pavansrivatsav.validator.ItemRestrictionValidator;

public class ItemRestrictionService {

	private ItemRestrictionValidator itrValidator = new ItemRestrictionValidator();

	public void insert(ItemRestriction itr) throws ServiceException {

		ItemRestrictionDAO itrdao = new ItemRestrictionDAO();
		try {
			itrValidator.validateInsert(itr);

			itrdao.insert(itr);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not insert into itemRestriction");
		}

	}

	public void update(ItemRestriction itr) throws ServiceException {

		ItemRestrictionDAO itrdao = new ItemRestrictionDAO();
		try {
			itrValidator.validateUpdate(itr);

			itrdao.update(itr);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not update itemRestriction");
		}

	}

	public void delete(ItemRestriction itr) throws ServiceException {

		ItemRestrictionDAO itrdao = new ItemRestrictionDAO();
		try {
			itrValidator.validateDelete(itr);

			itrdao.delete(itr.getId());
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not delete itemRestriction");
		}

	}

}
