package com.xsyu.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

/**
 * ClassName: AWTTest11
 * Package: com.xsyu.awt
 * Description:编写自定义组件
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/1 - 17:53
 * @Version: v1.0
 */
public class AWTTest11 {
    public static void main(String[] args) throws IOException {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        frame.setBackground(Color.ORANGE);
        //frame.setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //修改左上角图标
        frame.setIconImage(ImageIO.read(new File("山村小景.jpg")));

        //窗口主界面设置失败，未显示
        ImageView imageView = new ImageView("山村小景.jpg");
        //imageView.setBounds(20, 50, 100, 50);
        frame.add(imageView);


        frame.setVisible(true);
    }
}
