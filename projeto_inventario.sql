CREATE DATABASE projeto_inventario;

CREATE TABLE projeto_inventario.produto(
id int primary key auto_increment,
nome varchar(45) not null,
quantidade int not null
)