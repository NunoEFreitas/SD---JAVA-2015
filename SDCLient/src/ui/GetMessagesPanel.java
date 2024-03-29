package ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.WebServiceException;
import sd.Client;
import sd.Contact;
import sd.SD;

public class GetMessagesPanel extends javax.swing.JFrame {

    SD system;

    public GetMessagesPanel(SD system) {
        this.system = system;
        initComponents();
        Client cl = system.lc.getClient();
        ArrayList<String> tokens = system.getTokens();
        if (getMessage(cl.getEmail(), tokens, cl.getMacAddress()) == null && getLocation(cl.getMacAddress()) == null) {
            jLabel1.setForeground(Color.red);
            jLabel1.setText("Servidor de Presenças OFF LINE, por favor tente mais tarde");
            jButton1.setEnabled(false);
        } else {

            jLabel1.setText("Location: " + getLocation(cl.getMacAddress()));

            List<webservices.Messages> messages = getMessage(cl.getEmail(), tokens, cl.getMacAddress());
            System.out.println(messages.size());
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(messages.size());
            jTable1.setModel(dtm);

            for (int i = 0; i < messages.size(); i++) {
                String from = messages.get(i).getOwner();
                String message = messages.get(i).getMessage();
                String mt = messages.get(i).getStatus();
                String coordenadas = messages.get(i).getCoordenadas();
                System.out.println(mt);
                jTable1.setValueAt(from, i, 0);
                jTable1.setValueAt(message, i, 1);
                jTable1.setValueAt(mt, i, 2);
                jTable1.setValueAt(coordenadas, i, 3);
                ;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "From", "Message", "Message Type", "Coordenadas", "Map"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/round_ok.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Location:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<webservices.Messages> getMessage(java.lang.String email, java.util.List<java.lang.String> tokens, java.lang.String macAddress) throws WebServiceException {
        try {
        webservices.ContactManager_Service service = new webservices.ContactManager_Service();
        webservices.ContactManager port = service.getContactManagerPort();
        
            return port.getMessage(email, tokens, macAddress);
        } catch (WebServiceException e) {

        }
        return null;
    }

    private static String getLocation(java.lang.String macAddress) throws WebServiceException {
        try {
            webservices.ContactManager_Service service = new webservices.ContactManager_Service();
            webservices.ContactManager port = service.getContactManagerPort();

            return port.getLocation(macAddress);
        } catch (WebServiceException e) {

        }
        return null;
    }

}
