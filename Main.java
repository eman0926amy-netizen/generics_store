import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayInfo() {
        System.out.println(name + " | Price: " + price
                + " LYD | Quantity: " + quantity);
    }
}


class Customer {
    private String name;
    private String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}


class Order {
    private Customer customer;
    private Product product;
    private int quantity;

    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }

    public void printInvoice() {
        System.out.println("\n—— CUSTOMER INVOICE ——");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Product: " + product.getName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + calculateTotal() + " LYD");
        System.out.println("-—————————");
    }
}


class Store<T extends Product> {

    private String storeName;
    private List<T> products;

    public Store(String storeName) {
        this.storeName = storeName;
        products = new ArrayList<>();
    }

    public void addProduct(T product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("\nInventory of " + storeName);

        for (T product : products) {
            product.displayInfo();
        }
    }

   
    public void addFinancialValues(
            List<? super Number> report,
            Number... values) {

        for (Number value : values) {
            report.add(value);
        }
    }
}


public class Main {

    public static void main(String[] args) {

        
        Store<Product> store = new Store<>("Fashion Store");

  
        Product shirt = new Product("T-Shirt", 45.0, 20);
        Product jeans = new Product("Jeans", 90.0, 10);

      
        store.addProduct(shirt);
        store.addProduct(jeans);

       
        store.displayProducts();

        
        Customer customer = new Customer(
                "Sara", "0912345678");

        
        Order order = new Order(customer, shirt, 2);

        
        order.printInvoice();

        
        List<Object> financialReport = new ArrayList<>();

        store.addFinancialValues(
                financialReport,
                order.calculateTotal(),
                10,
                5.5
        );

        System.out.println("\nFinancial Report: "
                + financialReport);
    }
}
