<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Usuarios</title>

<link href="css/bootstrap.css" rel="stylesheet">

</head>
<body>
  <!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp"/>
<div id="p">
<h3>Cadastro de Usuarios</h3>
<form action="ManterCadastro.do" method="get">
<div class="form-group">
<label for="exampleInputEmail1">nome:</label> <input type="text" name="nome"  class="form-control" id="exampleInputEmail1" placeholder="Nome Completo"><br>


<label for="exampleInputEmail1">Data de nacimento: </label>
<input type="text" name="Data" class="form-control" placeholder="Data de nacimento"><br>

<label for="exampleInputEmail1">Sexo: </label>
<select class="form-control" name="sexo">
<option > </option>
<option >Masculino</option>
  <option>Feminino</option>
</select><br>


<label for="exampleInputEmail1">cpf:</label>
 <input type="text" name="cpf" class="form-control" placeholder="CPF"><br>
 
<label for="exampleInputEmail1">rg:</label>
 <input type="text" name="rg" class="form-control" placeholder="RG"><br>
 
 
<label for="exampleInputEmail1">cep:</label>
 <input type="text" name="cep" class="form-control" placeholder="CEP"><br>
 
 
<label for="exampleInputEmail1">Endereco:</label>
 <input type="text" name="Endereco" class="form-control" placeholder="Endereço"><br>
 
 
<label for="exampleInputEmail1">Numero:</label>
 <input type="text" name="Numero" class="form-control" placeholder="Numero"><br>
 
 
<label for="exampleInputEmail1">Complemento:</label>
 <input type="text" name="Complemento" class="form-control" placeholder="Complemento"><br>
 
 
<label for="exampleInputEmail1">Bairro:</label>
 <input type="text" name="Bairro" class="form-control" placeholder="Bairro"><br>
 
 
<label for="exampleInputEmail1">Cidade:</label>
 <input type="text" name="Cidade" class="form-control" placeholder="Cidade"><br>
 
<label for="exampleInputEmail1"> UF:</label>
 <input type="text" name="UF" class="form-control" placeholder="Cidade"><br>
 
 
 <div id="dados">
 <h3>Dados para contato</h3>
<label for="exampleInputEmail1">fone:</label>  <input type="text" name="fone Residencial"  class="form-control1" placeholder="Telefone Residencial" autocomplete="off"><br>
<label for="exampleInputEmail1">e-mail: </label>
<input type="text" name="Email" class="form-control1" placeholder="E-mail"><br> 
 
 
<label for="exampleInputEmail1">Telefone Celular:</label>
 <input type="text" name="Telefone_Celular"  class="form-control1" placeholder="Telefone Celular"><br>

<h3>Dados da universidade</h3>
<label for="exampleInputEmail1">Universidade:</label>
 <input type="text" name="Universidade" class="form-control1" placeholder="Nome da univercidade"><br>
 
 
<label for="exampleInputEmail1">Endereco Universidade:</label>
 <input type="text" name="EnderecoUniversidade" class="form-control1" placeholder="Nome da univercidade"><br>
 
 
<label for="exampleInputEmail1">Curso:</label>
 <input type="text" name="Curso" class="form-control1" placeholder="Curso"><br>
 
 
 <h3>Dados de acesso</h3>
<label for="exampleInputEmail1">Usuario:</label>
 <input type="text" name="Usuario" class="form-control1" placeholder="Usuario"><br>
 
<label for="exampleInputEmail1">Senha:</label>
 <input type="password" name="Senha" class="form-control1" placeholder="Senha"><br>
 
 
<label for="exampleInputEmail1">Pergunta Secreta:</label>
 <input type="text" name="PerguntaSecreta" class="form-control1" placeholder="Pergunta secreta"><br>
 
 
<label for="exampleInputEmail1">Cargo:</label>
 <input type="text" name="Cargo" class="form-control1" placeholder="Cargo"><br>
 
<label for="exampleInputEmail1">Categoria:</label>
 <input type="text" name="Categoria" class="form-control1" placeholder="Categoria"><br>
 


<input class="btn btn-primary" type="submit">
</div>
</div>

</form>
</div>


<script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>