import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private String cardId = "123456";
    private String password = "123456";
    private JFrame loginFrame;
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

    class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String cid = cardField.getText();
            String pwd = pwdField.getText();
            if(cid.equals(cardId) && pwd.equals(password)) {
                JOptionPane.showMessageDialog(null,"登录成功！");
            } else {
                JOptionPane.showMessageDialog(null,"卡号或密码错误！");
            }
        }
    }

    public static void main(String[] args) {
        new ATM().createLoginUI();
    }
}