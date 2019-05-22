package com.styd.config;

//import com.styd.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlDataBaseUtil {
    public static SqlSession getSqlSession() throws IOException {
        //指定全局配置文件
        String resource = "mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;

    }


    public static Object getTestData(String test_login, int sqlId) throws IOException {
        SqlSession sqlSession = SqlDataBaseUtil.getSqlSession();
        return sqlSession.selectOne(test_login, sqlId);
    }

}





