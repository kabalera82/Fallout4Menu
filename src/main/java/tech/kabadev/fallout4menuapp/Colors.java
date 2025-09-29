package tech.kabadev.fallout4menuapp;

import javafx.scene.paint.Color;

/**
 * Clase de utilidades que centraliza la paleta de colores
 * utilizada en la interfaz del menú estilo Fallout 4.
 *
 * <p> Esta clase Colors garantiza consistencia visual en toda la aplicacion facilitando cambios futuros,
 * cuando usas Color.rgb(r, g, b) (o también Color.rgb(r, g, b, opacity)),
 * estás creando un color a partir del modelo RGB (Red, Green, Blue).</p>
 *
 * <ul>
 *   <li>{@link #MENU_TEXT} Verde brillante para el texto de los menús.</li>
 *   <li>{@link #MENU_BG} Fondo semitransparente de los paneles del menú.</li>
 *   <li>{@link #MENU_BORDER} Borde verde que delimita el menú.</li>
 *   <li>{@link #MENU_ITEM_SELECTION} Verde más oscuro para resaltar elementos seleccionados.</li>
 *   <li>{@link #LOADING_SYMBOL} Verde brillante usado en iconos o símbolos de carga.</li>
 * </ul>
 *
 * @author kabalera82
 */

public class Colors {
    /** Verde Brillante para los textos */
    public static final Color MENU_TEXT = Color.rgb(25, 250, 25);
    /** Verde Oscuro para los textos con opacidad al 50% */
    public static final Color MENU_BG = Color.rgb(45, 65, 35, 0.5);
    /** Verde brillante para los bordes del menú. */
    public static final Color MENU_BORDER = Color.rgb(25, 250, 25);
    /** Verde oscuro para efecto Hover */
    public static final Color MENU_ITEM_SELECTION = Color.rgb(10, 140, 10);
    /** Verde brillante para símbolos o indicadores de carga */
    public static final Color LOADING_SYMBOL = Color.rgb(25, 250, 25);
}
