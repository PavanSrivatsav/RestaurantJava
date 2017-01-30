package com.pavansrivatsav.validator;

import com.pavansrivatsav.dao.FoodItemDAO;
import com.pavansrivatsav.exception.ItemNotFoundException;
import com.pavansrivatsav.modal.FoodItem;

public class ItemValidator {

	public void validateInsertItem(FoodItem item) {
		if ("".equals(item.getName().trim()) || item.getName() != (String) item.getName()) {
			try {

				throw new ItemNotFoundException("Item Not Found");
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
		} else if (item.getId() == null || item.getId() <= 0) { // order in if
																// -> 1st
																// equivalent
																// operator then
																// other
			try {
				throw new ItemNotFoundException("Invalid Id ");
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
		} else if (item.getPrice() == null || item.getPrice() <= 0) {
			try {
				throw new ItemNotFoundException("Invalid Price entered");
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			FoodItemDAO fidao = new FoodItemDAO();
			if (!fidao.itemValid(item.getName())) {
				try {
					throw new ItemNotFoundException("This item is not made in this hotel");
				} catch (ItemNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
