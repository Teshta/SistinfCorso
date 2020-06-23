package it.sistinf.headnet.facade;

import java.sql.SQLException;

import it.sistinf.headnet.vo.UserVO;

public interface HeadnetFacade {

	UserVO cercaUsername(String username) throws Exception;
	void registraUser(UserVO user) throws SQLException;
	UserVO cercaUtente(String nome, String cognome);

}
