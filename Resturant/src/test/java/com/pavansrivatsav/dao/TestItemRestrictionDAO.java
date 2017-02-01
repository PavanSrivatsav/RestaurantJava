package com.pavansrivatsav.dao;

import java.util.List;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.ItemRestriction;
import com.pavansrivatsav.service.ItemRestrictionService;
import com.pavansrivatsav.validator.ItemRestrictionValidator;

public class TestItemRestrictionDAO {

	public static void main(String[] args) throws ServiceException, ValidationException {

		ItemRestriction ir = new ItemRestriction();
		ItemRestrictionDAO irdao = new ItemRestrictionDAO();

		/* insert */

		ir.setId(2);
		ir.setItemCount(10);

		irdao.insert(ir);

		/* update */

		ir.setId(2);
		ir.setItemCount(8);

		irdao.update(ir);

		/* delete */

		irdao.delete(2);

		/* Select */

		List<ItemRestriction> list = irdao.select();
		for (ItemRestriction i : list) {

			System.out.println(i);
		}

		ir.setId(0);
		ir.setItemCount(0);

		ItemRestrictionService irs = new ItemRestrictionService();
		irs.insert(ir);

		ItemRestrictionValidator irv = new ItemRestrictionValidator();
		irv.validateInsert(ir);
	}

}
