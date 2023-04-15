package Rectangle;

import java.util.Scanner;

public class RectangleTest {
    Scanner sc = new Scanner(System.in);
    Rectangle rectangle = new Rectangle(0, 0, ' ');
    public RectangleTest(){
        System.out.println("MAIN_MENU:\n" +
                "W: Assign the Width\n" +
                "H: Assign the Height\n" +
                "F: Assign the Fill Style\n" +
                "A: Calculate the Area\n" +
                "P: Calculate the Perimeter\n" +
                "T: Text Description of the Rectangle (Hint: toString())\n" +
                "D: Draw the Rectangle\n" +
                "O: Draw the Outline of the Rectangle\n" +
                "Q: Quit");
        while(true){
            parseArgs(sc.next().charAt(0));
        }
    }

    public static void main(String[] args){
        new RectangleTest();
    }

    public void parseArgs(char c){
        switch(c){
            case 'w':
                rectangle.setWidth(sc.nextInt());
                System.out.println("width assigned to: " + rectangle.getWidth());
                break;
            case 'h':
                rectangle.setHeight(sc.nextInt());
                System.out.println("height assigned to: " + rectangle.getHeight());
                break;
            case 'f':
                rectangle.setFillStyle(sc.next().charAt(0));
                System.out.println("set fill style to character '" + rectangle.getFillStyle() + "'");
                break;
            case 'a':
                System.out.println("AREA OF RECTANGLE: " + rectangle.calcArea());
                break;
            case 'p':
                System.out.println("PERIMETER OF RECTANGLE: " + rectangle.calcPerimeter());
                break;
            case 't':
                System.out.println(rectangle.toString());
                break;
            case 'd':
                rectangle.drawRectangle(false);
                break;
            case 'o':
                rectangle.drawRectangle(true);
                break;
            case 'q':
                System.exit(0);

        }
    }
}
