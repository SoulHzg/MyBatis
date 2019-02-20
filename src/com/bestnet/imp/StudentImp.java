package com.bestnet.imp;

import com.bestnet.entity.StudentEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentImp {
    public StudentEntity qryStudentByCourseId(int course_id);

    public StudentEntity qryStudentById(int id);

    public int addStudentInfo(StudentEntity studentEntity);

    public long updStudentInfo(StudentEntity studentEntity);

    public int delStudentInfo(int id);

    //参数解析
    public StudentEntity qryStudentByIdAndName(@Param("id_") int id, @Param("name_") String name,@Param("sex_") String sex);

    public long addStudentByList(List<Object> studentList);


    //查询类型list<类名>，map，map<属性，类名>
    public List<StudentEntity> qryStudentReturnList(String name);
    public Map<String,Object> qryStudentReturnMap(int id);
    @MapKey("id")
    public Map<Integer,StudentEntity> qryStudentReturnMaps(String name);

    //association嵌套、分步骤、懒加载
    //使用resultMap级联查询  association嵌套
    public StudentEntity qryStudentReturnResultMap(int id);

    //分步骤、懒加载
    public StudentEntity qryStudentReturnResultMap2(int id);
}
