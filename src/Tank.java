import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private static int x, y;
    private static final int SPEED = 5;
    private static Dir dir;
    private static boolean bL,bR,bU,bD;


    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50 );
        move();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getExtendedKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
//                x -= SPEED;
//                dir = Dir.L;
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
//                x += SPEED;
//                dir = Dir.R;
                bR = true;
                break;
            case KeyEvent.VK_UP:
//                y -= SPEED;
//                dir = Dir.U;
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
//                y += SPEED;
//                dir = Dir.D;
                bD = true;
                break;
        }

        setMainDir();
    }

    private void setMainDir() {
        if (!bL && !bU && !bR && !bD) {
            dir =Dir.STOP;
        }
        if (bL && !bU && !bR && !bD) {
            dir =Dir.L;
        }
        if (!bL && bU && !bR && !bD) {
            dir =Dir.U;
        }
        if (!bL && !bU && bR && !bD) {
            dir =Dir.R;
        }
        if (!bL && !bU && !bR && bD) {
            dir =Dir.D;
        }
    }

    private void move() {
        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }
    }

    public void keyReleasd(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
        setMainDir();
    }

    // 最基础的面向对象的设计思想
//        抽象出名词：类，属性
//        抽象出动词：方法 eg.画
}
