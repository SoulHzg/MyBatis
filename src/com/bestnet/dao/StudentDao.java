package com.bestnet.dao;

import com.bestnet.entity.StudentEntity;
import com.bestnet.imp.StudentImp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentDao {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args) throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //旧方法查询 其中查询出来的studentEntity为一个实体对象
            /*StudentEntity studentEntity = sqlSession.selectOne("com.bestnet.dao.StudentDao.getEmpById", "1");
            System.out.println(studentEntity.getClass());
            System.out.println(studentEntity);*/

            //接口方法实现
            StudentImp studentImp = sqlSession.getMapper(StudentImp.class);
            StudentEntity studentEntity = studentImp.qryStudentById(1);
            System.out.println("接口实现类型:"+studentImp);
            System.out.println(studentEntity);
        }finally {
            sqlSession.close();
        }
    }
}
