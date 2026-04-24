---
name: new-page
description: Crea componentes Jetpack Compose para pantallas siguiendo una nomenclatura y estructura base.
---

# New Page Skill

Este skill automatiza la creación de pantallas (Pages) en Jetpack Compose con una estructura base de Scaffold.

## Objetivo
Generar archivos de pantalla consistentes en el proyecto.

## Reglas de Implementación
1. **Ubicación**: Siempre deben crearse en `ui/screens/pages/`.
2. **Nomenclatura**: El nombre del archivo y la función deben seguir el patrón `{Feature}Page`.
   - Ejemplo: `LoginPage`, `DashboardPage`, `UserProfilePage`.
3. **Estructura Base**: Cada página debe incluir un `Scaffold` base de Material3.

## Plantilla Base
Al crear una nueva página, utiliza el siguiente código como punto de partida:

```kotlin
package ui.screens.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun {Feature}Page() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "{Feature}") }
            )
        }
    ) { paddingValues ->
        Text(
            text = "Contenido de {Feature}",
            modifier = Modifier.padding(paddingValues)
        )
    }
}
```

## Instrucciones para el Agente
Cuando el usuario solicite una nueva página:
1. Identifica el nombre de la funcionalidad (`{Feature}`).
2. Crea el archivo en `ui/screens/pages/{Feature}Page.kt`.
3. Aplica la plantilla base reemplazando `{Feature}` con el nombre correspondiente.
4. Asegúrate de que los imports sean correctos según la configuración del proyecto.
