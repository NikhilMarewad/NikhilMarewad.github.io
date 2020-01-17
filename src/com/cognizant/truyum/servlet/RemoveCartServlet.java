package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet({ "/RemoveCartServlet", "/RemoveCart" })
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RemoveCartServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDao cartDao=new CartDaoSqlImpl();
		long menuItemId= Long.parseLong(request.getParameter("menuItemId"));
		request.setAttribute("alert", "Item removed from the Cart successfully");
		try {
			
		cartDao.removeCartItem(1, menuItemId);
		RequestDispatcher rd=request.getRequestDispatcher("ShowCart");
		rd.forward(request, response);		
		}catch (CartEmptyException e) {
			RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
			rd.forward(request, response);
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
