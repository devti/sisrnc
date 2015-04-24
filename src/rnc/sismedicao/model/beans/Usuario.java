package rnc.sismedicao.model.beans;

public class Usuario {
	
	private int codUsuario;
	private int codPessoa;
	private String login;
	private String nome;
	private String senha;

	public Usuario(String nome, String login, int codigoPessoa, int codigoUsuario){
		this.codPessoa = codigoPessoa;
		this.codUsuario = codigoUsuario;
		this.login = login;
		this.nome = nome;
		
	}
	public Usuario(int codUsuario, String login, String senha) {
		this.codUsuario = codUsuario;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(String login, String senha, String Nome) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
