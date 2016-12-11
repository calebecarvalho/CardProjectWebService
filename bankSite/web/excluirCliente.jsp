<%-- 
    Document   : excluirCliente
    Created on : Dec 11, 2016, 12:04:26 AM
    Author     : burn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exclusão de Cliente</title>
    </head>
    <body>
<font size="5" Color="black">Informe o CPF do ciente a ser congelado:</font>
        <br/><br/>
        <form action="/excluir" method="POST">
            CPF: <input type="text" name="cpf"/><br/>
            <input type="submit" value="Congelar Cliente"/>
        </form>
        
    </body>
</html>
