package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.Conexao;
import model.LoginUser;

public class Conexao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url= "jdbc:mysql://127.0.0.1:3306/dblogin?useTimezone&serverTimezone=UTC";
	private String user="root";
	private String password="inyzinho";
	
	//Método de Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			return con;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/**CRUD CREATE **/
	public void inserirUsuarios(LoginUser usuarios) {
		String create = "insert into usuarios (email_usuario, senha_usuario) values (?,?)";
		try {
			//Abrir a conexão
			Connection con = conectar();
			//Preparar a query para execucao no Banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			//Substituir os parametros (?) pelos contéudos das variáveis Java Beans
			pst.setString(1, usuarios.getEmail_usuario());
			pst.setString(2, usuarios.getSenha_usuario());
			
			//Executar a query
			pst.executeUpdate();
			//Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**CRUD READ **/
	public ArrayList<LoginUser> Exibirusuarios(){
		//Criando um objeto para acessar a classe JavaBeans
		ArrayList<LoginUser> usuarios = new ArrayList<>();
		String read ="select * from usuarios order by email_usuario";
		try {
			Connection con = conectar();
			PreparedStatement pst=con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//O laco abaixo será executado enquanto houver contatos
			while(rs.next()) {
				//variaveis de apoio que recebem os dados do banco
				String id_usuario = rs.getString(1);
				String email_usuario = rs.getString(2);
				String senha_usuario = rs.getString(3);
				
				//populando o ArrayList
				usuarios.add(new LoginUser(id_usuario, email_usuario, senha_usuario));
			}
			con.close();
			return usuarios;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
				
	    }
	}
}
	