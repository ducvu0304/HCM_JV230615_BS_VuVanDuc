package ra;

import ra.bussiness.Book;
import ra.utils.ScannerUtils;

import java.util.InputMismatchException;
import java.util.Scanner;


public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[100];
        int currentIndex = 0;
        int bookId = 0;

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            int chon = 0;

            try {
                System.out.println("Xin mời chọn chức năng:");
                chon = Integer.parseInt(scanner.nextLine().trim());
            } catch (InputMismatchException e) {
                System.err.println("Nhập sai định dạng xin mời nhập lại.");
            }


            switch (chon) {
                case 1:
                    System.out.println("Nhập số sách cần nhập:");
                    int n = ScannerUtils.inputInteger(scanner);

                    for (int i = 0; i < n; i++) {
                        Book book = new Book();
                        book.inputData(scanner);
                        books[currentIndex] = book;
                        currentIndex++;
                    }

                    System.out.println("Nhập thông tin sách thành công!");
                    break;
                case 2:
                    System.out.println("Hiển thị thông tin tất cả sách trong thư viện");
                    for (int i = 0; i < currentIndex; i++) {
                        books[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < currentIndex-1; i++) {
                        for (int j = i+1; j < currentIndex; j++) {
                            if (books[i].getInterest() > books[j].getInterest()) {
                                Book temp =  books[i];
                                books[i] = books[j];
                                books[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp danh sách thành công");
                    break;
                case 4:
                    try {
                        System.out.println("Xin mời nhập mã sách");
                        bookId = Integer.parseInt(scanner.nextLine().trim());
                    } catch (InputMismatchException e) {
                        System.err.println("Nhập sai định dạng");
                    }

                    int index = bookId - 1;

                    while (index < currentIndex - 1) {
                        books[index] = books[index + 1];
                        index++;
                    }
                    books[currentIndex] = null;
                    currentIndex--;
                    System.out.printf("Sách có id \"%d\" đã xóa thành công\n", bookId);
                    break;
                case 5:
                    System.out.println("Xin mời nhập tên sách hoặc mô tả về sách");
                    String find = scanner.nextLine();
                    boolean isExist = false;

                    for (int i = 0; i < currentIndex; i++) {
                        if (books[i].getBookName().contains(find) || books[i].getDescriptions().contains(find)) {
                            isExist = true;
                            books[i].displayData();
                            break;
                        }
                    }

                    if (!isExist) {
                        System.err.printf("Không tìm thấy sách có tên \"%s\" hoặc mô tả \"%s\"\n", find, find);
                    }

                    break;
                case 6:
                    try {
                        System.out.println("Xin mời nhập mã sách");
                        bookId = Integer.parseInt(scanner.nextLine().trim());
                    } catch (Exception e) {
                        System.err.println("Nhập sai định dạng");
                    }


                    if (bookId >= 1 && bookId <= currentIndex + 1) {
                        int i = bookId - 1;
                        books[i].displayData();
                        System.out.printf("********Cập nhật thông tin sách \"%s\"*********\n", books[i].getBookName());

                        /**Cập nhật tên sách*/
                        System.out.println("Xin mời nhập tên sách");
                        String bookName = scanner.nextLine().trim();

                        if (bookName != "") {
                            books[i].setBookName(bookName);
                        }

                        /**Cập nhật tên tác giả*/
                        System.out.println("Xin mời nhập tên tác giả");
                        String author = scanner.nextLine().trim();

                        if (author != "") {
                            books[i].setAuthor(author);
                        }

                        /**Cập nhật mô tả*/
                        boolean isLoop = true;
                        while (isLoop) {
                            System.out.println("Xin mời nhập mô tả");
                            String descriptions = scanner.nextLine().trim();

                            if (descriptions != "") {
                                if (descriptions.length() >= 10) {
                                    books[i].setBookName(descriptions);
                                    break;
                                } else {
                                    System.err.println("Mô tác ít nhất 10 ký tự. Xin mời nhập lại");
                                }
                            } else {
                                break;
                            }
                        }


                        /**Cập nhật giá nhập*/
                        while (isLoop) {
                            System.out.println("Xin mời nhập giá nhập");
                            String importPrice = scanner.nextLine().trim();

                            if (importPrice != "") {
                                try {
                                    books[i].setImportPrice(Double.parseDouble(importPrice));
                                    break;
                                } catch (Exception e) {
                                    System.err.println("Nhập sai dịnh dạng;");
                                }

                            } else {
                                break;
                            }
                        }

                        /**Cập nhật giá xuất*/
                        while (isLoop) {
                            System.out.println("Xin mời nhập giá nhập");
                            String exportPrice = scanner.nextLine().trim();

                            if (exportPrice != "") {
                                try {
                                    books[i].setImportPrice(Double.parseDouble(exportPrice));
                                    break;
                                } catch (Exception e) {
                                    System.err.println("Nhập sai dịnh dạng;");
                                }

                            } else {
                                break;
                            }
                        }
                        books[i].setInterest();

                    } else {
                        System.err.printf("Sách có mã \"%d\" không có trong thư viện \n", bookId);
                    }

                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("****************");
                    System.out.printf("Chức năng %d không có\n", chon);
            }
        }
    }
}
