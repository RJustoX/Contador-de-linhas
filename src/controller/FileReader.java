package code;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Rafael Justo
 */
public class FileReader {
    public int readFile(String path) throws Exception{
        System.out.println("teste");
        Scanner s = new Scanner(new File(path));
          int i = 0;
        
        while(s.hasNextLine()){
            i++;
            s.nextLine();          
        }
        System.out.println("Total de linha" + i);
       return i;
    }
}
