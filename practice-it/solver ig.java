import java.awt.datatransfer.Clipboard;
import java.util.*;
import java.awt.*;
class Main {
    public static Scanner sc = new Scanner(System.in);
    private static boolean cont = true;
    Toolkit toolkit=Toolkit.getDefaultToolkit();
    Clipboard clipboard=toolkit.getSystemClipboard();

    public static void main(String[] args){
        while(cont){
            System.out.println();
            System.out.print("Enter input value: ");
            int input = sc.nextInt();
            int input2 = sc.nextInt();
            System.out.println(mystery4(input, input2));
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

    //BJP5 Self-Check 12.13: mystery4

    public static int mystery4(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return mystery4(x - y, y);
        }
    }


}