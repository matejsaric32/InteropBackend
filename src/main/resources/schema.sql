CREATE TABLE IF NOT EXISTS HARDWARE
(
    ID    BIGINT AUTO_INCREMENT PRIMARY KEY,
    CODE  VARCHAR(100) NOT NULL UNIQUE,
    NAME  VARCHAR(100) NOT NULL,
    TYPE  VARCHAR(100) NOT NULL,
    STOCK INT          NOT NULL,
    PRICE NUMERIC      NOT NULL
);

CREATE TABLE IF NOT EXISTS REVIEW
(
    REVIEW_ID   BIGINT AUTO_INCREMENT PRIMARY KEY,
    UID         VARCHAR(100)  NOT NULL UNIQUE,
    TITLE       VARCHAR(100)  NOT NULL,
    TEXT        VARCHAR(1000) NOT NULL,
    RATING      BIGINT        NOT NULL,
    HARDWARE_ID BIGINT,
    CONSTRAINT FK_HARDWARE FOREIGN KEY (HARDWARE_ID) REFERENCES HARDWARE (ID)
);

-- create table if not exists account (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     username varchar(100) not null unique,
--     password varchar(1000) not null
--     );
--
-- create table if not exists authority (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     authority_name varchar(100) not null unique
--     );
--
-- create table if not exists account_authority (
--     account_id      bigint not null,
--     authority_id bigint not null,
--     constraint fk_account foreign key (account_id) references account(id),
--     constraint fk_authority foreign key (authority_id) references authority(id)
--     );