public class Calculator {
    public double performCalculation(AppInterface operation, double a, double b) {
        return operation.calculate(a, b);
    }
}
