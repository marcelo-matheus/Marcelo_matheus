<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar Cadastros</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
        <!-- Barra superior com os menus de navegação -->
		<c:import url="Menu.jsp"/>
        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Lista de Cadastro</h3>
<table>
<th>Id </th>
<th> &nbsp;&nbsp; &nbsp;&nbsp;Nome Completo </th>
<th>&nbsp;&nbsp;  &nbsp;&nbsp;Data de nacimento </th>
<th>&nbsp;&nbsp;  &nbsp;&nbsp;Sexo </th>
<th>&nbsp;&nbsp;  &nbsp;&nbsp;Email </th>
<th>&nbsp;&nbsp;  &nbsp;&nbsp;Telefone Residencial </th>

<th></th>
<c:forEach var="cadastro" items="${lista}">
<tr>

<td>${cadastro.id}</td>
<td>&nbsp;&nbsp; &nbsp;&nbsp;${cadastro.nomeCompleto}</td>
<td>&nbsp;&nbsp; &nbsp;&nbsp;${cadastro.dataDeNascimento}</td>
<td>&nbsp;&nbsp; &nbsp;&nbsp;${cadastro.sexo}</td>
<td>&nbsp;&nbsp; &nbsp;&nbsp;${cadastro.email}</td>
<td>&nbsp;&nbsp; &nbsp;&nbsp;${cadastro.telefoneResidencial}</td>
</tr>
</c:forEach>
</table>

            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>