package com.ltk.addressbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltk.addressbook.dao.AddressDao;
import com.ltk.addressbook.dao.AddressDaoOraclempl;
import com.ltk.addressbook.dao.AddressVo;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/")
public class AddressServlet extends HttpServlet {
	private static String form_jsp_root = "/WEB-INF/view/address/form.jsp";
	private static String index_jsp_root = "/WEB-INF/view/address/index.jsp";
	private static String urlPatterns = "/";

	private static String req_action_parameter = "a";
	private static String action_form_parameter = "form";
	private static String action_delete_parameter = "delete";
	private static String action_search_parameter = "search";

	private static final String TABLE_LIST_NAME = "list";

	private static final String TABLE_ID_NAME = "id";
	private static final String TABLE_NAME_NAME = "name";
	private static final String TABLE_TEL_NAME = "tel";
	private static final String TABLE_HP_NAME = "hp";
	private static final String TABLE_SERACH_NAME = "searchName";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter(req_action_parameter);

		if (action_form_parameter.equals(action)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(form_jsp_root);
			rd.forward(req, resp);
		} else if (action_delete_parameter.equals(action)) {
			Long id = Long.valueOf(req.getParameter(TABLE_ID_NAME));

			AddressDao dao = new AddressDaoOraclempl();
			dao.delete(id);
			resp.sendRedirect(req.getContextPath() + urlPatterns);
		} else if (action_search_parameter.equals(action)) {
			AddressDao dao = new AddressDaoOraclempl();

			List<AddressVo> list = dao.search(req.getParameter(TABLE_SERACH_NAME));
			req.setAttribute(TABLE_SERACH_NAME, req.getParameter(TABLE_SERACH_NAME));
			req.setAttribute(TABLE_LIST_NAME, list);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(index_jsp_root);
			rd.forward(req, resp);
		} else {
			AddressDao dao = new AddressDaoOraclempl();
			List<AddressVo> list = dao.getList();

			req.setAttribute(TABLE_LIST_NAME, list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(index_jsp_root);
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter(TABLE_NAME_NAME);
			String tel = req.getParameter(TABLE_TEL_NAME);
			String hp = req.getParameter(TABLE_HP_NAME);

			AddressVo vo = new AddressVo();
			vo.setName(name);
			vo.setTel(tel);
			vo.setHp(hp);

			AddressDao dao = new AddressDaoOraclempl();

			dao.insert(vo);

			resp.sendRedirect(req.getContextPath() + urlPatterns);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			doGet(req, resp);
		}
	}
}
