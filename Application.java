import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class Application
{
    private static void  start()
    {
            Stage stage = new Stage();
            WordSearchController wsc = new WordSearchController();
            stage.setTitle("Word Search Test");
            stage.setResizable(true);
            stage.setScene(wsc.scene);                        
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        System.out.println("Close button was clicked!");
                        Application.terminate();
                    }
                });
            stage.show(); 
    }
    
    public static void main(String args[])
    {       
        JFXPanel panel = new JFXPanel();        
        Platform.runLater(() -> start());               
    }
    
    public static void terminate()
    {
        System.out.println("Terminating Application...");
        System.exit(0);
    }
}
