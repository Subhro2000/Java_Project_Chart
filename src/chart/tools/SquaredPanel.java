/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chart.tools;

import chart.barChart.main.BarChartPanel;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Subhro Ghosh
 */
public class SquaredPanel extends JPanel
{
    public int x;
    public int y;
    public int side;

    

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        side = Math.min(getWidth(), getHeight());
        final int BORDER = 10;
        side-=2*BORDER;
         x = (getWidth()-side)/2;
         y = (getHeight()-side)/2;
    }
    
}