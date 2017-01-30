/* Class name = Modal Name*/

package com.pavansrivatsav.modal;

import lombok.Data;

@Data // to get getters and setters
public class FoodItem {

	private Integer id; // using Integer instead of int because if value is not
						// given it will insert defalt value ' 0 ' which will
						// violate our primary key.. so use Integer Object
						// Integer
	private String name;
	private Integer price;
}
