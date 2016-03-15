package com.dodecahedron.lomonosov.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dodecahedron.lomonosov.connection.DBWorker;

public class UserBean {
    private int id = 0;
    private String login = "";
    private String password = "";
    private String email ="";
    private static final String addUser = "INSERT INTO lomonosov.users(login,password,email) VALUES(?,?,?)";
    private static final String takePass = "SELECT password FROM lomonosov.users WHERE login=?;";
    private static final String takeData = "SELECT * FROM lomonosov.users WHERE login=?;";

    public UserBean(String login, String password, String email){}
    public UserBean(String login,String password){ this.login=login; this.password=password;} //конструктор для авторизации

    public UserBean(String login, String password, String email, String lastname, String firstname, String middlename, String city, String job, String promo, String phone, String birthdate) {
        this.login = login; //конструктор для регистрации
        this.password = password;
        this.email = email;

    }
    public Boolean logIn(){
        return (checkPassword() && takeData());
    }

    public Boolean addUser(){
        Boolean result=false;
        DBWorker worker = new DBWorker();
        try {
            PreparedStatement preparedStatement = worker.getConnection().prepareStatement(addUser);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);

            if (preparedStatement.executeUpdate()==1)
                result=true;
            worker.getConnection().close();//закрываем connection
        } catch (SQLException e) {
            result=false;
            e.printStackTrace();
        }
        return result;
    }
    public Boolean checkPassword() {
        DBWorker worker = new DBWorker();
        Boolean result = false;
        if (login != null) {
            try {
                PreparedStatement preparedStatement = worker.getConnection().prepareStatement(takePass);
                preparedStatement.setString(1, this.login);
                ResultSet res = preparedStatement.executeQuery(); //отправляем запрос
                if ((res.next()) && (res.getString("password").equals(this.password))) //сравниваем пароль с тем, что пришло от клиента,если первое условие выдает false, то второе уже не проверяется
                    result = true;
                else
                    result = false;
                worker.getConnection().close();//закрываем connection
            } catch (SQLException e) {
                result=false;
                e.printStackTrace();
            }
        }
        return result;
    }



    Boolean takeData(){
         DBWorker worker = new DBWorker();
         Boolean result = false;
         try {
             PreparedStatement preparedStatement = worker.getConnection().prepareStatement(takeData);
             preparedStatement.setString(1, this.login);
             ResultSet res = preparedStatement.executeQuery(); //отправляем запрос
             if (res.next()) {
                 result = true;
                 this.id=res.getInt("id");

                 this.email=res.getString("email");

             }
             else
                 result = false;
             worker.getConnection().close();//закрываем connection
         } catch (SQLException e) {
             result=false;
             e.printStackTrace();
         }
         return result;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}