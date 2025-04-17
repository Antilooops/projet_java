package com.epf.persistance.entity;

public class MapsEntity {
    private int id;
    private int rows;
    private int columns;
    private String imagePath;

    public MapsEntity() {
    }

    public MapsEntity(int id, int rows, int columns, String imagePath) {
        this.id = id;
        this.rows = rows;
        this.columns = columns;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "MapsEntity : id=" + this.id + ", rows=" + this.rows + ", columns=" + this.columns +
                        ", imagepath=" + this.imagePath;
    }
}
