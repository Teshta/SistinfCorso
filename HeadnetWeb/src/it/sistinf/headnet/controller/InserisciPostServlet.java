package it.sistinf.headnet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
//		HttpSession sessione=request.getSession();
//		if(sessione.getAttribute("USER") != null)
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		else{
//			String contenuto = request.getParameter("contenuto");
			

//			DipendenteVO dip = new DipendenteVO();
//			dip.setNome(nome);
//			dip.setCognome(cognome);
//			dip.setMatricola(matricola);
//			dip.setCodiceFiscale(codiceFiscale);
//			dip.getIndirizzo().setIndirizzo(indirizzo);
//			dip.getIndirizzo().setComune(comune);
//
//			request.setAttribute("INSERENDO", dip);
//
//			if(nome==null || nome.isEmpty()) {
//				request.setAttribute("MSG_KO", "Devi inserire il nome");
//			} else if(cognome==null || cognome.isEmpty()) {
//				request.setAttribute("MSG_KO", "Devi inserire il cognome");
//			} else if(matricola==null || matricola.isEmpty()) {
//				request.setAttribute("MSG_KO", "Devi inserire il matricola");
//			} else if(codiceFiscale==null || codiceFiscale.isEmpty()) {
//				request.setAttribute("MSG_KO", "Devi inserire il codice fiscale");
//			} else if(indirizzo==null || indirizzo.isEmpty()) {
//				request.setAttribute("MSG_KO", "Devi inserire l'indirizzo");
//			} else if(comune==null || comune.isEmpty()) {
//				request.setAttribute("MSG_KO", "Devi inserire il comune");		
//			} else {
//
//
//				AnagraficaFacade facade = new AnagraficaFacadeImp();			
//
//				try {
//
//					facade.inserisciDipendente(dip);
//					request.setAttribute("MSG_CORRECT", "Inserito correttamente");
//
//				} catch (Exception e) {
//					request.setAttribute("MSG_KO", "Si è verificato un errore applicativo"); // gestisco l'errore con un messaggio
//				}
//
//			}
//
//			request.getRequestDispatcher("/jsp/inserisci.jsp").forward(request, response);
//		}
//		else 
//			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
