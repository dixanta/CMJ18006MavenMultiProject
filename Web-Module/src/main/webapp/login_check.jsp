<%@page import="java.io.PrintStream"%>
<%@page import="java.net.Socket"%>
<%@page import="com.dixanta.module.entity.User"%>
<%@page import="com.dixanta.module.dao.impl.UserDAOImpl"%>
<%@page import="com.dixanta.module.dao.UserDAO"%>
<%
    if(request.getMethod().equalsIgnoreCase("post")){
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        
        UserDAO userDAO=new UserDAOImpl();
        try{
            User user=userDAO.login(userName, password);
            if(user==null){
                response.sendRedirect("index.jsp?error");
            }else{
                session.setAttribute("user", user);
                response.sendRedirect("dashboard.jsp");
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
%>