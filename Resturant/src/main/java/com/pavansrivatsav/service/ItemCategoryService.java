package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.ItemCategoryDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.ItemCategory;
import com.pavansrivatsav.validator.ItemCategoryValidator;

public class ItemCategoryService {

	private ItemCategoryValidator itcValidator = new ItemCategoryValidator();

	public void insert(ItemCategory itc) throws ServiceException {

		ItemCategoryDAO itcdao = new ItemCategoryDAO();
		try {
			itcValidator.validateInsert(itc);

			itcdao.insert(itc);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not insert into itemCategory");
		}

	}

	public void update(ItemCategory itc) throws ServiceException {

		ItemCategoryDAO itcdao = new ItemCategoryDAO();
		try {
			itcValidator.validateUpdate(itc);

			itcdao.update(itc);
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not update itemCategory");
		}

	}

	public void delete(ItemCategory itc) throws ServiceException {

		ItemCategoryDAO itcdao = new ItemCategoryDAO();
		try {
			itcValidator.validateDelete(itc);

			itcdao.delete(itc.getId());
		} catch (ValidationException e) {
			// e.printStackTrace();
			throw new ServiceException("Could not delete itemCategory");
		}

	}
}
