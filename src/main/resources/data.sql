-- delete from review;
-- delete from hardware;
-- delete from account_authority;
-- delete from account;
-- delete from authority;

INSERT INTO HARDWARE (CODE, NAME, TYPE, STOCK, PRICE)
    VALUES
        ('1234561', 'Asus TUF RTX 3080', 'GPU', 0, 1599.00),
        ('1234562', 'EVGA XC3 RTX 3070 Ti', 'GPU', 3, 1299.00),
        ('1234563', 'AMD Ryzen 5950X', 'CPU', 15, 899.00),
        ('1234564', 'Samsung 980 PRO SSD 1TB', 'STORAGE', 30, 299.00),
        ('1234565', 'Kingston FURY Beast DDR5 32GB', 'RAM', 0, 699.00);


insert into REVIEW (UID,  TITLE, TEXT, RATING, HARDWARE_ID)
    values
        ('123', 'Radi odlično', 'Radi odlično sa zahtjevnim aplikacijama.', 5, 1),
        ('111', 'Nisam impresioniran', 'Ne dobivam očekivane performanse.', 3, 2),
        ('222', 'Sretan kupac', 'Nemam nikakvih problema s procesorom. Mogao bi biti malo jeftiniji.', 5, 3),
        ('333', 'Nije vrijedan cijene', 'Poboljšanje performansi ne opravdava visoku cijenu.', 2, 4),
        ('444', 'Dobivam odlične brzine', 'Ne mogu vjerovati da radi tako brzo.', 5, 5),
        ('555', 'Najbolja grafička na tržištu', 'Ne isplati se uzimati 3090, ova je dovoljno dobra.', 5, 1);

-- insert into account(id, username, password)
--     values
--         (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
--         (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin
--
-- insert into authority (id, authority_name)
-- values
--     (1, 'ROLE_ADMIN'),
--     (2, 'ROLE_USER');
--
-- insert into account_authority (account_id, authority_id)
-- values
--     (1, 2),
--     (2, 1);