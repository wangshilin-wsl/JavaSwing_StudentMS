package ui.admin;

import dao.TeacherDao;
import pojo.Teacher;
import utils.JTableUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class AllTeacher {
    JButton jb=new JButton("查询");
    JButton jb1=new JButton("添加");
    JButton jb2=new JButton("退出");
    JFrame jf=new JFrame("所有老师");
    JLabel jLabel = new JLabel("老师名字:",JLabel.RIGHT);
    JTextField jt=new JTextField(50);
    JScrollPane sp=new JScrollPane();
    AllTeacher allTeacher;

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO 自动生成的方法存根
            if(e.getSource()==jb) {
                search();
            }
            if(e.getSource() == jb1){
                new AddTeacher(allTeacher).add();
            }
            if(e.getSource() == jb2){
                jf.setVisible(false);
            }
        }
    }

    public void total(AllTeacher allTeacher) {
        this.allTeacher = allTeacher;
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
        List<Teacher> all = new TeacherDao().findAllTeacher(jt.getText());

        String[] columeName= {"工号","姓名","性别","年龄","学院","职位"};
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
            values[i][0] = String.valueOf(all.get(i).getTeacherNum());
            values[i][1] = all.get(i).getName();
            values[i][2] = all.get(i).getSex();
            values[i][3] = String.valueOf(all.get(i).getAge());
            values[i][4] = all.get(i).getDept();
            values[i][5] = all.get(i).getWork();
        }
        model=new DefaultTableModel(values,columeName);
        table=new JTable(model);
        table.setBackground(Color.CYAN);
        Font font = new Font("黑体", Font.BOLD, 20);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        JTableUtils.setTableStyle(table);
        sp=new JScrollPane(table);
        //sp.add(table);
        jf.add(sp);
        jf.validate();
    }
}
