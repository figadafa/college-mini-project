public class Division implements AppInterface {
    public double calculate(double a, double b) {
        if (b == 0) throw new ArithmeticException("Tidak bisa dibagi NOL!!!");
        return a / b;
    }
}
