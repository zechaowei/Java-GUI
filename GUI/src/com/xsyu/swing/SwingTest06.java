package com.xsyu.swing;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;


/**
 * ClassName: SwingTest06
 * Package: com.xsyu.swing
 * Description:自定义主题
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/4 - 22:28
 * @Version: v1.0
 */
public class SwingTest06 {
    /**
     * 皮肤机制
     * 官方名称叫做LookAndFeel，Swing官方为我们提供了很多套皮肤，这些皮肤都是可以跨平台的，当然也有某些平台专属的限定皮肤:
     * 1、MetalLookAndFeel     ----> 官方默认皮肤
     * 2、WindowsLookAndFeel   ----> Windows操作系统限定皮肤，其他平台无法使用
     * 3、MotifLookAndFeel     ----> 官方皮肤
     * 4、NimbusLookAndFeel    ----> 官方皮肤
     * 5、AqualLookAndFeel     ----> MacOS操作系统限定皮肤，其他平台无法使用
     */


    static {
        try{
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }catch (UnsupportedLookAndFeelException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);
        frame.getContentPane().setBackground(Color.ORANGE);


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int value = JOptionPane.showConfirmDialog(frame, "是否退出程序?", "提示", JOptionPane.YES_NO_OPTION);
                if (value == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        JSplitPane pane1 = new JSplitPane();
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



        frame.setVisible(true);
    }
}
