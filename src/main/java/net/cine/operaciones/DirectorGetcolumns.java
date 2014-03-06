/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.cine.dao.DirectorDao;
import net.cine.helper.Conexion;


/**
 *
 * @author Crash
 */
public class DirectorGetcolumns implements GenericOperation {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<String> alColumns = null;
        try {
            DirectorDao oDirectorDAO = new DirectorDao(Conexion.getConection());
            alColumns = oDirectorDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return data;
            
        } catch (Exception e) {
            throw new ServletException("DirectorGetcolumnsJson: View Error: " + e.getMessage());
        }
    }
    
}
