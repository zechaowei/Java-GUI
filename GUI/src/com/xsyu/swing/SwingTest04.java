package com.xsyu.swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

/**
 * ClassName: SwingTest04
 * Package: com.xsyu.swing
 * Description:多面板和分割面板
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/4 - 18:56
 * @Version: v1.0
 */
public class SwingTest04 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        /**
         * 多面板
         */
        JTabbedPane pane = new JTabbedPane();

        /**
         * 设置多面板背景颜色
         */
//        pane.addTab("一号", new JPanel() {{
//            setBackground(Color.ORANGE);
//        }});
//        pane.addTab("二号", new JPanel() {{
//            setBackground(Color.PINK);
//        }});

        /**
         * 设置多面板内容
         */
//        //一号面板  ----> 颜色选择器
//        pane.addTab("一号", new JColorChooser());
//        //二号面板  ----> 文件选择器
//        pane.addTab("二号", new JFileChooser());

        //frame.add(pane);


        /**
         * 分割面板
         */

        JSplitPane pane1 = new JSplitPane();

        /**
         * 将窗口分割为两个部分：左边为橙色背景，右边为粉色背景
         */
//        pane1.setLeftComponent(new JPanel() {{
//            setBackground(Color.ORANGE);
//        }});
//        pane1.setRightComponent(new JPanel() {{
//            setBackground(Color.PINK);
//        }});

        /**
         * 模拟IDEA
         */

        File file = new File(".idea");
        JTextArea area = new JTextArea();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file);
        File[] files = Optional.ofNullable(file.listFiles()).orElseGet(() -> new File[0]);
        for (File f : files) {
            root.add(new DefaultMutableTreeNode(f.getName()));
        }
        JTree tree = new JTree(root);
        tree.addTreeSelectionListener(event -> {
            //清空文本域
            area.setText("");
            try(FileReader reader = new FileReader(".idea/" + event.getPath().getLastPathComponent().toString())){
                //开始直接读取内容
                char[] chars = new char[128];
                int length;
                while ((length = reader.read(chars))> 0){
                    //开始写入到编辑窗口中
                    area.setText(area.getText() + new String(chars, 0, length));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        //右边设置为文件树，左边设置为文本域
        //设置滚动面板
        pane1.setLeftComponent(new JScrollPane(tree));
        pane1.setRightComponent(new JScrollPane(area));
        frame.add(pane1);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
