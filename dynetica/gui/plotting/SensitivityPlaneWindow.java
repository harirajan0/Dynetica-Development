package dynetica.gui.plotting;

/**
 *
 * @author  Lingchong You
 * @version 0.1
 */
import dynetica.algorithm.*;
import dynetica.entity.*;
import dynetica.expression.Variable;
import dynetica.objective.AbstractMetric;
import java.util.*;
import javax.swing.*;
import java.io.*;
import matlabcontrol.*;

public class SensitivityPlaneWindow extends javax.swing.JFrame {
    InteractiveFigure figure = new InteractiveFigure();
    final DefaultListModel xNames = new DefaultListModel(); // xNames has an
                                                            // item for "Time".
    final DefaultListModel yNames = new DefaultListModel();

    final dynetica.system.ReactiveSystem system;
    SensitivityAnalysis algorithm;

    FigureAxisModel figureAxisModel;
    String xLabel;
    String[] yLabels;
    double[] xValues;
    double[][] yValues;

    //
    // 7/28/2013. These are defined to allow connection to Matlab to quickly
    // plot simulation data.
    //
    MatlabProxyFactory matlabfactory = null;
    MatlabProxy proxy = null;

    public SensitivityPlaneWindow(SensitivityAnalysis algorithm) {
        super("Sensitivity Analysis for " + algorithm.getSystem().getName());
        this.algorithm = algorithm;
        this.system = algorithm.getSystem();

        String variableName;
        Variable var = algorithm.getVariable();
        if (var instanceof Substance) {
            variableName = ((Substance) var).getName();
        } else {
            variableName = ((Parameter) var).getName();
        }
        xNames.addElement(variableName);
        yNames.addElement(variableName);

        ArrayList<AbstractMetric> metrics = algorithm.getMetrics();
        int nMets = metrics.size(); // substances.length;
        System.out.println("# of metrics = " + nMets);
        for (int i = 0; i < nMets; i++) {
            AbstractMetric m = (metrics.get(i));
            xNames.addElement(m.toString());
            yNames.addElement(m.toString());
        }
        initComponents();
        System.out.println("Components initialized.");
        figurePanel.add(figure.getPlotPanel(), java.awt.BorderLayout.CENTER);
        updateFigure();

        pack();
    }

    public void setUpData() {
        ArrayList<AbstractMetric> metrics = algorithm.getMetrics();
        int nMets = metrics.size(); // substances.length;
        System.out.println("# of metrics = " + nMets);
        AbstractMetric m;
        for (int i = 0; i < nMets; i++) {
            m = (metrics.get(i));
            xNames.addElement(m.toString());
            yNames.addElement(m.toString());
        }
        figurePanel.setSize(500, 500);
    }

    public final void updateFigure() {

        //
        // set up data for x-axis; only a single trace can be selected.
        //
        int xIndex = xList.getSelectedIndex();
        xLabel = (String) (xNames.get(xIndex));
        if (xIndex == 0) {
            xValues = algorithm.getXValues();
        } else {
            xValues = algorithm.getYValues()[xIndex - 1];
        }

        //
        // set up data for the y-axis; multiple traces can be selected.
        //

        int[] yIndices = yList.getSelectedIndices();
        yValues = new double[yIndices.length][xValues.length];
        yLabels = new String[yIndices.length];

        for (int i = 0; i < yIndices.length; i++) {
            if (yIndices[i] == 0) {
                yValues[i] = algorithm.getXValues();
            } else {
                yValues[i] = algorithm.getYValues()[yIndices[i] - 1];
            }
            yLabels[i] = (String) (yNames.get(yIndices[i]));
        }

        figure.plotData(xLabel, yLabels, xValues, yValues);
        figure.setLogX(logXItem.getState());
        figure.setLogY(logYItem.getState());

        figurePanel.repaint();

        if (figureAxisModel == null) {
            figureAxisModel = new FigureAxisModel();
            rangeTable.setModel(figureAxisModel);
        } else
            figureAxisModel.setFigure();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        xList = new javax.swing.JList();
        xListLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        yList = new javax.swing.JList();
        yListLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rangeTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        logXbox = new javax.swing.JCheckBox();
        logYbox = new javax.swing.JCheckBox();
        figurePanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveSelectedDataItem = new javax.swing.JMenuItem();
        matlabPlotMenuItem = new javax.swing.JMenuItem();
        closeItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        logXItem = new javax.swing.JCheckBoxMenuItem();
        logYItem = new javax.swing.JCheckBoxMenuItem();
        selectAllItem = new javax.swing.JMenuItem();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPane.setDividerLocation(110);
        mainPane.setLastDividerLocation(10);
        mainPane.setPreferredSize(new java.awt.Dimension(500, 550));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(5);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setLastDividerLocation(80);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel7.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(60, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(60, 200));

        xList.setModel(xNames);
        xList.setSelectedIndex(0);
        xList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        xList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                xListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(xList);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        xListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xListLabel.setText("X value");
        xListLabel
                .setToolTipText("The variable chosen as the x value. Time is set as the X-axis by default.");
        jPanel7.add(xListLabel, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(60, 100));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(60, 200));

