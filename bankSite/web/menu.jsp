<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciamento</title>
        <link href="menuS.css" rel="stylesheet" type="text/css">
        <link href="ifundo.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <header>
            <font size="5" Color="black">Gerenciamento de Clientes</font>
        </header>

<nav role='navigation'>
  <a href="/bankSite/cadastro.jsp">Cadastrar Cliente</a>
  <a href="/bankSite/excluirCliente.jsp">Excluir Cliente</a>
  <a href="/bankSite/listarCliente.jsp">Listar Clientes</a>
  <a href="/bankSite/consulta.jsp">Consultar por CPF</a>
  <a href="/bankSite/cancelarCartao.jsp">Cancelar Cartão</a>
</nav>
        
        <form action="Logout">           
            <input type="submit"    value="Logout"><br>
        </form>
        
    </body>
</html>
