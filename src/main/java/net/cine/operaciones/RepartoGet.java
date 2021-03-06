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
import net.cine.bean.RepartoBean;
import net.cine.dao.RepartoDao;
import net.cine.helper.Conexion;

public class RepartoGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;
        try {
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                RepartoDao oRepartoDAO = new RepartoDao(Conexion.getConection());
                RepartoBean oReparto = new RepartoBean();
                oReparto.setId(Integer.parseInt(request.getParameter("id")));
                oRepartoDAO.get(oReparto);
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oReparto);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("RepartoGetJson: View Error: " + e.getMessage());
        }
    }
}
