-- liquibase formatted sql

-- changeset JTibaduisa:1

create table tipos_listas(
	id int(11) primary key auto_increment not null,
    tipo_lista_id int(11) null comment "ID referencia de la misma tabla - recursiva",
    nombre varchar(255) not null,
    decsripcion text null,
    activo tinyint(1) not null default 1
);

create table listas_elementos(
	id int(11) primary key auto_increment not null,
    lista_elemento_id int(11) null comment "ID referencia de la misma tabla - recursiva",
    nombre varchar(255) not null,
    decsripcion text null,
    tipo_lista_id int(11) not null,
    activo tinyint(1) not null default 1
);

create table personas(
	id int(11) primary key auto_increment not null,
    nombre1 varchar(100) not null,
    nombre2 varchar(100) null,
    apellido1 varchar(100) not null,
    apellido2 varchar(100) null,
    fecha_registro date not null
);

create table autores (
	id int(11) primary key auto_increment not null,
    persona_id int(11) not null,
    activo tinyint(1) not null default 1
);

create table editoriales (
	id int primary key auto_increment not null,
    nombre varchar(150) not null,
    activo tinyint(1) not null default 1
);

create table categoria_libros (
	id int(11) primary key auto_increment not null,
    nombre varchar(100) not null,
    descripcion text not null,
    activo tinyint(1) not null default 1
);

create table libros (
	id int(11) primary key auto_increment not null,
    isbn varchar(150) not null,
    titulo varchar(150) not null,
    subtitulo varchar(150) null,
    descripcion text,
    num_paginas int(11) not null,
    anio_publicacion year not null,
    categoria_libro_id int(11) null,
    editorial_id int(11) not null,
    autor_id int(11) not null,
    activo tinyint(1) not null default 1
);

create table ejemplares (
	id int(11) primary key auto_increment not null,
    libro_id int(11) not null  comment "Referencia del libro",
    codigo_ejemplar varchar(100) not null,
    estado_ejemplar_id int(11) not null comment "estado de tipo de lista estado ejemplar"
);


-- changeset JTibaduisa:2

## Relaciones tabla tipo listas
alter table tipos_listas 
add constraint fk1_tipos_listas foreign key (tipo_lista_id) references tipos_listas (id);

## relaciones tabla listas elementos
alter table listas_elementos 
add constraint fk1_listas_elementos foreign key (lista_elemento_id) references listas_elementos (id),
add constraint fk2_listas_elementos foreign key (tipo_lista_id) references tipos_listas (id);

## relaciones tabla autores
alter table autores 
add constraint fk1_autores foreign key (persona_id) references personas (id);

## relaciones tabla libros
alter table libros 
add constraint fk1_libros foreign key (categoria_libro_id) references categoria_libros (id),
add constraint fk2_libros foreign key (editorial_id) references editoriales (id),
add constraint fk3_libros foreign key (autor_id) references autores (id);

## Relaciones tabla ejemplar
alter table ejemplares 
add constraint fk1_ejemplares foreign key (estado_ejemplar_id) references listas_elementos (id),
add constraint fk2_ejemplares foreign key (libro_id) references libros (id);

-- changeset Jorge:3
create table usuario(
	id int(11) primary key auto_increment,
    documento varchar(10) not null,
    persona_id int(11) not null
);

-- changeset Jorge:4
alter table usuario
add constraint fk1_usuario foreign key (persona_id) references personas (id);

-- changeset Jorge:5
alter table usuario
add column clave varchar(30) after documento;

-- changeset Pepo:6
alter table tipos_listas 
RENAME COLUMN decsripcion TO descripcion;