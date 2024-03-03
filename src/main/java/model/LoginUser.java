package model;

public class LoginUser {
	private String id_usuario;
	private String email_usuario;
	private String senha_usuario;
	
		public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public LoginUser(String id_usuario, String email_usuario, String senha_usuario) {
			super();
			this.id_usuario = id_usuario;
			this.email_usuario = email_usuario;
			this.senha_usuario = senha_usuario;
		}

	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}

}
