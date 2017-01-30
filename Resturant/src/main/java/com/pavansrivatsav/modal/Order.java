package com.pavansrivatsav.modal;

import lombok.Data;

@Data
public class Order {

	private Integer id;
	private Seat seatObj;
	private String status;

}
