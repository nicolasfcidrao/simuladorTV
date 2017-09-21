package model;

public class Tv {
    private boolean ligado;
    private int canal;
    private int volume;
    private int volumeMaximo;

    public Tv() {
        this.ligado = false;
        this.volumeMaximo = 15;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMaximo() {
        return volumeMaximo;
    }

    public void aumentaVolume() {
        this.volume++;
        if (volume > volumeMaximo)
            volume = volumeMaximo;
    }

    public void diminuiVolume() {
        this.volume--;
        if (volume < 0)
            volume = 0;
    }
}
