/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import net.cine.helper.Conexion;

public class DataSourceConnection implements GenericConnection {

    @Override
    public Connection crearConexion() {
        try {   
            InitialContext initialContext=new InitialContext();
            DataSource dataSource=(DataSource) initialContext.lookup("java:comp/env/jdbc/" + Conexion.getDatabaseName());
            Connection connection=dataSource.getConnection();
            return connection;
        } catch (NamingException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}

