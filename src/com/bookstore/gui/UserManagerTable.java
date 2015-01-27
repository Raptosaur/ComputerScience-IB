package com.bookstore.gui;

import com.bookstore.data.UserList;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Elijah on 27/01/2015.
 */
public class UserManagerTable extends AbstractTableModel {


    String[] columnNames = {"Username", "Real Name", "Admin"};
    Object[][] data = UserList.usersTo2DArray();

    public String getColumnName(int col) {
        return columnNames[col].toString();
    }

    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public boolean isCellEditable(int row, int col){
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
