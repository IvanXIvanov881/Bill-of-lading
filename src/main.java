import billOfLading.FragileLoad;
import billOfLading.UnbreakableLoad;
import billOfLading.WayBill;
import core.Controller;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       Controller controller = new Controller();

        boolean exit = false;

        while (!exit) {

            System.out.println();
            System.out.println("Моля изберете една от следните опции:");
            System.out.println("1 - създаване на товарителница.");
            System.out.println("2 - преглед на товарителница.");
            System.out.println("3 - проследяване на товарителница.");
            System.out.println("4 - пренасочване на товарителница.");
            System.out.println("5 - Обща цена на всички товарителници.");
            System.out.println("6 - Брой създадени товарителници.");
            System.out.println("7 - изтриване на товарителница.");
            System.out.println("8 - изход.");
            System.out.println();

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Моля попълнете следните данни:");
                    System.out.println("1 за чуплив товар и 2 за нечуплив товар");
                    String fragileOrNot = scanner.nextLine();
                    System.out.println();
                    if (fragileOrNot.equals("1")){
                        System.out.println("Номер на товарителница, килограми, обем, изпратена от кой град, адресирана до кой град.");
                        System.out.println("(Пример: A5324h 12.5 20 Русе Варна)");
                        String[] input = scanner.nextLine().split("\\s+");
                        WayBill wayBill = new FragileLoad(input[0], Double.parseDouble(input[1]),Double.parseDouble(input[2]), input[3], input[4]);
                        controller.addWayBillToRepo(wayBill);
                    } else if (fragileOrNot.equals("2")){
                        System.out.println("Номер на товарителница, килограми, обем, изпратена от кой град, адресирана до кой град.");
                        System.out.println("(Пример: A5324h 12.5 20 Русе Варна)");
                        String[] input = scanner.nextLine().split("\\s+");
                        WayBill wayBill = new UnbreakableLoad(input[0], Double.parseDouble(input[1]),Double.parseDouble(input[2]), input[3], input[4]);
                        controller.addWayBillToRepo(wayBill);
                    } else {
                        System.out.println("Грешно въведен вид на товара.");
                    }
                    break;
                case "2":
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput2 = scanner.nextLine();
                    System.out.println(controller.getWayStatistic(numberInput2));
                    break;
                case "3":
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput3 = scanner.nextLine();
                    String currentLocation = controller.getWayBill(numberInput3).getSendFrom();
                    System.out.printf("Текущата локация на товарителница номер:%s е %s%n",numberInput3,currentLocation);
                    break;
                case "4":
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput4 = scanner.nextLine();
                    System.out.println("Пренасочване на товарителница към: ");
                    String newLocation = scanner.nextLine();
                    controller.getWayBill(numberInput4).setToLocation(newLocation);
                    System.out.printf("Вие успешно пренасочихте товарителница номер:%s към %s%n",numberInput4,newLocation);
                    break;
                case "5":
                    double totalPrice = controller.sumOfAll();
                    System.out.printf("Сума: %.2fлв.\n",totalPrice);
                    System.out.println();
                case "6":
                    int totalWayBills = controller.getStatistics();
                    System.out.printf("Брой създадени товарителници: %d.\n",totalWayBills);
                    System.out.println();
                case "7":
                    System.out.println("Моля въведете номер на товарителницата:");
                    String numberInput5 = scanner.nextLine();
                   boolean isDelete = controller.removeWayBillFromRepo(numberInput5);
                   if(isDelete){
                       System.out.printf("Вие успешно изтрихте товарителница номер: %s\n",numberInput5);
                   } else {
                        System.out.println("Итриването е неуспешно.");
                    }
                    break;
                case "8":
                    System.out.println("Изход.");
                    exit = true;
                    break;
                default:
                    System.out.println("Невалиден избор!");
                    System.out.println("________________");
                    break;
            }
        }
    }
}
