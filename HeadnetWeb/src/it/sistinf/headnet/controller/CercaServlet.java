package it.sistinf.headnet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sistinf.headnet.vo.UserVO;
import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.facade.HeadnetFacadeImpl;
import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.facade.HeadnetFacadeImpl;


@WebServlet("/search")
public class CercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("CHIAMATO METODO DOGET");
		//response.getWriter().append("Servito alla url: ").append(request.getContextPath()).append(" parametro" + request.getParameter("matricola"));
		//request.getRequestDispatcher("/jsp/cerca.jsp").forward(request, response);

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		//String update = request.getParameter("up");
		//String delete = request.getParameter("delete");
		HeadnetFacade facade = new HeadnetFacadeImpl();

		UserVO trovato = new UserVO();
		trovato = facade.cercaUtente(nome, cognome);

		request.setAttribute("TROVATO", trovato);


		String pagina = "/jsp/cerca.jsp";

		/*if(update!= null &&("t").equals(update.trim())) {
			pagina="/jsp/modifica.jsp";
		}
		else if(delete!= null && ("t").equals(delete.trim())) {
			try {
				facade.deleteDipendente(matricola);
				request.setAttribute("CORRETTO", "Il dipendente è stato eliminato.");
		} catch (SQLException e) {
				request.setAttribute("SBAGLIATO", "L'operazione è stata annullata.");
			e.printStackTrace();
			}
			pagina = "/dipendenti";
		}
		System.err.println(update);
		System.err.println(delete);
		*/
		request.getRequestDispatcher(pagina).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("CHIAMATO METODO DOPOST");
		doGet(request, response);
	}

}
