package banco.de.dados.DAO;

import banco.de.dados.ConnectionFactory;
import banco.de.dados.Model.Cadastro;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroDAO {

	private boolean check = false;

	public void InserirCadastro(Cadastro ca) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO cadastro (Nome_Completo, Data_de_Nascimento, Sexo, CPF, RG, CEP, Endereco, Numero, Complemento, Bairro, Cidade, UF, Email, Telefone_Residencial, Telefone_Celular, Universidade, EnderecoUniversidade, Curso, Usuario, Senha, PerguntaSecreta, Cargo, Categoria)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			stmt.setString(1, ca.getNomeCompleto());
			stmt.setString(2, ca.getDataDeNascimento());
			stmt.setString(3, ca.getSexo());
			stmt.setString(4, ca.getCPF());
			stmt.setString(5, ca.getRG());
			stmt.setString(6, ca.getCEP());
			stmt.setString(7, ca.getEndereco());
			stmt.setString(8, ca.getNumero());
			stmt.setString(9, ca.getComplemento());
			stmt.setString(10, ca.getBairro());
			stmt.setString(11, ca.getCidade());
			stmt.setString(12, ca.getUF());
			stmt.setString(13, ca.getEmail());
			stmt.setString(14, ca.getTelefoneResidencial());
			stmt.setString(15, ca.getTelefone_Celular());
			stmt.setString(16, ca.getUniversidade());
			stmt.setString(17, ca.getEnderecoUniversidade());
			stmt.setString(18, ca.getCurso());
			stmt.setString(19, ca.getUsuario());
			stmt.setString(20, ca.getSenha());
			stmt.setString(21, ca.getPerguntaSecreta());
			stmt.setString(22, ca.getCargo());
			stmt.setString(23, ca.getCategoria());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu uma falha no seu cadastro ,tente novamente.");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public boolean CheckUsuario(String Usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Usuario = ?");
			stmt.setString(1, Usuario);
			rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Já existe este Usuário registrado.");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}

	public boolean CheckEmail(String Email) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Email = ?");
			stmt.setString(1, Email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Já existe este email registrado");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}

	// Usado na tela Registros do Superior para carregar todos os cadastros
	public List<Cadastro> CarregarCadastros() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar todos os cadastros no
	// campo de busca
	public List<Cadastro> CarregarCadastrosBuscar(String nome) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Nome_Completo LIKE ?");
			stmt.setString(2, "%" + nome + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar apenas os colaboradores
	public List<Cadastro> CarregarCadastrosColaborador() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Colaborador'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar apenas os avaliadores
	public List<Cadastro> CarregarCadastrosAvaliador() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Avaliador'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar os superiores
	public List<Cadastro> CarregarCadastrosSuperior() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Superior'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	
	
	
	
	//id
	public Cadastro carregar(int ID) {
		Cadastro cadastro = new Cadastro();
		cadastro.setId(ID);
		String sqlSelect = "SELECT Nome_Completo, Data_de_Nascimento, Sexo, CPF, RG, CEP, Endereco, Numero, Complemento, Bairro, Cidade, UF, Email, Telefone_Residencial, Telefone_Celular, Universidade, EnderecoUniversidade, Curso, Usuario, Senha, PerguntaSecreta, Cargo, Categoria FROM cadastro WHERE cadastro.ID = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cadastro.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					
					cadastro.setNomeCompleto(rs.getString("Nome_Completo"));
					cadastro.setDataDeNascimento(rs.getString("Data_de_Nascimento"));
					cadastro.setSexo(rs.getString("Sexo"));
					
					cadastro.setCPF(rs.getString("CPF"));
					cadastro.setRG(rs.getString("RG"));
					cadastro.setCEP(rs.getString("CEP"));
					cadastro.setEndereco(rs.getString("Endereco"));
					cadastro.setNumero(rs.getString("Numero"));
					cadastro.setComplemento(rs.getString("Complemento"));
					cadastro.setBairro(rs.getString("Bairro"));
					cadastro.setCidade(rs.getString("Cidade"));
					cadastro.setUF(rs.getString("UF"));
					cadastro.setEmail(rs.getString("Email"));
					cadastro.setTelefoneResidencial(rs.getString("Telefone_Residencial"));
					cadastro.setTelefone_Celular(rs.getString("Telefone_Celular"));
					cadastro.setUniversidade(rs.getString("Universidade"));
					cadastro.setEnderecoUniversidade(rs.getString("EnderecoUniversidade"));
					cadastro.setCurso(rs.getString("Curso"));
					cadastro.setUsuario(rs.getString("Usuario"));
					cadastro.setSenha(rs.getString("Senha"));
					cadastro.setPerguntaSecreta(rs.getString("PerguntaSecreta"));
					cadastro.setCargo(rs.getString("Cargo"));
					cadastro.setCategoria(rs.getString("Categoria"));
					
					
				} else {
					cadastro.setId(-1);
					cadastro.setNomeCompleto(null);
					cadastro.setTelefoneResidencial(null);
					cadastro.setEmail(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cadastro;
	}
	
	
	public List<Cadastro> carregarTodosCadastro() {
		Cadastro cadastro;
		
		List<Cadastro> lista = new ArrayList<Cadastro>();
		
		String sqlSelect = "SELECT id,Nome_Completo,Data_de_Nascimento,Sexo, Telefone_Residencial, Email FROM cadastro;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					cadastro = new Cadastro();
					
					cadastro.setId(rs.getInt("Id"));
					cadastro.setNomeCompleto(rs.getString("Nome_Completo"));
					cadastro.setDataDeNascimento(rs.getString("Data_de_Nascimento"));
					cadastro.setSexo(rs.getString("Sexo"));
					
					cadastro.setTelefoneResidencial(rs.getString("Telefone_Residencial"));
					cadastro.setEmail(rs.getString("Email"));
					
					lista.add(cadastro);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}


}
