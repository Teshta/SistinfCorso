package it.sistinf.headnet.facade;

import java.sql.SQLException;
import java.util.List;

import it.sistinf.headnet.vo.PostVO;
import it.sistinf.headnet.vo.UserVO;

public interface HeadnetFacade {

	UserVO cercaUsername(String username) throws Exception;
	void registraUser(UserVO user) throws SQLException;
	List<UserVO> cercaUtenti(String nome, String cognome);
	void inserisciPost(PostVO post) throws Exception;

}
