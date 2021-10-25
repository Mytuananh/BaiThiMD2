package strorage;

import model.Directory;

import java.io.*;
import java.util.ArrayList;

public class DirectoryReadWriteFile {
    private static DirectoryReadWriteFile directoryReadWriteFile;
    private DirectoryReadWriteFile() {
    }

    public static DirectoryReadWriteFile getInstance() {
        if (directoryReadWriteFile == null) {
            directoryReadWriteFile = new DirectoryReadWriteFile();
        }
        return directoryReadWriteFile;
    }

    public ArrayList<Directory> readFile() throws IOException, ClassNotFoundException {
        File file = new File("directory.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<Directory> directoryArrayList  = (ArrayList<Directory>) object;
            objectInputStream.close();
            fileInputStream.close();
            return directoryArrayList;
        }
        else return new ArrayList<>();
    }

    public void writeFile(ArrayList<Directory> directoryArrayList) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("directory.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(directoryArrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
