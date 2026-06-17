package console;

import actions.init.EntityConfig;
import world.Simulation;

import java.util.Scanner;

public class SimulationMenu {
    private static final String START = "s";
    private static final String EXIT = "e";
    private static final String CONTINUE = "Enter";
    private static final String RESET = "\u001B[0m";
    private static final String ITALIC = "\u001B[3m";
    private static final String PURPLE = "\u001B[35m";

    public static void printWelcomeMessage() {
        System.out.println("🌊️🌊🌊🌊🌊🌊🌊🌊🌊🌊\uD83C\uDFC4🌊🌊");
        System.out.print("🌊");
        System.out.print(PURPLE + ITALIC + " WELCOME TO SIMULATION! " + RESET);
        System.out.println("🌊");
        System.out.printf("🌊\uD83E\uDEB8🌊🌊🌊🌊🌊🌊🌊🌊🌊️🌊🌊%n%n");
    }

    public static void printRules() {
        System.out.printf("\uD83D\uDC21 Для запуска симуляции введите '%s'%n", START);
        System.out.printf("\uD83D\uDC21 Чтобы остановить или продолжить симуляцию нажмите клавишу %s%n", CONTINUE);
        System.out.printf("\uD83D\uDC21 Чтобы выйти из симуляции поставьте ее на паузу и введите '%s'%n%n", EXIT);
    }

    public static void printWorldConfig(EntityConfig entityConfig) {
        System.out.print("Информация о мире.");
        System.out.printf(" Акулы - %d.", entityConfig.predatorCount());
        System.out.printf(" Серферы - %d.", entityConfig.preyCount());
        System.out.printf(" Кораллы - %d.", entityConfig.coralCount());
        System.out.printf(" Острова - %d.", entityConfig.islandCount());
        System.out.printf(" Волны - %d.%n%n", entityConfig.waveCount());
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

    public static void printWarning() {
        System.out.printf("Такой команды нет! Для паузы нажмите - %s. Для выхода введите - '%s'%n", CONTINUE, EXIT);
    }
}
