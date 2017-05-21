# proyecto-iw
Repositorio para almacenar el código del proyecto de la asignatura ingeniería web

## Servicios web
### Servicio para usaurio: 
Responde a la url: http://localhost:8080/GeneraPruebas/rest/usuario
Se tiene configurado en en db el usuario con login=user03 y password=pwd03, el servicio para autenticar un usuario responde al método 
POST y usa parámetros tipo Queryparam. La siguiente imagen muestra el prueba en postman del servicio mencionado.

![autenticarws](https://cloud.githubusercontent.com/assets/20157011/26286671/c4ef8e10-3e30-11e7-85cc-b7084f0b9731.png)


### Servicio para preguntas
Responde a la url http://localhost:8080/GeneraPruebas/rest/pregunta
Se tiene configurado en db la temática con idTematica=1, el servicio para obtener el listado de preguntas dada una temática, responde al 
método GET y retorna un objeto JSON son la inforación den las preguntas retornadas, usa parámetros tipo QueryParam.
Para la creación de una pregunta el servicio responde al método POST y produce un String con la confirmación en caso de exito, usa parámetros tipo QueryParam, se ha hecho la prueba en postman con los siguientes datos:

texto:Pregunta de prueba en servicio web
numOpciones:2
jsonOpciones:{"a": "pWS option a", "b": "pWS option b"}
optCorrecta:a
nivelDificultad:2
idTematica:3
loginUsuarioCrea:user01
fechaCrea:2017/05/21

En la figura se muestra la prueba del servicio en postman.

![crearpreguntaws](https://cloud.githubusercontent.com/assets/20157011/26286908/41c2bc7e-3e35-11e7-81df-7c898cce87aa.png)
