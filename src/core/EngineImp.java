package core;
import billOfLading.FragileLoad;
import billOfLading.UnbreakableLoad;
import billOfLading.WayBill;
import java.util.Scanner;

public class EngineImp implements Engine {

    private ControllerImp controllerImp;
    private Scanner scanner;

    public EngineImp() {
        this.controllerImp = new ControllerImp();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        boolean exit = false;

        while (!exit) {

            String choice = getString(scanner);

            switch (choice) {

                case "1" -> {
                    System.out.println("Изберете: 1 за чуплив товар");
                    System.out.println("Изберете: 2 за нечуплив товар");
                    System.out.println("__________________________________________");
                    String fragileOrNot = scanner.nextLine();
                    if (fragileOrNot.equals("1")) {
                        System.out.println("Номер на товарителница, килограми, обем, изпратена от кой град, адресирана до кой град.");
                        System.out.println("(Пример: A1234h 12.5 20 Русе Варна)");
                        System.out.println("__________________________________________");
                        String[] input = scanner.nextLine().split("\\s+");
                        if (input.length == 5) {
                            String firstNum = input[1];
                            String secondNum = input[2];
                            if (isDouble(firstNum) && isDouble(secondNum)) {
                                WayBill wayBill = new FragileLoad(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]), input[3], input[4]);
                                controllerImp.addWayBillToRepo(wayBill);
                                System.out.printf("Вие успешно въведохте товарителница N:%s!%n", input[0]);
                                System.out.println("__________________________________________");
                            } else {
                                System.out.println("Моля въведете на 2-ра и 3-та секция число!");
                                System.out.println("__________________________________________");
                            }
                        } else {
                            System.out.println("Грешно въведени данни! Моля опитайте отново.");
                            System.out.println("__________________________________________");
                        }
                    } else if (fragileOrNot.equals("2")) {
                        System.out.println("Номер на товарителница, килограми, обем, изпратена от кой град, адресирана до кой град.");
                        System.out.println("(Пример: A5324h 12.5 20 Русе Варна)");
                        String[] input = scanner.nextLine().split("\\s+");
                        if (input.length == 5) {
                            String firstNum1 = input[1];
                            String secondNum1 = input[2];
                            if (isDouble(firstNum1) && isDouble(secondNum1)) {
                                WayBill wayBill = new UnbreakableLoad(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]), input[3], input[4]);
                                controllerImp.addWayBillToRepo(wayBill);
                                System.out.printf("Вие успешно въведохте товарителница N:%s!%n", input[0]);
                                System.out.println("__________________________________________");
                            } else {
                                System.out.println("Моля въведете на 2-ра и 3-та секция число!");
                                System.out.println("__________________________________________");
                            }
                        } else {
                            System.out.println("Грешно въведени данни! Моля опитайте отново.");
                            System.out.println("__________________________________________");
                        }
                    } else {
                        System.out.println("Грешно въведен избор! Моля опитайте отново.");
                        System.out.println("__________________________________________");
                    }
                }
                case "2" -> {
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput2 = scanner.nextLine();
                    System.out.println(controllerImp.getWayStatistic(numberInput2));
                }

                case "3" -> {
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput3 = scanner.nextLine();
                    String currentLocation = controllerImp.getWayBill(numberInput3).getSendFrom();
                    System.out.printf("Текущата локация на товарителница номер:%s е %s%n", numberInput3, currentLocation);
                    System.out.println("__________________________________________");
                }

                case "4" -> {
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput4 = scanner.nextLine();
                    System.out.println("Пренасочване на товарителница към: ");
                    String newLocation = scanner.nextLine();
                    controllerImp.getWayBill(numberInput4).setToLocation(newLocation);
                    System.out.printf("Вие успешно пренасочихте товарителница номер:%s към %s%n", numberInput4, newLocation);
                    System.out.println("__________________________________________");
                }

                case "5" -> {
                    double totalPrice = controllerImp.sumOfAll();
                    System.out.printf("Сума: %.2fлв.\n", totalPrice);
                    System.out.println("__________________________________________");
                }

                case "6" -> {
                    int totalWayBills = controllerImp.getStatistics();
                    System.out.printf("Брой създадени товарителници: %d.\n", totalWayBills);
                    System.out.println("__________________________________________");
                }

                case "7" -> {
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput5 = scanner.nextLine();
                    boolean isDelete = controllerImp.removeWayBillFromRepo(numberInput5);
                    if (isDelete) {
                        System.out.printf("Вие успешно изтрихте товарителница номер: %s\n", numberInput5);
                        System.out.println("__________________________________________");
                    } else {
                        System.out.println("Итриването е неуспешно.");
                        System.out.println("__________________________________________");
                    }
                }

                case "8" -> {
                    System.out.println("Изход.");
                    System.out.println("__________________________________________");
                    exit = true;
                }

                default -> {
                    System.out.println("Невалиден избор!");
                    System.out.println("________________");
                }
            }
        }
    }

    private static boolean isDouble(String numberToCheck) {
        try {
            Double.parseDouble(numberToCheck);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String getString(Scanner scanner) {
        String sb = "Моля изберете една от следните опции:" + System.lineSeparator() +
                "1 - Създаване на товарителница." + System.lineSeparator() +
                "2 - Преглед на товарителница." + System.lineSeparator() +
                "3 - Проследяване на товарителница." + System.lineSeparator() +
                "4 - Пренасочване на товарителница." + System.lineSeparator() +
                "5 - Обща цена на всички товарителници." + System.lineSeparator() +
                "6 - Брой създадени товарителници." + System.lineSeparator() +
                "7 - Изтриване на товарителница." + System.lineSeparator() +
                "8 - Изход." + System.lineSeparator() +
                "__________________________________________" + System.lineSeparator();
        System.out.print(sb);
        return scanner.nextLine();
    }

}
