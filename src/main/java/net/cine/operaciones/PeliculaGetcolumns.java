/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.cine.dao.PeliculaDao;
import net.cine.helper.Conexion;

/**
 *
 * @author Daniel
 */
public class PeliculaGetcolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<String> alColumns = null;
        try {
            PeliculaDao oPeliculaDAO = new PeliculaDao(Conexion.getConection());
            alColumns = oPeliculaDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return data;
        } catch (Exception e) {
            throw new ServletException("PeliculaGetcolumnsJson: View Error: " + e.getMessage());
        }
    }
}

