# Respuestas de análisis: Patrón Bridge

## 1. Explosión de clases
Sin Bridge, con 3 tipos de controles y 4 tipos de dispositivos se necesitaría una clase por cada combinación: 3 × 4 = 12 clases. Con Bridge solo se necesitan 3 + 4 = 7 clases (más la clase abstracta ControlRemoto y la interfaz Dispositivo), porque cada jerarquía crece por separado.

## 2. Acoplamiento
Si ControlRemotoBasico heredara de Radio o de TV, quedaría atado a ese dispositivo para siempre y habría que crear una clase nueva por cada dispositivo. Además, un control remoto no es un dispositivo, así que la herencia sería incorrecta. Con composición, el control solo depende de la interfaz Dispositivo.

## 3. Extensibilidad
Para agregar un Projector solo se crea la clase que implementa Dispositivo. No se modifica ninguna clase de control, y los controles existentes ya funcionan con él.

## 4. Principios SOLID
- Abierto/Cerrado (OCP): se pueden agregar dispositivos o controles nuevos sin modificar el código existente.
- Inversión de dependencias (DIP): ControlRemoto depende de la abstracción Dispositivo, no de Radio ni de TV.
- Responsabilidad única (SRP): los controles manejan la interacción con el usuario y los dispositivos manejan su propio funcionamiento.

## 5. Flexibilidad
Como el dispositivo es una referencia dentro del control, se puede cambiar en tiempo de ejecución con setDispositivo(). El mismo control pasa de manejar una TV a manejar una Radio sin crear otro objeto.

## Ejercicios de extensión
- Se agregó la clase Projector, que funciona con los controles existentes sin modificarlos.
- Se agregó ControlRemotoVoz, que funciona con los dispositivos existentes sin modificarlos.
- Funcionalidad cruzada: si un control avanzado solo debe funcionar con ciertos dispositivos, se agrega a Dispositivo un método como soportaGrabacion(). Antes de grabar, el control consulta ese método y avisa si el dispositivo no puede hacerlo. Así no se usa instanceof y se mantiene el desacoplamiento.