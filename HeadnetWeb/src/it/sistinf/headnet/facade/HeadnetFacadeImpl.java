package it.sistinf.headnet.facade;


import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.sistinf.headnet.dao.GestioneDriver;
import it.sistinf.headnet.dao.HeadnetDao;
import it.sistinf.headnet.vo.PostVO;
import it.sistinf.headnet.vo.RichiestaVO;
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
	public List<UserVO> cercaUtenti(String nome, String cognome) {
		new GestioneDriver().registraDriver();
		List<UserVO> utenti = new LinkedList<UserVO>();
		HeadnetDao dao = new HeadnetDao();
		utenti=dao.cercaUtenti(nome, cognome);
		return utenti;
	}

	@Override
	public void inserisciPost(PostVO post) throws Exception {
		new GestioneDriver().registraDriver();
		HeadnetDao dao = new HeadnetDao();
		dao.inserisciPost(post);
		
	}
	

	@Override
	public void mandaRichiesta(RichiestaVO richiesta) throws Exception {
		new GestioneDriver().registraDriver();
		HeadnetDao dao = new HeadnetDao();
		dao.mandaRichiesta(richiesta);
		
	}

	@Override
	public void gestisciAmicizia(String stato, int richiesta) throws Exception {
		new GestioneDriver().registraDriver();
		HeadnetDao dao = new HeadnetDao();
		dao.gestisciAmicizia(stato,richiesta);		
	}
}
