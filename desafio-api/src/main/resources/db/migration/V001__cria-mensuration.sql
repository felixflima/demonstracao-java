create table mensuration
(
 id bigint not null auto_increment,
 mensuration_date datetime not null,
 mensuration_max_value decimal(6,3) not null,
 mensuration_min_value decimal(6,3) not null,
 mensuration_place varchar(60) not null,
 primary key (id)
);

