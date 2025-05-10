package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Item> items;
    private int capacity;
    private int currentSize;
    private User owner;

    // Getters and Setters
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    // Add an item to the inventory
    public void addItem(String item, int count) {
        Item target = null;
        for (Item i : items) {
            if (i.getName().equals(item)) {
                target = i;
                break;
            }
        }
        if (target == null) {
            Item newItem = new Item();
            newItem.setName(item);
            newItem.setQuantity(count);
            items.add(newItem);
        } else {
            target.setQuantity(target.getQuantity() + count);
        }
    }

    // Remove an item from the inventory
    public void removeItem(String item, int count) {
        for (Item i : items) {
            if (i.getName().equals(item)) {
                if (i.getQuantity() > count) {
                    i.setQuantity(i.getQuantity() - count);
                } else if (i.getQuantity() == count) {
                    items.remove(i);
                }
                break;
            }
        }
    }

    // Check if the inventory has a specific item with the required quantity
    public boolean hasItem(String item, int count) {
        for (Item i : items) {
            if (i.getName().equals(item) && i.getQuantity() >= count) {
                return true;
            }
        }
        return false;
    }

    // Get the count of a specific item
    public int getItemCount(String itemName) {
        for (Item i : items) {
            if (i.getName().equals(itemName)) {
                return i.getQuantity();
            }
        }
        return 0; // Item not found
    }

    // Get all items as a map (item name -> quantity)
    public Map<String, Integer> getAllItems() {
        Map<String, Integer> itemMap = new HashMap<>();
        for (Item i : items) {
            itemMap.put(i.getName(), i.getQuantity());
        }
        return itemMap;
    }

    public int sellItem(String itemName, int quantity) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                if (item.getQuantity() >= quantity) {
                    item.setQuantity(item.getQuantity() - quantity);
                    return quantity * item.getSellPrice(); // بازگشت مقدار پول حاصل از فروش
                } else {
                    System.out.println("Not enough items to sell.");
                    return 0; // فروش ناموفق
                }
            }
        }
        System.out.println("Item not found in inventory.");
        return 0; // آیتم پیدا نشد
    }
}