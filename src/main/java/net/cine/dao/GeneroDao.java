/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.dao;

import net.cine.bean.GeneroBean;
import net.cine.helper.Conexion;

/**
 *
 * @author Diana Ortega
 */
public class GeneroDao extends GenericDaoImplementation<GeneroBean> {
    
     public GeneroDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion,"genero");
    }
    
}
