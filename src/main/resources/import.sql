insert into parent (par_name, par_address, par_city, par_email) values ('Aline Bastos', 'Rua das Flores, 13', 'Lorena', 'teste@teste.com');
insert into parent (par_name, par_address, par_city, par_email) values ('Ana Beatriz', 'Rua das Flores, 13', 'Lorena', 'teste@teste.com');
insert into parent (par_name, par_address, par_city, par_email) values ('Carla Brum', 'Rua das Flores, 13', 'Lorena', 'teste@teste.com');
insert into parent (par_name, par_address, par_city, par_email) values ('Cristina Aparecida', 'Rua das Flores, 13', 'Lorena', 'teste@teste.com');
insert into parent (par_name, par_address, par_city, par_email) values ('Valeria Vasques', 'Rua das Flores, 13', 'Lorena', 'teste@teste.com');
insert into parent (par_name, par_address, par_city, par_email) values ('Silvia Toledo', 'Rua das Flores, 13', 'Lorena', 'teste@teste.com');

insert into children (chi_name, chi_publicity, par_id) values ('Kauã', 'sim', 1);
insert into children (chi_name, chi_publicity, par_id) values ('Yasmin', 'sim', 3);
insert into children (chi_name, chi_publicity, par_id) values ('Letícia', 'não', 2);
insert into children (chi_name, chi_publicity, par_id) values ('Vitor', 'sim', 1);
insert into children (chi_name, chi_publicity, par_id) values ('Ana Lívia', 'sim', 4);
insert into children (chi_name, chi_publicity, par_id) values ('Breno', 'sim', 5);
insert into children (chi_name, chi_publicity, par_id) values ('Bianca', 'sim', 6);

insert into user (usr_active, usr_email, usr_name, usr_password) values(true,'teste@teste.com', 'israel', '$2a$10$npnxIqn0zTWBl.t2.LltQeZutM6RPCuf/4NdWotZLLvid8BGNLNC2');
insert into user (usr_active, usr_email, usr_name, usr_password) values(true,'teste@teste.com', 'jose', '$2a$10$npnxIqn0zTWBl.t2.LltQeZutM6RPCuf/4NdWotZLLvid8BGNLNC2');

insert into roles (role) values ('ADMIN');
insert into roles (role) values ('COMUM');

insert into usr_role (user_id, role_id) values (1, 1);
insert into usr_role (user_id, role_id) values (2, 2);

