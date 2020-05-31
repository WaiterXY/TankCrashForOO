import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    // 将这些类移出去
//    private int x = 100;
//    private int y = 100;
//    private int SPEED = 5;
    private Tank myTank;
    private Tank enemy;

    public TankFrame () {

        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);

        this.addKeyListener(new TankKeyListener());// 观察者模式
        myTank = new Tank(100, 100, Dir.R);
        enemy = new Tank(200, 200, Dir.D);
    }

    @Override
    public void paint(Graphics g) {
        // 因为 xy 是 tank 内部的属性，让外部访问不合适，所以应该让 tank 自己去执行
//        g.fillRect(x, y, 50 ,50);
        myTank.paint(g);
        enemy.paint(g);
        System.out.println("paint");
    }
    // 为什么使用内部类？
//        不需要让别的类访问键盘监听类
//        高内聚，低耦合
//    为什么不使用方法的内部类（局部内部类）或者匿名内部类
//        看起来不方便
//        内部类可以非常方便地访问包装类的局部变量
//    一开始本来准备实现 KeyListenter 接口，但是却要实现所有的包括 keyTpye 方法，
//    现在通过实现 KeyAdapter 就可以只实现我们需要的方法 但是需要注意的是， KeyAdapter 不是适配器模式
    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);
//            int key = e.getExtendedKeyCode();
//            switch (key) {
//                case KeyEvent.VK_LEFT:
//                    x -= SPEED;
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    x += SPEED;
//                    break;
//                case KeyEvent.VK_UP:
//                    y -= SPEED;
//                    break;
//                case KeyEvent.VK_DOWN:
//                    y += SPEED;
//                    break;
//            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleasd(e);
        }
    }


}
