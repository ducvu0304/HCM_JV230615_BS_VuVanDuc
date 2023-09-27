package ra.bussiness;

import java.awt.*;
import java.util.Scanner;

public class Book {
    private static int count = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;

    /**Constructor*/
    public Book() {
    }

    /**Getter & Setter*/
    public int getBookId() {
        return bookId;
    }

    public void setBookId() {
        this.bookId = count++;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest() {

        this.interest = (float) (exportPrice - importPrice);
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * name: inputData
     * */
    public void inputData(Scanner scanner) {
        /***/
        this.bookId = count++;

        /**Book name*/
       do {
           System.out.println("Xin mời nhập tên sách");
           this.bookName = scanner.nextLine().trim();

           if(this.bookName.equals("")){
               System.err.println("Tên sách không được để trống!");
           }
       }while (this.bookName.equals(""));

        /**Author*/
        do {
            System.out.println("Xin mời nhập tên tác giả");
            this.author = scanner.nextLine().trim();

            if(this.bookName.equals("")){
                System.err.println("Tên tác giả không được để trống!");
            }
        }while (this.author.equals(""));

        /**Descriptions*/
        do {
            System.out.println("Xin mời nhập mô tả");
            this.descriptions = scanner.nextLine().trim();

            if(this.descriptions.length() < 10){
                System.err.println("Mô tả ít nhất 10 ký tự!");
            }
        }while (this.descriptions.length() < 10);

        /**Import price*/
        do {
            try {
                System.out.println("Xin mời nhập \"giá nhập\":");
                this.importPrice = Double.parseDouble(scanner.nextLine().trim());

                if(this.importPrice <= 0){
                    System.err.println("Giá nhập phải lớn hơn 0");
                }
            }catch (Exception e) {
                System.err.println("Nhập sai định dạng");
            }

        }while (this.importPrice <= 0);

        /**Export price*/
        do {
            try {
                System.out.println("Xin mời nhập \"giá xuất\":");
                this.exportPrice = Double.parseDouble(scanner.nextLine().trim());

                if(this.exportPrice < this.importPrice * 1.2){
                    System.err.println("Giá xuất phải lớn hơn 1.2 giá nhập");
                }

            }catch (Exception e) {
                System.err.println("Nhập sai định dạng");
            }

        }while (this.exportPrice < this.importPrice*1.2);


        /**Interest*/
        this.interest = (float)(this.exportPrice - this.importPrice);

    }

    /**Update status*/
    public void updateStatus(){
        this.bookStatus = !this.bookStatus;
    }

    /**
     * name: displayData
     * */
    public void displayData(){
        System.out.printf("*****Thông tin sách %s ********** \n", this.bookName);
        System.out.printf("%d. %s\n" +
                          "Tác giả: %s\n" +
                          "Mô tả về sách: %s\n" +
                          "Giá nhập: %.2f - Giá xuất: %.2f \n" +
                          "Lợi nhuận: %.3f\n" +
                          "Trạng thái: %s\n",
                this.bookId, this.bookName, this.author,  this.descriptions, this.importPrice,
                this.exportPrice, this.interest, (this.bookStatus ? "Đang bán" : "Hết hàng"));
    }
}
