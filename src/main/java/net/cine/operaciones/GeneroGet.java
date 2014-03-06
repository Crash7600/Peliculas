/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

/**
 *
 * @author Daniel
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import net.cine.bean.GeneroBean;
import net.cine.dao.GeneroDao;
import net.cine.helper.Conexion;


public class GeneroGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                GeneroDao oGeneroDAO = new GeneroDao(Conexion.getConection());
                GeneroBean oGenero = new GeneroBean();
                oGenero.setId(Integer.parseInt(request.getParameter("id")));
                oGeneroDAO.get(oGenero);
                data = new Gson().toJson(oGenero);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("GeneroGetJson: View Error: " + e.getMessage());
        }
    }
}