# Practica01 - Gestión de suculentas

Aplicación web MVC con Spring Boot, Thymeleaf, Bootstrap, JPA/Hibernate y MySQL.

## Requisitos
- JDK 21 instalado.
- MySQL Server en ejecución y MySQL Workbench.
- Visual Studio Code con Extension Pack for Java y Spring Boot Extension Pack.
- Maven instalado, o abrir el proyecto como proyecto Maven en VS Code y usar las herramientas de Maven.

## 1. Preparar MySQL
1. Abre MySQL Workbench y conecta con tu conexión administrativa habitual (por ejemplo, root).
2. Abre `sql/practica.sql`.
3. Ejecuta todo el script con el botón del rayo.
4. Comprueba que existen la base `practica`, la tabla `suculenta` y registros de prueba.
5. Si MySQL muestra que el usuario ya existe pero tiene otra contraseña, ejecuta como administrador:
   `ALTER USER 'usuario_practica'@'localhost' IDENTIFIED BY 'la_Clave';`
   Luego ejecuta:
   `GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'localhost';`
6. Comprueba el acceso del usuario desde MySQL Workbench si lo deseas creando una conexión nueva:
   Hostname `localhost`, port `3306`, username `usuario_practica`, password `la_Clave`.

> La contraseña `la_Clave` es la solicitada por el enunciado. Para un sistema real se debe usar una contraseña más segura.

## 2. Abrir en Visual Studio Code
1. Extrae el ZIP en una carpeta de tu elección.
2. En VS Code elige File > Open Folder y selecciona la carpeta `practica01` que contiene `pom.xml`.
3. Instala las extensiones **Extension Pack for Java** y **Spring Boot Extension Pack** si VS Code las solicita.
4. Verifica en una terminal nueva:
   `java -version`
   Debe indicar Java 21.
5. Verifica Maven con:
   `mvn -version`
   Si aparece que `mvn` no se reconoce, instala Apache Maven y agrega su carpeta `bin` al PATH de Windows, o usa la vista Maven de VS Code para importar el `pom.xml`. Cierra y vuelve a abrir VS Code después de cambiar PATH.

## 3. Ejecutar
Desde la terminal de VS Code, ubicada en la carpeta que contiene `pom.xml`, ejecuta:

`mvn spring-boot:run`

La primera ejecución necesita conexión a Internet para descargar dependencias Maven. Cuando la consola indique que Tomcat inició en el puerto 91, abre:

http://localhost:91/suculentas

La aplicación usa el usuario `usuario_practica` y la contraseña `la_Clave`, tal como pide el enunciado.

## 4. Probar el CRUD
- **Listar:** abre `/suculentas`; los registros salen de MySQL.
- **Crear:** pulsa “Registrar suculenta”, completa los campos y guarda.
- **Leer:** revisa la tarjeta de la suculenta en el catálogo.
- **Actualizar:** pulsa “Editar”, cambia un dato y guarda.
- **Eliminar:** pulsa “Eliminar” y confirma.

Las imágenes deben tener una URL pública directa. Si una URL de ejemplo deja de funcionar, reemplázala por una URL pública válida en el formulario o en MySQL.

## 5. Estructura principal
- `model/Suculenta.java`: entidad JPA.
- `repository/SuculentaRepository.java`: acceso a datos.
- `service/SuculentaService.java`: lógica de servicio.
- `controller/SuculentaController.java`: rutas y control MVC.
- `templates/fragmentos/plantilla.html`: encabezado, menú y pie reutilizables.
- `templates/suculentas/listado.html`: catálogo dinámico.
- `templates/suculentas/formulario.html`: creación y edición.
- `application.properties`: conexión, puerto y logs.
- `sql/practica.sql`: base, usuario, tabla y datos de prueba.

## 6. Configuración solicitada
- Base de datos: `practica`
- Tabla: `suculenta`
- Usuario: `usuario_practica`
- Clave: `la_Clave`
- Puerto web: `91`
- Logging: nivel `TRACE`, formato con día del mes, hora y minuto
- Hibernate: `ddl-auto=validate`; la tabla debe existir antes de ejecutar.

## 7. Si falla
- `Access denied`: verifica usuario/clave y que el usuario exista para `localhost`.
- `Communications link failure`: comprueba que MySQL Server esté encendido y escuche en el puerto 3306.
- `Port 91 was already in use`: cierra la otra aplicación que usa ese puerto.
- `Unknown database 'practica'`: ejecuta `sql/practica.sql`.
- `Table 'practica.suculenta' doesn't exist`: confirma que el script se ejecutó en la conexión correcta.
- `mvn no se reconoce`: Maven no está instalado o su `bin` no está en PATH.
- `Unsupported class file` o versión de Java: selecciona JDK 21 en VS Code y revisa `java -version`.

## 8. Entrega
Antes de comprimir:
1. Detén la aplicación.
2. No incluyas `target/`.
3. Incluye `pom.xml`, `src/`, `sql/` y `README.md`.
4. Comprime la carpeta del proyecto como `SC403_Practica01_ApellidoNombre.zip` y sustituye el nombre de ejemplo por tus datos.
5. Ejecuta de nuevo la aplicación y prueba las cuatro operaciones antes de entregar.
