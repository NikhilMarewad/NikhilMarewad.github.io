package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		try {
			testGetMenuItemListAdmin();
			System.out.print("\n");
			testGetMenuItemListCustomer();
			System.out.print("\n");
			testModifyMenuItem();
			System.out.print("\n");
			testGetMenuItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);

		}
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao MenuitemDao = new MenuItemDaoSqlImpl();
		MenuitemDao.getMenuItemListAdmin();
		List<MenuItem> menuItemList = MenuitemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}		
		
	}
	
	private static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao MenuitemDao1 = new MenuItemDaoSqlImpl();
		MenuitemDao1.getMenuItemListCustomer();
		List<MenuItem> menuItemList1 =MenuitemDao1 .getMenuItemListCustomer();
		for (MenuItem x : menuItemList1) {
			System.out.println(x);
		}
		
	}

	public static void testModifyMenuItem() throws ParseException
	{
		MenuItem menuitem=new MenuItem(1, "French Fries", 100.0f, true, DateUtil.convertToDate("28/07/2017"),"MainCourse", true);
		MenuItemDao MenuitemDao = new MenuItemDaoSqlImpl();
		MenuitemDao.ModifyItem(menuitem);
		
	}
}