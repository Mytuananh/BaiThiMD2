package view;

import controller.DirectoryManager;
import model.Directory;
import strorage.DirectoryReadWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class DirectoryView {
    DirectoryReadWriteFile directoryReadWriteFile = DirectoryReadWriteFile.getInstance();
    public void run() {
        DirectoryManager directoryManager = DirectoryManager.getInstance();


        int choice = -2;

        while (choice != 8) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---MenuDirectory---");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Ghi từ file");
            System.out.println("7. Đọc vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Xem danh sách");
                    directoryManager.showAllDirectory();
                    break;
                }
                case 2: {
                    System.out.println("2. Thêm mới");
                    directoryManager.addNewDirectory(input());
                    break;
                }
                case 3: {
                    System.out.println("3. Cập nhật");
                    editDirectory(directoryManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Xóa");
                    removeDirectory(directoryManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Tìm kiếm");
                    searchDirectory(directoryManager);
                    break;
                }
                case 6: {
                    System.out.println("6. Ghi từ file");
                    writeFile(directoryManager);
                    break;
                }
                case 7: {
                    System.out.println("7. Đọc vào file");
                    readFile(directoryManager);
                    break;
                }
                case 8:
            }
        }
    }

    public static Directory input() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập SĐT: ");
        String phoneNumber = scanner1.nextLine();

        System.out.println("Nhập họ và tên: ");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();

        System.out.println("Nhập giới tính: ");
        Scanner scanner2 = new Scanner(System.in);
        String sex = scanner2.nextLine();

        System.out.println("Nhập địa chỉ: ");
        Scanner scanner3 = new Scanner(System.in);
        String address = scanner3.nextLine();

        System.out.println("Nhập tên nhóm: ");
        Scanner scanner4 = new Scanner(System.in);
        String group = scanner4.nextLine();

        System.out.println("Nhập ngày tháng năm sinh: ");
        Scanner scanner5 = new Scanner(System.in);
        String dateOfBirth = scanner5.nextLine();

        System.out.println("Nhập email: ");
        Scanner scanner6 = new Scanner(System.in);
        String email = scanner6.nextLine();

        return new Directory(phoneNumber, fullName, sex, address, group, dateOfBirth, email);
    }

    private void editDirectory(DirectoryManager directoryManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập SĐT: ");
        String phoneNumber = scanner.nextLine();
        directoryManager.editDirectory(phoneNumber, input());
    }

    private void removeDirectory(DirectoryManager directoryManager) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Nhập SĐT: ");
        String phoneNumber = scanner.nextLine();
        directoryManager.removeDirectory(phoneNumber);
    }

    private void searchDirectory(DirectoryManager directoryManager) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Nhập SĐT: ");
        String phoneNumber = scanner.nextLine();
        Directory directory =  directoryManager.searchDirectory(phoneNumber);
        if (directory != null) {
            System.out.println(directory);
        } else {
            System.out.println("Not found directory!");
        }
        }


    private void writeFile(DirectoryManager directoryManager) {
       try {
           directoryReadWriteFile.writeFile(directoryManager.getDirectoryArrayList());
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    private void readFile(DirectoryManager directoryManager) {
        try {
           directoryManager.setDirectoryArrayList(directoryReadWriteFile.readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
