package it.sistinf.headnet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestioneConnessione {
	
	protected Connection connection = null;
	protected Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;
	
	/*metodo che restituisce l'oggetto di connessione*/
	protected Connection apriConnessione() throws SQLException {  //si può usare solo dentro al package poichè è protected
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/headnet?serverTimezone=UTC", "root","admin");// la stringa di connessione per il db scelto(all'interno del metodo getConnection)
			System.out.println("Connessione aperta correttamente");
			return connection;
		}
	
	protected void chiudiConnessione() { //chiude la connessione al db
		if(connection != null) {
			try {
				connection.close();
				System.out.println("Connessione chiusa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(statement != null) {
			try {
				statement.close();
				System.out.println("Statement chiuso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
				System.out.println("PreparedStatement chiuso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(resultSet != null) {
			try {
				resultSet.close();
				System.out.println("ResultSet chiuso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
