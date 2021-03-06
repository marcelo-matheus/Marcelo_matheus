package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.de.dados.Model.Cadastro;
import service.CadastroService;

/**
 * Servlet implementation class ListarClientes
 */
@WebServlet("/ListaCadastro.do")
public class ListaCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CadastroService cs = new CadastroService();
		
		List<Cadastro> lista = cs.carregarTodosCadastro();
		
		
        //enviar para o jsp
        request.setAttribute("lista", lista);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("ListaCadastro.jsp");
        view.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
