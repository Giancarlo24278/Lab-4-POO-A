// SistemaClimatizacionClaseA.java
import java.util.HashMap;

public class SistemaClimatizacionClaseA implements EncendidoApagadoInterface, TemperaturaInterface,
        VentilacionInterface, CalefaccionInterface, DesempañadorInterface, IonizadorInterface, PerfilesInterface {

    private boolean encendido;
    private int temperaturaActual;
    private boolean modoAutomatico;
    private int nivelVentilacion;
    private String direccionVentilacion;
    private boolean ventilacionAutomatica;
    private boolean recirculacionInterna;
    private int calefaccionAsientos;
    private int calefaccionVolante;
    private int temperaturaConductor;
    private int temperaturaPasajero;
    private boolean desempañador;
    private boolean desempañadorEspejos;
    private boolean desempañadoAcelerado;
    private int calidadAire;
    private boolean ionizador;
    private boolean purificacionProfunda;
    private HashMap<String, PerfilClimatizacion> perfiles;

    public SistemaClimatizacionClaseA() {
        this.encendido = false;
        this.temperaturaActual = 22; // Temperatura inicial por defecto
        this.perfiles = new HashMap<>();
    }

    // Implementación de EncendidoApagadoInterface
    public void encender() {
        this.encendido = true;
        System.out.println("Sistema de climatización encendido.");
    }

    public void apagar() {
        this.encendido = false;
        System.out.println("Sistema de climatización apagado.");
    }

    public boolean isEncendido() {
        return this.encendido;
    }

    // Implementación de TemperaturaInterface
    public void ajustarTemperatura(int incremento) {
        if (encendido) {
            this.temperaturaActual += incremento;
            System.out.println("Temperatura ajustada a: " + temperaturaActual + "°C");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void activarModoAutomatico() {
        if (encendido) {
            this.modoAutomatico = true;
            System.out.println("Modo automático activado.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void desactivarModoAutomatico() {
        this.modoAutomatico = false;
        System.out.println("Modo automático desactivado.");
    }

    public int getTemperaturaActual() {
        return this.temperaturaActual;
    }

    // Implementación de VentilacionInterface
    public void ajustarNivelVentilacion(int nivel) {
        if (encendido) {
            if (nivel >= 1 && nivel <= 5) {
                this.nivelVentilacion = nivel;
                System.out.println("Nivel de ventilación ajustado a: " + nivel);
            } else {
                System.out.println("Error: Nivel de ventilación fuera de rango.");
            }
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void configurarDireccion(String direccion) {
        if (encendido) {
            this.direccionVentilacion = direccion;
            System.out.println("Dirección de ventilación ajustada a: " + direccion);
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void activarVentilacionAutomatica() {
        if (encendido) {
            this.ventilacionAutomatica = true;
            System.out.println("Ventilación automática activada.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void desactivarVentilacionAutomatica() {
        this.ventilacionAutomatica = false;
        System.out.println("Ventilación automática desactivada.");
    }

    public void activarRecirculacionInterna() {
        if (encendido) {
            this.recirculacionInterna = true;
            System.out.println("Recirculación interna activada.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void desactivarRecirculacionInterna() {
        this.recirculacionInterna = false;
        System.out.println("Recirculación interna desactivada.");
    }

    // Implementación de CalefaccionInterface
    public void ajustarCalefaccionAsientos(int nivel, String zona) {
        if (encendido) {
            if (nivel >= 1 && nivel <= 3) {
                this.calefaccionAsientos = nivel;
                System.out.println("Calefacción de asientos en " + zona + " ajustada a nivel " + nivel);
            } else {
                System.out.println("Error: Nivel de calefacción fuera de rango.");
            }
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void activarCalefaccionVolante(int nivel) {
        if (encendido) {
            if (nivel == 1 || nivel == 2) {
                this.calefaccionVolante = nivel;
                System.out.println("Calefacción del volante activada en nivel " + nivel);
            } else {
                System.out.println("Error: Nivel de calefacción del volante fuera de rango.");
            }
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void activarCalefaccionRapida() {
        if (encendido) {
            System.out.println("Calefacción rápida activada para calentar rápidamente el habitáculo.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void ajustarControlZonaDual(int temperaturaConductor, int temperaturaPasajero) {
        if (encendido) {
            this.temperaturaConductor = temperaturaConductor;
            this.temperaturaPasajero = temperaturaPasajero;
            System.out.println("Control de zona dual ajustado. Conductor: " + temperaturaConductor + "°C, Pasajero: " + temperaturaPasajero + "°C");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    // Implementación de DesempañadorInterface
    public void activarDesempañador() {
        if (encendido) {
            this.desempañador = true;
            System.out.println("Desempañador activado.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void desactivarDesempañador() {
        this.desempañador = false;
        System.out.println("Desempañador desactivado.");
    }

    public void activarDesempañadorEspejos() {
        if (encendido) {
            this.desempañadorEspejos = true;
            System.out.println("Desempañador de espejos laterales activado.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void activarModoAcelerado() {
        if (encendido) {
            this.desempañadoAcelerado = true;
            System.out.println("Modo de desempañado acelerado activado.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void configurarDesempañadoPorZona(String zona) {
        if (encendido) {
            System.out.println("Desempañado configurado para la zona: " + zona);
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public int getNivelHumedad() {
        return 60; // Simulación de nivel de humedad
    }

    // Implementación de IonizadorInterface
    public void activarIonizador() {
        if (encendido) {
            this.ionizador = true;
            System.out.println("Ionizador activado.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void desactivarIonizador() {
        this.ionizador = false;
        System.out.println("Ionizador desactivado.");
    }

    public void activarModoAutomatico() {
        if (encendido) {
            System.out.println("Modo automático del ionizador activado.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void activarPurificacionProfunda() {
        if (encendido) {
            this.purificacionProfunda = true;
            System.out.println("Ciclo de purificación profunda activado.");
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public int getCalidadAire() {
        return 75; // Simulación de calidad del aire
    }

    // Implementación de PerfilesInterface
    public void guardarPerfil(String nombre) {
        if (encendido) {
            perfiles.put(nombre, new PerfilClimatizacion(nombre, temperaturaActual, nivelVentilacion, calefaccionAsientos, ionizador));
            System.out.println("Perfil guardado: " + nombre);
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void cargarPerfil(String nombre) {
        if (encendido) {
            PerfilClimatizacion perfil = perfiles.get(nombre);
            if (perfil != null) {
                this.temperaturaActual = perfil.getTemperatura();
                this.nivelVentilacion = perfil.getNivelVentilacion();
                this.calefaccionAsientos = perfil.getCalefaccionAsientos();
                this.ionizador = perfil.isIonizador();
                System.out.println("Perfil cargado: " + nombre);
            } else {
                System.out.println("Perfil no encontrado.");
            }
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public void eliminarPerfil(String nombre) {
        if (encendido) {
            perfiles.remove(nombre);
            System.out.println("Perfil eliminado: " + nombre);
        } else {
            System.out.println("Error: El sistema está apagado.");
        }
    }

    public String[] listarPerfiles() {
        return perfiles.keySet().toArray(new String[0]);
    }
}

// Clase auxiliar para guardar perfiles
class PerfilClimatizacion {
    private String nombre;
    private int temperatura;
    private int nivelVentilacion;
    private int calefaccionAsientos;
    private boolean ionizador;

    public PerfilClimatizacion(String nombre, int temperatura, int nivelVentilacion, int calefaccionAsientos, boolean ionizador) {
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.nivelVentilacion = nivelVentilacion;
        this.calefaccionAsientos = calefaccionAsientos;
        this.ionizador = ionizador;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getNivelVentilacion() {
        return nivelVentilacion;
    }

    public int getCalefaccionAsientos() {
        return calefaccionAsientos;
    }

    public boolean isIonizador() {
        return ionizador;
    }
}
