---
name: Git Commit & Push
description: Automatiza el proceso de staging, commit con mensajes descriptivos (Conventional Commits) y push de los cambios.
---

# Git Commit & Push Skill

Esta skill proporciona instrucciones precisas para realizar commits estandarizados y subirlos al repositorio remoto de forma automática.

## Instrucciones para el Agente

Cuando el usuario solicite un commit o se use esta skill, sigue estos pasos:

### 1. Análisis de Cambios
- Ejecuta `git status` y `git diff --cached` (o `git diff` si nada está en stage) para entender qué ha cambiado.
- Identifica el propósito de los cambios (nueva funcionalidad, corrección de errores, documentación, etc.).

### 2. Generación del Mensaje de Commit
Usa la nomenclatura de **Conventional Commits**: `<tipo>(<alcance>): <descripción>`

- **Tipos permitidos**:
  - `feat`: Una nueva característica.
  - `fix`: Una corrección de un error.
  - `docs`: Cambios en la documentación.
  - `style`: Cambios que no afectan el significado del código (espacios, formato, etc.).
  - `refactor`: Un cambio de código que ni corrige un error ni añade una característica.
  - `test`: Añadir pruebas faltantes o corregir pruebas existentes.
  - `chore`: Cambios en el proceso de construcción o herramientas auxiliares.
- **Alcance (Scope)**: Opcional, describe la parte del código afectada (ej. `ui`, `model`, `api`).
- **Descripción**: Un resumen corto y descriptivo en presente (ej. "crear archivo AGENTS.md").

### 3. Ejecución de Comandos
Debes ejecutar los siguientes comandos en orden:

1. `git add .` (o archivos específicos si es necesario).
2. `git commit -m "<mensaje generado>"`
3. `git push`

## Ejemplo de Uso
Si el usuario dice "haz commit de la configuración", el agente debería:
1. Ver que cambió `build.gradle`.
2. Generar: `chore(config): actualizar dependencias de gradle`.
3. Ejecutar `git add .`, `git commit ...` y `git push`.
