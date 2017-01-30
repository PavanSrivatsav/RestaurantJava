package com.pavansrivatsav.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pavansrivatsav.modal.Seat;

public class TestSeatDAO {

	public static final Logger logger = Logger.getLogger(TestSeatDAO.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Seat st = new Seat();
		SeatDAO stdao = new SeatDAO();

		/* Insert */

		st.setId(11);
		st.setSeatNo(11);
		st.setStatus(0);

		stdao.insert(st);

		/* Update */

		st.setId(10);
		st.setStatus(1);

		stdao.update(st);

		/* Delete */

		stdao.delete(11);

		/* Select */

		List<Seat> stl = stdao.select();
		for (Seat i : stl) {

			System.out.println(i);
		}

		/* Functions */

		Boolean seatAvail = stdao.seatAvil(1);
		logger.log(Level.INFO, "Seat Available : " + seatAvail);

	}

}
