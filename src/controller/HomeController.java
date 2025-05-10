package controller;

import models.ProcessingMachine;
import models.Recipe;
import models.Result;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeController {
    private List<ProcessingMachine> processingMachineList = new ArrayList<>();
        private final User user;
        private final Scanner scanner;

        private final List<Recipe> recipes;

        public HomeController(User user, Scanner scanner) {
            this.user = user;
            this.scanner = scanner;
            this.recipes = user.getRecipes(); // دستورهای یادگرفته‌شده‌ی بازیکن

        }

    public Result crafting () {
            Result result = new Result();

            if (!user.isAtHome()) {
                result.setSuccess(false);
                result.setMessage("You must be at home to access crafting.");
                return result;
            }

            while (true) {
                System.out.println("\n=== Crafting Menu ===");
                System.out.println("Available commands:");
                System.out.println("- show recipes");
                System.out.println("- craft <item_name>");
                System.out.println("- exit");
                System.out.print("Enter command: ");

                String command = scanner.nextLine().trim();

                if (command.equalsIgnoreCase("exit")) {
                    result.setSuccess(true);
                    result.setMessage("Exited crafting menu.");
                    return result;
                }

                if (command.equalsIgnoreCase("show recipes")) {
                    showRecipes();
                } else if (command.startsWith("craft ")) {
                    String itemName = command.substring("craft ".length()).trim();
                    craftItem(itemName);
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
            }
        }

        private void showRecipes() {
            List<Recipe> recipes = user.getRecipes();
            System.out.println("\n=== Learned Recipes ===");
            for (Recipe recipe : recipes) {
                boolean canCraft = canCraft(recipe);
                System.out.printf("- %s (Can Craft: %s)\n", recipe.getName(), canCraft ? "Yes" : "No");
            }
        }

        private boolean canCraft(Recipe recipe) {
            if (!user.hasRequiredSkill(recipe.getRequiredSkillLevel())) {
                return false;
            }
            for (Map.Entry<String, Integer> ingredient : recipe.getIngredients().entrySet()) {
                if (!user.getInventory().hasItem(ingredient.getKey(), ingredient.getValue())) {
                    return false;
                }
            }
            return user.getEnergy().getCurrentEnergy() >= recipe.getEnergyCost();
        }

    private void craftItem(String itemName) {
        Recipe recipe = recipes.stream()
                .filter(r -> r.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

        if (recipe == null) {
            System.out.println("You don't know this recipe.");
            return;
        }

        if (!canCraft(recipe)) {
            System.out.println("You don't have enough resources or energy to craft this item.");
            return;
        }

        // مصرف مواد اولیه
        for (Map.Entry<String, Integer> ingredient : recipe.getIngredients().entrySet()) {
            user.getInventory().removeItem(ingredient.getKey(), ingredient.getValue());
        }

        // مصرف انرژی
        user.getEnergy().decreaseEnergy(recipe.getEnergyCost());

        // اضافه کردن آیتم ساخته‌شده
        user.getInventory().addItem(recipe.getName(), 1);
        System.out.println(itemName + " crafted successfully!");
    }

    private void sellItem(String itemName, int quantity) {
        // پیدا کردن دستورالعمل مربوطه
        Recipe recipe = recipes.stream()
                .filter(r -> r.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

        if (recipe == null) {
            System.out.println("You don't know this item.");
            return;
        }

        // فروش آیتم
        int earnedMoney = user.getInventory().sellItem(itemName, quantity);
        if (earnedMoney > 0) {
            user.addMoney(earnedMoney); // اضافه کردن پول به کاربر
            System.out.printf("Sold %d %s for %d gold.\n", quantity, itemName, earnedMoney);
        }
    }

    public Result cooking () {
        return null;
    }
    }
