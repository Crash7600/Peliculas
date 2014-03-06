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
import net.cine.bean.GeneroBean;
import net.cine.dao.GeneroDao;
import net.cine.helper.Conexion;
import net.cine.helper.EncodingUtil;



/**
 *
 * @author Daniel
 */
public class GeneroSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            GeneroDao oGeneroDAO = new GeneroDao(Conexion.getConection());
            GeneroBean oGenero = new GeneroBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oGenero = gson.fromJson(jason, oGenero.getClass());
            Map<String, String> data = new HashMap<>();
            if (oGenero != null) {
                oGenero = oGeneroDAO.set(oGenero);
                data.put("status", "200");
                data.put("message", Integer.toString(oGenero.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("GeneroSaveJson: View Error: " + e.getMessage());
        }
    }
}
