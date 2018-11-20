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
      System.out.println("Records Read Successfully ");          
      conn.commit();   
      conn.close();	
      RegionsList data = new RegionsList(regiones);
             
      String json = new Gson().toJson(data);
      return json;
    } 
    
    public String crearRegion(Regions region){
        
        SqlSession conn = MyBatisUtil.getSession();
        try {
            conn.insert("regions.insert", region);
            conn.commit();
        } catch (Exception e) {            
            e.printStackTrace();
            SucssErrAnswer error = new SucssErrAnswer(true,"No se guardo");
            String json = new Gson().toJson(error);
            return json;
        }finally{
             conn.close();
        }        
        SucssErrAnswer answer = new SucssErrAnswer(true,"si se guardo");
        String json  = new Gson().toJson(answer);
        return json;
    }
    /*
    public String actualizarRegion(Regions region){
        SqlSession conn = MyBatisUtil.getSession();
        try {
            conn.insert("regions.update", region);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
             conn.close();
        }  
        return "";
    }
    /*
    /*
    public String eliminarRegion(int id){
        SqlSession conn = MyBatisUtil.getSession();
        try {
            conn.delete("regions.delete", id);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
             conn.close();
        }
        
        return "";
    }
    */
    
    
}
