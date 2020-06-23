package it.sistinf.headnet.avo;

import java.util.Date;
import java.util.List;

public class UserVO {
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String password;
	private Date dataDiNascita;
	private List<PostVO> posts;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<PostVO> getPosts() {
		return posts;
	}
	public void setPosts(List<PostVO> posts) {
		this.posts = posts;
	}


}
