package py.com.ale.itemservice.models.service;

import java.util.List;
import py.com.ale.itemservice.models.entity.Item;

public interface ItemServices {

  List<Item> findAll();
  Item findById(Long id, Integer count);

}
