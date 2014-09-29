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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author wirarama
 */
public class Gnpoptimization {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        double[][] data1 = createdata(5.43,9.89,1000);
        double[][] data2 = createdata(4.32,9.31,1000);
        double[][] data3 = createdata(6.64,9.04,1000);
    }
    public static double[][] createdata(double min,double max,int data) throws IOException{
        double pointer = max;
        double[][] plot = new double[data][2];
        int last=0;
        try (final BufferedWriter out = new BufferedWriter(new FileWriter("test.csv"))){
            for(int i=1;i<=data;i++){
                double decreasement;
                if(i>520 && i<560){
                    decreasement = (double)randomrange(100,500)/(double)30000;
                }else if(i>602 && i<660){
                    decreasement = (double)randomrange(100,500)/(double)40000;
                }else{
                    decreasement = (double)randomrange(0,500)/(double)80000;
                }
                pointer = pointer - decreasement;
                System.out.println(pointer);
                plot[i-1][0] = i;
                plot[i-1][1] = pointer;
                out.write(""+pointer);
                out.newLine();
                last=i;
                if(pointer<=min){
                    break;
                }
            }
            out.close();
            double[][] plot1 = cleanarray(plot,last);
            makeplot1(plot1,"Silhouette","silhouette2.eps","rule","silhoette");
        }
        return plot;
    }
    public static int randomrange(int min,int max){
        int randomvalue = min + (int)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static void silhoutte(double[][] data,String testdate,String add,int subject){
        int[] nuattribute = {2,4,8,16,24,32};
        int[] nudataamount = {2,4,6,8,10,12};
        ArrayList<double[][]> dataplot = new ArrayList<>();
        String[] label = {"gnp","hierarchical","kmean"};
        for (double[] data2 : data) {
            double[][] data1 = new double[data[0].length][2];
            for (int j = 0; j<data[0].length; j++) {
                if(subject==1){
                    data1[j][0] = nuattribute[j];
                }else{
                    data1[j][0] = nudataamount[j];
                }
                data1[j][1] = data2[j];
            }
            dataplot.add(data1);
        }
        if(subject==1){
            makeplot2(dataplot,label,add,"attribute","silhouette value",testdate);
        }else{
            makeplot2(dataplot,label,add,"k","silhouette value",testdate);
        }
    }
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
    public static void makeplot2(ArrayList<double[][]> data,String[] label,String pngname,String xlabel,String ylabel,String testdate){
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
            epsexport(p,"log/"+testdate+"/"+pngname+testdate+".eps");
            k++;
        }
    }
    public static void epsexport(JavaPlot p,String epsname){
        PostscriptTerminal epsf = new PostscriptTerminal(epsname);
        epsf.setColor(true);
        p.setTerminal(epsf);
        p.plot();
    }
    public static double[][] cleanarray(double[][] data,int length){
        double[][] newdata = new double[length][data[0].length];
        System.arraycopy(data, 0, newdata, 0, length);
        return newdata;
    }
}
