package calculator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public abstract class Design extends Application{
//abstract Function Show used in Instance Class From Design Class To Call PrepareDesign Function 
    static  Text text = new Text("");
    static  Stack<Float> values = new Stack<Float>();
    static  Stack<Float> results = new Stack<Float>();
    static  Stack<Character> ops = new Stack<Character>();
    static  TextField Screen = new TextField();
    BorderPane pane = new BorderPane();
    VBox vBox = new VBox(10);
    Button []button = new Button[30];
    protected abstract Stage Show(Stage primaryStage);
    String Prev="";
    static String ans="0";
    Double result=0.0;
    Stack<String>op = new Stack<>();
    Stack<String>num = new Stack<>();
     //1+(9*(89/2)
     //Prepare Calculator Design in PrepareDesign Function and return This Satge Design
    Stage PrepareDesign(Stage primaryStage)
    {
       StackPane stackPae=new StackPane();
	   Screen.setText("0");
	   Screen.setEditable(false);
      // Screen.setDisable(true);
	   Screen.setMinHeight(100);
	  
        //	 Screen.setMinWidth(380);
	   Screen.setPadding(new Insets(10,10,10,10));
	   Screen.setStyle("-fx-font-size:20pt; -fx-font-weight:bold;-fx-text-fill: white; -fx-base:#005f6b;;-fx-border-color:cyan;-fx-border-radius:10;");
	   stackPae.getChildren().add(Screen);
	 //  text.setStyle("fx-margin-left:20;-fx-margin-right:0;-fx-margin-top:0;");
 	   stackPae.getChildren().add(text);
	    // Create a border pane
       pane.setStyle("  -fx-base:#005f6b;;-fx-border-radius:20;");
 	   pane.setTop(stackPae);

       vBox.setPadding(new Insets(15, 5, 5, 5));
       //vBox.getChildren().add(new Label("Courses"));
	   String [] names = {"p","r","s","c","t","X^2","X^","(",")","!","7","8","9","Clear","Back","4","5","6","*","/","1","2","3","+","-","0",".","%","ans","="};
         	   String [] name = {"PI","Sqrt","Sin","Cos","Tan","X^2","X^","(",")","!","7","8","9","Clear","Back","4","5","6","*","/","1","2","3","+","-","0",".","%","ans","="};

           int counter=0;
   for (int i=0;i<6;i++)
	{
 		HBox hBox = new HBox(10);

	    hBox.setPadding(new Insets(0, 0, 0, 5));
         // hBox.setStyle("-fx-background-color: #f9f9f9");
		VBox.setMargin(hBox, new Insets(0, 0, 0, 5));
	    vBox.getChildren().add(hBox);

           for(int j=0;j<5;j++) 
		 {
        	   button[counter] = new Button(name[counter]);
        	   button[counter].setMinWidth(50);
		       button[counter].setMinHeight(50);
 		       hBox.getChildren().add(button[counter]);
               if(counter==10||counter==11||counter==12||counter==16||counter==17||counter==15||counter==21||counter==22||counter==20)
               ScreenPrint(button[counter], names[counter]);  
               button[counter].setStyle("-fx-font-size:11pt;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;  -fx-base:#008c9e;");
              //button[counter].setStyle("-fx-font-size:11pt;-fx-font-weight:bold;-fx-background-radius:15;");

               button[counter].prefHeightProperty().bind(vBox.heightProperty().divide(6));
    		   button[counter].prefWidthProperty().bind(vBox.widthProperty().divide(5));
               counter++;

 		 }

	}
   button[0].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[1].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[2].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[3].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[4].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[5].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[6].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[7].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[8].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[9].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[14].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[19].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[29].setStyle("-fx-font-size:11pt;    -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[24].setStyle("-fx-font-size:11pt;   -fx-base:#263959;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");

   ///////////column2
   button[13].setStyle("-fx-font-size:11pt;  -fx-base:#79bd9a;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");   
   button[18].setStyle("-fx-font-size:11pt;  -fx-base:#79bd9a;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[23].setStyle("-fx-font-size:11pt;  -fx-base:#79bd9a;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");
   button[28].setStyle("-fx-font-size:11pt;  -fx-base:#79bd9a;-fx-text-fill: white; -fx-font-weight:bold;-fx-background-radius:10;");



ScreenPrint0(button[25], names[25]);
ScreenPrintdot(button[26], names[26]);
Add(button[23], names[22]);
Sub(button[24], names[24]);
Mul(button[18], names[18]);
Div(button[19], names[19]);
Clear(button[13],names[13]); 
BackSpace(button[14],names[14]); 
PI(button[0],names[0]);
Sqrt(button[1] , names[1]);
Up_2(button[5], names[5]);
Up_N(button[6], names[6]);
Sin(button[2], names[2]);
Cos(button[3], names[3]);
Tan(button[4], names[4]);
P_(button[9], names[9]);
OPen_Arc(button[7], names[7]);
Closed_Arc(button[8], names[8]);
ans(button[28],names[28]);
Equal(button[29],names[29]);
percent(button[27],names[27]);

pane.setCenter(vBox);
   Scene scene =new Scene(pane);
   primaryStage.getIcons().add(new Image("Cal.png"));
   primaryStage.setTitle("Calculator");  
   primaryStage.setScene(scene); 
   // primaryStage.setHeight(400);
  //primaryStage.setWidth(400);

  return primaryStage;
    }
    
    
    
protected Button ScreenPrint(Button button,String str)
    {   
          button.setOnAction(e->{
 
              text.setText("");
              
                     if(Prev.equals("|"))
                         Screen.setText("");
                         Prev=Screen.getText();
                         char limit[]=Prev.toCharArray();
                         if(limit.length<=20)
                         {
                          char[]CharArr;
                     if(!Prev.equals(null)||!Prev.equals(""))
                       {
              
                          String Pre=Prev+str;
                          CharArr=Pre.toCharArray();
                          if(CharArr[0]=='0'&&CharArr[1]=='.'&&!(Prev.contains("+")||Prev.contains("-")||Prev.contains("*")||Prev.contains("/")))
                       {
               
                          Prev=Prev+str;
                          Screen.setText(Prev);
                       }
                       
                          else if(CharArr[0]=='0'&&!(Prev.contains("+")||Prev.contains("-")||Prev.contains("*")||Prev.contains("/")))
                      {
                          String Val[]=Pre.split("0", 0);
                            Prev=Val[1];
                            Screen.setText(Prev);
                      }
                  
                  
                         else
                         {    
                           Prev=Prev+str;
                           Screen.setText(Prev);}
                         }
            
                        else
                         {        
                        	Prev=Prev+str;
                            Screen.setText(str);} }
                     
                        });
      
                        return button;
      
    }
protected Button ScreenPrint0(Button button,String str)
    { 
        button.setOnAction(e->{
            text.setText("");
            if(Prev.equals("|"))
                Screen.setText("");
           Prev=Screen.getText();
          char limit[]=Prev.toCharArray();
                         if(limit.length<=20)
                         {
            if(!Prev.equals(null)||!Prev.equals(""))
            {
              if(Prev.equals("0"))
              { }
              else{
                Prev=Prev+str;
            Screen.setText(Prev);}
            }
            else
            {Screen.setText(str);}
          
                         }
           
        });
      
    return button;
    }
protected Button ScreenPrintdot(Button button,String str)
{        button.setOnAction(e->{
    text.setText("");
    if(Prev.equals("|"))
                Screen.setText("0");
           Prev=Screen.getText();
                          char arr []=Prev.toCharArray();
                          if(arr.length<=20)
                         {
            if(!Prev.equals(null)||!Prev.equals(""))
            {
                
              if(Prev.contains("."))
              {  
              for (int i=arr.length-1;i>=0;i--)
              {
if(arr[i]=='.')
{
for(int j=arr.length-1;j>=i;j--)
{
     if(((arr[j]=='+'||arr[j]=='-'||arr[j]=='*'||arr[j]=='/'||arr[j]=='('||arr[j]=='^'))&&j!=arr.length-1)
              {Prev=Prev+str;
            Screen.setText(Prev);
            i=0;
              break;
               }
     else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='*'||arr[arr.length-1]=='/'||arr[arr.length-1]=='^'||arr[arr.length-1]=='(')
     {
     Prev=Prev+"0"+str;
            Screen.setText(Prev);
            i=0;
              break;
     }else if(arr[arr.length-1]==')'||arr[arr.length-1]=='p')
     {
    	 Screen.setText("Error");
          i=0;
          break;
          
    }
         }
}

              }
              }
              else{
                    if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='*'||arr[arr.length-1]=='/'||arr[arr.length-1]=='^'||arr[arr.length-1]=='(')
     {
     Prev=Prev+"0"+str;
            Screen.setText(Prev);
            
              
     }else if(arr[arr.length-1]==')'||arr[arr.length-1]=='p'||arr[arr.length-1]=='s')
     {
    	 Screen.setText("Error");}
                           else{
                Prev=Prev+str;
            Screen.setText(Prev);}}
            }
            else
            {Screen.setText(str);}
          
           
                         }
        });
      
    return button;
    }
protected Button Add(Button button ,String str)
{ 
    button.setOnAction(e->{text.setText("");
    if( Prev.equals("|"))
        Screen.setText(ans);
        Prev=Screen.getText();
        char[]CharArr=Prev.toCharArray();
        int expLen = CharArr.length;
                          if(CharArr.length<=20)
                         {
    if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/'||CharArr[expLen-1]=='(')
    {
      Screen.setText("Error Expression");
    }
    else
    {
      Prev=Prev+"+";
      Screen.setText(Prev);
     }       }
    });
   
  return button;
}
protected Button Sub(Button button ,String str)
{button.setOnAction(e->{text.setText("");
if(Prev.equals("|"))
                Screen.setText(ans);
       Prev=Screen.getText();
 char[]CharArr=Prev.toCharArray();
     int expLen = CharArr.length;
                          if(CharArr.length<=20)
                         {
   if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/')
   {
   Screen.setText("Error Expression");
   }
   else
   {
   Prev=Prev+"-";
   Screen.setText(Prev);
    }       
                         }
});
return button;
}
protected Button Mul(Button button ,String str)
{button.setOnAction(e->{text.setText("");
if(Prev.equals("|"))
                Screen.setText(ans);
       Prev=Screen.getText();
 char[]CharArr=Prev.toCharArray();
     int expLen = CharArr.length;
                          if(CharArr.length<=20)
                         {
   if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/'||CharArr[expLen-1]=='(')
   {
   Screen.setText("Error Expression");
   }
   else
   {
   Prev=Prev+"*";
   Screen.setText(Prev);
    }       
                         }
});
return button;
}
protected Button Div(Button button ,String str)
{button.setOnAction(e->{text.setText("");
if(Prev.equals("|"))
                Screen.setText(ans);
       Prev=Screen.getText();
 char[]CharArr=Prev.toCharArray();
     int expLen = CharArr.length;
                          if(CharArr.length<=20)
                         {
   if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/'||CharArr[expLen-1]=='(')
   {
   Screen.setText("Error Expression");
   }
   else
   {
   Prev=Prev+"/";
   Screen.setText(Prev);
    }
                         }       
});
return button;
}
protected void Clear(Button button, String name) {
button.setOnAction(e->{
text.setText("");  
Screen.clear();
Prev="";
ans="0";
Screen.setText("0");
});
    }
protected void BackSpace(Button button, String name) {
button.setOnAction(e->{
text.setText("");

char arr[]=Prev.toCharArray();
if(arr.length==1)
{
if(arr[0]=='0')
{}
else
{Prev="0";
    Screen.setText("0");

}
}
else{
String NewPrev="";
for(int i=0;i<arr.length-1;i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
Screen.setText(Prev);
}});
    }
protected void PI(Button button , String name)     
{ 
button.setOnAction(e->{
      text.setText("");
      if(Prev.equals("|"))
                Prev="";
      Prev=Screen.getText();
            char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      { Prev="p";
     Screen.setText(Prev);}
      else if(arr[0]=='0')
      { Prev="p";
 Screen.setText(Prev);}
      else if(arr[arr.length-1]=='*'||arr[arr.length-1]=='/'||arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='^'||arr[arr.length-1]=='('||arr[arr.length-1]!='.'&&(!(arr[arr.length-1]>='0'&&arr[arr.length-1]<='9'))&&arr[arr.length-1]!='p'&&arr[arr.length-1]!=')')          
 {
 
     Prev=Prev+"p";
 Screen.setText(Prev);}
 
 else
 {
   Screen.setText("Error Expression");
 }}
});
}
protected void Sqrt(Button button , String name)     
{
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
                Screen.setText("(r("+ans+"))");
     Prev=Screen.getText();
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(r(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   Screen.setText("Error Expression");
      }
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="(r("+Prev+"))";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"(r("+exp+"))";

            else
     Prev=Prev+"(r("+exp+"))";
 Screen.setText(Prev);
  }
        }
 
                         }
});
}
protected void OP(Button button , String name)     
{text.setText("");
 Prev=Screen.getText();
          if(Prev.endsWith("+")||Prev.endsWith("-")||Prev.endsWith("*")||Prev.endsWith("/"))
             Screen.setText("Error Syntax");
          else
              button.setOnAction(e->{Screen.setText(Prev=Prev+name);});
            
          }
