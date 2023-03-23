package SmallProjectsOrHW.testdir;

class Main {

    public static boolean isEquivelant(int string2, int string1){
        boolean False = false;
        if(string1 == string2){
            False = true;
        }
        if(False) {
            return !(string1 == string2);
        }
        return "false";
    }

    public static void main(String[] args){
        String int1 = "3";
        String int2 = "4";
        if(!(int1.equals(int2))){
            if(isEquivelant(Integer.parseInt(int1), Integer.parseInt(int2))){
                boolean isTrue = isEquivelant(Integer.parseInt("24"), Integer.parseInt("24"));
                if(!isTrue){
                    return false;
                }
            }
        }
    }
}
