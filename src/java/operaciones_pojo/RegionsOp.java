/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones_pojo;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import pojos.Regions;
import java.util.List;
import mybatisconfiguration.MyBatisUtil;
import pojos.mssgRequestAnswers.RegionsList;
import pojos.mssgRequestAnswers.SucssErrAnswer;
/**
 *
 * @author kalav
 */
public class RegionsOp {
    public String leerTodos(){
      //Hace todo el proceso de conexion a bda y el uso de archivos de configuracion  
      SqlSession conn = MyBatisUtil.getSession();
      //select contact all contacts		  
      List<Regions> regiones = conn.selectList("regions.getAll");      
      conn.commit();   
      conn.close();	
      RegionsList data = new RegionsList(regiones);             
      String json = new Gson().toJson(data);
      return json;
    } 
    
    public Regions getObjbyName(String name){
      //Hace todo el proceso de conexion a bda y el uso de archivos de configuracion  
      SqlSession conn = MyBatisUtil.getSession();
      //select contact all contacts		  
      Regions region = conn.selectOne("regions.getByName", name);      
      System.out.println("Records Read Successfully get by name ");          
      System.out.println(region.getRegion_name());                
      conn.commit();   
      conn.close();	      
      return region;
    }
}
