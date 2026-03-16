package Food;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import Food.service.*;
import Food.exception.*;
import Food.model.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static MenuService menuService = new MenuService();
    static OrderService orderService = new OrderService(menuService.getMenuList());

    public static void main(String[] args) throws DuplicateItemIdException {
            int choice;

            do {

                System.out.println("\n===== FAST FOOD MANAGEMENT =====");
                System.out.println("1. Menu Management");
                System.out.println("2. Order Management");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        menuManagement();
                        break;

                    case 2:
                        orderManagement();
                        break;

                    case 0:
                        System.out.println("Exit program");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 0);
    }
    public static void menuManagement() throws DuplicateItemIdException {

        int choice;

        do {

            System.out.println("\n---- MENU MANAGEMENT ----");
            System.out.println("1. Add item");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Search item");
            System.out.println("5. Show menu");
            System.out.println("0. Back");

            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addMenuItem();
                    break;

                case 2:
                    editMenuItem();
                    break;

                case 3:
                    deleteMenuItem();
                    break;

                case 4:
                    searchItem();
                    break;

                case 5:
                    menuService.showMenu();
                    break;

                case 0:
                    System.out.println("Back to main menu");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }
    public static void orderManagement() {

        int choice;

        do {

            System.out.println("\n---- ORDER MANAGEMENT ----");
            System.out.println("1. Create order");
            System.out.println("2. Add item to order");
            System.out.println("3. Pay order");
            System.out.println("4. Cancel order");
            System.out.println("5. Show orders");
            System.out.println("0. Back");

            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("moi ban nhap ten khach hang tao don: ");
                    orderService.createOrder(sc.nextLine());
                    break;

                case 2:
                    addItemToOrder();
                    break;

                case 3:
                    payOrderMenu();
                    break;

                case 4:
                    cancelOrderMenu();
                    break;

                case 5:
                    showOrdersMenu();
                    break;

                case 0:
                    System.out.println("Back");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }
    //add Menu
    private static void addMenuItem() throws DuplicateItemIdException {
        System.out.print("Nhap loai mon (1.Food 2.Drink 3.Dessert): ");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ma mon: ");
        String id = sc.nextLine();

        System.out.print("Nhap ten mon: ");
        String name = sc.nextLine();

        System.out.print("Nhap gia goc: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap ton kho: ");
        int stock = Integer.parseInt(sc.nextLine());

        MenuItem item;

        switch (type) {
            case 1:
                item = new Food(id, name, price, stock);
                break;
            case 2:
                System.out.print("Nhap size (S/M/L): ");
                Size size = Size.valueOf(sc.nextLine().toUpperCase());
                item = new Drink(id, name, price, stock, size);
                break;
            case 3:
                System.out.print("Co them topping khong (true/false): ");
                boolean topping = Boolean.parseBoolean(sc.nextLine());
                item = new Dessert(id, name, price, stock, topping);
                break;
            default:
                System.out.println("Loai mon khong hop le");
                return;
        }
        try {
            menuService.addItem(item);
            System.out.println("Them mon thanh cong");
        } catch (DuplicateItemIdException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
    // addOder
    public static void addItemToOrder() {

        try {

            System.out.print("Nhap Order ID : ");
            String orderId  = sc.nextLine();

            System.out.print("Nhap Item ID  : ");
            String itemId   = sc.nextLine();

            System.out.print("So luong      : ");
            int    quantity = sc.nextInt();
            sc.nextLine();

            if (quantity <= 0) {
                System.out.println("So luong phai lon hon 0!");
                return;
            }

            orderService.addItemToOrder(orderId, itemId, quantity);

        } catch (InvalidOrderIdException e) {
            System.out.println("Loi: " + e.getMessage());

        } catch (InsufficientStockException e) {
            System.out.println("Loi: " + e.getMessage());

        } finally {
            System.out.println("---------------------------");
        }
    }
    public static void searchItem() {

        System.out.println("\nSearch by:");
        System.out.println("1. Name");
        System.out.println("2. Price range");

        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {

            System.out.print("Enter name: ");
            String keyword = sc.nextLine();

            List<MenuItem> result = menuService.searchByName(keyword);

            if (result.isEmpty()) {
                System.out.println("No item found");
            } else {
                for (MenuItem item : result) {
                    System.out.println(item.getName() + " - " + item.getBasePrice());
                }
            }

        } else if (option == 2) {

            System.out.print("Min price: ");
            double min = sc.nextDouble();

            System.out.print("Max price: ");
            double max = sc.nextDouble();
            sc.nextLine();
            List<MenuItem> result = menuService.searchByPrice(min, max);

            if (result.isEmpty()) {
                System.out.println("No item found");
            } else {
                for (MenuItem item : result) {
                    System.out.println(item.getName() + " - " + item.getBasePrice());
                }
            }
        }
    }
    public static void editMenuItem() {

        System.out.print("Nhap ten mon can sua: ");
        String name = sc.nextLine();

        Optional<MenuItem> itemOpt = menuService.findByName(name);

        if(!itemOpt.isPresent()) {
            System.out.println("Khong tim thay mon!");
            return;
        }

        MenuItem item = itemOpt.get();

        System.out.print("Nhap ten moi: ");
        String newName = sc.nextLine();

        System.out.print("Nhap gia moi: ");
        double newPrice = Double.parseDouble(sc.nextLine());

        item.setName(newName);
        item.setBasePrice(newPrice);

        System.out.println("Cap nhat thanh cong!");
    }
    private static void deleteMenuItem() {

        System.out.print("Nhap ma mon can xoa: ");
        String id = sc.nextLine();

        try {
            menuService.deleteItem(id);
            System.out.println("Xoa mon thanh cong");
        } catch (ItemNotFoundException e) {
            System.out.println("Thong bao: " + e.getMessage());
        }
    }
    static void showOrdersMenu() {

        if (orderService.getOrders().isEmpty()) {
            System.out.println("Chua co don hang!");
            return;
        }

        orderService.getOrders()
                .forEach(System.out::println);
    }
    static void cancelOrderMenu() {

        try {

            System.out.print("Nhap Order ID: ");
            String orderId = sc.nextLine();

            orderService.cancelOrder(orderId);

            System.out.println("Don da bi huy!");

        } catch (InvalidOrderIdException e) {

            System.out.println(e.getMessage());
        }
    }
    static void payOrderMenu() {

        try {

            System.out.print("Nhap Order ID: ");
            String orderId = sc.nextLine();

            orderService.payOrder(orderId);

            System.out.println("Thanh toan thanh cong!");

        } catch (InvalidOrderIdException e) {

            System.out.println(e.getMessage());
        }
    }
}
