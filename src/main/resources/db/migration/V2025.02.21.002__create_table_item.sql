CREATE TABLE orders.item (
    id_item     VARCHAR(36)       NOT NULL,
    id_product  VARCHAR(36)       NOT NULL,
    quantity    INTEGER           NOT NULL,
    total       DOUBLE PRECISION  NOT NULL,
    id_order    VARCHAR(36)       NOT NULL,
    CONSTRAINT pk_item PRIMARY KEY (id_item)
);