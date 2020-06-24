package it.sistinf.headnet.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.sistinf.headnet.vo.PostVO;
import it.sistinf.headnet.vo.RichiestaVO;
import it.sistinf.headnet.vo.UserVO;

public class HeadnetDao extends GestioneConnessione {

	public UserVO cercaUsername(String username) throws Exception {
		UserVO user = new UserVO();

		try {

			connection = this.apriConnessione();

			String queryStr = "SELECT * FROM USER U WHERE U.USERNAME = ?";
			preparedStatement = connection.prepareStatement(queryStr);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();


			while(resultSet.next()) { //resultSet il cursore punta prima della prima riga, quindi necessario il next
				user.setId(resultSet.getInt("user_id"));
				user.setNome(resultSet.getString("nome"));
				user.setCognome(resultSet.getString("cognome"));
				user.setUsername(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setDataDiNascita(resultSet.getDate("dataDiNascita"));
				
			}		

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			chiudiConnessione();
		}
		return user;
	}
	

	public void registraUser(UserVO user) throws SQLException {
		
		try {

			connection = this.apriConnessione();
			preparedStatement = connection.prepareStatement("INSERT INTO HEADNET.USER (USERNAME, NOME, COGNOME, EMAIL, PASSWORD, DATADINASCITA) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getNome());
			preparedStatement.setString(3, user.getCognome());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setDate(6, new java.sql.Date(user.getDataDiNascita().getTime()));
			
			preparedStatement.executeUpdate();

		}
		catch(SQLException e) {
			throw e;
		} finally {
			chiudiConnessione();
		}
	}
	
	
	public List<UserVO> cercaUtenti(String nome, String cognome) {

		List<UserVO> users = new LinkedList<UserVO>();

		try {
			connection = this.apriConnessione();
			String queryStr = "SELECT * FROM USER WHERE user.nome LIKE ? AND user.cognome LIKE ?";
			preparedStatement = connection.prepareStatement(queryStr);
			preparedStatement.setString(1, "%"+nome+"%");
			preparedStatement.setString(2, "%"+cognome+"%");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				UserVO user = new UserVO();
				user.setId(resultSet.getInt("user_id"));
				user.setNome(resultSet.getString("nome"));
				user.setCognome(resultSet.getString("cognome"));
				user.setEmail(resultSet.getString("email"));
				user.setDataDiNascita(resultSet.getDate("dataDiNascita"));
				user.setUsername(resultSet.getString("username"));
				users.add(user);
			}	
			
			if(users.size() == 0) {
				users = null;
			}
		}

		catch(SQLException e) {
			e.printStackTrace();
		} finally {
			chiudiConnessione();
		}
		return users;	
	
	}	



//	public List<UserVO> findAll() {
//		List<UserVO> listauser = new LinkedList<UserVO>(); 
//
//		try {
//			connection = this.apriConnessione();
//			statement = connection.createStatement();
//			String queryStr = "SELECT * FROM USER";
//			resultSet = statement.executeQuery(queryStr);
//
//			while(resultSet.next()) {
//				UserVO user = new UserVO();
//				user.setNome(resultSet.getString("nome"));
//				user.setEmail(resultSet.getString("email"));
//				user.setDataDiNascita(resultSet.getDate("dataDiNascita"));
//				user.setUsername(resultSet.getString("username"));
//				listauser.add(user);
//			}
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//		} finally {
//			chiudiConnessione();
//		}
//		return listauser;
//	}


	public void inserisciPost(PostVO post) throws Exception {
		try {

			connection = this.apriConnessione();
			preparedStatement = connection.prepareStatement("INSERT INTO POST (contenuto, dataPubblicazione, user_id) VALUES (?, ?, ?)");
			preparedStatement.setString(1, post.getContenuto());
			preparedStatement.setDate(2, new java.sql.Date(post.getDataPubblicazione().getTime()));
			preparedStatement.setInt(3, post.getUser().getId());
			
			preparedStatement.executeUpdate();

		}
		catch(SQLException e) {
			throw e;
		} finally {
			chiudiConnessione();
		}
		
	} 
	
	public void mandaRichiesta(RichiestaVO richiesta) throws Exception {
		try {
			connection = this.apriConnessione();
			preparedStatement = connection.prepareStatement("INSERT INTO richiesta_amicizia ( user_richiedente, user_ricevente, stato) VALUES (?, ?, ?)");
			preparedStatement.setInt(1, richiesta.getRichiedente().getId());
			preparedStatement.setInt(2, richiesta.getRicevente().getId());
			preparedStatement.setString(3, richiesta.getStato());
			
			preparedStatement.executeUpdate();

		}
		catch(SQLException e) {
			throw e;
		} finally {
			chiudiConnessione();
		}
		
	}
	/* gestisce le amicizie aggiornando lo stato ad accettata o rifiutata */
	public void gestisciAmicizia(String stato, int richiesta) throws Exception {
		try {

			connection = this.apriConnessione();
			preparedStatement = connection.prepareStatement("UPDATE RICHIESTA_AMICIZIA SET STATO = ? WHERE RICHIESTA_ID = ? ");
			preparedStatement.setString(1, stato);
			preparedStatement.setInt(2, richiesta);
			
			preparedStatement.executeUpdate();

		}
		catch(SQLException e) {
			throw e;
		} finally {
			chiudiConnessione();
		}
		
	}
	
	public List<RichiestaVO> cercaRichiesteRicevute(RichiestaVO richiesta) {

        List<RichiestaVO> richiesteRicevute = new LinkedList<RichiestaVO>();

        try {
            connection = this.apriConnessione();
            String queryStr = "SELECT u.user_id , u.username, u.nome, u.cognome, r.richiesta_id FROM user as u JOIN richiesta_amicizia as r ON r.user_richiedente = u.user_id WHERE r.stato = 's' AND r.user_ricevente = ?";
            preparedStatement = connection.prepareStatement(queryStr);
            preparedStatement.setInt(1, richiesta.getRicevente().getId() );
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                RichiestaVO richRic = new RichiestaVO();
                UserVO richiedente = new UserVO();
                richiedente.setId(resultSet.getInt("user_id"));     
                richiedente.setUsername(resultSet.getString("username"));
                richiedente.setNome(resultSet.getString("nome"));
                richiedente.setCognome(resultSet.getString("cognome"));
                System.err.println("ID RICHIEDENTE: "+richiedente.getId()); 
                richRic.setRichiedente(richiedente); 
                richRic.setId(resultSet.getInt("richiesta_id"));
                richiesteRicevute.add(richRic);
            }    
            
    }

        catch(SQLException e) {
            e.printStackTrace();
        } finally {
            chiudiConnessione();
        }
        return richiesteRicevute;    

    }
    
    
    public List<RichiestaVO> cercaRichiesteInviate(RichiestaVO richiesta) {

        List<RichiestaVO> richiesteInviate = new LinkedList<RichiestaVO>();

        try {
            connection = this.apriConnessione();
            String queryStr = "SELECT u.user_id , u.username, u.nome, u.cognome, r.richiesta_id FROM user as u JOIN richiesta_amicizia as r ON r.user_ricevente = u.user_id WHERE r.stato = 's' AND r.user_richiedente = ?";
            preparedStatement = connection.prepareStatement(queryStr);
            preparedStatement.setInt(1, richiesta.getRichiedente().getId() );
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                RichiestaVO richInv = new RichiestaVO();
                UserVO ricevente = new UserVO();
                ricevente.setId(resultSet.getInt("user_id"));     
                ricevente.setUsername(resultSet.getString("username"));
                ricevente.setNome(resultSet.getString("nome"));
                ricevente.setCognome(resultSet.getString("cognome"));
                System.err.println("ID RICEVENTE: "+ricevente.getId()); 
                richInv.setRicevente(ricevente);
                richInv.setId(resultSet.getInt("richiesta_id"));
                richiesteInviate.add(richInv);
            }    
            
    }

