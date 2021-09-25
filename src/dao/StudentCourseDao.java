package dao;

import pojo.StudentCourse;
import utils.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDao {
    DBManager dbManager = new DBManager();
    public boolean createStudent(StudentCourse studentCourse){
        StringBuilder sql = new StringBuilder("insert into student_course values(");
        sql.append("null,"+
                "'"+studentCourse.getStudentNum()+"',"+
                "'"+studentCourse.getCourseNum()+"',"+
                "'"+studentCourse.getTerm()+"',"+
                "null)"
                );
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean updateStudentCourse(StudentCourse studentCourse){
        StringBuilder sql = new StringBuilder("update student_course");
        sql.append(" set score = '"+studentCourse.getScore()+"'"+
                "where id = "+studentCourse.getId());
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public List<String> findAllSem(){
       List<String> res = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select term " +
                "from student_course " +
                "group by term ");
        ResultSet set;
        try {
            set= dbManager.executeQuery(sql.toString());
            while(set.next()){
                res.add(set.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
