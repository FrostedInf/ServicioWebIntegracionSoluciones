/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones_pojo;

import com.google.gson.Gson;
import java.util.List;
import mybatisconfiguration.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Countries;
import pojos.mssgRequestAnswers.CountriesList;
import pojos.mssgRequestAnswers.SucssErrAnswer;

/**
 *
 * @author kalav
 */
public class CountriesOP {
    
    public String getAllCountries(){
      //Hace todo el proceso de conexion a bda y el uso de archivos de configuracion  
      SqlSession conn = MyBatisUtil.getSession();
      //select contact all contacts		  
      List<Countries> countries = conn.selectList("countries.getAll");
      System.out.println("Records Read Successfully ");          
      conn.commit();   
      conn.close();	
      CountriesList data = new CountriesList(countries);             
      String json = new Gson().toJson(data);
      return json;
    } 
    
    public String crearCountry(Countries region){
        
        SqlSession conn = MyBatisUtil.getSession();
        try {
            conn.insert("countries.insert", region);
            conn.commit();
        } catch (Exception e) {            
            e.printStackTrace();
            SucssErrAnswer error = new SucssErrAnswer(true,"No se guardo");
            String json = new Gson().toJson(error);
            return json;
        }finally{
             conn.close();
        }        
        SucssErrAnswer answer = new SucssErrAnswer(false,"si se guardo");
        String json  = new Gson().toJson(answer);
        return json;
    }
    
}
