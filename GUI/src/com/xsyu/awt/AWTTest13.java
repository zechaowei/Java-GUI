package com.xsyu.awt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * ClassName: AWTTest13
 * Package: com.xsyu.awt
 * Description:窗口自定义形状
 * 记录鼠标位置
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/1 - 22:58
 * @Version: v1.0
 */
public class AWTTest13 {
    public static void main(String[] args) {
        //使用匿名内部类
        Frame frame = new Frame("Hello World!") {
            @Override
            public void paint(Graphics g) {
                //绘制标题栏
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getWidth(), 28);
                //绘制标题名称
                g.setColor(Color.BLACK);
                g.drawString(getTitle(), 230, 20);
                //原本的绘制不要覆盖，该怎么做就怎么做
                super.paint(g);
            }
        };
        frame.setSize(500, 300);
        frame.setBackground(Color.ORANGE);
        frame.setAlwaysOnTop(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        //自定义窗口
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 30, 30));


        //鼠标点击后可以拖动窗口
        frame.addMouseMotionListener(new MouseAdapter() {
            int oldX, oldY;
            //鼠标拖动时，如果是标题栏，就将窗口位置修改
            public void mouseDragged(MouseEvent e) {
                if (e.getY() <= 28){
                    frame.setLocation(e.getXOnScreen() - oldX, e.getYOnScreen() - oldY);
                }
            }
            //记录上一次鼠标的位置
            public void mouseMoved(MouseEvent e){
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        frame.setVisible(true);
    }
}
