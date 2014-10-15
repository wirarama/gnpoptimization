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
        int[] normdiff1 = {0,10,50000};
        int[] sigdiff1 = {200,7000,500};
        int[] normdiff2 = {0,60,50000};
        int[] sigdiff2 = {50,2000,400};
        int[] normdiff3 = {0,10,40000};
        int[] sigdiff3 = {50,5000,300};
        double[][] data1 = dataset.createdata(5.43,9.89,1000,"data1",
                diffpoint.diffpoint1(),normdiff1,sigdiff1);
        double[][] data2 = dataset.createdata(4.32,9.31,1000,"data2",
                diffpoint.diffpoint2(),normdiff2,sigdiff2);
        double[][] data3 = dataset.createdata(5.64,9.04,1000,"data3",
                diffpoint.diffpoint3(),normdiff3,sigdiff3);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        dataplot.add(data2);
        dataplot.add(data3);
        String[] label = {"price","stock","weight"};
        plot.makeplot2(dataplot,label,"GNP without online optimization 1","rule","silhouette");
    }
    public static void cases1b() throws IOException{
        int[] normdiff1 = {0,10,50000};
        int[] sigdiff1 = {200,7000,500};
        int[] normdiff2 = {0,60,50000};
        int[] sigdiff2 = {50,2000,400};
        int[] normdiff3 = {0,10,40000};
        int[] sigdiff3 = {50,5000,300};
        double[][] data1 = dataset.createdata(5.43,9.89,2000,"data1",
                diffpoint.diffpoint1c(),normdiff1,sigdiff1);
        double[][] data2 = dataset.createdata(4.32,9.31,2000,"data2",
                diffpoint.diffpoint2c(),normdiff2,sigdiff2);
        double[][] data3 = dataset.createdata(5.64,9.04,2000,"data3",
                diffpoint.diffpoint3c(),normdiff3,sigdiff3);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        dataplot.add(data2);
        dataplot.add(data3);
        String[] label = {"price","stock","weight"};
        plot.makeplot2(dataplot,label,"GNP without online optimization 2","rule","silhouette");
    }
    public static void cases2() throws IOException{
        int[] normdiff1 = {0,100,50000};
        int[] sigdiff1 = {200,7000,200};
        double[][] data1 = dataset.createdata(5.43,9.89,1000,"data1b",
                diffpoint.diffpoint4(),normdiff1,sigdiff1);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        String[] label = {"silhouette"};
    }
    public static void cases3() throws IOException{
        int[] normdiff2 = {0,500,1000};
        int[] sigdiff2 = {1000,2000,100};
        double[][] data2 = dataset.createdata1(100,1000,1000,"data2b",
                diffpoint.diffpoint5(),normdiff2,sigdiff2);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data2);
        String[] label = {"value"};
    }
    public static void cases4() throws IOException{
        int[] normdiff1 = {0,10,50000};
        int[] sigdiff1 = {200,7000,500};
        int[] normdiff2 = {0,50,50000};
        int[] sigdiff2 = {50,2000,400};
        int[] normdiff3 = {0,10,40000};
        int[] sigdiff3 = {50,5000,300};
        double[][] data1 = dataset.createdata(5.43,9.89,1000,"data1",
                diffpoint.diffpoint1b(),normdiff1,sigdiff1);
        double[][] data2 = dataset.createdata(4.32,9.31,1000,"data2",
                diffpoint.diffpoint2b(),normdiff2,sigdiff2);
        double[][] data3 = dataset.createdata(5.64,9.04,1000,"data3",
                diffpoint.diffpoint3b(),normdiff3,sigdiff3);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        dataplot.add(data2);
        dataplot.add(data3);
        String[] label = {"price","stock","weight"};
        plot.makeplot2(dataplot,label,"GNP with online optimization 1","data","silhouette");
    }
    public static void cases4b() throws IOException{
        int[] normdiff1 = {0,10,50000};
        int[] sigdiff1 = {200,7000,500};
        int[] normdiff2 = {0,60,50000};
        int[] sigdiff2 = {50,2000,400};
        int[] normdiff3 = {0,10,40000};
        int[] sigdiff3 = {50,5000,300};
        double[][] data1 = dataset.createdata(5.43,9.89,2000,"data1",
                diffpoint.diffpoint1d(),normdiff1,sigdiff1);
        double[][] data2 = dataset.createdata(4.32,9.31,2000,"data2",
                diffpoint.diffpoint2d(),normdiff2,sigdiff2);
        double[][] data3 = dataset.createdata(5.64,9.04,2000,"data3",
                diffpoint.diffpoint3d(),normdiff3,sigdiff3);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(data1);
        dataplot.add(data2);
        dataplot.add(data3);
        String[] label = {"price","stock","weight"};
        plot.makeplot2(dataplot,label,"GNP with online optimization 2","data","silhouette");
    }
}