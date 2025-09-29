Fallout4MenuApp

Es la clase principal que extiende Application de JavaFX.

Contiene el método start(), punto de entrada que construye la escena (Scene) y muestra la ventana (Stage).

Encapsula la lógica de la interfaz en el método createContent().

Se encarga de componer todos los elementos visuales:

Fondo con ImageView + filtro SepiaTone.

Dos cajas de menú (MenuBox y MenuBox2).

Un Rectangle usado como enmascarador para transiciones de carga.

También maneja las acciones del menú:

"NEW" → dispara una transición (FadeTransition) y carga la LoadingScreen.

"SETTINGS" → muestra un submenú dinámico en la segunda caja.

"EXIT" → cierra la aplicación.

En un videojuego real sería el equivalente a la pantalla inicial con la lógica de navegación a otros estados (partida nueva, cargar, ajustes, etc.).

🎨 Colors

Clase de utilidades estáticas que centraliza la paleta de colores del proyecto.

Define constantes Color.rgb() para que todos los menús y elementos visuales usen la misma gama verde fosforescente estilo Fallout.

Ventaja: si mañana quieres cambiar la estética, modificas un único archivo y se actualiza en toda la UI.

Es una buena práctica profesional: aislar configuraciones comunes en una clase dedicada, en lugar de “quemar” valores mágicos en el código.

📦 MenuBox

Representa un contenedor visual para agrupar varios MenuItem.

Es probable que extienda de VBox o Pane y que defina su tamaño y disposición.

Permite añadir items con un método addItem(...) o addItems(...).

En tu app tienes dos instancias:

menuBox → menú principal (izquierda).

menuBox2 → submenú dinámico (derecha).

Conceptualmente, sería como un panel de botones que se puede reutilizar en distintos contextos.

🟩 MenuItem

Representa cada opción individual del menú (ej: "NEW", "LOAD", "EXIT").

Internamente seguramente sea un Label, Button o un StackPane estilizado.

Puede registrar acciones con setOnAction(...), de forma similar a un Button.

Se le pasa un texto (nombre de la opción) y un ancho fijo para mantener coherencia visual.

Es la unidad básica de interacción: cada MenuItem reacciona a clics o eventos de teclado.

⏳ LoadingScreen

Pantalla de transición mostrada al pulsar "NEW".

Cubre toda la ventana y muestra probablemente un símbolo de carga animado (según tu clase Colors.LOADING_SYMBOL).

Recibe un callback (Runnable) que se ejecuta al terminar la carga simulada, devolviendo al menú original.

Se usa junto con el FadeTransition para un efecto fluido.

En un juego real, aquí iría la lógica de cargar assets, mapas, texturas, partidas guardadas, etc.

⚙️ Relación entre clases

Fallout4MenuApp → Orquesta todo: crea instancias de MenuBox, MenuItem y LoadingScreen.

Colors → Da coherencia estética: todos los elementos visuales usan su paleta.

MenuBox y MenuItem → Encapsulan UI interactiva: evitan repetir código y dan modularidad.

LoadingScreen → Maneja transiciones entre estados (menú ↔ juego).

🔍 Esto es justo lo que se busca en un proyecto profesional y didáctico:

Separación de responsabilidades (cada clase tiene una función clara).

Reutilización (cajas e items de menú pueden usarse en otros contextos).

Mantenibilidad (paleta centralizada, transiciones encapsuladas).sería el equivalente a la pantalla inicial con la lógica de navegación a otros estados (partida nueva, cargar, ajustes, etc.).

📋 Product Backlog – Fallout4MenuApp
ID	Historia de Usuario (User Story)	Prioridad	Estimación	Criterios de Aceptación
US-01	Como jugador quiero ver un menú principal con fondo estilo Fallout para sentir la estética retrofuturista.	Alta	5 pts	Se muestra imagen de fondo a pantalla completa con efecto sepia.
US-02	Como jugador quiero opciones de menú (“CONTINUE”, “NEW”, “LOAD”, “SETTINGS”, “CREW”, “EXIT”) para navegar por el juego.	Alta	8 pts	Los items aparecen en columna, alineados y seleccionables.
US-03	Como jugador quiero iniciar una nueva partida para comenzar desde cero.	Alta	8 pts	Al pulsar “NEW” aparece pantalla de carga y después se vuelve al menú.
US-04	Como jugador quiero que el menú muestre transiciones suaves para una experiencia más inmersiva.	Media	5 pts	Se usa FadeTransition al cargar nueva partida.
US-05	Como jugador quiero acceder a un submenú de ajustes (gameplay, controles, display, audio) para personalizar la experiencia.	Alta	13 pts	Pulsar “SETTINGS” despliega menú secundario con las 4 opciones.
US-06	Como jugador quiero poder salir del juego desde el menú.	Alta	2 pts	Al pulsar “EXIT” se cierra la aplicación.
US-07	Como jugador quiero ver la lista de desarrolladores (crew) para conocer el equipo.	Baja	3 pts	Al pulsar “CREW” aparece texto/ventana con créditos.
US-08	Como desarrollador quiero centralizar los colores en una clase Colors para mantener coherencia visual.	Media	3 pts	Toda la interfaz usa Colors.java, no valores mágicos en el código.