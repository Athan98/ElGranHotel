/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.*;
import entidades.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stefano
 */
public class CrearReserva extends javax.swing.JInternalFrame {
    
    Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    Huesped_data hd = new Huesped_data(con);
    Habitacion_data habD = new Habitacion_data(con);
    Reserva_data rd = new Reserva_data(con);
    TipoHabitacion_data thD = new TipoHabitacion_data(con);
    double PrecioTotal = 0;
    
    DefaultTableModel modeloH = new DefaultTableModel();
    DefaultTableModel modeloR = new DefaultTableModel();
    
    public CrearReserva() {
        initComponents();
        cargarCabeceras();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHabitacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHab = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jbConfirmar = new javax.swing.JButton();
        PanelFechas = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jdIngreso = new com.toedter.calendar.JDateChooser();
        jdSalida = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jtCantPersonas = new javax.swing.JTextField();
        jbBuscarHab = new javax.swing.JButton();
        PanelHuesped = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jlApellido = new javax.swing.JLabel();
        jlDireccion = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        jbBuscarDNI = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jlTelefono = new javax.swing.JLabel();
        PanelReservas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtReserv = new javax.swing.JTable();
        jbCancelar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jbReservar = new javax.swing.JButton();
        jlMontoTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        PanelHabitacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtHab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtHab);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Habitaciones Disponibles");

