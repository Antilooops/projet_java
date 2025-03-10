package com.epf.model;

public class Maps {
    private int id;
    private int lines;
    private int rows;
    private String imagePath;

    public Maps() {
    }

    public Maps(int id, int lines, int rows, String imagePath) {
        this.id = id;
        this.lines = lines;
        this.rows = rows;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
