
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Oracle
 */
public class ConnectionDataBase {
    private String URL;
    private String DRIVER_CLASS;
    private String USER;
    private String PASS;
    private String query;
    private List<String> attributes;
    private Connection conexao;

    public ConnectionDataBase(String bd, String user, String pwd, List<String> attributes, Connection conexao){
        
        this.conexao = conexao;
        this.attributes = attributes;
        
        if(bd.equals("MYSQL")){
            this.URL = "jdbc:mysql://localhost:3306/schema1";
            this.DRIVER_CLASS = "com.mysql.jdbc.Driver";
            this.USER = user;
            this.PASS = pwd;
        }else if(bd.equals("ORACLE")){
            this.URL = "jdbc:oracle:thin:@localhost:1521:XE";
            this.DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
            this.USER = user;
            this.PASS = pwd;
        }
    }

    public void getConnection(String bd) throws SQLException{

        System.out.println("Conectando ao Banco de Dados");
        try{
            conexao =  DriverManager.getConnection(this.DRIVER_CLASS, this.USER, this.PASS);
            System.out.println(conexao.toString());
        
            if(bd.equals("MYSQL")){
    //              MySQLConnection.select(query, attributes, conexao);
            }else if(bd.equals("ORACLE")){
    //            OracleConnection.select(query, attributes, conexao);
            }
            
        }catch(SQLException sqex){
            sqex.getMessage();
        }finally{
            this.conexao.close();
        }

    }

    public String getURL(){
        return this.URL;
    }
    
    public String getUser(){
        return this.USER;
    }
    
    public String getPwd(){
        return this.PASS;
    }
    
    public String getDriver(){
        return this.DRIVER_CLASS;
    }
}
