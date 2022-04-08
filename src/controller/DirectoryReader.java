
package code;
import java.io.File; 
import java.util.ArrayList;
import java.util.Scanner; 

/**
 *
 * @author Rafael Justo
 */
public class DirectoryReader {

    int filesCount = 0;
    int totalLines = 0;

    public String readDirectory(File directory) throws Exception {
        String result = "";
        ArrayList<File> files = search(directory, "dart", "txt");

        for (File f : files) {
            filesCount++;
            totalLines += countLines(f.getPath());
        }
        result += "Total de arquivos: " + filesCount + "\n";
        result += "Total de linhas: " + totalLines;
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
    
    	private static ArrayList search(File root, String ... extensions) {
		ArrayList<File> resultado = new ArrayList<>();
		
		for(File f : root.listFiles()) {
			if(f.isDirectory()) {
				resultado.addAll(search(f, extensions));
			} else {
				if(chechExtension(f, extensions)) { // verifica a extensão do arquivo
					resultado.add(f);
				}
			}
		}
		
		return resultado;
	}
        
        	private static boolean chechExtension(File file, String ... extensions) {
		for(String extension : extensions) {
			if(file.getName().endsWith(extension)) {
				return true;
			}
		}
		
		return false;
	}
}
