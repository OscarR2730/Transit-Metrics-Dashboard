CREATE DATABASE BD_SeguridadVial;
GO
USE BD_SeguridadVial;
GO

CREATE TABLE TB_UBICACION_VIA (
    id_ubicacion INT IDENTITY(1,1) PRIMARY KEY,
    codigo_via VARCHAR(20) NOT NULL,
    departamento VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    kilometro DECIMAL(6,2) NULL
);

CREATE TABLE ReportesAccidentes (
    NRO_REPORTE VARCHAR(30) PRIMARY KEY,
    id_ubicacion INT FOREIGN KEY REFERENCES TB_UBICACION_VIA(id_ubicacion),
    FECHA_ACC DATE NOT NULL,
    MODALIDAD_ACC VARCHAR(50) NULL,
    CANT_FALLECIDOS INT DEFAULT 0,
    CANT_HERIDOS INT DEFAULT 0,
    DEPARTAMENTO VARCHAR(50),
    CODIGO_VIA VARCHAR(20)
);

GO
CREATE PROCEDURE sp_ConsultarAccidentesFiltro
    @Departamento VARCHAR(50),
    @Anio INT
AS
BEGIN
    SET NOCOUNT ON;
    SELECT 
        NRO_REPORTE AS [N° Reporte],
        FECHA_ACC AS [Fecha],
        CODIGO_VIA AS [Vía],
        DEPARTAMENTO AS [Departamento],
        MODALIDAD_ACC AS [Modalidad],
        CANT_FALLECIDOS AS [Fallecidos],
        CANT_HERIDOS AS [Heridos]
    FROM ReportesAccidentes
    WHERE DEPARTAMENTO = @Departamento AND YEAR(FECHA_ACC) = @Anio;
END;
GO
