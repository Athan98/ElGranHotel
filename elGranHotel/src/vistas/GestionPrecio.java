/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.*;
import entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class GestionPrecio extends javax.swing.JInternalFrame {
    
    Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    TipoHabitacion_data thd = new TipoHabitacion_data(con);
    TipoHabitacion th = new TipoHabitacion();

    DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int fila, int col) {
            if (col == 4) {
                return true;
            } else {
                return false;
            }
        }
        
    };
    
    
    public GestionPrecio() {
        initComponents();
        cargarCabeceras();
        cargartabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPrecios = new javax.swing.JTable();
        jpBotonera = new javax.swing.JPanel();
        jbActualizar = new javax.swing.JButton();

        jtPrecios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtPrecios.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPrecios.setRowHeight(25);
        jtPrecios.getTableHeader().setResizingAllowed(false);
        jtPrecios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtPrecios);

        javax.swing.GroupLayout jpTablaLayout = new javax.swing.GroupLayout(jpTabla);
        jpTabla.setLayout(jpTablaLayout);
        jpTablaLayout.setHorizontalGroup(
            jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpTablaLayout.setVerticalGroup(
            jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        jbActualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbActualizar.setText("Actualizar Precios");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoneraLayout = new javax.swing.GroupLayout(jpBotonera);
        jpBotonera.setLayout(jpBotoneraLayout);
        jpBotoneraLayout.setHorizontalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jbActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBotoneraLayout.setVerticalGroup(
            jpBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        List<TipoHabitacion> listatipos = new ArrayList<>();
        listatipos = thd.listaTipoHab();
        double precio;
        
        for (int i = 0; i < listatipos.size(); i++) {
            precio = Double.parseDouble(jtPrecios.getValueAt(i, 4).toString());
            if(precio < 0){
                JOptionPane.showMessageDialog(null, "Ingrese un monto válido");
                break;
            }else{
                thd.actualizarPrecio(precio, i+1);
                if (i==listatipos.size()-1) {
                    JOptionPane.showMessageDialog(null, "Se han actualizado los precios");
                }
            }            
        }
        
    }//GEN-LAST:event_jbActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JPanel jpBotonera;
    private javax.swing.JPanel jpTabla;
    private javax.swing.JTable jtPrecios;
    // End of variables declaration//GEN-END:variables

    public void cargarCabeceras(){
        modelo.addColumn("Tipo");
        modelo.addColumn("Cant. Personas");
        modelo.addColumn("Cant. Camas");
        modelo.addColumn("Tipo Cama");
        modelo.addColumn("Precio por Noche");        
        jtPrecios.setModel(modelo);
    }
    
    public void cargartabla(){
        List<TipoHabitacion> listatipos = new ArrayList<>();
        listatipos = thd.listaTipoHab();
        
        for (TipoHabitacion tipo : listatipos) {
            modelo.addRow(new Object[]{
                tipo.getTipo(),
                tipo.getCantidadPersonas(),
                tipo.getCantidadCamas(),
                tipo.getTipoCamas(),
                tipo.getPrecioPorNoche()
            });
        }
    }
}
