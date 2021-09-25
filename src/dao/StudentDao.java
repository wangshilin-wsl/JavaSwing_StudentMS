package dao;


import pojo.Student;
import utils.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    DBManager dbManager = new DBManager();
    //查询所有记录
    public List<Student> findAllStudent(String searchKey)  {
        List<Student> res = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from student where 1=1 ");
        if(searchKey != null && !"".equals(searchKey)){
            sql.append("and name like '%"+searchKey+"%'");
        }
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Student student = new Student(
                        Integer.parseInt(set.getString(1)),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getInt(5),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8),
                        set.getString(9));
                res.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean createStudent(Student student){
        StringBuilder sql = new StringBuilder("insert into student values(");
        sql.append("null,"+
                "'"+student.getName()+"',"+
                "'"+student.getSex()+"',"+
                "'"+student.getGrade()+"',"+
                ""+student.getAge()+","+
                "'"+student.getClas()+"',"+
                "'"+student.getMajor()+"',"+
                "'"+student.getDept()+"',"+
                "'"+student.getPassword()+"')");
        System.out.println("insert sql:"+sql.toString());
        boolean update = false;
        try {
            update = dbManager.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean login(Integer id, String password){
        boolean res = false;
        StringBuilder sql = new StringBuilder("select count(*) from student where studentNum = "
        +id+" and password ='"+password+"'" );
        System.out.println("select : "+ sql);
        ResultSet set = null;
        try {
            set = dbManager.executeQuery(sql.toString());
            set.next();
            if(set.getInt(1)>0){
                res = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
