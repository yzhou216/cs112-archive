import java.util.Scanner;
public class Quadratic {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("a: ");
                double a = sc.nextDouble();
                System.out.print("b: ");
                double b = sc.nextDouble();
                System.out.print("c: ");
                double c = sc.nextDouble();
                double determinat = Math.pow(b, 2) - (double) 4 * a * c;  
                if (determinat > 0.0) {  
                        double x0 = (-b + Math.pow(determinat, 0.5)) / (2.0 * a);
                        double x1 = (-b - Math.pow(determinat, 0.5)) / (2.0 * a);
                        System.out.println("x1=" + x0);
                        System.out.println("x2=" + x1);
                } else if (determinat == 0.0) { 
                        double x0 = -b / (2.0 * a);
                        System.out.println("x1=" + x0);
                } else {
                        System.err.println("ERROR");
                }
        }
}
