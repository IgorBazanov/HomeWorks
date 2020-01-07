package calculator;


class Calculator {

    int add(int x, int y) {
        return x + y;
    }

    double div(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException();
        }
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        if (x % y != 0) {
            throw new IllegalArgumentException();
        }
        return x / y;
    }

}
