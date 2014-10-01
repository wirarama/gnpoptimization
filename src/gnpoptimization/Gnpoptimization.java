/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpoptimization;

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
        int[] normdiff1 = {0,100,50000};
        int[] sigdiff1 = {200,7000,6000};
        int[] normdiff2 = {0,500,50000};
        int[] sigdiff2 = {50,2000,7000};
        int[] normdiff3 = {0,10,20000};
        int[] sigdiff3 = {50,5000,3000};
        double[][] data1 = createdata(5.43,9.89,1000,"data1",
                diffpoint.diffpoint1(),normdiff1,sigdiff1);
        double[][] data2 = createdata(4.32,9.31,1000,"data2",
                diffpoint.diffpoint2(),normdiff2,sigdiff2);
        double[][] data3 = createdata(5.64,9.04,1000,"data3",
                diffpoint.diffpoint3(),normdiff3,sigdiff3);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        dataplot.add(data2);
        dataplot.add(data3);
        String[] label = {"price","stock","weight"};
        plot.makeplot2(dataplot,label,"data","rule","silhouette");
    }
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