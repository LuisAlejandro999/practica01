-- Práctica Individual 01: catálogo de suculentas
-- Ejecutar en MySQL Workbench con un usuario que tenga permisos para crear bases de datos y usuarios.

CREATE DATABASE IF NOT EXISTS practica
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'usuario_practica'@'localhost' IDENTIFIED BY 'la_Clave';
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'localhost';
FLUSH PRIVILEGES;

USE practica;

CREATE TABLE IF NOT EXISTS suculenta (
    id_suculenta INT NOT NULL AUTO_INCREMENT,
    nombre_comun VARCHAR(100) NOT NULL,
    nombre_cientifico VARCHAR(150) NOT NULL,
    familia VARCHAR(100) NOT NULL,
    color_principal VARCHAR(50) NOT NULL,
    altura_cm INT NOT NULL,
    precio_estimado DECIMAL(10,2) NOT NULL,
    nivel_riego VARCHAR(30) NOT NULL,
    ruta_imagen VARCHAR(500) NOT NULL,
    PRIMARY KEY (id_suculenta)
);

INSERT INTO suculenta
(nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen)
SELECT 'Rosa de alabastro', 'Echeveria elegans', 'Crassulaceae', 'Verde azulado', 15, 3500.00, 'Bajo',
'https://images.unsplash.com/photo-1509423350716-97f9360b4e09?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM suculenta WHERE nombre_cientifico = 'Echeveria elegans');

INSERT INTO suculenta
(nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen)
SELECT 'Planta de jade', 'Crassula ovata', 'Crassulaceae', 'Verde', 30, 5000.00, 'Bajo',
'https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM suculenta WHERE nombre_cientifico = 'Crassula ovata');

INSERT INTO suculenta
(nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen)
SELECT 'Siempreviva', 'Sempervivum tectorum', 'Crassulaceae', 'Verde y rojizo', 10, 2800.00, 'Moderado',
'https://images.unsplash.com/photo-1497250681960-ef046c08a56e?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM suculenta WHERE nombre_cientifico = 'Sempervivum tectorum');

SELECT * FROM suculenta;
