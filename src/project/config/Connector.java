package project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
    private  static Connector connector;
    Statement statement;
    public final static String connectString="jdbc:mysql://localhost:3306/T2008M";
    public final static String user="root";
    public final static String password="root";

    private Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection(connectString,user,password);
            setStatement(conn.createStatement());
        }catch (Exception e){

        }

    }
    public static Connector getInstance(){
        if (connector==null){
            connector=new Connector();
        }
        return connector;
    }

    public Statement getStatement(){
        return statement;
    }
    public void setStatement(Statement statement){
        this.statement=statement;
    }
}

