<%-- 
    Document   : form
    Created on : Jan 24, 2013, 12:02:17 AM
    Author     : Sergio
--%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Edición de Mi Perfil.</h2>
    <div class="control-group">
        <label class="control-label" for="id">ID:</label>
        <div class="controls">
            <input type="text" id="id" name="id" placeholder="id" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="id_usuario">ID Usuario:</label>
        <div class="controls">
            <input type="text" id="id_usuario" name="id_usuario" placeholder="id_usuario" />
            <a class="btn btn-mini" id="id_usuario_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="nombre">Nombre:</label>
        <div class="controls">
            <input type="text" id="nombre" name="nombre" size="15" placeholder="nombre" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="ape1">Primer Apellido:</label>
        <div class="controls">
            <input type="text" id="ape1" name="ape1" size="15" placeholder="ape1" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="ape2">Segundo Apellido:</label>
        <div class="controls">
            <input type="text" id="ape2" name="ape2" size="15" placeholder="ape2" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="sexo">Sexo:</label>
        <div class="controls">
            <select id="sexo" name="sexo" type="text" autofocus="autofocus">
                <option value="">Seleccione una opción...</option>
                <option value="Hombre">Hombre</option>
                <option value="Mujer">Mujer</option>
            </select>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="poblacion">Población:</label>
        <div class="controls">
            <input type="text" id="poblacion" name="poblacion" size="15" placeholder="población" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="email">Em@il:</label>
        <div class="controls">
            <input type="text" id="email" name="email" size="15" placeholder="email" />
        </div>
    </div>
    
    <div class="control-group">
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>
