package it.sistinf.headnet.facade;


import java.sql.SQLException;

import it.sistinf.headnet.avo.UserVO;
import it.sistinf.headnet.dao.GestioneDriver;
import it.sistinf.headnet.dao.HeadnetDao;

public class HeadnetFacadeImp implements HeadnetFacade {

	@Override
	public UserVO cercaUtente(String username) {
		
		new GestioneDriver().registraDriver();
		UserVO trovato = null;
		HeadnetDao dao = new HeadnetDao();
		trovato = dao.cercaDipendenteVO(username);
		
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
}
