/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class PeliculaGetprettycolumns implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String data = "{\"data\": [\"id\", \"Nombre Pelicula\", \"Año\", \"Ciudad\", \"Website\", \"Duracion\", \"Puntuacion\", \"Site\", \"Genero id\"]}";
            return data;
        } catch (Exception e) {
            throw new ServletException("PeliculaGetprettycolumnsJson: View Error: " + e.getMessage());
        }
    }
}
