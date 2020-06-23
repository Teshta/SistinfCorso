package it.sistinf.headnet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sistinf.headnet.facade.HeadnetFacade;
import it.sistinf.headnet.facade.HeadnetFacadeImp;
import it.sistinf.headnet.vo.UserVO;



@WebServlet("/registra")
public class RegistraServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");	
		String password = request.getParameter("password");
		Date dataDiNascita = new Date();
		try {
			dataDiNascita = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataDiNascita").toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		UserVO user = new UserVO();
		user.setNome(nome);
		user.setCognome(cognome);
		user.setEmail(email);
	    user.setPassword(password);
	    user.setUsername(username);
		user.setDataDiNascita(dataDiNascita);
		
		request.setAttribute("INSERENDO", user);
		

		if (nome == null || nome.isEmpty()) {
			request.setAttribute("MSG_KO", "Non hai ancora inserito un nome");
		}
		else if(cognome== null || cognome.isEmpty()) {
			request.setAttribute("MSG_KO", "Non hai ancora inserito un cognome");
		}
		else if(email== null || email.isEmpty()) {
			request.setAttribute("MSG_KO", "Non hai ancora inserito una email valida");
		}
		else if(password== null || password.isEmpty()) {
			request.setAttribute("MSG_KO", "Non hai ancora inserito una password");
		}
		else if(username== null || username.isEmpty()) {
			request.setAttribute("MSG_KO", "Non hai ancora inserito uno username");
		}
		else if(dataDiNascita == null ) {
			request.setAttribute("MSG_KO", "Non hai ancora inserito la tua data di nascita");
		}
		else {

			HeadnetFacade facade = new HeadnetFacadeImp();
			try {
				facade.registraUser(user);
				request.setAttribute("MSG_CORRECT", "L'inserimento è andato a buon fine");
			}
			catch(SQLException e) {
				request.setAttribute("MSG_KO", "L'inserimento non è andato a buon fine");
			}
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	 }
}


