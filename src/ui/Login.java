package ui;

import dao.StudentDao;
import dao.TeacherDao;
import ui.admin.AdminHome;
import ui.student.StudentHome;
import ui.teacher.TeacherHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 登陆界面视图
 */
public class Login {
    JButton jb1=new JButton("登录");
    JButton jb2=new JButton("退出");
    JFrame jf=new JFrame("登录窗口");
    JTextField t2=new JTextField(30);
    JTextField t3=new JTextField(30);
    JComboBox cmb=new JComboBox();    //创建JComboBox
    public static Integer id;
    public static String password;
    class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==jb1) {
                if(!check()){
                    JOptionPane.showMessageDialog(null, "字段不能为空!!!");
                }else {
                    id = Integer.parseInt(t2.getText());
                    password = t3.getText();
                    if(cmb.getSelectedIndex() == 1){
                        if(new StudentDao().login(id,password)){
                            JOptionPane.showMessageDialog(null, "学生登录成功");
                            new StudentHome().menu();
                            jf.setVisible(false);
                        }else {
                            t2.setText("");
                            t3.setText("");
                            JOptionPane.showMessageDialog(null, "用户名或密码错误!!!");
                        }

                    }else if(cmb.getSelectedIndex() == 2){
                        if(new TeacherDao().login(id,password)){
                            JOptionPane.showMessageDialog(null, "教师登录成功");
                            new TeacherHome().menu();
                            jf.setVisible(false);
                        }else {
                            t2.setText("");
                            t3.setText("");
                            JOptionPane.showMessageDialog(null, "用户名或密码错误!!!");
                        }

                    }else if(cmb.getSelectedIndex() == 3){
                        if(id == 1 && "111".equals(password)){
                            JOptionPane.showMessageDialog(null, "管理员登录成功");
                            new AdminHome().menu();
                            jf.setVisible(false);
                        }else {
                            t2.setText("");
                            t3.setText("");
                            JOptionPane.showMessageDialog(null, "用户名或密码错误!!!");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "请选择正确的角色！！！");
                    }
                }
            }
            if(e.getSource()==jb2) {
                System.exit(0);
            }
        }
    }
    public void login( ) {
        // TODO Auto-generated method stub
        jf.setResizable(false);
        jb1.addActionListener(new MyListener());
        jb2.addActionListener(new MyListener());
        Font font=new Font("黑体",Font.BOLD,25);
        t2.setFont(font);
        t3.setFont(font);
        jb1.setFont(font);
        jb2.setFont(font);
        jf.setBounds(700, 300, 550, 430);
        jf.setLayout(new BorderLayout(70,20));
        JLabel l1=new JLabel("欢迎使用学生管理系统！",JLabel.CENTER);

        l1.setFont(font);
        JPanel jp4=new JPanel();
        jp4.setLayout(new GridLayout(2,1));
        jp4.add(new JPanel());
        jp4.add(l1);
        JLabel l2=new JLabel("学号/工号：",JLabel.RIGHT);
        Font font1=new Font("黑体",Font.BOLD,20);
        l2.setFont(font1);
        JLabel l3=new JLabel("密码：",JLabel.RIGHT);
        Font font2=new Font("黑体",Font.BOLD,20);
        l3.setFont(font2);

        JLabel label1=new JLabel("角色：",JLabel.RIGHT);    //创建标签
        label1.setFont(font1);

        cmb.addItem("---请选择---");    //向下拉列表中添加一项
        cmb.addItem("学生");
        cmb.addItem("教师");
        cmb.addItem("管理员");
        cmb.setFont(font1);

        JPanel jp1=new JPanel();
        jp1.setLayout(new GridLayout(3,3,5,10));
        jp1.add(label1);
        jp1.add(cmb);
        jp1.add(l2);
        jp1.add(t2);
        jp1.add(l3);
        jp1.add(t3);

        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        jp3.setLayout(new BorderLayout(50,50));
        jp2.setLayout(new GridLayout(1,1,100,5));
        jb1.setForeground(Color.CYAN);
        jp2.add(jb1);

        jb2.setForeground(Color.CYAN);

        jp2.add(jb2);

        jp3.add(new JPanel(),BorderLayout.SOUTH);
        jp3.add(new JPanel(),BorderLayout.EAST);
        jp3.add(new JPanel(),BorderLayout.WEST);
        jp3.add(new JPanel(),BorderLayout.NORTH);
        jp3.add(jp2);

        jf.add(jp4,BorderLayout.NORTH);
        jf.add(jp3,BorderLayout.SOUTH);
        jf.add(new JPanel(),BorderLayout.EAST);
        jf.add(new JPanel(),BorderLayout.WEST);
        jf.add(jp1);
        jf.setVisible(true);
    }
    public void show(){
        jf.setVisible(true);
    }
    public boolean check(){
        if(cmb.getSelectedIndex() ==0 || "".equals(t2.getText().trim())||"".equals(t3.getText().trim())){
            return false;
        }
        return true;
    }
}

