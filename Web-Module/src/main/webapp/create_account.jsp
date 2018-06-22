<%@page import="com.dixanta.module.entity.User"%>
<%@page import="com.dixanta.module.dao.impl.UserDAOImpl"%>
<%@page import="com.dixanta.module.dao.UserDAO"%>
<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserDAO userDAO = new UserDAOImpl();
        try {

            User user = userDAO.getByUserName(userName);
            if (user != null) {
                out.println("<h1>User Name " + userName +
                        " Already Exists</h1>");
            }else if((user=userDAO.getByEmail(email))!=null){
                out.println("<h1>Email " + email +
                        "Already Exists</h1>");
            }else {
                user=new User();
                user.setUserName(userName);
                user.setPassword(password);
                user.setEmail(email);
                user.setStatus(true);
                int result = userDAO.insert(user);
                if (result > 0) {
                    response.sendRedirect("thankyou.jsp");
                } else {
                    response.sendRedirect("register.jsp?error");
                }
            }
        } catch (Exception ex) {

        }
    } else {
        out.println("<h1>Besi Hero Paltya hera na </h1>");
    }
%>