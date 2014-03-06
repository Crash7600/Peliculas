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
import com.google.gson.GsonBuilder;
import net.cine.bean.UserBean;
import net.cine.dao.UserDao;
import net.cine.helper.Conexion;


public class UserGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                UserDao oUserDAO = new UserDao(Conexion.getConection());
                UserBean oUser = new UserBean();
                oUser.setId(Integer.parseInt(request.getParameter("id")));
                oUserDAO.get(oUser);
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oUser);
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("UserGetJson: View Error: " + e.getMessage());
        }
    }
}