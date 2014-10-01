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
            String name,int[][] diffpoint,int[] normdiff,int[] sigdiff) throws IOException{
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
                    if((diffpointer+1)<diffpoint.length && 
                            (i>diffpoint[diffpointer][0] && i<diffpoint[diffpointer][1])){
                        if(diffpoint[diffpointer][2]!=0){
                            decreasement = (double)diffpoint[diffpointer][2]/(double)sigdiff[2];
                        }else{
                            decreasement = (double)arrayfunction.randomrange(
                                    sigdiff[0],sigdiff[1])/(double)sigdiff[2];
                        }
                        diffpointer = diffpointer+1;
                    }else{
                        decreasement = (double)arrayfunction.randomrange(
                                normdiff[0],normdiff[1])/(double)normdiff[2];
                    }
                    decreasements += decreasement;
                }
                pointer = pointer - decreasement;
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
    public static double[][] createdata1(double min,double max,int data,
            String name,int[][] diffpoint,int[] normdiff,int[] sigdiff) throws IOException{
        double pointer = max;
        double[][] plotarr = new double[data][2];
        int last=0;
        int diffpointer = 0;
        try (final BufferedWriter out = new BufferedWriter(new FileWriter(name+".csv"))){
            for(int i=1;i<=data;i++){
                double decreasement;
                if((diffpointer+1)<diffpoint.length && 
                        (i>diffpoint[diffpointer][0] && i<diffpoint[diffpointer][1])){
                    decreasement = (double)diffpoint[diffpointer][2];
                    
                }else{
                    decreasement = (double)arrayfunction.randomrange(
                            normdiff[0],normdiff[1])/(double)normdiff[2];
                }
                if(diffpoint[diffpointer][3]==0){
                    pointer = pointer - decreasement;
                }else{
                    pointer = pointer + decreasement;
                }
                if((diffpointer+1)<diffpoint.length && 
                        (i>diffpoint[diffpointer][0] && i<diffpoint[diffpointer][1])){
                    decreasement = (double)diffpoint[diffpointer][2];
                    diffpointer = diffpointer+1;
                }
                plotarr[i-1][0] = i;
                plotarr[i-1][1] = pointer;
                out.write(""+pointer);
                out.newLine();
                last=i;
            }
            out.close();
            double[][] plot1 = arrayfunction.cleanarray(plotarr,last);
            plot.makeplot1(plot1,"Price",name,"rule","price(value)");
        }
        return plotarr;
    }
}
