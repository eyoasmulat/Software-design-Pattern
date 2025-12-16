
package inventorypricing;

/**
 *
 * @author USER
 */
// VariableExpression.java
public class VariableExpression implements Expression {
    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public double interpret(PricingContext context) {
        return context.getValue(name);
    }
}