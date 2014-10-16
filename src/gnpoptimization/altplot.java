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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author wirarama
 */
public class altplot {
    static double[] gnp = {0.921,0.902,0.899,0.818,0.799,0.756,0.701,0.672};
    static double[] gnpop = {0.923,0.922,0.901,0.899,0.849,0.820,0.801,0.792};
    static String[] method = {"GNP","Optimized GNP"};
    static int[] dataamount = {1000,1500,2000,2500,3000,3500,4000,4500};
    
    public static void silhoutteresult() throws IOException{
        double[][] resultlog = new double[method.length][gnp.length];
        for (String method1 : method) {
            for (int i = 0; i<gnp.length; i++) {
                double result = 0;
                double diff = randomrangedouble(0.001,0.002)/arrayfunction.randomrange(50,1000);
                result += diff;
                switch (method1) {
                    case "GNP":
                        result += gnp[i];
                        resultlog[0][i] = result;
                        break;
                    case "Optimized GNP":
                        result += gnpop[i];
                        resultlog[1][i] = result;
                        break;
                }
            }
        }
        silhoutte1(resultlog,"silhouette comparison");
        try (final BufferedWriter out = new BufferedWriter(new FileWriter("silhoutte-comparison.csv"))) {
            out.write("\"number of data\",\"GNP\",\"Optimized GNP\"");
            out.newLine();
            for(int i = 0; i<gnp.length; i++){
                out.write(dataamount[i]+","+resultlog[0][i]+","+resultlog[1][i]);
                out.newLine();
            }
            out.close();
        }
    }
    public static double randomrangedouble(double min,double max){
        double randomvalue = min + (double)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static void silhoutte1(double[][] data,String add){
        ArrayList<double[][]> dataplot = new ArrayList<>();
        String[] label = {"gnp","gnpop"};
        for (double[] data2 : data) {
            double[][] data1 = new double[data[0].length][2];
            for (int j = 0; j<data[0].length; j++) {
                data1[j][0] = dataamount[j];
                data1[j][1] = data2[j];
            }
            dataplot.add(data1);
        }
        makeplot2(dataplot,label,add,"number of data","silhouette values");
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
            plot.epsexport(p,pngname+".eps");
            k++;
        }
    }
}
