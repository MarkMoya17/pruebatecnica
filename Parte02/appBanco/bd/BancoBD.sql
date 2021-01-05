CREATE DATABASE bancodb;

USE bancodb;

CREATE TABLE t_banco(

  idBanco int primary key auto_increment,
  nombre varchar(80),
  direccion varchar(100),
  fechaRegistro varchar(20)

);

CREATE TABLE t_sucursal(

  idSucursal int primary key auto_increment,
  nombre varchar(80),
  direccion varchar(100),
  fechaRegistro varchar(20),
  idBanco int

);

CREATE TABLE t_ordenpago(

  idOrdenPago int primary key auto_increment,
  monto decimal,
  moneda varchar(20),
  estado varchar(20),
  fechaPago varchar(20),
  idSucursal int

);