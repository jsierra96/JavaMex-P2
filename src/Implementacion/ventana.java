package Implementacion;
import pruebacup.*;
import java.awt.event.*;
import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author Joanan
 */
public class ventana extends javax.swing.JFrame {
int i=1;
    public ventana() {
        initComponents();
        tabla.setSelectionMode(0);
        tabla.setEnabled(false);
        tabla.setModel(new DefaultTableModel(
         new Object[0][],new String[] {"Token", "Descripcion" }));
        tabla.getColumnModel().getColumn(1).setPreferredWidth(171);
        scroll1.setViewportView(tabla);
        numeros.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        scroll1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        codigo = new javax.swing.JEditorPane();
        numeros = new javax.swing.JEditorPane();
        area2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 70, -1));

        jLabel1.setText("Terminal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel2.setText("Lista de Tokens:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jButton1.setText("Abrir archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll1.setViewportView(tabla);

        getContentPane().add(scroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 390, 370));

        jButton4.setText("Compilar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 0, 265, 370));

        numeros.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(numeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 26, 370));

        jScrollPane3.setViewportView(jPanel1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 310, 240));

        area2.setColumns(20);
        area2.setRows(5);
        getContentPane().add(area2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 310, 60));

        jLabel3.setText("Archivo abierto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       codigo.setText("");
       i=1;
       JFileChooser selectorArchivos = new JFileChooser();
       selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
       int resultado = selectorArchivos.showOpenDialog(this);
        try {
        File file = selectorArchivos.getSelectedFile();
        FileReader s = new FileReader(file);
	BufferedReader ss = new BufferedReader(s);
		try {
		    String line;
		    while ((line = ss.readLine()) != null) {
                        numeros.setText(numeros.getText() + i +"\r\n");
                        codigo.setText(codigo.getText() + line + "\r\n");
                        i++;
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
                //area1.setEditable(false);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tabla.setModel(new DefaultTableModel(new Object[0][],new String[] {"Token", "Descripcio"}));
        AnalizadorLexico lexico1 = new AnalizadorLexico(new StringReader(codigo.getText()));
        parte2 lexico = new parte2(new StringReader(codigo.getText()));
        parser sintactico = new parser(lexico);
        try {
            lexico1.yylex(tabla);
            sintactico.parse();
            //jTextField3.setText(sintactico.resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String error=sintactico.ms;
        if(error == null){
            area2.setText("Compilacion Exitosa");
            JOptionPane.showMessageDialog(null,"Compilacion exitosa");
        }else{
            area2.setText(error);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area2;
    private javax.swing.JEditorPane codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JEditorPane numeros;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
