package many2mang;


import many2mang.Dao.StudentDao;
import many2mang.Dao.TeacherDao;
import many2mang.Domain.Student;
import many2mang.Domain.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestDemo {
    private static final SqlSession session;
    private static InputStream in;
    private static TeacherDao tDao;
    private static StudentDao sDao;

    static {
        //1.读取配置文件
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        tDao = session.getMapper(TeacherDao.class);
        sDao = session.getMapper(StudentDao.class);
    }


    @Test
    public void test1() {
        Teacher t1 = new Teacher();
        t1.setName("老师1");

        Teacher t2 = new Teacher();
        t2.setName("老师2");

        Student s1 = new Student();
        s1.setName("小明");
        Student s2 = new Student();
        s2.setName("小王");

        // 维护关系
        s1.getTeachers().add(t1);
        s1.getTeachers().add(t2);

        s2.getTeachers().add(t1);
        s2.getTeachers().add(t2);

        sDao.save(s1);
        sDao.save(s2);
        tDao.save(t1);
        tDao.save(t2);
        // s1学生来维护和老师的关系
        for (Teacher t : s1.getTeachers()) {
            sDao.insertRelation(s1.getId(), t.getId());
        }
        // s2学生来维护和老师的关系
        for (Teacher t : s2.getTeachers()) {
            sDao.insertRelation(s2.getId(), t.getId());
        }
        session.commit();
    }

    //获取该学生的老师
    @Test
    public void test2() {
        Student s = sDao.get((long) 43);
        System.out.println(s.toString());
        System.out.println(s.getTeachers().toString());

    }

    //删除该学生
    @Test
    public void test3e() {
        // 先删除关系，再删除学生
        sDao.deleteRelationWithTeacher((long) 44);
        sDao.delete((long) 44);
        session.commit();
    }

    //获取该老师的学生
    @Test
    public void test4() {
        Teacher s = tDao.get((long) 40);
        System.out.println(s.toString());
        System.out.println(s.getStds().toString());
    }


    //删除该l老师
    @Test
    public void test5() {
        tDao.deleteRelationWithStudent((long) 9);
        tDao.delete((long) 9);
        session.commit();
    }
}
