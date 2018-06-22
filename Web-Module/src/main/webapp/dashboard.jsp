<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.net.Socket"%>
<%@page import="com.dixanta.module.entity.User"%>
<%@page import="com.dixanta.module.dao.impl.UserDAOImpl"%>
<%
    User user = new User();
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    } else {
        user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("index.jsp");
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome <%=user.getUserName()%></h1>
        <%
            if (request.getMethod().equalsIgnoreCase("post")) {
                try {
                    Socket socket = new Socket("192.168.0.10", 9090);
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println(user.getUserName());
                    ps.println(user.getPassword());
                    String message=request.getParameter("message");
                    ps.println(message);
                    if(message.equalsIgnoreCase("list")){
                       BufferedReader reader=new BufferedReader(
                       new  InputStreamReader(socket.getInputStream()));
                       String line="";
                       String content="";
                      while(!(line=reader.readLine()).equalsIgnoreCase("%%END%%")){
                          content +=line + "<br/>";
                      } 
                      out.println(content);
                    }
                    
                    ps.println("exit");
                    
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        %>

        <form method="post" action="">
            <textarea name="message"></textarea>
            <button type="submit">Send</button>
        </form>
    </body>
</html>
