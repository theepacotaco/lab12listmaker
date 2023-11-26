import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Use JFileChooser to let the user choose a file
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        // Check if the user selected a file
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Call the method to process the file and print the summary
            printFileSummary(selectedFile);
        } else {
            System.out.println("No file selected. Exiting program.");
        }
    }

    private static void printFileSummary(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Variables to store counts
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            // Read each line and update counts
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += line.split("\\s+").length; // Split by whitespace to count words
                charCount += line.length();
            }

            // Print summary report
            System.out.println("File Summary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
