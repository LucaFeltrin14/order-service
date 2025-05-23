package store.order;

import store.product.ProductOut;

public class ItemParser {
    // JPA -> domínio
    public static Item toDomain(ItemModel im) {
        ProductOut prod = ProductOut.builder().id(im.idProduct()).build();
        return Item.builder()
                   .id(im.id())
                   .product(prod)
                   .quantity(im.quantity())
                   .total(im.total())
                   .build();
    }

    // domínio -> JPA
    public static ItemModel toModel(Item i, OrderModel order) {
        ItemModel im = new ItemModel();
        im.idProduct(i.product().id());
        im.quantity(i.quantity());
        im.total(i.total());
        im.order(order);
        return im;
    }

    // domínio -> DTO de saída
    public static ItemOut toOut(Item i) {
        return ItemOut.builder()
                      .id(i.id())
                      .product(i.product())
                      .quantity(i.quantity())
                      .total(i.total())
                      .build();
    }
}