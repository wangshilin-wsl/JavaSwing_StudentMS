package ui.teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherHome {
    static JMenuItem jm3=new JMenuItem("退出系统");
    static JMenuItem jm2=new JMenuItem("教授课程");
    static JMenuItem jm1=new JMenuItem("录入分数");
    class MyListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO 自动生成的方法存根
            if(e.getSource()==jm1) {
                Mark mark = new Mark();
                mark.total(mark);
            }
            if(e.getSource()==jm2) {
                new TeacherAllCourse().total();
            }
            if(e.getSource()==jm3) {
                System.exit(0);
            }
        }

    }
    public void menu( ) {
        jm1.addActionListener(new TeacherHome().new MyListener());
        jm2.addActionListener(new TeacherHome().new MyListener());
        jm3.addActionListener(new TeacherHome().new MyListener());
        JFrame jf=new JFrame("学生管理系统1.0版本----教师首页");
        jf.setBounds(100, 100, 1500,800);
        JMenuBar a = new JMenuBar();
        JMenu ch=new JMenu("操作");
        Font font=new Font("黑体",Font.BOLD,20);
        ch.setFont(font);
        a.add(ch);

        jm1.setFont(font);
        jm1.setForeground(Color.BLUE);

        jm2.setFont(font);
        jm2.setForeground(Color.BLUE);

        jm3.setFont(font);
        jm3.setForeground(Color.BLUE);

        ch.add(jm1);
        ch.add(jm2);
        ch.add(jm3);
        jf.add(a,BorderLayout.NORTH);
        JLabel jLabel= new JLabel();
        jf.add(jLabel);
        jf.setVisible(true);
    }
}
