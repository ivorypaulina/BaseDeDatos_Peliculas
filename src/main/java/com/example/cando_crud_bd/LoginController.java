package com.example.cando_crud_bd.controller;

import com.example.cando_crud_bd.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;

    @FXML
    private void ingresar() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        if (usuario.equals("admin") && password.equals("1234")) {
            abrirCrud();
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos");
        }
    }

    private void abrirCrud() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Main.class.getResource("/com/example/cando_crud_bd/peliculas.fxml")
            );

            Scene scene = new Scene(loader.load(), 1200, 750);
            scene.getStylesheets().add(
                    Main.class.getResource("/com/example/cando_crud_bd/style.css").toExternalForm()
            );

            Stage stage = new Stage();
            stage.setTitle("CRUD de Películas");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            Stage ventanaActual = (Stage) txtUsuario.getScene().getWindow();
            ventanaActual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}