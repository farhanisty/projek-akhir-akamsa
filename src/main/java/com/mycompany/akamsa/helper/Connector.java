/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.helper;

import com.mycompany.akamsa.config.Database;
import java.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;


/**
 *
 * @author farhannivta
 */
public class Connector {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException {
        if(Connector.connection == null) {
            MysqlDataSource datasource = new MysqlDataSource();
            
            datasource.setServerName(Database.host);
            datasource.setUser(Database.user);
            datasource.setPassword(Database.password);
            datasource.setDatabaseName(Database.name);
            

            Connector.connection = datasource.getConnection();

        }
        
        return Connector.connection;
    }
}
