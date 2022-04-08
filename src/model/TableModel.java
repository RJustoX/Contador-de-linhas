package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private ArrayList<Data> rows;
    public String[] collumns = new String[]{"Extensão", "Arquivos", "Linhas"};

    public TableModel() {
        rows = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return collumns[column];
    }

    public void adicionaLinha(Data data) {
        rows.add(data);
        fireTableRowsInserted(rows.size() - 1, rows.size() - 1);
    }

    public Data getLinha(int linha) {
        return rows.get(linha);
    }

    public void removeLinha(int row) {
        rows.remove(row);
        fireTableRowsDeleted(row, row);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Data a = rows.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.getExtension();
            case 1:
                return a.getFiles();
            case 2:
                return a.getLines();
            default:
                throw new IndexOutOfBoundsException();
        }
    }
 

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }
}
