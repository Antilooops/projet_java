package com.epf.core.model;

import com.epf.core.exception.BadAttributException;

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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) throws BadAttributException {
        if (rows <= 0) {
            throw new BadAttributException("Rows not set correctly. Cannot be less than or equal to 0.");
        } else if (rows > 15) {
            throw new BadAttributException("Rows not set correctly. Cannot be more than 15.");
        } else {
            this.rows = rows;
        }
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) throws BadAttributException {
        if (columns <= 5) {
            throw new BadAttributException("Columns not set correctly. Cannot be less than or equal to 5.");
        } else if (columns > 20) {
            throw new BadAttributException("Columns not set correctly. Cannot be more than 20.");
        } else {
            this.columns = columns;
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Maps : id=" + this.id + ", rows=" + this.rows + ", columns=" + this.columns +
                        ", imagepath=" + this.imagePath;
    }
}
