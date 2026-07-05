package com.example.cando_crud_bd.controller;

import com.example.cando_crud_bd.dao.PeliculaDAO;
import com.example.cando_crud_bd.dao.PeliculaDAOImpl;
import com.example.cando_crud_bd.model.Pelicula;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PeliculaController {

    @FXML private TextField txtId;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtDirector;
    @FXML private TextField txtDuracion;

    @FXML private ComboBox<String> cmbGenero;
    @FXML private DatePicker dpEstreno;
    @FXML private CheckBox chkDisponible;

    @FXML private TableView<Pelicula> tablaPeliculas;
    @FXML private TableColumn<Pelicula, Integer> colId;
    @FXML private TableColumn<Pelicula, String> colTitulo;
    @FXML private TableColumn<Pelicula, String> colGenero;
    @FXML private TableColumn<Pelicula, String> colDirector;
    @FXML private TableColumn<Pelicula, Integer> colDuracion;
    @FXML private TableColumn<Pelicula, String> colEstreno;
    @FXML private TableColumn<Pelicula, Boolean> colDisponible;

    private final PeliculaDAO peliculaDAO = new PeliculaDAOImpl();
    private ObservableList<Pelicula> listaPeliculas;

    @FXML
    public void initialize() {
        cmbGenero.setItems(FXCollections.observableArrayList(
                "Accion", "Romance", "Drama", "Terror", "Comedia", "Ciencia Ficcion"
        ));

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        colEstreno.setCellValueFactory(new PropertyValueFactory<>("estreno"));
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        cargarPeliculas();

        tablaPeliculas.setOnMouseClicked(event -> seleccionarPelicula());
    }

    @FXML
    private void registrar() {
        if (!validarCampos()) return;

        Pelicula pelicula = new Pelicula(
                txtTitulo.getText(),
                cmbGenero.getValue(),
                txtDirector.getText(),
                Integer.parseInt(txtDuracion.getText()),
                dpEstreno.getValue(),
                chkDisponible.isSelected()
        );

        peliculaDAO.crear(pelicula);
        mostrarAlerta("Registro exitoso", "La película fue registrada correctamente");
        cargarPeliculas();
        limpiar();
    }

    @FXML
    private void actualizar() {
        if (txtId.getText().isEmpty()) {
            mostrarAlerta("Error", "Seleccione una película de la tabla");
            return;
        }

        if (!validarCampos()) return;

        Pelicula pelicula = new Pelicula(
                Integer.parseInt(txtId.getText()),
                txtTitulo.getText(),
                cmbGenero.getValue(),
                txtDirector.getText(),
                Integer.parseInt(txtDuracion.getText()),
                dpEstreno.getValue(),
                chkDisponible.isSelected()
        );

        peliculaDAO.actualizar(pelicula);
        mostrarAlerta("Actualización exitosa", "La película fue actualizada correctamente");
        cargarPeliculas();
        limpiar();
    }

    @FXML
    private void eliminar() {
        if (txtId.getText().isEmpty()) {
            mostrarAlerta("Error", "Seleccione una película de la tabla");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Está seguro de eliminar esta película?");

        if (confirmacion.showAndWait().get() == ButtonType.OK) {
            int id = Integer.parseInt(txtId.getText());
            peliculaDAO.eliminar(id);

            mostrarAlerta("Eliminado", "La película fue eliminada correctamente");
            cargarPeliculas();
            limpiar();
        }
    }

    @FXML
    private void limpiar() {
        txtId.clear();
        txtTitulo.clear();
        txtDirector.clear();
        txtDuracion.clear();
        cmbGenero.setValue(null);
        dpEstreno.setValue(null);
        chkDisponible.setSelected(false);
        tablaPeliculas.getSelectionModel().clearSelection();
    }

    private void cargarPeliculas() {
        listaPeliculas = FXCollections.observableArrayList(peliculaDAO.listar());
        tablaPeliculas.setItems(listaPeliculas);
    }

    private void seleccionarPelicula() {
        Pelicula pelicula = tablaPeliculas.getSelectionModel().getSelectedItem();

        if (pelicula != null) {
            txtId.setText(String.valueOf(pelicula.getId()));
            txtTitulo.setText(pelicula.getTitulo());
            cmbGenero.setValue(pelicula.getGenero());
            txtDirector.setText(pelicula.getDirector());
            txtDuracion.setText(String.valueOf(pelicula.getDuracion()));
            dpEstreno.setValue(pelicula.getEstreno());
            chkDisponible.setSelected(pelicula.isDisponible());
        }
    }

    private boolean validarCampos() {
        if (txtTitulo.getText().isEmpty()) {
            mostrarAlerta("Validación", "El título es obligatorio");
            return false;
        }

        if (txtTitulo.getText().length() < 3 || txtTitulo.getText().length() > 100) {
            mostrarAlerta("Validación", "El título debe tener entre 3 y 100 caracteres");
            return false;
        }

        if (cmbGenero.getValue() == null) {
            mostrarAlerta("Validación", "Debe seleccionar un género");
            return false;
        }

        if (txtDirector.getText().isEmpty()) {
            mostrarAlerta("Validación", "El director es obligatorio");
            return false;
        }

        if (txtDuracion.getText().isEmpty()) {
            mostrarAlerta("Validación", "La duración es obligatoria");
            return false;
        }

        try {
            int duracion = Integer.parseInt(txtDuracion.getText());

            if (duracion <= 0) {
                mostrarAlerta("Validación", "La duración debe ser mayor a 0");
                return false;
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Validación", "La duración debe ser un número");
            return false;
        }

        if (dpEstreno.getValue() == null) {
            mostrarAlerta("Validación", "Debe seleccionar una fecha de estreno");
            return false;
        }

        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}