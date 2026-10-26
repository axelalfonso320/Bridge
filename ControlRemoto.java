package Bridge;

public abstract class ControlRemoto {
    protected Dispositivo dispositivo; // ¡ESTE ES EL PUENTE!

    public ControlRemoto(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    // Permite cambiar el dispositivo en tiempo de ejecución
    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public abstract void togglePower();
    public abstract void volumeDown();
    public abstract void volumeUp();
    public abstract void channelDown();
    public abstract void channelUp();
}