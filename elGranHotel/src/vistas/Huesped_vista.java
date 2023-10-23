/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Huesped_vista extends javax.swing.JInternalFrame {

   
    GestionHuesped panelGH=new GestionHuesped();
    BusquedaHuesped panelBH=new BusquedaHuesped();

    
    public Huesped_vista() {
        initComponents();
        PanePrincipal.addTab("Agregar Huesped",panelGH);
        PanePrincipal.addTab("Busqueda",panelBH);
        PanePrincipal.setSelectedComponent(panelGH);


    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PanePrincipal = new javax.swing.JTabbedPane();

        setClosable(true);
        setTitle("Huespedes");
        setPreferredSize(new java.awt.Dimension(900, 650));

        PanePrincipal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PanePrincipalStateChanged(evt);
            }
        });
        jScrollPane1.setViewportView(PanePrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanePrincipalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PanePrincipalStateChanged
//       
//       
        panelBH.borrarFilas();
        panelBH.actualizarLista();

    }//GEN-LAST:event_PanePrincipalStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanePrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
