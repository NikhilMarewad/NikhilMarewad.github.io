package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<>();
			menuItemList.add(new MenuItem(1, "Sandwitch", 99.0f, true, DateUtil.convertToDate("15/03/2017"),
					"MainCourse", true));
			menuItemList.add(
					new MenuItem(2, "Burger", 129.0f, true, DateUtil.convertToDate("23/12/2017"), "MainCourse", false));
			menuItemList.add(
					new MenuItem(3, "Pizza", 149.0f, true, DateUtil.convertToDate("21/12/2018"), "MainCourse", false));
			menuItemList.add(
					new MenuItem(4, "French Fries", 57.0f, false, DateUtil.convertToDate("02/07/2017"), "Starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Browine", 32.0f, true, DateUtil.convertToDate("02/11/2017"),
					"Dessert", true));
		}

	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerItem = new ArrayList<MenuItem>();
		Date d = new Date();

		for (MenuItem x : menuItemList) {
			if (x.isActive() && x.getDatOfLaunch().before(d)) {
				customerItem.add(x);

			}
		}
		return customerItem;
	}

	@Override
	public void ModifyItem(MenuItem menuItem) {
		MenuItem x = getMenuItem(menuItem.getId());
		x.setName(menuItem.getName());
		x.setActive(menuItem.isActive());
		x.setDatOfLaunch(menuItem.getDatOfLaunch());
		x.setCategory(menuItem.getCategory());
		x.setFreeDelivery(menuItem.isFreeDelivery());
	}

	@Override
	public MenuItem getMenuItem(long menuId) {
		MenuItem menuItem = null;
		for (MenuItem n : menuItemList)
			if (n.getId() == menuId) {
				menuItem = n;
				break;
			}
		return menuItem;
	}

}
