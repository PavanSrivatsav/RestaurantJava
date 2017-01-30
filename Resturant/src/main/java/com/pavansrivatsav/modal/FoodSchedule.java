package com.pavansrivatsav.modal;

import java.time.LocalTime;

import lombok.Data;

@Data

public class FoodSchedule {

	private Integer id;
	private String foodType;
	private LocalTime startTime;
	private LocalTime endTime; // use local time datatype for time

}
