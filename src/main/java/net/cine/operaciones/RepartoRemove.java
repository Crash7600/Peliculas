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
import net.cine.bean.RepartoBean;
import net.cine.dao.RepartoDao;
import net.cine.helper.Conexion;



/**
 *
 * @author Daniel
 */
public class RepartoRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            RepartoDao oRepartoDAO = new RepartoDao(Conexion.getConection());
            RepartoBean oReparto = new RepartoBean();                                           
            oReparto.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oReparto != null) {
                oRepartoDAO.remove(oReparto);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oReparto.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("RepartoRemoveJson: View Error: " + e.getMessage());
        }
    }
}
