package com.xsyu.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * ClassName: AWTTest09
 * Package: com.xsyu.awt
 * Description:菜单栏和弹出菜单
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/31 - 15:40
 * @Version: v1.0
 */
public class AWTTest09 {
    public static void main(String[] args) {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setBackground(Color.ORANGE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);


        /**
         * 菜单栏
         * 菜单名称：
         * 菜单选项：
         * 可以勾选的选项：
         * 设置快捷键：
         */
        MenuBar menuBar = new MenuBar();
        //菜单名称
        Menu menu = new Menu("Menu1");
        //菜单选项
        MenuItem item1 = new MenuItem("This is one button");
        MenuItem item2 = new MenuItem("This is two button");
        menu.add(item1);
        menu.add(item2);

        //添加可以勾选的选项
        CheckboxMenuItem checkboxMenuItem = new CheckboxMenuItem("This is something you can check");
        menu.add(checkboxMenuItem);

        /**
         * 设置快捷键
         * 函数：setShortcut(key)
         * 函数：setShortcut(key,useShiftModifier):选择快捷键，是否需要shift共同操作
         */
        item1.setShortcut(new MenuShortcut('U'));
        item2.setShortcut(new MenuShortcut('Y'));
        checkboxMenuItem.setShortcut(new MenuShortcut('E', true));

        //将菜单加入到菜单栏中
        menuBar.add(menu);
        //菜单栏在frame窗口
        frame.setMenuBar(menuBar);


        //添加监听事件
        item1.addActionListener(e -> System.out.println("Menu1 is clicked!"));
        item2.addActionListener(e -> System.out.println("Menu2 is clicked!"));

        /**
         * 弹出菜单
         * 函数：PopupMenu()
         */
        PopupMenu popupMenu = new PopupMenu();
        popupMenu.add(new MenuItem("No.1 button"));
        popupMenu.add(new MenuItem("No.2 button"));
        frame.add(popupMenu);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    //以前面的组件作为原点，即frame为原点，因此后面的坐标是相对于组件的原点坐标
                    popupMenu.show(frame, e.getX(), e.getY());
                }
            }
        });
        frame.setVisible(true);
    }
}