CREATE TABLE Producto(
    id INT PRIMARY KEY,
    nombre VARCHAR(100) DEFAULT '',
    cantidad INT DEFAULT 0,
    precio DECIMAL(5,2) DEFAULT 0.0
)