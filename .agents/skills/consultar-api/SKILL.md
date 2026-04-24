---
name: consultar-api
description: Consulta la API de usuarios para obtener el número de registros usando curl.
---

# Consultar API Skill

Este skill permite consultar la API de usuarios utilizando comandos de terminal.

## Objetivo
Consultar el endpoint de usuarios y reportar cuántos registros hay en total.

## Comando de Uso
Para obtener el número de registros, ejecuta el siguiente comando:

```bash
curl -s https://69de35c8410caa3d47bac8c2.mockapi.io/usuarios | jq 'length'
```

*Nota: Se requiere `jq` para procesar el JSON y obtener la longitud del arreglo directamente.*

## Pasos manuales (si no hay jq)
1. Ejecutar: `curl -s https://69de35c8410caa3d47bac8c2.mockapi.io/usuarios`
2. Contar los elementos del arreglo JSON devuelto.
