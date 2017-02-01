package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pavansrivatsav.modal.Order;
import com.pavansrivatsav.modal.Seat;

public class TestOrderDAO {

	public static final Logger logger = Logger.getLogger(TestOrderDAO.class.getName());

	public static void main(String[] args) {

		Order or = new Order();
		OrderDAO ordao = new OrderDAO();
		Seat st = new Seat();

		/* Insert */

		or.setId(1542);

		st.setSeatNo(10);
		or.setSeatObj(st);

		or.setStatus("REQUESTED");

		ordao.insert(or);

		/* Update */

		st.setSeatNo(10);
		or.setSeatObj(st);

		or.setStatus("SERVED");

		ordao.update(or);

		/* Delete */

		ordao.delete(1542);

		/* Select */

		List<Order> list = ordao.select();

		for (Order i : list) {

			System.out.println(i.getId() + "\t" + i.getSeatObj().getSeatNo() + "\t" + i.getStatus());
		}

		/* Functions */

		Boolean entryFn = ordao.invalidEntry("a,b,c", "1,2,3");
		logger.log(Level.INFO, "Valid Entry : " + entryFn);

		Boolean maxLength = ordao.maxLength("a,b,c,d,e,f", "1,2,3,4,");
		logger.log(Level.INFO, "Max Length : " + !maxLength);
	}

}
