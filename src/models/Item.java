package models;

import java.util.HashMap;

public class Item {
    private int id;
    private String name;
    private String type;
    private int basePrice;
    private int quantity;
    private HashMap<String, Object> properties;
    private int sellPrice;

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

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
            // Cherry Bomb: نابود کردن هرچیز در شعاع کوچک
            case "cherry bomb":
                System.out.println("Cherry Bomb activated! Small radius objects destroyed.");
                break;

            // Bomb: نابود کردن هرچیز در شعاع متوسط
            case "bomb":
                System.out.println("Bomb activated! Medium radius objects destroyed.");
                break;

            // Mega Bomb: نابود کردن هرچیز در شعاع بزرگ
            case "mega bomb":
                System.out.println("Mega Bomb activated! Large radius objects destroyed.");
                break;

            // Sprinkler: آبیاری ۴ کا‌ل‌م
            case "sprinkler":
                System.out.println("Sprinkler activated! Watering 4 adjacent tiles.");
                break;

            // Quality Sprinkler: آبیاری ۸ کا‌ل‌م
            case "quality sprinkler":
                System.out.println("Quality Sprinkler activated! Watering 8 adjacent tiles.");
                break;

            // Iridium Sprinkler: آبیاری ۲۴ کا‌ل‌م
            case "iridium sprinkler":
                System.out.println("Iridium Sprinkler activated! Watering 24 adjacent tiles.");
                break;

            // Charcoal Kiln: تبدیل چوب به زغال
            case "charcoal kiln":
                System.out.println("Charcoal Kiln activated! Wood converted into coal.");
                break;

            // Furnace: تبدیل کانی‌ها به شمش
            case "furnace":
                System.out.println("Furnace activated! Ores smelted into bars.");
                break;

            // Scarecrow: جلوگیری از حمله کلاغ‌ها
            case "scarecrow":
                System.out.println("Scarecrow placed! Crows are kept away from crops.");
                break;

            // Deluxe Scarecrow: جلوگیری از حمله کلاغ‌ها تا شعاع ۱۲
            case "deluxe scarecrow":
                System.out.println("Deluxe Scarecrow placed! Crows are kept away within 12 tiles radius.");
                break;

            // Bee House: تولید عسل
            case "bee house":
                System.out.println("Bee House activated! Producing honey.");
                break;

            // Cheese Press: تبدیل شیر به پنیر
            case "cheese press":
                System.out.println("Cheese Press activated! Turning milk into cheese.");
                break;

            // Keg: تبدیل میوه و سبزیجات به نوشیدنی
            case "keg":
                System.out.println("Keg activated! Turning fruits and vegetables into beverages.");
                break;

            // Loom: تبدیل پشم به پارچه
            case "loom":
                System.out.println("Loom activated! Turning wool into cloth.");
                break;

            // Mayonnaise Machine: تبدیل تخم مرغ به سس مایونز
            case "mayonnaise machine":
                System.out.println("Mayonnaise Machine activated! Turning eggs into mayonnaise.");
                break;

            // Oil Maker: تبدیل truffle به روغن
            case "oil maker":
                System.out.println("Oil Maker activated! Turning truffle into oil.");
                break;

            // Preserves Jar: تبدیل سبزیجات به ترشی و مربا
            case "preserves jar":
                System.out.println("Preserves Jar activated! Turning vegetables into pickles and jam.");
                break;

            // Dehydrator: خشک کردن میوه‌ها
            case "dehydrator":
                System.out.println("Dehydrator activated! Drying fruits.");
                break;

            // Grass Starter: کاشت اولیه‌ی علف
            case "grass starter":
                System.out.println("Grass Starter used! Planting initial grass.");
                break;

            // Fish Smoker: دودی کردن ماهی
            case "fish smoker":
                System.out.println("Fish Smoker activated! Smoking fish with coal.");
                break;

            // Mystic Tree Seed: ساخت درخت mystic
            case "mystic tree seed":
                System.out.println("Mystic Tree Seed planted! Growing a mystic tree.");
                break;

            default:
                System.out.println("No action defined for: " + name);
        }
    }
}