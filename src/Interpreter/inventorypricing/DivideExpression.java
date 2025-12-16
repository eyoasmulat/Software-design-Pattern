
package inventorypricing;

/**
 *
 * @author USER
 */
// DivideExpression.java
public class DivideExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(PricingContext context) {
        double divisor = right.interpret(context);
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left.interpret(context) / divisor;
    }
}
