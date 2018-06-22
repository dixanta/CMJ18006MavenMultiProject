<%-- 
    Document   : index
    Created on : Jun 22, 2018, 5:21:44 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Simple Chat Site</h1>
        <form action="login_check.jsp" method="post">
            <h3>Login</h3>
            <div>
                <label>User Name</label>
                <input type="text" name="username"/>
            </div>
            <div>
                <label>Password</label>
                <input type="text" name="password"/>
            </div>
            <button type="submit">Login</button>
        </form>
        <div>
            Don't have account yet ?
            <a href="register.jsp">Click here to Register</a>
        </div>
    </body>
</html>
