package view;

import controller.GreenhouseController;

import java.util.Scanner;

public class GreenhouseView {
    private final Scanner scanner;
    private final GreenhouseController greenhouseController;

    public GreenhouseView(Scanner scanner, GreenhouseController greenhouseController) {
        this.scanner = scanner;
        this.greenhouseController = greenhouseController;
    }

    public void display() {
        System.out.println("=== Greenhouse System ===");
//        System.out.println("Available commands:");
//        System.out.println("- build <money>: Build the greenhouse.");
//        System.out.println("- plant <crop>: Plant a crop in the greenhouse.");
//        System.out.println("- water <amount> <weather>: Water the crops (specify weather).");
//        System.out.println("- harvest: Harvest all crops.");
//        System.out.println("- status: Get the greenhouse status.");
//        System.out.println("- exit: Exit the greenhouse system.");

        while (true) {
            //System.out.print("> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            switch (parts[0]) {
                case "build":
                    if (parts.length < 2) {
                        System.out.println("Usage: build <money>");
                        break;
                    }
                    int money = Integer.parseInt(parts[1]);
                    System.out.println(greenhouseController.buildGreenhouse(money));
                    break;
                case "plant":
                    if (parts.length < 2) {
                        System.out.println("Usage: plant <crop>");
                        break;
                    }
                    String crop = parts[1];
                    System.out.println(greenhouseController.plantCrop(crop));
                    break;
                case "water":
                    if (parts.length < 3) {
                        System.out.println("Usage: water <amount> <weather>");
                        break;
                    }
                    int water = Integer.parseInt(parts[1]);
                    String weather = parts[2];
                    System.out.println(greenhouseController.waterCrops(water, weather));
                    break;
                case "harvest":
                    System.out.println(greenhouseController.harvestCrops());
                    break;
                case "status":
                    System.out.println(greenhouseController.getGreenhouseStatus());
                    break;
                case "exit":
                    System.out.println("Exiting Greenhouse System...");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}