        yList.setModel(yNames);
        yList.setSelectedIndex(0);
        yList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                yListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(yList);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        yListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yListLabel.setText("Y values");
        yListLabel
                .setToolTipText("The Y-values. By default the first substance on the list is selected.");
        jPanel8.add(yListLabel, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel8);

        jSplitPane1.setTopComponent(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout(0, 3));

        jLabel6.setText("Figure Configuration");
        jLabel6.setBorder(javax.swing.BorderFactory
                .createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setMaximumSize(new java.awt.Dimension(200, 18));
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 18));
        jPanel3.add(jLabel6, java.awt.BorderLayout.NORTH);

        rangeTable.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        rangeTable.setMaximumSize(new java.awt.Dimension(70, 100));
        rangeTable.setMinimumSize(new java.awt.Dimension(70, 64));
        rangeTable.setPreferredSize(new java.awt.Dimension(70, 64));
        rangeTable.setRowMargin(5);
        rangeTable.setRowSelectionAllowed(false);
        jPanel3.add(rangeTable, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1,
                javax.swing.BoxLayout.Y_AXIS));

        logXbox.setText("Log Scale in X");
        logXbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logXboxActionPerformed(evt);
            }
        });
        jPanel1.add(logXbox);

        logYbox.setText("Log Scale in Y");
        logYbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logYboxActionPerformed(evt);
            }
        });
        jPanel1.add(logYbox);

        jPanel3.add(jPanel1, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setBottomComponent(jPanel3);

        mainPane.setLeftComponent(jSplitPane1);

        figurePanel.setLayout(new java.awt.BorderLayout());
        mainPane.setRightComponent(figurePanel);

        getContentPane().add(mainPane, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        saveSelectedDataItem.setText("Save Selected Data");
        saveSelectedDataItem
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        saveSelectedDataItemActionPerformed(evt);
                    }
                });
        fileMenu.add(saveSelectedDataItem);

        matlabPlotMenuItem.setText("Plot in Matlab");
        matlabPlotMenuItem
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        matlabPlotMenuItemActionPerformed(evt);
                    }
                });
        fileMenu.add(matlabPlotMenuItem);

        closeItem.setText("Close");
        closeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeItemActionPerformed(evt);
            }
        });
        fileMenu.add(closeItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        viewMenu.setText("View");

        logXItem.setText("Log Scale in X axis");
        logXItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logXItemActionPerformed(evt);
            }
        });
        viewMenu.add(logXItem);

        logYItem.setText("Log Scale in Y axis");
        logYItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logYItemActionPerformed(evt);
            }
        });
        viewMenu.add(logYItem);

        selectAllItem.setText("Select All");
        selectAllItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllItemActionPerformed(evt);
            }
        });
        viewMenu.add(selectAllItem);

        jMenuBar1.add(viewMenu);

        setJMenuBar(jMenuBar1);
    }// </editor-fold>//GEN-END:initComponents

    private void yListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_yListValueChanged
        updateFigure();
    }// GEN-LAST:event_yListValueChanged

    private void logYboxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logYboxActionPerformed
        boolean state = logYbox.isSelected();
        logYItem.setSelected(state);
        figure.setLogY(state);
        figurePanel.repaint();
    }// GEN-LAST:event_logYboxActionPerformed

    private void logXboxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logXboxActionPerformed
        boolean state = logXbox.isSelected();
        logXItem.setSelected(state);
        figure.setLogX(state);
        figurePanel.repaint();
    }// GEN-LAST:event_logXboxActionPerformed

    private void selectAllItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selectAllItemActionPerformed
        int[] allIndices = new int[yNames.size()];
        for (int i = 0; i < allIndices.length; i++)
            allIndices[i] = i;
        yList.setSelectedIndices(allIndices);
    }// GEN-LAST:event_selectAllItemActionPerformed

    private void saveSelectedDataItemActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveSelectedDataItemActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File output = fileChooser.getSelectedFile();
            figure.saveData(output);
        }

    }// GEN-LAST:event_saveSelectedDataItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitItemActionPerformed
        System.exit(0);
    }// GEN-LAST:event_exitItemActionPerformed

    private void closeItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_closeItemActionPerformed
        this.dispose();
    }// GEN-LAST:event_closeItemActionPerformed

    private void logXItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logXItemActionPerformed
        figure.setLogX(logXItem.getState());
        logXbox.setSelected(logXItem.getState());
        figurePanel.repaint();
    }// GEN-LAST:event_logXItemActionPerformed

    private void logYItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logYItemActionPerformed
        figure.setLogY(logYItem.getState());
        logYbox.setSelected(logYItem.getState());
        figurePanel.repaint();

    }// GEN-LAST:event_logYItemActionPerformed

    private void xListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_xListValueChanged
        updateFigure();
    }// GEN-LAST:event_xListValueChanged

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_exitForm
        this.dispose();
    }// GEN-LAST:event_exitForm

    private void matlabPlotMenuItemActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_matlabPlotMenuItemActionPerformed
        try {
            InteractiveFigure.matlabPlot(xLabel, yLabels, xValues, yValues,
                    logXItem.isSelected(), logYItem.isSelected());
        }

        catch (MatlabConnectionException MCE) {
            System.out.println(MCE);
        }

        catch (MatlabInvocationException MIE) {
            System.out.println(MIE);
        }
    }// GEN-LAST:event_matlabPlotMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JPanel figurePanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JCheckBoxMenuItem logXItem;
    private javax.swing.JCheckBox logXbox;
    private javax.swing.JCheckBoxMenuItem logYItem;
    private javax.swing.JCheckBox logYbox;
    private javax.swing.JSplitPane mainPane;
    private javax.swing.JMenuItem matlabPlotMenuItem;
    private javax.swing.JTable rangeTable;
    private javax.swing.JMenuItem saveSelectedDataItem;
    private javax.swing.JMenuItem selectAllItem;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JList xList;
    private javax.swing.JLabel xListLabel;
    private javax.swing.JList yList;
    private javax.swing.JLabel yListLabel;

    // End of variables declaration//GEN-END:variables

    class FigureAxisModel extends javax.swing.table.AbstractTableModel {
        final Object[][] data = { { "xmin", new Double(figure.getXmin()) },
                { "xmax", new Double(figure.getXmax()) },
                { "ymin", new Double(figure.getYmin()) },
                { "ymax", new Double(figure.getYmax()) } };

        public FigureAxisModel() {
        }

        public void setFigure() {
            data[0][1] = new Double(figure.getXmin());
            data[1][1] = new Double(figure.getXmax());
            data[2][1] = new Double(figure.getYmin());
            data[3][1] = new Double(figure.getYmax());

            for (int i = 0; i < 4; i++)
                fireTableCellUpdated(i, 1);
        }

        public int getColumnCount() {
            return data[0].length;
        }

        public String getColumnName(int c) {
            return null;
        }

        public int getRowCount() {
            return data.length;
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return (col == 1);
        }

        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);

            double newValue = ((Double) value).doubleValue();
            if (row == 0) {
                figure.setXmin(newValue);
                figurePanel.repaint();
            }

            else if (row == 1) {
                figure.setXmax(newValue);
                figurePanel.repaint();
            }

            else if (row == 2) {
                figure.setYmin(newValue);
                figurePanel.repaint();
            }

            else if (row == 3) {
                figure.setYmax(newValue);
                figurePanel.repaint();
            }

        }
    }

}
