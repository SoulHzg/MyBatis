package com.bestnet.test;

import com.bestnet.entity.CourseEntity;
import com.bestnet.entity.StudentEntity;
import com.bestnet.imp.CourseImp;
import com.bestnet.imp.StudentImp;
import com.mbg.entity.StudentEntityExample;
import com.mbg.imp.StudentEntityMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StudentDaoTest {


    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void qryStudentInfo() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentImp studentImp = sqlSession.getMapper(StudentImp.class);
            StudentEntity studentEntity = studentImp.qryStudentById(1);
            System.out.println(studentEntity);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void addStudentInfo() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentImp studentImp = sqlSession.getMapper(StudentImp.class);
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName("胡志刚");
            studentEntity.setSex("男");
            //新增
            /*int num = studentImp.addStudentInfo(studentEntity);
            System.out.println("新增返回值num:"+num);
            System.out.println(studentEntity.getId());*/

            //修改
            /*studentEntity.setId(128);
            long num = studentImp.updStudentInfo(studentEntity);*/
            //删除
            int num = studentImp.delStudentInfo(128);
            System.out.println("编辑返回值num:"+num);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    //参数解析
    @Test
    public void qryStudentByIdAndName() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentImp studentImp = sqlSession.getMapper(StudentImp.class);
            //多个参数传入
            StudentEntity studentEntity = studentImp.qryStudentByIdAndName(127, null,null);
            System.out.println(studentEntity);
            //list
            /*List<Object> list = new ArrayList<Object>();
            list.add("李寒蕾");
            list.add("女");
            long num = studentImp.addStudentByList(list);
            System.out.println("集合入参添加成功条数："+num);
            sqlSession.commit();*/
        }finally {
            sqlSession.close();
        }
    }


    //查询类型list<类名>，map，map<属性，类名>
    @Test
    public void qryStudentReturn() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentImp studentImp = sqlSession.getMapper(StudentImp.class);
            //list<类名>
            /*List<StudentEntity> list = studentImp.qryStudentReturnList("%胡%");
            System.out.println(Arrays.asList(list));*/
            //map
            /*Map<String,Object> map = studentImp.qryStudentReturnMap(130);
            System.out.println(map);*/
            //map<属性，类名>
            Map<Integer,StudentEntity> map = studentImp.qryStudentReturnMaps("%胡%");
            System.out.println(map);
        }finally {
            sqlSession.close();
        }
    }

    //association嵌套、分步骤、懒加载
    @Test
    public void qryStudentReturnByResultMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentImp studentImp = sqlSession.getMapper(StudentImp.class);
            //使用resultMap级联查询
            /*StudentEntity studentEntity = studentImp.qryStudentReturnResultMap(130);*/
            //分步骤
            StudentEntity studentEntity = studentImp.qryStudentReturnResultMap2(130);
            System.out.println(studentEntity.getName());
            System.out.println(studentEntity.getCourseEntity().getName());

        }finally {
            sqlSession.close();
        }
    }

    @Test
    //collection嵌套、分步骤、懒加载
    public void qryCourseAndStudentList()throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CourseImp courseImp = sqlSession.getMapper(CourseImp.class);
            //嵌套
            /*CourseEntity courseEntity = courseImp.qryCourseAndListStudent(1);*/
            //分步
            CourseEntity courseEntity = courseImp.qryCourseAndListStudent2(1);
            System.out.println(courseEntity.getName());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testMbg() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void qryStudentMBG() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentEntityMapper studentEntityMapper = sqlSession.getMapper(StudentEntityMapper.class);
            StudentEntityExample studentEntityExample = new StudentEntityExample();
            StudentEntityExample.Criteria criteria = studentEntityExample.createCriteria();
            criteria.andNameEqualTo("胡志刚");
            StudentEntityExample.Criteria criteria1 = studentEntityExample.createCriteria();
            criteria1.andSexEqualTo("1");
            studentEntityExample.or(criteria1);
            List<com.mbg.entity.StudentEntity> list = studentEntityMapper.selectByExample(studentEntityExample);
            System.out.println(Arrays.asList(list));
        }finally {
            sqlSession.close();
        }
    }

}