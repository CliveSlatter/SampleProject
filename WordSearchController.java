import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.Node;
import javafx.event.EventHandler;
import java.util.ArrayList;
public class WordSearchController
{
    public static Scene scene; 
    public static BorderPane borderPane;
    public static MenuBar menuBar;
    public static Menu game;
    public static Menu options;
    public static Menu help;
    public static MenuItem newGame;
    public static MenuItem exit;
    public static MenuItem editWords;
    public static MenuItem defaultSettings;
    public static MenuItem topics;
    public static MenuItem about;
    public static MenuItem courseItem;
    public static SplitMenuButton courses;
    public static SplitMenuButton categories;
    public static GridPane gridPane;
    public static VBox vBox;
    public static Button create;
    public static ListView wordList;
    public static ArrayList courseList;
    public static char[][] grid; 
    public static String topic;
    public static String cID;
    
    public WordSearchController(){
        borderPane = new BorderPane();
        gridPane = new GridPane();
        scene = new Scene(borderPane,1200,900);
        menuBar = new MenuBar();
        game = new Menu("Game");
        options = new Menu("Options");
        help = new Menu("Help");
        newGame = new MenuItem("New Game");
        exit = new MenuItem("Exit");
        editWords = new MenuItem("Add / Amend Words List");
        defaultSettings = new MenuItem("Change Default Settings");
        topics = new MenuItem("Help Topics");
        about = new MenuItem("About Word Search");
        game.getItems().add(newGame);
        game.getItems().add(exit);
        options.getItems().add(editWords);
        options.getItems().add(defaultSettings);
        help.getItems().add(topics);
        help.getItems().add(about); 
        menuBar.getMenus().add(game);
        menuBar.getMenus().add(options);
        menuBar.getMenus().add(help);
        courses = new SplitMenuButton();
        categories = new SplitMenuButton();
        create = new Button("Create");
        courses.setMinWidth(150);
        courses.setText("Course");
        categories.setMinWidth(150);
        categories.setText("Category");        
        create = new Button("Find Words");
        vBox = new VBox();
        vBox.getChildren().addAll(courses,categories,create);

        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPrefSize(700,700);
        grid = new char[20][20];
        for(int r = 0; r < 20; r++){
            for(int c = 0; c < 20; c++){
                Button button = new Button(" ");
                button.setMaxWidth(30);
                button.setMaxHeight(30);
                gridPane.add(button, c, r);            
            }
        }
        gridPane.setOnMouseClicked(e-> GridClicked(e));
        borderPane.setTop(menuBar);
        borderPane.setLeft(vBox);
        borderPane.setCenter(gridPane);
    }

    public static void GridClicked(MouseEvent e){
        if(e.getButton()==MouseButton.PRIMARY){
            Node source = (Node)e.getSource();
            Integer colIndex = GridPane.getColumnIndex(source);
            Integer rowIndex = GridPane.getRowIndex(source);
            System.out.println("Mouse entered cell col: " + colIndex + " row: " + rowIndex);            
        }
    }
}
