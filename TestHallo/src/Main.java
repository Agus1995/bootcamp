public class Main {

    public static void main(String[] args) {
        int x;
        int y;

        for(x=0;x<10;x++){
            for(y=0;y<10;y++) {

                    if (x+y==6){
                        System.out.print("*");
                    }
                    else if (y-x==6){
                        System.out.print("*");
                    }
                    else if (x==6){
                        System.out.print("*");
                    }
                    else if (x==3 && y==6){
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
            }
            System.out.println();
        }

    }
}
