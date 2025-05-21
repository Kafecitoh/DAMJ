-- Añadir columna para guardar la fecha en la que empieza el director. Debe ser una fecha válida y no futura.

USE EMPRESANEW2021

IF EXISTS (
SELECT * FROM sys.columns
WHERE Name = N'fechaDireccion' AND Object_ID = Object_ID(N'DEPARTAMENTO')
)
BEGIN
ALTER TABLE DEPARTAMENTO DROP CONSTRAINT CK_fechaDirección
ALTER TABLE DEPARTAMENTO DROP COLUMN fechaDireccion
END
GO

ALTER TABLE DEPARTAMENTO
ADD fechaDireccion DATE NULL
CONSTRAINT CK_fechaDirección -CHECK (fechaDireccion <= GETDATE())
GO

-- Función auxiliar para calcular años entre dos fechas aproximados
IF OBJECT_ID('fnCalcularAntiguedad') IS NOT NULL
DROP FUNCTION fnCalcularAntiguedad
GO

CREATE FUNCTION fnCalcularAntiguedad(@inicio DATE, @fin DATE)
RETURNS INT
AS
BEGIN
RETURN DATEDIFF(DAY, @inicio, @fin) / 365
END
GO

-- Procedimiento para asignar o actualizar el director de un departamento
IF OBJECT_ID('prAsignarDirector') IS NOT NULL
DROP PROCEDURE prAsignarDirector
GO

CREATE PROCEDURE prAsignarDirector
@nombreDpto VARCHAR(25),
@nssDirector VARCHAR(15) = NULL,
@fechaInicio DATE = NULL,
@mensaje VARCHAR(200) OUTPUT,
@antiguedad INT OUTPUT
AS
BEGIN
DECLARE @idDpto INT, @nssActual VARCHAR(15), @fechaActual DATE, @nombreCompleto VARCHAR(100)

SELECT @idDpto = NumDepartamento,
@nssActual = NSSDirector,
@fechaActual = fechaDireccion
FROM DEPARTAMENTO
WHERE NomeDepartamento = @nombreDpto

IF @idDpto IS NULL
RETURN -1

-- Si no se indica nuevo director
IF @nssDirector IS NULL
BEGIN
SET @fechaInicio = DATEADD(MONTH, -2, GETDATE())

UPDATE DEPARTAMENTO
SET fechaDireccion = @fechaInicio
WHERE NumDepartamento = @idDpto

SELECT @nombreCompleto = Nome + ' ' + Apelido1 + ' ' + ISNULL(Apelido2, '')
FROM EMPREGADO
WHERE NSS = @nssActual

SET @antiguedad = dbo.fnCalcularAntiguedad(@fechaInicio, GETDATE())

SET @mensaje = 'Director actual de ' + @nombreDpto + ' es ' + @nombreCompleto +
', desde el ' + CONVERT(VARCHAR, @fechaInicio, 103)

RETURN 0
END

-- Validaciones
IF NOT EXISTS (SELECT 1 FROM EMPREGADO WHERE NSS = @nssDirector)
RETURN -2

IF NOT EXISTS (SELECT 1 FROM EMPREGADO WHERE NSS = @nssDirector AND NumDepartamentoPertenece = @idDpto)
RETURN -3

IF NOT EXISTS (SELECT 1 FROM EMPREGADOFIXO WHERE NSS = @nssDirector)
RETURN -4

IF @fechaInicio IS NULL OR @fechaInicio > GETDATE()
SET @fechaInicio = DATEADD(MONTH, -2, GETDATE())

UPDATE DEPARTAMENTO
SET NSSDirector = @nssDirector,
fechaDireccion = @fechaInicio
WHERE NumDepartamento = @idDpto

SELECT @nombreCompleto = Nome + ' ' + Apelido1 + ' ' + ISNULL(Apelido2, '')
FROM EMPREGADO
WHERE NSS = @nssDirector

SET @antiguedad = dbo.fnCalcularAntiguedad(@fechaInicio, GETDATE())

SET @mensaje = 'Nuevo director en ' + @nombreDpto + ': ' + @nombreCompleto +
', desde el ' + CONVERT(VARCHAR, @fechaInicio, 103)

