package dao;


import pojo.Teacher;
import utils.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    DBManager dbManager = new DBManager();
    //查询所有记录
    public List<Teacher> findAllTeacher(String searchKey)  {
        List<Teacher> res = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from teacher where 1=1 ");
        if(searchKey != null && !"".equals(searchKey)){
            sql.append("and name like '%"+searchKey+"%'");
        }
        ResultSet set = null;
        System.out.println("select sql:"+sql.toString());
        try {
            set = dbManager.executeQuery(sql.toString());
            while (set.next()){
                Teacher teacher = new Teacher(
                        Integer.parseInt(set.getString(1)),
                        set.getString(2),
                        set.getString(3),
                        set.getInt(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(7));
                res.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


    public boolean createTeacher(Teacher teacher){
        StringBuilder sql = new StringBuilder("insert into teacher values(");
        sql.append("null,"+
                "'"+teacher.getName()+"',"+
                "'"+teacher.getSex()+"',"+
                 ""+teacher.getAge()+","+
                "'"+teacher.getDept()+"',"+
                "'"+teacher.getWork()+"',"+
                "'"+teacher.getPassword()+"')");
        System.out.println("insert : "+ sql);
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
        StringBuilder sql = new StringBuilder("select count(*) from teacher where teacherNum = "
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
