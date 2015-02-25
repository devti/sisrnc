package rnc.sismedicao.model.beans;

public class Usuario extends Pessoa{
	
	private int codUsuario;
	private int codPessoa;
	private String login;
	private String senha;

	public Usuario(int codUsuario, String login, String senha) {
		this.codUsuario = codUsuario;
		this.login = login;
		this.senha = senha;
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
