package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowMenuItemListCustomerServlet
 */
@WebServlet({ "/ShowMenuItemListCustomerServlet", "/ShowMenuItemListCustomer" })
public class ShowMenuItemListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowMenuItemListCustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		MenuItemDaoCollectionImpl MenuitemDao1 = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList1 =MenuitemDao1.getMenuItemListCustomer();
		System.out.println(menuItemList1.size());
		request.setAttribute("menuItemList1",menuItemList1);
		RequestDispatcher rd=request.getRequestDispatcher("menu-item-list-customer.jsp");
		rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}