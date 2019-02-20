package com.mbg.imp;

import com.mbg.entity.StudentEntity;
import com.mbg.entity.StudentEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int countByExample(StudentEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int deleteByExample(StudentEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int insert(StudentEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int insertSelective(StudentEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    List<StudentEntity> selectByExample(StudentEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    StudentEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int updateByExampleSelective(@Param("record") StudentEntity record, @Param("example") StudentEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int updateByExample(@Param("record") StudentEntity record, @Param("example") StudentEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int updateByPrimaryKeySelective(StudentEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Thu Jan 17 14:29:16 CST 2019
     */
    int updateByPrimaryKey(StudentEntity record);
}