protected void Up_2(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
     if(Prev.equals("|"))
                Screen.setText("("+ans+"^2)");
      Prev=Screen.getText();
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(0^2)";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   Screen.setText("Error Expression");
      }
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="("+Prev+"^2)";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"("+exp+"^2)";

            else
     Prev=Prev+"("+exp+"^2)";
 Screen.setText(Prev);
  }
        }
                         }
 
});
}

protected void Up_N(Button button , String name)     
{ button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
     if(Prev.equals("|"))
                Screen.setText("("+ans+"^");
      Prev=Screen.getText();
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(0^";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   Screen.setText("Error Expression");
      }
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="("+Prev+"^";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"("+exp+"^";

            else
     Prev=Prev+"("+exp+"^";
 Screen.setText(Prev);
  }
        }
                         }
 
});
}
protected void Sin(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
     if(Prev.equals("|"))
                Screen.setText("(s("+ans+"))");
      Prev=Screen.getText();
      char limit[]=Prev.toCharArray();
                         if(limit.length<=20)
                         {
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(s(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {       Screen.setText("Error Expression");
}
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="(s("+Prev+"))";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"(s("+exp+"))";

            else
     Prev=Prev+"(s("+exp+"))";
 Screen.setText(Prev);
  }
        }
 
                         }
});
}
protected void Cos(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
                Screen.setText("(c("+ans+"))");
     Prev=Screen.getText();
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
 
    if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(c(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {       Screen.setText("Error Expression");
}
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="(c("+Prev+"))";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"(c("+exp+"))";

            else
     Prev=Prev+"(c("+exp+"))";
 Screen.setText(Prev);
  }
        }
                         }
 
});
}
protected void Tan(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
                Screen.setText("(t("+ans+"))");
     Prev=Screen.getText();
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(t(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {       Screen.setText("Error Expression");
}
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="(t("+Prev+"))";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"(t("+exp+"))";

            else
     Prev=Prev+"(t("+exp+"))";
 Screen.setText(Prev);
  }
        }
                         }
 
});
}
protected void P_(Button button , String name)     
{ button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
                Screen.setText("(!("+ans+"))");
     Prev=Screen.getText();
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(!(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   Screen.setText("Error Expression");
      }
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="(!("+Prev+"))";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"(!("+exp+"))";

            else
     Prev=Prev+"(!("+exp+"))";
 Screen.setText(Prev);
  }
        }
 
                         }
});
}
protected void OPen_Arc(Button button , String name)     
{ 
button.setOnAction(e->{
      text.setText("");
            char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null)||Prev.equals("0"))
      {    if(Prev.equals("0"))
      { Prev="(";
       Screen.setText(Prev);}
      else{
          Prev=Prev+"(";
       Screen.setText(Prev);
              }
  }
      else if(arr[arr.length-1]=='*'||arr[arr.length-1]=='/'||arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='(')          
 {
 
     Prev=Prev+"(";
 Screen.setText(Prev);}
 
 else
 {
      Screen.setText("Error Expression");

 }
                         }
});
}
protected void Closed_Arc(Button button , String name)     
{ 
button.setOnAction(e->{
      text.setText("");
      int closed=0,open=0;
            char arr[]=Prev.toCharArray();
                          if(arr.length<=20)
                         {
      if(Prev.equals("")||Prev.equals(null))
      {       Screen.setText("Error Expression");

  }
      else if(Prev.contains("("))          
 {
 for(int i=0;i<arr.length;i++)
 {
 if(arr[i]=='(')
     open++;
 else if(arr[i]==')')
     closed++;
 }
 if(open>closed)
 {/* while(open>closed)
 {Prev=Prev+")";
 Screen.setText(Prev); closed++;
}*/
     if(!(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='^'||arr[arr.length-1]=='!'||arr[arr.length-1]=='('))
     {  Prev=Prev+")";
 Screen.setText(Prev); }
     else
               {       Screen.setText("Error Expression");

               }
 }
 else if(open==closed)
 {   Screen.setText("Error Expression");
}
    }
 
 else
 {
       Screen.setText("Error Expression");

 }
                         }
});
}
protected void Equal (Button button,String name)
{
button.setOnAction(e->{
text.setText("");
String alt="";boolean flag=true;
int closed=0,open=0;
char operand;
char[]equal=Prev.toCharArray();
for(int i=0;i<equal.length;i++)
{
    if(equal[equal.length-1]=='+'||equal[equal.length-1]=='-'||equal[equal.length-1]=='*'||equal[equal.length-1]=='/'||equal[equal.length-1]=='^'||equal[equal.length-1]=='(')
    {
    	Screen.setText("Error");}
    else{
        if(equal[i]=='(')
     open++;
    else if(equal[i]==')')
    	
     closed++;
    }
     
}
if(open>closed)
 { while(open>closed)
 {Prev=Prev+")";
 Screen.setText(Prev); closed++;
}
 }
equal=Prev.toCharArray();
for(int i=0;i<equal.length;i++)
{
if(equal[i]=='+'||equal[i]=='-'||equal[i]=='*'||equal[i]=='/'||equal[i]=='^'||equal[i]=='!'||equal[i]=='s'||equal[i]=='%'||equal[i]=='c'||equal[i]=='s'||equal[i]=='t'||equal[i]=='('||equal[i]==')')
{
    if(equal[i]=='-')
    {  if(equal[i-1]=='('||equal[i-1]=='^')
        {
        alt=alt+equal[i];flag=true;
        continue;
        }
    }
   if(flag)
      alt=alt+" ";
      alt=alt+equal[i];
      if(!(i==equal.length-1))
        alt=alt+" ";
      flag=false;
        
}
    
else
 {
	alt=alt+equal[i];flag=true;
    if(i==equal.length-1)
    alt=alt+" ";
    
  }
    
}


equal=alt.toCharArray();
ans=evaluate(equal)+"";
    
//////////////////////////////The answer is ...  
Screen.setText(ans+"");
    Prev="|";
    

});
}
 public static float evaluate(char []tokens)
    {  char prevchar = 0;
    boolean flag=false;
         // Stack for numbers: 'values'
        
 
        for (int i = 0; i < tokens.length; i++)
        {
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 //"Pi","Sqrt"
            // Current token is a number, push it to stack for numbers
            if ((tokens[i] >= '0' && tokens[i] <= '9')||tokens[i]=='.'||tokens[i]=='p'||tokens[i]=='~')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while ((i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9'))||tokens[i]=='.'||tokens[i]=='p'||tokens[i]=='~')
                {   if(flag)
                {sbuf.append(prevchar+"");
                flag =false;}
                    if(tokens[i]=='p')
                {sbuf.append(Math.PI);i++;}
                    else if(tokens[i]=='~')
                {sbuf.append(ans);i++;}
                    else
                    sbuf.append(tokens[i++]);
                
                }
                values.push(Float.parseFloat(sbuf.toString()));
            }
 
            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                {
                   if(ops.peek()=='r'||ops.peek()=='c'||ops.peek()=='s'||ops.peek()=='t'||ops.peek()=='!'||ops.peek()=='%')
                    {
                       values.push(applyOp(ops.pop(), '|', values.pop()));
                       results.push(10f);
                    }
                    
                   else{  values.push(applyOp(ops.pop(), values.pop(), values.pop()));results.push(10f);}
                
                }
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == 'r' ||tokens[i] == '+' || tokens[i] == '-' ||tokens[i]=='s'||tokens[i]=='%'||
                     tokens[i] == '*' || tokens[i] == '/'||tokens[i] == '^'||tokens[i]=='c'||tokens[i]=='s'||tokens[i]=='t'||tokens[i]=='!')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                if(tokens[i+1]==' ')
                {
                     while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                { 
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));results.push(10f);}
                    
                // Push current token to 'ops'.
                ops.push(tokens[i]);}
                else
                {
                prevchar=tokens[i];
                flag=true;
                }
            }
                
            
        }
 
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
            results.push(10f);
        // Top of 'values' contains result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
 public static float applyOp(char op, float b, float a)
    {
        switch (op)
        {
               
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
           try{  
                return a / b;
               }
           catch(ArithmeticException asd)
           {
           Screen.setText("Math Error");
           }
           // return a / b;
            case '^':
                double a1=(double)a;
                double b1=(double)b;
                return (float) Math.pow(a1, b1);
                case 'r':
                double a11=(double)a;
                return (float) Math.sqrt(a11);
                 case '%':
                     if(results.empty()&&values.size()!=1)
                     {
                
                return (float) (a)/100;}
                     else 
                     {
                       float a10=a/100;
                       a10=a10*(values.peek());
                return (float) a10;
                     }
               
                case 's':
                {
                double a12=(double)a;
                double r12=Math.toRadians(a12);
                return (float)  Math.sin(r12);
                
                }
                case 'c':
                {
                double a13=(double)a;
                double r13=Math.toRadians(a13);
                return (float) Math.cos(r13);
                }
                case 't':
                {
                   if(a==90)
                   {  Screen.setText("Stack Overflow");
                       
                   return 3/0;
                        
                   }
                   else
                   {
                double a14=(double)a;
                double r14=Math.toRadians(a14);
                return (float)  Math.tan(r14);
                   }
                }
                 case '!':
                int a15;
        try {
            a15 = fact((int)a);
            return (float) (a15);
        } catch (Exception ex) {
            text.setText(ex.getMessage());
             return 3/0; 
        }
             
                
                 
                
        }
        return 0;
    }
