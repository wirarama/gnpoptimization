/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpoptimization;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author wirarama
 */
public class cases {
    public static void cases1() throws IOException{
        int[] normdiff1 = {0,100,50000};
        int[] sigdiff1 = {200,7000,6000};
        int[] normdiff2 = {0,500,50000};
        int[] sigdiff2 = {50,2000,7000};
        int[] normdiff3 = {0,10,20000};
        int[] sigdiff3 = {50,5000,3000};
        double[][] data1 = dataset.createdata(5.43,9.89,1000,"data1",
                diffpoint.diffpoint1(),normdiff1,sigdiff1,false);
        double[][] data2 = dataset.createdata(4.32,9.31,1000,"data2",
                diffpoint.diffpoint2(),normdiff2,sigdiff2,false);
        double[][] data3 = dataset.createdata(5.64,9.04,1000,"data3",
                diffpoint.diffpoint3(),normdiff3,sigdiff3,false);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        dataplot.add(data2);
        dataplot.add(data3);
        String[] label = {"price","stock","weight"};
        plot.makeplot2(dataplot,label,"data","rule","silhouette");
    }
    public static void cases2() throws IOException{
        int[] normdiff1 = {0,100,50000};
        int[] sigdiff1 = {200,7000,6000};
        double[][] data1 = dataset.createdata(5.43,9.89,1000,"data1b",
                diffpoint.diffpoint3(),normdiff1,sigdiff1,false);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        String[] label = {"silhouette"};
        plot.makeplot2(dataplot,label,"data-b","rule","silhouette");
    }
    public static void cases3() throws IOException{
        int[] normdiff2 = {100,500,1};
        int[] sigdiff2 = {50,2000,1};
        double[][] data2 = dataset.createdata(100,1000,1000,"data2b",
                diffpoint.diffpoint4(),normdiff2,sigdiff2,true);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data2);
        String[] label = {"value"};
        plot.makeplot2(dataplot,label,"value","rule","silhouette");
    }
}
