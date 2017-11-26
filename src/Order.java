import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ikram
 * Date: 11/26/17
 * Time: 1:53 AM
 * To change this template use File | Settings | File Templates.
 */


/**
 * Aggregate ROOT for OrderLine as OrderLine items must exits only if there is an order from particular customer
 */
public class Order {

    private final List<OrderLine> orderLines = new ArrayList<OrderLine>();
    private final Customer customer;
    private int totalAmount;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return Collections.unmodifiableList(orderLines);
    }

    public void addToOrder(Product product, int amount) {
        removeFromOrder(product);
        final OrderLine orderLine = new OrderLine(product, amount);
        orderLines.add(orderLine);
        totalAmount = totalAmount + (orderLine.getTotalPrice());
        calculateDiscount();
    }

    public void removeFromOrder(Product product) {
             ///
    }

    public void calculateDiscount(){
        totalAmount =  (totalAmount * 10) / 100;
    }

}