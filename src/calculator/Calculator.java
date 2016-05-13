package calculator;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 public class Calculator extends Design{
@Override
public void start(Stage primaryStage) throws Exception {
    
       task a = new task();
    Thread thread = new Thread(a);
    
    thread.start();
    
	primaryStage=Show(primaryStage);
 	primaryStage.show();
}
public static void main(String[]args)
{
	launch(args);
}
    @Override
    protected Stage Show(Stage primaryStage) {
       return primaryStage=PrepareDesign(primaryStage);
    }

    
   
}
class task implements Runnable
{

    public task() {
    }

    @Override
    public void run() {
        AudioClip audio = new AudioClip(getClass().getResource("tone1.mp3").toExternalForm());
            audio.setVolume(1000f); 
          // audio.setCycleCount(audio.INDEFINITE);
             audio.play();
             
             
     }

}