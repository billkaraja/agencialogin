package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import DAO.Conexao;
import model.LoginUser;




@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Conexao dao = new Conexao();
	LoginUser usuarios = new LoginUser();   
    
    public Controller() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			usuarios(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else if (action.equals("/select")) {
			exibirUsuarios(request, response);
		} else if (action.equals("/update")) {
			editarUsuario(request, response);
		} else if (action.equals("/delete")) {
			novoUsuario(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}
}

private void usuarios(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {			
	// Criando um objeto que irá receber os dados JavaBeans
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
	
}

// Novo contato
protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// Setar as variaveis usuario
	usuarios.setEmail_usuario(request.getParameter("email_usuario"));
	usuarios.setSenha_usuario(request.getParameter("senha_usuario"));
	
	// Invocar o método inserirContato passando o objeto contato
	dao.Exibirusuarios();
	// Redirecionar para o documento agenda.js
	response.sendRedirect("main");
}

//Editar usuario
protected void exibirUsuarios(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// Recebimento do id do contato que será recebido
	String id = request.getParameter("id");
	usuarios.setId_usuario(id);
	//Executar o método selecionarContato (DAO)
	
	//Encaminhar ao documento editar.jsp
	RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
	rd.forward (request, response);
}
protected void editarUsuario(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// Setar as variáveis conexao
	        usuarios.setId_usuario(request.getParameter("id_usuario"));			
			usuarios.setEmail_usuario(request.getParameter("email_usuario"));
   //Executar o método de alterarUsuario
			
}
//remover o contato
protected void removerContato(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	//recebimento do id contato a ser excluído (validador.js)
	String id_usuario = request.getParameter("id_usuario");
	//System.out.println(idcon);
	//setar a variável idcon JavaBeans
	
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
   }
}
  