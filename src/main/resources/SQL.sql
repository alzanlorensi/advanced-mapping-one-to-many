#Create a schema called advanced-mapping
create table instructor_detail_one_to_many (
                                               id SERIAL primary key not null,
                                               job varchar(128) default null,
                                               hobby varchar(45) default null
)

create table instructor_one_to_many(
                                       id SERIAL primary key not null,
                                       first_name varchar(45) default null,
                                       last_name varchar(45) default null,
                                       email varchar(45) default null,
                                       instructor_detail_one_to_many_fk INT default null,
                                       constraint instructor_fk foreign key (instructor_detail_one_to_many_fk) references instructor_detail_one_to_many(id)

)

create table course (
                        id SERIAL primary key not null,
                        title varchar(128) default null,
                        instructor_id_fk INT default null,
                        constraint instructor_fk foreign key (instructor_id_fk ) references instructor_one_to_many(id)
)