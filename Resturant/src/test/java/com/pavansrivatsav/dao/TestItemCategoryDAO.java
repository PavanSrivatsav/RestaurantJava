package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.modal.FoodSchedule;
import com.pavansrivatsav.modal.ItemCategory;
import com.pavansrivatsav.service.ItemCategoryService;

public class TestItemCategoryDAO {

	public static final Logger logger = Logger.getLogger(TestItemCategoryDAO.class.getName());

	public static void main(String[] args) throws ServiceException {

		ItemCategory ict = new ItemCategory();
		ItemCategoryDAO ictdao = new ItemCategoryDAO();
		FoodItem food = new FoodItem();
		FoodSchedule foodsche = new FoodSchedule();

		/* insert */

		ict.setId(17);

		food.setId(15); // food_items
		ict.setFood(food);

		foodsche.setId(4); // food_schedule

		ict.setFoodSchedule(foodsche);

		ict.setQuantity(300);

		ictdao.insert(ict);

		/* update */

		ict.setId(17);
		foodsche.setId(3);
		ict.setFoodSchedule(foodsche);

		ictdao.update(ict);

		/* delete */

		ict.setId(17);
		ictdao.delete(17);

		/* select */

		List<ItemCategory> itclist = ictdao.select();
		for (ItemCategory i : itclist) {
			System.out.println(i.getId() + "\t" + i.getFood().getId() + "\t" + i.getFoodSchedule().getId() + "\t"
					+ i.getQuantity());
		}

		/* Functions */

		Boolean quantityFnTest = ictdao.quantityAvil("idly", 1);
		logger.log(Level.INFO, "Quantity Available : " + quantityFnTest);

		/* Validator */

		ItemCategoryService ics = new ItemCategoryService();

		ict.setId(0);

		food.setId(1); // food_items
		ict.setFood(food);

		foodsche.setId(4); // food_schedule

		ict.setFoodSchedule(foodsche);

		ict.setQuantity(300);

		// ItemCategoryValidator valid = new ItemCategoryValidator();
		// valid.validateInsert(ict);

		ics.insert(ict);

	}

}
