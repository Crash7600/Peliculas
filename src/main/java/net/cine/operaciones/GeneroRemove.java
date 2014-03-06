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
import net.cine.bean.GeneroBean;
import net.cine.dao.GeneroDao;
import net.cine.helper.Conexion;



/**
 *
 * @author Daniel
 */
public class GeneroRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            GeneroDao oGeneroDAO = new GeneroDao(Conexion.getConection());
            GeneroBean oGenero = new GeneroBean();                                           
            oGenero.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oGenero != null) {
                oGeneroDAO.remove(oGenero);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oGenero.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("GeneroRemoveJson: View Error: " + e.getMessage());
        }
    }
}
