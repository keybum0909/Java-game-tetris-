package tetrisblocks;

import tetris.TetrisBlock;

public class SShape extends TetrisBlock{
    public SShape(){
        super( new int[][]{ {1, 0},
                          {1, 1},
                          {0, 1} });
    }
    public void rotation(){
        super.rotate();
        
        if(this.getWidth() == 1){
            this.setX(this.getX() + 1);
            this.setY(this.getY() - 1);
        }else{
            this.setX(this.getX() - 1);
            this.setY(this.getY() + 1);
        }
    }
}
