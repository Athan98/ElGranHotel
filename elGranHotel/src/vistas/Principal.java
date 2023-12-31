/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Conexion;
import data.Habitacion_data;
import data.Reserva_data;
import entidades.ReservaHuesped;
import entidades.Habitacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    private Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    private Habitacion_data habd = new Habitacion_data(con);
    private Reserva_data rd = new Reserva_data(con);
    private Reserva_Vista RV = new Reserva_Vista();
    private Huesped_vista HV = new Huesped_vista();
    private Habitacion_vista HABV = new Habitacion_vista();

    public static DefaultTableModel modeloCI = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public static DefaultTableModel modeloCO = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public Principal() {
        initComponents();
        actualizarReservas();
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        actualizarFechaHora();
        armarCabeceraTablas();
        llenarTablas(modeloCI, modeloCO);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/texturaHormigon.jpg")); Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jpCheck = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableCI = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableCO = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmMenu1 = new javax.swing.JMenu();
        jmGestionHuesped = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmGestionHab = new javax.swing.JMenuItem();
        jReservas = new javax.swing.JMenu();
        jmReservas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("El gran hotel "
        );

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jpCheck.setBackground(new java.awt.Color(51, 51, 51));
        jpCheck.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpCheck.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movimiento diario");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHECK-IN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 2, 24), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 500));

        jtableCI.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtableCI);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHECK-OUT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 2, 24), new java.awt.Color(255, 153, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 500));

        jtableCO.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtableCO);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpCheckLayout = new javax.swing.GroupLayout(jpCheck);
        jpCheck.setLayout(jpCheckLayout);
        jpCheckLayout.setHorizontalGroup(
            jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCheckLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCheckLayout.setVerticalGroup(
            jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 20, 32);
        jPanel3.add(jpCheck, gridBagConstraints);

        escritorio.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));

        jmMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jmMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jmMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jmMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/huespIcon.png"))); // NOI18N
        jmMenu1.setText("Huespedes");
        jmMenu1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        jmGestionHuesped.setBackground(new java.awt.Color(51, 51, 51));
        jmGestionHuesped.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jmGestionHuesped.setForeground(new java.awt.Color(51, 51, 51));
        jmGestionHuesped.setText("Gestión Huespedes");
        jmGestionHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionHuespedActionPerformed(evt);
            }
        });
        jmMenu1.add(jmGestionHuesped);

        jMenuBar1.add(jmMenu1);

        jMenu2.setBackground(new java.awt.Color(51, 51, 51));
        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/habIcon.png"))); // NOI18N
        jMenu2.setText("Habitaciones");
        jMenu2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        jmGestionHab.setBackground(new java.awt.Color(51, 51, 51));
        jmGestionHab.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jmGestionHab.setForeground(new java.awt.Color(51, 51, 51));
        jmGestionHab.setText("Gestión Habitaciones");
        jmGestionHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionHabActionPerformed(evt);
            }
        });
        jMenu2.add(jmGestionHab);

        jMenuBar1.add(jMenu2);

        jReservas.setBackground(new java.awt.Color(51, 51, 51));
        jReservas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jReservas.setForeground(new java.awt.Color(51, 51, 51));
        jReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reservaIcon.png"))); // NOI18N
        jReservas.setText("Reservas");
        jReservas.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        jmReservas.setBackground(new java.awt.Color(51, 51, 51));
        jmReservas.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jmReservas.setForeground(new java.awt.Color(51, 51, 51));
        jmReservas.setText("Gestión Reservas");
        jmReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReservasActionPerformed(evt);
            }
        });
        jReservas.add(jmReservas);

        jMenuBar1.add(jReservas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmGestionHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionHabActionPerformed

        if (!RV.isClosed() || RV.isVisible()) {
            RV.setVisible(false);
            escritorio.remove(RV);
        }
        if (!HV.isClosed() || HV.isVisible()) {
             HV.setVisible(false);
            escritorio.remove(HV);
        }

        escritorio.repaint();

        if (!HABV.isVisible() ) {
            HABV.setVisible(true);
            escritorio.add(HABV);
            escritorio.moveToFront(HABV);
        }
        //CENTRAR VENTANA
        HABV.setLocation((escritorio.getWidth() - HABV.getWidth()) / 2, (escritorio.getHeight() - HABV.getHeight()) / 2);
    }//GEN-LAST:event_jmGestionHabActionPerformed

    private void jmGestionHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionHuespedActionPerformed
        
        if (!RV.isClosed() || RV.isVisible()) {
             RV.setVisible(false);
            escritorio.remove(RV);
        }
        if (!HABV.isClosed() || HABV.isVisible()) {
             HABV.setVisible(false);
            escritorio.remove(HABV);
        }
        
        escritorio.repaint();
        if (!HV.isVisible()) {
            HV.setVisible(true);
            escritorio.add(HV);
            escritorio.moveToFront(HV);
        }
        //CENTRAR VENTANA
        HV.setLocation((escritorio.getWidth() - HV.getWidth()) / 2, (escritorio.getHeight() - HV.getHeight()) / 2);
    }//GEN-LAST:event_jmGestionHuespedActionPerformed

    private void jmReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReservasActionPerformed

        if (!HV.isClosed() || HV.isVisible()) {
             HV.setVisible(false);
            escritorio.remove(HV);
        }
        if (!HABV.isClosed() || HABV.isVisible()) {
             HABV.setVisible(false);
            escritorio.remove(HABV);
        }
        escritorio.repaint();
        if (!RV.isVisible()) {
            RV.setVisible(true);
            escritorio.add(RV);
            escritorio.moveToFront(RV);
        }
        //CENTRAR VENTANA
        RV.setLocation((escritorio.getWidth() - RV.getWidth()) / 2, (escritorio.getHeight() - RV.getHeight()) / 2);
    }//GEN-LAST:event_jmReservasActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu jReservas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jmGestionHab;
    private javax.swing.JMenuItem jmGestionHuesped;
    private javax.swing.JMenu jmMenu1;
    private javax.swing.JMenuItem jmReservas;
    private javax.swing.JPanel jpCheck;
    private javax.swing.JTable jtableCI;
    private javax.swing.JTable jtableCO;
    // End of variables declaration//GEN-END:variables

    private void actualizarReservas() { //Cambia a "ocupadas" las habitaciones con reserva del dia
        List<ReservaHuesped> listareserva = new ArrayList<>();
        List<Habitacion> listahab = new ArrayList<>();

        listahab = habd.listarHabitaciones();
        listareserva = rd.buscarReservasXfecha(LocalDate.now(), LocalDate.now());

        rd.finReserva();

        for (Habitacion hab : listahab) {
            habd.modificarDisponibilidad(hab.getNroHabitacion(), hab.getPiso(), false);
        }

        for (ReservaHuesped reserva : listareserva) {
            habd.modificarDisponibilidad(reserva.getIdHabitacion().getNroHabitacion(), reserva.getIdHabitacion().getPiso(), true);
        }

    }

    //HILO PARA ESTABLECER Y ACTUALIZAR FECHA Y HORA
    private void actualizarFechaHora() {
        Thread reloj = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            while (true) {
                String fechaHora = sdf.format(new Date());
                SwingUtilities.invokeLater(() -> setTitle("El Gran Hotel " + fechaHora));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        reloj.start();
    }


    private void armarCabeceraTablas() {
        modeloCI.addColumn("Fecha");
        modeloCI.addColumn("Nombre");
        modeloCI.addColumn("Telefono");
        modeloCI.addColumn("N° habitacion");
        modeloCI.addColumn("Piso");
        jtableCI.setModel(modeloCI);

        modeloCO.addColumn("Fecha");
        modeloCO.addColumn("Nombre");
        modeloCO.addColumn("Telefono");
        modeloCO.addColumn("N° habitacion");
        modeloCO.addColumn("Piso");
        jtableCO.setModel(modeloCO);
    }

    public void llenarTablas(DefaultTableModel modeloCI, DefaultTableModel modeloCO) {

        borrarFilas(modeloCO);
        borrarFilas(modeloCI);

        List<ReservaHuesped> listaReservas = rd.buscarReservasXfecha(LocalDate.now(), LocalDate.now());

        for (ReservaHuesped rh : listaReservas) {
            if (rh.getFechaIngreso().compareTo(LocalDate.now()) == 0) {
                modeloCI.addRow(new Object[]{
                    rh.getFechaIngreso(),
                    rh.getIdHuesped().getNombre(),
                    rh.getIdHuesped().getTelefono(),
                    rh.getIdHabitacion().getNroHabitacion(),
                    rh.getIdHabitacion().getPiso()

                });
            } else if (rh.getFechaSalida().compareTo(LocalDate.now()) == 0) {

                modeloCO.addRow(new Object[]{
                    rh.getFechaIngreso(),
                    rh.getIdHuesped().getNombre(),
                    rh.getIdHuesped().getTelefono(),
                    rh.getIdHabitacion().getNroHabitacion(),
                    rh.getIdHabitacion().getPiso()
                });
            }
        }

    }

    private void borrarFilas(DefaultTableModel modelo) {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }

    }
}
