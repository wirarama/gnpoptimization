/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpoptimization;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.terminal.PostscriptTerminal;
import java.util.ArrayList;

/**
 *
 * @author wirarama
 */
public class plot {
    public static void makeplot1(double[][] data,String label,String pngname,String xlabel,String ylabel){
        JavaPlot p = new JavaPlot();
        p.setTitle(pngname);
        p.setKey(JavaPlot.Key.BELOW);
        p.getAxis("x").setLabel(xlabel);
        p.getAxis("y").setLabel(ylabel);
        p.addPlot(data);
        ((AbstractPlot) p.getPlots().get(0)).setTitle(label);
        PlotStyle stl = ((AbstractPlot) p.getPlots().get(0)).getPlotStyle();
        stl.setStyle(Style.LINES);
        epsexport(p,pngname+".eps");
    }
    public static void makeplot2(ArrayList<double[][]> data,String[] label,String pngname,String xlabel,String ylabel){
        JavaPlot p = new JavaPlot();
        p.setTitle(pngname);
        p.setKey(JavaPlot.Key.BELOW);
        p.getAxis("x").setLabel(xlabel);
        p.getAxis("y").setLabel(ylabel);
        int k=0;
        for(int i=0;i<data.size();i++){
            double[][] data1 = data.get(i);
            p.addPlot(data1);
            ((AbstractPlot) p.getPlots().get(k)).setTitle(label[k]);
            PlotStyle stl = ((AbstractPlot) p.getPlots().get(k)).getPlotStyle();
            stl.setStyle(Style.LINES);
            epsexport(p,pngname+".eps");
            k++;
        }
    }
    public static void epsexport(JavaPlot p,String epsname){
        PostscriptTerminal epsf = new PostscriptTerminal(epsname);
        epsf.setColor(true);
        p.setTerminal(epsf);
        p.plot();
    }
}
