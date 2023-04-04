import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    // Déclaration des champs de classe
    private StackPane root;
    private ComboBox<String> combo;
    private TextField txtNom, txtNom1, txtNom2, txtNom3, txtNom4;
    private ToggleGroup group, group1, group2, group3;
    private RadioButton rb1, rb2, rb3, Math1, Math2, Math3, Info1, Info2, Info3, Geo1, Geo2, Geo3;
    private CheckBox cb1;
    private Button btn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new StackPane(); // Initialisation du conteneur
        initWidgets();
        addWidgetsToSceneV1();
        primaryStage.setTitle("Cours"); // Titre de la fenêtre
        primaryStage.setScene(new Scene(root, 400, 250)); // Mettre le conteneur comme contenu de la fenêtre.
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
                btn
        );
        flowPaneBtn1.setAlignment(javafx.geometry.Pos.CENTER);

        FlowPane flowPaneBtn2 = new FlowPane();
        flowPaneBtn2.getChildren().addAll(
                new Label("Valeur")
        );
        flowPaneBtn2.setAlignment(javafx.geometry.Pos.CENTER);

        // Conteneur principal
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
                flowPaneAnglais, flowPaneMath, flowPaneInfo, flowPaneGeo, flowPaneOptionnel, flowPaneBtn, flowPaneBtn1, flowPaneBtn2
        );
        root.getChildren().addAll(vbox);
    }

    private void initWidgets() {
        txtNom = new TextField();
        group = new ToggleGroup();
        rb1 = new RadioButton("1");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        rb2 = new RadioButton("2");
        rb2.setToggleGroup(group);
        rb3 = new RadioButton("3");
        rb3.setToggleGroup(group);

        txtNom1 = new TextField();
        group1 = new ToggleGroup();
        Math1 = new RadioButton("1");
        Math1.setToggleGroup(group1);
        Math1.setSelected(true);
        Math2 = new RadioButton("2");
        Math2.setToggleGroup(group1);
        Math3 = new RadioButton("3");
        Math3.setToggleGroup(group1);

        txtNom2 = new TextField();
        group2 = new ToggleGroup();
        Info1 = new RadioButton("1");
        Info1.setToggleGroup(group2);
        Info1.setSelected(true);
        Info2 = new RadioButton("2");
        Info2.setToggleGroup(group2);
        Info3 = new RadioButton("3");
        Info3.setToggleGroup(group2);

        txtNom3 = new TextField();
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
        txtNom4 = new TextField();
        cb1 = new CheckBox("Prendre en considération les coefficients");
        btn = new Button("Moyenne");
    }
}