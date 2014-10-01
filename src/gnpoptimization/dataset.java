/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpoptimization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author wirarama
 */
public class dataset {
    public static double[][] createdata(double min,double max,int data,
            String name,int[][] diffpoint,int[] normdiff,int[] sigdiff,boolean plus) throws IOException{
        double pointer = max;
        double[][] plotarr = new double[data][2];
        double diff = max-min;
        double decreasements = 0;
        int last=0;
        int diffpointer = 0;
        try (final BufferedWriter out = new BufferedWriter(new FileWriter(name+".csv"))){
            for(int i=1;i<=data;i++){
                double decreasement = 0;
                if(decreasements<=diff){
                    if((diffpointer+1)<=diffpoint.length && 
                            (i>diffpoint[diffpointer][0] && i<diffpoint[diffpointer][1])){
                        decreasement = (double)arrayfunction.randomrange(
                                sigdiff[0],sigdiff[1])/(double)sigdiff[2];
                        diffpointer = diffpointer+1;
                    }else{
                        decreasement = (double)arrayfunction.randomrange(
                                normdiff[0],normdiff[1])/(double)normdiff[2];
                    }
                    decreasements += decreasement;
                }
                pointer = pointer - decreasement;
                System.out.println(pointer);
                plotarr[i-1][0] = i;
                plotarr[i-1][1] = pointer;
                out.write(""+pointer);
                out.newLine();
                last=i;
            }
            out.close();
            double[][] plot1 = arrayfunction.cleanarray(plotarr,last);
            plot.makeplot1(plot1,"Silhouette",name,"rule","silhoette");
        }
        return plotarr;
    }
}
