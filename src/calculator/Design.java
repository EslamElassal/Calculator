package calculator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public abstract class Design extends Application{
//abstract Function Show used in Instance Class From Design Class To Call PrepareDesign Function 
    static Text text = new Text("");
    static  Stack<Float> values = new Stack<Float>();
    static  Stack<Float> results = new Stack<Float>();
    static   Stack<Character> ops = new Stack<Character>();
    TextField Screen = new TextField();
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
         Screen.setDisable(true);
	 Screen.setMinHeight(50);
	 Screen.setMinWidth(380);
        
	 Screen.setPadding(new Insets(10,10,10,10));
	 Screen.setStyle("-fx-background-color: #f9f9f9;-fx-text-align:right;");
	 stackPae.getChildren().add(Screen);
	 text.setStyle("fx-margin-left:20;-fx-margin-right:0;-fx-margin-top:0;");
 	 stackPae.getChildren().add(text);
	// Create a border pane
	 pane.setStyle("-fx-background-color: #d0cccc;");
 	 pane.setTop(stackPae);
	 
	   vBox.setPadding(new Insets(15, 5, 5, 5));
	   //vBox.getChildren().add(new Label("Courses"));
	 String [] names = {"p","r","sin","cos","tan","X^2","X^","(",")","!","7","8","9","C","B","4","5","6","*","/","1","2","3","+","-","0",".","%","ans","="};
 int counter=0;
 	for (int i=0;i<6;i++)
	{HBox hBox = new HBox(10);
	  hBox.setPadding(new Insets(0, 0, 0, 5));
     // hBox.setStyle("-fx-background-color: #f9f9f9");
		VBox.setMargin(hBox, new Insets(0, 0, 0, 5));
	   vBox.getChildren().add(hBox);
		 //create number buttons
           for(int j=0;j<5;j++) 
		 {button[counter] = new Button(names[counter]);
		  button[counter].setMinWidth(40);
		  button[counter].setMinHeight(30);
                  button[counter].setStyle("-fx-background-radius:30");
 		  hBox.getChildren().add(button[counter]);
                  if(counter==10||counter==11||counter==12||counter==16||counter==17||counter==15||counter==21||counter==22||counter==20)
                          ScreenPrint(button[counter], names[counter]);  
                 
                      counter++;    
 		 }
	}
//create operators and job functions   
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
Factorial(button[9], names[9]);
OPen_Arc(button[7], names[7]);
Closed_Arc(button[8], names[8]);
ans(button[28],names[28]);
Equal(button[29],names[29]);
percent(button[27],names[27]);
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
    //to draw numbers in perfect way at screen except zero and decimal point
protected Button ScreenPrint(Button button,String str)
    {   
        button.setOnAction(e->{
            text.setText("");
            if(Prev.equals("|"))
                Screen.setText("");
            
            Prev=Screen.getText();
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
                else  if(CharArr[0]=='0'&&!(Prev.contains("+")||Prev.contains("-")||Prev.contains("*")||Prev.contains("/")))
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
            {              Prev=Prev+str;
Screen.setText(str);}   
        });
      
    return button;
    }
 //to draw zero in perfect way at screen
protected Button ScreenPrint0(Button button,String str)
    { 
        button.setOnAction(e->{
            text.setText("");
            if(Prev.equals("|"))
                Screen.setText("");
           Prev=Screen.getText();
          
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
          
           
           
        });
      
    return button;
    }
 //to draw decimal point in perfect way at screen
protected Button ScreenPrintdot(Button button,String str)
{        button.setOnAction(e->{
    text.setText("");
    if(Prev.equals("|"))
                Screen.setText("0");
           Prev=Screen.getText();
                          char arr []=Prev.toCharArray();

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
     {text.setText("Error");
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
            
              
     }else if(arr[arr.length-1]==')'||arr[arr.length-1]=='p'||arr[arr.length-1]=='r')
     {text.setText("Error");}
                           else{
                Prev=Prev+str;
            Screen.setText(Prev);}}
            }
            else
            {Screen.setText(str);}
          
           
          
        });
      
    return button;
    }
 //to draw '+' plus operator and its previous and next numbers in perfect way at screen
