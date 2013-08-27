/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynetica.gui.algorithms;

import dynetica.gui.algorithms.SensitivityAnalysisEditor;
import dynetica.gui.algorithms.MultiParameterSensitivityAnalysisEditor;
import dynetica.entity.Substance;
import dynetica.objective.*;
import dynetica.system.ReactiveSystem;
import java.util.List;
import javax.swing.*;

/**
 * 
 * @author Derek Eidum (2013)
 */
public class MetricEditor extends javax.swing.JPanel {

    DefaultComboBoxModel substanceBoxModel = new DefaultComboBoxModel();
    ReactiveSystem system;
    JFrame frame;
    JPanel parent;
    Substance substance;
    AbstractMetric metric;

    /**
     * Creates new form MetricEditor
     */
    public MetricEditor(JFrame jf, SensitivityAnalysisEditor e) {
        frame = jf;
        parent = e;
        system = e.system;
        initComponents();
        setUpBox();
        substance = (Substance) system.getEntity((String) substanceSelector
                .getSelectedItem());
    }

    public MetricEditor(JFrame jf, MultiParameterSensitivityAnalysisEditor e) {
        frame = jf;
        parent = e;
        system = e.getSystem();
        initComponents();
        setUpBox();
        substance = (Substance) system.getEntity((String) substanceSelector
                .getSelectedItem());
    }

    public MetricEditor(JFrame jf, SequentialTwoParameterScanEditor e) {
        frame = jf;
        parent = e;
        system = e.getSystem();
        initComponents();
        setUpBox();
        substance = (Substance) system.getEntity((String) substanceSelector
                .getSelectedItem());
    }

    public MetricEditor(JFrame jf, TargetObjectiveEditor toe) {
        frame = jf;
        parent = toe;
        system = toe.system;
        initComponents();
        setUpBox();
        substance = (Substance) system.getEntity((String) substanceSelector
                .getSelectedItem());
    }

    private void setUpBox() {
        List substanceList = system.getSubstances();
        for (Object o : substanceList) {
            substanceBoxModel.addElement(((Substance) o).getName());
        }
    }

    private void updateText() {
        if (metric == null) {
            return;
        }
        textField.setText(metric.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        substanceSelector = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        metricSelector = new javax.swing.JComboBox();
        textField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Substance");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14,
                -1, -1));

        substanceSelector.setModel(substanceBoxModel);
        substanceSelector
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        substanceSelectorActionPerformed(evt);
                    }
                });
        add(substanceSelector,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 11, 119,
                        -1));

        jLabel2.setText("Metric");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45,
                -1, -1));

        metricSelector.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Select a metric...", "Final Value",
                        "Time to Steady State", "Area Under Curve",
                        "Correlation Coefficient", "Maximum Value",
                        "Minimum Value", "Maximum Rate", "Range" }));
        metricSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metricSelectorActionPerformed(evt);
            }
        });
        add(metricSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                78, 42, 119, -1));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings
                .createAutoBinding(
                        org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
                        textField, org.jdesktop.beansbinding.ELProperty
                                .create("false"), textField,
                        org.jdesktop.beansbinding.BeanProperty
                                .create("editable"));
        bindingGroup.addBinding(binding);

        add(textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10,
                73, 187, -1));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(75,
                104, -1, -1));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void substanceSelectorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_substanceSelectorActionPerformed
        substance = (Substance) system.getEntity((String) substanceSelector
                .getSelectedItem());
        if (metric == null) {
            return;
        }
        metric.setSubstance(substance);
        updateText();
    }// GEN-LAST:event_substanceSelectorActionPerformed

    private void metricSelectorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_metricSelectorActionPerformed
        String selected = (String) metricSelector.getSelectedItem();
        if (selected.equalsIgnoreCase("Final Value")) {
            metric = new FinalValue(substance);
        } else if (selected.equalsIgnoreCase("Maximum Value")) {
            metric = new MaximumValue(substance);
        } else if (selected.equalsIgnoreCase("Minimum Value")) {
            metric = new MinimumValue(substance);
        } else if (selected.equalsIgnoreCase("Range")) {
            metric = new Range(substance);
        } else if (selected.equalsIgnoreCase("Maximum Rate")) {
            metric = new MaximumRate(substance);
        } else if (selected.equalsIgnoreCase("Area Under Curve")) {
            metric = new AreaUnderCurve(substance);
        } else if (selected.equalsIgnoreCase("Time to Steady State")) {
            double fraction = -1;
            while ((fraction < 0) || (fraction > 1)) {
                String fractionInput = JOptionPane.showInputDialog(this,
                        "Fraction of steady state reached? (Between 0 and 1) ");
                fraction = Double.parseDouble(fractionInput);
            }
            metric = new TimeToSteadyState(substance, fraction);
        } else if (selected.equalsIgnoreCase("Correlation Coefficient")) {
            String ts = "";
            while (!system.contains(ts)) {
                ts = JOptionPane.showInputDialog(null,
                        "Target substance/expression name: ");
            }
            Substance target = (Substance) system.getEntity(ts);
            metric = new CorrelationCoefficient(substance, target);
        }
        updateText();
    }// GEN-LAST:event_metricSelectorActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        if (metric == null) {
            return;
        }
        if (parent instanceof SensitivityAnalysisEditor) {
            ((SensitivityAnalysisEditor) parent).addMetric(metric);
        } else if (parent instanceof TargetObjectiveEditor) {
            ((TargetObjectiveEditor) parent).setMetric(metric);
        }

        //
        // extended by LY to take care of MultiParameterSensitivityAnalysis
        //
        else if (parent instanceof MultiParameterSensitivityAnalysisEditor) {
            ((MultiParameterSensitivityAnalysisEditor) parent)
                    .addMetric(metric);
        }
        //
        // extended by LY to take care of SequentialTwoParameterScanEditor
        //
        else if (parent instanceof SequentialTwoParameterScanEditor) {
            ((SequentialTwoParameterScanEditor) parent).addMetric(metric);
        }

        frame.setVisible(false);
        frame.dispose();
    }// GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox metricSelector;
    private javax.swing.JComboBox substanceSelector;
    private javax.swing.JTextField textField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
