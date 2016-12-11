<%-- 
    Document   : cadastro
    Created on : Dec 10, 2016, 9:34:50 PM
    Author     : burn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
        <link href="alinhamento.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Cadastre seu Cliente</h1>
        
        <form action="cadastro" method="POST">
            <label class="hora">CPF:     </label><input type="text" name="cpf"/><br/>
            <label class="hora">NOME:      </label><input type="text" name="nome"/><br/>
            <label class="hora">SENHA:     </label><input type="text" name="senha"/><br/>
            <label class="hora">CEP:     </label><input type="text" name="cep"/><br/>
            <label class="hora">ENDERECO:      </label><input type="text" name="endereco"/><br/>
            <label class="hora">EMAIL:      </label><input type="text" name="email"/><br/>
            <label class="hora">TELEFONE-RES:      </label><input type="text" name="telefoneres"/><br/>
            <label class="hora">CELULAR:      </label><input type="text" name="celular"/><br/>
            <label class="hora">INDEX:      </label><input type="text" name="index"/><br/>
            
            <input type="submit" value="Submit"/>
        </form>
        
        
    </body>
</html>
