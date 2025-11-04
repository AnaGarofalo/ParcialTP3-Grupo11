# PARCIAL TP3

## Integrantes

- Acosta, Luis
- Benito, Christian
- Garófalo, Ana
- Hochman, Lucas

## Implementación

- Pantallas Requeridas
- Retrofit (4 rutas requeridas, se puede ver la respuesta de transactions en la pantalla home y la de user/{id} en una pantalla provisoria que reemplaza a la pantalla optativa Profile)
- Room (modelo User, se crea al completar el Sign Up, se muestra en una pantalla provisoria que reemplaza a la pantalla optativa Profile, los métodos de update y delete están creados pero no implementados)

**Extras:** inyección de depndencias, modo oscuro, pantalla de Categorías

---

## 1. ¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?

Arquitectura Utilizada: La aplicación utiliza una combinación de Clean Architecture (Arquitectura Limpia) y el patrón MVVM (Model-View-ViewModel).

**Clean Architecture:** Separación de responsabilidades en diferentes capas. Aunque la estructura de paquetes no es estrictamente data, domain, presentation, los componentes sí lo son:

- **Domain:** Define las interfaces de lógica de negocio, como UserRepository.kt, que es un contrato abstracto.
- **Data:** Contiene las implementaciones concretas, como UserRepositoryImpl.kt (que depende de UserDao) y las clases de infraestructura de red (AuthImpl, SafeApiCall).
- **Presentation:** Incluye los componentes de UI (Jetpack Compose, como LoginScreen.kt) y los ViewModels (LoginViewModel.kt) que conectan la lógica con la UI.

**MVVM:** Se utiliza para la capa de presentación.

- **View:** Son los @Composable de Jetpack Compose (ej. LoginScreen).
- **ViewModel:** Clases como LoginViewModel, WalletViewModel y UserViewModel que exponen el estado (UiState) a la UI mediante StateFlow y manejan la lógica de la pantalla.

**¿Por qué esta arquitectura?** Clean Architecture promueve la separación de responsabilidades, haciendo que el código sea más mantenible, escalable e independiente de frameworks (la lógica de dominio no sabe nada de Room o Retrofit). MVVM es el patrón recomendado por Google para la UI, ya que desacopla la lógica de la UI y maneja el estado de forma eficiente, especialmente con Jetpack Compose.

---

## 2. ¿Tuvieron objetos stateful y stateless? ¿Cómo definen la elección de los mismos?

Sí, en Jetpack Compose esta distinción es fundamental y la aplicación los utiliza.

**Stateless (Sin Estado):** Son composables "tontos" que no gestionan su propio estado. Simplemente renderizan la información que reciben como parámetros y notifican eventos a través de lambdas.

Ejemplo: El componente BaseScreen es un claro ejemplo de un componente stateless. Expone "slots" (topBar, content, fab) pero no sabe ni le importa qué contiene ese content. Su apariencia depende únicamente de los parámetros que se le pasan.

**Stateful (Con Estado):** Son composables que crean, retienen o gestionan su propio estado (usando remember, rememberSavable, o recolectando un StateFlow).

Ejemplo: LoginScreen.kt es stateful porque obtiene y se suscribe al LoginViewModel (viewModel: LoginViewModel = viewModel()). Este ViewModel mantiene el estado de la pantalla (ej. uiState).

Para los objetos que sirven de base para evitar repetir código (BaseScreen, BaseInput) o aquellos que sólo renderizan contenido (IncomeExpenseCard) utilizamos componentes stateles. Para aquellos que tienen estados variables (los formularios de Login, Create Account) o varían de estado porque reciben información de fuentes externas (api, base de datos) usamos stateful

---

## 3. ¿Qué mejoras detectan que podrían realizarle a la app? Comenten al menos 2 cuestiones a refactorizar.

**Manejo de estados:** aunque tenemos un componente safeApiCall que maneja las excepciones a las requests de la api, en los componentes sólo solemos usar el UiState en caso successfull y a veces error o loading, pero no lo manejamos de manera consistente en toda la aplicación

**Uso de Casos de Uso (Use Cases):** En Clean Architecture, la capa domain suele contener "Casos de Uso" (o "Interactors") que encapsulan una única regla de negocio. Actualmente, el LoginViewModel llama directamente al repositorio (auth.login(...)). Se podría crear una clase en el dominio llamada LoginUseCase (por ejemplo). El ViewModel llamaría a loginUseCase.invoke(username, password). Este Caso de Uso contendría la lógica de llamar al auth.login, validar los campos (si no se hace ya en la UI), y manejar la lógica de negocio específica del login. Esto hace que el ViewModel sea aún más ligero y que las reglas de negocio sean más fáciles de probar de forma aislada.

---

## 4. ¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código? Mencionen la estrategia de mapeo que más se adecúe.

**Manejo de Errores Actual:** El manejo de errores se contempla en tres niveles:

**Nivel de Infraestructura (Red):** Usamos un wrapper suspend fun safeApiCall(...). Este helper envuelve la llamada de Retrofit en un try-catch para capturar Exceptions (ej. SocketTimeoutException) y también comprueba response.isSuccessful para errores HTTP (ej. 4xx, 5xx).

**Estrategia de Mapeo:** Los resultados de safeApiCall se mapean a una Sealed Class llamada ApiResult, que puede ser ApiResult.Success(data), ApiResult.Error(code, message) o ApiResult.Exception(exception).

**Nivel de ViewModel:** Los ViewModels (ej. LoginViewModel, WalletViewModel) tienen su propia Sealed Class de UiState que incluye un estado de Error (ej. data class Error(val message: String)). Cuando detectan un fallo (actualmente solo un null de la capa inferior), emiten este estado de error. La UI (Compose) observaría este estado y mostraría un AlertDialog o un Snackbar.

**Manejo de Errores Sugerido (Mejora):** El ApiResult detallado de la infraestructura no llega al ViewModel.

La estrategia de mapeo ideal sería: safeApiCall -> ApiResult<T> -> Repositorio -> Result<Model> -> ViewModel -> UiState.Error(String)

El ViewModel recibiría el Result (que podría contener el código de error o el mensaje de excepción) y sería responsable de mapear ese error técnico a un mensaje legible por el usuario. Por ejemplo, un HttpException 404 se mapearía a "Usuario o contraseña incorrectos", mientras que un SocketTimeoutException se mapearía a "No se pudo conectar al servidor, revisa tu conexión".

---

## 5. Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizaría para extenderla.

La aplicación está preparada para adaptarse a distintos idiomas porque usa String Resources.

**Inglés (Default):** Todos los textos en inglés se mantienen en el archivo app/src/main/res/values/strings.xml. Por ejemplo, en LoginScreen.kt se usa stringResource(R.string.welcome).

**Español (Localización):** Para agregar el español, se crea un nuevo directorio de recursos: app/src/main/res/values-es/. Dentro de ese directorio, se crea un nuevo archivo strings.xml. En este nuevo archivo, se definen las mismas claves pero con los valores traducidos al español.

El sistema operativo Android se encarga automáticamente de seleccionar el archivo de recursos correcto (el de values-es si el dispositivo está en español, o el de values por defecto si está en inglés o cualquier otro idioma no definido). El código de la aplicación (stringResource(R.string.welcome)) no necesita ningún cambio.

---

## 6. Y si necesitamos agregar otros idiomas?

La estrategia es exactamente la misma, simplemente se escala. Se añade un nuevo directorio values-<código_idioma> por cada idioma adicional requerido, utilizando los códigos ISO 639-1.
