/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpoptimization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import java.util.ArrayList;

/**
 *
 * @author wirarama
 */
public class silhouette1 {
    
    public static void valuetest() throws IOException{
        int[] data1 = {1,1,1,1,2,3,3,4,7,8,8,10,12,13,15};
        int[] data2 = {30,35,35,35,35,36,36,38};
        int[] data3 = {50,51,65,66,66,66,66,67,67,67};
        double[][] forplot = new double[data1.length+data2.length+data3.length][2];
        double avdata1 = calcaverage(data1);
        double avdata2 = calcaverage(data2);
        double avdata3 = calcaverage(data3);
        forplot = calcsilhouette(data1,avdata1,avdata2,"data1",forplot,0);
        forplot = calcsilhouette(data2,avdata2,avdata3,"data2",forplot,data1.length);
        forplot = calcsilhouette(data3,avdata3,avdata2,"data3",forplot,(data1.length+data2.length));
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(forplot);
        String[] label = {"silhouette"};
        /*for(int i=0;i<forplot.length;i++){
            System.out.println(i+" "+forplot[i][0]+" "+forplot[i][1]);
        }*/
        plot.makeplot2(dataplot,label,"Silhouette simulation","data","silhouette");
    }
    public static double calcaverage(int[] data){
        double out = 0;
        for(int i=0;i<data.length;i++){
            out += data[i];
        }
        out = (double) out/(double) data.length;
        return out;
    }
    public static double[][] calcsilhouette(
            int[] data,
            double av1,
            double av2,
            String filename,
            double[][] forplot,
            int forplotindex
    ) throws IOException{
        try (final BufferedWriter rec = new BufferedWriter(new FileWriter("silhoutte-simulation-"+filename+".csv"))) {
            double out = 0;
            for(int i=0;i<data.length;i++){
                double a = abs(data[i]-av1);
                double b = abs(data[i]-av2);
                double silh = (b-a)/max(a,b);
                rec.write(data[i]+","+a+","+b+","+silh);
                rec.newLine();
                out += silh;
                forplot[forplotindex][0] = data[i];
                forplot[forplotindex][1] = silh;
                //System.out.println(forplotindex+" "+forplot[forplotindex][0]+" "+forplot[forplotindex][1]);
                forplotindex+=1;
            }
            out = (double) out/(double) data.length;
            rec.write(av1+","+av2+","+out);
            rec.newLine();
            rec.close();
        }
        return forplot;
    }
}
