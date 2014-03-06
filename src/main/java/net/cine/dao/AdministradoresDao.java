/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cine.dao;


import net.cine.bean.AdministradoresBean;
import net.cine.bean.UsuarioBean;
import net.cine.helper.Conexion;

/**
 *
 * @author AntonioNP
 */
public class AdministradoresDao extends GenericDaoImplementation<AdministradoresBean>{
    
    public AdministradoresDao(Conexion.Tipo_conexion tipo_conexion) throws Exception{
        super(tipo_conexion, "administradores");
    }
    
    public AdministradoresBean getFromId_usuario(UsuarioBean oUsuarioBean) throws Exception {
        AdministradoresBean oAdministradoresBean = new AdministradoresBean();
        if (oUsuarioBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                String id_usuario = Integer.toString(oUsuarioBean.getId());
                Integer id_user = Integer.parseInt(oMysql.getId("administradores", "id_usuario", id_usuario));
                oAdministradoresBean.setId(id_user);
            } catch (Exception e) {
                throw new Exception("AdministradoresDao.getAdministradores: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oAdministradoresBean.setId(0);
        }
        return oAdministradoresBean;
    }
}