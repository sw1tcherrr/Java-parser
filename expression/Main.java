package expression;

import expression.generic.GenericTabulator;
import expression.generic.Tabulator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Tabulator t = new GenericTabulator();
        Object[][][] table = t.tabulate(args[0].substring(1), args[1], -2, 2, -2, 2, -2, 2);
        for (Object[][] x : table) {
            for (Object[] xy : x) {
                System.out.print(Arrays.toString(xy) + " ");
            }
            System.out.println();
        }
    }
}
