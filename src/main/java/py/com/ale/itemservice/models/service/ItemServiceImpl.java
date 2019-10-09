package py.com.ale.itemservice.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import py.com.ale.itemservice.models.entity.Item;
import py.com.ale.itemservice.models.entity.Product;

@Service
public class ItemServiceImpl implements ItemServices {

  @Autowired
  RestTemplate restClient;

  @Override
  public List <Item> findAll() {

    List <Product> products = Arrays.asList(Objects
        .requireNonNull(restClient.getForObject("http://localhost:8001/listar", Product[].class)));

    return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer count) {
    Map <String, String> pathVariable = new HashMap <>();
    pathVariable.put("id", id.toString());
    Product product = restClient
        .getForObject("http://localhost:8001/ver/{id}", Product.class, pathVariable);

    return new Item(product, count);
  }
}
