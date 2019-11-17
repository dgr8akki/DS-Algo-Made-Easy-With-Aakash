import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * FileIO
 */
public class FileIO {

  public List<String> read(String path) {
    File file = new File(path);
    List<String> results = new ArrayList<>();
    try {
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()) {
        String word = sc.nextLine();
        results.add(word);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return results;
  }

  public static void main(String[] args) {
    FileIO fileIO = new FileIO();
    String path = "data.txt";
    fileIO.read(path);
  }
}
