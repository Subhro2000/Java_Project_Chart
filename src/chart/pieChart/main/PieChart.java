/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chart.pieChart.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import chart.tools.CenteredFrame;
import chart.pieChart.inputs.PieChartInputs;

/**
 *
 * @author Subhro Ghosh
 */
public class PieChart
{
    public static void main(String[] args)
    {
        PieChartInputs inputs = PieChartInputs.takeInputs();
        JPanel panel = new PieChartPanel(inputs.values, inputs.labels, inputs.header, inputs.colors);
        JFrame frm = new CenteredFrame("Pie Chart");
        frm.add(panel);
        frm.setVisible(true);
    }
}
