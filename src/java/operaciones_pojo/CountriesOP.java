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
import pojos.Regions;
import pojos.mssgRequestAnswers.CountriesList;
import pojos.mssgRequestAnswers.SucssErrAnswer;

/**
 *
 * @author kalav
 */
public class CountriesOP {
    
    public String getAllCountries(){      
      SqlSession conn = MyBatisUtil.getSession();       
      List<Countries> countries = conn.selectList("countries.getAll");
      System.out.println("Records Read Successfully ");          
      conn.commit();   
      conn.close();	
      CountriesList data = new CountriesList(countries);             
      String json = new Gson().toJson(data);
      return json;
    } 
    
    public String crearCountry(Countries countries){
        Regions region = new Regions();
        RegionsOp regionsOp = new RegionsOp();
        region = regionsOp.getObjbyName(countries.getRegion_name());
        SqlSession conn = MyBatisUtil.getSession();
        try {
            if(region!= null){
                countries.setRegion_id(region.getRegion_id());
                conn.insert("countries.insert", countries);
                conn.commit();
            }else{
            SucssErrAnswer error = new SucssErrAnswer(true,"No existe la region");
            String json = new Gson().toJson(error);
            return json;
            } 
            
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
    
    public String deleteCountry(String id){
    SqlSession conn = MyBatisUtil.getSession();       
        try {           
            if (id == null || id == "") {
                SucssErrAnswer answer = new SucssErrAnswer(true,"identificador no valido");
                String json  = new Gson().toJson(answer);
                return json;
            }
            conn.delete("countries.deleteById",id);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            SucssErrAnswer answer = new SucssErrAnswer(true,"pais no eliminado");
            String json  = new Gson().toJson(answer);
            return json;
        }finally {
            conn.close();
        }
        
        SucssErrAnswer answer = new SucssErrAnswer(false,"pais eliminado");
        String json  = new Gson().toJson(answer);
    
    return json;
    }
    
    public String updateCountry(Countries countries){
        Regions region = new Regions();
        RegionsOp regionsOp = new RegionsOp();
        region = regionsOp.getObjbyName(countries.getRegion_name());
        SqlSession conn = MyBatisUtil.getSession();
        try {
            if(region!= null){
                countries.setRegion_id(region.getRegion_id());
                conn.update("countries.update", countries);
                conn.commit();
            }else{
            SucssErrAnswer error = new SucssErrAnswer(true,"No existe la region");
            String json = new Gson().toJson(error);
            return json;
            } 
            
        } catch (Exception e) {            
            e.printStackTrace();
            SucssErrAnswer error = new SucssErrAnswer(true,"No se actualizo el elemento");
            String json = new Gson().toJson(error);
            return json;
        }finally{
             conn.close();
        }        
        SucssErrAnswer answer = new SucssErrAnswer(false,"se actualizo el elemento" + countries.getCountry_name());
        String json  = new Gson().toJson(answer);
        return json;
    }
}
