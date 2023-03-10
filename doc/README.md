# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2022/23)
Autor/a: David Chaves Cumbreras   uvus:JFH0630

El objetivo de este dataset es analizar y recoger los datos de los primeros 15 minutos de varias partidas del videojuego League of Legends en el año 2020 y en el rango Diamante.Se han realizado algunas modificaciones mediante la pagina web https://mockaroo.com para crear datos aleatorios y la propia función ALEATORIO de excel. 


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

El dataset original ha sido descargado de kaggle (https://www.kaggle.com/datasets/benfattori/league-of-legends-diamond-games-first-15-minutes). Originalmente el dataset contaba con 19 columnas y 46000 filas de las cuales se han hecho algunos ajustes para hacer el csv mas sencillo y mas claro, debido a la cantidad de datos que poseia. Actualmente se ha creado una version simplificada y otra extendida del csv, pero se va a emplear de momento la version simplificada la cual cuenta con 18 filas y 20 columnas(5 de ellas pertenecen a un tipo auxiliar de tipo Player). Se han eliminado columnas del csv original como blueDragonKills y red, y blueTowersDestroyed y red. El proyecto consta de de una gran variedad de tipos(String,Double,Integer,List,Player(auxiliar),Enum y Boolean). El objetivo de este dataset es tratar de predecir el transcurso de una partida sabiendo unicamente las estadisticas/datos de los primeros 15 minutos.

Antes de explicar cada tipo voy a especificar algunos terminos que pueden ser algo confusos sin una previa explicación:


* **Partida**: Cada juego suele durar entre 20 o 30 minutos, pero el objetivo de este dataset es tratar de ver y analizar el transcurso de una partida con unicamente datos de los primeros 15 minutos de juego. El unico dato que no corresponde a estos primeros 15 minutos de partida es el del equipo ganador mediante el tipo de dato 
blue_win.

* **Equipos**: En una partida hay dos equipos uno rojo y otro azul habiendo 5 jugadores por equipo.

* **Oro**: Representa la cantidad oro obtenido por parte de un jugador, este recurso es empleado para comprar mejoras durante la partida.
Hay varios factores que intervienen en el transcurso de una partida, pero por normal general el equipo con mas oro (la suma del oro de los 5 miembros de un equipo) es el que suele ganar o el que tiene mas posibilidades de ganar, por tanto mediante este dato podemos tratar de predecir el equipo ganador en una partida.

* **Champs(Campeones)**: Son los personajes jugables que tiene cada jugador, en el juego original hay un total de 162 personajes.

* **Monster**: Junto al oro, los monstruos es una de las fuentes mediante la cual se puede tratar de predecir el equipo ganador de una partida. En los primeros 15 minutos solo se pueden matar 3 monstruos en total(la suma de los monstruos de cada equipo tiene que ser menor o igual que tres).

* **Nivel**: A lo largo de la partida vas subiendo de nivel comenzando por el nivel 1 y teniendo como maximo nivel 18.

* **Asistencia**:El termino de asistencia se refiere a que has ayudado a matar a un enemigo pero tu compañero es el que le ha dado el ultimo golpe para matarlo.




El dataset MatchTimelinesFirst15(simplificado) está compuesto por 21 columnas, con la siguiente descripción:

* **matchId**: de tipo entero largo, representa un numero identificativo de la partida de 10 digitos.
* **blue_win**: de tipo boleano, devuelve true si ganó el equipo azul, y devuelve false si ganó el equipo rojo.
* **blueGold**: de tipo entero,representa  la suma de oro de las 5 personas del equipo azul.
* **blueChampKills**: de tipo entero, representa la suma de los enemigos rojos matados por parte del equipo azul.
* **blueMonsterKills**: de tipo entero, representa la suma de los monstruos matados por parte del equipo azul.
* **blueAvgLevel**: de tipo flotante, representa la media de nivel del equipo azul.
* **redGold**: de tipo entero, representa la suma de oro de las 5 personas del equipo rojo.
* **redChampKills**: de tipo entero, representa la suma de los enemigos azules matados por parte del equipo rojo.
* **redMonsterKills**: de tipo entero, representa la suma de los monstruos matados por parte del equipo rojo.
* **redAvgLevel**: de tipo flotante, representa la media de nivel del equipo rojo.
* **datematch**: de tipo fecha, representa el dia en el que tiene lugar la partida.
* **rango**: de tipo Rango, representa la categoria de la partida pudiendo ser 	DIAMANTE_IV,DIAMANTE_III,DIAMANTE_II o DIAMANTE_I.
* **server**: de tipo cadena,representa el servidor en el que tiene lugar la partida puede ser tanto un pais, una region o un continente.



* Los siguientes 5 tipos pertenecen al tipo auxiliar Player:

    * **bestplayer**: de tipo String, el nombre de usuario del mejor jugador de la partida.
    * **enemiesKilled**: de tipo Integer, representa el numero de enemigos matados por parte del jugador
    * **deads**: de tipo Integer, representa las muertes del jugador.
    * **assists**: de tipo Integer, representa el numero de asistencia del jugadores
    * **team**: de tipo Equipo, representa al equipo al que pertenece el jugador, puede ser ROJO o AZUL.

* **champs**: de tipo lista, representa algunos personajes que hay en la partida.



## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base

El tipo base del proyecto es de tipo Partida, en donde se almacena la informacion de una partida de los primeros 15 minutos ocurridas en el año 2020 y de rango  diamante.

**Propiedades**:

- _id_partida_, de tipo Long,consultable y modificable. Indica un numero identificativo de la partida de 10 digitos.
- _gana_azul_, de tipo Boolean,consultable y modificable. Devuelve true si ganó el equipo azul, y devuelve false si ganó el equipo rojo.
- _oro_equipo_azul_, de tipo Integer,consultable y modificable. Indica la suma de los enemigos rojos matados por parte del equipo azul.
- _rivales_matados_azul_, de tipo Integer,consultable y modificable. Indica la suma de los enemigos rojos matados por parte del equipo azul.
- _monstruos_matados_azul_, de tipo Double, consultable y modificable. Indica la suma de los monstruos matados por parte del equipo azul.
- _media_nivel_azul_, de tipo Integer, consultable y modificable. Indica la media de nivel del equipo azul.
- _oro_equipo_rojo_, de tipo Integer,consultable y modificable. Indica la suma de los enemigos azules matados por parte del equipo rojo.
- _rivales_matados_rojo_, de tipo Integer,consultable y modificable. Indica la suma de los enemigos azules matados por parte del equipo rojo.
- _monstruos_matados_rojo_, de tipo Double, consultable y modificable. Indica la suma de los monstruos matados por parte del equipo rojo.
- _media_nivel_rojo_, de tipo Integer, consultable y modificable. Indica la media de nivel del equipo rojo.
- _fecha_partida_, de tipo LocalDate,consultable y modificable. Indica el dia en el que tiene lugar la partida.
- _rango_, de tipo Rango,consultable y modificable. Indica la categoria de la partida pudiendo ser	DIAMANTE_IV,DIAMANTE_III,DIAMANTE_II o DIAMANTE_I. 
- _server_, de tipo String,consultable y modificable. Indica el servidor en el que tiene lugar la partida puede ser tanto un pais, una region o un continente.
- _mejor_jugador_, de tipo Player(auxiliar),consultable y modificable. Indica los datos del mejor jugador de la partida.
- _personajes_, de tipo List<String>,consultable y modificable. Indica algunos personajes que hay en la partida.
 
**Propiedades derivadas(No estan en el constructor)**:
 
- _equipo_ganador_, de tipo Equipo(derivada),consultable. Indica el equipo ganador segun el valor de gana_azul, si es true devuelve AZUL y si es false devuelve ROJO.
- _tipoVictoria_, de tipo TipoVictoria(derivada),consultable. Indica el tipo de partida que fue segun el oro del equipo ganador y el del equipo perdedor.Puede ser  REMONTADA,IGUALADA,MUCHA_VENTAJA,VENTAJA_ACEPTABLE,NO_DATA.
 

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo ```Partida``` a partir de los siguientes parámetros: ```Long id_partida,Boolean gana_azul,Integer oro_equipo_azul,Integer rivales_matados_azul,Integer oro_equipo_rojo,Integer rivales_matados_rojo,LocalDate fecha_partida,Rango rango_partida,String server```.
- C3: Crea un objeto de tipo ```Partida``` a partir de los siguientes parámetros: ```Long id_partida,Boolean gana_azul,LocalDate fecha_partida,Rango rango_partida,String server```.

**Restricciones**:
 
- R1: El id de la partida debe estar entre 3300000000 y 3500000000.
- R2: Media nivel de cualquier equipo debe estar entre 1.0 y 18.0.
- R3: La suma de Monstruos matados equipo rojo y equipo azul tiene que ser menor o igual a tres .
- R4: La fecha de partida debe ser despues del 31/12/2019 y antes del 1/1/2021, es decir que ocurra en el año 2022.
- R5: La suma de los enemigos matados mas las asistencias del jugador, debe ser menor o igual al numero total de enemigos matados del equipo al que pertenece el jugador.
- R6: Todos los integer tanto en el tipo base como en el tipo auxiliar no pueden ser un valor negativo.

**Criterio de igualdad**: En una partida se considera que jugaron las mismas personas respecto a otra si: 
 
 * 1º La partida se jugó el mismo dia.
 * 2º La partida era del mismo Rango(DIAMANTE_IV,DIAMANTE_III,DIAMANTE_II o DIAMANTE_I).
 * 3º La partida tuvo lugar en el mismo servidor.
 
 Si se cumple estas condiciones en dos partidas, se considera que ese mismo dia coindicidieron las mismas personas en 2 partidas.
 
 
 
**Criterio de ordenación**: Por fecha_partida y por id_partida.

**Otras operaciones**:
 
-	_parseaTipoVictoria_: Empleado para reutilizar codigo en la propiedad derivada tipoVictoria.
- _check...._: Empleado en los Checkers para reutilizar codigo y reducirlo en los constructores y setters.

#### Tipos auxiliares

 El tipo Player almacena los datos del mejor jugador del tipo base Partida. Para la implementacion de este tipo se ha empleado un record por tanto todas sus propiedades son unicamenten consultables.

##### Propiedades tipo auxiliar
 
- _bestplayer_, de tipo String, el nombre de usuario del mejor jugador de la partida.
- _enemiesKilled_, de tipo Integer, representa el numero de enemigos matados por parte del jugador
- _deads_, de tipo Integer, representa las muertes del jugador.
- _assists_, de tipo Integer, representa el numero de asistencia del jugadores
- _team_, de tipo Equipo, representa al equipo al que pertenece el jugador, puede ser ROJO o AZUL.

 
 Hasta aqui la primera entrega
 
 
 
 
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
