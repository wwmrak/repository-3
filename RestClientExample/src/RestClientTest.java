
import java.util.List;

public class RestClientTest {
  RestClient restClient = new RestClient();

  public static void main(String[] args) throws Exception {
    RestClientTest restClientTestObj = new RestClientTest();
    restClientTestObj.callTests();
  }

  @SuppressWarnings("unused")
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

    // 2.
    Order orderObj3 = new Order();
    orderObj3.setOrderReference("orderReference1");
    orderObj3.setBricksQuanity(7);

    try {
      Order orderObjReturn = restClient.updateOrder(orderObj3);

      if (orderObjReturn != null) {
        String orderReference = orderObjReturn.getOrderReference();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 3.
    Order orderObj4 = new Order();
    orderObj4.setOrderReference("orderReference1");
    orderObj4.setDispatched(true);

    try {
      Order orderObjReturn = restClient.fulfillOrder(orderObj4);

      // 400 is returned as response status if invalid order reference is submitted
      if (orderObjReturn != null) {
        boolean isDispatched = orderObjReturn.isDispatched();
        int responseStatus = orderObjReturn.getResponseStatus();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 4.
    Order orderObj5 = new Order();
    orderObj5.setOrderReference("orderReference1");
    orderObj5.setBricksQuanity(9);

    try {
      Order orderObjReturn = restClient.updateOrder(orderObj5);

      // returns 400 for dispatched order
      if (orderObjReturn != null) {
        int responseStatus = orderObjReturn.getResponseStatus();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
