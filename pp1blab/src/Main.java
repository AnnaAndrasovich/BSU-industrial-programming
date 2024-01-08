import java.text.NumberFormat;
import java.util.Scanner;
import static java.lang.Math.*;

public class Main {
    public static double x_get(double w){
        double x = w;
        if (x < -1 || x > 1){
            x = x_get(w);
        }
        return x;
    }

    public static double eps_get(int es){
        double eps = 10.0;
        int k = es;
        if (k < 1){
            eps = eps_get(es);
        }
        for (; k != 0; --k){
            eps *= 0.1;
        }
        return eps;
    }

    public static double res_get (double k, double e){
        double res = k, per = e, i = 1, dk = k * k, p1 = 1.0, p2 = k;
        while (per >= e){
            p1 *= i / ++i;
            p2 *= dk;
            per = p1 * p2 / ++i;
            res += per;
        }
        return res;
    }
    public static void main(String[] args) {
        int k = 6; double w = 0.089, x = 0.08, eps = 7;

        Scanner ts = new Scanner(System.in);
        System.out.print ("Enter the x, x => (-1; +1): ");
            do { x = ts.nextDouble();}
            while (x < -1 || x > 1);

        System.out.println("Enter eps (eps is N): ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt())
        {
            k = sc.nextInt();
            eps = eps_get (k);
        }
        else
            System.out.println("There is not any number \n");

        double res;
        res = res_get (x, eps);
        double as = asin(x);
        System.out.print ("By implemented function: asin x =\n");
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k);
        System.out.println(formatter.format(res));
        System.out.print("By function from class 'Math': asin x = \n");
        System.out.println(formatter.format(as));
    }
}
