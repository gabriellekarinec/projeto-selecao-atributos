/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Resultado;
/**
 *
 * @author augusto
 */
public class MySQLConnection {
    public static Resultado select(String where, List<String> attributes) throws ClassNotFoundException, SQLException{
       // String query = "select id_book, author, volume1, title, institution, venue, address, publisher, year1, pages, editor, note, month1, class1 from book";
		List<Book> retorno = new ArrayList<Book>();
                List<String> attrs = new ArrayList<String>();
                Class.forName("com.mysql.jdbc.Driver");
//		"jdbc:mysql://hostname:port/dbname"
		String URL = "jdbc:mysql://localhost:3306/BANCO_PROJETO";
		String USER = "root";//COLOCAR USERNAME
		String PASS = "";//COLOCAR PWD
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                ResultSetMetaData rsmd = null;
               
		
                        conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
                        String query = "select * from book " + where;
                        System.out.println(query);
			rs = stmt.executeQuery(query);
                        rsmd = rs.getMetaData();

			while (rs.next()) {//dentro desse while aparece cada linha
                            
                            String id;
                            String author;
                            String volume;
                            String title;
                            String institution;
                            String venue;
                            String address;
                            String publisher;
                            String year;
                            String pages;
                            String editor;
                            String note;
                            String month;
                            String classe;
                            
                            /*if(!attributes.isEmpty()){
        				//COLOCAR AQUI AS VARIAVEIS
                                if(attributes.contains("id")){
        				id = rs.getInt("id");
                                }if(attributes.contains("author")){
                        		author = rs.getString("author");
                                }if(attributes.contains("volume")){
                                    volume = rs.getString("volume");
                                }if(attributes.contains("title")){
                                    title = rs.getString("title");
                                }if(attributes.contains("institution")){
                                    institution = rs.getString("institution");
                                }if(attributes.contains("venue")){
                                    venue = rs.getString("venue");
                                }if(attributes.contains("address")){
                                    address = rs.getString("address");
                                }if(attributes.contains("publisher")){
                                    publisher = rs.getString("publisher");
                                }if(attributes.contains("year")){
                                    year = rs.getString("year");
                                }if(attributes.contains("pages")){
                                    pages = rs.getString("pages");
                                }if(attributes.contains("editor")){
                                    editor = rs.getString("editor");
                                }if(attributes.contains("note")){
                                    note = rs.getString("note");
                                }if(attributes.contains("month")){
                                    month = rs.getString("month");
                                }if(attributes.contains("class")){
                                    classe = rs.getString("class");
                                }
                            }else{*/
                                    id = rs.getString("id");
                                    author = rs.getString("author");
                                    volume = rs.getString("volume");
                                    title = rs.getString("title");
                                    institution = rs.getString("institution");
                                    venue = rs.getString("venue");
                                    address = rs.getString("address");
                                    publisher = rs.getString("publisher");
                                    year = rs.getString("year");
                                    pages = rs.getString("pages");
                                    editor = rs.getString("editor");
                                    note = rs.getString("note");
                                    month = rs.getString("month");
                                    classe = rs.getString("class");
                           // }
                                
                                /*System.out.println(id);
                                System.out.println(author);
                                System.out.println(volume);
                                System.out.println(title);
                                System.out.println(institution);
                                System.out.println(venue);
                                System.out.println(address);
                                System.out.println(publisher);
                                System.out.println(year1);
                                System.out.println(pages);
                                System.out.println(editor);
                                System.out.println(note);
                                System.out.println(month);
                                System.out.println(classe);*/
                               retorno.add(new Book(id, author, volume, title, institution, venue, address,
                                    publisher, year, pages, editor, note, month, classe, 1)); 
			}
     
                    conn.close();
                    stmt.close();
                    rs.close();        
                
                    
                    String URL2 = "jdbc:mysql://localhost:3306/BANCO_PROJETO2";
                    String USER2 = "root";//COLOCAR USERNAME
                    String PASS2 = "";//COLOCAR PWD
                    Connection conn2 = null;
                    Statement stmt2 = null;
                    ResultSet rs2 = null;
                    ResultSetMetaData rsmd2 = null;
                    
                    conn2  = DriverManager.getConnection(URL2, USER2, PASS2);
                    stmt2 = conn2.createStatement();
                    
                    String query2 = "select * from book " + where;
                    System.out.println(query2);                   
                    rs2 = stmt2.executeQuery(query2);  
                    rsmd2 = rs2.getMetaData();

                    while (rs2.next()) {//dentro desse while aparece cada linha
                            
                        String id2;
                        String author2;
                        String volume2;
                        String title2;
                        String institution2;
                        String venue2;
                        String address2;
                        String publisher2;
                        String year2;
                        String pages2;
                        String editor2;
                        String note2;
                        String month2;
                        String classe2;
                            
                        id2 = rs2.getString("id");
                        author2 = rs2.getString("author");
                        volume2 = rs2.getString("volume");
                        title2 = rs2.getString("title");
                        institution2 = rs2.getString("institution");
                        venue2 = rs2.getString("venue");
                        address2 = rs2.getString("address");
                        publisher2 = rs2.getString("publisher");
                        year2 = rs2.getString("year");
                        pages2 = rs2.getString("pages");
                        editor2 = rs2.getString("editor");
                        note2 = rs2.getString("note");
                        month2 = rs2.getString("month");
                        classe2 = rs2.getString("class");
                           
                        retorno.add(new Book(id2, author2, volume2, title2, institution2, venue2, address2,
                            publisher2, year2, pages2, editor2, note2, month2, classe2, 2)); 
                        
                    }
                    
                     for(int x=1; x <= rsmd2.getColumnCount(); x++ ){
//                        System.out.println(rsmd.getColumnName(x));
                        attrs.add(rsmd2.getColumnName(x));
                    }
                    if(attributes.isEmpty()){
                        attributes = attrs;
                    }

                    conn2.close();
                    stmt2.close();
                    rs2.close();
                    
                   
                for(Book book : retorno){
                    System.out.println(book.get("author"));
                }
                return new Resultado(retorno, attrs, attributes);
	}
}
