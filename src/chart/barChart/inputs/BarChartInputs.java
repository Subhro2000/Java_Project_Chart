/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chart.barChart.inputs;

import chart.pieChart.inputs.PieChartInputs;

/**
 *
 * @author Subhro Ghosh
 */
public class BarChartInputs extends PieChartInputs
{
    public int maxValue;
    public int minValue;
    public int gapInterval;

    
    public static BarChartInputs takeInputs()
    {
        
        BarChartInputs inp = new BarChartInputs();
        inp.maxValue = 30000;
        inp.minValue = 0;
        inp.gapInterval = 10000;
//        inp.values = new double[]{35,30,10,25,40,5};
//        inp.labels = new String[]{"Apple", "Orange", "Banana", "Kiwifruit", "Blackberry", "Grapes"};
//        inp.values = new double[]{95,20,85,60,50,40,30,10,30,55};
//        inp.values = new double[]{95,20,85,60};
        inp.values = new double[]{29000,5000,26000,18000,16000,12000,9000,3000};
//        inp.values = new double[]{29000,5000,26000,18000,16000,12000,9000,3000,20000,15000,7000,21000,27000,14000};
//        inp.labels = new String[]{"Venezuela","US", "Saudi", "Canada"};
        inp.labels = new String[]{"Venezuela","US", "Saudi", "Canada", "Iran", "Russia", "UAE", "China","India","Pakistan","Norway","Mayanmar","SriLanka","Africa"};
//        inp.labels = new String[]{"Venezuela","US", "Saudi", "Canada", "Iran", "Russia", "UAE", "China","India","Mayanmar"};
        inp.colors = readColors("Big Color Table.txt", true, 0);
        inp.header = "Top Oil Reserve";
//        inp.header = "Nices Fruits";
        return inp;
    }
}
