<%-- 
    Document   : consulta
    Created on : Dec 10, 2016, 11:00:53 PM
    Author     : burn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="fundosParaMenus.css" rel="stylesheet" type="text/css">
        <title>Consulta de Cliente</title>
    </head>
    <body>
       <font size="5" Color="black">Informe o CPF:</font>
        <br/><br/>
        <form action="/consulta" method="POST">
            CPF: <input type="text" name="cpf"/><br/>
            <input type="submit" value="Consultar"/>
        </form>
        
    </body>
</html>