        jbConfirmar.setText("Confirmar Reserva");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHabitacionLayout = new javax.swing.GroupLayout(PanelHabitacion);
        PanelHabitacion.setLayout(PanelHabitacionLayout);
        PanelHabitacionLayout.setHorizontalGroup(
            PanelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHabitacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHabitacionLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHabitacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHabitacionLayout.createSequentialGroup()
                                .addComponent(jbConfirmar)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHabitacionLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(189, 189, 189))))))
        );
        PanelHabitacionLayout.setVerticalGroup(
            PanelHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHabitacionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelFechas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel17.setText("Ingreso:");

        jLabel16.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel16.setText("Salida:");

        jLabel13.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel13.setText("Cant. Personas: ");

        jtCantPersonas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jbBuscarHab.setText("Buscar Habitaciones");
        jbBuscarHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarHabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFechasLayout = new javax.swing.GroupLayout(PanelFechas);
        PanelFechas.setLayout(PanelFechasLayout);
        PanelFechasLayout.setHorizontalGroup(
            PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFechasLayout.createSequentialGroup()
                        .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFechasLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFechasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscarHab)
                .addContainerGap())
        );
        PanelFechasLayout.setVerticalGroup(
            PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jdIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jbBuscarHab)
                .addGap(19, 19, 19))
        );

        PanelHuesped.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel14.setText("D N I:");

        jLabel15.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel15.setText("Nombre:");

        jLabel18.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel18.setText("Apellido:");

        jLabel19.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel19.setText("Direccion:");

        jLabel20.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel20.setText("Correo:");

        jlNombre.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre.setText("------------------------");

        jtDNI.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jlApellido.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jlApellido.setForeground(new java.awt.Color(255, 255, 255));
        jlApellido.setText("------------------------");

        jlDireccion.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jlDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jlDireccion.setText("------------------------");

        jlCorreo.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jlCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jlCorreo.setText("------------------------");

        jbBuscarDNI.setText("Buscar");
        jbBuscarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarDNIActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel21.setText("Telefono:");

        jlTelefono.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jlTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jlTelefono.setText("------------------------");

        javax.swing.GroupLayout PanelHuespedLayout = new javax.swing.GroupLayout(PanelHuesped);
        PanelHuesped.setLayout(PanelHuespedLayout);
        PanelHuespedLayout.setHorizontalGroup(
            PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHuespedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21))
                .addGap(48, 48, 48)
                .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHuespedLayout.createSequentialGroup()
                        .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))
                    .addGroup(PanelHuespedLayout.createSequentialGroup()
                        .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarDNI)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelHuespedLayout.setVerticalGroup(
            PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHuespedLayout.createSequentialGroup()
                .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jlNombre))
                .addGap(18, 18, 18)
                .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jlDireccion))
                .addGap(18, 18, 18)
                .addGroup(PanelHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHuespedLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21))
                    .addGroup(PanelHuespedLayout.createSequentialGroup()
                        .addComponent(jlCorreo)
                        .addGap(18, 18, 18)
                        .addComponent(jlTelefono)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        PanelReservas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Reservas Confirmadas");

        jtReserv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtReserv);

        jbCancelar.setText("Cancelar Reserva");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelReservasLayout = new javax.swing.GroupLayout(PanelReservas);
        PanelReservas.setLayout(PanelReservasLayout);
        PanelReservasLayout.setHorizontalGroup(
            PanelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservasLayout.createSequentialGroup()
                .addGroup(PanelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelReservasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelReservasLayout.createSequentialGroup()
                        .addGroup(PanelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelReservasLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelReservasLayout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel4)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelReservasLayout.setVerticalGroup(
            PanelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addContainerGap())
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbReservar.setText("Realizar Reservas");
        jbReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReservarActionPerformed(evt);
            }
        });

        jlMontoTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlMontoTotal.setText("$-");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Total: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(jlMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbReservar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PanelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jlMontoTotal)))))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        Huesped h = hd.buscarHuespedPorDni(jtDNI.getText());
        LocalDate ingreso = jdIngreso.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate salida = jdSalida.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long dias = salida.toEpochDay() - ingreso.toEpochDay();
        
        List<Habitacion> habSelec = new ArrayList<>();
        
        for (int i = 0; i <= jtHab.getRowCount(); i++) {                         // Lista con habitaciones seleccionadas

            if (jtHab.isRowSelected(i)) {
                Habitacion habitacion = new Habitacion();
                TipoHabitacion tipo = new TipoHabitacion();
                habitacion.setPiso(Integer.parseInt(modeloH.getValueAt(i, 0).toString()));
                habitacion.setNroHabitacion(Integer.parseInt(modeloH.getValueAt(i, 1).toString()));
                tipo.setPrecioPorNoche((double) modeloH.getValueAt(i, 5));
                habitacion.setIdTipoHabitacion(tipo);
                
                habSelec.add(habitacion);                                       
                modeloH.removeRow(i);                                           // Borro la fila de la tabla habitaciones
            }
        }
        // Cargo tabla de reservas confirmadas
        for (int x = 0; x <= habSelec.size() - 1; x++) {
            PrecioTotal = PrecioTotal + habSelec.get(x).getIdTipoHabitacion().getPrecioPorNoche() * dias;
            modeloR.addRow(new Object[]{h.getDni(), ingreso, salida,
                habSelec.get(x).getPiso(), habSelec.get(x).getNroHabitacion(), habSelec.get(x).getIdTipoHabitacion().getPrecioPorNoche() * dias});
        }
        
        jlMontoTotal.setText(PrecioTotal + "");
        

    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbBuscarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDNIActionPerformed
        Huesped h = hd.buscarHuespedPorDni(jtDNI.getText());
        jlApellido.setText(h.getApellido());
        jlCorreo.setText(h.getCorreo());
        jlDireccion.setText(h.getDireccion());
        jlNombre.setText(h.getNombre());
        jlTelefono.setText(h.getTelefono());

    }//GEN-LAST:event_jbBuscarDNIActionPerformed

    private void jbBuscarHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarHabActionPerformed
        borrarFilas(modeloH);
        try {
            int personas = Integer.parseInt(jtCantPersonas.getText());
            //Validaciones fecha y cant personas
            if (personas == 0 || jdIngreso == null || jdSalida == null || jdIngreso.getDate().before(Date.valueOf(LocalDate.now()))) {
                JOptionPane.showMessageDialog(null, "Ingrese datos válidos.");
                
            } else {
                LocalDate ingreso = jdIngreso.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate salida = jdSalida.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
                List<Habitacion> lista = new ArrayList<>();
                List<TipoHabitacion> tipos = thD.listaTipoHab();
                
                switch (personas) {                                             //Switch para llenar lista 
                    case 1:
                        lista.clear();
                        lista = habD.listarPorCategoria(tipos.get(0));
                        lista.addAll(habD.listarPorCategoria(tipos.get(4)));    // Simples y Suite Lujo
                        lista.addAll(habD.listarPorCategoria(tipos.get(5)));
                        
                        break;
                    case 2:
                        lista.clear();
                        lista = habD.listarPorCategoria(tipos.get(1));
                        lista.addAll(habD.listarPorCategoria(tipos.get(2)));    // Dobles, Triple y Suite Lujo
                        lista.addAll(habD.listarPorCategoria(tipos.get(3)));
                        lista.addAll(habD.listarPorCategoria(tipos.get(5)));
                        
                        break;
                    case 3:
                        lista.clear();
                        lista = habD.listarPorCategoria(tipos.get(3));                     // Triples
                        break;
                    
                }
                // Reservas que coinciden con las fechas de ingreso y salida, o estan en el medio.
                List<ReservaHuesped> reservas = rd.buscarReservasXfecha(ingreso, salida);
                
                for (int i = lista.size() - 1; i >= 0; i--) {
                    boolean ocupada = false;
                    Habitacion hab = lista.get(i);
                    
                    for (ReservaHuesped reserva : reservas) {
                        
                        if (reserva.getIdHabitacion().getIdHabitacion() == hab.getIdHabitacion()) {
                            ocupada = true;
                            break;
                        }
                        
                    }
                    if (ocupada == true) {                                      // Elimino de la lista las habitacion ocupadas en esa fecha, segun las reservas obtenidas.
                        lista.remove(i);
                    }
                }
                
                for (Habitacion habitacion : lista) {
                    modeloH.addRow(new Object[]{
                        habitacion.getPiso(),
                        habitacion.getNroHabitacion(),
                        habitacion.getIdTipoHabitacion().getTipo(),
                        habitacion.getIdTipoHabitacion().getCantidadCamas(),
                        habitacion.getIdTipoHabitacion().getTipoCamas(),
                        habitacion.getIdTipoHabitacion().getPrecioPorNoche()
                    
                    });
                }
                
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato");
            
        }
        

    }//GEN-LAST:event_jbBuscarHabActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        try {
            PrecioTotal = PrecioTotal - ((double) modeloR.getValueAt(jtReserv.getSelectedRow(), 5));
            modeloR.removeRow(jtReserv.getSelectedRow());
          
            
            jlMontoTotal.setText(PrecioTotal + "");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No hay reservas para cancelar.");
        }

    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReservarActionPerformed
        for (int i = 0; i <= jtReserv.getRowCount() - 1; i++) {
            LocalDate ingreso = jdIngreso.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate salida = jdSalida.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            rd.hacerReserva(hd.buscarHuespedPorDni(jtDNI.getText()),
                    habD.buscarHabitacion((int) modeloR.getValueAt(i, 4), (int) modeloR.getValueAt(i, 3)),
                    ingreso, salida, Integer.parseInt(jtCantPersonas.getText()));
            
        }
        
        borrarFilas(modeloR);
        

    }//GEN-LAST:event_jbReservarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFechas;
    private javax.swing.JPanel PanelHabitacion;
    private javax.swing.JPanel PanelHuesped;
    private javax.swing.JPanel PanelReservas;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbBuscarDNI;
    private javax.swing.JButton jbBuscarHab;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbReservar;
    private com.toedter.calendar.JDateChooser jdIngreso;
    private com.toedter.calendar.JDateChooser jdSalida;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlDireccion;
    private javax.swing.JLabel jlMontoTotal;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JTextField jtCantPersonas;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTable jtHab;
    private javax.swing.JTable jtReserv;
    // End of variables declaration//GEN-END:variables

    public void cargarCabeceras() {
        modeloH.addColumn("Piso");
        modeloH.addColumn("N°Habitacion");
        modeloH.addColumn("Tipo");
        
        modeloH.addColumn("Cama/s");
        modeloH.addColumn("T.Cama/s");
        modeloH.addColumn("Precio X noche($");
        jtHab.setModel(modeloH);
        
        modeloR.addColumn("DNI");
        modeloR.addColumn("Ingreso");
        modeloR.addColumn("Salida");
        modeloR.addColumn("Piso");
        modeloR.addColumn("N°Habitacion");
        modeloR.addColumn("Precio");
        jtReserv.setModel(modeloR);
        
    }
    
    public void borrarFilas(DefaultTableModel modelo) {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
        
    }
    
}
