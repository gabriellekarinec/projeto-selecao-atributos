/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resultado {
    private final double PESO = 0.5;
    private List<Book> books;
    private List<String> atributos;
    private List<String> atributosToShow;

    public Resultado(List<Book> books,List<String> atributos,List<String> atributosToShow){
        this.books = books;
        this.atributos = atributos;
        this.atributosToShow = atributosToShow;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<String> getAtributos() {
        return atributos;
    }

    public List<String> getAtributosToShow() {
        return atributosToShow;
    }
    
    public List<Book> getBooksFromSchema(int schema){
        List<Book> retorno = new ArrayList<Book>();
        for(Book book : books){
            if(book.getSchemaNumber() == schema){
                retorno.add(book);
            }
        }
        return retorno;
    }
    
    //Aqui fica o resultado para cada lista de schema e mapeado pra cada
    //atributo
    public Map<String, Integer> nullQuantities(List<Book> books){
        Map<String, Integer> retorno = new HashMap<String, Integer>();
        for(Book book : books){
            for(String att : atributos){
                if(!retorno.containsKey(att)){
                    retorno.put(att, 0);
                }else{
                    String valor = book.get(att);
                    if((valor == null) || valor.contains("null") || valor.isEmpty())
                        retorno.put(att, retorno.get(att)+1);
                }
            }
        }    
        return retorno;
    }
    
    public Map<String, Integer> repQuantities(List<Book> books){
        Map<String, Integer> retorno = new HashMap<String, Integer>();
        List<String> reps = new ArrayList<String>();
        for(Book book : books){
            for(String att : atributos){
                if(!retorno.containsKey(att)){
                    retorno.put(att, 0);
                }else{
                    String valor = book.get(att);
                    if(reps.contains(valor)){
                        retorno.put(att, retorno.get(att)+1);
                    }else{
                        reps.add(valor);
                    }
                }
            }
        }    
        return retorno;
    }
    
    public Map<String, Double> calculateForSchema(int schema){
        List<Book> books = getBooksFromSchema(schema);
        Map<String, Integer> values = nullQuantities(books);
        Map<String, Integer> valuesRep = repQuantities(books);
        double calcNull = 0;
        double calcRep = 0;
        Map<String, Double> retorno = new HashMap<String, Double>();
        
        for(String atr : this.atributos){
            double value = ((double)values.get(atr)/books.size()) * PESO;
            double valueRep = ((double)valuesRep.get(atr)/books.size()) * PESO;
            
            System.out.println("Schema: "+schema );
            System.out.println("Porcentagem de nulidades do atributo "+atr+": "+ value);
            System.out.println("Porcentagem de repetições do atributo "+atr+": "+ valueRep );
            
            
            retorno.put(atr, (1 - (calcNull + calcRep)));
            
           
        }
        
        return retorno;
    }
    
    
   
    
}
