package py.com.ale.itemservice.models.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.ale.itemservice.clients.ProductRestClient;
import py.com.ale.itemservice.models.entity.Item;
import py.com.ale.itemservice.models.entity.Producto;

@Service("serviceFeing")
public class ItemServiceFeign implements ItemServices {

  @Autowired
  private ProductRestClient productRestClient;

  @Override
  public List <Item> findAll() {
    return productRestClient.listar().stream().map(p -> new Item(p, 1))
        .collect(Collectors.toList());
  }

  @HystrixCommand(fallbackMethod = "metodoAlternativo")
  @Override
  public Item findById(Long id, Integer count) {
    return new Item(productRestClient.detalle(id), count);
  }


  public Item metodoAlternativo(Long id, Integer count) {
    Item item = new Item();
    Producto producto = new Producto();

    item.setCount(count);
    producto.setId(id);
    producto.setName("Sony Camera");
    producto.setPrice(500.00);
    item.setProducto(producto);
    return item;
  }
}
