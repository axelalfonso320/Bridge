package Bridge;

// Extensión: nuevo control que responde a comandos de voz.
// No se modificó ningún dispositivo ni control existente.
public class ControlRemotoVoz extends ControlRemoto {
    public ControlRemotoVoz(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void comando(String texto) {
        System.out.println("Control Voz: escuché \"" + texto + "\"");
        switch (texto.toLowerCase()) {
            case "encender":
            case "apagar":
                togglePower();
                break;
            case "subir volumen":
                volumeUp();
                break;
            case "bajar volumen":
                volumeDown();
                break;
            case "siguiente canal":
                channelUp();
                break;
            case "canal anterior":
                channelDown();
                break;
            default:
                System.out.println("Control Voz: comando no reconocido");
        }
    }

    @Override
    public void togglePower() {
        if (dispositivo.isEnabled()) dispositivo.disable();
        else dispositivo.enable();
    }

    @Override
    public void volumeDown() { dispositivo.setVolume(dispositivo.getVolume() - 10); }

    @Override
    public void volumeUp() { dispositivo.setVolume(dispositivo.getVolume() + 10); }

    @Override
    public void channelDown() { dispositivo.setChannel(dispositivo.getChannel() - 1); }

    @Override
    public void channelUp() { dispositivo.setChannel(dispositivo.getChannel() + 1); }
}