/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.config;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author farhannivta
 */
public class Database {
    public static String host;
    public static String user;
    public static String password;
    public static String name;
    
    public static void init() {
        Properties props = new Properties();

        try (InputStream input = Database.class.getClassLoader().getResourceAsStream("config.properties");
) {
            if (input == null) {
                System.out.println("File config.properties tidak ditemukan.");
                return;
            }

            props.load(input);
            
            String host = props.getProperty("DB_HOST");
            String user = props.getProperty("DB_USER");
            String pass = props.getProperty("DB_PASSWORD");
            String name = props.getProperty("DB_NAME");
            
            Database.host = (host != null) ? host : "";
            Database.user = (user != null) ? user : "";
            Database.password = (password != null) ? password : "";
            Database.name = (name != null) ? name : "";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
