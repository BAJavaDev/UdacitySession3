package functionalinterfaces;
@FunctionalInterface
public interface CalculatorInterface<T> {
    public T performOperation(T num1, T num2);
}
