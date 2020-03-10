import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Main extends JFrame implements Runnable {

Point mousePosition;
int time =0; //to store the time the mouse position is stationary

    private class Canvas extends JPanel {

        private Grid grid;
        Point mousePosition;

        //creating our window for the task
        public Canvas() {
            setPreferredSize(new Dimension(1280, 720)); //size of the window
            grid = new Grid(10, 10);
            mousePosition = getMousePosition();
        }

        //setting up the time interval or delay time before th tool tip pops up in the screen approximately 3 seconds
        @Override
        public void paint(Graphics g)
        {
            grid.paint(g, getMousePosition());

            Point currentPosition = getMousePosition(); // to store the currentposition of the mouse
            if (getMousePosition() == null || currentPosition == null) return;
            if (currentPosition.equals(mousePosition))
            {
                time = time + 1; //for each paint if mouse position is stationary increment timer by 1
            }
            else
            {
                mousePosition = currentPosition; // make the new position of the mouse the new current position for further comparision
                time = 0; // if mouse position is changed reset te timer
            }


            //setting the timer to be approximately 3 seconds
            // draw the tool tip
            if (currentPosition.equals(getMousePosition()) && time>=300)
            {
                grid.drawTooltip(g, mousePosition); //drawing the tool tip at the cell where the mouse is positioned
            }
        }
    }

    public static void main(String[] args) {
        Main window = new Main();
        window.run();

    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Canvas());
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            this.repaint();
        }
    }

}
