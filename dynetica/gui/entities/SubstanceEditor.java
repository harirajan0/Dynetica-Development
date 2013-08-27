/*
 * SubstanceEditor.java
 *
 * Created on September 25, 2000, 6:03 PM
 * Last modified on July 07, 2002
 */

package dynetica.gui.entities;

/**
 * 
 * @author Lingchong You
 * @version 0.01
 */

// import javax.swing.JTree;
// import javax.swing.tree.*;

public class SubstanceEditor extends javax.swing.JPanel {

    private dynetica.entity.Substance substance;

    public SubstanceEditor(dynetica.entity.Substance substance) {
        this.substance = substance;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        labelPane = new javax.swing.JPanel();
        initialValueLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        minLabel = new javax.swing.JLabel();
        maxLabel = new javax.swing.JLabel();
        rExpressionLabel = new javax.swing.JLabel();
        fieldPane = new javax.swing.JPanel();
        initialValueField = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        min = new javax.swing.JTextField();
        max = new javax.swing.JTextField();
        rExpression = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setName("Substance Editor"); // NOI18N
        setLayout(new java.awt.BorderLayout(0, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html> <i> Substance </i>" + substance.getName());
        jLabel1.setMaximumSize(new java.awt.Dimension(181, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(181, 30));
        jLabel1.setPreferredSize(new java.awt.Dimension(181, 30));
        add(jLabel1, java.awt.BorderLayout.NORTH);

        jSplitPane2.setDividerSize(3);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane1.setDividerLocation(100);
        jSplitPane1.setDividerSize(1);
        jSplitPane1.setLastDividerLocation(100);

        labelPane.setLayout(new java.awt.GridLayout(5, 1));

        initialValueLabel
                .setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        initialValueLabel.setText("Initial value");
        initialValueLabel
                .setToolTipText("The initial level (concentration of number of molecules)\nof the substance.");
        initialValueLabel
                .setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        initialValueLabel.setMaximumSize(new java.awt.Dimension(400, 25));
        initialValueLabel.setMinimumSize(new java.awt.Dimension(100, 25));
        initialValueLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        labelPane.add(initialValueLabel);

        jLabel2.setText("Value");
        labelPane.add(jLabel2);

        minLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        minLabel.setText("Min");
        minLabel.setToolTipText("The minimum level of the substance.");
        minLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        minLabel.setMaximumSize(new java.awt.Dimension(400, 25));
        minLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        labelPane.add(minLabel);

        maxLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maxLabel.setText("Max");
        maxLabel.setToolTipText("The maximum level of the substance.");
        maxLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        maxLabel.setMaximumSize(new java.awt.Dimension(400, 25));
        maxLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        labelPane.add(maxLabel);

        rExpressionLabel
                .setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rExpressionLabel.setText("Rate expression");
        rExpressionLabel
                .setToolTipText("The rate expression for this substance");
        rExpressionLabel.setMaximumSize(new java.awt.Dimension(400, 25));
        rExpressionLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        rExpressionLabel
                .setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        labelPane.add(rExpressionLabel);

        jSplitPane1.setLeftComponent(labelPane);

        fieldPane.setMaximumSize(new java.awt.Dimension(150, 100));
        fieldPane.setLayout(new java.awt.GridLayout(5, 1));

        initialValueField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        initialValueField.setText(String.valueOf(substance.getInitialValue()));
        initialValueField.setMaximumSize(new java.awt.Dimension(400, 25));
        initialValueField.setPreferredSize(new java.awt.Dimension(106, 25));
        initialValueField
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        initialValueFieldActionPerformed(evt);
                    }
                });
        initialValueField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                initialValueFieldFocusLost(evt);
            }
        });
        fieldPane.add(initialValueField);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField1.setText(String.valueOf(substance.getValue()));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        fieldPane.add(jTextField1);

        min.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        min.setText(String.valueOf(substance.getMin()));
        min.setMaximumSize(new java.awt.Dimension(400, 25));
        min.setPreferredSize(new java.awt.Dimension(106, 25));
        min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minActionPerformed(evt);
            }
        });
        min.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                minFocusLost(evt);
            }
        });
        fieldPane.add(min);

        max.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        max.setText(String.valueOf(substance.getMax()));
        max.setMaximumSize(new java.awt.Dimension(400, 25));
        max.setPreferredSize(new java.awt.Dimension(106, 25));
        max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxActionPerformed(evt);
            }
        });
        max.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                maxFocusLost(evt);
            }
        });
        fieldPane.add(max);

        rExpression.setEditable(false);
        rExpression.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        rExpression.setText(getRateExpression());
        rExpression.setMaximumSize(new java.awt.Dimension(400, 25));
        rExpression.setPreferredSize(new java.awt.Dimension(106, 25));
        fieldPane.add(rExpression);

        jSplitPane1.setRightComponent(fieldPane);

        jSplitPane2.setLeftComponent(jSplitPane1);

        jPanel1.setBorder(javax.swing.BorderFactory
                .createTitledBorder("Annotation"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTextArea1.setLineWrap(true);
        jTextArea1.setText(substance.getAnnotation());
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel1);

        add(jSplitPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTextField1FocusLost
        substance.setValue(Double.parseDouble(jTextField1.getText()));
    }// GEN-LAST:event_jTextField1FocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        substance.setValue(Double.parseDouble(jTextField1.getText()));
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTextArea1FocusLost
        setAnnotation();
    }// GEN-LAST:event_jTextArea1FocusLost

    private void maxFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_maxFocusLost
        setSubstanceMax();
    }// GEN-LAST:event_maxFocusLost

    private void minFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_minFocusLost
        setSubstanceMin();
    }// GEN-LAST:event_minFocusLost

    private void initialValueFieldFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_initialValueFieldFocusLost
        setSubstanceInitialValue();
    }// GEN-LAST:event_initialValueFieldFocusLost

    private void maxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_maxActionPerformed
        setSubstanceMax();
    }// GEN-LAST:event_maxActionPerformed

    private void minActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_minActionPerformed
        setSubstanceMin();
    }// GEN-LAST:event_minActionPerformed

    private void initialValueFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_initialValueFieldActionPerformed
        setSubstanceInitialValue();
    }// GEN-LAST:event_initialValueFieldActionPerformed

    private void setAnnotation() {
        String newAnnotation = jTextArea1.getText();
        String oldOne = substance.getAnnotation();
        if (oldOne.compareTo(newAnnotation) != 0) {
            substance.getSystem().fireSystemStateChange();
            substance.setAnnotation(newAnnotation);
        }
    }

    private void setSubstanceMax() {
        double oldValue = substance.getMax();
        double newValue = Double.parseDouble(max.getText());
        if (oldValue != newValue) {
            substance.setMax(newValue);
            substance.getSystem().fireSystemStateChange();
        }
    }

    private void setSubstanceMin() {
        double oldValue = substance.getMin();
        double newValue = Double.parseDouble(min.getText());
        if (oldValue != newValue) {
            substance.setMin(newValue);
            substance.getSystem().fireSystemStateChange();
        }
    }

    private void setSubstanceInitialValue() {
        double oldValue = substance.getInitialValue();
        double newValue = Double.parseDouble(initialValueField.getText());
        if (oldValue != newValue) {
            substance.setInitialValue(newValue);
            substance.getSystem().fireSystemStateChange();
        }
    }

    private String getRateExpression() {
        if (substance.getRateExpression() != null)
            return substance.getRateExpression().toString();
        else
            return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fieldPane;
    private javax.swing.JTextField initialValueField;
    private javax.swing.JLabel initialValueLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel labelPane;
    private javax.swing.JTextField max;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JTextField min;
    private javax.swing.JLabel minLabel;
    private javax.swing.JTextField rExpression;
    private javax.swing.JLabel rExpressionLabel;
    // End of variables declaration//GEN-END:variables

}