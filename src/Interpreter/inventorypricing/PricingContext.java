
package inventorypricing;

/**
 *
 * @author USER
 */
// PricingContext.java
import java.util.HashMap;
import java.util.Map;

public class PricingContext {
    private final Map<String, Double> variables = new HashMap<>();

    public void setVariable(String name, double value) {
        variables.put(name, value);
    }

    public double getValue(String name) {
        if (!variables.containsKey(name)) {
            throw new IllegalArgumentException("Variable not found: " + name);
        }
        return variables.get(name);
    }
}