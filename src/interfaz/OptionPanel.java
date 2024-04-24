package interfaz;

import services.Wallet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static services.Main.ventana;

public class OptionPanel extends JPanel {

    //X = 0
    JLabel precios = new JLabel("Precios"); // x2
    JLabel bitCoinLabel = new JLabel("BitCoin");
    JLabel ethereumLabel = new JLabel("Ethereum");
    JLabel dogeCoinLabel = new JLabel("DogeCoin");
    JButton actualizarPrecios = new JButton("Actualizar Precios"); // x2

    //X = 1
    JLabel precioBitCoinLabel;
    JLabel precioEthereumLabel;
    JLabel precioDogeCoinLabel;

    //X = 2
    JButton comprarBitCoin = new JButton("Comprar BitCoin");
    JButton comprarEthereum = new JButton("Comprar Ethereum");
    JButton comprarDogeCoin = new JButton("Comprar DogeCoin");

    public OptionPanel(Wallet wallet) {
        precioBitCoinLabel = new JLabel(wallet.getBitCoinStatus().getPrice().toString());
        precioEthereumLabel = new JLabel(wallet.getEthereumStatus().getPrice().toString());
        precioDogeCoinLabel = new JLabel(wallet.getDogeCoinStatus().getPrice().toString());

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        add(precios, c);

        c.gridx = 0;
        c.gridy = 1;
        add(bitCoinLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        add(ethereumLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        add(dogeCoinLabel, c);

        c.gridx = 0;
        c.gridy = 4;
        add(actualizarPrecios, c);

        c.gridx = 1;
        c.gridy = 1;
        add(precioBitCoinLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        add(precioEthereumLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        add(precioDogeCoinLabel, c);

        c.gridx = 2;
        c.gridy = 1;
        add(comprarBitCoin, c);

        c.gridx = 2;
        c.gridy = 2;
        add(comprarEthereum, c);

        c.gridx = 2;
        c.gridy = 3;
        add(comprarDogeCoin, c);

        c.gridx = 3;
        c.gridy = 4;
        add(new JLabel("powered by CoinGekoAPI"), c);

        actualizarPrecios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wallet.acturalizarPrecios();
                ventana.repintarOptions();
            }
        });
        comprarBitCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wallet.aceptarTransaccion(wallet.precioTransaccion(Wallet.BITCOIN), Wallet.BITCOIN);
                ventana.repintarWallet();
            }
        });
        comprarEthereum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wallet.aceptarTransaccion(wallet.precioTransaccion(Wallet.ETHEREUM), Wallet.ETHEREUM);
                ventana.repintarWallet();
            }
        });
        comprarDogeCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wallet.aceptarTransaccion(wallet.precioTransaccion(Wallet.DOGECOIN), Wallet.DOGECOIN);
                ventana.repintarWallet();
            }
        });

    }
}
