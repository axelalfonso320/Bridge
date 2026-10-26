package Bridge;

public class Projector implements Dispositivo {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() { return on; }

    @Override
    public void enable() {
        on = true;
        System.out.println("Proyector encendido");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Proyector apagado");
    }

    @Override
    public int getVolume() { return volume; }

    @Override
    public void setVolume(int percent) {
        if (percent > 100) percent = 100;
        if (percent < 0) percent = 0;
        volume = percent;
    }

    @Override
    public int getChannel() { return channel; }

    @Override
    public void setChannel(int channel) {
        if (channel < 1) channel = 1;
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("  [Projector] " + (on ? "ON" : "OFF")
                + " | Volumen: " + volume + " | Canal: " + channel);
    }
}