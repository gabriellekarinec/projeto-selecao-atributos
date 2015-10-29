
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Gabrielle
 */

public class OracleConnection {
	
    public static void select(String query, List<String> attributes) throws ClassNotFoundException, SQLException{
       // String query = "select id_book, author, volume1, title, institution, venue, address, publisher, year1, pages, editor, note, month1, class1 from book";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//		"jdbc:oracle:thin:@hostname:1521:database_name";
		String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		String USER = "BANCO_PROJETO";//COLOCAR USERNAME
		String PASS = "projeto";//COLOCAR PWD
		Connection conn = DriverManager.getConnection(URL, USER, PASS);

		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
                        
                        ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {//dentro desse while aparece cada linha
                            
                            int id;
                            String author;
                            String volume1;
                            String title;
                            String institution;
                            String venue;
                            String address;
                            String publisher;
                            String year1;
                            String pages;
                            String editor;
                            String note;
                            String month1;
                            String class1;
                            
                            if(!attributes.isEmpty()){
        				//COLOCAR AQUI AS VARIAVEIS
                                if(attributes.contains("id_book")){
        				id = rs.getInt("id_book");
                                }if(attributes.contains("author")){
                        		author = rs.getString("author");
                                }if(attributes.contains("volume1")){
                                    volume1 = rs.getString("volume1");
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
                                }if(attributes.contains("year1")){
                                    year1 = rs.getString("year1");
                                }if(attributes.contains("pages")){
                                    pages = rs.getString("pages");
                                }if(attributes.contains("editor")){
                                    editor = rs.getString("editor");
                                }if(attributes.contains("note")){
                                    note = rs.getString("note");
                                }if(attributes.contains("month1")){
                                    month1 = rs.getString("month1");
                                }if(attributes.contains("class1")){
                                    class1 = rs.getString("class1");
                                }
                            }else{
                                    id = rs.getInt("id_book");
                                    author = rs.getString("author");
                                    volume1 = rs.getString("volume1");
                                    title = rs.getString("title");
                                    institution = rs.getString("institution");
                                    venue = rs.getString("venue");
                                    address = rs.getString("address");
                                    publisher = rs.getString("publisher");
                                    year1 = rs.getString("year1");
                                    pages = rs.getString("pages");
                                    editor = rs.getString("editor");
                                    note = rs.getString("note");
                                    month1 = rs.getString("month1");
                                    class1 = rs.getString("class1");
                            }
                                
                                /*System.out.println(id);
                                System.out.println(author);
                                System.out.println(volume1);
                                System.out.println(title);
                                System.out.println(institution);
                                System.out.println(venue);
                                System.out.println(address);
                                System.out.println(publisher);
                                System.out.println(year1);
                                System.out.println(pages);
                                System.out.println(editor);
                                System.out.println(note);
                                System.out.println(month1);
                                System.out.println(class1);*/
                                
			}
                           
                    for(int x=1; x<= rsmd.getColumnCount(); x++ ){
                                    System.out.println(rsmd.getColumnName(x));
                                }
		}finally{
                 
			conn.close();
		}
	}
}
