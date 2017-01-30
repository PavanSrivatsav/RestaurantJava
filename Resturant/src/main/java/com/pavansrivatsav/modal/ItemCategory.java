package com.pavansrivatsav.modal;

import lombok.Data;

@Data
public class ItemCategory {

	private Integer id;
	private Integer quantity;
	private FoodItem food;
	private FoodSchedule foodSchedule;

}
