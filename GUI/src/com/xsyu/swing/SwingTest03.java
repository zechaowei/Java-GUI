package com.xsyu.swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.util.Optional;

/**
 * ClassName: SwingTest03
 * Package: com.xsyu.swing
 * Description:Swing组件介绍(二)
 * ----> 开关按钮
 * ----> 颜色选择器
 * ----> 文件选择器
 * ----> 悬浮提示
 * ----> 文件数
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/4 - 16:13
 * @Version: v1.0
 */
public class SwingTest03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        /**
         * 开关按钮:JToggleButton()
         */
//        JToggleButton button = new JToggleButton("This is the switch");
//        button.setBounds(10, 10, 100, 30);
//        //默认点击
//        button.setSelected(true);
//        frame.setLayout(null);
//        frame.add(button);

        /**
         * 颜色选择器:JColorChooser()
         */
//        JColorChooser chooser = new JColorChooser();
//        chooser.setBounds(0, 0, 500, 300);
//        frame.add(chooser);

        /**
         * 文件选择器:JFileChooser()
         */
//        JFileChooser chooser = new JFileChooser();
//        chooser.setBounds(0, 0, 500, 300);
//        frame.add(chooser);

        /**
         * 悬浮提示:setToolTipText("xxxx")
         */
//        JButton button = new JButton("This is the switch");
//        frame.setLayout(null);
//        button.setBounds(175, 100, 150, 30);
//        button.setToolTipText("This button is for solving the xxx problem!");
//        frame.add(button);
//        frame.getContentPane().setBackground(Color.ORANGE);

        /**
         * 文件树:JTree()
         */
        //普通测试
//        frame.setLayout(null);
//        JTree tree = new JTree();
//        tree.setBounds(0, 0, 200, 300);
//        frame.add(tree);
//        frame.getContentPane().setBackground(Color.ORANGE);

        //展示 .idea 目录下所有文件
        File file = new File(".idea");
        //文件树 ----> 树形关系，肯定有一个根节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName());
        //拿到当前目录下所有文件和文件夹
        File[] files = Optional.ofNullable(file.listFiles()).orElseGet(() -> new File[0]);
        for (File f : files) {
            //构造子节点并连接
            root.add(new DefaultMutableTreeNode(f.getName()));
        }
        JTree tree = new JTree(root);
        frame.setLayout(null);
        tree.setBounds(0, 0 ,200, 300);
        frame.add(tree);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
