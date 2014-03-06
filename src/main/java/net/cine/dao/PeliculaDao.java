/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.dao;

import net.cine.bean.PeliculaBean;
import net.cine.helper.Conexion;

/**
 *
 * @author Daniel
 */
public class PeliculaDao extends GenericDaoImplementation<PeliculaBean> {

    public PeliculaDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "pelicula");
    }
}
