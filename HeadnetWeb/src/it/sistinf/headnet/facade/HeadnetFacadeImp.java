package it.sistinf.headnet.facade;


import it.sistinf.headnet.avo.UserVO;
import it.sistinf.headnet.dao.GestioneDriver;
import it.sistinf.headnet.dao.HeadnetDao;

public class HeadnetFacadeImp implements HeadnetFacade {

	@Override
	public UserVO cercaUtente(String email) {
		
		new GestioneDriver().registraDriver();
		UserVO trovato = null;
		HeadnetDao dao = new HeadnetDao();
		trovato = dao.cercaDipendenteVO(email);
		
		return trovato;
	}

}
