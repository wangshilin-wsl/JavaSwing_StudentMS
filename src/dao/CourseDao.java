package dao;


import pojo.Course;
import pojo.MyCourse;
import pojo.Teacher;
import pojo.TeacherCourse;
import utils.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    DBManager dbManager = new DBManager();
    //查询所有记录
    public List<Course> findAllCourse(String searchKey)  {
        List<Course> res = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT c.courseNum,c.teacherNum,c.name,c.time,c.local,c.type,t.name " +
                "from course c " +
                "LEFT JOIN teacher t on c.teacherNum = t.teacherNum " +
                " where 1=1 ");
        if(searchKey != null && !"".equals(searchKey)){
            sql.append("and c.name like '%"+searchKey+"%'");
        }
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherNum(Integer.parseInt(set.getString(2)));
                teacher.setName(set.getString(7));
                Course course = new Course(
                        Integer.parseInt(set.getString(1)),
                        teacher,
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6));
                res.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean createCourse(Course course){
        StringBuilder sql = new StringBuilder("insert into course values(");
        sql.append("null,"+
                "'"+course.getTeacher().getTeacherNum()+"',"+
                "'"+course.getName()+"',"+
                "'"+course.getTime()+"',"+
                "'"+course.getLocal()+"',"+
                "'"+course.getType()+"')");
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public List<MyCourse> findAllMyCourse(Integer num,String searchKey,String sem){
        StringBuilder sql = new StringBuilder("SELECT c.*,t.name,sc.term,sc.score from course c LEFT JOIN teacher t on c.teacherNum = t.teacherNum " +
                " LEFT JOIN student_course sc on c.courseNum = sc.courseNum " +
                "where 1=1");
        if(searchKey != null && !"".equals(searchKey)){
            sql.append(" and c.name like '%"+searchKey+"%'");
        }
        if(num!=null&& num>0){
            sql.append(" and sc.studentNum ="+num);
        }
        if(!"---请选择---".equals(sem)){
            sql.append(" and sc.term = '"+sem+"'");
        }
        List<MyCourse> res = new ArrayList<>();
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherNum(Integer.parseInt(set.getString(2)));
                teacher.setName(set.getString(7));
                MyCourse course = new MyCourse(
                        Integer.parseInt(set.getString(1)),
                        teacher,
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(8),
                        Integer.parseInt(set.getString(9)==null?"-1":set.getString(9)));
                res.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


    public List<Course> findNoSelectCourse(Integer id)  {
        List<Course> res = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select courseNum,name from course " +
                "where courseNum not in (SELECT courseNum from student_course  " +
                "where 1=1 ");
        if(id != null &&id>0){
            sql.append(" and studentNum =" +id +")");
        }

        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Course course = new Course();
                course.setCourseNum(set.getInt(1));
                course.setName(set.getString(2));
                res.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Course> findCourseByTeacherNum(Integer id, String searchKey){
        List<Course> res = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from course " +
                "where teacherNum ="+id);
        if(searchKey != null && !"".equals(searchKey)){
            sql.append(" and name like '%"+searchKey+"%'");
        }
        ResultSet set = null;
        System.out.println(" and select sql:"+sql.toString());
        try {
            set= dbManager.executeQuery(sql.toString());
            while (set.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherNum(Integer.parseInt(set.getString(2)));
                Course course = new Course(
                        Integer.parseInt(set.getString(1)),
                        teacher,
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6));
                res.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<TeacherCourse> findTeacherTeachCourse(Integer id, String searchKey,boolean flag){
        List<TeacherCourse> res = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select sc.id, sc.courseNum,s.studentNum,s.name,c.name,c.time,c.local,c.type,sc.score " +
                " from student_course sc " +
                " LEFT JOIN student s on sc.studentNum = s.studentNum " +
                " LEFT JOIN course c on sc.courseNum = c.courseNum " +
                " where c.teacherNum =  "+id);
        if(searchKey != null && !"".equals(searchKey)){
            sql.append(" and s.name like '%"+searchKey+"%'");
        }
        if(flag){
            sql.append(" and sc.score is null");
        }
        ResultSet set = null;
        System.out.println(" and select sql:"+sql.toString());
        try {
            set= dbManager.executeQuery(sql.toString());
            while (set.next()){
                TeacherCourse course = new TeacherCourse();
                course.setScID(set.getInt(1));
                course.setCourseNum(set.getInt(2));
                course.setStudentNum(set.getInt(3));
                course.setStudentName(set.getString(4));
                course.setName(set.getString(5));
                course.setTime(set.getString(6));
                course.setLocal(set.getString(7));
                course.setType(set.getString(8));
                course.setScore(Integer.parseInt(set.getString(9)==null? "-1":set.getString(9)));
                res.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

}
