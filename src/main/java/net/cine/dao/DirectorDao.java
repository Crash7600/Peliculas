/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.dao;

import net.cine.helper.Conexion;
import net.cine.bean.DirectorBean;

/**
 *
 * @author Crash
 */
public class DirectorDao extends GenericDaoImplementation<DirectorBean>{
    
    public DirectorDao(Conexion.Tipo_conexion tipo_conexion) throws Exception {
        super(tipo_conexion, "director");
    }
    
}
