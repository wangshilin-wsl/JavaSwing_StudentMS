package ui.student;

import dao.CourseDao;
import dao.StudentCourseDao;
import pojo.MyCourse;
import utils.JTableUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MyStudentAllCourse {
    JButton jb=new JButton("查询");
    JButton jb2=new JButton("退出");
    JFrame jf=new JFrame("我的课程");
    JLabel jLabel = new JLabel("课程名:",JLabel.RIGHT);
    JTextField jt=new JTextField(50);
    JLabel jLabe2 = new JLabel("学期:",JLabel.RIGHT);
    JComboBox jt2=new JComboBox();
    JScrollPane sp=new JScrollPane();
    List<String> sem ;

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

        }
    }

    public void total() {
        search();
        jb.addActionListener(new MyListener());
        jb2.addActionListener(new MyListener());
        jf.setBounds(100, 100, 1500,800);
        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(1,100,10,10));

        Font font=new Font("黑体",Font.BOLD,20);
        jt.setFont(font);
        jt2.setFont(font);
        jLabel.setFont(font);
        jLabe2.setFont(font);
        jb.setFont(font);

        jb2.setFont(font);
        jp.add(jLabel);
        jp.add(jt);

        jp.add(jLabe2);
        jp.add(jt2);

        sem = new StudentCourseDao().findAllSem();
        jt2.addItem("---请选择---");
        for (String s : sem) {
            jt2.addItem(s);
        }
        jp.add(jb);
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
        int index = jt2.getSelectedIndex()-1;
        List<MyCourse> all;
        if(index >=0){
            all = new CourseDao().findAllMyCourse(1,jt.getText(),sem.get(index));
        }else {
            all = new CourseDao().findAllMyCourse(1,jt.getText(),"---请选择---");
        }


        String[] columeName= {"课程号","老师编号","老师名字","课程名","上课时间","上课地点","课程类型","学期","分数"};
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
        String[][] values= new String[all.size()][9];
        for (int i = 0; i < all.size(); i++) {
            values[i][0] = String.valueOf(all.get(i).getCourseNum());
            values[i][1] = String.valueOf(all.get(i).getTeacher().getTeacherNum());
            values[i][2] = all.get(i).getTeacher().getName();
            values[i][3] = all.get(i).getName();
            values[i][4] = all.get(i).getTime();
            values[i][5] = all.get(i).getLocal();
            values[i][6] = all.get(i).getType();
            values[i][7] = all.get(i).getTerm();
            values[i][8] = String.valueOf(all.get(i).getScore()==-1?"":all.get(i).getScore());
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
