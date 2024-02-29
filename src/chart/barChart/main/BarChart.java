/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chart.barChart.main;

import chart.barChart.inputs.BarChartInputs;
import chart.tools.CenteredFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Subhro Ghosh
 */
public class BarChart
{
    public static void main(String[] args)
    {
        BarChartInputs inputs = BarChartInputs.takeInputs();
        JFrame frm = new CenteredFrame("Bar Chart");
        
        JPanel panel = new BarChartPanel(inputs.values, inputs.labels, inputs.maxValue, inputs.minValue,inputs.gapInterval,
                                                                    inputs.header, inputs.colors);
        
        frm.add(panel);
        frm.setVisible(true);
    }
    
}
