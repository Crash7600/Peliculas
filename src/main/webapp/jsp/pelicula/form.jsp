<%-- 
    Document   : form
    Created on : 24-ene-2014, 11:23:46
    Author     : al037877
--%>

<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <fieldset>
        <div class="control-group">
            <label class="control-label" for="id">Id: </label>
            <div class="controls">
                <input id="id" name="id" type="text" size="30" maxlength="50" />
            </div>
        </div>        
        
        
        <div class="control-group">
            <label class="control-label"  for="nombre_pelicula">Nombre Pelicula:</label>
            <div class="controls">
                <input type="text" id="nombre_pelicula" name="nombre_pelicula" size="15" placeholder="nombre_pelicula" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label"  for="anyo">Año:</label>
            <div class="controls">
                <input type="text" id="anyo" name="anyo" size="15" placeholder="anyo" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="ciudad">Ciudad: </label>
            <div class="controls">
                <input id="ciudad" name="ciudad" type="text" size="30" maxlength="50" placeholder="ciudad"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="website">Website: </label>
            <div class="controls">
                <input id="website" name="website" type="text" size="30" maxlength="50" placeholder="website"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="duracion">Duracion: </label>
            <div class="controls">
                <input id="duracion" name="duracion" type="text" size="30" maxlength="50" placeholder="duracion"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="puntuacion">Puntuacion: </label>
            <div class="controls">
                <input id="puntuacion" name="puntuacion" type="text" size="30" maxlength="50" placeholder="puntuacion"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="url">URL de la Pelicula: </label>
            <div class="controls">
                <input id="url" name="url" type="text" size="30" maxlength="50" placeholder="url"/>
            </div>
        </div>
        
        
        <div class="control-group">
        <label class="control-label"  for="id_genero">Genero Id:</label>
        <div class="controls">
            <input readonly="true" id="id_genero" class="input-mini"
                       name="id_genero" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_genero_button" href="#"><i class="icon-search"></i></a>
        </div>
        </div>
    
        <div class="control-group">
            <div class="controls">
                <span id="id_genero_desc" class="alert alert-success"></span>                                       
            </div>
        </div> 
        
        
        <div class="control-group">
            <div class="controls">
                <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
            </div>
        </div>
    </fieldset>
</form>