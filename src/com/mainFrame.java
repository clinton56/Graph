/*
 * Created by JFormDesigner on Tue May 19 02:08:43 CEST 2015
 */

package com;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxPerimeter;
import java.awt.Color;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

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

            for(int i=0; i<n; i++){
                V[i]=graph.insertVertex(parent,null, "" + (i+1), 0,0,30,30);
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
        panel12.removeAll();
        panel12.add(graphComponent);
        panel12.setAutoscrolls(true);
        panel12.setPreferredSize(graphComponent.getPreferredSize());
        panel12.revalidate();
        panel12.repaint();
        pack();
        revalidate();
        repaint();
    }

    private void button3ActionPerformed(ActionEvent e) {
        int v1 = Integer.parseInt(JtextV1.getText());
        int v2 = Integer.parseInt(JtextV2.getText());
        graph.insertEdge(graph.getDefaultParent(), null, "df", V[v1 - 1], V[v2 - 1]);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        panel12.removeAll();
        panel12.add(graphComponent);
        panel12.setAutoscrolls(true);
        panel12.setPreferredSize(graphComponent.getPreferredSize());
        panel12.revalidate();
        panel12.repaint();
        pack();
        revalidate();
        repaint();

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariusz Bielec
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        panel7 = new JPanel();
        panel8 = new JPanel();
        label3 = compFactory.createLabel("text");
        nrOfVertex = new JTextField();
        button2 = new JButton();
        panel9 = new JPanel();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        label4 = compFactory.createLabel("text");
        panel10 = new JPanel();
        JtextV1 = new JTextField();
        JtextV2 = new JTextField();
        button3 = new JButton();
        panel11 = new JPanel();
        label5 = compFactory.createLabel("text");
        comboBox1 = new JComboBox();
        button4 = new JButton();
        panel12 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "4*(default, $lcgap), default",
            "default"));

        //======== panel7 ========
        {

            // JFormDesigner evaluation mark
                      /* panel7.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel7.getBorder())); panel7.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
*/
            panel7.setLayout(new FormLayout(
                "default",
                "5*(default, $lgap), default"));

            //======== panel8 ========
            {
                panel8.setLayout(new FormLayout(
                    "default",
                    "2*(default, $lgap), default"));

                //---- label3 ----
                label3.setText("Liczba wierzcholkow");
                panel8.add(label3, CC.xy(1, 1));
                panel8.add(nrOfVertex, CC.xy(1, 3));

                //---- button2 ----
                button2.setText("Ok");
                button2.setPreferredSize(new Dimension(30, 34));
                button2.setMinimumSize(new Dimension(30, 34));
                button2.setMaximumSize(new Dimension(30, 34));
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button2ActionPerformed(e);
                    }
                });
                panel8.add(button2, CC.xy(1, 5));
            }
            panel7.add(panel8, CC.xy(1, 1));

            //======== panel9 ========
            {
                panel9.setLayout(new FormLayout(
                    "default",
                    "default, $lgap, default"));

                //---- checkBox2 ----
                checkBox2.setText("skierowany");
                panel9.add(checkBox2, CC.xy(1, 1));

                //---- checkBox3 ----
                checkBox3.setText("wazony");
                panel9.add(checkBox3, CC.xy(1, 3));
            }
            panel7.add(panel9, CC.xy(1, 3));

            //---- label4 ----
            label4.setText("Dodaj krawedz:");
            panel7.add(label4, CC.xy(1, 5));

            //======== panel10 ========
            {
                panel10.setLayout(new FormLayout(
                    "default, $lcgap, default",
                    "default"));

                //---- JtextV1 ----
                JtextV1.setPreferredSize(new Dimension(50, 26));
                JtextV1.setMinimumSize(new Dimension(50, 26));
                panel10.add(JtextV1, CC.xy(1, 1));

                //---- JtextV2 ----
                JtextV2.setMinimumSize(new Dimension(50, 26));
                JtextV2.setPreferredSize(new Dimension(50, 26));
                panel10.add(JtextV2, CC.xy(3, 1));
            }
            panel7.add(panel10, CC.xy(1, 7));

            //---- button3 ----
            button3.setText("Dodaj");
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button3ActionPerformed(e);
                }
            });
            panel7.add(button3, CC.xy(1, 9));

            //======== panel11 ========
            {
                panel11.setLayout(new FormLayout(
                    "default",
                    "2*(default, $lgap), default"));

                //---- label5 ----
                label5.setText("Wybierz algorytm");
                panel11.add(label5, CC.xy(1, 1));
                panel11.add(comboBox1, CC.xy(1, 3));

                //---- button4 ----
                button4.setText("Start");
                panel11.add(button4, CC.xy(1, 5));
            }
            panel7.add(panel11, CC.xy(1, 11));
        }
        contentPane.add(panel7, CC.xy(1, 1, CC.DEFAULT, CC.TOP));

        //======== panel12 ========
        {
            panel12.setMinimumSize(new Dimension(300, 300));
            panel12.setPreferredSize(new Dimension(500, 600));
            panel12.setLayout(new BorderLayout());
        }
        contentPane.add(panel12, CC.xy(3, 1));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariusz Bielec
    private JPanel panel7;
    private JPanel panel8;
    private JLabel label3;
    private JTextField nrOfVertex;
    private JButton button2;
    private JPanel panel9;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JLabel label4;
    private JPanel panel10;
    private JTextField JtextV1;
    private JTextField JtextV2;
    private JButton button3;
    private JPanel panel11;
    private JLabel label5;
    private JComboBox comboBox1;
    private JButton button4;
    private JPanel panel12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
