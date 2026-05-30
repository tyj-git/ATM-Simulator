import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private String cardId = "123456";
    private String password = "123456";
    private double balance = 10000;
    private JFrame loginFrame, mainFrame;
    private JTextField cardField, pwdField;

    public void createLoginUI() {
        loginFrame = new JFrame("ATM柜员机-登录");
        loginFrame.setSize(350, 220);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));

        loginFrame.add(new JLabel("卡号："));
        cardField = new JTextField(15);
        loginFrame.add(cardField);

        loginFrame.add(new JLabel("密码："));
        pwdField = new JPasswordField(15);
        loginFrame.add(pwdField);

        JButton loginBtn = new JButton("登录");
        loginBtn.addActionListener(new LoginListener());
        loginFrame.add(loginBtn);
        loginFrame.setVisible(true);
    }

    private void createMainUI() {
        loginFrame.dispose();
        mainFrame = new JFrame("ATM柜员机系统");
        mainFrame.setSize(400, 350);
        mainFrame.setLayout(new GridLayout(5,1,10,10));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton queryBtn = new JButton("1. 查询余额");
        JButton exitBtn = new JButton("退出");

        queryBtn.addActionListener(e -> JOptionPane.showMessageDialog(null,"当前余额："+balance+"元"));
        exitBtn.addActionListener(e->System.exit(0));

        mainFrame.add(queryBtn);
        mainFrame.add(exitBtn);
        mainFrame.setVisible(true);
    }

    class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String cid = cardField.getText();
            String pwd = pwdField.getText();
            if(cid.equals(cardId) && pwd.equals(password)) createMainUI();
            else JOptionPane.showMessageDialog(null,"卡号或密码错误！");
        }
    }

    public static void main(String[] args) {
        new ATM().createLoginUI();
    }
}