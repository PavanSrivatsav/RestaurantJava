package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.service.ItemService;
import com.pavansrivatsav.validator.ItemValidator;

public class TestFoodItemDAO {

	public static final Logger logger = Logger.getLogger(TestFoodItemDAO.class.getName());

	public static void main(String[] args) throws ServiceException {

		FoodItemDAO fidao = new FoodItemDAO();
		FoodItem fiobj = new FoodItem(); // insert : use small object names

		/* Insert */
		//
		// fiobj.setId(15);
		// fiobj.setName("Juice");
		// fiobj.setPrice(40);
		//
		// fidao.insert(fiobj);
		//
		// /* Update */
		//
		// fiobj.setName("Mango Juice");
		// fiobj.setId(15);
		//
		// fidao.update(fiobj);
		//
		// /* Delete */
		//
		// fidao.delete("Mango Juice");
		//
		// /* Select */
		//
		// List<FoodItem> flist = fidao.select();
		// for (FoodItem i : flist) {
		//
		// System.out.println(i);
		// }

		/* Functions */
		//
		// String itemPrice = fidao.itemPrice("idly");
		// logger.log(Level.INFO, "Item Price " + itemPrice);
		//
		// Boolean itemValid = fidao.itemValid("jaf");
		// logger.log(Level.INFO, "Item Valid : " + itemValid);

		/* Validation */

		ItemService service = new ItemService();
		fiobj.setName("Test");
		fiobj.setId(0);
		fiobj.setPrice(1);
		// ItemValidator valid=new ItemValidator();
		// valid.validateInsert(fiobj);
		service.insert(fiobj);

		fidao.insert(fiobj); // getting inserted!!

	}
}
