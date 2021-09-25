package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Enumeration;

public class JTableUtils {
    public static void setTableStyle(JTable jtb) {

        //设置选中行的背景色
        //jtb.setSelectionBackground(new Color(224, 242, 255));

        //设置表格每行的高度
        jtb.setRowHeight(35);

        // 设置点击表头自动实现排序
        jtb.setAutoCreateRowSorter(false);
        // 设置表头文字居中显示
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtb.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(renderer.CENTER);

        // 设置表格中的数据居中显示
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        jtb.setDefaultRenderer(Object.class,r);

        jtb.setFocusable(false);

        jtb.setFont(new Font("新宋体", Font.PLAIN, 18));
        fitTableColumns(jtb);
    }

    // 根据内容自动调节表格的列宽度
    @SuppressWarnings("rawtypes")
    private static void fitTableColumns(JTable myTable)
    {
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTableHeader header = myTable.getTableHeader();
        int rowCount = myTable.getRowCount();
        Enumeration columns = myTable.getColumnModel().getColumns();
        while(columns.hasMoreElements())
        {
            TableColumn column = (TableColumn)columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int)header.getDefaultRenderer().getTableCellRendererComponent
                    (myTable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
            for(int row = 0; row < rowCount; row++)
            {
                int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent
                        (myTable, myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // 此行很重要
            column.setWidth(width+myTable.getIntercellSpacing().width);
        }
    }
}
