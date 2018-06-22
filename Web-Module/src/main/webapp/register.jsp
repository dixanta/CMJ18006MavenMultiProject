

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Your Account!</h1>
        <form method="post" action="create_account.jsp" autocomplete="off">
            <div>
                <label>User Name</label>
                <input type="text" name="username" required="required"/>
            </div>
            <div>
                <label>Email</label>
                <input type="email" name="email" required="required"/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" required="required"/>
            </div>
            <div>
                <button type="submit">Register</button>
            </div>
        </form>
    </body>
</html>
