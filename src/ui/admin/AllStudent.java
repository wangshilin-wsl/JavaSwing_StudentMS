package ui.admin;

import dao.StudentDao;
import pojo.Student;
import utils.JTableUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class AllStudent {
    JButton jb=new JButton("查询");
    JButton jb1=new JButton("添加");
    JButton jb2=new JButton("退出");
    JFrame jf=new JFrame("所有学生");
    JLabel jLabel = new JLabel("学生姓名:",JLabel.RIGHT);
    JTextField jt=new JTextField(50);
    JScrollPane sp=new JScrollPane();
    AllStudent allStudent;

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO 自动生成的方法存根
            if(e.getSource()==jb) {
                search();
            }
            if(e.getSource() == jb1){
                new AddStudent(allStudent).add();
            }
            if(e.getSource() == jb2){
                jf.setVisible(false);
            }
        }
    }

    public void total(AllStudent allStudent) {
        this.allStudent = allStudent;
        search();
        jb.addActionListener(new MyListener());
        jb1.addActionListener(new MyListener());
        jb2.addActionListener(new MyListener());
        jf.setBounds(100, 100, 1500,800);
        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(1,100,10,10));

        Font font=new Font("黑体",Font.BOLD,20);
        jt.setFont(font);
        jLabel.setFont(font);
        jb.setFont(font);
        jb1.setFont(font);
        jb2.setFont(font);

        jp.add(jLabel);
        jp.add(jt);
        jp.add(jb);
        jp.add(jb1);
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
        List<Student> all = new StudentDao().findAllStudent(jt.getText());

        String[] columeName= {"学号","姓名","性别","年级","年龄","班级","专业","学院"};
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
        String[][] values= new String[all.size()][8];
        for (int i = 0; i < all.size(); i++) {
            values[i][0] = String.valueOf(all.get(i).getStudentNum());
            values[i][1] = all.get(i).getName();
            values[i][2] = all.get(i).getSex();
            values[i][3] = all.get(i).getGrade();
            values[i][4] = String.valueOf(all.get(i).getAge());
            values[i][5] = all.get(i).getClas();
            values[i][6] = all.get(i).getMajor();
            values[i][7] = all.get(i).getDept();
        }
        model=new DefaultTableModel(values,columeName);
        table=new JTable(model);
        table.setBackground(Color.CYAN);
        Font font = new Font("黑体", Font.BOLD, 20);
        table.setFont(font);
        JTableUtils.setTableStyle(table);
        table.getTableHeader().setFont(font);
        sp=new JScrollPane(table);
        //sp.add(table);
        jf.add(sp);
        jf.validate();
    }
}
