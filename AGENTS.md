# App de Adopción de Mascotas - Guías del Proyecto

## Descripción General
Este proyecto está siendo transformado de una plantilla básica de gestión de usuarios a una **Aplicación de Adopción de Mascotas**. Está construido utilizando Kotlin y Jetpack Compose para Android.

El objetivo es permitir a los usuarios:
1. Explorar mascotas disponibles para adopción.
2. Ver información detallada de cada mascota (raza, edad, personalidad, etc.).
3. Gestionar un perfil de usuario y realizar un seguimiento de las solicitudes de adopción.

## Stack Tecnológico
- **Lenguaje**: Kotlin
- **Framework de UI**: Jetpack Compose
- **Arquitectura**: MVVM (Model-View-ViewModel)
- **Networking**: Retrofit
- **Carga de Imágenes**: Coil (Recomendado)
- **Inyección de Dependencias**: Por implementar (probablemente Hilt).

## Estructura del Proyecto
- `com.upn.emptyapp.ui.screens`: Componentes de UI y pantallas.
- `com.upn.emptyapp.viewmodels`: Lógica de negocio y gestión de estado.
- `com.upn.emptyapp.models`: Modelos de datos (ej. `Pet`, `User`, `AdoptionRequest`).
- `com.upn.emptyapp.services`: Definiciones de API mediante Retrofit.
- `com.upn.emptyapp.http`: Configuración del cliente de red.

## Estándares de Codificación
1. **Priorizar Compose**: Usar Jetpack Compose para toda la interfaz de usuario.
2. **Material 3**: Seguir las guías de Material Design 3 para un diseño moderno.
3. **Convenciones de Nombres**:
   - Clases: PascalCase
   - Funciones/Variables: camelCase
   - Recursos: snake_case
4. **Gestión de Estado**: Usar `StateFlow` o `MutableState` en los ViewModels para exponer el estado de la UI.
5. **Código Limpio**: Mantener los composables pequeños y reutilizables.

## Hoja de Ruta de Desarrollo
1. [ ] Crear el modelo de datos `Pet`.
2. [ ] Reemplazar la lista de usuarios actual en `HomeScreen` por una cuadrícula/lista de mascotas.
3. [ ] Diseñar e implementar `PetDetailScreen`.
4. [ ] Implementar funcionalidad de búsqueda/filtrado de mascotas.
5. [ ] Refactorizar `UserApiService` para incluir endpoints relacionados con mascotas.

## Instrucciones para Agentes de IA
- **Migración**: Refactorizar los archivos de ejemplo existentes (como `Usuario.kt`, `UserViewModel.kt`) o reemplazarlos con versiones centradas en mascotas.
- **UI/UX**: Priorizar un diseño amigable y visualmente atractivo, siguiendo el sistema de diseño definido en [DESIGN.md](file:///Users/ludk/Projects/UPN/EmptyApp/DESIGN.md).
- **Buenas Prácticas**: Utilizar patrones modernos de desarrollo Android (Compose, Coroutines, StateFlow).
- **Documentación**: Mantener este archivo `AGENTS.md` y documentar cualquier decisión arquitectónica importante.
