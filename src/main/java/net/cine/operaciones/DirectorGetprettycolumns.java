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
 * @author Crash
 */
public class DirectorGetprettycolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String data = "{\"data\": [\"id\", \"nombre\", \"nacionalidad\", \"año inicio\", \"año fin\"]}";
            return data;
        } catch (Exception e) {
            throw new ServletException("DirectorGetpagesJson: View Error: " + e.getMessage());
        }
    }
}
