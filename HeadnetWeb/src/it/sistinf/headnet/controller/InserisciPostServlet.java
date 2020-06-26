package it.sistinf.headnet.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.facade.HeadnetFacadeImpl;
import it.sistinf.headnet.vo.PostVO;
import it.sistinf.headnet.vo.UserVO;


@WebServlet("/insert")
public class InserisciPostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//non funziona
		HttpSession sessione=request.getSession(false);
		if(sessione.getAttribute("USER") == null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else{
			String contenuto = request.getParameter("contenuto");

			boolean inserito = false;
			PostVO post = new PostVO();
			UserVO user = new UserVO();
			
			post.setContenuto(contenuto);
//			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
//			Date today = calendar.getTime();
//			post.setDataPubblicazione(today);
			user = (UserVO)sessione.getAttribute("USER"); 
			post.setUser(user);

			request.setAttribute("INSERENDO", post);

			if(contenuto==null || contenuto.isEmpty()) {
				request.setAttribute("MSG_KO", "Devi inserire il contenuto");
			} else {
				HeadnetFacade facade = new HeadnetFacadeImpl();
				try {

					facade.inserisciPost(post);
					request.setAttribute("MSG_CORRECT", "Inserito correttamente");
					inserito = true;

				} catch (Exception e) {
					request.setAttribute("MSG_KO", "Si è verificato un errore applicativo"); // gestisco l'errore con un messaggio

				}

			}
			if (inserito)
				request.getRequestDispatcher("/homepost").forward(request, response);
			else
				request.getRequestDispatcher("/jsp/inserisciPost.jsp").forward(request, response);	
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
