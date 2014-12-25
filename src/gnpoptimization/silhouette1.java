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

/**
 *
 * @author wirarama
 */
public class silhouette1 {
    public static void valuetest() throws IOException{
        int[] data1 = {1,1,1,1,2,3,3,4,7,8,8,10,12,13,15};
        int[] data2 = {30,35,35,35,35,36,36,38};
        int[] data3 = {50,51,65,66,66,66,66,67,67,67};
        double avdata1 = calcaverage(data1);
        double avdata2 = calcaverage(data2);
        double avdata3 = calcaverage(data3);
        calcsilhouette(data1,avdata1,avdata2,"data1");
        calcsilhouette(data2,avdata2,avdata3,"data2");
        calcsilhouette(data3,avdata3,avdata2,"data3");
    }
    public static double calcaverage(int[] data){
        double out = 0;
        for(int i=0;i<data.length;i++){
            out += data[i];
        }
        out = (double) out/(double) data.length;
        return out;
    }
    public static void calcsilhouette(int[] data,double av1,double av2,String filename) throws IOException{
        try (final BufferedWriter rec = new BufferedWriter(new FileWriter("silhoutte-simulation-"+filename+".csv"))) {
            double out = 0;
            for(int i=0;i<data.length;i++){
                double a = abs(data[i]-av1);
                double b = abs(data[i]-av2);
                double silh = (b-a)/max(a,b);
                rec.write(data[i]+","+a+","+b+","+silh);
                rec.newLine();
                out += silh;
            }
            out = (double) out/(double) data.length;
            rec.write(av1+","+av2+","+out);
            rec.newLine();
            rec.close();
        }
    }
}
