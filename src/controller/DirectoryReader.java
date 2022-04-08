package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import model.Data;
import views.MainView;

/**
 *
 * @author Rafael Justo
 */
public class DirectoryReader {

    int otherFilesCount = 0;
    int otherTotalLines = 0;

    public Data readDirectory(File directory, String extension, boolean others) throws Exception {
        int filesCount = 0;
        int totalLines = 0;
        Data result = new Data("", 0, 0);
        ArrayList<File> files = search(directory, others, extension);

        for (File f : files) {
            filesCount++;
            totalLines += countLines(f.getPath());
        }
//        result += "Total de arquivos: " + filesCount + "\n";
//        result += "Total de linhas: " + totalLines;
        if (others) {
            result = new Data("Total", filesCount, totalLines);
        } else {
            result = new Data(extension, filesCount, totalLines);           
        }

        return result;
    }

    public int countLines(String path) throws Exception {

        Scanner s = new Scanner(new File(path));
        int i = 0;

        while (s.hasNextLine()) {
            i++;
            s.nextLine();
        }

        return i;
    }

    private ArrayList search(File root, boolean others, String... extensions) {
        ArrayList<File> resultado = new ArrayList<>();

        for (File f : root.listFiles()) {
            if (f.isDirectory()) {
                resultado.addAll(search(f, others, extensions));
            } else {
                if (chechExtension(f, extensions)) { // verifica a extensão do arquivo
                    resultado.add(f);
                } else if(others){
                                    
                    resultado.add(f);
                }
            }
        }

        return resultado;
    }

    private static boolean chechExtension(File file, String... extensions) {
        for (String extension : extensions) {
            if (file.getName().endsWith(extension)) {
                return true;
            }
        }

        return false;
    }
}
