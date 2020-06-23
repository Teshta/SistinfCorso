package it.sistinf.headnet.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.sistinf.headnet.vo.UserVO;

public class HeadnetDao extends GestioneConnessione {

	public UserVO cercaUtenteVO(String username) throws Exception {
		UserVO dip = new UserVO();

		try {

			connection = this.apriConnessione();

			String queryStr = "SELECT * FROM USER U WHERE U.USERNAME = ?";
			preparedStatement = connection.prepareStatement(queryStr);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();


			while(resultSet.next()) { //resultSet il cursore punta prima della prima riga, quindi necessario il next
				dip.setNome(resultSet.getString("nome"));
				dip.setCognome(resultSet.getString("cognome"));
				dip.setUsername(resultSet.getString("username"));
				dip.setEmail(resultSet.getString("email"));
				dip.setPassword(resultSet.getString("password"));
				dip.setDataDiNascita(resultSet.getDate("dataDiNascita"));
				
			}		

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			chiudiConnessione();
		}
		return dip;
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
	
	
	public UserVO cercaUtente(String nome, String cognome) {

		UserVO user = new UserVO();

		try {
			connection = this.apriConnessione();
			String queryStr = "SELECT * FROM USER  WHERE user.nome = ? AND user.cognome = ?";
			preparedStatement = connection.prepareStatement(queryStr);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				user.setNome(resultSet.getString("nome"));
				user.setCognome(resultSet.getString("cognome"));
				user.setEmail(resultSet.getString("email"));
				user.setDataDiNascita(resultSet.getDate("dataDiNascita"));
				user.setUsername(resultSet.getString("username"));
			}	
		}

		catch(SQLException e) {
			e.printStackTrace();
		} finally {
			chiudiConnessione();
		}
		return user;	
	
	}	


	public List<UserVO> findAll() {
		List<UserVO> listauser = new LinkedList<UserVO>(); 

		try {
			connection = this.apriConnessione();
			statement = connection.createStatement();
			String queryStr = "SELECT * FROM USER";
			resultSet = statement.executeQuery(queryStr);

			while(resultSet.next()) {
				UserVO user = new UserVO();
				user.setNome(resultSet.getString("nome"));
				user.setEmail(resultSet.getString("email"));
				user.setDataDiNascita(resultSet.getDate("dataDiNascita"));
				user.setUsername(resultSet.getString("username"));
				listauser.add(user);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} finally {
			chiudiConnessione();
		}
		return listauser;
	} 

}
