    package komp;

/**
 *
 * @author Simon Johansson
 * Last updated 2015-06-01
 */
public class GUI extends javax.swing.JFrame {

    private final Libary Lib;
    private String filename;
    private int i;
    
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        Lib = new Libary();
        i = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rb_JSON = new javax.swing.JRadioButton();
        rb_XML = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_main = new javax.swing.JTextArea();
        lbl_first_name = new javax.swing.JLabel();
        txf_first_name = new javax.swing.JTextField();
        lbl_age = new javax.swing.JLabel();
        txf_age = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        lbl_phone = new javax.swing.JLabel();
        txf_phone = new javax.swing.JTextField();
        lbl_last_name = new javax.swing.JLabel();
        txf_last_name = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menubtn_explorer = new javax.swing.JMenuItem();
        menubtn_exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rb_JSON);
        rb_JSON.setText("JSON");

        buttonGroup1.add(rb_XML);
        rb_XML.setText("XML");

        txa_main.setEditable(false);
        txa_main.setColumns(20);
        txa_main.setRows(5);
        jScrollPane1.setViewportView(txa_main);

        lbl_first_name.setText("First Name:");

        lbl_age.setText("Age:");

        btn_save.setText("SAVE");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        lbl_phone.setText("Phone:");

        lbl_last_name.setText("Last Name:");

        jMenu1.setText("File");

        menubtn_explorer.setText("Explorer");
        menubtn_explorer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtn_explorerActionPerformed(evt);
            }
        });
        jMenu1.add(menubtn_explorer);

        menubtn_exit.setText("Exit");
        menubtn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtn_exitActionPerformed(evt);
            }
        });
        jMenu1.add(menubtn_exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_XML, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rb_JSON, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_first_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_phone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(lbl_age, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txf_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txf_last_name))
                            .addComponent(txf_age)
                            .addComponent(txf_phone))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(rb_XML)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_JSON)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_first_name)
                            .addComponent(txf_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_last_name)
                            .addComponent(txf_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_age)
                            .addComponent(txf_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_phone)
                            .addComponent(txf_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_save)
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * @param evt, Exits the program on click.
     */
    private void menubtn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menubtn_exitActionPerformed

    /**
     * Depending on what radiobutton is selected
     * Sends a int, which later on is used in a Switch-case in Libary.java
     * 
     * Also sends all txf Inputs from user to Libary.java->saveToFile
     * 
     * @param evt 1 or 0 for Switch
     */
    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(rb_XML.isSelected()){
            i = 1;
            Lib.saveToFile(txf_first_name.getText(),txf_last_name.getText(),txf_phone.getText(),Integer.parseInt(txf_age.getText()), i);
        }else if(rb_JSON.isSelected()){
            i = 0;
            Lib.saveToFile(txf_first_name.getText(),txf_last_name.getText(),txf_phone.getText(),Integer.parseInt(txf_age.getText()), i);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    /**
     * Resets the JTextArea to empty
     * 
     * Using the length and Math.min takes out the first 4 letters in the filename
     * (xml_ or json)
     * 
     * Which then is used in a Switch-case in Libary.java->readFile
     * Also sends the JTextArea so it can be manipulated with-in Libary.java
     * 
     * @param evt, onClick starts a JFileChooser from Libary.java
     */
    private void menubtn_explorerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtn_explorerActionPerformed
        txa_main.setText("");
        
        filename = Lib.getFile();
        String extension = filename.substring(0, Math.min(filename.length(), 4));
        Lib.readFile(extension,filename,txa_main);
        
    }//GEN-LAST:event_menubtn_explorerActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_age;
    private javax.swing.JLabel lbl_first_name;
    private javax.swing.JLabel lbl_last_name;
    private javax.swing.JLabel lbl_phone;
    private javax.swing.JMenuItem menubtn_exit;
    private javax.swing.JMenuItem menubtn_explorer;
    private javax.swing.JRadioButton rb_JSON;
    private javax.swing.JRadioButton rb_XML;
    private javax.swing.JTextArea txa_main;
    private javax.swing.JTextField txf_age;
    private javax.swing.JTextField txf_first_name;
    private javax.swing.JTextField txf_last_name;
    private javax.swing.JTextField txf_phone;
    // End of variables declaration//GEN-END:variables
}
