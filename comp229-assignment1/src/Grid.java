import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;

public class Grid {

    private Cell[][] cells  = new Cell[20][20];;

    private int x;
    private int y;
    int a;
    Color c;


    public Grid(int x, int y) {
        this.x = x;
        this.y = y;

        a=(int)(Math.random()*(255-100)+100); //setting random range for the color green
        c = new Color((int)(Math.random()*30), (int)(a), (int)(Math.random()*30)); //setting c as the color of the cells

        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                cells[i][j] = new Cell(x + j * 35, y + i * 35);
            }
        }
    }

    //this is to draw the tool tip in the cell the mouse is positioned at for approximatly 3 seconds
    public void drawTooltip(Graphics g, Point mousePosition) {
        for (int y = 0; y < 20; ++y) {
            for (int x = 0; x < 20; ++x) {
                Cell thisCell = cells[x][y];
                thisCell.ToolTip(g, thisCell.contains(mousePosition));
            }
        }

    }


    public void paint(Graphics g, Point mousePosition){

        // Painting the Cells
        for (int y = 0; y < 20; ++y) {
            for (int x = 0; x < 20; ++x) {
                Cell thisCell = cells[x][y];
                thisCell.paint(g, thisCell.contains(mousePosition));

            }
        }
    }
        //Painting ToolTip
       //for (int y = 0; y < 20; ++y) {
         //   for (int x = 0; x < 20; ++x) {
           //     Cell thisCell = cells[x][y];
             //   thisCell.ToolTip(g, thisCell.contains(mousePosition));
               // }
           //}


    }


