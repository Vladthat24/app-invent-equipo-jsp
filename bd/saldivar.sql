create database BD_SALDIVAR;

use BD_SALDIVAR;

create table marca
(
	idmarca int primary key auto_increment,
	codigo varchar(11) not null,
	descripcion varchar(255) not null
);


create table pais(
	idpais int primary key auto_increment,
	codigo varchar(11) not null,
	nombre varchar(45) not null
)


create table equipo(
	idequipo int primary key auto_increment,
	idpais int not null,
	idmarca int not null,
	nombre varchar(45) not null,
	descripcion varchar(255) not null,
	estado varchar(45) not null
)

alter table equipo add constraint fk_equipo_pais foreign key (idpais) references pais(idpais);
alter table equipo add constraint fk_equipo_marca foreign key (idmarca) references marca(idmarca);


insert into marca (codigo,descripcion) values('M001','LG');
insert into pais (codigo,nombre) values('L001','Perú');
insert into equipo (idpais,idmarca,nombre,descripcion,estado) values (1,1,'Monitor','Monitor Curvo de 29 pulgadas','Operativo');

select e.idequipo, p.codigo as cod_pais ,p.nombre as nom_pais,
m.codigo as cod_marca,m.descripcion as descp_marca,
e.nombre as nom_equio, e.descripcion as descp_equipo,
e.estado as estado_equipo
from equipo e 
inner join pais p on e.idpais =p.idpais
inner join marca m on e.idmarca =m.idmarca 



