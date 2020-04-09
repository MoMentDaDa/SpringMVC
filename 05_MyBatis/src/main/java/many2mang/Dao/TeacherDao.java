package many2mang.Dao;

import many2mang.Domain.Teacher;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings("all")


public interface TeacherDao {
    //保存新的老师
    long save(Teacher e);

    // 老师选学生
    void insertRelation(@Param("studentID") Long studentID, @Param("teacherID") Long teacherID);

    //获取该老师的所有学生
    Teacher get(Long id);

    // 删除老师
    void delete(Long id);

    //删除师生关系
    void deleteRelationWithStudent(Long id);


    Teacher selectByTeacherName(String name);
}
