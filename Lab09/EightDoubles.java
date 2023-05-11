import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;
public class EightDoubles {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                double doubles[] = new double[8];
                        for(int i = 0; i <= 7; i++) {
                                boolean invalidEntry;
                                do{
                                        try {
                                                invalidEntry = false;
                                                doubles[i] = sc.nextDouble();
                                        } catch(InputMismatchException exception) {
                                                System.err.println("ERROR: non-numeric input. Please reenter.");
                                                sc.nextLine();
                                                invalidEntry = true;
                                        }
                                } while(invalidEntry);
                        }
                double max = -Double.MAX_VALUE;
                double min = Double.MAX_VALUE;
                double total = 0;
                for(int i = 0; i <= 7; i++) {
                        if(doubles[i] > max)
                                max = doubles[i];
                        if(doubles[i] < min)
                                min = doubles[i];
                        total += doubles[i];
                }
                DecimalFormat df = new DecimalFormat("0.00");
                System.out.println("Maximum " + max);
                System.out.println("Minimun " + min);
                System.out.println("Average " + df.format(total / (double) 8));
        }
}
