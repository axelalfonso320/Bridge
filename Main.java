package Bridge;

public class Main {
    public static void main(String[] args) {
        // Combinación 1: Control básico con Radio
        System.out.println("=== Control Básico con Radio ===");
        ControlRemoto control1 = new ControlRemotoBasico(new Radio());
        probarControlRemoto(control1);

        // Combinación 2: Control avanzado con TV
        System.out.println("\n=== Control Avanzado con TV ===");
        ControlRemotoAvanzado control2 = new ControlRemotoAvanzado(new TV());
        probarControlRemoto(control2);
        control2.mute(); // Funcionalidad exclusiva del control avanzado

        // Combinación 3: Control básico con TV
        System.out.println("\n=== Control Básico con TV ===");
        ControlRemoto control3 = new ControlRemotoBasico(new TV());
        probarControlRemoto(control3);

        // Combinación 4: Control avanzado con Radio
        System.out.println("\n=== Control Avanzado con Radio ===");
        ControlRemotoAvanzado control4 = new ControlRemotoAvanzado(new Radio());
        probarControlRemoto(control4);
        control4.record();

        // Extensión 1: nuevo dispositivo (Projector) con los controles existentes
        System.out.println("\n=== Control Avanzado con Projector ===");
        ControlRemotoAvanzado control5 = new ControlRemotoAvanzado(new Projector());
        probarControlRemoto(control5);

        // Extensión 2: nuevo control (Voz) con dispositivos existentes
        System.out.println("\n=== Control por Voz con TV ===");
        ControlRemotoVoz control6 = new ControlRemotoVoz(new TV());
        control6.comando("encender");
        control6.comando("subir volumen");
        control6.comando("siguiente canal");
        control6.dispositivo.printStatus();

        // Cambio de dispositivo en tiempo de ejecución
        System.out.println("\n=== Cambio de dispositivo en ejecución ===");
        control6.setDispositivo(new Radio());
        control6.comando("encender");
        control6.dispositivo.printStatus();
    }

    public static void probarControlRemoto(ControlRemoto control) {
        control.togglePower(); // Encender
        control.volumeUp();
        control.channelUp();
        control.volumeDown();
        control.dispositivo.printStatus();
        control.togglePower(); // Apagar
    }
}