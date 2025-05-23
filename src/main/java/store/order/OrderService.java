package store.order;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import store.product.ProductController;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private ProductController productClient;

    public OrderOut create(OrderIn in, String idAccount) {
        if (in.items() == null || in.items().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order must contain items");
        OrderModel saved = orderRepository.save(OrderParser.fromIn(in, idAccount, productClient));
        return OrderParser.toOut(saved);
    }

    public List<OrderOut> findAll(String idAccount) {
        return orderRepository.findByIdAccount(idAccount).stream()
                .map(OrderParser::toOut)
                .collect(Collectors.toList());
    }

    public OrderOut findById(String id, String idAccount) {
        OrderModel om = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!om.idAccount().equals(idAccount))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return OrderParser.toOut(om);
    }
}