<%-- 
    Document   : login02
    Created on : Dec 30, 2013, 1:18:26 PM
    Author     : rafa
--%>
<%@page import="net.cine.bean.UsuarioBean"%>
<% UsuarioBean oUsuario = (UsuarioBean) request.getSession().getAttribute("usuarioBean"); %>
<% if (oUsuario==null){ %>
    <h1>No has entrado en el sistema, ¿quizas has olvidado logearte?</h1>
    <h4>Login o Password incorrectos, revisa tu login o tu password.</h4>
<% } else { %>
    <h1>Has entrado en el sistema</h1>
    <h4>Bienvenido, <%=oUsuario.getLogin() %>. Ahora puedes disfrutar de una buena pelicula.</h4>
<% } %>
