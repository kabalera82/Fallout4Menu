package tech.kabadev.fallout4menuapp;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Clase principal de la aplicación Fallout4MenuApp.
 *
 * <p>Simula un menú inspirado en Fallout 4 usando JavaFX.</p>
 * <p>Responsabilidades:</p>
 * <ul>
 *   <li>Inicializar la aplicación (método {@code start}).</li>
 *   <li>Construir y organizar la interfaz gráfica (método {@code createContent}).</li>
 *   <li>Configurar eventos de interacción en los elementos del menú.</li>
 * </ul>
 *
 * <p>Componentes principales:</p>
 * <ul>
 *   <li>Imagen de fondo con efecto SepiaTone.</li>
 *   <li>Dos cajas de menú (MenuBox y MenuBox2).</li>
 *   <li>Rectangle usado como enmascarador para transiciones.</li>
 *   <li>Items de menú con acciones: "NEW", "SETTINGS", "EXIT", etc.</li>
 * </ul>
 *
 * @author Marcos
 * @version 1.0
 */
public class Fallout4MenuApp extends Application {

    /**
     * Punto de entrada de la aplicación.
     * @param args argumentos desde la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args); // Lanza la aplicación JavaFX
    }

    /**
     * Construye el contenido gráfico del menú.
     * @return un nodo raíz (Parent) con toda la interfaz montada.
     */
    private Parent createContent() {
        Pane root = new Pane(); // Contenedor principal

        // Imagen de fondo cargada desde recursos
        ImageView imageView = new ImageView(getClass()
                .getResource("/images/Fallout4_bg.jpg").toExternalForm());

        // Ajusta el tamaño de la imagen al ancho y alto de la ventana
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);

        // Filtro Sepia para darle aspecto retro
        SepiaTone tone = new SepiaTone(0.85);
        imageView.setEffect(tone);

        // Rectangle transparente que actúa como "cortina" para transiciones
        Rectangle masker = new Rectangle(1280, 720);
        masker.setOpacity(0);              // invisible por defecto
        masker.setMouseTransparent(true);  // no bloquea clics

        // Caja de menú principal
        MenuBox menuBox = new MenuBox(250, 350);
        menuBox.setTranslateX(250); // posición en X
        menuBox.setTranslateY(230); // posición en Y

        // Caja secundaria (submenu)
        MenuBox menuBox2 = new MenuBox(510, 350);
        menuBox2.setTranslateX(250 + 20 + 250); // desplazada a la derecha
        menuBox2.setTranslateY(230);

        // Item "CONTINUE" sin acción definida
        menuBox.addItem(new MenuItem("CONTINUE", 250));

        // Item "NEW": simula carga con transición
        MenuItem itemNew = new MenuItem("NEW", 250);
        itemNew.setOnAction(() -> {
            // FadeTransition oscurece la pantalla
            FadeTransition ft = new FadeTransition(Duration.seconds(1.5), masker);
            ft.setToValue(1);

            // Al finalizar, muestra pantalla de carga
            ft.setOnFinished(e -> {
                root.getChildren().setAll(new LoadingScreen(1280, 720, () -> {
                    masker.setOpacity(0); // vuelve transparente
                    root.getChildren().setAll(imageView, menuBox, menuBox2, masker);
                }));
            });

            ft.play(); // inicia animación
        });
        menuBox.addItem(itemNew);

        // Item "LOAD" sin acción definida
        menuBox.addItem(new MenuItem("LOAD", 250));

        // Item "SETTINGS": carga submenú en segunda caja
        MenuItem itemSettings = new MenuItem("SETTINGS", 250);
        itemSettings.setOnAction(() -> {
            menuBox2.addItems(
                    new MenuItem("GAMEPLAY", 510),
                    new MenuItem("CONTROLS", 510),
                    new MenuItem("DISPLAY", 510),
                    new MenuItem("AUDIO", 510));
        });
        menuBox.addItem(itemSettings);

        // Item "CREW" sin acción definida
        menuBox.addItem(new MenuItem("CREW", 250));

        // Item "EXIT": cierra la aplicación
        MenuItem itemExit = new MenuItem("EXIT", 250);
        itemExit.setOnAction(() -> System.exit(0));
        menuBox.addItem(itemExit);

        // Añade todos los elementos al contenedor principal
        root.getChildren().addAll(imageView, menuBox, menuBox2, masker);
        return root;
    }

    /**
     * Método principal de JavaFX.
     * Construye la escena y muestra la ventana.
     *
     * @param primaryStage ventana principal de la aplicación.
     * @throws Exception si ocurre un error al iniciar la UI.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent()); // crea la escena
        primaryStage.setTitle("Fallout4 Menu");   // título de la ventana
        primaryStage.setScene(scene);             // asigna escena
        primaryStage.show();                      // muestra la ventana
    }
}
