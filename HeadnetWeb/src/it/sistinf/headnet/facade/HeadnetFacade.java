package it.sistinf.headnet.facade;

import java.sql.SQLException;
import java.util.List;

import it.sistinf.headnet.vo.PostVO;
import it.sistinf.headnet.vo.RichiestaVO;
import it.sistinf.headnet.vo.UserVO;

public interface HeadnetFacade {

	UserVO cercaUsername(String username) throws Exception;
	void registraUser(UserVO user) throws SQLException;
	List<UserVO> cercaUtenti(String nome, String cognome);
	void inserisciPost(PostVO post) throws Exception;
	void mandaRichiesta(RichiestaVO richiesta) throws Exception;
	void gestisciAmicizia(String stato, int richiesta) throws Exception;
	List<RichiestaVO> cercaRichiesteRicevute(RichiestaVO richiesta);
    List<RichiestaVO> cercaRichiesteInviate(RichiestaVO richiesta);
	List<UserVO> cercaAmici(RichiestaVO richiesta);
	List<PostVO> mieiPost(UserVO user);
	List<PostVO> postHome(UserVO user);
	void mettiLike(UserVO user, PostVO post) throws Exception;
	int contaLike(PostVO post) throws Exception;
	boolean controllaAmicizie(RichiestaVO richiesta);
	boolean controllaRichiesteInviate(RichiestaVO richiesta);
	boolean controllaRichiesteRicevute(RichiestaVO richiesta);

}
