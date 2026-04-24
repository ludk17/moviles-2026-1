---
name: consultar-api
description: Consulta una API de usuarios y devuelve el conteo de elementos.
---

# Skill Consultar API

Esta skill permite obtener el número de usuarios desde una API externa.

## Instrucciones para el Agente

Cuando el usuario solicite usar esta skill o consultar la API de usuarios:

1. Utiliza la herramienta `read_url_content` para obtener los datos de la URL: `https://69a788b72cd1d0552690e014.mockapi.io/usuarios`
2. Procesa la respuesta JSON.
3. Cuenta el número de elementos en el arreglo de usuarios.
4. Informa al usuario el resultado: "Se han encontrado X usuarios."
