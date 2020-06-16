# demoweb-springboot-apirest
A simple example for handling api-rest with SpringBoot
# Ejecución
1. Abrir en el explorador de archivos un directorio por ejemplo C:\Users\usuario\Documents\Spring Tool Suite Projects
2. Abrir una ventana de comandos git en ese directorio y ejecutar el comando: 
   git clone https://github.com/saaiidmoran/demoweb-springboot-apirest
   Creará una carpeta llamada "demoweb-springboot-apirest"
3. Abrir el IDE STS4
4. Cuando haya cargado por completo ir a la opción file, luego en import, buscar la opción maven y dar doble click, seleccionar la opción
   Existing Maven Proyects y despues click en Next
5. En root directory dar click en la opción que dice browse e ir a la ruta: 
   C:\Users\usuario\Documents\Spring Tool Suite Projects
6. Seleccionar la carpeta del proyecto y click en seleccionar carpeta
7. Identificará el archivo pom.xml del proyecto (debe estar palomeado)
8. Click en finish
9. Abrir la linea de comando de MySQL y loguearse
10. Ejecutar el comando create schema demo
11. En STS4 buscar el archivo application.properties ubicado en src/main/resources
12. Modificar la linea spring.datasource.password=password poniendo la contraseña propia de MySQL
13. Guardar las modificaciones, para guardar en STS4 se puede hacer presionando ctrl + s
14. Dar click en el icono verde con el símbolo de > ubicado, aparecerá un recuadro que dice Run as...
15. Seleccionar la opción que dice Spring Boot App y click en OK
16. Si se hizo todo correctamente se ejecutará sin problemas
