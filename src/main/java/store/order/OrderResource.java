package store.order;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderResource implements OrderController {

    @Autowired
    private OrderService service;

    @Override
    public ResponseEntity<OrderOut> create(@RequestBody OrderIn in) {
        String idAccount = RequestHeaderHelper.idAccount();
        return ResponseEntity.status(201).body(service.create(in, idAccount));
    }

    @Override
    public ResponseEntity<List<OrderOut>> findAll() {
        String idAccount = RequestHeaderHelper.idAccount();
        return ResponseEntity.ok(service.findAll(idAccount));
    }

    @Override
    public ResponseEntity<OrderOut> findById(@PathVariable String id) {
        String idAccount = RequestHeaderHelper.idAccount();
        return ResponseEntity.ok(service.findById(id, idAccount));
    }
}