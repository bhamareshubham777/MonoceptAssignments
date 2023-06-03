package com.techlabs.files;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandling {
	public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        scanner.close();

        File file = new File(fileName);
        
        System.out.println("Number of lines: " + countLines(file));
        System.out.println("Number of words: " + countWords(file));
        System.out.println("Number of characters: " + countCharacters(file));
        
    }

    public static int countLines(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lineCount++;
        }
        scanner.close();
        return lineCount;
    }

    public static int countWords(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int wordCount = 0;
        while (scanner.hasNext()) {
            scanner.next();
            wordCount++;
        }
        scanner.close();
        return wordCount;
    }

    public static int countCharacters(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int characterCount = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            characterCount += line.replaceAll("\\s", "").length();
        }
        scanner.close();
        return characterCount;
    }
}


