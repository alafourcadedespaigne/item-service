package py.com.ale.itemservice.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import py.com.ale.itemservice.models.entity.Producto;

@FeignClient(name = "products-services")
public interface ProductRestClient {


  @GetMapping("/listar")
  List <Producto> listar();


  @GetMapping("ver/{id}")
  Producto detalle(@PathVariable Long id);

}
