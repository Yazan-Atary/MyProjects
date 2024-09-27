package datastructurebtec;
import java.util.ArrayList;


public class Folder {
    public String name;
    public Folder parentFolder;
    public ArrayList<File> files;

    public Folder(String name, Folder parentFolder, ArrayList<File> files) {
        this.name = name;
        this.parentFolder = parentFolder;
        this.files = files;
    }

    public Folder(String name, Folder parentFolder) {
        this(name, parentFolder, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parentFolder;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void addFolder(Folder folder) {
        files.add(new File(folder.getName(), folder.hashCode(), parentFolder));
    }

    public void addFile(File file) {
        files.add(file);
    }

    // Linear search method based on file ID
    public File linearSearch(int targetID) {
        for (File file : files) {
            if (file.getID() == targetID) {
                return file; // Target ID found
            }
        }
        return null; // Target ID not found
    }
  // Bubble Sort method to sort files by ID
    public void bubbleSort() {
        int n = files.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (files.get(j).getID() > files.get(j + 1).getID()) {
                    // swap temp and arr[i]
                    File temp = files.get(j);
                    files.set(j, files.get(j + 1));
                    files.set(j + 1, temp);
                }
            }
        }
    }
    // Binary search method based on file ID (assumes files are sorted by ID)
    public File binarySearch(int targetID) {
        int left = 0;
        int right = files.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (files.get(mid).getID() == targetID) {
                return files.get(mid); // Target ID found
            } else if (files.get(mid).getID() < targetID) {
                left = mid + 1; // Target ID is in the right half
            } else {
                right = mid - 1; // Target ID is in the left half
            }
        }

        return null; // Target ID not found
    }
    // Print the content of the array
    public void printFiles() {
        System.out.println("Files in Folder '" + name + "':");
        for (File file : files) {
            System.out.println("File Name: " + file.getName() + ", File ID: " + file.getID());
        }
    }
}