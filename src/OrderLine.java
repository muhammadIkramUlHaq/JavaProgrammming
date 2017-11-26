/**
 * Created with IntelliJ IDEA.
 * User: Ikram
 * Date: 11/26/17
 * Time: 1:50 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * OrderLine is made immutable so that it can only be changed by providing the value into constructor
 */
public class OrderLine {
        private final int productIdentifier;
        private final String productName;
        private final int amount;

        public OrderLine(Product product, int amount) {
            this.productIdentifier = product.getIdentifier();
            this.productName = product.getPriceName();
            this.amount = amount;
        }

        public int getTotalPrice(){
            return  amount;
        }
}
