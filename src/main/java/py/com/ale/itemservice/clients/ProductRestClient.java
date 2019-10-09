package py.com.ale.itemservice.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import py.com.ale.itemservice.models.entity.Product;

@FeignClient(name = "products-services", url = "localhost:8001")
public interface ProductRestClient {

  @GetMapping("/listar")
  List <Product> listar();

  @GetMapping("ver/{id}")
  Product detalle(@PathVariable Long id);

}
