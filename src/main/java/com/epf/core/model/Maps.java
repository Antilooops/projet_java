package com.epf.core.model;

import com.epf.core.exception.BadAttributeException;

public class Maps {
    private int id;
    private int rows;
    private int columns;
    private String imagePath;

    public Maps() {
    }

    public Maps(int id, int rows, int columns, String imagePath) {
        this.id = id;
        this.rows = rows;
        this.columns = columns;
        this.imagePath = imagePath;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) throws BadAttributeException {
        if (id < 0) {
            throw new BadAttributeException("Id not set correctly. Cannot be less than 0.");
        } else {
            this.id = id;
        }
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) throws BadAttributeException {
        if (rows <= 0) {
            throw new BadAttributeException("Rows not set correctly. Cannot be less than or equal to 0.");
        } else if (rows > 15) {
            throw new BadAttributeException("Rows not set correctly. Cannot be more than 15.");
        } else {
            this.rows = rows;
        }
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int columns) throws BadAttributeException {
        if (columns <= 5) {
            throw new BadAttributeException("Columns not set correctly. Cannot be less than or equal to 5.");
        } else if (columns > 20) {
            throw new BadAttributeException("Columns not set correctly. Cannot be more than 20.");
        } else {
            this.columns = columns;
        }
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) throws BadAttributeException {
        if (imagePath == null || imagePath.length() <= 255) {
            this.imagePath = imagePath;
        } else {
            throw new BadAttributeException("Name not set correctly. Name to long.");
        }
    }

    @Override
    public String toString() {
        return "Maps : id=" + this.id + ", rows=" + this.rows + ", columns=" + this.columns +
                        ", imagepath=" + this.imagePath;
    }
}
