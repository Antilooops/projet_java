package com.epf.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapsDTO {
    @JsonProperty("id_map")
    private int id;
    @JsonProperty("ligne")
    private int rows;
    @JsonProperty("colonne")
    private int columns;
    @JsonProperty("chemin_image")
    private String imagePath;

    public MapsDTO() {
    }

    public MapsDTO(int id, int rows, int columns, String imagePath) {
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
        return "MapsDTO : id=" + this.id + ", rows=" + this.rows + ", columns=" + this.columns +
                        ", imagepath=" + this.imagePath;
    }
}
