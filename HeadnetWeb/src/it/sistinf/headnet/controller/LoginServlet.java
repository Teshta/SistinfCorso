package it.sistinf.headnet.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.sistinf.headnet.avo.UserVO;
import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.facade.HeadnetFacadeImp;

/**
 * Servlet implementation class CercaServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		HttpSession sessione=request.getSession();
		if(sessione.getAttribute("USER") != null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else{
			boolean successo = false;
			UserVO user = new UserVO();
			String username = request.getParameter("username");
			String password = request.getParameter("password"); //non criptata
			HeadnetFacade facade = new HeadnetFacadeImp();		

			try {
				user = facade.cercaUtente(username);
				if(password.equals(user.getPassword())){
					sessione.setAttribute("USER", user);
					request.setAttribute("MSG_CORRECT", "Login effettuato con successo");
					successo = true;
				}
				else 
					request.setAttribute("MSG_KO", "Email o Password errate");
				//gestione errori
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("MSG_KO", "Si è verificato un errore applicativo");
			}

			if (successo)
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else 
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
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
