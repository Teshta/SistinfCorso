package it.sistinf.headnet.facade;

import java.sql.SQLException;

import it.sistinf.headnet.vo.UserVO;

public interface HeadnetFacade {

	UserVO cercaUtente(String username) throws Exception;

	void registraUser(UserVO user) throws SQLException;

}
