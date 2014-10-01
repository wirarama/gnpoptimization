/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpoptimization;

/**
 *
 * @author wirarama
 */
public class arrayfunction {
    public static int randomrange(int min,int max){
        int randomvalue = min + (int)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static double[][] cleanarray(double[][] data,int length){
        double[][] newdata = new double[length][data[0].length];
        System.arraycopy(data, 0, newdata, 0, length);
        return newdata;
    }
}
