public class Transaction {
    String payment_info;
    int transaction_id;
    boolean transaction_status;
    float total;
    Order order;

    Transaction(String payment_info, int transaction_id, float total, Order order) {
        this.payment_info = payment_info;
        this.transaction_id = transaction_id;
        this.transaction_status = false;
        this.total = total;
        this.order = order;
    }

    public void updateStatus(boolean b){
        transaction_status = b;
    }
}