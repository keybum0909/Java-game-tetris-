package tetris;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock {
    private int[][][][] allShapes = {
        //I-Shape
        {
           //0 degree
            {
                {1},
                {1},
                {1},
                {1}
,            },
            //90 degrees
            {
                {1, 1, 1, 1}
            },
            //180 degrees
            {
                {1},
                {1},
                {1},
                {1}
            },
            //270 degrees
            {
                {1, 1, 1, 1}
            }
        },
        //J-Shape
        {
           //0 degree
            {
                {0, 1},
                {0, 1},
                {1, 1}
            },
            //90 degrees
            {
                {1, 0, 0},
                {1, 1, 1}
            },
            //180 degrees
            {
                {1, 1},
                {1, 0},
                {1, 0}
            },
            //270 degrees
            {
                {1, 1, 1},
                {0, 0, 1}
            } 
        },
        //L-Shape
        {
           //0 degree
            {
                {1, 0},
                {1, 0},
                {1, 1}
            },
            //90 degrees
            {
                {1, 1, 1},
                {1, 0, 0}
            },
            //180 degrees
            {
                {1, 1},
                {0, 1},
                {0, 1}
            },
            //270 degrees
            {
                {0, 0, 1},
                {1, 1, 1}
            } 
        },
        //O-Shape
        {
           //0 degree
            {
                {1, 1},
                {1, 1}
            },
            //90 degrees
            {
                {1, 1},
                {1, 1}
            },
            //180 degrees
            {
                {1, 1},
                {1, 1}
            },
            //270 degrees
            {
                {1, 1},
                {1, 1}
            } 
        },
        //S-Shape
        {
           //0 degree
            {
                {1, 0},
                {1, 1},
                {0, 1}
            },
            //90 degrees
            {
                {0, 1, 1},
                {1, 1, 0}
            },
            //180 degrees
            {
                {1, 0},
                {1, 1},
                {0, 1}
            },
            //270 degrees
            {
                {0, 1, 1},
                {1, 1, 0}
            } 
        },
        //T-Shape
        {
           //0 degree
            {
                {1, 1, 1},
                {0, 1 ,0}
            },
            //90 degrees
            {
                {0, 1},
                {1, 1},
                {0, 1}
            },
            //180 degrees
            {
                {0, 1, 0},
                {1, 1, 1}
            },
            //270 degrees
            {
                {1, 0},
                {1, 1},
                {1, 0}
            } 
        },
        //Z-Shape
        {
           //0 degree
            {
                {1, 1, 0},
                {0, 1, 1}
            },
            //90 degrees
            {
                {0, 1},
                {1, 1},
                {1, 0}
            },
            //180 degrees
            {
                {1, 1, 0},
                {0, 1, 1}
            },
            //270 degrees
            {
                {0, 1},
                {1, 1},
                {1, 0} 
            } 
        }
    };
    
    private int[][] shape;
    private Color color;
    private int x, y;
    private int[][][] shapes;
    private int currentRotation;
    
    private Color[] availableColors = {Color.GREEN, Color.RED, Color.BLUE, 
                                   Color.CYAN, Color.MAGENTA, Color.ORANGE, 
                                   Color.PINK, Color.LIGHT_GRAY, Color.YELLOW};
    
    public TetrisBlock(int[][] shape){
        this.shape = shape;
        initShapes();
    }
    
    private void initShapes(){
        shapes = new int[4][][];
        for(int i = 0; i < 4; i++){
            int r = shape[0].length;
            int c = shape.length;
            
            shapes[i] = new int[r][c];
            
            for(int y = 0; y < r; y++){
                for(int x = 0; x < c; x++){
                    shapes[i][y][x] = shape[c - x - 1][y];
                } 
            }
            shape = shapes[i];
        }
    }
    
    public void spawn(int gridWidth){
       Random r = new Random();
       
       currentRotation = r.nextInt( shapes.length );
       shape = shapes[currentRotation];
       
       y = -getHeight();
       x = r.nextInt( gridWidth - getWidth() );
        
       color = availableColors[r.nextInt( availableColors.length )];
    }
    
    public int[][] getShape(){ return shape; }
    
    public Color getColor(){ return color; }
    
    public int getHeight(){ return shape.length; }
    
    public int getWidth(){ return shape[0].length; }
    
    public int getX(){ return x; }
    
    public void setX(int newX){ x = newX; }
    
    public int getY(){ return y; }
    
    public void setY(int newY){ y = newY; }
    
    public void moveDown(){ y++; }
        
    public void moveRight(){ x++; }
    
    public void moveLeft(){ x--; }
    
    public void rotate() {
        currentRotation++;
        if(currentRotation > 3) currentRotation = 0;
        shape = shapes[currentRotation];
    }

    public int getBottomEdge(){ return y + getHeight(); }
    
    public int getLeftEdge(){ return x; }
    
    public int getRightEdge(){ return x + getWidth(); }

}
