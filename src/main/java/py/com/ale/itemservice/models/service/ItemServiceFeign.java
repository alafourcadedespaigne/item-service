package py.com.ale.itemservice.models.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import py.com.ale.itemservice.clients.ProductRestClient;
import py.com.ale.itemservice.models.entity.Item;

@Service("serviceFeing")
public class ItemServiceFeign implements ItemServices {

  @Autowired
  private ProductRestClient productRestClient;

  @Override
  public List <Item> findAll() {
    return productRestClient.listar().stream().map(p -> new Item(p, 1))
        .collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer count) {
    return new Item(productRestClient.detalle(id), count);
  }
}
