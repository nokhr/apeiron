package com.dodecahedron.lomonosov.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Krist on 05.04.2015.
 */
public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/lomonosov";  //хардкодим параметры базы, она у нас будет одна, так что вроде норм
    private static final String USERNAME = "root";
    private static final String PASSWORD = "5rdxsz12";

    Connection connection = null;
    public DBWorker(){
        Connection connection = null;
        try {
            System.out.println("Loading driver..."); //Это все копипаста, чисто для проверки драйвера, можно удалить
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
    }

    public Connection getConnection(){ //перекинул сюда
        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }
        if(connection==null)
            System.out.print("Connetion is null"); // это тоже формальность
        return connection;
    }
}
