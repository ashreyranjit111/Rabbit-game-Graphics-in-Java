import javax.tools.Tool;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Cell extends Rectangle {


    Color c; //color shades for the RGB colors
    int a; //variable for color green

    public Cell(int x, int y) {
        super(x, y, 35, 35);
        a=(int)(Math.random()*(255-100)+100); //setting random range for the color green
         c = new Color((int)(Math.random()*30), (int)(a), (int)(Math.random()*30)); //setting c as the color of the cells
    }


    public void paint(Graphics g, Boolean highlighted) {

        g.setColor(c);  //setting color for the background of the cell //initializing it inside paint so it repaints a new random set of pattern eac it is run
        g.fillRect(x, y, 35, 35);//setting the cell location and size
        g.drawRect(x, y, 35, 35); // drawing the cells
        g.setColor(Color.black);//setting color or the boarders of the cell black
        g.drawRect(x, y, 35, 35);//drawing the boarders of the cell

        //creating a highlight on the cell the mouse is positioned at
        if (highlighted) {
            g.setColor(Color.white);
            g.drawRect(x,y, 34, 34); //this is to make the higlited box to be visible so the cell does't overlap it
        }
    }

    //making the tool tip
    public void ToolTip(Graphics tt, Boolean highlighted)
    {
       if(highlighted){
           tt.setColor(Color.orange);
           tt.fillRect( x + 35, y+ 35, 80, 30);
           tt.setColor(Color.black);

           //this is to display the shade of the color green preset in the cell eg: (grass: 3)
           tt.setFont(new Font("ToolTip", Font.BOLD, 20));
           tt.drawString("grass: " + a / 50,  x + 35, y + 55);
        }
    }



@Override
    public boolean contains(Point target){
       if (target == null){
            return false;
        }
        return super.contains(target);
    }
}
