package many2mang.Dao;

import many2mang.Domain.Student;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings("all")
public interface StudentDao {
    //  保存学生
    void save(Student d);

    // 表关系映射
    void insertRelation(@Param("studentID") Long studentID, @Param("teacherID") Long teacherID);

    //更新师生关系
    //void updateRelation(@Param("studentID") Long studentID, @Param("teacherID") Long teacherID);

    //获取该学生的老师
    Student get(Long id);

    // 删除学生
    void delete(Long id);

    //删除师生关系
    void deleteRelationWithTeacher(Long id);
}
