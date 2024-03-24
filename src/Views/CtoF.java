package src.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CtoF{
    private int weight = 1280;
    private int height = 720;
    private JFrame frame;
    private JLabel lb1, lb2;
    private JTextField tf1;
    private JButton btn1, btn2;

    public CtoF(){
        // 建立 JFrame 物件，同時設定標題
        frame = new JFrame("Hello JAVA Swing");
        // 設定佈局
        frame.setLayout(null);
        
        // 建立標籤
        lb1 = new JLabel("請輸入攝氏溫度 : ");
        lb1.setBounds(5, 5, 100, 20); // 設定絕對座標
        frame.add(lb1); // 將元件加入版面
        
        // 建立文字框
        tf1 = new JTextField("0");
        tf1.setBounds(107, 5, 100, 20); // 設定絕對座標
        frame.add(tf1); // 將元件加入版面
        
        // 建立"確認"按鈕 
        btn1 = new JButton("求華氏溫度");
        btn1.setBounds(5, 37, 100, 20); // 設定絕對座標
        frame.add(btn1); // 將元件加入版面
        btn1.addActionListener(new ActionListener() { // 註冊事件，使用匿名類別的匿名物件
            // 處理觸發的事件
            @Override
            public void actionPerformed(ActionEvent e) {
                double c = 0, f = 0;
                try{
                    c = Double.parseDouble(tf1.getText()); // 取得文字框的文字，並轉換成 Double
                    f = 9.0 / 5.0 * c + 32;
                    lb2.setText("華氏溫度 " + f + " 度");
                    btn2.setEnabled(true); // 啟用 btn2 按鈕
                    btn1.setEnabled(false); // 不啟用 btn1 按鈕
                }catch(Exception ex){
                    // JOptionPane 可以輕鬆彈出一個標準對話框
                    // showMessageDialog(parentComponent, message, title, messageType)
                    JOptionPane.showMessageDialog(null, "請輸入數字", "輸入錯誤", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // 建立"清除"按鈕
        btn2 = new JButton("清除");
        btn2.setBounds(107, 37, 100, 20); // 設定絕對座標
        btn2.setEnabled(false); // 不啟用 btn2 按鈕
        frame.add(btn2); // 將元件加入版面
        btn2.addActionListener(new ActionListener() { // 註冊事件，使用匿名類別的匿名物件
            // 處理觸發的事件
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(""); // 將文字框清除
                lb2.setText(""); // 將 lb2 標籤清除
                btn1.setEnabled(true); // 啟用 btn1 按鈕
                btn2.setEnabled(false); // 不啟用 btn2 按鈕
            }
        });
        
        // 建立標籤
        lb2 = new JLabel("[]");
        lb2.setBounds(5, 59, 200, 40); // 設定絕對座標
        frame.add(lb2); // 將元件加入版面
        
        // 設定版面大小
        frame.setSize(weight, height);
        // 顯示視窗
        frame.setVisible(true);
        
        // JFrame 關閉視窗的設定，有這一行才能結束程式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
