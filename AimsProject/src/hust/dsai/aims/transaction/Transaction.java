package hust.dsai.aims.transaction;

import hust.dsai.aims.order.Order;

public class Transaction {
  String payment_info;
  int transaction_id;
  boolean transaction_status;
  double total;
  Order order;

  public Transaction(String payment_info, int transaction_id, double total, Order order) {
    this.payment_info = payment_info;
    this.transaction_id = transaction_id;
    this.transaction_status = false;
    this.total = total;
    this.order = order;
  }

  public void updateStatus(boolean b) {
    transaction_status = b;
  }
}
