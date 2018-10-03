package finalproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border.*;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FinalProjectMain
{

   public static void main( String args[] )
   {
       //ADD CODE HERE:
       //     -Create the following objects using 'new':
       //       i. A MainWindow object called ‘yourWindow’.
       MainWindow yourWindow = new MainWindow();
       //       ii. A MyButton object called ‘yourButton’.
       MyButton yourButton = new MyButton();
       //       iii. A JtextArea object called ‘yourTextArea’ that starts empty, has 30 columns and 1 row.
       JTextArea yourTextArea = new JTextArea();
       yourTextArea.setRows(1);
       yourTextArea.setColumns(30);
       //       iv. A MakeRequest object called ‘yourRequest’.
       MakeRequest yourRequest = new MakeRequest();
       
       int startTags = 0;
       int lowerAs = 0;
       
       
       //   -Add a mouse listener to yourButton using .addMouseListener()
       //   -Pass .addMouseListener() an anonymous inner class that extends MouseAdapter and implements mouseReleased()
       //   -In mouseReleased():
       //       -In mouseReleased(), pass the text in yourTextArea, using the .getText() method, to the .requestHTML() of the yourRequest 
       //       object and place the resulting string containing the HTML into a string variable.
       yourButton.addMouseListener(
              new MouseAdapter() {
                 public void mouseReleased(MouseEvent e) {
                    yourRequest.requestHTML(yourTextArea.getText());
                    
                    for (int i = yourTextArea.indexOf("a"); i >= 0; i = yourRequest.htmlCode.indexOf("a", i + 1))
                    {
                        lowerAs++;
                    }
                    for (int i = yourRequest.htmlCode.indexOf("<html>"); i >= 0; i = yourRequest.htmlCode.indexOf("<html>", i + 1)) 
                    {
                       startTags++;
                    }

                    yourTextArea.append("Number of lower case A's are: " + lowerAs +
                            "\nNumber of start tags are: " + startTags);
                 }
              });
       //       -In mouseReleased(), use a loop to find how many lowercase ‘a’s appear in the HTML and how many ‘<html’ tags appear in the HTML 
       //       (NOTE: do not include the close ‘>’ in your search string). You can use the .substring() method to take sub strings of the HTML 
       //       and compare them to test strings using .equals() (NOTE: you CANNOT use == to compare strings in this context). You may need to 
       //       use an if statement to check that you are not using .substring() passed the end of the HTML string.
       
       //       -Pass the .setText() from yourTextArea a string that contains the a readout describing how many a’s were in the HTML and how 
       //       many HTML start tags were in the HTML.
       
      //This code places the GUI elements in window and updates the window.
      //You may comment them out until you define yourButton and yourWindow
      yourWindow.myAdd(yourButton);
      yourWindow.myAdd(yourTextArea);
      yourWindow.update();      
   }
}
