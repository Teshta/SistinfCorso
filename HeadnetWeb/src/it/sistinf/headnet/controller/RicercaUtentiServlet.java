package it.sistinf.headnet.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sistinf.headnet.vo.UserVO;
import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.facade.HeadnetFacadeImpl;


@WebServlet("/search")
public class RicercaUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("CHIAMATO METODO DOGET");

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		//mancano i controlli
		HeadnetFacade facade = new HeadnetFacadeImpl();

		List<UserVO> utenti = new LinkedList<UserVO>();
		utenti = facade.cercaUtenti(nome, cognome);

		request.setAttribute("utenti", utenti);


		String pagina = "/jsp/lista.jsp";

		request.getRequestDispatcher(pagina).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("CHIAMATO METODO DOPOST");
		doGet(request, response);
	}

}