protected void ans (Button button,String name)
{
button.setOnAction(e->{
      text.setText("");
            char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="~";
     Screen.setText(Prev);}
      else if(arr[0]=='0')
      { Prev="~";
 Screen.setText(Prev);}
      else if(arr[arr.length-1]=='*'||arr[arr.length-1]=='/'||arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='^'||arr[arr.length-1]=='('||arr[arr.length-1]!='.'&&(!(arr[arr.length-1]>='0'&&arr[arr.length-1]<='9'))&&arr[arr.length-1]!='p'&&arr[arr.length-1]!='~')          
 {
 
     Prev=Prev+"~";
 Screen.setText(Prev);}
 
 else
 {
   Screen.setText("Error Expression");
 }
});

}
protected static int fact(int x) throws Exception
{int val=1;
if(x>0)
{
for(int i=x;i>0;i--)
{val*=i;}
}
else if(x==0)
val=1;
else
throw new Exception("Error!");

return val;
}
protected void percent(Button button ,String name )
{
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(%0)";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   Screen.setText("Error Expression");
      }
       
else {
          int num = 0;
  for(int i=arr.length-1;i>=0;i--)
      {
      if(arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*'||arr[i]==')')
      { if(arr[i]==')')
      {
      for(int j=i;j>=0;j--)
 {
    
     if(arr[j]=='(')
     open++;
 else if(arr[j]==')')
     closed++;
     if((closed==open)&&open!=0&&closed!=0)
     {num=j;
     i=0;
     flag=false;
     break;
     }}
 }else
  
          num=i;break;}
      }
  
   if(num==0)
  {    Prev="(%"+Prev+")";
 Screen.setText(Prev);
  }
  else
  {
      String exp="" ;
       
      String NewPrev="";
     if(!flag)
         num-=1;
for(int i=0;i<(arr.length-(arr.length-(num+1)));i++)
    NewPrev=NewPrev+arr[i];
Prev=NewPrev;
        for(int i=num+1;i<arr.length;i++)
          exp=exp+arr[i];
        if(!flag)
                 Prev=Prev+"(%"+exp+")";

            else
     Prev=Prev+"(%"+exp+")";
 Screen.setText(Prev);
  }
        }
 
 
});

}
}

