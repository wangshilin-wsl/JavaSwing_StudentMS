package ui.teacher;

import dao.CourseDao;
import dao.StudentCourseDao;
import pojo.StudentCourse;
import pojo.TeacherCourse;
import ui.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MarkCourse {
    JButton jb1=new JButton("打分");
    JButton jb2=new JButton("关闭");
    JFrame jf=new JFrame("打分");
    JComboBox jt1=new JComboBox();    //创建JComboBox
    JTextField jt2=new JTextField(100);
    List<TeacherCourse> list;
    Mark mark;

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO 自动生成的方法存根
            if(e.getSource()==jb1) {
                if(!check()){
                    JOptionPane.showMessageDialog(null, "打分失败,字段为空或者不合法!!!");
                }else {
                    int temp = jt1.getSelectedIndex()-1;
                    StudentCourse studentCourse = new StudentCourse();
                   studentCourse.setId(list.get(temp).getScID());
                   studentCourse.setScore(Integer.parseInt(jt2.getText()));
                    new StudentCourseDao().updateStudentCourse(studentCourse);
                    JOptionPane.showMessageDialog(null, "给 "+list.get(temp).getStudentName()+
                            " 的 "+list.get(temp).getName()+" 课程"+"打分成功！！！");
                    jf.setVisible(false);
                    mark.search();
                }
            }
            if(e.getSource()==jb2) {
                jf.setVisible(false);
            }
        }
    }

    public void add(Mark mark) {
        this.mark= mark;
        list= new CourseDao().findTeacherTeachCourse(Login.id,"",true);
        jf.setResizable(false);
        Font font=new Font("黑体",Font.BOLD,25);
        jb1.addActionListener(new MyListener());
        jb2.addActionListener(new MyListener());
        jf.setLayout(new BorderLayout(60,10));
        jf.add(new JPanel(),BorderLayout.EAST);
        jf.add(new JPanel(),BorderLayout.WEST);
        jf.add(new JPanel(),BorderLayout.NORTH);
        jf.setBounds(100, 100, 1000,350);

        JPanel jp1=new JPanel();
        jp1.setLayout(new GridLayout(3,2,5,10));
        JLabel jl1=new JLabel("课程-学生：",JLabel.RIGHT);
        jl1.setFont(font);
        JLabel jl2=new JLabel("分数：",JLabel.RIGHT);
        jl2.setFont(font);
        jt1.addItem("--请选择--");
        for (int i = 0; i < list.size(); i++) {
            jt1.addItem(list.get(i).getName()+"("+list.get(i).getCourseNum()+")-"+
                    list.get(i).getStudentName()+"("+list.get(i).getCourseNum()+")");
        }

        jp1.add(jl1);
        jp1.add(jt1);
        jt1.setFont(font);

        jp1.add(jl2);
        jp1.add(jt2);
        jt2.setFont(font);

        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        jp3.setLayout(new BorderLayout(50,50));
        jp2.setLayout(new GridLayout(1,1,50,5));
        jb1.setForeground(Color.CYAN);
        jb1.setFont(font);

        jb2.setForeground(Color.CYAN);
        jb2.setFont(font);


        jp3.add(new JPanel(),BorderLayout.SOUTH);
        jp3.add(new JPanel(),BorderLayout.EAST);
        jp3.add(new JPanel(),BorderLayout.WEST);
        jp3.add(new JPanel(),BorderLayout.NORTH);
        jp3.add(jp2);

        jp2.add(jb1);
        jp2.add(jb2);

        jf.add(jp1);
        jf.add(jp3,BorderLayout.SOUTH);
        jf.setVisible(true);
    }
    public boolean check(){
        if(jt1.getSelectedIndex() == 0 ||
                "".equals(jt2.getText().trim()) ||
                Integer.parseInt(jt2.getText().trim())>100
            || Integer.parseInt(jt2.getText().trim())<0){
            return false;
        }
        return true;
    }
}
