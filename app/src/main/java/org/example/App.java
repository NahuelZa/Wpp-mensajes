package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Ventana
        window = primaryStage;
        window.setTitle("Bus 69");

        //File menu
        Menu fileMenu = new Menu("F_ile");
        //Menu items
        MenuItem newFile = new MenuItem("_New...");
        newFile.setOnAction(actionEvent -> System.out.println("Creando algo"));

        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("New Save.."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("New _Maodule"));
        fileMenu.getItems().add(new SeparatorMenuItem());

        //Edit menu
        Menu editMenu = new Menu("Edit");
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(actionEvent -> System.out.println("Pegar"));
        editMenu.getItems().add(paste);
        paste.setDisable(true);

        Menu helpMenu = new Menu("Ayuda");
        CheckMenuItem showLines = new CheckMenuItem("Quiero pito");
        showLines.setOnAction(actionEvent -> {
            if (showLines.isSelected())
                System.out.println("Por favor ayuda quiero pito");
            else
                System.out.println("No quiero mas pito");
        });


        CheckMenuItem autoSave = new CheckMenuItem("Autoguardado");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);


        Menu dificultad=new Menu("Dificultad");
        ToggleGroup elegirDificultad=new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medio = new RadioMenuItem("medio");
        RadioMenuItem hard = new RadioMenuItem("hard");

        easy.setToggleGroup(elegirDificultad);
        medio.setToggleGroup(elegirDificultad);
        hard.setToggleGroup(elegirDificultad);

        dificultad.getItems().addAll(easy,medio,hard);

        //Boton
        Button boton = new Button("Cambiar");
        boton.setOnAction(actionEvent -> setUserAgentStylesheet(STYLESHEET_CASPIAN));

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu,dificultad);

        //layout
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(boton);


        Scene scene1 = new Scene(layout, 500, 500);
        scene1.getStylesheets().add("Viper.css");


        window.setScene(scene1);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
        ;

    }
}