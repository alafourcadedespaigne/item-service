package py.com.ale.itemservice.models.entity;

public class Item {

  private Producto producto;
  private Integer count;

  public Item() {
  }


  public Double getAmount() {
    return producto.getPrice() * count.doubleValue();
  }

  public Item(Producto producto, Integer count) {
    this.producto = producto;
    this.count = count;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
