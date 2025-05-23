package store.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import store.product.ProductOut;

@Entity
@Table(name = "item", schema = "orders")
@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class ItemModel {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "id_product", nullable = false)
    private String idProduct;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "total", nullable = false)
    private double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    private OrderModel order;
}