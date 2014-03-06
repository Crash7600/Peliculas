/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

/**
 *
 * @author Crash
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.cine.bean.DirectorBean;
import net.cine.dao.DirectorDao;
import net.cine.helper.Conexion;


public class DirectorGet implements GenericOperation {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;
        try {
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                DirectorDao oDirectorDAO = new DirectorDao(Conexion.getConection());
                DirectorBean oDirector = new DirectorBean();
                oDirector.setId(Integer.parseInt(request.getParameter("id")));
                oDirectorDAO.get(oDirector);
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oDirector);
                
                
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("DirectorGetJson: View Error: " + e.getMessage());
        }
    }
    
}