/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package budgee;

import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Salupado
 */
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    CardLayout cardLayout;
    public mainFrame() {
        initComponents();
        Component [] components = this.getContentPane().getComponents();
        
        for (Component component : components)
        {
            if (component instanceof JButton)
            {
                ((JButton) component).setUI(new BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }
        
        cardLayout = (CardLayout)(panel_cards.getLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_header = new javax.swing.JPanel();
        panel_logo = new javax.swing.JPanel();
        label_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_functions = new javax.swing.JPanel();
        button_records = new javax.swing.JButton();
        button_analytics = new javax.swing.JButton();
        button_budget = new javax.swing.JButton();
        button_accounts = new javax.swing.JButton();
        button_categories = new javax.swing.JButton();
        panel_cards = new javax.swing.JPanel();
        panel_records = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel_analytics = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panel_budget = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panel_accounts = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panel_categories = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Budgee");
        setBackground(new java.awt.Color(100, 151, 155));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setName("home_frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 600));

        panel_header.setBackground(new java.awt.Color(71, 92, 122));
        panel_header.setMaximumSize(new java.awt.Dimension(32767, 100));
        panel_header.setPreferredSize(new java.awt.Dimension(111, 100));

        panel_logo.setBackground(new java.awt.Color(71, 92, 122));

        label_logo.setBackground(new java.awt.Color(71, 92, 122));
        label_logo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        label_logo.setForeground(new java.awt.Color(255, 255, 255));
        label_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_logo.setText("budgee");
        label_logo.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/budgee/img/budgee_logo.png"))); // NOI18N

        javax.swing.GroupLayout panel_logoLayout = new javax.swing.GroupLayout(panel_logo);
        panel_logo.setLayout(panel_logoLayout);
        panel_logoLayout.setHorizontalGroup(
            panel_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_logoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panel_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_logoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addComponent(label_logo))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panel_logoLayout.setVerticalGroup(
            panel_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_logoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_headerLayout = new javax.swing.GroupLayout(panel_header);
        panel_header.setLayout(panel_headerLayout);
        panel_headerLayout.setHorizontalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_headerLayout.createSequentialGroup()
                .addComponent(panel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_headerLayout.setVerticalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panel_functions.setBackground(new java.awt.Color(71, 92, 122));
        panel_functions.setMaximumSize(new java.awt.Dimension(150, 1000));
        panel_functions.setMinimumSize(new java.awt.Dimension(150, 35));
        panel_functions.setPreferredSize(new java.awt.Dimension(150, 1000));
        panel_functions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        button_records.setBackground(new java.awt.Color(104, 93, 121));
        button_records.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button_records.setForeground(new java.awt.Color(255, 255, 255));
        button_records.setText("Records");
        button_records.setBorderPainted(false);
        button_records.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_records.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button_records.setMaximumSize(new java.awt.Dimension(150, 50));
        button_records.setMinimumSize(new java.awt.Dimension(150, 50));
        button_records.setPreferredSize(new java.awt.Dimension(150, 50));
        button_records.setSelected(true);
        button_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_recordsActionPerformed(evt);
            }
        });
        panel_functions.add(button_records);

        button_analytics.setBackground(new java.awt.Color(104, 93, 121));
        button_analytics.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button_analytics.setForeground(new java.awt.Color(255, 255, 255));
        button_analytics.setText("Analytics");
        button_analytics.setBorderPainted(false);
        button_analytics.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_analytics.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button_analytics.setMaximumSize(new java.awt.Dimension(150, 50));
        button_analytics.setMinimumSize(new java.awt.Dimension(150, 50));
        button_analytics.setPreferredSize(new java.awt.Dimension(150, 50));
        button_analytics.setSelected(true);
        button_analytics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_analyticsActionPerformed(evt);
            }
        });
        panel_functions.add(button_analytics);

        button_budget.setBackground(new java.awt.Color(104, 93, 121));
        button_budget.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button_budget.setForeground(new java.awt.Color(255, 255, 255));
        button_budget.setText("Budget");
        button_budget.setBorderPainted(false);
        button_budget.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_budget.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button_budget.setMaximumSize(new java.awt.Dimension(150, 50));
        button_budget.setMinimumSize(new java.awt.Dimension(150, 50));
        button_budget.setPreferredSize(new java.awt.Dimension(150, 50));
        button_budget.setSelected(true);
        button_budget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_budgetActionPerformed(evt);
            }
        });
        panel_functions.add(button_budget);

        button_accounts.setBackground(new java.awt.Color(104, 93, 121));
        button_accounts.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button_accounts.setForeground(new java.awt.Color(255, 255, 255));
        button_accounts.setText("Accounts");
        button_accounts.setBorderPainted(false);
        button_accounts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_accounts.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button_accounts.setMaximumSize(new java.awt.Dimension(150, 50));
        button_accounts.setMinimumSize(new java.awt.Dimension(150, 50));
        button_accounts.setPreferredSize(new java.awt.Dimension(150, 50));
        button_accounts.setSelected(true);
        button_accounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_accountsActionPerformed(evt);
            }
        });
        panel_functions.add(button_accounts);

        button_categories.setBackground(new java.awt.Color(104, 93, 121));
        button_categories.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button_categories.setForeground(new java.awt.Color(255, 255, 255));
        button_categories.setText("Categories");
        button_categories.setBorderPainted(false);
        button_categories.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_categories.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button_categories.setMaximumSize(new java.awt.Dimension(150, 50));
        button_categories.setMinimumSize(new java.awt.Dimension(150, 50));
        button_categories.setPreferredSize(new java.awt.Dimension(150, 50));
        button_categories.setSelected(true);
        button_categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_categoriesActionPerformed(evt);
            }
        });
        panel_functions.add(button_categories);

        panel_cards.setLayout(new java.awt.CardLayout());

        jLabel2.setText("records");

        javax.swing.GroupLayout panel_recordsLayout = new javax.swing.GroupLayout(panel_records);
        panel_records.setLayout(panel_recordsLayout);
        panel_recordsLayout.setHorizontalGroup(
            panel_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
            .addGroup(panel_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_recordsLayout.createSequentialGroup()
                    .addContainerGap(380, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(420, Short.MAX_VALUE)))
        );
        panel_recordsLayout.setVerticalGroup(
            panel_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(panel_recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_recordsLayout.createSequentialGroup()
                    .addContainerGap(269, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(283, Short.MAX_VALUE)))
        );

        panel_cards.add(panel_records, "panel_records");

        jLabel3.setText("analytics");

        javax.swing.GroupLayout panel_analyticsLayout = new javax.swing.GroupLayout(panel_analytics);
        panel_analytics.setLayout(panel_analyticsLayout);
        panel_analyticsLayout.setHorizontalGroup(
            panel_analyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
            .addGroup(panel_analyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_analyticsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_analyticsLayout.setVerticalGroup(
            panel_analyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(panel_analyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_analyticsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel_cards.add(panel_analytics, "panel_analytics");

        jLabel4.setText("budget");

        javax.swing.GroupLayout panel_budgetLayout = new javax.swing.GroupLayout(panel_budget);
        panel_budget.setLayout(panel_budgetLayout);
        panel_budgetLayout.setHorizontalGroup(
            panel_budgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
            .addGroup(panel_budgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_budgetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_budgetLayout.setVerticalGroup(
            panel_budgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(panel_budgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_budgetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel_cards.add(panel_budget, "panel_budget");

        jLabel5.setText("accounts");

        javax.swing.GroupLayout panel_accountsLayout = new javax.swing.GroupLayout(panel_accounts);
        panel_accounts.setLayout(panel_accountsLayout);
        panel_accountsLayout.setHorizontalGroup(
            panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
            .addGroup(panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_accountsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_accountsLayout.setVerticalGroup(
            panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(panel_accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_accountsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel_cards.add(panel_accounts, "panel_accounts");

        jLabel6.setText("categories");

        javax.swing.GroupLayout panel_categoriesLayout = new javax.swing.GroupLayout(panel_categories);
        panel_categories.setLayout(panel_categoriesLayout);
        panel_categoriesLayout.setHorizontalGroup(
            panel_categoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
            .addGroup(panel_categoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_categoriesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_categoriesLayout.setVerticalGroup(
            panel_categoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(panel_categoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_categoriesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel_cards.add(panel_categories, "panel_categories");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_header, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_functions, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_functions, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_cards, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_recordsActionPerformed
        cardLayout.show(panel_cards, "panel_records");
    }//GEN-LAST:event_button_recordsActionPerformed

    private void button_analyticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_analyticsActionPerformed
        cardLayout.show(panel_cards, "panel_analytics");
    }//GEN-LAST:event_button_analyticsActionPerformed

    private void button_budgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_budgetActionPerformed
        cardLayout.show(panel_cards, "panel_budget");
    }//GEN-LAST:event_button_budgetActionPerformed

    private void button_accountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_accountsActionPerformed
        cardLayout.show(panel_cards, "panel_accounts");
    }//GEN-LAST:event_button_accountsActionPerformed

    private void button_categoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_categoriesActionPerformed
        cardLayout.show(panel_cards, "panel_categories");
    }//GEN-LAST:event_button_categoriesActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_accounts;
    private javax.swing.JButton button_analytics;
    private javax.swing.JButton button_budget;
    private javax.swing.JButton button_categories;
    private javax.swing.JButton button_records;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_logo;
    private javax.swing.JPanel panel_accounts;
    private javax.swing.JPanel panel_analytics;
    private javax.swing.JPanel panel_budget;
    private javax.swing.JPanel panel_cards;
    private javax.swing.JPanel panel_categories;
    private javax.swing.JPanel panel_functions;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_logo;
    private javax.swing.JPanel panel_records;
    // End of variables declaration//GEN-END:variables
}
