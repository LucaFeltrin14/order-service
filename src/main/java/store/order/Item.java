package store.order;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import store.product.ProductOut;

@Builder
@Data
@Accessors(fluent = true)
public class Item {
    private String id;
    private ProductOut product;  // agora contém o objeto completo
    private int quantity;
    private double total;
}