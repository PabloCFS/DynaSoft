USE DB_INT_SOFTLAND

CREATE TABLE FACTURA(
	CLIENTE VARCHAR(20) NOT NULL,
	NOMBRE_CLIENTE VARCHAR(150) NULL,
	CONSECUTIVO VARCHAR(10) NULL,
	FACTURA VARCHAR(50) PRIMARY KEY NOT NULL,
	FECHA DATETIME NOT NULL,
	MODULO VARCHAR(4) NOT NULL,
	NIVEL_PRECIO VARCHAR(12) NOT NULL,
	RUBRO1 VARCHAR(50) NULL

	--CONSTRAINT FK_CLIENTE FOREIGN KEY (CLIENTE) REFERENCES TABLA (DATO),
	--CONSTRAINT FK_NIVEL_PRECIO FOREIGN KEY (NIVEL_PRECIO) REFERENCES TABLA (DATO)
);

CREATE TABLE DOC_ELECTRONICO_PROC_DE(
	NUMERO_DOC VARCHAR(50) PRIMARY KEY NOT NULL,
	NIT_RECEPTOR VARCHAR(40) NOT NULL,
	CONTIENE_ERRORES VARCHAR(1) NULL,
	ERROR_WS VARCHAR(1) NOT NULL,
	ERROR_SOFTLAND VARCHAR(1) NOT NULL,
	ENVIADO VARCHAR(1) NOT NULL,
	TOTALGRAVADO DECIMAL(28,2) NULL,
	TOTALEXENTO DECIMAL(28,2) NULL,
	TOTALVENTA DECIMAL(28,2) NULL,
	TOTALDESCUENTOS DECIMAL(28,2) NULL,
	TOTALVENTANETA DECIMAL(28,2) NULL,
	TOTALIMPUESTO DECIMAL(28,2) NULL,
	TOTALCOMPROBANTE DECIMAL(28,2) NULL
);

CREATE TABLE DOCUMENTOS_CC(
	CLIENTE VARCHAR(20) NOT NULL,
	TIPO VARCHAR(3) NOT NULL PRIMARY KEY,
	DOCUMENTO VARCHAR(50) NOT NULL,
	CreateDate DATETIME NOT NULL,
	TIPO_ASIENTO VARCHAR(4) NULL,
	MONEDA VARCHAR(4) NOT NULL,

	--CONSTRAINT FK_CLIENTE FOREIGN KEY (CLIENTE) REFERENCES TABLA (DATO),
	--CONSTRAINT FK_TIPO FOREIGN KEY (TIPO) TABLA (DATO),
	--CONSTRAINT FK_TIP0_ASIENTO FOREIGN KEY (TIPO_ASIENTO) REFERENCES TABLA (DATO),
	--CONSTRAINT FK_MONEDO FOREIGN KEY (MONEDA) REFERENCES TABLA (DATO)
);

CREATE TABLE CLIENTE(
	CLIENTE VARCHAR(20) PRIMARY KEY NOT NULL,
	NOMBRE VARCHAR(150) NOT NULL
);

--===============================
--CONSULTAS SQL - STORE PROCEDURE
--===============================

--TRAER FACTURAS EN UN RANGO DE FECHAS

CREATE PROCEDURE SP_LISTAR_FACTURAS_DYNASOFT
	@fecha1 DATETIME,
	@fecha2 DATETIME
AS
BEGIN
	SELECT
		FACTURA.CLIENTE,
		FACTURA.NOMBRE_CLIENTE,
		FACTURA.CONSECUTIVO,
		FACTURA.FACTURA,
		FACTURA.FECHA,
		FACTURA.MODULO,
		DOC_ELECTRONICO_PROC_DE.NIT_RECEPTOR,
		DOC_ELECTRONICO_PROC_DE.CONTIENE_ERRORES,
		DOC_ELECTRONICO_PROC_DE.ERROR_WS,
		DOC_ELECTRONICO_PROC_DE.ERROR_SOFTLAND,
		DOC_ELECTRONICO_PROC_DE.ENVIADO,
		FACTURA.NIVEL_PRECIO,
		DOC_ELECTRONICO_PROC_DE.TOTALGRAVADO,
		DOC_ELECTRONICO_PROC_DE.TOTALEXENTO,
		DOC_ELECTRONICO_PROC_DE.TOTALVENTA,
		DOC_ELECTRONICO_PROC_DE.TOTALDESCUENTOS,
		DOC_ELECTRONICO_PROC_DE.TOTALVENTANETA,
		DOC_ELECTRONICO_PROC_DE.TOTALIMPUESTO,
		DOC_ELECTRONICO_PROC_DE.TOTALCOMPROBANTE,
		FACTURA.RUBRO1
	FROM FACTURA
		INNER JOIN DOC_ELECTRONICO_PROC_DE
			ON FACTURA.FACTURA = DOC_ELECTRONICO_PROC_DE.NUMERO_DOC
	WHERE FACTURA.FECHA >= @fecha1 AND FACTURA.FECHA <= @fecha2;