RETURN 0
END
GO

-- Procedimiento para mostrar mensajes de asignación
IF OBJECT_ID('prMostrarMensajeDirector') IS NOT NULL
DROP PROCEDURE prMostrarMensajeDirector
GO




EXEC @codigo = prAsignarDirector @nombreDpto, @directorNSS, @fechaInicio, @msg OUTPUT, @anos OUTPUT




-- Procedimiento que recorre departamentos y asigna fechas en orden creciente
IF OBJECT_ID('prActualizarFechasDirecciones') IS NOT NULL
DROP PROCEDURE prActualizarFechasDirecciones
GO

CREATE PROCEDURE prActualizarFechasDirecciones
@fechaBase DATE
AS
BEGIN
DECLARE @nombreDpto VARCHAR(25),
@mensaje VARCHAR(200),
@anos INT,
@codigo INT,
@fechaActual DATE = @fechaBase

DECLARE curDeptos CURSOR FOR
SELECT NomeDepartamento FROM DEPARTAMENTO ORDER BY NomeDepartamento

OPEN curDeptos
FETCH NEXT FROM curDeptos INTO @nombreDpto

WHILE Undetermined error: @@FETCH_STATUS = 0
BEGIN
EXEC @codigo = prAsignarDirector
@nombreDpto = @nombreDpto,
@nssDirector = NULL,
@fechaInicio = @fechaActual,
@mensaje = @mensaje OUTPUT,
@antiguedad = @anos OUTPUT

IF @codigo = 0
PRINT @mensaje + ' (Hace ' + CAST(@anos AS VARCHAR) + ' años)'
ELSE
PRINT 'Error en ' + @nombreDpto + ' -> Código: ' + CAST(@codigo AS VARCHAR)

SET @fechaActual = DATEADD(DAY, 45, @fechaActual)
FETCH NEXT FROM curDeptos INTO @nombreDpto
END

CLOSE curDeptos
DEALLOCATE curDeptos
END
GO

-- Función que muestra empleados y los proyectos en los que trabajan
IF OBJECT_ID('fnListadoProyectosEmpleados') IS NOT NULL
DROP FUNCTION fnListadoProyectosEmpleados
GO

CREATE FUNCTION fnListadoProyectosEmpleados()
RETURNS @resultado TABLE (
nombreCompleto VARCHAR(100),
proyectosHoras VARCHAR(MAX)
)
AS
BEGIN
DECLARE @nss VARCHAR(15), @nombre VARCHAR(100), @proyectos VARCHAR(MAX)
DECLARE @proyecto VARCHAR(50), @horas INT

DECLARE c_emp CURSOR STATIC FOR
SELECT NSS, Nome + ' ' + Apelido1 + ' ' + ISNULL(Apelido2, '') FROM EMPREGADO

OPEN c_emp
FETCH NEXT FROM c_emp INTO @nss, @nombre

WHILE @@FETCH_STATUS = 0
BEGIN
SET @proyectos = ''

DECLARE c_proj CURSOR STATIC FOR
SELECT P.NomeProxecto, EP.Horas
FROM EMPREGADO_PROXECTO EP JOIN PROXECTO P ON EP.NumProxecto = P.NumProxecto
WHERE EP.NSSEmpregado = @nss

OPEN c_proj
FETCH NEXT FROM c_proj INTO @proyecto, @horas

WHILE @@FETCH_STATUS = 0
BEGIN
SET @proyectos = @proyectos + @proyecto + ' (' + CAST(@horas AS VARCHAR) + 'h); '
FETCH NEXT FROM c_proj INTO @proyecto, @horas
END

CLOSE c_proj
DEALLOCATE c_proj

IF LEN(@proyectos) > 0
INSERT INTO @resultado VALUES (@nombre, LEFT(@proyectos, LEN(@proyectos) - 2))

FETCH NEXT FROM c_emp INTO @nss, @nombre
END

CLOSE c_emp
DEALLOCATE c_emp

RETURN
END
GO

-- Consulta final
SELECT * FROM dbo.fnListadoProyectosEm