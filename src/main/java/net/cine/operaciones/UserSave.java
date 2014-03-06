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
import net.cine.bean.UserBean;
import net.cine.dao.UserDao;
import net.cine.helper.Conexion;
import net.cine.helper.EncodingUtil;

/**
 *
 * @author Daniel
 */
public class UserSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            UserDao oUserDAO = new UserDao(Conexion.getConection());
            UserBean oUser = new UserBean();
            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oUser = gson.fromJson(jason, oUser.getClass());
            Map<String, String> data = new HashMap<>();
            if (oUser != null) {
                oUser = oUserDAO.set(oUser);
                data.put("status", "200");
                data.put("message", Integer.toString(oUser.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("UserSaveJson: View Error: " + e.getMessage());
        }
    }
}
