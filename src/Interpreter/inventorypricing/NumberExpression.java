
package inventorypricing;

/**
 *
 * @author USER
 */
// NumberExpression.java
public class NumberExpression implements Expression {
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public double interpret(PricingContext context) {
        return value;
    }
}