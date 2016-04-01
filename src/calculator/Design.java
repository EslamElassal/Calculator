/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Eslam
 */
public abstract class Design extends Application{
//abstract Function Show used in Instance Class From Design Class To Call PrepareDesign Function 
    Text text = new Text("EX");
    TextField Screen = new TextField();
    BorderPane pane = new BorderPane();
    VBox vBox = new VBox(10);
    Button []button = new Button[30];
    protected abstract Stage Show(Stage primaryStage);
    String Prev="",Next="",op="";
    Double result=0.0;
    
    //Prepare Calculator Design in PrepareDesign Function and return This Satge Design
    Stage PrepareDesign(Stage primaryStage)
    {
    StackPane stackPae=new StackPane();
	
	 Screen.setEditable(false);
         Screen.setDisable(true);
	 Screen.setMinHeight(50);
	 Screen.setMinWidth(380);
	 Screen.setPadding(new Insets(10,10,10,10));
	 Screen.setStyle("-fx-background-color: #f9f9f9;");
	 stackPae.getChildren().add(Screen);
	 text.setStyle("fx-margin-left:20;-fx-margin-right:0;-fx-margin-top:0;");
 	 stackPae.getChildren().add(text);
	// Create a border pane
	 pane.setStyle("-fx-background-color: #d0cccc;");
 	 pane.setTop(stackPae);
	 
	   vBox.setPadding(new Insets(15, 5, 5, 5));
	   //vBox.getChildren().add(new Label("Courses"));
	 String [] names = {"PI","Sqrt","Sin","Cos","Tan","X^2","X^","(",")","!","7","8","9","C","Back","4","5","6","X","/","1","2","3","+","-","0",".","%","ans","="};
 int counter=0;
 	for (int i=0;i<6;i++)
	{HBox hBox = new HBox(10);
	  hBox.setPadding(new Insets(0, 0, 0, 5));
     // hBox.setStyle("-fx-background-color: #f9f9f9");
		VBox.setMargin(hBox, new Insets(0, 0, 0, 5));
	   vBox.getChildren().add(hBox);
		 
           for(int j=0;j<5;j++) 
		 {button[counter] = new Button(names[counter]);
		  button[counter].setMinWidth(40);
		  button[counter].setMinHeight(30);
                  button[counter].setStyle("-fx-background-radius:30");
 		  hBox.getChildren().add(button[counter]);
                   
                      counter++;
 		 }
	}
      
      
 
                 
	pane.setCenter(vBox);
        Scene scene =new Scene(pane);
	 primaryStage.setTitle("Calculator");  
	  primaryStage.setScene(scene);  
	  primaryStage.setMaxHeight(360);
	  primaryStage.setMaxWidth(285);
	  primaryStage.setMinHeight(360);
	  primaryStage.setMinWidth(285);
          return primaryStage;
    }
   
}
