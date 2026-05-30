import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private String cardId = "123456";
    private String password = "123456";
    private double balance = 10000.0;
    private JFrame loginFrame, mainFrame;
    private JTextField cardField, pwdField;

    public void createLoginUI() {
        loginFrame = new JFrame("ATM登录");
        loginFrame.setSize(350, 220);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

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
        mainFrame = new JFrame("ATM主界面");
        mainFrame.setSize(400, 350);
        mainFrame.setLayout(new GridLayout(6, 1, 10, 10));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton queryBtn = new JButton("1. 查询余额");
        JButton drawBtn = new JButton("2. 取款");
        JButton saveBtn = new JButton("3. 存款");
        JButton exitBtn = new JButton("退出");

        // 查询
        queryBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "当前余额：" + balance + " 元");
        });

        // 取款
        drawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("请输入取款金额（100的倍数，最多5000）：");
            try {
                double money = Double.parseDouble(input);
                if (money <= 0 || money % 100 != 0) {
                    JOptionPane.showMessageDialog(null, "必须是100的倍数！");
                } else if (money > 5000) {
                    JOptionPane.showMessageDialog(null, "单次最多取5000！");
                } else if (money > balance) {
                    JOptionPane.showMessageDialog(null, "余额不足！");
                } else {
                    balance -= money;
                    JOptionPane.showMessageDialog(null, "取款成功！剩余：" + balance);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "输入格式错误！");
            }
        });

        // 存款
        saveBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("请输入存款金额：");
            try {
                double money = Double.parseDouble(input);
                if (money < 0) {
                    JOptionPane.showMessageDialog(null, "不能存负数！");
                } else {
                    balance += money;
                    JOptionPane.showMessageDialog(null, "存款成功！当前：" + balance);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "输入格式错误！");
            }
        });

        // 退出
        exitBtn.addActionListener(e -> System.exit(0));

        mainFrame.add(queryBtn);
        mainFrame.add(drawBtn);
        mainFrame.add(saveBtn);
        mainFrame.add(exitBtn);
        mainFrame.setVisible(true);
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = cardField.getText();
            String pwd = pwdField.getText();
            if (id.equals(cardId) && pwd.equals(password)) {
                createMainUI();
            } else {
                JOptionPane.showMessageDialog(null, "卡号或密码错误！");
            }
        }
    }

    public static void main(String[] args) {
        new ATM().createLoginUI();
    }
}