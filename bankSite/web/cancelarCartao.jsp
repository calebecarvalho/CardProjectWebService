<%-- 
    Document   : cancelarCartao
    Created on : Dec 10, 2016, 11:01:03 PM
    Author     : burn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="fundosParaMenus.css" rel="stylesheet" type="text/css">
        <title>Cancelar Cartão</title>
    </head>
    <body>
        <font size="5" Color="black">Informe o Número do Cartão:</font>
        <br/><br/>
        <form action="/bloqueiaCartao" method="POST">
            Número do Cartão: <input type="text" name="numCartao"/><br/>
            <input type="submit" value="Cancelar Cartão"/>
        </form>
        
    </body>
</html>
