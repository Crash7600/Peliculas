/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.dao;

import net.cine.bean.UserBean;
import net.cine.bean.UsuarioBean;
import net.cine.helper.Conexion;

/**
 *
 * @author Sergio
 */
public class UserDao extends GenericDaoImplementation<UserBean> {

    public UserDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "user");
    }

    public UserBean getFromId_usuario(UsuarioBean oUsuarioBean) throws Exception {
        UserBean oUserBean = new UserBean();
        if (oUsuarioBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                String id_usuario = Integer.toString(oUsuarioBean.getId());
                Integer id_user = Integer.parseInt(oMysql.getId("user", "id_usuario", id_usuario));
                oUserBean.setId(id_user);
            } catch (Exception e) {
                throw new Exception("UserDao.getUser: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oUserBean.setId(0);
        }
        return oUserBean;
    }
}
