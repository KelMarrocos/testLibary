package Dominio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginScreen {

    private JFrame frame;
    private JTextField userField;
    private JPasswordField passField;
    private JCheckBox showPasswordCheckBox;

    public loginScreen() {
        // Criação do frame (Janela)
        frame = new JFrame("Login Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setLayout(new BorderLayout());

        // Painel para conter os componentes de login
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Lables
        JLabel userLabel = new JLabel("Username: ");
        JLabel passLaber = new JLabel("Password: ");

        // Campos de texto e senha
        userField = new JTextField();
        passField = new JPasswordField();

        //checkbox para mostrar a senha
        showPasswordCheckBox = new JCheckBox("Show Password");

        // Botão de login
        JButton loginButton = new JButton("Login");

        // Adicionando componentes ao painel
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLaber);
        panel.add(passField);
        panel.add(new JLabel()); // espaço vazio para alinhar o chebox
        panel.add(showPasswordCheckBox);

        //Adicionando o painel e o botão ao frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(loginButton, BorderLayout.SOUTH);

        // Ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifyLogin();
            }
        });

        // Ação do checkbox de visualizar a senha
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()){
                    passField.setEchoChar((char) 0);
                } else {
                    passField.setEchoChar('*');
                }
            }
        });

        // Centralizar a janela na tela
        frame.setLocationRelativeTo(null);
    }

    // Exibir a janela
    public void show() {
        if (frame != null){
        frame.setVisible(true);
    } else{
            System.out.println("Frame is not initialized.");
        }
    }

    // Verificar credenciais de login
    private void verifyLogin() {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        // Verificação simples de login (exemplo)
        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(frame, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
        }
    }
}