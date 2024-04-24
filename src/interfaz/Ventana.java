package interfaz;

import services.Main;
import services.Wallet;

import javax.swing.*;
import java.awt.*;

import static services.Main.ventana;

public class Ventana extends JFrame {
    private JPanel options;
    private static JPanel walletPanel;
    private static Wallet wallet;

    public Ventana(Wallet wallet) {
        walletPanel = new WalletPanel(wallet);
        Ventana.wallet = wallet;

        setTitle("Ventana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 600, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        add(walletPanel, c);

        setVisible(true);

    }

    public static JPanel nuevoWalletPanel(Wallet wallet){
        walletPanel = new WalletPanel(wallet);
        return walletPanel;
    }
    public static void repintarWallet() {
        ventana.remove(walletPanel);
        walletPanel = nuevoWalletPanel(wallet);
        GridBagConstraints c = new GridBagConstraints();
        ventana.add(walletPanel);
        walletPanel.setVisible(true);
        ventana.validate();
        ventana.repaint();
    }
}
