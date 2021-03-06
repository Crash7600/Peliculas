<%@page import="net.cine.bean.UsuarioBean"%>
<%UsuarioBean user = (UsuarioBean) request.getSession().getAttribute("usuarioBean");%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>CineOnline</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
        <script src="./js/vendor/jquery.validate.min.js"></script>

    </head>
    <body>
        <!--[if lt IE 7]>
        <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->


        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span>
                    </a> 
                    <a class="brand" href="jsp">CineOnline</a>                   
                    <div class="nav-collapse collapse">
                        <%if (user != null) {%>
                           <jsp:include page="jsp/menuSuperior.jsp" />
                        <% }%>
                        <jsp:include page="jsp/usuario/infologin.jsp" />                        
                    </div>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row-fluid">
                <%
                    if (user != null) {
                        out.print("<div class=\"span2\">");
                %>
                <jsp:include page="jsp/menuLateral.jsp" />
                <%
                        out.print("</div>");
                    }
                %>
                <%
                    if (user != null) {
                        out.print("<div class=\"span10\">");
                        out.print("<div id=\"indexContenido\"></div>");
                    } else {
                        out.print("<div class=\"span12\">");
                    }
                %>
                <div id="indexContenidoJsp">
                    <jsp:include page='<%=(String) request.getAttribute("contenido")%>' />                
                </div>
                <%
                    out.print("</div>");
                %>    
                <div class="row-fluid">
                    <div class="span12"><hr><footer><p>&copy; Daniel Rodriguez (2014)</p></footer></div>   
                </div>
            </div>
        </div>                    

        <!-- carga de javascript -->

        <script src="js/vendor/bootstrap.min.js"></script>

        <script src="js/vendor/bootstrap-transition.js"></script>
        <script src="js/vendor/bootstrap-alert.js"></script>
        <script src="js/vendor/bootstrap-modal.js"></script>
        <script src="js/vendor/bootstrap-dropdown.js"></script>
        <script src="js/vendor/bootstrap-scrollspy.js"></script>
        <script src="js/vendor/bootstrap-tab.js"></script>
        <script src="js/vendor/bootstrap-tooltip.js"></script>
        <script src="js/vendor/bootstrap-popover.js"></script>
        <script src="js/vendor/bootstrap-button.js"></script>
        <script src="js/vendor/bootstrap-collapse.js"></script>
        <script src="js/vendor/bootstrap-carousel.js"></script>
        <script src="js/vendor/bootstrap-typeahead.js"></script>    

        <script src="js/util.js" charset="UTF-8"></script>
        <script src="js/main.js" charset="UTF-8"></script>

        <script src="js/control/usuario.js" charset="UTF-8"></script>
        <script src="js/control/director.js" charset="UTF-8"></script>
        <script src="js/control/estudio.js" charset="UTF-8"></script>
        <script src="js/control/genero.js" charset="UTF-8"></script>
        <script src="js/control/user.js" charset="UTF-8"></script>
        <script src="js/control/reparto.js" charset="UTF-8"></script>
        <script src="js/control/pelicula.js" charset="UTF-8"></script>

        
        
        
        <script>

            $(document).ready(function() {
                inicializacion();
                $('#lnkLenguaje').unbind('click');
                $('#lnkLenguaje').click(function() {
                    var lenguaje = objeto('lenguaje', '<%=request.getContextPath()%>');
                    var lenguajeView = vista(lenguaje, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(lenguajeView.getEmptyList());

                    var lenguajeControl = control_lenguaje_list('<%=request.getContextPath()%>');
                    lenguajeControl.inicia(lenguajeView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                
                
                $('#lnkDirector').unbind('click');
                $('#lnkDirector').click(function() {
                    var director = objeto('director', '<%=request.getContextPath()%>');
                    var directorView = vista(director, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(directorView.getEmptyList());

                    var directorControl = control_director_list('<%=request.getContextPath()%>');
                    directorControl.inicia(directorView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                
                

                $('#lnkUsuario').unbind('click');
                $('#lnkUsuario').click(function() {
                    var usuario = objeto('usuario', '<%=request.getContextPath()%>');
                    var usuarioView = vista(usuario, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(usuarioView.getEmptyList());

                    var usuarioControl = control_usuario_list('<%=request.getContextPath()%>');
                    usuarioControl.inicia(usuarioView, 1, null, null, 10, null, null, null, null);
                    return false;
                });

                $('#lnkEstudio').unbind('click');
                $('#lnkEstudio').click(function() {
                    var estudio = objeto('estudio', '<%=request.getContextPath()%>');
                    var estudioView = vista(estudio, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(estudioView.getEmptyList());

                    var estudioControl = control_estudio_list('<%=request.getContextPath()%>');
                    estudioControl.inicia(estudioView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
               
               
               
               $('#lnkGenero').unbind('click');
                $('#lnkGenero').click(function() {
                    var genero = objeto('genero', '<%=request.getContextPath()%>');
                    var generoView = vista(genero, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(generoView.getEmptyList());

                    var generoControl = control_genero_list('<%=request.getContextPath()%>');
                    generoControl.inicia(generoView, 1, null, null, 10, null, null, null, null);
                    return false;
                });

                $('#lnkUser').unbind('click');
                $('#lnkUser').click(function() {
                    var user = objeto('user', '<%=request.getContextPath()%>');
                    var userView = vista(user, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(userView.getEmptyList());

                    var userControl = control_user_list('<%=request.getContextPath()%>');
                    userControl.inicia(userView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                $('#lnkUser').unbind('click');
                $('#lnkUser').click(function() {
                    var user = objeto('user', '<%=request.getContextPath()%>');
                    var userView = vista(user, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(userView.getEmptyList());

                    var userControl = control_user_list('<%=request.getContextPath()%>');
                    userControl.inicia(userView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                
                $('#lnkReparto').unbind('click');
                $('#lnkReparto').click(function() {
                    var reparto = objeto('reparto', '<%=request.getContextPath()%>');
                    var repartoView = vista(reparto, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(repartoView.getEmptyList());

                    var repartoControl = control_reparto_list('<%=request.getContextPath()%>');
                    repartoControl.inicia(repartoView, 1, null, null, 10, null, null, null, null);
                    return false;
                });

                $('#lnkPelicula').unbind('click');
                $('#lnkPelicula').click(function() {
                    var pelicula = objeto('pelicula', '<%=request.getContextPath()%>');
                    var peliculaView = vista(pelicula, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(peliculaView.getEmptyList());

                    var peliculaControl = control_pelicula_list('<%=request.getContextPath()%>');
                    peliculaControl.inicia(peliculaView, 1, null, null, 10, null, null, null, null);
                    return false;
                });

               
                
                
                
                
            

               

            });

        </script>
    </body>
</html>
