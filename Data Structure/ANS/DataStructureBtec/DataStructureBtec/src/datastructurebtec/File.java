package datastructurebtec;

public class File {

    public String name;
    public int id;
    public Folder parentFolder;

    public File(String name, int id, Folder parentFolder) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Missing or empty file name.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Error: Missing or invalid ID for file " + name + ".");
        }

        this.name = name;
        this.id = id;
        this.parentFolder = parentFolder;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parentFolder;
    }

}
