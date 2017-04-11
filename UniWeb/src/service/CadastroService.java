package service;

import java.util.List;

import banco.de.dados.DAO.CadastroDAO;
import banco.de.dados.Model.Cadastro;








public class CadastroService {
	
	CadastroDAO dao = new CadastroDAO();
	
	
	
	public Cadastro InserirCadastro(Cadastro ca) {
		dao.InserirCadastro(ca);
		return ca;
	}
	
	public boolean CheckUsuario(String Usuario){
		return dao.CheckUsuario(Usuario);
	}
	
	public boolean CheckEmail(String Email) {
		return dao.CheckEmail(Email);
	}
	
	
	
	
	public Cadastro carregar(int id){
		return dao.carregar(id);
	}
	
	public List<Cadastro> carregarTodosCadastro(){
		return dao.carregarTodosCadastro();
	}
	
}
