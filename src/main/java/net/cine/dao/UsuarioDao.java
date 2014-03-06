/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.dao;

import net.cine.bean.UserBean;
import net.cine.bean.AdministradoresBean;
import net.cine.bean.UsuarioBean;
import net.cine.helper.Conexion;
import net.cine.helper.Enum;

/**
 *
 * @author rafa
 */
public class UsuarioDao extends GenericDaoImplementation<UsuarioBean> {

    public UsuarioDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "usuario");
    }

    public UsuarioBean getFromLogin(UsuarioBean oUsuario) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            String strId = oMysql.getId("usuario", "login", oUsuario.getLogin());
            if (strId == null) {
                oUsuario.setId(0);
            } else {
                oUsuario.setId(Integer.parseInt(strId));
                String pass = oUsuario.getPassword();
                oUsuario.setPassword(oMysql.getOne("usuario", "password", oUsuario.getId()));
                if (!pass.equals(oUsuario.getPassword())) {
                    oUsuario.setId(0);
                }
            }
            oMysql.desconexion();
            return oUsuario;
        } catch (Exception e) {
            throw new Exception("UsuarioDao.getFromLogin: Error: " + e.getMessage());
        }
    }

    public UsuarioBean type(UsuarioBean oUsuarioBean) throws Exception {

        try {
            UserDao oUserDao = new UserDao(enumTipoConexion);
            UserBean oUserBean = oUserDao.getFromId_usuario(oUsuarioBean);
            oUsuarioBean.setTipoUsuario(Enum.TipoUsuario.Usuario);
        } catch (Exception e1) {
            
                try {
                    AdministradoresDao oProfesorDao = new AdministradoresDao(enumTipoConexion);
                    AdministradoresBean oProfesorBean = oProfesorDao.getFromId_usuario(oUsuarioBean);
                    oUsuarioBean.setTipoUsuario(Enum.TipoUsuario.Administrador);
                } catch (Exception e3) {
                    throw new Exception("UsuarioDao.type: Error: " + e3.getMessage());
                }
            
        } finally {
            oMysql.desconexion();
        }
        return oUsuarioBean;
    }
 
    @Override
    public UsuarioBean get(UsuarioBean oUsuarioBean) throws Exception {
        if (oUsuarioBean.getId() > 0) {
            try {
                oMysql.conexion(enumTipoConexion);
                if (!oMysql.existsOne("usuario", oUsuarioBean.getId())) {
                    oUsuarioBean.setId(0);
                } else {
                    oUsuarioBean.setLogin(oMysql.getOne("usuario", "login", oUsuarioBean.getId()));
                    oUsuarioBean.setPassword(oMysql.getOne("usuario", "password", oUsuarioBean.getId()));
                }
            } catch (Exception e) {
                throw new Exception("UsuarioDao.getUsuario: Error: " + e.getMessage());
            } finally {
                oMysql.desconexion();
            }
        } else {
            oUsuarioBean.setId(0);
        }
        return oUsuarioBean;
    }

    
}
