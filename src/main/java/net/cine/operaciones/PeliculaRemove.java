/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.cine.bean.PeliculaBean;
import net.cine.dao.PeliculaDao;
import net.cine.helper.Conexion;

/**
 *
 * @author Daniel
 */
public class PeliculaRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            PeliculaDao oPeliculaDAO = new PeliculaDao(Conexion.getConection());
            PeliculaBean oPelicula = new PeliculaBean();                                           
            oPelicula.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oPelicula != null) {
                oPeliculaDAO.remove(oPelicula);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oPelicula.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("PeliculaRemoveJson: View Error: " + e.getMessage());
        }
    }
}
