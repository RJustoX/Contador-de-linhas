/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Rafael Justo
 */
public class Data {
    String extension;
    int files;
    int lines;

    public Data(String extension, int files, int lines) {
        this.extension = extension;
        this.files = files;
        this.lines = lines;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getFiles() {
        return files;
    }

    public void setFiles(int files) {
        this.files = files;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Data{" + "extension=" + extension + ", files=" + files + ", lines=" + lines + '}';
    }
    
}
