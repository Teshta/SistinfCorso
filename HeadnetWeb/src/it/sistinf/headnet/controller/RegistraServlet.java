package it.sistinf.headnet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.vo.UserVO;
@WebServlet("/registra")
public class RegistraServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("CHIAMATO METODO DOGET");

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");	
		String password = request.getParameter("password");
		Date dataDiNascita = new SimpleDateFormat().parse(request.getParameter("dataDiNascita"));

		System.err.println( nome + " " + cognome + " " + email + " " + password + " " + dataDiNascita);

		UserVO user = new UserVO();
		user.setNome(nome);
		user.setCognome(cognome);
		user.setEmail(email);
	    user.setPassword(password);
		user.setDataDiNascita(dataDiNascita);
		
		request.setAttribute("INSERENDO", user);
		

		if (nome == null || nome.isEmpty()) {
			request.setAttribute("SBAGLIATO", "Non hai ancora inserito un nome");
		}
		else if(cognome== null || cognome.isEmpty()) {
			request.setAttribute("SBAGLIATO", "Non hai ancora inserito un cognome");
		}
		else if(email== null || email.isEmpty()) {
			request.setAttribute("SBAGLIATO", "Non hai ancora inserito una email valida");
		}
		else if(password== null || password.isEmpty()) {
			request.setAttribute("SBAGLIATO", "Non hai ancora inserito una password");
		}
		else if(dataDiNascita == null ) {
			request.setAttribute("SBAGLIATO", "Non hai ancora inserito la tua data di nascita");
		}
		else {

			HeadnetFacade facade = new HeadnetFacadeImpl();
			try {
				facade.insertDipendente(dip);
				request.setAttribute("CORRETTO", "L'inserimento è andato a buon fine");
			}
			catch(SQLException e) {
				request.setAttribute("SBAGLIATO", "L'inserimento non è andato a buon fine");
			}
		}

		request.getRequestDispatcher("/jsp/insert.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("CHIAMATO METODO DOPOST");
		doGet(request, response);
	 }
}


