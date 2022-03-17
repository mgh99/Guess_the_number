# ADIVINA EL NÚMERO SECRETO
--------------------------------------
El programa es una aplicación de chat cliente-servidor implementada con CORBA y Java.

## Funcionamiento
* Tienes 5 vidas para adivinar el número secreto que se genera de forma aleatoria.
* Cada vez que gastes una vida, se te indicará que queda una menos y si el número que has introducido es mayor o menor que el generado por la aplicación.
* Cuando hayas gastado ya 4 intentos te dará una pista sobre la primera cifra del número secreto. (Si te sale de resultado un 0 significará que el número tiene solo unidades, es decir, del 01 al 09).
* Una vez que hayas acertado saldrá un mensaje de enhorabuena.
* Y si por el contrario gastas todas tus vidas y aún no has acertado el número, saldrá un mensaje por pantalla diciendo que has perdido y cuál era el número secreto.

## Compilación en Linux 
Desde el directorio raíz del proyecto, abre una terminal y ejecuta en el siguiente orden estos comandos:

```
idlj -fall AdivinhaNumero.idl
javac Server.java
javac Client.java
```

## Ejecución en Linux
Desde el directorio raíz del proyecto abriremos 3 terminales y ejecutaremos un comando en cada una de ellas y en el mismo orden:

```
tnameserv -ORBInitialPort 2000
java Server -ORBInitialHost localhost -ORBInitialPort 2000
java Client -ORBInitialHost localhost -ORBInitialPort 2000
```
-----------------------------------------------------
## Visualización
<div align = "center"><img src="https://github.com/mgh99/Guess_the_number/blob/master/img/adivina_numero.gif.gif" alt="App Screenshot" style="zoom: 70%" /></div>

----------------------------------------------------------
## Autor
<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://www.linkedin.com/in/mar%C3%ADa-gonz%C3%A1lez-herrero-56bb21177/"><img src="https://avatars.githubusercontent.com/u/43043718?v=4" width="100px;" alt=""/><br /><sub><b>María González</b></sub></a><br /><a href="https://github.com/mgh99/Programacion_sistemas_Internet" title="Code">💻</a></td>
  </tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

