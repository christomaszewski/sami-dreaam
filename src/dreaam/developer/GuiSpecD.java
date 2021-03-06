package dreaam.developer;

import sami.gui.GuiElementSpec;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import sami.engine.Mediator;

/**
 *
 * @author pscerri
 */
public class GuiSpecD extends javax.swing.JDialog {

    String[] types = {"Map", "Compass", "Weapon State", "Alert Window", "Weather"};

    HashMap<String, MyRenderer> mapping = new HashMap<String, MyRenderer>();

    /**
     * Creates new form GuiSpecD
     */
    public GuiSpecD(java.awt.Frame parent, boolean modal, ArrayList<GuiElementSpec> selected) {
        super(parent, modal);
        initComponents();

        mainP.setLayout(new GridLayout(0, 1));

        for (String string : types) {
            MyRenderer r = new MyRenderer(string);
            if (selected != null) {

                for (GuiElementSpec gUIElementSpec : selected) {
                    if (gUIElementSpec.matches(string)) {
                        r.setSelected();
                        r.s.setValue(gUIElementSpec.getRelativeSize());
                    }
                }

            }
            mainP.add(r);
            mapping.put(string, r);
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
        mainP = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.layout.GroupLayout mainPLayout = new org.jdesktop.layout.GroupLayout(mainP);
        mainP.setLayout(mainPLayout);
        mainPLayout.setHorizontalGroup(
            mainPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 524, Short.MAX_VALUE)
        );
        mainPLayout.setVerticalGroup(
            mainPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 408, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainP);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 528, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jButton1))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        setVisible(false);

        ArrayList<GuiElementSpec> elements = new ArrayList<GuiElementSpec>();

        for (String string : types) {
            MyRenderer r = mapping.get(string);
            if (r.isSelected()) {
                GuiElementSpec spec = new GuiElementSpec(string);
                spec.setRelativeSize(r.s.getValue());
                elements.add(spec);
            }
        }

        Mediator.getInstance().getProject().setGuiElements(elements);

    }//GEN-LAST:event_jButton1ActionPerformed

    private class MyRenderer extends JPanel {

        JCheckBox cb = new JCheckBox();
        JSlider s = new JSlider(0, 200, 100);

        public MyRenderer(Object o) {
            setLayout(new FlowLayout());
            cb.setEnabled(true);
            add(cb);
            add(new JLabel(o.toString()));
            add(s);
            setBorder(new EtchedBorder(2));
        }

        boolean isSelected() {
            return cb.isSelected();
        }

        private void setSelected() {
            cb.setSelected(true);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiSpecD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiSpecD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiSpecD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiSpecD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GuiSpecD dialog = new GuiSpecD(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainP;
    // End of variables declaration//GEN-END:variables
}
