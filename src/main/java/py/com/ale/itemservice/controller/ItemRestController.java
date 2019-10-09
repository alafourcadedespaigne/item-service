package py.com.ale.itemservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import py.com.ale.itemservice.models.entity.Item;
import py.com.ale.itemservice.models.service.ItemServices;

@RestController
public class ItemRestController {

  @Autowired
  @Qualifier("serviceFeing")
  ItemServices itemServices;

  @GetMapping("getAll")
  public List <Item> findAll() {
    return itemServices.findAll();
  }

  @GetMapping("ver/{id}/count/{count}")
  public Item detail(@PathVariable Long id, @PathVariable Integer count) {
    return itemServices.findById(id, count);
  }
}
