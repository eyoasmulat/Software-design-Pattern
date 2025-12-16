
package inventorypricing;

/**
 *
 * @author USER
 */
// SubtractExpression.java
public class SubtractExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(PricingContext context) {
        return left.interpret(context) - right.interpret(context);
    }
}
