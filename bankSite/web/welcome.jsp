<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <% 
            if(session.getAttribute("username")==null){
               response.sendRedirect("login.jsp");
              }
        %>
        
        Welcome, ${username}
        
        <form action="Logout">
            
            <input type="submit"    value="Logout"><br>
            
        </form>
           
        
    </body>
</html>
