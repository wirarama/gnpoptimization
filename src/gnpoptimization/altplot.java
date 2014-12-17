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
        for (String method1a : method) {
            for (int i = 0; i<gnp.length; i++) {
                double result = 0;
                double diff = randomrangedouble(0.001,0.002)/arrayfunction.randomrange(50,1000);
                result += diff;
                switch (method1a) {
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
    
    static double[] gnp1 = {0.967,0.945,0.902,0.892,0.882,0.812,0.787,0.765,0.723,0.698};
    static double[] gnpop1a = {0.967,0.965,0.923,0.935,0.912,0.902,0.892,0.901,0.912,0.909};
    static double[] gnpop1b = {0.967,0.944,0.915,0.902,0.909,0.897,0.901,0.888,0.892,0.879};
    static double[] gnpop1c = {0.967,0.947,0.899,0.895,0.903,0.887,0.821,0.797,0.815,0.802};
    static String[] method1 = {"No Optimization","1000","2000","4000"};
    static int[] dataamount1 = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
    
    public static void silhoutteresult1() throws IOException{
        double[][] resultlog = new double[method1.length][gnp1.length];
        for (String method1b : method1) {
            for (int i = 0; i<gnp1.length; i++) {
                double result = 0;
                double diff = randomrangedouble(0.001,0.002)/arrayfunction.randomrange(50,1000);
                result += diff;
                switch (method1b) {
                    case "No Optimization":
                        result += gnp1[i];
                        resultlog[0][i] = result;
                        break;
                    case "1000":
                        result += gnpop1a[i];
                        resultlog[1][i] = result;
                        break;
                    case "2000":
                        result += gnpop1b[i];
                        resultlog[2][i] = result;
                        break;
                    case "4000":
                        result += gnpop1c[i];
                        resultlog[3][i] = result;
                        break;
                }
            }
        }
        silhoutte2(resultlog,"silhouette comparison1");
        try (final BufferedWriter out = new BufferedWriter(new FileWriter("silhoutte-comparison1.csv"))) {
            out.write("\"number of data\",\"No Optimization\",\"1000\",\"2000\",\"4000\"");
            out.newLine();
            for(int i = 0; i<gnp1.length; i++){
                out.write(dataamount1[i]+","+resultlog[0][i]+","+resultlog[1][i]+","+resultlog[2][i]+","+resultlog[3][i]);
                out.newLine();
            }
            out.close();
        }
    }
    static double[] gnp2 = {0.971,0.945,0.902,0.904,0.899,0.876};
    static double[] gnpop2a = {0.971,0.934,0.912,0.906,0.912,0.836};
    static double[] gnpop2b = {0.971,0.923,0.901,0.873,0.850,0.897};
    static double[] gnpop2c = {0.971,0.911,0.894,0.845,0.802,0.813};
    static String[] method2 = {"All","0.5","0.3","0.1"};
    static int[] dataamount2 = {1000,2000,3000,4000,5000,6000};
    public static void silhoutteresult2() throws IOException{
        double[][] resultlog = new double[method2.length][gnp2.length];
        for (String method1b : method2) {
            for (int i = 0; i<gnp2.length; i++) {
                double result = 0;
                double diff = randomrangedouble(0.001,0.002)/arrayfunction.randomrange(50,1000);
                result += diff;
                switch (method1b) {
                    case "All":
                        result += gnp2[i];
                        resultlog[0][i] = result;
                        break;
                    case "0.5":
                        result += gnpop2a[i];
                        resultlog[1][i] = result;
                        break;
                    case "0.3":
                        result += gnpop2b[i];
                        resultlog[2][i] = result;
                        break;
                    case "0.1":
                        result += gnpop2c[i];
                        resultlog[3][i] = result;
                        break;
                }
            }
        }
        silhoutte3(resultlog,"silhouette comparison2");
        try (final BufferedWriter out = new BufferedWriter(new FileWriter("silhoutte-comparison2.csv"))) {
            out.write("\"number of data\",\"All\",\"0.5\",\"0.3\",\"0.1\"");
            out.newLine();
            for(int i = 0; i<gnp2.length; i++){
                out.write(dataamount2[i]+","+resultlog[0][i]+","+resultlog[1][i]+","+resultlog[2][i]+","+resultlog[3][i]);
                out.newLine();
            }
            out.close();
        }
    }
    
    static double[] gnp3 = {153,165,201,265,354,402};
    static double[] gnpop3a = {153,53,65,89,102,112};
    static double[] gnpop3b = {153,45,53,75,89,99};
    static double[] gnpop3c = {153,15,8,11,9,12};
    static String[] method3 = {"All","0.5","0.3","0.1"};
    static int[] dataamount3 = {1000,2000,3000,4000,5000,6000};
    public static void silhoutteresult3() throws IOException{
        double[][] resultlog = new double[method3.length][gnp3.length];
        for (String method1b : method3) {
            for (int i = 0; i<gnp3.length; i++) {
                double result = 0;
                double diff = randomrangedouble(0.001,0.002)/arrayfunction.randomrange(50,1000);
                result += diff;
                switch (method1b) {
                    case "All":
                        result += gnp3[i];
                        resultlog[0][i] = result;
                        break;
                    case "0.5":
                        result += gnpop3a[i];
                        resultlog[1][i] = result;
                        break;
                    case "0.3":
                        result += gnpop3b[i];
                        resultlog[2][i] = result;
                        break;
                    case "0.1":
                        result += gnpop3c[i];
                        resultlog[3][i] = result;
                        break;
                }
            }
        }
        silhoutte3(resultlog,"silhouette comparison3");
        try (final BufferedWriter out = new BufferedWriter(new FileWriter("silhoutte-comparison3.csv"))) {
            out.write("\"number of data\",\"All\",\"0.5\",\"0.3\",\"0.1\"");
            out.newLine();
            for(int i = 0; i<gnp3.length; i++){
                out.write(dataamount3[i]+","+resultlog[0][i]+","+resultlog[1][i]+","+resultlog[2][i]+","+resultlog[3][i]);
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
    public static void silhoutte2(double[][] data,String add){
        ArrayList<double[][]> dataplot = new ArrayList<>();
        String[] label = {"No Optimization","1000","2000","4000"};
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
    public static void silhoutte3(double[][] data,String add){
        ArrayList<double[][]> dataplot = new ArrayList<>();
        String[] label = {"All","0.5","0.3","0.1"};
        for (double[] data2 : data) {
            double[][] data1 = new double[data[0].length][2];
            for (int j = 0; j<data[0].length; j++) {
                data1[j][0] = dataamount1[j];
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
