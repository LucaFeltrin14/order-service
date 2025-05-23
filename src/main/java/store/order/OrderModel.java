package store.order;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "orders", schema = "orders")
@Data
@Accessors(fluent = true)
@NoArgsConstructor
public class OrderModel {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "dt_order", nullable = false)
    private LocalDateTime date;

    @Column(name = "id_account", nullable = false)
    private String idAccount;

    @Column(name = "vl_total", nullable = false)
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<ItemModel> items = new ArrayList<>();
}