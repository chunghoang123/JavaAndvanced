package session05;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products;
    public ProductManager() {
        products = new ArrayList<>();
    }
    public void addProduct(Product product) throws InvalidProductException {
        boolean exists = products.stream()
                .anyMatch(p -> p.getId() == product.getId());
        if (exists){
            throw new InvalidProductException("Sản phẩm với ID " + product.getId() + " đã tồn tại!");
        }
        products.add(product);
        System.out.println("Đã thêm sản phẩm thành công!");
    }
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.println("danh sach san pham");
        System.out.println("ID | Ten SP | Gia | SL | Danh Muc " );
        System.out.println("-----------------------------------");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("-----------------------------------");
        System.out.println("Tong so san pham: " + products.size());

    }
    public void updateQuantity(int id, int newQuantity) throws InvalidProductException {
        Optional<Product> productOpt = products.stream().filter(p -> p.getId() == id).findFirst();
        if (productOpt.isPresent()){
            Product product = productOpt.get();
            product.setQuantity(newQuantity);
            System.out.println("Đã cập nhật số lượng sản phẩm ID " + id + " thành công!");
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm với ID " + id);
        }
    }
    public void deleteOutOfStockProducts() {
        int inittialSize = products.size();

        products.removeIf(product -> product.getQuantity() == 0);

        int deletecout = inittialSize - products.size();

        if (deletecout > 0){
            System.out.println("Đã xóa " + deletecout + " sản phẩm đã hết hàng!");

        }else {
            System.out.println("Không có sản phẩm nào hết hàng!");
        }

    }
    public Product inputProduct(Scanner scanner) {
        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập danh mục: ");
        String category = scanner.nextLine();

        return new Product(id, name, price, quantity, category);
    }
}
