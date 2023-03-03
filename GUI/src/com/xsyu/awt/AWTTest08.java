package com.xsyu.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: AWTTest08
 * Package: com.xsyu.awt
 * Description:滚动面板和列表
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/31 - 14:43
 * @Version: v1.0
 */
public class AWTTest08 {
    public static void main(String[] args) {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);

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

        /**
         * 创建滚动面板
         */
        ScrollPane scrollPane = new ScrollPane();
        frame.add(scrollPane);

        /**
         * 演示1：
         */
//        GridLayout layout = new GridLayout();
//        layout.setRows(20);
//        Panel panel = new Panel();
//        panel.setLayout(layout);
//        for (int i = 0; i < 20; i++) {
//            //添加按钮
//            //panel.add(new Button("我是按钮" + i));
//            Button button = new Button("我是按钮" + i);
//            //只能设置高度，当窗口展示的大小小于200时，窗口底部出现滚动面板
//            button.setPreferredSize(new Dimension(200, 50));
//            panel.add(button);
//        }
//        scrollPane.add(panel);

        /**
         * 演示2：
         */

        List list = new List();
        list.setBackground(Color.ORANGE);
        //开启多选择
        list.setMultipleMode(true);
        list.add("小糍粑");
        list.add("锅巴洋芋");
        list.add("手抓饼");
        list.add("凉面");
        scrollPane.add(list);

        list.addActionListener(e -> {

        });
        frame.setVisible(true);
    }
}
