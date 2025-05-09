package models;

import java.util.HashMap;

public class Item {
    private int id;
    private String name;
    private String type;
    private int basePrice;
    private int quantity;
    private HashMap<String, Object> properties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getPrice() {
        return basePrice * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    // متد use() برای استفاده از آیتم‌ها با توجه به نوع آیتم عملیات مرتبط را اجرا می‌کند.
    public void use() {
        switch (name.toLowerCase()) {
            case "cherry bomb":
                System.out.println("Cherry Bomb activated! Small radius objects destroyed.");
                break;

            case "bomb":
                System.out.println("Bomb activated! Medium radius objects destroyed.");
                break;

            case "mega bomb":
                System.out.println("Mega Bomb activated! Large radius objects destroyed.");
                break;

            case "sprinkler":
                System.out.println("Sprinkler activated! Watered 4 tiles.");
                break;

            case "quality sprinkler":
                System.out.println("Quality Sprinkler activated! Watered 8 tiles.");
                break;

            case "iridium sprinkler":
                System.out.println("Iridium Sprinkler activated! Watered 24 tiles.");
                break;

            case "charcoal kiln":
                System.out.println("Charcoal Kiln activated! Wood converted to coal.");
                break;

            case "furnace":
                System.out.println("Furnace activated! Ores converted to bars.");
                break;

            case "scarecrow":
                System.out.println("Scarecrow placed! Crows are kept away.");
                break;

            case "deluxe scarecrow":
                System.out.println("Deluxe Scarecrow placed! Crows are kept away within 12 tiles.");
                break;

            case "bee house":
                System.out.println("Bee House activated! Honey produced.");
                break;

            case "cheese press":
                System.out.println("Cheese Press activated! Milk converted to cheese.");
                break;

            case "keg":
                System.out.println("Keg activated! Fruits and vegetables turned into beverages.");
                break;

            case "loom":
                System.out.println("Loom activated! Wool turned into cloth.");
                break;

            case "mayonnaise machine":
                System.out.println("Mayonnaise Machine activated! Eggs turned into mayonnaise.");
                break;

            case "oil maker":
                System.out.println("Oil Maker activated! Truffles turned into oil.");
                break;

            case "preserves jar":
                System.out.println("Preserves Jar activated! Vegetables turned into pickles and jam.");
                break;

            case "dehydrator":
                System.out.println("Dehydrator activated! Fruits dried.");
                break;

            case "grass starter":
                System.out.println("Grass Starter used! Grass planted.");
                break;

            case "fish smoker":
                System.out.println("Fish Smoker activated! Fish smoked.");
                break;

            case "mystic tree seed":
                System.out.println("Mystic Tree Seed planted! Mystic tree growing.");
                break;

            default:
                System.out.println("No use defined for: " + name);
        }
    }
}
