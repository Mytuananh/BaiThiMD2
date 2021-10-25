package controller;

import model.Directory;

import java.util.ArrayList;

public class DirectoryManager {
    private static DirectoryManager directoryManager = new DirectoryManager();
    ArrayList<Directory> directoryArrayList = new ArrayList<>();
    private  DirectoryManager() {
    }

    public static DirectoryManager getInstance() {
        return directoryManager;
    }

    public DirectoryManager(ArrayList<Directory> directoryArrayList) {
        this.directoryArrayList = directoryArrayList;
    }

    public ArrayList<Directory> getDirectoryArrayList() {
        return directoryArrayList;
    }

    public void setDirectoryArrayList(ArrayList<Directory> directoryArrayList) {
        this.directoryArrayList = directoryArrayList;
    }

    public void addNewDirectory(Directory directory) {
        directoryArrayList.add(directory);
    }

    public void removeDirectory(String phoneNumber) {
        if (directoryArrayList != null) {
            for (int i = 0; i < directoryArrayList.size(); i++) {
                if (directoryArrayList.get(i).getPhoneNumber().equals(phoneNumber)) {
                    directoryArrayList.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("Not found!");
        }
    }

    public void editDirectory(String phoneNumber, Directory directory) {
        if (directoryArrayList != null) {
            for (int i = 0; i < directoryArrayList.size(); i++) {
                if (directoryArrayList.get(i).getPhoneNumber().equals(phoneNumber)) {
                    directoryArrayList.set(i,directory);
                    break;
                }
            }
        } else {
            System.out.println("Not found!");
        }
    }

    public Directory searchDirectory(String phoneNumber) {
        Directory directory = null;
        for (int i = 0; i < directoryArrayList.size(); i++) {
            if (directoryArrayList.get(i).getPhoneNumber().equals(phoneNumber)) {
                directory = directoryArrayList.get(i);
                break;
            }
        }
        return directory;
    }

    public void showAllDirectory() {
        for (Directory dir: directoryArrayList) {
            System.out.println(dir);
        }
    }
}
