# CHALLENGE - HACIENDO DDD DESDE CERO #

## Summary ##

En este reto vamos a poner en evidencia las aspectos fundamentales de DDD aplicando todo el conocimiento que se a trabajado dentro del curso de DDD y las mentorias basadas en el ejemplo del JUEGO DE DADOS. Aquí se espera dar solución aplicando a las capas de dominio (aggregate), business (use case), infra (handle y bus) y application (spring boot).

  


Recuerde usar la librería de [https://github.com/Sofka-XT/ddd-generic-java ][https_github.com_Sofka-XT_ddd-generic-java]y puedes usar el siguiente ejemplo como base:

[https://github.com/Sofka-XT/java-ddd-demo-dice][https_github.com_Sofka-XT_java-ddd-demo-dice]

  


Exitos!!

## Use Case/Problem ##

Con base al conocimiento adquirido aplicar DDD en un problema cualquiera, este problema puede inventado o puesto en conversación con tu equipo (maximo 3), es decir por equipo se pueden reunir y plantear un **Modelo de Dominio** básico para poner en evidencia el conocimiento de DDD, pero de forma individual se deberá dar respuesta a la solución planteada, es decir el planteamiento del problema se puede inventar por el equipo pero la solución será de forma individual.

  


Por consiguiente se debe tener en cuenta la siguientes directrices.

1.  Se debe tener 1 agregado como mínimo
2.  Se debe tener 3 entidades como mínimo
3.  Se debe tener 8 objetos de valor
4.  se debe tener 7 comportamientos con sus respectivos eventos de dominio y comandos
5.  Se debe tener mínimo 5 casos de uso disparados por comandos y 2 por eventos
6.  Se debe tener mínimo 5 handles para los casos de uso
7.  Se debe materializar los eventos de dominio en una colección

  


Se puede reutiliza la infraestructura diseñada en el ejemplo.

  


**IMPORTENTE**\: Se debe tener un cubrimiento de pruebas unitarias para poder aceptar que el caso de uso sea valido, es decir, si no se hace pruebas unitarias al caso de uso se considera que no finalizo dicho caso de uso

## Evaluation criteria ##

| Criteria                                                                                       | Percentage |
| ---------------------------------------------------------------------------------------------- | ---------- |
| Implementa el modelo de dominio con un agregado y todos sus comportamientos, eventos y objetos | 40.0 %     |
| Implementa los casos 7 casos de uso según las directrices descritas en el problema del reto.   | 30.0 %     |
| Implementa la capa de infraestructura y conecta con el bus de rabbit y mongodb                 | 20.0 %     |
| Realiza la materialización de los eventos.                                                     | 10.0 %     |


**Nota:** Se realiza el juego quien quiere ser millonario.
![img.png](img.png)
[https_github.com_Sofka-XT_ddd-generic-java]: https://github.com/Sofka-XT/ddd-generic-java
[https_github.com_Sofka-XT_java-ddd-demo-dice]: https://github.com/Sofka-XT/java-ddd-demo-dice