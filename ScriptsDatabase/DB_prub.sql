CREATE DATABASE DB_INT_SOFTLAND;

USE DB_INT_SOFTLAND;

CREATE TABLE USUARIOS(
	nombre varchar(30),
	clave varchar(10)
);

EXEC SP_COLUMNS USUARIOS;

DROP TABLE USUARIOS;

INSERT INTO USUARIOS(nombre,clave) VALUES('Pablo','123');
INSERT INTO USUARIOS(nombre,clave) VALUES('Ana','1234');
INSERT INTO USUARIOS(nombre,clave) VALUES('Juan','456');
INSERT INTO USUARIOS(nombre,clave) VALUES('Pedro','457');

SELECT * FROM USUARIOS;



------------------------Procedimientos alamacenados
USE DB_INT_SOFTLAND;
------------------------INSERTAR USUARIOS
CREATE PROCEDURE SP_INSERTAR_USUARIO
	@nombre varchar(30),
	@clave varchar(10)
AS
BEGIN
	INSERT INTO Usuarios (nombre,clave)
	VALUES(@nombre,@clave)
END

EXEC SP_INSERTAR_USUARIO Maria, 998




------------------------ELIMINAR USUARIOS
CREATE PROCEDURE SP_ELIMINAR_USUARIO
	@nombre varchar(50)
AS
BEGIN
	DELETE FROM USUARIOS WHERE nombre = @nombre
END
GO

EXEC SP_ELIMINAR_USUARIO Juan

------------------------TRAER TODOS LOS USUARIOS
CREATE PROCEDURE LISTAR_USUARIOS
AS
BEGIN
SELECT * FROM USUARIOS;
END

EXEC LISTAR_USUARIOS


------------------------TRAER UN USUARIO
CREATE PROCEDURE SP_CONSULTAR_UN_USUARIO
	@nombre varchar(50)
AS
BEGIN
	SELECT * FROM USUARIOS WHERE nombre = @nombre;
END

EXEC SP_CONSULTAR_UN_USUARIO Pedro

------------------------ACTUALIZAR USUARIO
CREATE PROCEDURE SP_ACTUALIZAR_USUARIO
	@nombre varchar(50),
	@clave varchar(50)
AS
BEGIN
	UPDATE USUARIOS
	SET nombre = @nombre,
		clave = @clave
	WHERE nombre = @nombre
END

EXEC SP_ACTUALIZAR_USUARIO Pablo, 876

SELECT * FROM USUARIOS;