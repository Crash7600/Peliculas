<%-- 
    Document   : menu02
    Created on : Jan 18, 2013, 12:30:02 PM
    Author     : rafa
--%>

<%@page import="net.cine.bean.UsuarioBean"%>

<div class="well sidebar-nav">
    <ul class="nav nav-list">
        <li class="nav-header">Usuario</li>
        <li><a id="lnkUser" href="#">Mi Perfil</a></li>
        <li><a id="lnkHome"  href="jsp">Home</a></li>
        <li><a id="lnkLogout" href="jsp?ob=usuario&op=logout">Logout</a></li>
        <li class="nav-header">Mantenimientos</li>            
        
        <%
            //Parte para saber el tipo de usuario
            UsuarioBean oUsuarioBean;
            oUsuarioBean = (UsuarioBean) request.getSession().getAttribute("usuarioBean");
            java.lang.Enum tipoUsuario = oUsuarioBean.getTipoUsuario();
            //
            //Validacion
        if (tipoUsuario.equals(net.cine.helper.Enum.TipoUsuario.Administrador)) {
            
             out.print("<li><a id=\"lnkUsuario\" href=\"#\">Usuario</a></li>");
            
            
             } 
        //else {
            //Mostramos el MENSAJE
        //    oContexto.setVista("jsp/mensaje.jsp");
        //    return "<span class=\"label label-important\">¡¡¡ No estás autorizado a entrar aquí !!!<span>";
       // }
                    
               
                %>
        
        
        
        <li><a id="lnkDirector" href="#">Director</a></li>
        <li><a id="lnkEstudio" href="#">Estudio</a></li>
        <li><a id="lnkGenero" href="#">Genero</a></li>
        <li><a id="lnkReparto" href="#">Reparto</a></li>
        <li><a id="lnkPelicula" href="#">Pelicula</a></li>
        
        
    </ul>
</div>
