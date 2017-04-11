package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.de.dados.Model.Cadastro;
import service.CadastroService;


/**
 * Servlet implementation class ManterCadastroController
 */
@WebServlet("/ManterCadastro.do")
public class ManterCadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome_Completo = request.getParameter("nome");
		String pTelefone_Residencial = request.getParameter("fone Residencial");
		String pData_de_Nascimento = request.getParameter("Data");
		String pSexo = request.getParameter("sexo");
		String pCPF = request.getParameter("cpf");
		String pRG = request.getParameter("rg");
		String pCep = request.getParameter("cep");
		String pEndereco = request.getParameter("Endereco");
		String pNumero = request.getParameter("Numero");
		String pComplemento = request.getParameter("Complemento");
		String pBairro = request.getParameter("Bairro");
		String pCidade = request.getParameter("Cidade");
		String pEmail = request.getParameter("Email");
		String pTelefone_Celular = request.getParameter("Telefone_Celular");
		String pUniversidade = request.getParameter("Universidade");
		String pEnderecoUniversidade = request.getParameter("EnderecoUniversidade");
		String pCurso = request.getParameter("Curso");
		String pUsuario = request.getParameter("Usuario");
		String pSenha = request.getParameter("Senha");
		String pPerguntaSecreta = request.getParameter("PerguntaSecreta");
		String pCargo = request.getParameter("Cargo");
		String pCategoria = request.getParameter("Categoria");
		String pUF = request.getParameter("UF");
		
		
		//instanciar o javabean
		Cadastro cadastro = new Cadastro();
		
		
		cadastro.setNomeCompleto(pNome_Completo);
		cadastro.setDataDeNascimento(pData_de_Nascimento);
		cadastro.setSexo(pSexo);
		cadastro.setCPF(pCPF);
		cadastro.setRG(pRG);
		cadastro.setCEP(pCep);
		cadastro.setEndereco(pEndereco);
		cadastro.setNumero(pNumero);
		cadastro.setComplemento(pComplemento);
		cadastro.setBairro(pBairro);
		cadastro.setCidade(pCidade);
		cadastro.setUF(pUF);
		cadastro.setEmail(pEmail);
		cadastro.setTelefoneResidencial(pTelefone_Residencial);
		cadastro.setTelefone_Celular(pTelefone_Celular);
		cadastro.setUniversidade(pUniversidade);
		cadastro.setEnderecoUniversidade(pEnderecoUniversidade);
		cadastro.setCurso(pCurso);
		cadastro.setUsuario(pUsuario);
		cadastro.setSenha(pSenha);
		cadastro.setPerguntaSecreta(pPerguntaSecreta);
		cadastro.setCargo(pCargo);
		cadastro.setCategoria(pCategoria);
		
		//instanciar o service
		CadastroService cs = new CadastroService();
		cs.InserirCadastro(cadastro);
		//cadastro = cs.carregar(cadastro.getId());;
		
		 //enviar para o jsp
        request.setAttribute("cadastro", cadastro);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Cadastro.jsp");
        view.forward(request, response);
		
		/*PrintWriter out = response.getWriter();
		out.println("<html><head><title>Usuario Cadastrado</title></head><body>");
		out.println(	"Casdastro feito com sucesso""id: "+cadastro.getId()+"<br>");
		out.println(	"nome: "+cadastro.getNome_Completo()+"<br>");
		out.println(	"Data de nacimento: "+cadastro.getData_de_Nascimento()+"<br>");
		out.println(	"Sexo: "+cadastro.getSexo()+"<br>");
		out.println(	"CPF: "+cadastro.getCPF()+"<br>");
		
		out.println(	"RG: "+cadastro.getRG()+"<br>");
		out.println(	"CEP: "+cadastro.getCEP()+"<br>");
		out.println(	"Endereco: "+cadastro.getEndereco()+"<br>");
		out.println(	"Numero: "+cadastro.getNumero()+"<br>");
		out.println(	"Complemento: "+cadastro.getComplemento()+"<br>");
		out.println(	"Bairro: "+cadastro.getBairro()+"<br>");
		out.println(	"Cidade: "+cadastro.getCidade()+"<br>");
		out.println(	"UF: "+cadastro.getUF()+"<br>");
		out.println(	"e-mail: "+cadastro.getEmail()+"<br>");
		out.println(	"Telefone Residencial: "+cadastro.getTelefone_Residencial()+"<br>");
		out.println(	"Telefone Celular: "+cadastro.getTelefone_Celular()+"<br>");
		out.println(	"e-mail: "+cadastro.getUniversidade()+"<br>");
		out.println(	"Universidade: "+cadastro.getEnderecoUniversidade()+"<br>");
		out.println(	"Curso: "+cadastro.getCurso()+"<br>");
		out.println(	"Usuario: "+cadastro.getUsuario()+"<br>");
		out.println(	"Senha: "+cadastro.getSenha()+"<br>");
		out.println(	"Confirmar Senha: "+cadastro.getConfirmarSenha()+"<br>");
		
		out.println(	"Pergunta Secreta: "+cadastro.getPerguntaSecreta()+"<br>");
		out.println(	"Cargo: "+cadastro.getCargo()+"<br>");
		out.println(	"Categoria: "+cadastro.getCategoria()+"<br>");
		
		
	    out.println("</body></html>");*/
		
	}

}
