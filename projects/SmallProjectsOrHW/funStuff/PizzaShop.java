package SmallProjectsOrHW.funStuff;
import java.util.*;
import java.util.Scanner;

class Pizza {

    private String[] toppings;
    private double cost = 13;
    public Pizza(String... toppings){
        this.toppings = toppings;
        for(String str : toppings){
            String paramStr = str.replaceAll(" ", "");
            switch(paramStr){
                case "pepperoni":
                    cost += 1;
                    break;
                case "mushroom":
                    cost += 0.5;
                    break;
                case "olive":
                    cost += 0.5;
                    break;
                case "anchovy":
                    cost += 2;
                    break;
                case "ham":
                    cost += 1.5;
                    break;
                default:
                    System.out.println(paramStr + " topping ommited: invalid topping");
            }
        }
    }

    public double getCost() {
        return cost;
    }
}

public class PizzaShop {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pizza> Pizzas = new ArrayList<>();

    public static void main(String[] args){
        boolean cont = true;
        boolean acceptingCoupon = true;
        double multiplier = 1;
        double totalCost = 0;
        while(cont){
            System.out.println("Select input type: pizza/drink/wings/coupon");
            if(sc.next().equalsIgnoreCase("pizza")){
                System.out.print("enter desired toppings separated with a comma: ");
                String[] toppings = sc.next().split(",");
                Pizzas.add(new Pizza(toppings));
            } else if(sc.next().equalsIgnoreCase("drink")){ // giving up on making objects im too tired for this shit
                System.out.print("enter size (small/med/large/tub): ");
                String selection = sc.next();
                if(selection.equalsIgnoreCase("small")) totalCost += 2;
                else if(selection.equalsIgnoreCase("med")) totalCost += 3;
                else if(selection.equalsIgnoreCase("large")) totalCost += 3.5;
                else if(selection.equalsIgnoreCase("tub")) totalCost += 3.75;
                else System.out.println("invalid selection");
            } else if(sc.next().equalsIgnoreCase("wings")){
                System.out.print("enter amount (10/20/40/100): ");
                int selection = sc.nextInt();
                if(selection == 10) totalCost += 5;
                else if(selection == 20) totalCost += 9;
                else if(selection == 40) totalCost += 17.5;
                else if(selection == 100) totalCost += 48;
                else System.out.println("invalid selection");
            } else if (sc.next().equalsIgnoreCase("coupon") && acceptingCoupon) {
                System.out.print("enter a number from 0-1 as your discount percentage: ");
                double temp = sc.nextDouble();
                if(temp < 0 || temp > 1){
                    System.out.println("invalid input");
                } else{
                    multiplier -= sc.nextDouble();
                    acceptingCoupon = false;
                }
            } else {
                System.out.println("invalid input");
            }
            System.out.print("continue order? (y)");
            if(sc.next().toLowerCase().charAt(0) != 'y'){
                cont = false;
            }
        }
        for(Pizza pizza : Pizzas){
            totalCost += pizza.getCost();
        }
        totalCost *= multiplier;
        totalCost *= 1.0625;
        System.out.println("your total cost: " + totalCost);
    }
}
