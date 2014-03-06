/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.dao;

import net.cine.bean.RepartoBean;
import net.cine.helper.Conexion;

/**
 *
 * @author Daniel
 */
public class RepartoDao extends GenericDaoImplementation<RepartoBean> {

    public RepartoDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "reparto");
    }

}
