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
import net.cine.helper.EncodingUtil;



/**
 *
 * @author Daniel
 */
public class EstudioSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            EstudioDao oEstudioDAO = new EstudioDao(Conexion.getConection());
            EstudioBean oEstudio = new EstudioBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oEstudio = gson.fromJson(jason, oEstudio.getClass());
            Map<String, String> data = new HashMap<>();
            if (oEstudio != null) {
                oEstudio = oEstudioDAO.set(oEstudio);
                data.put("status", "200");
                data.put("message", Integer.toString(oEstudio.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("EstudioSaveJson: View Error: " + e.getMessage());
        }
    }
}
