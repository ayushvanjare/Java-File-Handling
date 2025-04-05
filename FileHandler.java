package task1;

import java.io.*;
import java.util.Scanner;

public class FileHandler {

    public static void main(String[] args) {
        String filePath = "sample.txt";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1 - Write to file");
            System.out.println("2 - Read from file");
            System.out.println("3 - Modify file content");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter text to write to the file (type 'exit' to finish):");
                    while (true) {
                        String line = scanner.nextLine();
                        if (line.equalsIgnoreCase("exit")) {
                            break;
                        }
                        writeFile(filePath, line);
                    }
                    break;

                case 2:
                    readFile(filePath);
                    break;

                case 3:
                    System.out.print("Enter text to replace: ");
                    String oldText = scanner.nextLine();
                    System.out.print("Enter new text: ");
                    String newText = scanner.nextLine();
                    modifyFile(filePath, oldText, newText);
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void writeFile(String filePath, String content) {
        createFileIfNotExist(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Text written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
        }
    }

    public static void readFile(String filePath) {
        createFileIfNotExist(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("File content:");
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                isEmpty = false;
            }
            if (isEmpty) {
                System.out.println("[File is empty]");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }

    public static void modifyFile(String filePath, String oldText, String newText) {
        createFileIfNotExist(filePath);
        StringBuilder content = new StringBuilder();
        boolean isReplaced = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(oldText)) {
                    line = line.replace(oldText, newText);
                    isReplaced = true;
                }
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            return;
        }

        if (isReplaced) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(content.toString());
                System.out.println("File modified successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to the file.");
            }
        } else {
            System.out.println("Text to replace not found in the file.");
        }
    }

    public static void createFileIfNotExist(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + filePath);
                }
            } catch (IOException e) {
                System.out.println("Error creating the file.");
            }
        }
    }
}
