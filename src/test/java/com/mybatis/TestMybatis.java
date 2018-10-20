package com.mybatis;

import com.ads.entity.Feedback;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/4/16
 */

public class TestMybatis {
    SqlSession sqlSession;
    
    @Before
    public void beforeLoadXml(){
        InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        byte[] data = new byte[1024];
//        try {
//            inputStream.read(data);
//            System.out.println(new String(data));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    
    
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
//        Configuration configuration = sqlSessionFactory.getConfiguration();
//        Environment environment = configuration.getEnvironment();
//        System.out.println(configuration);
        sqlSession = sqlSessionFactory.openSession();
    }
    
  
}
