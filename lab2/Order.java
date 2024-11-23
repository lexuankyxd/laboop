public class Order {
    CustomerUser user;
    int ord_id;
    boolean status;
    float shippingCost;
    float totalCost;

    Order(CustomerUser user, int id){
        this.user = user;
        this.ord_id = id;
        this.status = false;
        this.shippingCost = AimsSystem.calculateShippingCost(this);
        totalCost = user.cart.total * 1.1f + shippingCost;
    }

    public void printOrder(){
        System.out.println(ord_id + " status: " + status + " shippingCost: " + shippingCost + " totalCost: " + totalCost);
    }

    public void updateStatus(boolean b){
        status = b;
    }
}