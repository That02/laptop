import java.util.*;

class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}

class Store {
    private Set<Laptop> laptops = new HashSet<>();

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops(Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean matchesFilters = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key.equals("RAM")) {
                    if (laptop.getRam() < (int)value) {
                        matchesFilters = false;
                        break;
                    }
                } else if (key.equals("Storage")) {
                    if (laptop.getStorage() < (int)value) {
                        matchesFilters = false;
                        break;
                    }
                } else if (key.equals("OS")) {
                    if (!laptop.getOs().equals(value)) {
                        matchesFilters = false;
                        break;
                    }
                } else if (key.equals("Color")) {
                    if (!laptop.getColor().equals(value)) {
                        matchesFilters = false;
                        break;
                    }
                }
            }
            if (matchesFilters) {
                System.out.println("Brand: " + laptop.getBrand() + ", RAM: " + laptop.getRam() +
                        ", Storage: " + laptop.getStorage() + ", OS: " + laptop.getOs() +
                        ", Color: " + laptop.getColor());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Brand1", 8, 512, "Windows", "Black");
        Laptop laptop2 = new Laptop("Brand2", 16, 1024, "MacOS", "Silver");
        Laptop laptop3 = new Laptop("Brand3", 4, 256, "Linux", "Black");

        Store store = new Store();
        store.addLaptop(laptop1);
        store.addLaptop(laptop2);
        store.addLaptop(laptop3);

        Map<String, Object> filters = new HashMap<>();
        filters.put("RAM", 8);
        filters.put("OS", "Windows");

        System.out.println("Filtered Laptops:");
        store.filterLaptops(filters);
    }
}