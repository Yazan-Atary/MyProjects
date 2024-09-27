package datastructurebtec;

import java.util.ArrayList;
import java.util.List;

public class DataStructureBtec {

    public static void main(String[] args) {
        
        // Test Case 1: Creating a file with missing ID
        try {
            File fileWithMissingID = new File("FileWithMissingID.txt", 0, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test Case 2: Creating a file with a duplicate ID
        Folder rootFolder = new Folder("Root", null);
        Folder subfolder = new Folder("Subfolder", rootFolder);

        List<File> filesToCreate = createFiles(1, 5);

        // Adding a file with ID 3 to simulate a duplicate ID
        File fileWithDuplicateID = new File("DuplicateFile.txt", 3, null);
        subfolder.addFile(filesToCreate.get(2)); // Adding a file with ID 3 (duplicate)

        try {
            subfolder.addFile(fileWithDuplicateID);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Print the files in the subfolder after adding valid files
        subfolder.printFiles();
    }

    public static List<File> createFiles(int startIndex, int endIndex) {
        List<File> files = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            files.add(new File("SubfolderFile" + i + ".txt", i, null));
        }
        return files;
    }
}
