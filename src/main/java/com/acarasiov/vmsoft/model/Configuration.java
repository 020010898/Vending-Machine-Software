package com.acarasiov.vmsoft.model;

public class Configuration {
    public static int rows;

    public static String columns;

    public Configuration() {
    }

    public Configuration(int rows, String columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public static int intColumn(){
        return Integer.parseInt(columns);
    }
    public static int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Product{" +
                "rows=" + rows +
                ", columns='" + columns + '\'' +
                '}';
    }
}
