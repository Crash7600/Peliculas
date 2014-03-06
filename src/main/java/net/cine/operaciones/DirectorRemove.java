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
import net.cine.bean.DirectorBean;
import net.cine.dao.DirectorDao;
import net.cine.helper.Conexion;



/**
 *
 * @author Crash
 */
public class DirectorRemove implements GenericOperation {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            DirectorDao oEntregaDAO = new DirectorDao(Conexion.getConection());
            DirectorBean oDirector = new DirectorBean();                                           
            oDirector.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oDirector != null) {
                oEntregaDAO.remove(oDirector);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oDirector.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("DirectorRemoveJson: View Error: " + e.getMessage());
        }
    }
    
}
