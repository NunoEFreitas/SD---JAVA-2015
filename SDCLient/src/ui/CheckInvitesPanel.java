package ui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rmi.InviteLocal;
import sd.Client;
import sd.SD;
import rmi.InviteRemote;
import sd.Contact;
import sd.ListInvites;

public class CheckInvitesPanel extends javax.swing.JFrame {

    /**
     * Creates new form CheckInvitesPanel
     */
    SD system;
    ListInvites li = new ListInvites();
    InviteLocal invite = new InviteLocal();

    public CheckInvitesPanel(SD system) {
        this.system = system;
        initComponents();
        ArrayList<Contact> inviteList;
        inviteList = system.li.getInviteList();
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(inviteList.size());
        jTable1.setModel(dtm);

        for (int i = 0; i < inviteList.size(); i++) {
            String nome = inviteList.get(i).getNome();
            String curso = inviteList.get(i).getCurso();
            String email = inviteList.get(i).getEmail();
            jTable1.setValueAt(nome, i, 0);
            jTable1.setValueAt(curso, i, 1);
            jTable1.setValueAt(email, i, 2);
            ;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Curso", "Email", "Accept", "Reject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/round_ok.png"))); // NOI18N
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Client cl = system.lc.getClient();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if ((jTable1.getModel().getValueAt(i, 3) != null && jTable1.getModel().getValueAt(i, 4) == null)) {
                Contact c = new Contact();
                c = system.getInvite(jTable1.getModel().getValueAt(i, 2).toString());
                system.insertContact(c);
                system.removeInvite(c);
                system.save();
                dispose();
                System.out.println("Convite aceite");
                try {
                    invite.sendAnswer(c.getIp(), cl.getIp(), cl.getNome(), cl.getNome(), cl.getEmail(), true, cl.getToken());
                } catch (RemoteException ex) {
                    Logger.getLogger(CheckInvitesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ((jTable1.getModel().getValueAt(i, 3) == null && jTable1.getModel().getValueAt(i, 4) != null)) {
                Contact c = new Contact();
                c = system.getInvite(jTable1.getModel().getValueAt(i, 2).toString());
                system.removeInvite(c);
                system.save();
                dispose();
                System.out.println("Convite rejeitado");
                try {
                    invite.sendAnswer(c.getIp(), cl.getIp(), cl.getNome(), cl.getNome(), cl.getEmail(), false, cl.getToken());
                } catch (RemoteException ex) {
                    Logger.getLogger(CheckInvitesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ((jTable1.getModel().getValueAt(i, 3) != null && jTable1.getModel().getValueAt(i, 4) != null)) {

                System.out.println("Selecione uma e so uma opcao");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
