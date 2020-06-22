package it.sistinf.headnet.dao;

import java.sql.SQLException;


import it.sistinf.headnet.avo.UserVO;

public class HeadnetDao extends GestioneConnessione {

	public UserVO cercaDipendenteVO(String email) {
		UserVO dip = new UserVO();

		try {

			connection = this.apriConnessione();

			String queryStr = "SELECT * FROM USERS U WHERE U.EMAIL = ?";
			preparedStatement = connection.prepareStatement(queryStr);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			boolean trovato = false;

			while(resultSet.next()) { //resultSet il cursore punta prima della prima riga, quindi necessario il next
				dip.setNome(resultSet.getString("nome"));
				dip.setCognome(resultSet.getString("cognome"));
				dip.setEmail(resultSet.getString("email"));
				dip.setPassword(resultSet.getString("password"));
				dip.setDataDiNascita(resultSet.getDate("dataDiNascita"));
				trovato = true;
			}	

//			if(!trovato) {
//				throw new DipendenteNonTrovatoException();
//			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			chiudiConnessione();
		}
		return dip;
	}

}