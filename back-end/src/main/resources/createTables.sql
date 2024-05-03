CREATE TABLE CLOTHES_ITEMS
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    type_id     VARCHAR(50)  NOT NULL,
    outfit_id   BIGINT       NOT NULL,
    CONSTRAINT fk_outfit
        FOREIGN KEY (outfit_id) REFERENCES OUTFITS (id)
);
CREATE TABLE CLOTHES_PHOTOS
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    clothes_item_id BIGINT       NOT NULL,
    photo           VARCHAR(255) NOT NULL,
    CONSTRAINT fk_clothes_item
        FOREIGN KEY (clothes_item_id) REFERENCES CLOTHES_ITEMS (id)
);
CREATE TABLE CLOTHES_ITEM_TYPES
(
    id          VARCHAR(50) PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);
CREATE TABLE OUTFITS
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    user_id LONG         NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES USERS (id)
);
CREATE TABLE OUTFIT_TAGS
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    outfit_id BIGINT       NOT NULL,
    tag       VARCHAR(255) NOT NULL,
    CONSTRAINT fk_outfit
        FOREIGN KEY (outfit_id) REFERENCES OUTFITS (id)
);
CREATE TABLE USERS
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname          VARCHAR(255) NOT NULL,
    email             VARCHAR(255) NOT NULL UNIQUE,
    password          VARCHAR(255) NOT NULL,
    registration_date DATETIME     NOT NULL
);
CREATE TABLE COMMENTS
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT      NOT NULL,
    outfit_id        BIGINT      NOT NULL,
    comment_text     TEXT        NOT NULL,
    rate             VARCHAR(50) NOT NULL,
    date_of_creation DATETIME    NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES USERS (id),
    CONSTRAINT fk_outfit
        FOREIGN KEY (outfit_id) REFERENCES OUTFITS (id)
);
