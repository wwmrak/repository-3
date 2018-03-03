public class Order {
  int bricksQuanity = 0;
  String orderReference = null;
  boolean isDispatched = false;
  int responseStatus = 0;

  public int getBricksQuanity() {
    return bricksQuanity;
  }

  public void setBricksQuanity(int bricksQuanity) {
    this.bricksQuanity = bricksQuanity;
  }

  public String getOrderReference() {
    return orderReference;
  }

  public void setOrderReference(String orderReference) {
    this.orderReference = orderReference;
  }

  public boolean isDispatched() {
    return isDispatched;
  }

  public void setDispatched(boolean isDispatched) {
    this.isDispatched = isDispatched;
  }

  public int getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(int responseStatus) {
    this.responseStatus = responseStatus;
  }
}
