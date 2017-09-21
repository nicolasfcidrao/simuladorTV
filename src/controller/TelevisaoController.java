package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import model.Canal;
import model.Tv;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelevisaoController implements Initializable {

    private Tv tv;
    private ArrayList<Canal> canais;
    private Canal[] canaisValidos = new Canal[4];
    private int canalAtual;

    @FXML
    ToggleButton onOff;
    @FXML
    Label canal;
    @FXML
    Label nomeCanal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tv = new Tv();
        sintonizar();
        canal.setVisible(false);
        canalAtual = 1;
        nomeCanal.setVisible(false);
    }


    void sintonizar() {
        canais = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (i == 8 || i == 12 || i == 10 || i == 22) {
                if (i == 8) {
                    canais.add(new Canal("SBT"));
                    canaisValidos[0] = canais.get(7);
                } else if (i == 12) {
                    canais.add(new Canal("RECORD"));
                    canaisValidos[2] = canais.get(11);
                } else if (i == 10) {
                    canais.add(new Canal("GLOBO"));
                    canaisValidos[1] = canais.get(9);
                } else {
                    canais.add(new Canal("TV DIARIO"));
                    canaisValidos[3] = canais.get(21);
                }
            } else {
                canais.add(new Canal());
            }
        }
    }

    public void ligarDesligarTv() {
        if (tv.isLigado()) {
            tv.setLigado(false);
            onOff.setText("ON");
            onOff.setSelected(false);
            canal.setVisible(false);
        } else {
            tv.setLigado(true);
            onOff.setText("OFF");
            onOff.setSelected(true);
            canal.setVisible(true);
            canal.setText(canalAtual + "");
        }
    }

    public void diminuirCanal() {
        canalAtual--;
        if (canalAtual <= 0)
            canalAtual = 30;
        canal.setText(canalAtual + "");

        if (canalAtual == 8) {
            nomeCanal.setText(canaisValidos[0].getNome());
            nomeCanal.setVisible(true);

        } else if (canalAtual == 12) {
            nomeCanal.setText(canaisValidos[2].getNome());
            nomeCanal.setVisible(true);
        } else if (canalAtual == 10) {
            nomeCanal.setText(canaisValidos[1].getNome());
            nomeCanal.setVisible(true);

        } else if (canalAtual == 22) {
            nomeCanal.setText(canaisValidos[3].getNome());
            nomeCanal.setVisible(true);
        } else {
            nomeCanal.setVisible(false);
        }

    }

    public void aumentarCanal() {
        canalAtual++;
        if (canalAtual == 31)
            canalAtual = 0;
        canal.setText(canalAtual + "");

        if (canalAtual == 8) {
            nomeCanal.setText(canaisValidos[0].getNome());
            nomeCanal.setVisible(true);

        } else if (canalAtual == 12) {
            nomeCanal.setText(canaisValidos[2].getNome());
            nomeCanal.setVisible(true);

        } else if (canalAtual == 10) {
            nomeCanal.setText(canaisValidos[1].getNome());
            nomeCanal.setVisible(true);

        } else if (canalAtual == 22) {
            nomeCanal.setText(canaisValidos[3].getNome());
            nomeCanal.setVisible(true);
        } else {
            nomeCanal.setVisible(false);
        }

    }

    public void diminuirVolume() {
        tv.aumentaVolume();

    }

    public void aumentarVolume() {
        tv.diminuiVolume();
    }
}
