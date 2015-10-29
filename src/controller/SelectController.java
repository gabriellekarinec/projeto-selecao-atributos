package controller;

import dao.MySQLConnection;
import java.sql.SQLException;

import dao.OracleConnection;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Resultado;
import sun.applet.Main;

public class SelectController {
        public static List<String> InterestedAttributes(String query){
            List<String> retorno = new ArrayList<String>();
                    
            String sql = query.toLowerCase();
            int idxSelect = sql.indexOf("select") + 6; // +6 porque ele retorna o indice do inicio da string
            int idxFrom =  sql.indexOf("from");
            String attributes = query.substring(idxSelect, idxFrom) ; 
            if(!attributes.contains("*")){
                for(int i = 0; i < attributes.split(",").length; i++){
                    retorno.add(attributes.split(",")[i]);
                }
            }
            
            return retorno;
        }
	public Resultado SelectWithQueryField(String queryField) throws ClassNotFoundException, SQLException{
                List<String> atributos = InterestedAttributes(queryField);
//                for(String att:atributos){
//                    System.out.println(att);
//                }
                String where = getWhere(queryField);
//		OracleConnection.select(queryField, atributos);//colocar o retorno auqui
                Resultado retorno = MySQLConnection.select(where, atributos);
		//o retorno vai ser todos os campos e vai ser chamado a classe de resolução
                return retorno;
	}
        
        public static String getWhere(String query){
            if(query.contains("where")){
                int idx = query.indexOf("where");
                String retorno = query.substring(idx, query.length());
                System.out.println(retorno);
            
                return retorno;
            }else{
                return "";
            }
        }
        
}
