package it.sistinf.headnet.facade;


import java.sql.SQLException;

import it.sistinf.headnet.dao.GestioneDriver;
import it.sistinf.headnet.dao.HeadnetDao;
import it.sistinf.headnet.vo.PostVO;
import it.sistinf.headnet.vo.UserVO;

public class HeadnetFacadeImpl implements HeadnetFacade {

	@Override
	public UserVO cercaUsername(String username) throws Exception {
		
		new GestioneDriver().registraDriver();
		UserVO trovato = null;
		HeadnetDao dao = new HeadnetDao();
		trovato = dao.cercaUsername(username);
		
		return trovato;
	}

	@Override
	public void registraUser(UserVO user) throws SQLException {
		new GestioneDriver().registraDriver();
		HeadnetDao dao = new HeadnetDao();
		System.err.println(user.getNome());	
		try {
			dao.registraUser(user);		
		}
		catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public UserVO cercaUtente(String nome, String cognome) {
		new GestioneDriver().registraDriver();
		UserVO trovato = new UserVO();
		HeadnetDao dao = new HeadnetDao();
		trovato=dao.cercaUtente(nome, cognome);
		return trovato;
	}

	@Override
	public void inserisciPost(PostVO post) throws Exception {
		new GestioneDriver().registraDriver();
		HeadnetDao dao = new HeadnetDao();
		dao.inserisciPost(post);
		
	}
}
