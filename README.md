# Pokédex TCG Pocket 🎴

Un sistema completo de gestión de cartas Pokémon con múltiples interfaces: consola, interfaz gráfica y aplicación web.

## 📋 Descripción

Este proyecto implementa un sistema CRUD (Create, Read, Update, Delete) para gestionar cartas del Trading Card Game de Pokémon. Incluye tres interfaces diferentes:

- **Aplicación de consola** (Java) - Interfaz de línea de comandos completa
- **Interfaz gráfica** (Java Swing) - GUI de escritorio para consultas
- **Aplicación web** (Node.js + Express) - Formulario web para añadir cartas

## 🛠️ Tecnologías Utilizadas

### Backend Java
- **Java 23**
- **Maven** para gestión de dependencias
- **MySQL Connector** 8.0.30
- **Swing** para interfaz gráfica

### Backend Node.js
- **Node.js**
- **Express.js** 5.1.0
- **MySQL2** 3.14.1
- **CORS** para conexiones cross-origin
- **Body-parser** para manejo de JSON

### Base de Datos
- **MySQL** con base de datos `pokemon_tcg_pocket`

## 📊 Estructura de la Base de Datos

```sql
CREATE TABLE cartas (
    id_carta INT PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50),
    sub_tipo VARCHAR(50),
    rareza VARCHAR(50),
    expansion_poke VARCHAR(100)
);
```

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 23 o superior
- Node.js 18 o superior
- MySQL Server
- Maven

### 1. Configuración de Base de Datos

```sql
-- Crear base de datos
CREATE DATABASE pokemon_tcg_pocket;

-- Usar la base de datos
USE pokemon_tcg_pocket;

-- Crear tabla cartas
CREATE TABLE cartas (
    id_carta INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50),
    sub_tipo VARCHAR(50),
    rareza VARCHAR(50),
    expansion_poke VARCHAR(100)
);
```

### 2. Configuración del Proyecto Java

```bash
# Clonar el repositorio
cd JavaBDFinal

# Compilar con Maven
mvn clean compile

# Ejecutar aplicación de consola
java -cp target/classes Principal

# Ejecutar interfaz gráfica
java -cp target/classes PokedexGUI
```

### 3. Configuración del Proyecto Node.js

```bash
# Navegar al directorio del proyecto web
cd mi-proyecto-cartas

# Instalar dependencias
npm install

# Iniciar servidor
node index.js
```

La aplicación web estará disponible en `http://localhost:3000`

## 🎮 Funcionalidades

### Aplicación de Consola (Principal.java)
1. **Visualizar todas las cartas** - Muestra el catálogo completo
2. **Buscar carta por ID** - Consulta una carta específica
3. **Filtrar cartas** - Por tipo, subtipo o rareza
4. **Añadir nueva carta** - Insertar cartas al sistema
5. **Eliminar carta** - Borrar carta por ID
6. **Actualizar carta** - Modificar información existente

### Interfaz Gráfica (PokedexGUI.java)
- **Vista de todas las cartas** - Listado completo en área de texto
- **Búsqueda por ID** - Campo de entrada y visualización de resultados
- **Interfaz intuitiva** - Botones y scroll para mejor experiencia

### Aplicación Web
- **Formulario de alta de cartas** - Interface web estilizada
- **Diseño responsive** - Adaptable a diferentes pantallas
- **Validación de campos** - Campos requeridos y tipos de datos
- **Estilo Pokémon** - Tema visual inspirado en la franquicia

## 📁 Estructura del Proyecto

```
├── JavaBDFinal/
│   ├── src/main/java/
│   │   ├── Principal.java          # Aplicación de consola
│   │   ├── Pokedex.java           # Lógica de base de datos
│   │   └── PokedexGUI.java        # Interfaz gráfica
│   ├── pom.xml                    # Configuración Maven
│   └── .gitignore
│
├── mi-proyecto-cartas/
│   ├── db.js                      # Configuración MySQL
│   ├── index.js                   # Servidor Express
│   ├── package.json               # Dependencias Node.js
│   └── public/
│       └── index.html             # Frontend web
```

## ⚙️ Configuración de Conexión

### Java (Pokedex.java)
```java
final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
final String USER = "root";
final String PASSWORD = "1234";
```

### Node.js (db.js)
```javascript
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '1234',
  database: 'pokemon_tcg_pocket'
});
```

## 🔧 Personalización

Para adaptar el proyecto a tu entorno:

1. **Cambiar credenciales de BD** - Modificar en `Pokedex.java` y `db.js`
2. **Añadir campos** - Extender tabla y clases correspondientes
3. **Modificar estilos** - Personalizar CSS en `index.html`
4. **Ampliar funcionalidades** - Añadir nuevos endpoints o métodos

## 📝 Notas de Desarrollo

- **Prepared Statements** utilizados para prevenir inyección SQL
- **Manejo de excepciones** implementado en todas las operaciones
- **Patrón DAO** aplicado en la clase Pokedex
- **Validación de entrada** en interfaces de usuario
- **Diseño responsivo** en aplicación web

## 🐛 Solución de Problemas

### Error de Conexión MySQL
- Verificar que MySQL esté ejecutándose
- Comprobar credenciales de acceso
- Confirmar que la base de datos existe

### Problemas de Compilación Java
- Verificar versión de Java (requiere 23+)
- Ejecutar `mvn clean install`

### Error en Aplicación Web
- Verificar que Node.js esté instalado
- Ejecutar `npm install` para dependencias
- Comprobar puerto 3000 disponible

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork del proyecto
2. Crear rama feature (`git checkout -b feature/AmazingFeature`)
3. Commit de cambios (`git commit -m 'Add: AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir Pull Request

---

**Desarrollado con ❤️ para la comunidad Pokémon**
