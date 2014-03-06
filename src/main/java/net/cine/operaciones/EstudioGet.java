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
import net.cine.bean.EstudioBean;
import net.cine.dao.EstudioDao;
import net.cine.helper.Conexion;

public class EstudioGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;
        try {
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                EstudioDao oEstudioDAO = new EstudioDao(Conexion.getConection());
                EstudioBean oEstudio = new EstudioBean();
                oEstudio.setId(Integer.parseInt(request.getParameter("id")));
                oEstudioDAO.get(oEstudio);
                data = new Gson().toJson(oEstudio);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("EstudioGetJson: View Error: " + e.getMessage());
        }
    }
}
