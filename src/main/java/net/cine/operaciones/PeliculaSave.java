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
import net.cine.bean.PeliculaBean;
import net.cine.dao.PeliculaDao;
import net.cine.helper.Conexion;
import net.cine.helper.EncodingUtil;

/**
 *
 * @author Daniel
 */
public class PeliculaSave implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            PeliculaDao oPeliculaDAO = new PeliculaDao(Conexion.getConection());
            PeliculaBean oPelicula = new PeliculaBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oPelicula = gson.fromJson(jason, oPelicula.getClass());
            Map<String, String> data = new HashMap<>();
            if (oPelicula != null) {
                oPeliculaDAO.set(oPelicula);
                data.put("status", "200");
                data.put("message", Integer.toString(oPelicula.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("PeliculaSaveJson: View Error: " + e.getMessage());
        }
    }
}
