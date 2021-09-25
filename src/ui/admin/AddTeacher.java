package ui.admin;

import dao.TeacherDao;
import pojo.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddTeacher {
    JButton jb1=new JButton("提交");
    JButton jb2=new JButton("关闭");
    JFrame jf=new JFrame("添加教师");
    JTextField jt1=new JTextField(100);
    JTextField jt2=new JTextField(100);
    JTextField jt3=new JTextField(100);
    JTextField jt4=new JTextField(100);
    JTextField jt5=new JTextField(100);
    JTextField jt6=new JTextField(100);
    AllTeacher allTeacher;

    public AddTeacher(AllTeacher allTeacher) {
        this.allTeacher = allTeacher;
    }

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO 自动生成的方法存根
            if(e.getSource()==jb1) {
                if(!check()){
                    JOptionPane.showMessageDialog(null, "字段不能为空!!!");
                }else {
                    Teacher teacher = new Teacher();
                    teacher.setName(jt1.getText().trim());
                    teacher.setSex(jt2.getText().trim());
                    teacher.setAge(Integer.parseInt(jt3.getText().trim()));
                    teacher.setDept(jt4.getText().trim());
                    teacher.setWork(jt5.getText().trim());
                    teacher.setPassword(jt6.getText().trim());
                    new TeacherDao().createTeacher(teacher);
                    JOptionPane.showMessageDialog(null, "添加教师 "+jt1.getText()
                            +" 成功！！！");
                    jf.setVisible(false);
                    allTeacher.search();
                }
            }
            if(e.getSource()==jb2) {
                jf.setVisible(false);
            }
        }
    }

    public void add()
    {
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
        JLabel jl1=new JLabel("姓名：",JLabel.RIGHT);
        jl1.setFont(font);
        JLabel jl2=new JLabel("性别：",JLabel.RIGHT);
        jl2.setFont(font);
        JLabel jl3=new JLabel("年龄：",JLabel.RIGHT);
        jl3.setFont(font);
        JLabel jl4=new JLabel("学院：",JLabel.RIGHT);
        jl4.setFont(font);
        JLabel jl5=new JLabel("职位：",JLabel.RIGHT);
        jl5.setFont(font);
        JLabel jl6=new JLabel("密码：",JLabel.RIGHT);
        jl6.setFont(font);

        jp1.add(jl1);
        jp1.add(jt1);
        jt1.setFont(font);

        jp1.add(jl2);
        jp1.add(jt2);
        jt2.setFont(font);

        jp1.add(jl3);
        jp1.add(jt3);
        jt3.setFont(font);

        jp1.add(jl4);
        jp1.add(jt4);
        jt4.setFont(font);

        jp1.add(jl5);
        jp1.add(jt5);
        jt5.setFont(font);

        jp1.add(jl6);
        jp1.add(jt6);
        jt6.setFont(font);


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
        if("".equals(jt1.getText().trim()) ||
                "".equals(jt2.getText().trim()) ||
                "".equals(jt3.getText().trim()) ||
                "".equals(jt4.getText().trim()) ||
                "".equals(jt5.getText().trim()) ||
                "".equals(jt6.getText().trim())){
            return false;
        }
        return true;
    }
}
