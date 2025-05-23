package store.order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import store.product.ProductController;
import store.product.ProductOut;

public class OrderParser {

    public static OrderModel fromIn(OrderIn in, String idAccount, ProductController productClient) {
        OrderModel om = new OrderModel()
            .date(LocalDateTime.now())
            .idAccount(idAccount);

        double sum = 0;
        for (ItemIn ii : in.items()) {
            // busca preço
            ProductOut prod = productClient.findById(ii.idProduct()).getBody();
            if (prod == null) {
                throw new IllegalArgumentException("Produto não encontrado: " + ii.idProduct());
            }
            double subtotal = prod.price() * ii.quantity();
            sum += subtotal;

            // cria e associa o ItemModel
            Item iDom = Item.builder()
                .id(null)
                .product(prod)
                .quantity(ii.quantity())
                .total(subtotal)
                .build();

            ItemModel im = ItemParser.toModel(iDom, om);
            om.items().add(im);
        }
        om.total(sum);
        return om;
    }

    public static OrderOut toOut(OrderModel om) {
        List<ItemOut> ios = om.items().stream()
            .map(im -> ItemParser.toDomain(im))   // usa lambda claro
            .map(itemDom -> ItemParser.toOut(itemDom)) // se ItemParser tiver toOut
            .collect(Collectors.toList());

        return OrderOut.builder()
            .id(om.id())
            .date(om.date())
            .items(ios)
            .total(om.total())
            .build();
    }
}
