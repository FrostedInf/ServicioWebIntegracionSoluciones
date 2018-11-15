/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones_pojo;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import mybatisconfiguration.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Departments;

/**
 *
 * @author kalav
 */
public class DeparmentOp {
    public String leerTodos(){
      //Hace todo el proceso de conexion a bda y el uso de archivos de configuracion
      SqlSession conn = MyBatisUtil.getSession();
      //select contact all contacts		
      List<Departments> departments = conn.selectList("departments.getAll");
      System.out.println("Records Read Successfully ");          
      conn.commit();   
      conn.close();	
      String json = new Gson().toJson(departments);
      return json;
    } 
}