        catch(SQLException e) {
            e.printStackTrace();
        } finally {
            chiudiConnessione();
        }
        return richiesteInviate;    

    }

    
    public List<UserVO> cercaAmici(RichiestaVO richiesta) {

        List<UserVO> amici = new LinkedList<UserVO>();

        try {
            connection = this.apriConnessione();
            StringBuilder queryStr = new StringBuilder();
            queryStr.append("SELECT u.user_id, u.username, u.nome, u.cognome "); 
            queryStr.append("FROM user AS u JOIN richiesta_amicizia AS r ON u.user_id=r.user_richiedente ");
            queryStr.append("WHERE r.stato = 'a' AND r.user_ricevente = ? ");
            queryStr.append("UNION SELECT u.user_id, u.username, u.nome, u.cognome ");
            queryStr.append("FROM user AS u JOIN richiesta_amicizia as r ON u.user_id=r.user_ricevente  ");
            queryStr.append("WHERE r.stato = 'a' AND r.user_richiedente = ?");
            preparedStatement = connection.prepareStatement(queryStr.toString());
            preparedStatement.setInt(1, richiesta.getRichiedente().getId());
            preparedStatement.setInt(2, richiesta.getRicevente().getId());
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                UserVO amico = new UserVO();
                amico.setId(resultSet.getInt("user_id"));     
                amico.setUsername(resultSet.getString("username"));
                amico.setNome(resultSet.getString("nome"));
                amico.setCognome(resultSet.getString("cognome"));
                System.err.println("ID AMICO: "+ amico.getId()); 
                amici.add(amico);
            }    
            
    }

        catch(SQLException e) {
            e.printStackTrace();
        } finally {
            chiudiConnessione();
        }
        return amici;    

    }

    public List<PostVO> mieiPost(UserVO user) {

        List<PostVO> post = new LinkedList<PostVO>();

        try {
            connection = this.apriConnessione();
            String queryStr = "SELECT p.post_id , p.contenuto, p.dataPubblicazione, u.username FROM post p JOIN user u ON u.user_id = p.user_id WHERE  p.user_id = ?";
            preparedStatement = connection.prepareStatement(queryStr);
            preparedStatement.setInt(1, user.getId() );
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                PostVO postSing = new PostVO();
                UserVO userp = new UserVO();
                postSing.setId(resultSet.getInt("post_id"));     
                postSing.setContenuto(resultSet.getString("contenuto"));
                postSing.setDataPubblicazione(resultSet.getDate("dataPubblicazione"));
                postSing.setUser(userp);
                postSing.getUser().setUsername(resultSet.getString("username"));
                System.err.println("USER: "+ postSing.getUser().getUsername()); 
                post.add(postSing);
            }    
            
    }

        catch(SQLException e) {
            e.printStackTrace();
        } finally {
            chiudiConnessione();
        }
        return post;    

    }
	
    
    public List<PostVO> postHome(UserVO user) {

        List<PostVO> post = new LinkedList<PostVO>();

        try {
            connection = this.apriConnessione();
            StringBuilder queryStr = new StringBuilder();
            queryStr.append("SELECT p.post_id , p.contenuto, p.dataPubblicazione, u.username ");
            queryStr.append("FROM post p JOIN user u ");
            queryStr.append("ON u.user_id = p.user_id ");
            queryStr.append("WHERE  p.user_id = ? ");
            queryStr.append("UNION SELECT p.post_id , p.contenuto, p.dataPubblicazione, innerTable.userName ");
            queryStr.append("FROM post AS p ");
            queryStr.append("JOIN ( SELECT u.user_id as userId, u.username as userName ");
            queryStr.append("FROM user AS u JOIN richiesta_amicizia AS r ON u.user_id=r.user_richiedente ");
            queryStr.append("WHERE r.stato = 'a' AND r.user_ricevente = ? ");
            queryStr.append("UNION SELECT u.user_id as userId, u.username as userName ");
            queryStr.append("FROM user AS u JOIN richiesta_amicizia as r ON u.user_id=r.user_ricevente ");
            queryStr.append("WHERE r.stato = 'a' AND r.user_richiedente = ?) as innerTable ");
            queryStr.append("ON p.user_id = innerTable.userId ");
            preparedStatement = connection.prepareStatement(queryStr.toString());
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.setInt(3, user.getId());
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                PostVO postSing = new PostVO();
                UserVO userp = new UserVO();
                postSing.setId(resultSet.getInt("post_id"));     
                postSing.setContenuto(resultSet.getString("contenuto"));
                postSing.setDataPubblicazione(resultSet.getDate("dataPubblicazione"));
                postSing.setUser(userp);
                postSing.getUser().setUsername(resultSet.getString("username"));
                System.err.println("USER: "+ postSing.getUser().getUsername());
                post.add(postSing);
            }
            
    }

        catch(SQLException e) {
            e.printStackTrace();
        } finally {
            chiudiConnessione();
        }
        return post;    

    }

}
