# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2022/23)
Autor/a: David Chaves Cumbreras   uvus:JFH0630

El objetivo de este dataset es analizar y recoger los datos de varias partidas del videojuego League of Legends en el año 2020 y se han realizado algunas
modificaciones mediante la pagina web https://mockaroo.com para crear datos aleatorios y la propia función ALEATORIO de excel. El dataset original ha sido descargado 
de kaggle (https://www.kaggle.com/datasets/benfattori/league-of-legends-diamond-games-first-15-minutes). Originalmente el dataset contaba con 19 columnas y 46000 filas 
de las cuales se han hecho algunos ajustes para hacer el csv mas sencillo y mas claro, debido a la cantidad de datos que tenia el csv. Actualmente se ha creado una 
version simplificada y otra extendida del csv, pero se va a emplear de momento la version simplificada la cual cuenta con 20 filas y 21 columnas(5 de ellas pertenecen 
a un tipo auxiliar de tipo Player). Se han eliminado columnas del csv original como blueDragonKills y red o blueTowersDestroyed y red. Otras columnas se han fusionado 
como blueJungleMinionskilled y red en la columna blueMinionsKilled y red. El proyecto consta de de una gran variedad de 
tipos(String,Double,Integer,List,Player(auxiliar),Enum y Boolean). El objetivo de este dataset es tratar de predecir el transcurso de una partida sabiendo unicamente 
las estadisticas de los primeros 15 minutos de partida.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.partida>**: Paquete que contiene los tipos del proyecto.
  * **fp.partida.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **MatchTimelinesFirst15**: Datos sacados de 1000 partidas de un videojuego en el año 2020(incompleto para el test) .
    * **MatchTimelinesFirst15(simplificado)**: Datos sacados de 20 partidas de un videojuego en el año 2020 y columnas acorde a los archivos de src.
    
## Estructura del *dataset*

El Formato del fichero esta compuesto por una Cabecera con los nombres de campos en primera linea, en el resto de lineas estan los datos de las partidas.

Antes de explicar cada tipo voy a especificar algunos terminos que pueden ser algo confusos sin 
una previa explicación:

* **Partida**: Cada juego suele durar entre 20 o 30 minutos, pero el objetivo de este dataset es tratar de ver y analizar el transcurso de una partida con unicamente datos de los primeros 15 minutos de juego. El unico dato que no corresponde a estos primeros 15 minutos de partida es el del equipo ganador mediante el tipo de dato 
blue_win.

* **Equipos**: En una partida hay dos equipos uno rojo y otro azul habiendo 5 jugadores por equipo.

* **Oro**: Representa la cantidad oro obtenido por parte de un jugador, este recurso es empleado para comprar mejoras durante la partida.
Hay varios factores que intervienen en el transcurso de una partida, pero por normal general el equipo con mas oro (la suma del oro de los 5 miembros de un equipo) es 
el que suele ganar o el que tiene mas posibilidades de ganar, por tanto mediante este dato podemos tratar de predecir el equipo ganador en una partida.

* **Champs(Campeones): Son los personajes jugables que tiene cada jugador y se les llama campeones, en el juego original hay un total de 162 personajes.

* **Minions**: Es una de las fuentes principales de obtener oro, cada vez que matas uno te da una cantidad de oro.

* **Monster**: Junto al oro, los monstruos es una de las fuentes mediante la cual se puede tratar de predecir el equipo ganador de una partida. En los primeros 15
minutos solo se pueden matar 3 monstruos en total(la suma de los monstruos de cada equipo tiene que ser menor o igual que tres).

* **Nivel**: A lo largo de la partida vas subiendo de nivel comenzando por el nivel 1 y teniendo como maximo nivel 18.

* **Asistencia**:El termino de asistencia se refiere a que has ayudado a matar a un enemigo pero tu compañero es el que le ha dado el ultimo golpe para matarlo.

El dataset MatchTimelinesFirst15(simplificado) está compuesto por 21 columnas, con la siguiente descripción:

* **matchId**: de tipo Long, representa un numero identificativo de la partida de 10 digitos.
* **blue_win**: de tipo Boolean, devuelve true si ganó el equipo azul, y devuelve false si ganó el equipo rojo.
* **blueGold**: de tipo Integer>,representa  la suma de oro de las 5 personas del equipo azul.
* **blueChampKills**: de tipo Integer>, representa la suma de los enemigos rojos matados por parte del equipo azul.
* **blueMinionsKilled**: de tipo Integer, representa la suma de los minions matados por parte del equipo azul.
* **blueMonsterKills**: de tipo Integer, representa la suma de los monstruos matados por parte del equipo azul.
* **blueAvgLevel**: de tipo Double, representa la media de nivel del equipo azul.
* **redGold**: de tipo Integer, representa la suma de oro de las 5 personas del equipo rojo.
* **redChampKills**: de tipo Integer, representa la suma de los enemigos azules matados por parte del equipo rojo.
* **redMinionsKilled**: de tipo Integer, representa la suma de los minions matados por parte del equipo rojo.
* **redMonsterKills**: de tipo Integer, representa la suma de los monstruos matados por parte del equipo rojo.
* **redAvgLevel**: de tipo Double, representa la media de nivel del equipo rojo.
* **datematch**: de tipo LocalDate>, representa el dia en el que tiene lugar la partida.
* **server**: de tipo String,representa el servidor en el que tiene lugar la partida puede ser tanto un pais, una region o un continente.
* **rango**: de tipo Rango, representa la categoria de la partida pudiendo ser esta 	DIAMANTE_IV,DIAMANTE_III,DIAMANTE_II o DIAMANTE_I.


* Los siguientes 5 tipos pertenecen al tipo auxiliar Player:

    * **bestplayer**: de tipo String, el nombre de usuario del mejor jugador de la partida.
    * **enemiesKilled**: de tipo Integer>, representa el numero de enemigos matados por parte del jugador
    * **deads**: de tipo Integer, representa las muertes del jugador.
    * **assists**: de tipo Integer, representa el numero de asistencia del jugadores
    * **team**: de tipo Equipo, representa al equipo al que pertenece el jugador.

* **champs**: de tipo List, representa algunos personajes que hay en la partida.



## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Base
Descripción breve del tipo base.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

#### Tipos auxiliares
Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
