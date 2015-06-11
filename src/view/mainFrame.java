/*
 * Created by JFormDesigner on Tue May 19 02:08:43 CEST 2015
 */

package view;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxPerimeter;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Mariusz Bielec
 */
public class mainFrame extends JFrame {
    public mainFrame() {
        initComponents();
    }
    GraphView graph;

    private void button3ActionPerformed(ActionEvent e) {
        int v1 = Integer.parseInt(JtextV1.getText());
        int v2 = Integer.parseInt(JtextV2.getText());
        graph.insertEdge(graph.getDefaultParent(), null, "df", graph.V[v1-1], graph.V[v2-1]);
        graph.neighbours[v1-1][v2-1]=true;
        graph.neighbours[v2-1][v1-1]=true;
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphPanel.removeAll();
        graphPanel.add(graphComponent);
        //graphPanel.setAutoscrolls(true);
        //graphPanel.setPreferredSize(graphComponent.getPreferredSize());
        //graphPanel.revalidate();
        //graphPanel.repaint();
        //pack();

        revalidate();
        repaint();

    }


    private void newGraphButtonActionPerformed(ActionEvent e) {
        int n = Integer.parseInt(numberOfVertex.getText());
        graph.nbOfVertex = n;
        graph = new GraphView();
        Object parent = graph.getDefaultParent();
        graph.changeStyleSheet();
        mxFastOrganicLayout layout = new mxFastOrganicLayout(graph);
        layout.setForceConstant(80);
        mxCircleLayout circleLayout = new mxCircleLayout(graph);
        //circleLayout.execute(parent);
        circleLayout.execute(parent);
        graph.getModel().beginUpdate();
        graph.V = new Object[100];
        graph.listVertex = new LinkedList<>();
        graph.V = new Object[300];

        try {

            for (int i = 0; i < n; i++) {
                Object v = graph.insertVertex(parent, null, "" + (i + 1), 0, 0, 30, 30);
                graph.listVertex.add(v);
                graph.V[i]=v;
            }
            int size = graph.listVertex.size();
            graph.neighbours = new boolean[size][size];
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    graph.neighbours[i][j]=false;
                }
            }
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

    private void addVertexButtonActionPerformed(ActionEvent e) {
        int n = Integer.parseInt(numberOfVertex.getText());
        Object parent = graph.getDefaultParent();
        mxFastOrganicLayout layout = new mxFastOrganicLayout(graph);
        layout.setForceConstant(80);
        mxCircleLayout circleLayout = new mxCircleLayout(graph);
        circleLayout.execute(parent);
        graph.getModel().beginUpdate();
        try {

            for (int i = graph.nbOfVertex; i < graph.nbOfVertex + n; i++) {
                Object v = graph.insertVertex(parent, null, "" + (i + 1), 0, 0, 30, 30);
                graph.listVertex.add(v);
                graph.V[i]=v;
            }
            graph.nbOfVertex += n;
            circleLayout.execute(parent);

            int size = graph.listVertex.size();
            graph.neighbours = new boolean[size][size];
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    graph.neighbours[i][j]=false;
                }
            }
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

    private void deleteButtonActionPerformed(ActionEvent e) {
        if (graph.listVertex.contains(graph.getSelectionCell())) {
            graph.listVertex.remove(graph.getSelectionCell());
            for(int i=0; i<graph.V.length; i++){
                if(graph.V[i]!=null && graph.V[i].equals(graph.getSelectionCell())) {
                    graph.V[i]=null;
                    break;
                }
            }
        }
        graph.removeCells(graph.getSelectionCells());
        //graph.removeSelectionCell(graph.getSelectionCell());
//        listVertex.remove(graph.getSelectionCell());
    }

