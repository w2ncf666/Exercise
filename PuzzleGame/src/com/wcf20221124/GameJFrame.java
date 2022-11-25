package com.wcf20221124;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] Data = new int[4][4];
    int x = 0, y = 0;
    int count;
    String path = "D:\\GitHub\\Exercise\\PuzzleGame\\animal"+3+"\\";
    Random r=new Random();
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    //下拉选项
    JMenuItem replay = new JMenuItem("重新游戏");
    //JMenuItem relogin = new JMenuItem("重新登录");
    JMenuItem close = new JMenuItem("退出游戏");

    JMenuItem myaccount = new JMenuItem("支持我");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem girl = new JMenuItem("女孩");
    JMenuItem sport = new JMenuItem("运动");

    public GameJFrame() {
        initgame();
        randomData();
        initMenu();
        // this.setVisible(true);
        initImage();
        this.setVisible(true);
//        for (int i = 0; i < Data.length; i++) {
//            for (int j = 0; j <Data[i].length; j++) {
//                System.out.print(Data[i][j] + " ");
//            }
//        }
    }

    private void randomData() {
        int[] temparr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < temparr.length; i++) {
            int index = r.nextInt(temparr.length);
            int temp = temparr[i];
            temparr[i] = temparr[index];
            temparr[index] = temp;

        }
        for (int i = 0; i < temparr.length; i++) {
            Data[i / 4][i % 4] = temparr[i];
            if (temparr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
        }
    }

    private void initMenu() {
        JMenuBar jMenuBar = new JMenuBar();//菜单框对象
        //菜单框的选项
        JMenu changeimage=new JMenu("切换图片");
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutUs = new JMenu("关于我");

        //添加
        functionMenu.add(changeimage);
        functionMenu.add(replay);
        //functionMenu.add(relogin);
        functionMenu.add(close);
        changeimage.add(animal);
        changeimage.add(girl);
        changeimage.add(sport);
        aboutUs.add(myaccount);
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutUs);
        this.setJMenuBar(jMenuBar);
        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//匿名内部类写法
                if (e.getSource() == replay) {
                    System.out.println("重新游戏");
                    count = 0;
                    randomData();
                    initImage();
                }
            }
        });
        //relogin.addActionListener(this);
        close.addActionListener(this);
        myaccount.addActionListener(this);
        animal.addActionListener(this);
        girl.addActionListener(this);
        sport.addActionListener(this);
    }

    private void initImage() {
        this.getContentPane().removeAll();
        if (IsWin()) {
            JLabel win = new JLabel(new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\3DP3``Y3)F(Z7Z{~XAD{2X7.jpg"));
            win.setBounds(200, 150, 197, 400);
            //this.add(jLabel);
            this.getContentPane().add(win);//好烦吗写了好久,会给黄石东一个惊喜!
        }
        JLabel stepcount = new JLabel("当前步数:" + count);
        stepcount.setBounds(50, 5, 150, 80);
        this.getContentPane().add(stepcount);
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                k = Data[i][j];
                // ImageIcon icon = new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\animal8\\1.jpg");
                JLabel jLabel = new JLabel(new ImageIcon(path+k+".jpg"));
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //this.add(jLabel);
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                this.getContentPane().add(jLabel);
            }
        }
        //背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
//        if(IsWWin()){
//            JLabel win = new JLabel(new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\win.png"));
//          win.setBounds(283, 283, 197, 73);
//          //this.add(jLabel);
//          this.getContentPane().add(win);
//        }
        this.getContentPane().repaint();

      /*  ImageIcon icon = new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\animal8\\1.jpg");
        JLabel jLabel = new JLabel(new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\animal8\\1.jpg"));
        jLabel.setBounds(0, 0, 105, 105);
        //this.add(jLabel);
        this.getContentPane().add(jLabel);*/
    }

    private void initgame() {
        this.setSize(615, 700);
        this.setTitle("拼图11.24");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {//按下事件,如果不抬起会一直响应.
        int code = e.getKeyCode();
        //System.out.println(code);
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon(path+"all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            //this.add(jLabel);
            jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
            this.getContentPane().add(jLabel);

            JLabel background = new JLabel(new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {//松开事件,在此做改动
        int code = e.getKeyCode();
        if (code == 65)
            initImage();
        if (!IsWin()) {
            if (code == 37) {
                if (y == 0)
                    return;
                System.out.println("向左移动");
                Data[x][y] = Data[x][y - 1];
                Data[x][y - 1] = 0;
                y--;
                count++;
                initImage();
            } else if (code == 38) {
                if (x == 0)
                    return;
                System.out.println("向上移动");
                Data[x][y] = Data[x - 1][y];
                Data[x - 1][y] = 0;
                x--;
                count++;
                initImage();
            } else if (code == 39) {
                if (y == 3)
                    return;
                System.out.println("向右移动");
                Data[x][y] = Data[x][y + 1];
                Data[x][y + 1] = 0;
                y++;
                count++;
                initImage();
            } else if (code == 40) {
                if (x == 3)
                    return;
                System.out.println("向下移动");
                Data[x][y] = Data[x + 1][y];
                Data[x + 1][y] = 0;
                x++;
                count++;
                initImage();
            } else if (code == 87) {
                Data = new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 0}
                };
                initImage();
            }

        }
//         else if(code==65)
//            initImage();
    }

    private boolean IsWin() {
        for (int i = 0; i < Data.length; i++) {
            for (int j = 0; j < Data[i].length; j++) {
                if (Data[i][j] != win[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* if (e.getSource() == relogin) {
            System.out.println("重新登录");
            this.setVisible(false);
            new LoginJFrame();
        }*/
        if (e.getSource() == close)
            System.exit(0);
        if (e.getSource() == myaccount) {
            System.out.println("支持我");
            JDialog jDialog = new JDialog();//弹框对象
            //jlabel是容器对象,用来装图片
            JLabel jLabel = new JLabel(new ImageIcon("D:\\GitHub\\Exercise\\PuzzleGame\\(F%9S)P{4ULA4TZA8@T8F%N.png"));
            jLabel.setBounds(0, 0, 421, 352);//设置容器的位置和大小,相对于弹框而言
            jDialog.getContentPane().add(jLabel);//弹框的容器中添加这个装图片的容器
            jDialog.setAlwaysOnTop(true);//置顶
            jDialog.setSize(350, 300);//弹框大小
            jDialog.setLocationRelativeTo(null);//居中
            jDialog.setModal(true);//无法操作其他界面
            jDialog.setVisible(true);//界面显示出来
        }
        if(e.getSource()==animal){//  path + "animal8\\" + k + ".jpg"    D:\\GitHub\\Exercise\\PuzzleGame\\animal8\\1.jpg
            int a=r.nextInt(8)+1;
            path="D:\\GitHub\\Exercise\\PuzzleGame\\animal"+a+"\\";
            randomData();
            initImage();
            //"path+\\k.jpg"
        }
        else if(e.getSource()==sport){
            int a=r.nextInt(10)+1;
            path="D:\\GitHub\\Exercise\\PuzzleGame\\sport"+a+"\\";
            randomData();
            initImage();
        }
        else if(e.getSource()==girl){
            int a=r.nextInt(13)+1;
            path="D:\\GitHub\\Exercise\\PuzzleGame\\girl"+a+"\\";
            randomData();
            initImage();
        }
    }
}
