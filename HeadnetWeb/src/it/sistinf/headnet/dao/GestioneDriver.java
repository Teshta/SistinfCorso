package it.sistinf.headnet.dao;

public class GestioneDriver {
	public void registraDriver() { //non serve lo fa in automatico
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver registrato correttamente");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //per ricercare,una volta senza instanziare, il driver del database e vedere se è presente
	}
}

