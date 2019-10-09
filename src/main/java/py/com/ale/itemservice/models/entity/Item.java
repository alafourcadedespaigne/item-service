package py.com.ale.itemservice.models.entity;

public class Item {

  private Product product;
  private Integer count;

  public Item() {
  }


  public Double getAmount() {
    return product.getPrice() * count.doubleValue();
  }

  public Item(Product product, Integer count) {
    this.product = product;
    this.count = count;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
