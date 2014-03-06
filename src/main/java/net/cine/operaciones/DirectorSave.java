/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.cine.bean.DirectorBean;
import net.cine.dao.DirectorDao;
import net.cine.helper.Conexion;
import net.cine.helper.EncodingUtil;



/**
 *
 * @author Crash
 */
public class DirectorSave implements GenericOperation {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            DirectorDao oDirectorDAO = new DirectorDao(Conexion.getConection());
            DirectorBean oDirector = new DirectorBean();
            Gson gson=  new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oDirector = gson.fromJson(jason, oDirector.getClass());
            Map<String, String> data = new HashMap<>();
            if (oDirector != null) {
                oDirector = oDirectorDAO.set(oDirector);
                data.put("status", "200");
                data.put("message", Integer.toString(oDirector.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("DirectorSaveJson: View Error: " + e.getMessage());
        }
    }
    
}