protected Button Add(Button button ,String str)
{ 
    button.setOnAction(e->{text.setText("");
    if(Prev.equals("|"))
                Screen.setText(ans);
       Prev=Screen.getText();
 char[]CharArr=Prev.toCharArray();
     int expLen = CharArr.length;
   if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/'||CharArr[expLen-1]=='(')
   {
   text.setText("Error");
   }
   else
   {
   Prev=Prev+"+";
   Screen.setText(Prev);
    }       
});
   
return button;
}
//to draw '-' subtraction operator and its previous and next numbers in perfect way at screen
protected Button Sub(Button button ,String str)
{button.setOnAction(e->{text.setText("");
if(Prev.equals("|"))
                Screen.setText(ans);
       Prev=Screen.getText();
 char[]CharArr=Prev.toCharArray();
     int expLen = CharArr.length;
   if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/')
   {
   text.setText("Error");
   }
   else
   {
   Prev=Prev+"-";
   Screen.setText(Prev);
    }       
});
return button;
}
//to draw '*' multiplication operator and its previous and next numbers in perfect way at screen
protected Button Mul(Button button ,String str)
{button.setOnAction(e->{text.setText("");
if(Prev.equals("|"))
                Screen.setText(ans);
       Prev=Screen.getText();
 char[]CharArr=Prev.toCharArray();
     int expLen = CharArr.length;
   if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/'||CharArr[expLen-1]=='(')
   {
   text.setText("Error");
   }
   else
   {
   Prev=Prev+"*";
   Screen.setText(Prev);
    }       
});
return button;
}
//to draw '/' div operator and its previous and next numbers in perfect way at screen
protected Button Div(Button button ,String str)
{button.setOnAction(e->{text.setText("");
if(Prev.equals("|"))
                Screen.setText(ans);
       Prev=Screen.getText();
 char[]CharArr=Prev.toCharArray();
     int expLen = CharArr.length;
   if(CharArr[expLen-1]=='+'||CharArr[expLen-1]=='-'||CharArr[expLen-1]=='*'||CharArr[expLen-1]=='/'||CharArr[expLen-1]=='(')
   {
   text.setText("Error");
   }
   else
   {
   Prev=Prev+"/";
   Screen.setText(Prev);
    }       
});
return button;
}
//to clear the screen of calculator and 'ans'(last value calculated) value
protected void Clear(Button button, String name) {
button.setOnAction(e->{
text.setText("");  
Screen.clear();
Prev="";
ans="0";
Screen.setText("0");
});
    }
//to clear screen one char only and not has any effects on 'ans' (last value calculated) value 
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
//to draw 'p' PI  constant and its previous and next numbers or operators in perfect way at screen
protected void PI(Button button , String name)     
{ 
button.setOnAction(e->{
      text.setText("");
      if(Prev.equals("|"))
                Prev="";
            char arr[]=Prev.toCharArray();
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
   text.setText("Error");
 }
});
}
//to draw 'r' Square root  operator and its previous and next numbers or operators in perfect way at screen
protected void Sqrt(Button button , String name)     
{
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
               Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(r0)";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   text.setText("Error");
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
  {    Prev="(r"+Prev+")";
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
                 Prev=Prev+"(r"+exp+")";

            else
     Prev=Prev+"(r"+exp+")";
 Screen.setText(Prev);
  }
        }
 
 
});
}
//to draw '^ 2'   operator and its previous and next numbers or operators in perfect way at screen
protected void Up_2(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
     if(Prev.equals("|"))
               Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(0^2)";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   text.setText("Error");
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
 
 
});
}
//to draw '^ n' operator and its previous and next numbers or operators in perfect way at screen
protected void Up_N(Button button , String name)     
{ button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
     if(Prev.equals("|"))
                Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(0^";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   text.setText("Error");
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
 
 
});
}
//to draw 'sin' function and its previous and next numbers or operators in perfect way at screen
protected void Sin(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
     if(Prev.equals("|"))
               Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(s(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {       text.setText("Error");
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
 
 
});
}
//to draw 'cos' function and its previous and next numbers or operators in perfect way at screen
protected void Cos(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
               Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(c(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {       text.setText("Error");
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
 
 
});
}
//to draw 'tan' function and its previous and next numbers or operators in perfect way at screen
protected void Tan(Button button , String name)     
{ 
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
                Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(t(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {       text.setText("Error");
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
 
 
});
}
//to draw 'factorial' function and its previous and next numbers or operators in perfect way at screen
protected void Factorial(Button button , String name)     
{ button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(!(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   text.setText("Error");
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
 
 
});
}
//to draw '(' open arc operator and its previous and next numbers or operators in perfect way at screen
protected void OPen_Arc(Button button , String name)     
{ 
button.setOnAction(e->{
      text.setText("");
            char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null)||Prev.equals("0"))
      {    if(Prev.equals("0"))
      { Prev="(";
       Screen.setText(Prev);}
      else{
          Prev=Prev+"(";
       Screen.setText(Prev);
              }
  }
      else if(arr[arr.length-1]=='*'||arr[arr.length-1]=='/'||arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')          
 {
 
     Prev=Prev+"(";
 Screen.setText(Prev);}
 
 else
 {
      text.setText("Error");

 }
});
}
//to draw ')' closed arc operator and its previous and next numbers or operators in perfect way at screen
protected void Closed_Arc(Button button , String name)     
{ 
button.setOnAction(e->{
      text.setText("");
      int closed=0,open=0;
            char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      {       text.setText("Error");

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
               {       text.setText("Error");

               }
 }
 else if(open==closed)
 {   text.setText("Error");
}
    }
 
 else
 {
       text.setText("Error");

 }
});
}
//to enhancement screen arcs '( )' operator and its previous and next numbers or operators in perfect way at screen and calculate screen expression value by call function 'evaluate'
protected void Equal (Button button,String name)
{
button.setOnAction(e->{
      text.setText("");
String alt="";boolean flag=true;
int closed=0,open=0;
char operand;
Prev=Screen.getText();
char[]equal=Prev.toCharArray();
for(int i=0;i<equal.length;i++)
{
    if(equal[equal.length-1]=='+'||equal[equal.length-1]=='-'||equal[equal.length-1]=='*'||equal[equal.length-1]=='/'||equal[equal.length-1]=='^'||equal[equal.length-1]=='(')
    {text.setText("Error");}
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
if(equal[i]=='+'||equal[i]=='-'||equal[i]=='*'||equal[i]=='/'||equal[i]=='^'||equal[i]=='!'||equal[i]=='r'||equal[i]=='%'||equal[i]=='c'||equal[i]=='s'||equal[i]=='t'||equal[i]=='('||equal[i]==')')
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
{alt=alt+equal[i];flag=true;
if(i==equal.length-1)
alt=alt+" ";}
    }

equal=alt.toCharArray();
ans=evaluate(equal)+"";
    text.setText(ans+"");
    Prev="|";
    
/*for(int i=0;i<equal.length;i++)
{
    if(equal[i]=='+'||equal[i]=='-'||equal[i]=='*'||equal[i]=='/'||equal[i]=='^'||equal[i]=='!'||equal[i]=='r'||equal[i]=='%'||equal[i]=='c'||equal[i]=='s'||equal[i]=='t'||equal[i]=='n'||equal[i]=='a'||equal[i]=='i'||equal[i]=='o')
//push to stacks
    {
    op.push(equal[i]+"");
     }
    else if((equal[i]=='('||equal[i]==')'||equal[i]=='p')){
    if(equal[i]=='p')
        num.push(Math.PI+"");
    else
        num.push(equal[i]+"");
    //if((!cat.equals(null)||!cat.equals(""))&&flag)
      //  num.push(cat+"");
    }
    else{
    cat=cat+equal[i];
    if(equal.length-1==i)
        num.push(cat+"");
    else if(equal[i+1]==')'||equal[i+1]=='+'||equal[i+1]=='-'||equal[i+1]=='*'||equal[i+1]=='/'||equal[i+1]=='^'||equal[i+1]=='!'||equal[i+1]=='r'||equal[i+1]=='('||equal[i+1]=='%'||equal[i+1]=='c'||equal[i+1]=='s'||equal[i+1]=='t'||equal[i+1]=='n'||equal[i+1]=='a'||equal[i+1]=='i'||equal[i+1]=='o')
    { num.push(cat+"");
    cat="";}
    }
     
}
cat="x";
System.out.println(cat+"c");
cat="d";
/*while(num.size()>1)
{

    if(num.get(num.size()-1).equals(")"))
    {
    
    }
    if(!(num.get(num.size()-1).equals("(")||num.get(num.size()-2).equals("(")))
    {
    operand=op.pop().charAt(0);
    double number=Double.parseDouble(num.pop());
    switch(operand)
    {
        case '+':num.push((Double.parseDouble(num.pop())+number)+"");break;
        case '-':num.push((Double.parseDouble(num.pop())-number)+"");break;
        case '*':num.push((Double.parseDouble(num.pop())*number)+"");break;
        case '/':num.push((Double.parseDouble(num.pop())/number)+"");break;
    }
    }
    
}*/
    
});
}

//to screen expression value
public static float evaluate(char []tokens)
    {  char prevchar = 0;
    boolean flag=false;
         // Stack for numbers: 'values'
       int num=0; 
 
        for (int i = 0; i < tokens.length; i++)
        {if(tokens[i]=='%')num=i;
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 //"p","r"
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
                   if(ops.peek()=='\u221a'||ops.peek()=='c'||ops.peek()=='s'||ops.peek()=='t'||ops.peek()=='!'||ops.peek()=='%')
                    {
                       values.push(applyOp(ops.pop(), '|', values.pop(),num,tokens));
                       results.push(10f);
                    }
                    
                   else{  values.push(applyOp(ops.pop(), values.pop(), values.pop(),num,tokens));results.push(10f);}
                
                }
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||tokens[i]=='r'||tokens[i]=='%'||
                     tokens[i] == '*' || tokens[i] == '/'||tokens[i] == '^'||tokens[i]=='c'||tokens[i]=='s'||tokens[i]=='t'||tokens[i]=='!')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                if(tokens[i+1]==' ')
                {
                     while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                { 
                    values.push(applyOp(ops.pop(), values.pop(), values.pop(),num,tokens));results.push(10f);}
                    
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
            values.push(applyOp(ops.pop(), values.pop(), values.pop(),num,tokens));
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
public static float applyOp(char op, float b, float a,int index,char tokens[])
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
           text.setText("Math Error");
           }
           // return a / b;
            case '^':
                double a1=(double)a;
                double b1=(double)b;
                return (float) Math.pow(a1, b1);
                case '\u221a':
                double a11=(double)a;
                return (float) Math.sqrt(a11);
                 case '%':
                     if(results.empty()&&values.size()!=1)
                     {
                
                return (float) (a)/100;}
                     else 
                     {
                       float a10=a/100;
                         
                       a10=a10*(percent_num(tokens, index));
                return (float) a10;
                     }
               
                case 's':
                double a12=(double)a;
                return (float)  Math.sin(Math.toRadians(a12));
                case 'c':
                double a13=(double)a;
                return (float) Math.cos(Math.toRadians(a13));
                case 't':
                double a14=(double)a;
                if(a14==90)
                {text.setText("Invalid");
                    return 3/0;}
                else
                return (float)  Math.tan(Math.toRadians(a14));
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
//to save the last value calculated in 'ans' variable and return it later when we need it
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
   text.setText("Error");
 }
});

}
//to calculte factorial value
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
//to draw'%' operator and its previous and next numbers or operators in perfect way at screen 
protected void percent(Button button ,String name )
{
button.setOnAction(e->{
    boolean flag=true;//for not duplicate ()
    text.setText("");
    if(Prev.equals("|"))
               Prev=ans;
    int open=0,closed=0;
    char arr[]=Prev.toCharArray();
      if(Prev.equals("")||Prev.equals(null))
      { Prev="(%(0))";
     Screen.setText(Prev);}
      else if(arr[arr.length-1]=='+'||arr[arr.length-1]=='-'||arr[arr.length-1]=='/'||arr[arr.length-1]=='*'||arr[arr.length-1]=='('||arr[arr.length-1]=='^')
      {   
   text.setText("Error");
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
  {    Prev="(%("+Prev+"))";
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
                 Prev=Prev+"(%("+exp+"))";

            else
     Prev=Prev+"(%("+exp+"))";
 Screen.setText(Prev);
  }
        }
 
 
});

}
protected static float percent_num(char [] tokens,int index)
{
float num=0f;
  Stack<Float> val = new Stack<Float>();
for(int j=index;j>=0;j--)
{    

if(tokens[j]=='+'||tokens[j]=='-'||tokens[j]=='*'||tokens[j]=='/'||tokens[j]=='^')
{
    for(int i=j;i>=0;i--)
 if ((tokens[i] >= '0' && tokens[i] <= '9')||tokens[i]=='.'||tokens[i]=='p'||tokens[i]=='~')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                
                while ((i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9'))||tokens[i]=='.'||tokens[i]=='p'||tokens[i]=='~'||tokens[i]=='-')
                {  /* if(flag)
                {sbuf.append(prevchar+"");
                flag =false;}*/
                    if(tokens[i]=='p')
                {sbuf.append(Math.PI);i--;}
                    else if(tokens[i]=='~')
                {sbuf.append(ans);i--;}
                    else
                    sbuf.append(tokens[i--]);
                if(i<0)
                    break;
                }
                val.push(Float.parseFloat(sbuf.reverse().toString()));
               j=-1;
                break;
               
            }
}
}
return num=val.pop();
}
}
