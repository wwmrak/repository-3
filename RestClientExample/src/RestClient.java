import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
  private static final String URI = "http://......";

  /**
   * Important remark
   *
   * Different methods in rest client could have been combined in one, but one method should usually
   * perform one thing. For better readibility, for cases when method does two sufficiently
   * different tasks it is divided into two methods
   */

  // 1.a
  public String submitOrderGetReference(Order orderObj) throws Exception {
    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target(URI).path("ordersSubmit");

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
    Response response =
        invocationBuilder.post(Entity.entity(orderObj, MediaType.APPLICATION_JSON_TYPE));

    String orderReference = response.readEntity(String.class);
    return orderReference;
  }

  // 1.b
  public Order submitOrderReferenceGetOrder(Order orderObj) throws Exception {
    Client client = ClientBuilder.newClient();
    WebTarget webTarget =
        client.target(URI).path("orderReference").path(orderObj.getOrderReference());

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
    Response response = invocationBuilder.get();

    Order orderObjReturn = response.readEntity(Order.class);
    return orderObjReturn;
  }

  // 1.c
  public List<Order> getAllOrders() throws Exception {
    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target(URI).path("orders").path("all");

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
    Response response = invocationBuilder.get();

    List<Order> ordersReturn = response.readEntity(new GenericType<List<Order>>() {});
    return ordersReturn;
  }
}
