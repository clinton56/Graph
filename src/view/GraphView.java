package view;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxPerimeter;

import java.util.List;
import java.util.Map;

/**
 * Created by mariusz on 11.06.15.
 */


public class GraphView extends mxGraph {
    public Object[] V;
    public static int nbOfVertex;
    public List<Object> listVertex;
    public boolean[][] neighbours;
    public void changeStyleSheet(){
        Map<String, Object> st = super.getStylesheet().getDefaultVertexStyle();
        st.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        st.put(mxConstants.STYLE_PERIMETER, mxPerimeter.EllipsePerimeter);
        st.put(mxConstants.STYLE_GRADIENTCOLOR, "white");
        st.put(mxConstants.STYLE_FONTSIZE, "10");
    }
    public void changeVertexColor(Object o, String c){

        super.setCellStyles(mxConstants.STYLE_FILLCOLOR, c, new Object[]{o});
    }
}