import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * implements a graphical interface
 */
public class GUI extends JFrame {
    private File selectedFile;
    private final JTextArea textArea;

    /**
     * creates the main window with 2 buttons
     */
    public GUI() {
        setTitle("File Analyzer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JButton openFileButton = new JButton("Open File");
        openFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        JButton analyzeButton = new JButton("Analyze File");
        analyzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String outputFile = JOptionPane.showInputDialog("Enter the name of output file:");
                JPanel panel = new JPanel();
                add(panel);
                try {
                    analyzeFile(outputFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openFileButton);
        buttonPanel.add(analyzeButton);
        add(buttonPanel, BorderLayout.NORTH);

        textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
    }

    /**
     * opens selected by user file
     */
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }
    }

    /**
     * counts the number of uses of large and small english letters in the file
     * and writes it in the chosen file
     * @param outputFile file where we want to write the answer
     * @throws IOException if file hasn't found
     */
    private void analyzeFile(String outputFile) throws IOException {
        if (selectedFile == null) {
            textArea.setText("No file selected");
            add(textArea, BorderLayout.CENTER);
            return;
        }

        FileHandler fileHandler = new FileHandler();
        fileHandler.readFile(selectedFile);

        try (FileWriter writer = new FileWriter(outputFile, false)) {
            fileHandler.writeToFile(writer);
            textArea.setText("File analyzed. Results written to " + outputFile);
            add(textArea, BorderLayout.CENTER);
        }
        catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error analyzing file: " + e.getMessage());
            add(textArea, BorderLayout.CENTER);
        }
    }
}