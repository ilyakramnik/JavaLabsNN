import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * a class for processing an input file and writing data to another file
 */
public class FileHandler {
    int[] dict = new int[52];

    /**
     * counts the number of uses of large and small english letters in the file
     * @param selectedFile file which user have chosen
     */
    public void readFile(File selectedFile) {
        Arrays.fill(dict, 0);
        try (FileReader reader = new FileReader(selectedFile)) {
            int c;
            while ((c = reader.read()) != -1) {
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    int ind = -1;
                    if (Character.isUpperCase(c)) {
                        ind = c - 'A' + 26;
                    } else if (Character.isLowerCase(c)) {
                        ind = c - 'a';
                    }
                    ++dict[ind];
                }
            }
        } catch (IOException ex) {
            System.out.println("The name of the file is wrong. Please try again");
        }
    }

    /**
     * writes the number of uses of English letters to a new file
     * @param writer allows to write lines in new file
     * @throws IOException if file hasn't found
     */
    public void writeToFile(FileWriter writer) throws IOException {
        for (int i = 0; i < 52; ++i) {
            char letter;
            if (i < 26) {
                letter = (char) ('a' + i);
            } else {
                letter = (char) ('A' + i - 26);
            }
            writer.write(letter + ": " + dict[i]);
            writer.append('\n');
        }
    }
}