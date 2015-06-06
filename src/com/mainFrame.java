/*
 * Created by JFormDesigner on Tue May 19 02:08:43 CEST 2015
 */

package com;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxPerimeter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * @author Mariusz Bielec
 */
public class mainFrame extends JFrame {
    public mainFrame() {
        initComponents();
    }

    mxGraph graph;
    Object[] V;

    private void button2ActionPerformed(ActionEvent e) {
        int n = Integer.parseInt(nrOfVertex.getText());
        graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        Map<String, Object> st = graph.getStylesheet().getDefaultVertexStyle();
        st.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        st.put(mxConstants.STYLE_PERIMETER, mxPerimeter.EllipsePerimeter);
        st.put(mxConstants.STYLE_GRADIENTCOLOR, "white");
        st.put(mxConstants.STYLE_FONTSIZE, "10");
        mxFastOrganicLayout layout = new mxFastOrganicLayout(graph);
        layout.setForceConstant(80);
        mxCircleLayout circleLayout = new mxCircleLayout(graph);
        //circleLayout.execute(parent);
        circleLayout.execute(parent);
        graph.getModel().beginUpdate();
        V = new Object[n];

        try {
            /*Object v1 = graph.insertVertex(parent, null, "Hello", 10, 20, 80,
                    30);
            Object v2 = graph.insertVertex(parent, null, "World!", 240, 250,
                    80, 30);
            Object v3 = graph.insertVertex(parent, null, "World!", 300, 50,
                    80, 30);
            Object v4 = graph.insertVertex(parent, null, "World!", 400, 180,
                    80, 30);
            Object v5 = graph.insertVertex(parent, null, "World!", 450, 10,
                    80, 30);
            Object v6 = graph.insertVertex(parent, null, "World!", 200, 100,
                    80, 30);
            Object v7 = graph.insertVertex(parent, null, "World!", 10, 310,
                    80, 80);*/

            for (int i = 0; i < n; i++) {
                V[i] = graph.insertVertex(parent, null, "" + (i + 1), 0, 0, 30, 30);
            }
            //graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "#10C500", new Object[]{v1, v2});
            //graph.setCellStyle(mxConstants.SHAPE_ELLIPSE, new Object[]{v4});


            /*graph.insertEdge(parent, null, "Edge", v1, v2);
            graph.insertEdge(parent, null, "Edge", v1, v3);
            graph.insertEdge(parent, null, "Edge", v2, v6);
            graph.insertEdge(parent, null, "Edge", v6, v4);
            graph.insertEdge(parent, null, "Edge", v5, v3);*/
            // circleLayout.execute(parent);
            circleLayout.execute(parent);
            //graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "#10C500", new Object[]{v1, v2});
        } finally {
            graph.getModel().endUpdate();
        }
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphPanel.removeAll();
        graphPanel.add(graphComponent);
        graphPanel.setAutoscrolls(true);
        graphPanel.setPreferredSize(graphComponent.getPreferredSize());
        graphPanel.revalidate();
        graphPanel.repaint();
        pack();
        revalidate();
        repaint();
    }

