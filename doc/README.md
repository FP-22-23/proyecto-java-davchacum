# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2022/23)
Autor/a: David Chaves Cumbreras   uvus:JFH0630

El objetivo de este dataset es analizar y recoger los datos de varias partidas del videojuego League of Legends en el año 2020 y se han realizado algunas
modificaciones mediante la pagina web https://mockaroo.com para crear datos aleatorios y la propia función ALEATORIO de excel. El dataset original ha sido descargado 
de kaggle (https://www.kaggle.com/datasets/benfattori/league-of-legends-diamond-games-first-15-minutes). Originalmente el dataset contaba con 19 columnas y 46000 filas 
de las cuales se han hecho algunos ajustes para hacer el csv mas sencillo y mas claro, debido a la cantidad de datos que tenia el csv. Actualmente se ha creado una 
version simplificada y otra extendida del csv, pero se va a emplear de momento la version simplificada la cual cuenta con 20 filas y 20 columnas(5 de ellas pertenecen 
a un tipo auxiliar de tipo Player). Se han eliminado columnas del csv original como blueDragonKills y red o blueTowersDestroyed y red. Otras columnas se han fusionado 
como blueJungleMinionskilled y red en la columna blueMinionsKilled y red. El proyecto consta de de una gran variedad de 
tipos(String,Double,Integer,List,Player(auxiliar),Enum y Boolean)


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

El dataset MatchTimelinesFirst15(simplificado) está compuesto por 20 columnas, con la siguiente descripción:

* **matchId**: de tipo \<tipo\>, representa....
* **blue_win**: de tipo \<tipo\>, representa....
* **blueGold**: de tipo \<tipo\>, representa....
* **blueMinionsKilled**: de tipo \<tipo\>, representa....
* **blueAvgLevel**: de tipo \<tipo\>, representa....
* **redGold**: de tipo \<tipo\>, representa....
* **redMinionsKilled**: de tipo \<tipo\>, representa....
* **redAvgLevel**: de tipo \<tipo\>, representa....
* **\<columna 9>**: de tipo \<tipo\>, representa....
* **\<columna 10>**: de tipo \<tipo\>, representa....
* **\<columna 11>**: de tipo \<tipo\>, representa....
* **\<columna 12>**: de tipo \<tipo\>, representa....
* **\<columna 13>**: de tipo \<tipo\>, representa....
* **\<columna 14>**: de tipo \<tipo\>, representa....
* **\<columna 15>**: de tipo \<tipo\>, representa....
* **\<columna 16>**: de tipo \<tipo\>, representa....
* **\<columna 17>**: de tipo \<tipo\>, representa....
* **\<columna 18>**: de tipo \<tipo\>, representa....
* **\<columna 19>**: de tipo \<tipo\>, representa....
* **\<columna 20>**: de tipo \<tipo\>, representa....


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
