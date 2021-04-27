-- Suggested testing environment:
-- http://sqlite.online/

-- Example case create statement:
CREATE TABLE sellers
(
    id     INTEGER     NOT NULL PRIMARY KEY,
    name   VARCHAR(30) NOT NULL,
    rating INTEGER     NOT NULL
);

CREATE TABLE items
(
    id       INTEGER     NOT NULL PRIMARY KEY,
    name     VARCHAR(30) NOT NULL,
    sellerId INTEGER REFERENCES sellers (id)
);

INSERT INTO sellers(id, name, rating)
VALUES (1, 'Roger', 3);
INSERT INTO sellers(id, name, rating)
VALUES (2, 'Penny', 5);

INSERT INTO items(id, name, sellerId)
VALUES (1, 'Notebook', 2);
INSERT INTO items(id, name, sellerId)
VALUES (2, 'Stapler', 1);
INSERT INTO items(id, name, sellerId)
VALUES (3, 'Pencil', 2);

-- Expected output (in any order):
-- Item      Seller
-- ----------------
-- Notebook  Penny
-- Pencil    Penny
