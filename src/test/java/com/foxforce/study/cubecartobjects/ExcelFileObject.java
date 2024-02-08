package com.foxforce.study.cubecartobjects;

public class ExcelFileObject {
    private String file;
    private String sheet;

    public ExcelFileObject() {
    }

    public ExcelFileObject(String file, String sheet) {
        this.file = file;
        this.sheet = sheet;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }
}
