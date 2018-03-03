import java.util.List;

public class RestClientTest {
  RestClient restClient = new RestClient();

  public static void main(String[] args) throws Exception {
    RestClientTest main = new RestClientTest();
    main.callTests();
  }

  @SuppressWarnings({"unused"})
  void callTests() {
    // 1.a
    Order orderObj1 = new Order();
    orderObj1.setBricksQuanity(5);

    try {
      String orderReference = restClient.submitOrderGetReference(orderObj1);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 1.b
    Order orderObj2 = new Order();
    orderObj2.setOrderReference("orderReference1");

    try {
      Order orderObjReturn = restClient.submitOrderReferenceGetOrder(orderObj2);

      // if invalid order reference is submitted null is returned
      if (orderObjReturn != null) {
        String orderReference = orderObjReturn.getOrderReference();
        int bricksQuantity = orderObjReturn.getBricksQuanity();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 1.c
    try {
      List<Order> orders = restClient.getAllOrders();

      for (Order orderObjReturn : orders) {
        if (orderObjReturn != null) {
          String orderReference = orderObjReturn.getOrderReference();
          int bricksQuantity = orderObjReturn.getBricksQuanity();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
