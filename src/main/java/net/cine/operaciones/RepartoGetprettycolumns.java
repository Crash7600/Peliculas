/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.operaciones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Daniel
 */
public class RepartoGetprettycolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String data = "{\"data\": [\"id\", \"Nombre\", \"Fecha Nacimiento\", \"Ciudad\"]}";
            return data;
        } catch (Exception e) {
            throw new ServletException("RepartoGetpagesJson: View Error: " + e.getMessage());
        }
    }
}
