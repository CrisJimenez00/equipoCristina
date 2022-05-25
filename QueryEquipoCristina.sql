-- Cristina Jiménez
drop database equipo;
create database if not exists equipo;
use equipo;

create table if not exists entrenador(
    codentrenador int auto_increment,
    dni char(12) ,
    nombre varchar(50) ,
    ape1 varchar(50) ,
    ape2 varchar(50) ,
    constraint pk_entrenador primary key (codentrenador)
);


create table if not exists equipo(
	codequipo int auto_increment,
    nombre varchar(50),
    direcsede varchar(100) ,
    fondos decimal,
    codentrenador int,
    constraint pk_equipo primary key (codequipo),
    constraint fk_codentrenador foreign key (codentrenador) references entrenador(codentrenador)
    on delete set null on update no action
    
);

create table if not exists jugador(
	codjugador int auto_increment,
    dni char(12) ,
    nombre varchar(50),
    ape1 varchar(50) ,
    ape2 varchar(50) ,
    codequipo int,
    constraint pk_codjugador primary key (codjugador),
    constraint fk_codequipo foreign key (codequipo) references equipo(codequipo)
    on delete set null on update no action
);

INSERT INTO `equipo`.`entrenador` (`codentrenador`, `dni`, `nombre`, `ape1`, `ape2`) VALUES ('1', '79297715V', 'Mohamed', 'Mota', 'Cifuentes');
INSERT INTO `equipo`.`entrenador` (`codentrenador`, `dni`, `nombre`, `ape1`, `ape2`) VALUES ('2', '67232956T', 'Maria', 'Barea', 'Guevara');
INSERT INTO `equipo`.`entrenador` (`codentrenador`, `dni`, `nombre`, `ape1`, `ape2`) VALUES ('3', '23977487X', 'Kevin', 'Mateos', 'Sanz');
INSERT INTO `equipo`.`entrenador` (`codentrenador`, `dni`, `nombre`, `ape1`, `ape2`) VALUES ('4', '11527656X', 'Ariana', 'Prada', 'Vallejo');

select * from entrenador;

INSERT INTO `equipo`.`equipo` (`codequipo`, `nombre`, `direcsede`, `fondos`, `codentrenador`) VALUES ('1234', 'Estepona', 'Calle Inventada nº1', '2000000', '1');
INSERT INTO `equipo`.`equipo` (`codequipo`, `nombre`, `direcsede`, `fondos`, `codentrenador`) VALUES ('1233', 'Esteponense', 'Calle Inevntada nº2', '2000254', '3');
INSERT INTO `equipo`.`equipo` (`codequipo`, `nombre`, `direcsede`, `fondos`, `codentrenador`) VALUES ('1232', 'Marbella', 'Avenida Sin originalidad nº1', '321456', '2');
INSERT INTO `equipo`.`equipo` (`codequipo`, `nombre`, `direcsede`, `fondos`, `codentrenador`) VALUES ('1231', 'Pablo Picaso', 'Calle nose donde nº45', '2145778', '4');

select * from equipo;

INSERT INTO `equipo`.`jugador` (`codjugador`, `dni`, `nombre`, `ape1`, `ape2`, `codequipo`)
VALUES ('1112', '97771686C', 'Siham', 'Capdevila', 'Sampedro', '1234'),
('1113', '68508954G', 'Jonatan', 'Ayala', 'Zheng', '1233'),
('1114', '37675206X', 'Ramiro', 'Molinero', 'Lago', '1231'),
('1115', '15905854C', 'Angel', 'del Castillo', 'Moran', '1232');

select * from jugador;



select * from entrenador;
select * from equipo;
select * from jugador;