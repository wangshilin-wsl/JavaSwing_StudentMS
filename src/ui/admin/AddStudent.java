package ui.admin;

import dao.StudentDao;
import pojo.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddStudent {
    JButton jb1=new JButton("提交");
    JButton jb2=new JButton("关闭");
    JFrame jf=new JFrame("添加学生");
    JTextField jt1=new JTextField(100);
    JTextField jt2=new JTextField(100);
    JTextField jt3=new JTextField(100);
    JTextField jt4=new JTextField(100);
    JTextField jt5=new JTextField(100);
    JTextField jt6=new JTextField(100);
    JTextField jt7=new JTextField(100);
    JTextField jt8=new JTextField(100);
    AllStudent allStudent;

    public AddStudent(AllStudent allStudent) {
        this.allStudent = allStudent;
    }

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO 自动生成的方法存根
            if(e.getSource()==jb1) {
                if(!check()){
                    JOptionPane.showMessageDialog(null, "字段不能为空!!!");
                }else {
                    Student student = new Student();
                    student.setName(jt1.getText());
                    student.setSex(jt2.getText());
                    student.setGrade(jt3.getText());
                    student.setAge(Integer.parseInt(jt4.getText()));
                    student.setClas(jt5.getText());
                    student.setMajor(jt6.getText());
                    student.setDept(jt7.getText());
                    student.setPassword(jt8.getText());
                    new StudentDao().createStudent(student);
                    JOptionPane.showMessageDialog(null, "添加学生 "+jt1.getText()
                            +" 成功！！！");
                    jf.setVisible(false);
                    allStudent.search();
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
        JLabel jl3=new JLabel("年级：",JLabel.RIGHT);
        jl3.setFont(font);
        JLabel jl4=new JLabel("年龄：",JLabel.RIGHT);
        jl4.setFont(font);
        JLabel jl5=new JLabel("班级：",JLabel.RIGHT);
        jl5.setFont(font);
        JLabel jl6=new JLabel("专业：",JLabel.RIGHT);
        jl6.setFont(font);
        JLabel jl7=new JLabel("学院：",JLabel.RIGHT);
        jl7.setFont(font);
        JLabel jl8=new JLabel("密码：",JLabel.RIGHT);
        jl8.setFont(font);

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

        jp1.add(jl7);
        jp1.add(jt7);
        jt7.setFont(font);

        jp1.add(jl8);
        jp1.add(jt8);
        jt8.setFont(font);




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
                "".equals(jt6.getText().trim()) ||
                "".equals(jt7.getText().trim()) ||
                "".equals(jt8.getText().trim())){
            return false;
        }
        return true;
    }
}
