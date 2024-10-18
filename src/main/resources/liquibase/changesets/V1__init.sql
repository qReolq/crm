create table if not exists clients
(
    id   bigserial primary key,
    name varchar(255)
);

create table if not exists contacts
(
    id           bigserial primary key,
    contact_type varchar(255),
    value varchar(255),
    client_id bigint,
    constraint fk_contacts_clients foreign key (client_id) references clients (id) on delete cascade on update no action
);