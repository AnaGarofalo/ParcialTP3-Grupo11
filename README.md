# RoomJetpackCompose
It's an app built with [Kotlin][1] that shows how to perform CRUD operations in the Room database using Kotlin Flow in clean architecture using [Android Architecture Components][3] and the MVVM Architecture Pattern. For the UI it uses Jetpack Compose, Android's modern toolkit for building native UI.

![alt text](https://i.ibb.co/7X7bvbr/App.png)

Below you can find the docs for each tehnology that is used in this app:

## Firebase Products:
* [Firebase Authentication](https://firebase.google.com/docs/auth)

## Android Architecture Components:
* [ViewModel][5]
* [Navigation][12]

## Dependency Injection:
* [Hilt for Android][6]

## Asynchronous Programming:
* [Kotlin Coroutines][7]
* [Asynchronous Flow][8]

## Other Android Components:
* [Jetpack Compose][9]
* [Room][13]

---

This repo represents the code for following article writen on the Medium publication:

* [How to read data from Room using Kotlin Flow in Jetpack Compose?][10]

See it also on youtube:

* https://youtu.be/BIMSsgyGBKE

**License**
---
The code in this project is licensed under the Apache License 2.0.

    Copyright 2018 Google LLC

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

**Disclaimer**
---
* This is not an officially supported Google product.

[1]: https://kotlinlang.org/
[2]: https://firebase.google.com/docs/auth
[3]: https://developer.android.com/topic/libraries/architecture
[5]: https://developer.android.com/topic/libraries/architecture/viewmodel
[6]: https://developer.android.com/training/dependency-injection/hilt-android
[7]: https://kotlinlang.org/docs/coroutines-overview.html
[8]: https://kotlinlang.org/docs/flow.html
[9]: https://developer.android.com/jetpack/compose
[10]: https://medium.com/firebase-tips-tricks/how-to-read-data-from-room-using-kotlin-flow-in-jetpack-compose-7a720dec35f5
[12]: https://developer.android.com/guide/navigation
[13]: https://developer.android.com/training/data-storage/room

---

## Guía rápida: uso de `BaseScreen`

`BaseScreen` centraliza el layout de pantallas en Compose y expone slots para que agregues tus propios componentes sin repetir estructura.

- Props principales:
  - `title: String?` – título simple para el TopBar (si no pasás `topBar`).
  - `topBar: @Composable (() -> Unit)?` – TopBar custom (usa `AppTopBar` o el que quieras).
  - `header: @Composable (() -> Unit)?` – Cabecera opcional sobre el contenido (chips, filtros, etc.).
  - `content: @Composable (PaddingValues) -> Unit` – Contenido principal. Recibe el padding superior ya calculado.
  - `bottomBar: @Composable (() -> Unit)?` – Barra inferior (por ejemplo `BottomNavigationBar`).
  - `fab: @Composable (() -> Unit)?` – Floating Action Button opcional.
  - `centerContent: Boolean` – Centra vertical y horizontalmente el contenido cuando es `true`.

- Estilos y comportamiento incorporados:
  - Respeta el área segura de status bar para evitar solapes con la cámara/recortes.
  - Pinta el fondo con `MaterialTheme.colorScheme.surface` dentro de un contenedor con bordes superiores curvos.
  - Mantiene paddings y radios desde `ui.theme.Dimens`.

- Ejemplo mínimo:

```kotlin
@Composable
fun ExampleScreen() {
    BaseScreen(
        title = "Example",
        bottomBar = { BottomNavigationBar() },
    ) { _ ->
        // Tu contenido
        Column(Modifier.fillMaxSize().padding(Dimens.paddingLarge)) {
            Text("Hola BaseScreen")
        }
    }
}
```

- Ejemplo con TopBar custom + Header + FAB:

```kotlin
@Composable
fun WithHeaderAndFab() {
    BaseScreen(
        topBar = { AppTopBar(title = "Dashboard") },
        header = {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(label = "All")
                FilterChip(label = "Income")
                FilterChip(label = "Expense")
            }
        },
        fab = { AddActionFab(onClick = { /* do something */ }) },
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(100) { index -> Text("Item #$index") }
        }
    }
}
```

### Ejemplo centrado (empty state)

```kotlin
@Composable
fun EmptyState() {
    BaseScreen(title = "No Data", centerContent = true) { _ ->
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Info, contentDescription = null)
            Spacer(Modifier.height(8.dp))
            Text("Todavía no hay elementos")
        }
    }
}
```

### Ejemplo con lista seccionada (como Notification)

```kotlin
@Composable
fun SectionList(sections: List<Section>) {
    BaseScreen(title = "Sectioned") { _ ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(Dimens.paddingMedium),
            verticalArrangement = Arrangement.spacedBy(Dimens.paddingMedium),
            contentPadding = PaddingValues(bottom = Dimens.paddingLarge)
        ) {
            sections.forEach { section ->
                item(section.title) { Text(section.title) }
                items(section.items) { item -> ItemRow(item) }
            }
        }
    }
}
```

- Recomendaciones:
  - Cuando uses `LazyColumn`, pasá `contentPadding = PaddingValues(bottom = Dimens.paddingLarge)` si tenés navbar para evitar que el último ítem quede tapado.
  - Si ves que el título se corta por la cámara/notch, el `BaseScreen` ya aplica `statusBarsPadding()` al TopBar.
  - Para pantallas centradas (empty states, loaders): `centerContent = true`.
