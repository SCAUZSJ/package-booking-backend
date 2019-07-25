CREATE TABLE package(
    id VARCHAR not null,
    owner VARCHAR(20) not null ,
    phone varchar(20) not null,
    status varchar(10) not null,
    ap_time timestamp,
    primary key(id)
);