<%-- 
    Document   : form
    Created on : Jan 21, 2013, 10:24:17 AM
    Author     : Daniel
--%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Estudio</h2>
    <div class="control-group">
        <label class="control-label" for="id">Id:</label>
        <div class="controls">
            <input id="id" name="id" placeholder="id" />
        </div>
    </div>        
    <div class="control-group">
        <label class="control-label"  for="nombre">Nombre:</label>
        <div class="controls">
            <input type="text" id="nombre" name="nombre" size="15" placeholder="nombre" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="ciudad">Ciudad:</label>
        <div class="controls">
            <input type="text" id="ciudad" name="ciudad" size="15" placeholder="ciudad" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="telefono">Telefono:</label>
        <div class="controls">
            <input type="text" id="telefono" name="telefono" size="15" placeholder="telefono" />
        </div>
    </div>


    <div class="control-group">
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>

