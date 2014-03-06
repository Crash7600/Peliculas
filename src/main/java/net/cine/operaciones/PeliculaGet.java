/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.cine.bean.PeliculaBean;
import com.google.gson.Gson;
import net.cine.dao.PeliculaDao;
import net.cine.helper.Conexion;

/**
 *
 * @author Daniel
 */

public class PeliculaGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                PeliculaDao oPeliculaDAO = new PeliculaDao(Conexion.getConection());
                PeliculaBean oPelicula = new PeliculaBean();
                oPelicula.setId(Integer.parseInt(request.getParameter("id")));
                oPelicula = oPeliculaDAO.get(oPelicula);
                data = new Gson().toJson(oPelicula);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("PeliculaGetJson: View Error: " + e.getMessage());
        }
    }
}
