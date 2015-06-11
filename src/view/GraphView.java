package view;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxPerimeter;

import java.util.List;
import java.util.Map;

/**
 * Created by mariusz on 11.06.15.
 */


class GraphView extends mxGraph {
    Object[] V;
    public static int nbOfVertex;
    List<Object> listVertex;

    public void changeStyleSheet(){
        Map<String, Object> st = super.getStylesheet().getDefaultVertexStyle();
        st.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        st.put(mxConstants.STYLE_PERIMETER, mxPerimeter.EllipsePerimeter);
        st.put(mxConstants.STYLE_GRADIENTCOLOR, "white");
        st.put(mxConstants.STYLE_FONTSIZE, "10");
    }
    public void changeVertexColor(Object o, String c){

        super.setCellStyles(mxConstants.STYLE_FILLCOLOR, c, new Object[]{o});
        //((mxCell)o).
    }
}