    private void button3ActionPerformed(ActionEvent e) {
        int v1 = Integer.parseInt(startEdgeText.getText());
        int v2 = Integer.parseInt(endEdgeText.getText());
        graph.insertEdge(graph.getDefaultParent(), null, "df", V[v1 - 1], V[v2 - 1]);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphPanel.removeAll();
        graphPanel.add(graphComponent);
        graphPanel.setAutoscrolls(true);
        graphPanel.setPreferredSize(graphComponent.getPreferredSize());
        graphPanel.revalidate();
        graphPanel.repaint();
        pack();
        revalidate();
        repaint();

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariusz Bielec
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        optionsPanel = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        panel1 = new JPanel();
        deleteLab1 = new JLabel();
        deleteLab2 = new JLabel();
        deleteButton = new JButton();
        edgeLabel = compFactory.createLabel("text");
        addEdgePanel = new JPanel();
        startEdgeText = new JTextField();
        endEdgeText = new JTextField();
        addEdge = new JButton();
        algorithmsPanel = new JPanel();
        selectAlgorithmLabel = compFactory.createLabel("text");
        selectAlgorithm = new JComboBox();
        algorithmButton = new JButton();
        graphPanel = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "4*(default, $lcgap), default",
            "default"));

        //======== optionsPanel ========
        {

            // JFormDesigner evaluation mark
            optionsPanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), optionsPanel.getBorder())); optionsPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            optionsPanel.setLayout(new FormLayout(
                "default",
                "5*(default, $lgap), default"));

            //======== panel2 ========
            {
                panel2.setLayout(new FormLayout(
                    "default",
                    "3*(default, $lgap), default"));

                //---- label1 ----
                label1.setText("Liczba wierzcho\u0142k\u00f3w:");
                panel2.add(label1, CC.xy(1, 1));
                panel2.add(textField1, CC.xy(1, 3));

                //---- button1 ----
                button1.setText("Nowy graf");
                panel2.add(button1, CC.xy(1, 5));

                //---- button2 ----
                button2.setText("Dodaj");
                panel2.add(button2, CC.xy(1, 7));
            }
            optionsPanel.add(panel2, CC.xy(1, 1));

            //======== panel1 ========
            {
                deletePanel.setLayout(new FormLayout(
                    "default",
                    "2*(default, $lgap), default"));

                //---- deleteLab1 ----
                deleteLab1.setText("Zaznacz krawedz");
                deletePanel.add(deleteLab1, CC.xy(1, 1));

                //---- deleteLab2 ----
                deleteLab2.setText("lub wierzcholek:");
                deletePanel.add(deleteLab2, CC.xy(1, 3));

                //---- deleteButton ----
                deleteButton.setText("Usun");
                deletePanel.add(deleteButton, CC.xy(1, 5));
            }
            optionsPanel.add(deletePanel, CC.xy(1, 3));

            //---- edgeLabel ----
            edgeLabel.setText("Dodaj krawedz:");
            optionsPanel.add(edgeLabel, CC.xy(1, 5));

            //======== addEdgePanel ========
            {
                addEdgePanel.setLayout(new FormLayout(
                    "default, $lcgap, default",
                    "default"));

                //---- startEdgeText ----
                startEdgeText.setPreferredSize(new Dimension(50, 26));
                startEdgeText.setMinimumSize(new Dimension(50, 26));
                addEdgePanel.add(startEdgeText, CC.xy(1, 1));

                //---- endEdgeText ----
                endEdgeText.setMinimumSize(new Dimension(50, 26));
                endEdgeText.setPreferredSize(new Dimension(50, 26));
                addEdgePanel.add(endEdgeText, CC.xy(3, 1));
            }
            optionsPanel.add(addEdgePanel, CC.xy(1, 7));

            //---- addEdge ----
            addEdge.setText("Dodaj");
            addEdge.addActionListener(e -> button3ActionPerformed(e));
            optionsPanel.add(addEdge, CC.xy(1, 9));

            //======== algorithmsPanel ========
            {
                algorithmsPanel.setLayout(new FormLayout(
                    "default",
                    "2*(default, $lgap), default"));

                //---- selectAlgorithmLabel ----
                selectAlgorithmLabel.setText("Wybierz algorytm");
                algorithmsPanel.add(selectAlgorithmLabel, CC.xy(1, 1));
                algorithmsPanel.add(selectAlgorithm, CC.xy(1, 3));

                //---- algorithmButton ----
                algorithmButton.setText("Start");
                algorithmsPanel.add(algorithmButton, CC.xy(1, 5));
            }
            optionsPanel.add(algorithmsPanel, CC.xy(1, 11));
        }
        contentPane.add(optionsPanel, CC.xy(1, 1, CC.DEFAULT, CC.TOP));

        //======== graphPanel ========
        {
            graphPanel.setMinimumSize(new Dimension(300, 300));
            graphPanel.setPreferredSize(new Dimension(500, 600));
            graphPanel.setLayout(new BorderLayout());
        }
        contentPane.add(graphPanel, CC.xy(3, 1));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Damian Liwak
    private JPanel optionsPanel;
    private JPanel panel8;
    private JLabel numOfVertexLabel;
    private JTextField nrOfVertex;
    private JButton okButton;
    private JPanel deletePanel;
    private JLabel deleteLab1;
    private JLabel deleteLab2;
    private JButton deleteButton;
    private JLabel edgeLabel;
    private JPanel addEdgePanel;
    private JTextField startEdgeText;
    private JTextField endEdgeText;
    private JButton addEdge;
    private JPanel algorithmsPanel;
    private JLabel selectAlgorithmLabel;
    private JComboBox selectAlgorithm;
    private JButton algorithmButton;
    private JPanel graphPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
