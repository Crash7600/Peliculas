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
import net.cine.bean.EstudioBean;
import net.cine.dao.EstudioDao;
import net.cine.helper.Conexion;



/**
 *
 * @author Daniel
 */
public class EstudioRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            EstudioDao oEstudioDAO = new EstudioDao(Conexion.getConection());
            EstudioBean oEstudio = new EstudioBean();                                           
            oEstudio.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oEstudio != null) {
                oEstudioDAO.remove(oEstudio);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oEstudio.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("EstudioRemoveJson: View Error: " + e.getMessage());
        }
    }
}
