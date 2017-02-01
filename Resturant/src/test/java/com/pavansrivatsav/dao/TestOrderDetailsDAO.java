package com.pavansrivatsav.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pavansrivatsav.modal.FoodItem;
import com.pavansrivatsav.modal.Order;
import com.pavansrivatsav.modal.OrderDetails;

public class TestOrderDetailsDAO {

	public static final Logger logger = Logger.getLogger(TestOrderDetailsDAO.class.getName());

	public static void main(String[] args) {
		OrderDetailsDAO ordao = new OrderDetailsDAO();
		OrderDetails ord = new OrderDetails();
		Order or = new Order();
		FoodItem fi = new FoodItem();

		/* Insert */

		ord.setId(1548);

		or.setId(1541);
		ord.setOr(or);

		fi.setId(10);
		ord.setFi(fi);

		ord.setQuantity(10);
		ord.setStatus("ORDERED");
		ord.setTimeOfOrder(LocalDateTime.parse("2017-01-26T08:10:00"));

		ordao.insert(ord);

		/* Update */

		ord.setStatus("TEST");

		or.setId(1541);
		ord.setOr(or);

		fi.setId(10);
		ord.setFi(fi);

		ordao.update(ord);

		/* Delete */

		ordao.delete(1541); // delete normal way for column having foreign

		/* Select */

		List<OrderDetails> ordlist = ordao.select();

		for (OrderDetails i : ordlist) {
			System.out.println(i.getId() + "\t" + i.getOr().getId() + "\t" + i.getFi().getId() + "\t" + i.getQuantity()
					+ "\t" + i.getStatus() + "\t\t"
					+ DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(i.getTimeOfOrder()));
			// dd-MM-yyyy hh:mm:ss a to display date,time and [am or pm] -> (a)
		}

		/* Procedures */ // have to have o/p para compalsary

		Map<String, Object> order = ordao.takeOrder("variety rice,snacks", "10,20", 1);
		logger.log(Level.INFO, "" + order);

		Map<String, Object> cancelFullOrder = ordao.cancelFullOrder(1247);
		logger.log(Level.INFO, "" + cancelFullOrder);

		Map<String, Object> cancelOrder = ordao.cancelOrder("tea", 1249, 1);
		logger.log(Level.INFO, "" + cancelOrder);

	}

}
