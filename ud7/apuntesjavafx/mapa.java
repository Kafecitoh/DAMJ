package ud7.apuntesjavafx;

/**
 * Crea un programa que represente el mapa en una interfaz gráfica JavaFX y que permita mover un robot desde la casilla A hasta la Z con las teclas
 * de los cursores o AWSD. 
 * Si se pisa una mina deberá mostrar un cuadro de diálogo de error
 * Si se llega a la meta un cuadro de diálogo de éxito.
 */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Mapa extends Application {

    String[] mapa = {
            " Z ",
            " * ",
            " * * ",
            " ",
            " A "
    };

    Label[][] labels = new Label[mapa.length][5]; // máx 5 columnas visibles
    int robotFila = 4;
    int robotCol = mapa[4].indexOf('A');

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();

        // Crear las etiquetas iniciales
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length(); j++) {
                Label lbl = new Label(" " + mapa[i].charAt(j) + " ");
                lbl.setStyle("-fx-border-color: black; -fx-font-size: 20px;");
                labels[i][j] = lbl;
                grid.add(lbl, j, i);
            }
        }

        Scene scene = new Scene(grid);
        scene.setOnKeyPressed(e -> {
            int nuevaFila = robotFila;
            int nuevaCol = robotCol;

            if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W)
                nuevaFila--;
            if (e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S)
                nuevaFila++;
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A)
                nuevaCol--;
            if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D)
                nuevaCol++;

            // Control de límites
            if (nuevaFila < 0 || nuevaFila >= mapa.length ||
                    nuevaCol < 0 || nuevaCol >= mapa[nuevaFila].length())
                return;

            char destino = mapa[nuevaFila].charAt(nuevaCol);

            if (destino == '*') {
                mostrarAlerta("¡Boom!", "Has pisado una mina.");
                return;
            }

            if (destino == 'Z') {
                mostrarAlerta("¡Felicidades!", "Has llegado a la meta.");
                return;
            }

            // Mover robot
            actualizarEtiqueta(robotFila, robotCol, ' ');
            actualizarEtiqueta(nuevaFila, nuevaCol, 'A');
            robotFila = nuevaFila;
            robotCol = nuevaCol;
        });

        stage.setTitle("Mapa del Robot");
        stage.setScene(scene);
        stage.show();
    }

    private void actualizarEtiqueta(int fila, int col, char nuevo) {
        mapa[fila] = mapa[fila].substring(0, col) + nuevo + mapa[fila].substring(col + 1);
        labels[fila][col].setText(" " + nuevo + " ");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}