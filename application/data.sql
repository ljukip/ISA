/* Dodavanje obicnih korisnika */
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (1, 'Bekki', 'Blomefield', 'bblomefield0@imdb.com', '3135448244', 'Detroit', 'lxKQ9V5SV1Q');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (2, 'Ham', 'Aldwich', 'haldwich1@sphinn.com', '4419905397', 'Peteranec', '0nmOvflObEDa');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (3, 'Kaitlynn', 'Fagg', 'kfagg2@pen.io', '2734251812', 'Haumeni', 'c53pBXAou7iP');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (4, 'Remus', 'Cuff', 'rcuff3@php.net', '4069609280', 'Taounza', '1ISoIUrMFYs');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (5, 'Rebbecca', 'Wedgbrow', 'rwedgbrow4@hugedomains.com', '3556728245', 'Olenyok', 'wdCF92TsKv');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (6, 'Thia', 'McGhie', 'tmcghie5@hugedomains.com', '9306858412', 'Palu', 'zf2lKhF9BQPM');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (7, 'Osborn', 'Toffolo', 'otoffolo6@dailymotion.com', '8672972721', 'Saint-Herblain', 'QJwPx14');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (8, 'Bartolomeo', 'Aggis', 'baggis7@yellowbook.com', '6184506392', 'Kushtia', 'fOOwb9Jt');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (9, 'Trina', 'Noore', 'tnoore8@mozilla.org', '7029104854', 'Cikupa', 'HjadYH63V');
insert into isa_schema.korisnik (id, ime, prezime, email, telefon, grad, lozinka) values (10, 'Herculie', 'Cronkshaw', 'hcronkshaw9@ezinearticles.com', '7566402446', 'Pelabuhanratu', 'TgmLm4JQgW');
/* Dodavanje admina sistema */
insert into isa_schema.admin_sistema (id, ime, prezime, email, telefon, grad, lozinka) values (1, 'Emyle', 'Levesque', 'elevesque0@discuz.net', '6005578407', 'Yaurisque', 'TyUGF3');
insert into isa_schema.admin_sistema (id, ime, prezime, email, telefon, grad, lozinka) values (2, 'Gilbertina', 'Longson', 'glongson1@cdc.gov', '6877921342', 'Gul’cha', 'r7KJBm');
insert into isa_schema.admin_sistema (id, ime, prezime, email, telefon, grad, lozinka) values (3, 'Papagena', 'Belli', 'pbelli2@answers.com', '4109389844', 'Baltimore', 'xs7TTAyQJI');
insert into isa_schema.admin_sistema (id, ime, prezime, email, telefon, grad, lozinka) values (4, 'Vergil', 'Bocke', 'vbocke3@twitter.com', '6977461326', 'Lucapa', 'LBeXtx');
/* Dodavanje admina kompanija */
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (1, 'Keane', 'Goodenough', 'kgoodenough0@nhs.uk', '1839404084', 'Yaohua', 'fIQhbXq', 'ADMIN_AVIONSKE_KOMPANIJE', 3, null, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (2, 'Griffie', 'Ferretti', 'gferretti1@so-net.ne.jp', '3314181429', 'Marinilla', 'cYDazNY', 'ADMIN_AVIONSKE_KOMPANIJE', 2, null, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (3, 'Morna', 'Maccaig', 'mmaccaig2@deviantart.com', '1713920058', 'Bibis', 'hHYHxpnzm', 'ADMIN_KOMPANIJE_VOZILA', null, null, 2);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (4, 'Adelice', 'Roj', 'aroj3@mozilla.org', '3556989537', 'Bang Saphan', '0yg9WthVcJ', 'ADMIN_HOTELA', null, 5, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (5, 'Elfrieda', 'Challenor', 'echallenor4@wired.com', '7498890750', 'Trinaterra', 'ZGc3be2dHeR8', 'ADMIN_KOMPANIJE_VOZILA', null, null, 1);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (6, 'Bonnibelle', 'Ferraraccio', 'bferraraccio5@joomla.org', '6011733633', 'Jackson', 'CYPoiDhO1', 'ADMIN_AVIONSKE_KOMPANIJE', 1, null, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (7, 'Kilian', 'Dryburgh', 'kdryburgh6@npr.org', '4358681446', 'Laban', 'o6vqVe041', 'ADMIN_HOTELA', null, 3, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (8, 'Upton', 'Iorns', 'uiorns7@naver.com', '7187848303', 'Utrecht', '9wrPi3WFD', 'ADMIN_HOTELA', null, 2, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (9, 'Babbie', 'Stuchburie', 'bstuchburie8@hc360.com', '3736404312', 'Luhe', 'B76ZMw', 'ADMIN_HOTELA', null, 8, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (10, 'Pooh', 'Haley', 'phaley9@amazon.com', '2866911725', 'Sandvika', 'irN7W3l', 'ADMIN_HOTELA', null, 7, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (11, 'Stanislas', 'Mayou', 'smayoua@cdc.gov', '9998599658', 'Baojiadian', 'kHNI1sXrla', 'ADMIN_AVIONSKE_KOMPANIJE', 1, null, null);
insert into isa_schema.admin_kompanije (id, ime, prezime, email, telefon, grad, lozinka, tip, avionska_kompanija_id, hotel_id, kompanija_vozila_id) values (12, 'Hartley', 'Timson', 'htimsonb@networkadvertising.org', '3586701536', 'Yëlkino', 'VANidQ0SR', 'ADMIN_HOTELA', null, 1, null);
/* Dodavanje adresa */
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (1, '51776', 'Barabedang', 'Indonesia', 'Oak', null, null, 6, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (2, '30162', 'Huzhen', 'China', 'Gina', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (3, '9778', 'Naguilian', 'Philippines', 'Dennis', null, null, 8, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (4, '5142', 'Julita', 'Philippines', 'Shasta', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (5, '73', 'Deán Funes', 'Argentina', 'Schurz', null, null, 1, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (6, '671', 'Gikongoro', 'Rwanda', 'Little Fleur', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (7, '3', 'Patrocínio', 'Brazil', 'Daystar', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (8, '18091', 'Xichehe', 'China', 'Gerald', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (9, '6742', 'Beberon', 'Philippines', 'Stuart', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (10, '48', 'Yanji', 'China', 'Garrison', null, null, 4, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (11, '68', 'Chengxi', 'China', 'Katie', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (12, '1', 'Longgao', 'China', 'Mccormick', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (13, '8998', 'Bokat', 'Indonesia', 'Valley Edge', null, null, 2, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (14, '65', 'Binalbagan', 'Philippines', 'Mayfield', null, null, null, 2);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (15, '2803', 'Perlez', 'Serbia', 'Banding', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (16, '1', 'Baharly', 'Turkmenistan', 'Walton', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (17, '61', 'Gombe', 'Uganda', 'Maryland', null, null, 5, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (18, '4414', 'Xinghua', 'China', 'Lillian', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (19, '3', 'Tsuma', 'Japan', 'Gina', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (20, '15665', 'Sibanicú', 'Cuba', 'Mccormick', null, 1, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (21, '3483', 'Hirosaki', 'Japan', 'Hollow Ridge', null, null, 3, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (22, '77', 'Joaquín Suárez', 'Uruguay', 'International', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (23, '60', 'Birmingham', 'United States', 'Tony', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (24, '01321', 'Ijūin', 'Japan', 'Dwight', null, 4, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (25, '09', 'Tanggung', 'Indonesia', 'Hoepker', null, 2, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (26, '38', 'Maramag', 'Philippines', 'Oriole', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (27, '6', 'Bobo-Dioulasso', 'Burkina Faso', 'Dakota', null, null, null, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (28, '34', 'Hengshitang', 'China', 'Porter', null, null, 7, null);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (29, '79', 'Zakhim', 'Yemen', 'Grayhawk', null, null, null, 1);
insert into isa_schema.adresa (id, broj, grad, zemlja, ulica, avionska_kompanija_id, garaza_id, hotel_id, kompanija_vozila_id) values (30, '0', 'Yonglong', 'China', 'Aberg', null, 3, null, null);
/* Dodavanje kompanija vozila */
insert into isa_schema.kompanija_vozila (id, naziv, opis, adresa_id) values (1, 'Lueilwitz LLC', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', 29);
insert into isa_schema.kompanija_vozila (id, naziv, opis, adresa_id) values (2, 'Hermiston, Kiehn and O''Conner', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 14);
/* Dodavanje garaza kompanijama vozila */
insert into isa_schema.garaza (id, adresa_id, kompanija_id) values (1, 20, 2);
insert into isa_schema.garaza (id, adresa_id, kompanija_id) values (2, 25, 2);
insert into isa_schema.garaza (id, adresa_id, kompanija_id) values (3, 30, 2);
insert into isa_schema.garaza (id, adresa_id, kompanija_id) values (4, 24, 1);
/* Dodavanje vozila garazama */
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (1, 6, 4.5, 'SEDAN', 4);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (2, 5, 11.9, 'MINIVAN', 1);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (3, 3, 24.3, 'DZIP', 3);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (4, 5, 22.5, 'MINIVAN', 2);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (5, 3, 29.5, 'MINIVAN', 3);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (6, 5, 17.0, 'SEDAN', 3);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (7, 6, 5.5, 'SEDAN', 3);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (8, 7, 17.6, 'DZIP', 3);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (9, 2, 17.9, 'SEDAN', 2);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (10, 2, 13.9, 'MINIVAN', 4);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (11, 7, 24.4, 'MINIVAN', 1);
insert into isa_schema.vozilo (id, broj_putnika, cena_po_danu, tip, garaza_id) values (12, 5, 28.5, 'SEDAN', 4);
/* Dodavanje hotela */
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (1, 'Reilly LLC', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 5);
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (2, 'Klocko-Lowe', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 13);
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (3, 'Raynor-Bayer', 'In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 21);
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (4, 'Windler-Erdman', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', 10);
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (5, 'Nolan-McLaughlin', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', 17);
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (6, 'Schamberger-Lemke', 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 1);
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (7, 'Beier, Blanda and Schimmel', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', 28);
insert into isa_schema.hotel (id, naziv, opis, adresa_id) values (8, 'Schoen and Sons', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 3);
/* Dodavanje soba hotelima */
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (1, 7, 4, 'TROKREVETNA', 2);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (2, 9, 4, 'JEDNOKREVETNA', 1);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (3, 1, 1, 'JEDNOKREVETNA', 6);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (4, 5, 3, 'TROKREVETNA', 3);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (5, 8, 5, 'DVOKREVETNA', 3);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (6, 7, 0, 'JEDNOKREVETNA', 7);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (7, 2, 4, 'TROKREVETNA', 8);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (8, 1, 3, 'JEDNOKREVETNA', 7);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (9, 8, 3, 'DVOKREVETNA', 2);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (10, 2, 3, 'TROKREVETNA', 4);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (11, 3, 2, 'JEDNOKREVETNA', 4);
insert into isa_schema.soba (id, broj_kreveta, sprat, tip, hotel_id) values (12, 8, 1, 'DVOKREVETNA', 3);
/* Dodavanje opcija hotelima */
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (1, 2, 18.8, '6th generation');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (2, 2, 28.9, 'orchestration');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (3, 3, 20.9, 'process improvement');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (4, 2, 4.6, 'eco-centric');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (5, 2, 14.2, 'empowering');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (6, 8, 35.8, 'Multi-tiered');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (7, 4, 46.1, 'Upgradable');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (8, 4, 4.6, 'mobile');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (9, 4, 16.3, 'leading edge');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (10, 2, 20.0, 'open system');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (11, 8, 9.1, 'attitude');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (12, 8, 25.4, 'incremental');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (13, 6, 48.8, 'Team-oriented');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (14, 6, 45.9, 'exuding');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (15, 3, 29.2, 'systematic');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (16, 8, 19.0, 'Integrated');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (17, 1, 32.7, 'radical');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (18, 4, 29.9, 'Balanced');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (19, 3, 34.3, 'hardware');
insert into isa_schema.opcija (id, hotel_id, cena, naziv) values (20, 1, 27.7, 'Multi-tiered');
/* Dodavanje cenovnika sobama */
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (1, 28.8, '2019-08-29 23:59:37', '2019-09-11 13:39:19', 12);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (2, 83.3, '2019-09-13 17:00:21', '2019-09-20 11:10:01', 1);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (3, 67.1, '2019-08-27 19:40:27', '2019-09-08 15:05:32', 5);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (5, 29.7, '2019-09-02 15:03:24', '2019-09-22 21:14:16', 8);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (7, 56.2, '2019-08-31 14:08:15', '2019-09-11 09:48:00', 1);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (8, 50.7, '2019-09-07 22:48:08', '2019-09-25 11:25:29', 3);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (9, 51.1, '2019-09-10 00:33:58', '2019-09-26 23:57:17', 5);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (10, 83.5, '2019-09-10 06:07:12', '2019-09-21 23:19:58', 4);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (13, 52.4, '2019-09-05 21:38:46', '2019-09-9 06:26:57', 4);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (14, 27.9, '2019-09-11 06:15:03', '2019-09-13 21:41:49', 9);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (15, 50.1, '2019-09-15 10:15:52', '2019-09-24 14:06:07', 12);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (18, 57.3, '2019-08-27 09:32:32', '2019-09-24 11:41:10', 10);
insert into isa_schema.cenovnik_sobe (id, cena, pocetni_datum, krajnji_datum, soba_id) values (20, 70.4, '2019-09-06 08:35:53', '2019-09-14 17:58:14', 7);