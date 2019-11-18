package pac;

public class printer {
    private static int og = 0, yg = 0, i=-1;
    private static long t=-1;

    public void print(String action, long duration) {
        boolean f = true;
        if (action.equals("end of minor GC")) {
            yg++;
            f = true;
        }
        if (action.equals("end of major GC")) {
            og++;
            f = false;
        }
        System.out.printf("%-11d%-9s%-9d%-12s%-13d%-10.1f\n", yg, f ? String.valueOf(duration) : " ", og, f ? " " : String.valueOf(duration),i,t/60000.0);
    }

    public static void setI(int i) {
        printer.i = i;
    }

    public static void setT(long t) {
        printer.t = t;
    }
}
