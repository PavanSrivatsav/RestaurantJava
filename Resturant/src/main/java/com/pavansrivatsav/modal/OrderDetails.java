package com.pavansrivatsav.modal;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDetails {

	private Integer id;
	private Integer quantity;

	private Order or = new Order();
	private FoodItem fi = new FoodItem();

	private String status;
	private LocalDateTime timeOfOrder;

}
