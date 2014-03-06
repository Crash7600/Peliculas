<div class="row-fluid">
    <div class="span8">
        <div class="row-fluid">
            
        </div>
    </div>
    <form id="loginForm" action="jsp" class="form-horizontal" method="post">
    
        <img class="imagenentrada" src="img/popcorn.png">
        <h1 class="tituloentrada">CineOnline</h1>
   
    <input type="hidden" name="ob" value="usuario" />
    <input type="hidden" name="op" value="login02" />
    <div class="control-group">
        <label class="control-label" for="inputLogin">Usuario:</label>
        <div class="controls">
            <input type="text" id="inputLogin" autofocus="autofocus" placeholder="Nombre de usuario" name="login">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPassword">Password:</label>
        <div class="controls">
            <input type="password" id="inputPassword" placeholder="Password" name="password">
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button id="entrarBTN" type="submit" class="btn">Entrar</button>
        </div>
    </div>
</form>
<p>Licencia <a href="http://www.gnu.org/licenses/fdl-1.3.html">GNU Free Documentation License 1.3</a></p>
</div>