    private void button4ActionPerformed(ActionEvent e) {
        System.out.println("wchodze");
       // graph.changeVertexColor(graph.V[2], "red");
        for(int i=0; i<graph.listVertex.size(); i++){
            for(int j=0; j<graph.listVertex.size(); j++){
                if(graph.neighbours[i][j]==true){
                    System.out.println("krawedz z" + (i+1) + "do" + (j+1));
                }
            }
        }
        if(graph.getSelectionCell()==null){
            JOptionPane.showMessageDialog(null, "Zaznacz wierzcholek stratowy :-)",
                    "Uwaga", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,
            //"Company name can not be empty");
            return;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariusz Bielec
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        optionsPanel = new JPanel();
        panel2 = new JPanel();
        vertexLabel = new JLabel();
        numberOfVertex = new JTextField();
        newGraphButton = new JButton();
        addVertexButton = new JButton();
        panel1 = new JPanel();
        deleteLab1 = new JLabel();
        deleteLab2 = new JLabel();
        deleteButton = new JButton();
        edgeLabel = compFactory.createLabel("text");
        panel10 = new JPanel();
        JtextV1 = new JTextField();
        JtextV2 = new JTextField();
        button3 = new JButton();
        panel11 = new JPanel();
        label5 = compFactory.createLabel("text");
        selectAlgorithm = new JComboBox();
        button4 = new JButton();
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

                //---- vertexLabel ----
                vertexLabel.setText("Liczba wierzcho\u0142k\u00f3w:");
                panel2.add(vertexLabel, CC.xy(1, 1));
                panel2.add(numberOfVertex, CC.xy(1, 3));

                //---- newGraphButton ----
                newGraphButton.setText("Nowy graf");
                newGraphButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newGraphButtonActionPerformed(e);
                    }
                });
                panel2.add(newGraphButton, CC.xy(1, 5));

                //---- addVertexButton ----
                addVertexButton.setText("Dodaj");
                addVertexButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addVertexButtonActionPerformed(e);
                    }
                });
                panel2.add(addVertexButton, CC.xy(1, 7));
            }
            optionsPanel.add(panel2, CC.xy(1, 1));

            //======== panel1 ========
            {
                panel1.setLayout(new FormLayout(
                    "default",
                    "2*(default, $lgap), default"));

                //---- deleteLab1 ----
                deleteLab1.setText("Podaj krawedz");
                panel1.add(deleteLab1, CC.xy(1, 1));

                //---- deleteLab2 ----
                deleteLab2.setText("lub wierzcholek:");
                panel1.add(deleteLab2, CC.xy(1, 3));

                //---- deleteButton ----
                deleteButton.setText("Usun");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteButtonActionPerformed(e);
                    }
                });
                panel1.add(deleteButton, CC.xy(1, 5));
            }
            optionsPanel.add(panel1, CC.xy(1, 3));

            //---- edgeLabel ----
            edgeLabel.setText("Dodaj krawedz:");
            optionsPanel.add(edgeLabel, CC.xy(1, 5));

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
            optionsPanel.add(panel10, CC.xy(1, 7));

            //---- button3 ----
            button3.setText("Dodaj");
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button3ActionPerformed(e);
                    button3ActionPerformed(e);
                }
            });
            optionsPanel.add(button3, CC.xy(1, 9));

            //======== panel11 ========
            {
                panel11.setLayout(new FormLayout(
                        "default",
                        "2*(default, $lgap), default"));

                //---- label5 ----
                label5.setText("Wybierz algorytm");

                panel11.add(label5, CC.xy(1, 1));
                panel11.add(selectAlgorithm, CC.xy(1, 3));
                selectAlgorithm.addItem("DFS");
                selectAlgorithm.addItem("BFS");
                selectAlgorithm.addItem("SCC");
                //---- button4 ----
                button4.setText("Start");
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button4ActionPerformed(e);
                    }
                });
                panel11.add(button4, CC.xy(1, 5));
            }
            optionsPanel.add(panel11, CC.xy(1, 11));
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
    // Generated using JFormDesigner Evaluation license - Mariusz Bielec
    private JPanel optionsPanel;
    private JPanel panel2;
    private JLabel vertexLabel;
    private JTextField numberOfVertex;
    private JButton newGraphButton;
    private JButton addVertexButton;
    private JPanel panel1;
    private JLabel deleteLab1;
    private JLabel deleteLab2;
    private JButton deleteButton;
    private JLabel edgeLabel;
    private JPanel panel10;
    private JTextField JtextV1;
    private JTextField JtextV2;
    private JButton button3;
    private JPanel panel11;
    private JLabel label5;
    private JComboBox selectAlgorithm;
    private JButton button4;
    private JPanel graphPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}


