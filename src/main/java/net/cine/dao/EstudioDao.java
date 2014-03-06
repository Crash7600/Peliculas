/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.dao;

import net.cine.bean.EstudioBean;
import net.cine.helper.Conexion;

/**
 *
 * @author Crash
 */
public class EstudioDao extends GenericDaoImplementation<EstudioBean> {

    public EstudioDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "estudio");
    }

}
