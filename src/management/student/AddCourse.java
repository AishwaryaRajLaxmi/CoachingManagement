
package management.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AddCourse extends javax.swing.JFrame {

    /**
     * Creates new form AddBatch
     */
    public AddCourse() {
        initComponents();
    }

    Connection con;
    PreparedStatement pat;
    ResultSet rs;

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCourse = new javax.swing.JTextField();
        btnCreateCourse = new javax.swing.JButton();
        CancelCourse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setText("Course ");

        btnCreateCourse.setText("ADD COURSE");
        btnCreateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCourseActionPerformed(evt);
            }
        });

        CancelCourse.setText("Cancel");
        CancelCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel3Layout = new javax.swing.GroupLayout(jpanel3);
        jpanel3.setLayout(jpanel3Layout);
        jpanel3Layout.setHorizontalGroup(
            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel3Layout.createSequentialGroup()
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel3Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel2)
                        .addGap(110, 110, 110)
                        .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnCreateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(CancelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jpanel3Layout.setVerticalGroup(
            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(116, 116, 116)
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(297, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCourseActionPerformed
        // TODO add your handling code here:
        String CName = txtCourse.getText();


        try {
            
             if (CName.isEmpty()) {
                JOptionPane.showMessageDialog(this ,"Feild must not be empty");
                return;
             }
             
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/coaching_management_db", "root", "Tanu@123");
            //            pat = con.prepareStatement("select * from admin_tbl where mobile='" + userName + "' OR email='" + userName + "'");
            pat = con.prepareStatement("insert into course_tbl (name) values(?)");
            //            rs = pat.executeQuery();
            System.out.print(pat);
            pat.setString(1, CName);
           
            pat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course created.....");
            this.hide();
            Course c=new Course();
            c.setVisible(true);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCourse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCreateCourseActionPerformed

    private void CancelCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelCourseActionPerformed
        // TODO add your handling code here:
        this.hide();
        Course a =new Course();
        a.setVisible(true);
    }//GEN-LAST:event_CancelCourseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelCourse;
    private javax.swing.JButton btnCreateCourse;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpanel3;
    private javax.swing.JTextField txtCourse;
    // End of variables declaration//GEN-END:variables
}
