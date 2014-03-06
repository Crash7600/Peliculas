<%-- 
    Document   : form
    Created on : Jan 21, 2013, 10:24:17 AM
    Author     : al037805
--%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Director</h2>
    <div class="control-group">
        <label class="control-label" for="id">Id:</label>
        <div class="controls">
            <input type="text" id="id" name="id" placeholder="id" />
        </div>
    </div>
    
    <div class="control-group">
        <label class="control-label"  for="nombredirector">Nombre:</label>
        <div class="controls">
            <input type="text" id="nombredirector" name="nombredirector" size="15" placeholder="nombredirector" />
        </div>
    </div>
    
    <div class="control-group">
        <label class="control-label"  for="nacionalidad">Nacionalidad:</label>
        <div class="controls">
            <input type="text" id="nacionalidad" name="nacionalidad" size="15" placeholder="nacionalidad" />
        </div>
    </div>
     
    <div class="control-group">
        <label class="control-label" for="descripcion">Año de inicio: </label> 
        <div class="controls">
            <input id="anyoinicio" name="anyoinicio" type="text" size="10" maxlength="50" value="" /> 
        </div>
    </div>
    <script>$("#anyoinicio").datepicker({
            showOn: 'both',
            buttonImageOnly: true,
            changeYear: true,
            numberOfMonths: 1});
    </script>
    
    
    <div class="control-group">
        <label class="control-label" for="descripcion">Año de fin: </label> 
        <div class="controls">
            <input id="anyofin" name="anyofin" type="text" size="10" maxlength="50" value="" /> 
        </div>
    </div>
    <script>$("#anyofin").datepicker({
            showOn: 'both',
            buttonImageOnly: true,
            changeYear: true,
            numberOfMonths: 1});
    </script>
    
    <div class="control-group">
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>
<script>
    $(function() {
        $("#datepicker").datepicker();
    });
</script>
