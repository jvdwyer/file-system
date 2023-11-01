import java.util.HashSet;
import java.util.Set;

class FileSystem {
    private Set<String> set;

    FileSystem() {
        set = new HashSet<>();
    }

    private boolean addFile(String file) {
        if (set.contains(file)) {
            return false;
        } else {
            set.add(file);
            return true;
        }
    }

    private boolean deleteFile(String file) {
        if (!set.contains(file)) {
            return false;
        } else {
            set.remove(file);
            return true;
        }
    }

    private boolean copyFile(String fromPath, String toPath) {
        if (set.contains(toPath)) {
            return false;
        }
    
        if (!set.contains(fromPath)) {
            return false;
        }

        return addFile(toPath);
    }

    private void printFileSystem() {
        System.out.println("System contents is (are): ");
        for (String file : set) {
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        String[][] operations = {
            {"add", "file1"}, 
            {"delete", "file2"}, 
            {"add", "/file2"}, 
            {"delete", "file1"},
            {"add", "dir1/file4"},
            {"copy", "file1", "file3"},
            {"add", "file1"},
            {"copy", "file1", "file2"},
        };
        FileSystem fileSystem = new FileSystem();

        for (String[] operation : operations) {
            if (operation[0].equals("add")) {
                System.out.println(fileSystem.addFile(operation[1]));
            } else if (operation[0].equals("delete")) {
                System.out.println(fileSystem.deleteFile(operation[1]));
            } else if (operation[0].equals("copy")) {
                System.out.println(fileSystem.copyFile(operation[1], operation[2]));
            }
        }

        fileSystem.printFileSystem();
    }
}