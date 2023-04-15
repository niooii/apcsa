package Rectangle;

public class Rectangle {
    private int myWidth, myHeight;
    private char myFillStyle;
    public Rectangle(int w, int h, char fs){
        this.myWidth = w;
        this.myHeight = h;
        this.myFillStyle = fs;
    }

    public int calcArea(){
        return this.myWidth * this.myHeight;
    }

    public int calcPerimeter(){
        return this.myWidth * 2 + this.myHeight * 2;
    }

    public void drawRectangle(boolean outlineOnly){
        for(int i = 0; i < myHeight; i++){
            for(int j = 0; j < myWidth; j++){
                if((outlineOnly && j != 0 && j != myWidth - 1) && (!(i == 0) && !(i == myHeight - 1)))
                    System.out.print(' ');
                else if(!outlineOnly){
                    System.out.print(myFillStyle);
                } else if((i == 0 || i == myHeight - 1) || (j == 0 || j == myWidth - 1))
                    System.out.print(myFillStyle);
            }
            System.out.println();
        }
    }



    //getters
    public int getWidth(){
        return myWidth;
    }
    public int getHeight(){
        return myHeight;
    }
    public char getFillStyle(){
        return myFillStyle;
    }

    //setters
    public void setWidth(int width) { myWidth = width;}
    public void setHeight(int height) { myHeight = height;}
    public void setFillStyle(char myFillStyle) {
        this.myFillStyle = myFillStyle;
    }

    public String toString(){
        return "height: " + myHeight + "\nwidth: " + myWidth;
    }
}