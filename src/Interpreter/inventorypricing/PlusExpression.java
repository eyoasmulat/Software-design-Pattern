
package inventorypricing;

/**
 *
 * @author USER
 */
// PlusExpression.java
public class PlusExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(PricingContext context) {
        return left.interpret(context) + right.interpret(context);
    }
}
