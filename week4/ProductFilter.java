import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

enum Category {
    MOBILE, LAPTOP, TV, REFRIGERATOR;
}

class Product {
    private String id;
    private String name;
    private boolean warranty;
    private Category category;

    public Product(String id, String name, boolean warranty, Category category) {
        this.id = id;
        this.name = name;
        this.warranty = warranty;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean hasWarranty() {
        return warranty;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

public class ProductFilter {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("P1", "Mobile1", true, Category.MOBILE),
                new Product("P2", "Mobile2", false, Category.MOBILE),
                new Product("P3", "Laptop1", true, Category.LAPTOP),
                new Product("P4", "Laptop2", false, Category.LAPTOP),
                new Product("P5", "TV1", true, Category.TV),
                new Product("P6", "TV2", false, Category.TV),
                new Product("P7", "Refrigerator1", true, Category.REFRIGERATOR),
                new Product("P8", "Refrigerator2", false, Category.REFRIGERATOR)
        ));

        // Example usage
        List<List<Product>> filteredProducts = filterProductsByCategory(products, Category.MOBILE);
        printProducts(filteredProducts);
    }

    public static List<List<Product>> filterProductsByCategory(List<Product> products, Category category) {
        Predicate<Product> categoryPredicate = product -> product.getCategory() == category;

        List<Product> withWarranty = new ArrayList<>();
        List<Product> withoutWarranty = new ArrayList<>();

        for (Product product : products) {
            if (categoryPredicate.test(product)) {
                if (product.hasWarranty()) {
                    withWarranty.add(product);
                } else {
                    withoutWarranty.add(product);
                }
            }
        }

        return Arrays.asList(withWarranty, withoutWarranty);
    }

    public static void printProducts(List<List<Product>> products) {
        System.out.println("Products with warranty:");
        products.get(0).forEach(product -> System.out.println(product.getId() + " - " + product.getName()));

        System.out.println("Products without warranty:");
        products.get(1).forEach(product -> System.out.println(product.getId() + " - " + product.getName()));
    }
}
