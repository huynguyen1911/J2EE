import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        String msg = """
                Chương trình quản lý sách
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách
                3. Thay đổi sách
                4. Xuất thông tin
                5. Tìm sách Lập trình
                6. Lấy sách tối đa theo giá
                7. Tìm kiếm theo tác giả
                0. Thoát
                Chọn chức năng:""";

        int chon = 0;
        do {
            System.out.println(msg);
            chon = x.nextInt();
            x.nextLine(); // Đọc bỏ dòng mới

            switch (chon) {
                case 1 -> {
                    // Thêm 1 cuốn sách
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                    System.out.println("Đã thêm sách thành công!");
                }

                case 2 -> {
                    // Xóa 1 cuốn sách
                    System.out.print("Nhập vào mã sách cần xóa: ");
                    int bookId = x.nextInt();
                    x.nextLine(); // Đọc bỏ dòng mới

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);

                    if (find != null) {
                        listBook.remove(find);
                        System.out.println("Đã xóa sách thành công!");
                    } else {
                        System.out.println("Không tìm thấy sách có mã: " + bookId);
                    }
                }

                case 3 -> {
                    // Thay đổi sách
                    System.out.print("Nhập vào mã sách cần điều chỉnh: ");
                    int bookId = x.nextInt();
                    x.nextLine(); // Đọc bỏ dòng mới

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);

                    if (find != null) {
                        System.out.println("Nhập thông tin mới cho sách:");
                        find.input();
                        System.out.println("Đã cập nhật sách thành công!");
                    } else {
                        System.out.println("Không tìm thấy sách có mã: " + bookId);
                    }
                }

                case 4 -> {
                    // Xuất thông tin tất cả sách
                    System.out.println("\n=== DANH SÁCH TẤT CẢ SÁCH ===");
                    if (listBook.isEmpty()) {
                        System.out.println("Danh sách sách trống!");
                    } else {
                        listBook.forEach(Book::output);
                    }
                    System.out.println("==============================\n");
                }

                case 5 -> {
                    // Tìm cuốn sách có tựa đề chứa chữ "Lập trình" (không phân biệt hoa thường)
                    System.out.println("\n=== SÁCH CÓ TỰA ĐỀ CHỨA 'LẬP TRÌNH' ===");
                    List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle().toLowerCase().contains("lập trình"))
                            .toList();

                    if (list5.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào!");
                    } else {
                        list5.forEach(Book::output);
                    }
                    System.out.println("=========================================\n");
                }

                case 6 -> {
                    // Lấy sách: Nhập vào 1 số K và giá sách P mong muốn tìm kiếm
                    // Hãy lấy tối đa K cuốn sách đều thỏa mãn có giá sách <= P
                    System.out.print("Nhập số lượng sách K cần lấy: ");
                    int K = x.nextInt();
                    System.out.print("Nhập giá sách P tối đa: ");
                    double P = x.nextDouble();
                    x.nextLine(); // Đọc bỏ dòng mới

                    System.out.println("\n=== SÁCH CÓ GIÁ <= " + P + " (TỐI ĐA " + K + " CUỐN) ===");
                    List<Book> list6 = listBook.stream()
                            .filter(p -> p.getPrice() <= P)
                            .limit(K)
                            .toList();

                    if (list6.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào!");
                    } else {
                        list6.forEach(Book::output);
                    }
                    System.out.println("=================================================\n");
                }

                case 7 -> {
                    // Nhập vào 1 danh sách các tác giả từ bàn phím
                    // Hãy cho biết tất cả cuốn sách của những tác giả này?
                    System.out.print("Nhập số lượng tác giả: ");
                    int n = x.nextInt();
                    x.nextLine(); // Đọc bỏ dòng mới

                    List<String> authors = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập tên tác giả thứ " + (i + 1) + ": ");
                        authors.add(x.nextLine().trim());
                    }

                    System.out.println("\n=== SÁCH CỦA CÁC TÁC GIẢ ĐÃ NHẬP ===");
                    List<Book> list7 = listBook.stream()
                            .filter(book -> authors.stream()
                                    .anyMatch(author -> book.getAuthor().equalsIgnoreCase(author)))
                            .toList();

                    if (list7.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào!");
                    } else {
                        list7.forEach(Book::output);
                    }
                    System.out.println("=====================================\n");
                }

                case 0 -> {
                    System.out.println("Thoát chương trình. Tạm biệt!");
                }

                default -> {
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                }
            }

        } while (chon != 0);

        x.close();
    }
}
