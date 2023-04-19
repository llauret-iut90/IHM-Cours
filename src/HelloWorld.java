import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class HelloWorld extends Application {
    // Déclaration des champs de classe
    private StackPane root;
    private ComboBox<String> combo;
    private TextField txtNom, txtNom1, txtNom2, txtNom3, txtNom4;
    private ToggleGroup group, group1, group2, group3;
    private RadioButton rb1, rb2, rb3, Math1, Math2, Math3, Info1, Info2, Info3, Geo1, Geo2, Geo3;
    private CheckBox cb1;
    private Button btn;
    private VBox vbox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

//        // Formattage des champs de texte pour ne pas pouvoir entrer autre chose qu'un nombre
//        TextFormatter<String> formatter = new TextFormatter<>(change -> {
//            String newText = change.getControlNewText();
//            if (newText.matches("\\d")) {
//                return change;
//            }
//            return null;
//        });
//
//        txtNom.setTextFormatter(formatter);
//        txtNom1.setTextFormatter(formatter);
//        txtNom2.setTextFormatter(formatter);
//        txtNom3.setTextFormatter(formatter);
//        txtNom4.setTextFormatter(formatter);

        root = new StackPane(); // Initialisation du conteneur
        primaryStage.getIcons().add(new Image("file:icone-fenetre.gif"));
        primaryStage.setTitle("[IHM]"); // Titre de la fenêtre

        initWidgets();
        addWidgetsToSceneV2();
        addListener();

        primaryStage.setScene(new Scene(vbox, 450, 270)); // Mettre le conteneur comme contenu de la fenêtre.
        primaryStage.setResizable(false); // Fenêtre non redimensionnable
        primaryStage.show();
    }

    private void addWidgetsToSceneV1() {
        // Conteneurs pour chaque matière
        FlowPane flowPaneAnglais = new FlowPane();
        flowPaneAnglais.getChildren().addAll(
                new Label("Anglais"), // Label
                txtNom, // Champ de texte
                rb1, rb2, rb3 // Boutons radio
        );
        flowPaneAnglais.setStyle("-fx-background-color: #0000ff");
        flowPaneAnglais.setAlignment(javafx.geometry.Pos.CENTER);

        FlowPane flowPaneMath = new FlowPane();
        flowPaneMath.getChildren().addAll(
                new Label("Math"), txtNom1,
                Math1, Math2, Math3
        );
        flowPaneMath.setStyle("-fx-background-color: #ff0000");
        flowPaneMath.setAlignment(javafx.geometry.Pos.CENTER);

        FlowPane flowPaneInfo = new FlowPane();
        flowPaneInfo.getChildren().addAll(
                new Label("Informatique"), txtNom2,
                Info1, Info2, Info3
        );
        flowPaneInfo.setStyle("-fx-background-color: #00ff00");
        flowPaneInfo.setAlignment(javafx.geometry.Pos.CENTER);

        FlowPane flowPaneGeo = new FlowPane();
        flowPaneGeo.getChildren().addAll(
                new Label("Géographie"), txtNom3,
                Geo1, Geo2, Geo3
        );
        flowPaneGeo.setStyle("-fx-background-color: #00ffff");
        flowPaneGeo.setAlignment(javafx.geometry.Pos.CENTER);

        FlowPane flowPaneOptionnel = new FlowPane();
        flowPaneOptionnel.getChildren().addAll(
                combo, txtNom4, new Label("Optionnel")
        );
        flowPaneOptionnel.setAlignment(javafx.geometry.Pos.CENTER);

        FlowPane flowPaneBtn = new FlowPane();
        flowPaneBtn.getChildren().addAll(
                cb1
        );
        flowPaneBtn.setAlignment(javafx.geometry.Pos.CENTER);

        FlowPane flowPaneBtn1 = new FlowPane();
        flowPaneBtn1.getChildren().addAll(
                btn, new Label("Valeur")
        );
        flowPaneBtn1.setAlignment(javafx.geometry.Pos.CENTER);

        // Conteneur principal
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
                flowPaneAnglais, flowPaneMath, flowPaneInfo, flowPaneGeo, flowPaneOptionnel, flowPaneBtn, flowPaneBtn1
        );
        root.getChildren().addAll(vbox);
    }

    private void addWidgetsToSceneV2() {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Anglais"), 0, 0);
        gridPane.add(txtNom, 1, 0);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(rb1, rb2, rb3);
        gridPane.add(hBox, 2, 0);

        gridPane.add(new Label("Math"), 0, 1);
        gridPane.add(txtNom1, 1, 1);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(Math1, Math2, Math3);
        gridPane.add(hBox1, 2, 1);

        gridPane.add(new Label("Informatique"), 0, 2);
        gridPane.add(txtNom2, 1, 2);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(Info1, Info2, Info3);
        gridPane.add(hBox2, 2, 2);

        gridPane.add(new Label("Géographie"), 0, 3);
        gridPane.add(txtNom3, 1, 3);
        gridPane.setPadding(new Insets(10, 10, 10, 10));


        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(Geo1, Geo2, Geo3);
        gridPane.add(hBox3, 2, 3);

        gridPane.add(combo, 0, 4);
        gridPane.add(txtNom4, 1, 4);
        gridPane.add(new Label("Optionnel"), 2, 4);


        FlowPane flowPaneBtn = new FlowPane();
        flowPaneBtn.getChildren().addAll(
                cb1
        );
        flowPaneBtn.setAlignment(javafx.geometry.Pos.CENTER);

        HBox hbox4 = new HBox();
        hbox4.getChildren().addAll(
                btn, new Label("Valeur")
        );

        vbox = new VBox();
        vbox.getChildren().addAll(
                gridPane, flowPaneBtn, hbox4
        );

        gridPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        gridPane.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        gridPane.setMaxWidth(400);
        gridPane.maxHeight(270);
        hbox4.setAlignment(Pos.CENTER);
//        root.getChildren().addAll(gridPane, flowPaneBtn, hbox4, vbox);
    }

    private void initWidgets() {
        txtNom = new TextField("0");
        group = new ToggleGroup();
        rb1 = new RadioButton("1");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        rb2 = new RadioButton("2");
        rb2.setToggleGroup(group);
        rb3 = new RadioButton("3");
        rb3.setToggleGroup(group);

        txtNom1 = new TextField("0");
        group1 = new ToggleGroup();
        Math1 = new RadioButton("1");
        Math1.setToggleGroup(group1);
        Math1.setSelected(true);
        Math2 = new RadioButton("2");
        Math2.setToggleGroup(group1);
        Math3 = new RadioButton("3");
        Math3.setToggleGroup(group1);

        txtNom2 = new TextField("0");
        group2 = new ToggleGroup();
        Info1 = new RadioButton("1");
        Info1.setToggleGroup(group2);
        Info1.setSelected(true);
        Info2 = new RadioButton("2");
        Info2.setToggleGroup(group2);
        Info3 = new RadioButton("3");
        Info3.setToggleGroup(group2);

        txtNom3 = new TextField("0");
        group3 = new ToggleGroup();
        Geo1 = new RadioButton("1");
        Geo1.setToggleGroup(group3);
        Geo1.setSelected(true);
        Geo2 = new RadioButton("2");
        Geo2.setToggleGroup(group3);
        Geo3 = new RadioButton("3");
        Geo3.setToggleGroup(group3);

        combo = new ComboBox<>(FXCollections.observableArrayList("Latin", "Grec", "Sport"));
        combo.setValue("Latin");
        txtNom4 = new TextField("0");
        cb1 = new CheckBox("Prendre en considération les coefficients");
        btn = new Button("Moyenne");
    }

    private void addListener() {
        btn.setOnAction(event -> {
            double moyenne = 0;

            if (!txtNom.getText().isEmpty()) {
                double anglais = Double.parseDouble(txtNom.getText());
                if (cb1.isSelected()) {
                    if (rb1.isSelected()) {
                        moyenne += anglais;
                    } else if (rb2.isSelected()) {
                        moyenne += 2 * anglais;
                    } else if (rb3.isSelected()) {
                        moyenne += 3 * anglais;
                    }
                } else moyenne += anglais;
            }

            if (!txtNom1.getText().isEmpty()) {
                double math = Double.parseDouble(txtNom1.getText());
                if (cb1.isSelected()) {
                    if (Math1.isSelected()) {
                        moyenne += math;
                    } else if (Math2.isSelected()) {
                        moyenne += 2 * math;
                    } else if (Math3.isSelected()) {
                        moyenne += 3 * math;
                    }
                } else moyenne += math;
            }

            if (!txtNom2.getText().isEmpty()) {
                double info = Double.parseDouble(txtNom2.getText());
                if (cb1.isSelected()) {
                    if (Info1.isSelected()) {
                        moyenne += info;
                    } else if (Info2.isSelected()) {
                        moyenne += 2 * info;
                    } else if (Info3.isSelected()) {
                        moyenne += 3 * info;
                    }
                } else moyenne += info;
            }

            if (!txtNom3.getText().isEmpty()) {
                double geo = Double.parseDouble(txtNom3.getText());
                if (cb1.isSelected()) {
                    if (Geo1.isSelected()) {
                        moyenne += geo;
                    } else if (Geo2.isSelected()) {
                        moyenne += 2 * geo;
                    } else if (Geo3.isSelected()) {
                        moyenne += 3 * geo;
                    }
                } else moyenne += geo;
            }

            if (!txtNom4.getText().isEmpty()) {
                double autre = Double.parseDouble(txtNom4.getText());
                if (cb1.isSelected()) {
                    if (combo.getValue().equals("Latin")) {
                        moyenne += 2 * autre;
                    } else if (combo.getValue().equals("Grec")) {
                        moyenne += 2 * autre;
                    } else if (combo.getValue().equals("Sport")) {
                        moyenne += autre;
                    }
                    moyenne /= 5;
                } else {
                    moyenne += autre;
                    moyenne /= 5;
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Moyenne");
            alert.setHeaderText("Moyenne");
            alert.setContentText("Votre moyenne est de " + moyenne);
            alert.showAndWait();
        });
    }
}