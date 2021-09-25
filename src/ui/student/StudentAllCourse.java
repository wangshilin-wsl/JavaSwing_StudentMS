package ui.student;

import dao.CourseDao;
import pojo.Course;
import utils.JTableUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class StudentAllCourse {
    JButton jb=new JButton("查询");
    JButton jb2=new JButton("退出");
    JButton jb3=new JButton("选修");
    JFrame jf=new JFrame("所有课程");
    JLabel jLabel = new JLabel("课程名:",JLabel.RIGHT);
    JTextField jt=new JTextField(50);
    JScrollPane sp=new JScrollPane();

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO 自动生成的方法存根
            if(e.getSource()==jb) {
                search();
            }
            if(e.getSource() == jb2){
                jf.setVisible(false);
            }
            if(e.getSource()== jb3){
                new EleCourse().add();
            }
        }
    }

    public void total() {
        search();
        jb.addActionListener(new MyListener());
        jb2.addActionListener(new MyListener());
        jb3.addActionListener(new MyListener());
        jf.setBounds(100, 100, 1500,800);
        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(1,100,10,10));

        Font font=new Font("黑体",Font.BOLD,20);
        jt.setFont(font);
        jLabel.setFont(font);
        jb.setFont(font);

        jb2.setFont(font);
        jb3.setFont(font);
        jp.add(jLabel);
        jp.add(jt);
        jp.add(jb);
        jp.add(jb3);
        jp.add(jb2);
        jp.add(new JPanel());

        jf.add(jp,BorderLayout.NORTH);
        jf.add(new JPanel(),BorderLayout.SOUTH);
        jf.add(new JPanel(),BorderLayout.EAST);
        jf.add(new JPanel(),BorderLayout.WEST);
        jf.setVisible(true);
    }

    public  void search() {
        DefaultTableModel model;
        JTable table;
        jf.remove(sp);
        List<Course> all = new CourseDao().findAllCourse(jt.getText());

        String[] columeName= {"课程号","老师编号","老师名字","课程名","上课时间","上课地点","课程类型"};
        if(all.size()==0) {
            model=new DefaultTableModel(columeName,1);
            table=new JTable(model);
            table.setBackground(Color.CYAN);
            sp=new JScrollPane(table);
            //sp.add(table);
            jf.add(sp);
            jf.validate();
            return ;
        }
        String[][] values= new String[all.size()][7];
        for (int i = 0; i < all.size(); i++) {
            values[i][0] = String.valueOf(all.get(i).getCourseNum());
            values[i][1] = String.valueOf(all.get(i).getTeacher().getTeacherNum());
            values[i][2] = all.get(i).getTeacher().getName();
            values[i][3] = all.get(i).getName();
            values[i][4] = all.get(i).getTime();
            values[i][5] = all.get(i).getLocal();
            values[i][6] = all.get(i).getType();
        }
        model=new DefaultTableModel(values,columeName);
        table=new JTable(model);
        Font font = new Font("黑体", Font.BOLD, 20);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        JTableUtils.setTableStyle(table);
        table.setBackground(Color.CYAN);
        sp=new JScrollPane(table);
        //sp.add(table);
        jf.add(sp);
        jf.validate();
    }
}
