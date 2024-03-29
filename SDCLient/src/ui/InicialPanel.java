package ui;

import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;
import rmi.InviteRemote;
import rmi.Invite;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.Timer;
import javax.xml.ws.WebServiceException;
import rmi.MessageRemote;
import sd.Client;
import sd.Contact;
import sd.SD;

public class InicialPanel extends javax.swing.JFrame {

    /**
     * Creates new form incialPanel
     */
    //static SD system = new SD();
    static SD system = SD.loadFile();

    ;
    public InicialPanel() {
        initComponents();
        jLabel2.setVisible(false);
        /*
         if(system.checkClient()){
         jButton5.setEnabled(false);
         } else {
         jToggleButton1.setEnabled(false);
         jToggleButton2.setEnabled(false);
         jToggleButton3.setEnabled(false);
         jToggleButton4.setEnabled(false);
         jButton1.setEnabled(false);
         jButton2.setEnabled(false);
         jButton3.setEnabled(false);
         jButton4.setEnabled(false);
            
         }
         */
    }

    public void refresh() {
        this.setVisible(false);
        new InicialPanel().setVisible(true);
    }

    static String SERVICE_NAME = "/Invites";
    static String SERVICE_MESSAGE = "/Messages";
    static Invite stub;
    static rmi.Message stub_m;

    private static void bindRMI(InviteRemote inv) throws RemoteException {
        System.getProperties().put("java.security.policy", "./server.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {

        }

        LocateRegistry.getRegistry().rebind(SERVICE_NAME, inv);
        System.out.println("Servidor activo a espera de invites");

    }

    private static void bindRMImessage(MessageRemote mes) throws RemoteException {
        System.getProperties().put("java.security.policy", "./server.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            LocateRegistry.createRegistry(1100);
        } catch (RemoteException e) {

        }

        LocateRegistry.getRegistry().rebind(SERVICE_MESSAGE, mes);
        System.out.println("Servidor activo a espera de mensagens");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/sendInvite.png"))); // NOI18N
        jButton1.setText("Enviar Convite");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/checkSMS.png"))); // NOI18N
        jButton3.setText("Consultar Mensagens");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/edituser.png"))); // NOI18N
        jButton4.setText("Enviar Feed");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/add-user-icon.png"))); // NOI18N
        jButton5.setText("Registar Utilizador");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/CheckStatus.png"))); // NOI18N
        jButton2.setText("Consultar Feeds");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/SendSMS.png"))); // NOI18N
        jToggleButton1.setText("Enviar Mensagem");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/checkInvite.png"))); // NOI18N
        jToggleButton2.setText("Consultar Convites");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/checkContat.png"))); // NOI18N
        jToggleButton3.setText("Consultar Contactos");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/delete.png"))); // NOI18N
        jToggleButton4.setText("Remover Utilizador");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado do Sistema:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images2/logo_um_eng.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(290, 290, 290))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                                .addGap(0, 77, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jToggleButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (system.checkClient() == false) {
            RegisterPanel rp = new RegisterPanel(system);
            rp.setVisible(true);
            jLabel2.setVisible(false);
            //initComponents();

        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Utilizador ja registado");
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (system.checkClient() == true) {
            SendInvitesPanel cp = new SendInvitesPanel(system);
            cp.setVisible(true);
            jLabel2.setVisible(false);
            //initComponents();
        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (system.checkClient() == true) {
            StatusPanel sp = new StatusPanel(system);
            sp.setVisible(true);
            jLabel2.setVisible(false);
            //initComponents();
        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (system.checkClient() == true) {
            GetMessagesPanel gmp = new GetMessagesPanel(system);
            gmp.setVisible(true);
            jLabel2.setVisible(false);
            //initComponents();
        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (system.checkClient() == true) {
            SendMessagesPanel smp = new SendMessagesPanel(system);
            smp.setVisible(true);
            jLabel2.setVisible(false);
            //initComponents();
        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (system.checkClient() == true) {
            CheckInvitesPanel cip = new CheckInvitesPanel(system);
            cip.setVisible(true);
            jLabel2.setVisible(false);
        //initComponents();

        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (system.checkClient() == true) {
            CheckContactsPanel ccp = new CheckContactsPanel(system);
            ccp.setVisible(true);
            jLabel2.setVisible(false);
            //initComponents();
        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (system.checkClient() == true) {
            CheckStatusPanel csp = new CheckStatusPanel(system);
            csp.setVisible(true);
            jLabel2.setVisible(false);
            //initComponents();
        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        if (system.checkClient() == true) {
            system.removeRegister();
            system.save();
            jLabel2.setText("Utilizador Removido com sucesso");
            jLabel2.setVisible(true);
        } else {
            jLabel2.setVisible(true);
            jLabel2.setForeground(Color.red);
            jLabel2.setText("Não existe nenhum utilizador registado");
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnknownHostException {
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
            java.util.logging.Logger.getLogger(InicialPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicialPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicialPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicialPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicialPanel().setVisible(true);
            }
        });

        String ip = InetAddress.getLocalHost().toString();
        String[] ips = ip.split("/");
        if (system.checkClient()) {
            Client c = system.getClient();

            if (!c.getIp().equals(ips)) {
                c.setIp(ips[1]);
                String[] mac = {"00:00:00:00:0a:11", "00:00:00:00:0a:22", "00:00:00:00:0a:33", "00:00:00:00:0a:44"};
                int idx = new Random().nextInt(mac.length);
                c.setMacAddress(mac[idx]);
            }
        }

        InviteRemote inv = null;
        try {
            inv = new InviteRemote(system);
        } catch (RemoteException e1) {
            System.err.println("unexpected error...");
            e1.printStackTrace();
        }

        try {
            bindRMI(inv);
        } catch (RemoteException e1) {
            System.err.println("erro ao registar o stub...");
            e1.printStackTrace();
        }

        MessageRemote mes = null;
        try {
            mes = new MessageRemote(system);
        } catch (RemoteException e1) {
            System.err.println("unexpected error...");
            e1.printStackTrace();
        }

        try {
            bindRMImessage(mes);
        } catch (RemoteException e1) {
            System.err.println("erro ao registar o stub...");
            e1.printStackTrace();
        }

        while (true) {
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            if (system.checkClient()) {
                Client c = system.getClient();
                sendPresence(c.getIp(), c.getNome(), c.getCurso(), c.getEmail());

            }

        }
    }

    public static Boolean sendPresence(String ip, String nome, String curso, String email) {
        getContactList(ip, nome, curso, email);
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<webservices.Presences> getContactList(java.lang.String ip, java.lang.String nome, java.lang.String curso, java.lang.String email) throws WebServiceException {
        try {
            webservices.ContactManager_Service service = new webservices.ContactManager_Service();
            webservices.ContactManager port = service.getContactManagerPort();

            return port.getContactList(ip, nome, curso, email);
        } catch (WebServiceException e) {

        }
        return null;
    }
}
