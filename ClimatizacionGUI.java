// ClimatizacionGUI.java
import javax.swing.*;

import java.awt.event.ActionListener;

public class ClimatizacionGUI {
    private SistemaClimatizacionClaseA sistema = new SistemaClimatizacionClaseA();
    private JTextArea outputArea;

    public ClimatizacionGUI() {
        JFrame frame = new JFrame("Sistema de Climatización - Clase A");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Área de texto para mensajes de estado
        outputArea = new JTextArea();
        outputArea.setBounds(20, 450, 440, 100);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(20, 450, 440, 100);
        frame.add(scrollPane);

        // Botones de Encendido y Apagado
        JButton encenderBtn = new JButton("Encender");
        encenderBtn.setBounds(20, 20, 150, 30);
        frame.add(encenderBtn);

        JButton apagarBtn = new JButton("Apagar");
        apagarBtn.setBounds(200, 20, 150, 30);
        frame.add(apagarBtn);

        // Ajuste de Temperatura
        JLabel tempLabel = new JLabel("Temperatura:");
        tempLabel.setBounds(20, 70, 100, 30);
        frame.add(tempLabel);

        JTextField tempField = new JTextField("22");
        tempField.setBounds(120, 70, 50, 30);
        frame.add(tempField);

        JButton ajustarTempBtn = new JButton("Ajustar Temp.");
        ajustarTempBtn.setBounds(200, 70, 150, 30);
        frame.add(ajustarTempBtn);

        // Nivel de Ventilación
        JLabel ventLabel = new JLabel("Nivel de Ventilación:");
        ventLabel.setBounds(20, 110, 120, 30);
        frame.add(ventLabel);

        JTextField ventField = new JTextField("3");
        ventField.setBounds(150, 110, 50, 30);
        frame.add(ventField);

        JButton ajustarVentBtn = new JButton("Ajustar Vent.");
        ajustarVentBtn.setBounds(220, 110, 150, 30);
        frame.add(ajustarVentBtn);

        // Dirección de Ventilación
        JLabel dirVentLabel = new JLabel("Dirección de Ventilación:");
        dirVentLabel.setBounds(20, 150, 150, 30);
        frame.add(dirVentLabel);

        JComboBox<String> dirVentCombo = new JComboBox<>(new String[]{"parabrisas", "frontal", "pies"});
        dirVentCombo.setBounds(180, 150, 100, 30);
        frame.add(dirVentCombo);

        JButton dirVentBtn = new JButton("Configurar Dirección");
        dirVentBtn.setBounds(300, 150, 150, 30);
        frame.add(dirVentBtn);

        // Calefacción de Asientos
        JLabel calefLabel = new JLabel("Calefacción de Asientos (1-3):");
        calefLabel.setBounds(20, 190, 200, 30);
        frame.add(calefLabel);

        JTextField calefField = new JTextField("2");
        calefField.setBounds(220, 190, 50, 30);
        frame.add(calefField);

        JComboBox<String> zonaCombo = new JComboBox<>(new String[]{"delantero", "trasero"});
        zonaCombo.setBounds(280, 190, 100, 30);
        frame.add(zonaCombo);

        JButton ajustarCalefBtn = new JButton("Ajustar Calefacción");
        ajustarCalefBtn.setBounds(20, 230, 200, 30);
        frame.add(ajustarCalefBtn);

        // Calefacción del Volante
        JLabel volanteLabel = new JLabel("Calefacción del Volante (1-2):");
        volanteLabel.setBounds(20, 270, 200, 30);
        frame.add(volanteLabel);

        JTextField volanteField = new JTextField("1");
        volanteField.setBounds(220, 270, 50, 30);
        frame.add(volanteField);

        JButton ajustarVolanteBtn = new JButton("Ajustar Calef. Volante");
        ajustarVolanteBtn.setBounds(300, 270, 150, 30);
        frame.add(ajustarVolanteBtn);

        // Desempañador
        JButton activarDesempañadorBtn = new JButton("Activar Desempañador");
        activarDesempañadorBtn.setBounds(20, 310, 200, 30);
        frame.add(activarDesempañadorBtn);

        JButton activarDesempañadorEspejosBtn = new JButton("Activar Desempañador Espejos");
        activarDesempañadorEspejosBtn.setBounds(240, 310, 220, 30);
        frame.add(activarDesempañadorEspejosBtn);

        // Ionizador
        JButton activarIonizadorBtn = new JButton("Activar Ionizador");
        activarIonizadorBtn.setBounds(20, 350, 200, 30);
        frame.add(activarIonizadorBtn);

        // Gestión de Perfiles
        JLabel perfilLabel = new JLabel("Nombre del Perfil:");
        perfilLabel.setBounds(20, 390, 120, 30);
        frame.add(perfilLabel);

        JTextField perfilField = new JTextField();
        perfilField.setBounds(140, 390, 100, 30);
        frame.add(perfilField);

        JButton guardarPerfilBtn = new JButton("Guardar Perfil");
        guardarPerfilBtn.setBounds(20, 430, 150, 30);
        frame.add(guardarPerfilBtn);

        JButton cargarPerfilBtn = new JButton("Cargar Perfil");
        cargarPerfilBtn.setBounds(200, 430, 150, 30);
        frame.add(cargarPerfilBtn);

        // Métodos auxiliares para mostrar mensajes en el área de salida
        ActionListener showMessage = e -> {
            String command = e.getActionCommand();
            switch (command) {
                case "Encender":
                    sistema.encender();
                    addMessage("Sistema de climatización encendido.");
                    break;
                case "Apagar":
                    sistema.apagar();
                    addMessage("Sistema de climatización apagado.");
                    break;
                case "Ajustar Temp.":
                    try {
                        int incremento = Integer.parseInt(tempField.getText()) - sistema.getTemperaturaActual();
                        sistema.ajustarTemperatura(incremento);
                        addMessage("Temperatura ajustada a: " + sistema.getTemperaturaActual() + "°C");
                    } catch (NumberFormatException ex) {
                        addMessage("Error: Ingrese un valor numérico para la temperatura.");
                    }
                    break;
                case "Ajustar Vent.":
                    try {
                        int nivel = Integer.parseInt(ventField.getText());
                        sistema.ajustarNivelVentilacion(nivel);
                        addMessage("Nivel de ventilación ajustado a: " + nivel);
                    } catch (NumberFormatException ex) {
                        addMessage("Error: Ingrese un valor numérico para el nivel de ventilación.");
                    }
                    break;
                case "Configurar Dirección":
                    String direccion = (String) dirVentCombo.getSelectedItem();
                    sistema.configurarDireccion(direccion);
                    addMessage("Dirección de ventilación ajustada a: " + direccion);
                    break;
                case "Ajustar Calefacción":
                    try {
                        int nivel = Integer.parseInt(calefField.getText());
                        String zona = (String) zonaCombo.getSelectedItem();
                        sistema.ajustarCalefaccionAsientos(nivel, zona);
                        addMessage("Calefacción de asientos ajustada a nivel " + nivel + " en " + zona);
                    } catch (NumberFormatException ex) {
                        addMessage("Error: Ingrese un valor numérico para la calefacción de asientos.");
                    }
                    break;
                case "Ajustar Calef. Volante":
                    try {
                        int nivel = Integer.parseInt(volanteField.getText());
                        sistema.activarCalefaccionVolante(nivel);
                        addMessage("Calefacción del volante ajustada a nivel " + nivel);
                    } catch (NumberFormatException ex) {
                        addMessage("Error: Ingrese un valor numérico para la calefacción del volante.");
                    }
                    break;
                case "Activar Desempañador":
                    sistema.activarDesempañador();
                    addMessage("Desempañador activado.");
                    break;
                case "Activar Desempañador Espejos":
                    sistema.activarDesempañadorEspejos();
                    addMessage("Desempañador de espejos laterales activado.");
                    break;
                case "Activar Ionizador":
                    sistema.activarIonizador();
                    addMessage("Ionizador activado.");
                    break;
                case "Guardar Perfil":
                    String nombrePerfil = perfilField.getText();
                    if (!nombrePerfil.isEmpty()) {
                        sistema.guardarPerfil(nombrePerfil);
                        addMessage("Perfil guardado: " + nombrePerfil);
                    } else {
                        addMessage("Error: Ingrese un nombre para el perfil.");
                    }
                    break;
                case "Cargar Perfil":
                    String nombrePerfilCargar = perfilField.getText();
                    if (!nombrePerfilCargar.isEmpty()) {
                        sistema.cargarPerfil(nombrePerfilCargar);
                        addMessage("Perfil cargado: " + nombrePerfilCargar);
                    } else {
                        addMessage("Error: Ingrese un nombre para el perfil.");
                    }
                    break;
                default:
                    break;
            }
        };

        // Asignar action listeners a los botones
        encenderBtn.setActionCommand("Encender");
        apagarBtn.setActionCommand("Apagar");
        ajustarTempBtn.setActionCommand("Ajustar Temp.");
        ajustarVentBtn.setActionCommand("Ajustar Vent.");
        dirVentBtn.setActionCommand("Configurar Dirección");
        ajustarCalefBtn.setActionCommand("Ajustar Calefacción");
        ajustarVolanteBtn.setActionCommand("Ajustar Calef. Volante");
        activarDesempañadorBtn.setActionCommand("Activar Desempañador");
        activarDesempañadorEspejosBtn.setActionCommand("Activar Desempañador Espejos");
        activarIonizadorBtn.setActionCommand("Activar Ionizador");
        guardarPerfilBtn.setActionCommand("Guardar Perfil");
        cargarPerfilBtn.setActionCommand("Cargar Perfil");

        // Agregar el mismo ActionListener a cada botón
        encenderBtn.addActionListener(showMessage);
        apagarBtn.addActionListener(showMessage);
        ajustarTempBtn.addActionListener(showMessage);
        ajustarVentBtn.addActionListener(showMessage);
        dirVentBtn.addActionListener(showMessage);
        ajustarCalefBtn.addActionListener(showMessage);
        ajustarVolanteBtn.addActionListener(showMessage);
        activarDesempañadorBtn.addActionListener(showMessage);
        activarDesempañadorEspejosBtn.addActionListener(showMessage);
        activarIonizadorBtn.addActionListener(showMessage);
        guardarPerfilBtn.addActionListener(showMessage);
        cargarPerfilBtn.addActionListener(showMessage);

        frame.setVisible(true);
    }

    private void addMessage(String message) {
        outputArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClimatizacionGUI::new);
    }
}
