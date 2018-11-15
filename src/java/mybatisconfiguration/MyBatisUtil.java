/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybatisconfiguration;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author kalav
 */
public class MyBatisUtil {
    
    public static String RESOURCE = "mybatisconfiguration/configuration.xml";
    public static String ENVIROMENT = "development";
    
    public static SqlSession getSession(){
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader(RESOURCE);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader, ENVIROMENT);
            session = sqlMapper.openSession();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
    
}
