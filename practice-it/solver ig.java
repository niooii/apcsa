import java.util.*;
class Main {
    public static Scanner sc = new Scanner(System.in);
    private static boolean cont = true;

    public static void main(String[] args){
        while(cont){
            System.out.println();
            System.out.print("Enter input value: ");
            int input = sc.nextInt();
            mystery3(input);
            System.out.println();
            System.out.println("continue? (y)");
            if(sc.next().toLowerCase().charAt(0) != 'y') System.exit(0);
        }
    }

    //BJP5 Self-Check 12.5: mystery3

    public static void mystery3(int n) {
        if (n <= 0) {
            System.out.print("*");
        } else if (n % 2 == 0) {
            System.out.print("(");
            mystery3(n - 1);
            System.out.print(")");
        } else {
            System.out.print("[");
            mystery3(n - 1);
            System.out.print("]");
        }
    }


}