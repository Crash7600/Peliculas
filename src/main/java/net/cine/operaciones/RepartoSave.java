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
import net.cine.bean.RepartoBean;
import net.cine.dao.RepartoDao;
import net.cine.helper.Conexion;
import net.cine.helper.EncodingUtil;



/**
 *
 * @author Daniel
 */
public class RepartoSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            RepartoDao oRepartoDAO = new RepartoDao(Conexion.getConection());
            RepartoBean oReparto = new RepartoBean();
            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oReparto = gson.fromJson(jason, oReparto.getClass());
            Map<String, String> data = new HashMap<>();
            if (oReparto != null) {
                oReparto = oRepartoDAO.set(oReparto);
                data.put("status", "200");
                data.put("message", Integer.toString(oReparto.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("RepartoSaveJson: View Error: " + e.getMessage());
        }
    }
}
