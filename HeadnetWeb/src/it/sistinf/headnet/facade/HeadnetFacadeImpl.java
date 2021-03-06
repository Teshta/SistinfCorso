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
	
	@Override
    public List<RichiestaVO> cercaRichiesteRicevute(RichiestaVO richiesta) {
        new GestioneDriver().registraDriver();
        List<RichiestaVO> richiesteRicevute = new LinkedList<RichiestaVO>();
        HeadnetDao dao = new HeadnetDao();
        richiesteRicevute=dao.cercaRichiesteRicevute(richiesta);
        return richiesteRicevute;
    }

    
    @Override
    public List<RichiestaVO> cercaRichiesteInviate(RichiestaVO richiesta) {
        new GestioneDriver().registraDriver();
        List<RichiestaVO> richiesteInviate = new LinkedList<RichiestaVO>();
        HeadnetDao dao = new HeadnetDao();
        richiesteInviate=dao.cercaRichiesteInviate(richiesta);
        return richiesteInviate;
    }
    
    @Override
    public List<UserVO> cercaAmici(RichiestaVO richiesta) {
        new GestioneDriver().registraDriver();
        List<UserVO> amici = new LinkedList<UserVO>();
        HeadnetDao dao = new HeadnetDao();
        amici=dao.cercaAmici(richiesta);
        return amici;
    }
    
    @Override
    public List<PostVO> mieiPost(UserVO user) {
        new GestioneDriver().registraDriver();
        List<PostVO> posts = new LinkedList<PostVO>();
        HeadnetDao dao = new HeadnetDao();
        posts=dao.mieiPost(user);
        return posts;
    }
    
    @Override
    public List<PostVO> postHome(UserVO user){
        new GestioneDriver().registraDriver();
        List<PostVO> posts = new LinkedList<PostVO>();
        HeadnetDao dao = new HeadnetDao();
        posts=dao.postHome(user);
        return posts;
        
    }
    
    @Override
    public int contaLike(PostVO post) throws Exception {
        new GestioneDriver().registraDriver();
        HeadnetDao dao = new HeadnetDao();
        int c = dao.contaLike(post);
        return c;
    }

    @Override
    public void mettiLike(UserVO user, PostVO post) throws Exception {
        new GestioneDriver().registraDriver();
        HeadnetDao dao = new HeadnetDao();
        dao.mettiLike(user, post);
        
    }

	@Override
	public boolean controllaAmicizie(RichiestaVO richiesta) {
		new GestioneDriver().registraDriver();
        HeadnetDao dao = new HeadnetDao();
        boolean trovato = dao.controllaAmicizie(richiesta);
		return trovato;
	}

	@Override
	public boolean controllaRichiesteInviate(RichiestaVO richiesta) {
		new GestioneDriver().registraDriver();
        HeadnetDao dao = new HeadnetDao();
        boolean trovato = dao.controllaRichiesteInviate(richiesta);
		return trovato;
	}

	@Override
	public boolean controllaRichiesteRicevute(RichiestaVO richiesta) {
		new GestioneDriver().registraDriver();
        HeadnetDao dao = new HeadnetDao();
        boolean trovato = dao.controllaRichiesteRicevute(richiesta);
		return trovato;
	}



}
