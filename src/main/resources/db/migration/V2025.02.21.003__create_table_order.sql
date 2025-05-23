CREATE TABLE orders.orders (
    id_order    VARCHAR(36)       NOT NULL,
    dt_order    TIMESTAMP         NOT NULL,
    id_account  VARCHAR(36)       NOT NULL,
    vl_total    DOUBLE PRECISION  NOT NULL,
    CONSTRAINT pk_order PRIMARY KEY (id_order)
);