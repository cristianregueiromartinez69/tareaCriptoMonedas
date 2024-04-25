package interfaz;


import services.Wallet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static services.Main.ventana;

public class WalletPanel extends JPanel {
    private JLabel nombre = new JLabel("Nombre Usuario");
    private JLabel bitcoin = new JLabel("Bitcoin");
    private JLabel ethereum = new JLabel("Ethereum");
    private JLabel dogeCoin = new JLabel("DogeCoin");
    private JLabel dollar = new JLabel("Dollar");
    private JLabel numeroBitcoin;
    private JLabel numeroEthereum;
    private JLabel numeroDogeCoin;
    private JLabel numeroDollar;
    private JButton addDollar = new JButton("add Dollar");

    public WalletPanel(Wallet wallet) {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        setBackground(Color.LIGHT_GRAY);

        numeroBitcoin = new JLabel(wallet.getBitCoins().toString());
        numeroEthereum = new JLabel(wallet.getEthereum().toString());
        numeroDogeCoin = new JLabel(wallet.getDogeCoin().toString());
        numeroDollar = new JLabel(wallet.getEuros().toString());

        c.gridx = 0;
        c.gridy = 0;

        add(nombre, c);

        c.gridx = 0;
        c.gridy = 1;
        add(bitcoin, c);
        c.gridx = 1;
        c.gridy = 1;
        add(numeroBitcoin, c);
        c.gridx = 0;
        c.gridy = 2;
        add(ethereum, c);
        c.gridx = 1;
        c.gridy = 2;
        add(numeroEthereum, c);
        c.gridx = 0;
        c.gridy = 3;
        add(dogeCoin, c);
        c.gridx = 1;
        c.gridy = 3;
        add(numeroDogeCoin, c);
        c.gridx = 0;
        c.gridy = 4;
        add(dollar, c);
        c.gridx = 1;
        c.gridy = 4;
        add(numeroDollar, c);

        c.gridx = 0;
        c.gridy = 5;
        add(Box.createVerticalStrut(20), c);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        add(addDollar, c);

        addDollar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wallet.setEuros(wallet.getEuros()+ LerDatos.lerDouble("Introduce el numero de Dolares que vas a añadir"));
                ventana.repintarWallet();
            }
        });

        setVisible(true);

    }
}
