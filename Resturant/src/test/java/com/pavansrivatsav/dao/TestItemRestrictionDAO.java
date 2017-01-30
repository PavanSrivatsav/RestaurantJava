package com.pavansrivatsav.dao;

import java.util.List;

import com.pavansrivatsav.modal.ItemRestriction;

public class TestItemRestrictionDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ItemRestriction ir = new ItemRestriction();
		ItemRestrictionDAO irdao = new ItemRestrictionDAO();

		/* insert */

		ir.setId(2);
		ir.setItemCount(10);

		irdao.insert(ir);

		/* update */

		ir.setId(2);
		ir.setItemCount(8);

		irdao.update(ir);

		/* delete */

		irdao.delete(2);

		/* Select */

		List<ItemRestriction> list = irdao.select();
		for (ItemRestriction i : list) {

			System.out.println(i);
		}

	}

}
