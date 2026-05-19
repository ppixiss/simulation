package ui;

import actions.init.EntityConfig;

import java.util.Scanner;

public class SimulationMenu {
    private static final String START = "s";
    private static final String EXIT = "e";
    private static final String CONTINUE = "Enter";
    private static final String RESET = "\u001B[0m";
    private static final String ITALIC = "\u001B[3m";
    private static final String PURPLE = "\u001B[35m";

    private static final Scanner scanner = new Scanner(System.in);

    public static void printWelcomeMessage() {
        System.out.println("🌊️🌊🌊🌊🌊🌊🌊🌊🌊🌊\uD83C\uDFC4🌊🌊");
        System.out.print("🌊");
        System.out.print(PURPLE + ITALIC + " WELCOME TO SIMULATION! " + RESET);
        System.out.println("🌊");
        System.out.println("🌊\uD83E\uDEB8🌊🌊🌊🌊🌊🌊🌊🌊🌊️🌊🌊");
        System.out.println();
    }

    public static void printRules() {
        System.out.printf("\uD83D\uDC21 Для запуска симуляции введите '%s'%n", START);
        System.out.printf("\uD83D\uDC21 Чтобы остановить или продолжить симуляцию нажмите клавишу %s%n", CONTINUE);
        System.out.printf("\uD83D\uDC21 Чтобы выйти из симуляции поставьте ее на паузу и введите '%s'%n", EXIT);
        System.out.println();
    }

    public static void printWorldConfig(EntityConfig entityConfig) {
        //todo: отформатировать
        System.out.print("Информация о мире.");
        System.out.print(" Акулы - " + entityConfig.predatorCount() + ". ");
        System.out.print(" Серферы - " + entityConfig.preyCount() + ". ");
        System.out.print(" Кораллы - " + entityConfig.coralCount() + ". ");
        System.out.print(" Острова - " + entityConfig.islandCount() + ". ");
        System.out.println(" Волны - " + entityConfig.waveCount() + ". ");
        System.out.println();
    }

    public static boolean shouldStartSimulation(Scanner scanner) {
        while (true) {
            String validationStart = scanner.nextLine();

            switch (validationStart.toLowerCase()) {
                case START:
                    return true;
                case EXIT:
                    return false;
                default:
                    System.out.printf("Ошибка! Введите '%s' или '%s'%n", START, EXIT);
            }
        }
    }
}

