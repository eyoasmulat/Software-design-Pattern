
package inventorypricing;

/**
 *
 * @author USER
 */
// MultiplyExpression.java
public class MultiplyExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(PricingContext context) {
        return left.interpret(context) * right.interpret(context);
    }
}