END

USE DB_INT_SOFTLAND

INSERT INTO FACTURA(CLIENTE,NOMBRE_CLIENTE,CONSECUTIVO,FACTURA,FECHA,MODULO,NIVEL_PRECIO,RUBRO1) VALUES('CLI0018','COOPERATIVA DE ELECTRIFICACION RURAL DE SAN CARLOS R L','DE_FA','00100001010000001588','2022-06-10 14:05:47.000','FA','ND-DOLAR','4033');

INSERT INTO DOC_ELECTRONICO_PROC_DE(NUMERO_DOC,NIT_RECEPTOR,CONTIENE_ERRORES,ERROR_WS,ERROR_SOFTLAND,ENVIADO,TOTALGRAVADO,TOTALEXENTO,TOTALVENTA,TOTALDESCUENTOS,TOTALVENTANETA,TOTALIMPUESTO,TOTALCOMPROBANTE)
	VALUES('00100001010000001588','3004045117','S','N','N','S',18773.72,0.00,18773.72,0.00,18773.72,0.00,18773.72);

EXEC SP_LISTAR_FACTURAS_DYNASOFT '2022-06-10 00:00:01.000', '2022-06-16 23:59:59.000';

--TRAER NOTAS DE CREDITO EN UN RANGO DE FECHAS
CREATE PROCEDURE SP_LISTAR_NOTAS_CREDITO_DYNASOFT
	@fecha1 DATETIME,
	@fecha2 DATETIME
AS
BEGIN
	SELECT
		DOCUMENTOS_CC.CLIENTE,
		CLIENTE.NOMBRE,
		DOCUMENTOS_CC.TIPO,
		DOCUMENTOS_CC.DOCUMENTO,
		DOCUMENTOS_CC.CreateDate,
		DOCUMENTOS_CC.TIPO_ASIENTO,
		DOC_ELECTRONICO_PROC_DE.NIT_RECEPTOR,
		DOC_ELECTRONICO_PROC_DE.CONTIENE_ERRORES,
		DOC_ELECTRONICO_PROC_DE.ERROR_WS,
		DOC_ELECTRONICO_PROC_DE.ERROR_SOFTLAND,
		DOC_ELECTRONICO_PROC_DE.ENVIADO,
		DOCUMENTOS_CC.MONEDA,
		DOC_ELECTRONICO_PROC_DE.TOTALGRAVADO,
		DOC_ELECTRONICO_PROC_DE.TOTALEXENTO,
		DOC_ELECTRONICO_PROC_DE.TOTALVENTA,
		DOC_ELECTRONICO_PROC_DE.TOTALDESCUENTOS,
		DOC_ELECTRONICO_PROC_DE.TOTALVENTANETA,
		DOC_ELECTRONICO_PROC_DE.TOTALIMPUESTO,
		DOC_ELECTRONICO_PROC_DE.TOTALCOMPROBANTE
	FROM DOCUMENTOS_CC
		INNER JOIN CLIENTE
			ON DOCUMENTOS_CC.CLIENTE = CLIENTE.CLIENTE
		INNER JOIN DOC_ELECTRONICO_PROC_DE
			ON DOCUMENTOS_CC.DOCUMENTO = DOC_ELECTRONICO_PROC_DE.NUMERO_DOC
	WHERE DOCUMENTOS_CC.TIPO LIKE 'N/C' AND DOCUMENTOS_CC.CreateDate >= @fecha1 AND DOCUMENTOS_CC.CreateDate <= @fecha2;
END

USE DB_INT_SOFTLAND
EXEC SP_LISTAR_NOTAS_CREDITO_DYNASOFT '2022-06-03 00:00:01.000', '2022-06-16 23:59:59.000';

--=====================

--=====================


DROP TABLE FACTURA;
DROP TABLE DOC_ELECTRONICO_PROC_DE;
DROP TABLE CLIENTE;