# Practica Calificada 2

## A)

### src/main/java/Pair.java

1. No esta dentro de un paquete nombrado
2. FirstType no cumple con la expresion regular `'^[A-Z][0-9]?$'`
3. SecondType no cumple con la expresion regular `'^[A-Z][0-9]?$'`
4. El atributo first deberia de tener primero su modificador `private` y luego su modificador `final`
5. El atributo second deberia de tener primero su modificador `private` y luego su modificador `final`

### src/main/java/Principal.java

1. No esta dentro de un paquete nombrado
2. El atributo allYearsTeachers deberia de tener primero su modificador `private` y luego su modificador `final`
3. El metodo calculateGrades tiene una complejidad cognitiva muy alta, en otras palabras, puede llegar a ser muy codigo spaguetti y puede ser reducido
4. En la condicion `!(yearToCalculate != yearlyTeachers.getKey())` se puede reemplazar la doble negacion por una igualdad
5. La condicion `teacher.second() != true` se puede reducir a `!teacher.second()`
6. La condicion `teacher.second() != true` debe demostrar un uso de los elementos primitivos de la clase Boolean `Boolean.FALSE.equals(teacher.second())`
7. El jump de la linea 43 es innecesario
8. Cambiar el System.out por el uso de un logger

### src/main/java/Student.java

1. No esta dentro de un paquete nombrado
2. El atributo _Nombre no esta siendo usado
3. _Nombre no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
4. _Tipo no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
5. _notaBase no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
6. Pregrado no cumple con la expresion regular `'^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$'`
7. Maestria no cumple con la expresion regular `'^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$'`
8. Doctorado no cumple con la expresion regular `'^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$'`
9. Grado no cumple con la expresion regular ` '^[a-z][a-zA-Z0-9]*$'`
10. Lanza una excepcion muy especifica en vez de usar una generica

### src/main/java/Teacher.java

1. No esta dentro de un paquete nombrado
2. El atributo _Nombre no esta siendo usado
3. _Nombre no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
4. _Tipo no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
5. _salarioBaseMensual no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
6. _comision no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
7. _bonus no cumple con la expresion regular `'^[a-z][a-zA-Z0-9]*$'`
8. ProfesorTP no cumple con la expresion regular `'^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$'`
9. ProfesorTC no cumple con la expresion regular `'^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$'`
10. Administrativo no cumple con la expresion regular `'^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$'`
11. Sueldo no cumple con la expresion regular ` '^[a-z][a-zA-Z0-9]*$'`
12. Lanza una excepcion muy especifica en vez de usar una generica

### src/test/java/PrincipalTest.java

1. En la linea 16 los parametros del assertEquals estan a la inversa
2. En la linea 25 los parametros del assertEquals estan a la inversa
3. En la linea 46 los parametros del assertEquals estan a la inversa
4. En la linea 59 los parametros del assertEquals estan a la inversa
5. En la linea 71 los parametros del assertEquals estan a la inversa
6. En la linea 81 los parametros del assertEquals estan a la inversa
7. En la linea 102 los parametros del assertEquals estan a la inversa
8. En la linea 112 los parametros del assertEquals estan a la inversa
9. En la linea 152 los parametros del assertEquals estan a la inversa
10. En la linea 162 los parametros del assertEquals estan a la inversa
11. En la linea 172 los parametros del assertEquals estan a la inversa

## B)
- Se corrigieron todos los code smells previamente detectados
- Se implementaros 2 enums para las constantes presentadas por Student y por Teacher
- Se implementaron 2 constructores para permitir la asignacion de el resto de atributos
- Se estandarizo el nombre de las variables y clases a el idioma ingles

## C)
- Se corrigieron todos los code smells previamente detectados
- Se renombro la clase Principal a Calculator para permitirle centrarse en la logica del sistema y se movio el metodo main a la clase App
- Ahora la insercion de datos se maneja desde la funcion main y se crearon metodos en la clase Calculator para agregar elementos a el mapa allYearsTeachers, de esta forma se puede generalizar el uso de la clase Calculator sin que el programa pierda su funcionalidad original
- Se invirtio el primer if de la funcion calculateGrades de tal forma que se reduce un nivel de indentacion a la logica principal y se evita sobrecargar el cuerpo de el if
- Se invirtio el if dentro de el primer for para reducir un nivel de indentacion el cuerpo de el for y evitar sobrecargar el cuerpo de el if
- Se empezo a utilizar la palabra clave var para inferir el tipo de las variables automaricamente y permitir tener un codigo un poco mas limpio de tipos algo complejos
- Se invirtieron el resto de ifs del final para evitar el uso innecesario de else
- Se completo el main con la instanciacion de Calculator y el agregado de los profesores

[Link del Sonar Cloud](https://sonarcloud.io/project/overview?id=UG-Software-Engineering-I-2021-2_practica-calificada-2-Anse14)