/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chart.barChart.main;

import chart.tools.SquaredPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Subhro Ghosh
 */
public class BarChartPanel extends SquaredPanel
{
    private double vals[];
    private String labels[];
    private int maxValue;
    private int minValue;
    private int gapBtHr;
    private String header;
    private Color colors[];
    private int nSlices;
    private Color sliceColors[];
    
    

    public BarChartPanel(double[] vals, String[] labels, int maxValue, int minValue, int gap, String header, Color[] colors)
    {
        
        this.vals = vals;
        this.labels = labels;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.gapBtHr = gap;
        this.header = header;
        this.nSlices = vals.length;
        this.colors = colors;
        this.sliceColors = genColors(nSlices);
        
    }
    
    private  Color[] genColors(int n) // Generating diff color every slice
    {
        Color cols[] = new Color[n];
        int nums[] = new int[n];
        
        Random rand = new Random();
        int r;
        for(int i=0; i<n; i++)
        {
            while(true)
            {
                r = rand.nextInt(colors.length);
                int j;
                for(j=0; j<i; j++)
                {
                    if(nums[j]==r)
                        break;
                }
                if(j==i)
                    break;
            }
            nums[i] = r;
            cols[i] = colors[r];
        }
        
//        System.out.println(Arrays.toString(nums));
        return cols;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setColor(Color.red);
//        g.drawRect(x, y, side, side);
        
//        x = x-side*10/100;
        x = x+side*10/100;
        side = side-side*20/100;
        
        //Header
        Font fnt0 = new Font("Times New Roman", Font.BOLD+Font.ITALIC, 40);
        g.setFont(fnt0);
        FontMetrics fm0 = g.getFontMetrics();
        int headerWd = fm0.stringWidth(header);
        g.setColor(Color.BLACK);
        int headerX = (getWidth()-headerWd)/2;
        int headerY = (getHeight()*10/100);
        g.drawString(header,headerX,headerY);
        
        Font fnt = new Font("Calibri", Font.BOLD, side*4/100);
        g.setFont(fnt);
        FontMetrics fm = g.getFontMetrics();
        
//        int baseHrY = side-(side*10/100); // 90% of the side
        int baseHrY = y+side; // 90% of the side
        int initialBaseLineY = baseHrY;
        
//        int baseHrEndX = x+side+side*50/100; // length of the line
        int baseHrEndX = x+side; // length of the line
        g.drawLine(x, baseHrY, baseHrEndX, baseHrY);
        
        String s = minValue+"  ";
        int lineValueWd = fm.stringWidth(s);
        int lineValueHt = fm.getAscent();
        g.drawString(s, x-lineValueWd, baseHrY+(lineValueHt/2));
        
//        int gapBtHr = 10000;
        int noOfHr = maxValue/gapBtHr;

        
        int gap = minValue;
        int gapHeight = side*(75/noOfHr)/100;
        
        // drawing horizontal lines
        for (int i = noOfHr; i>=1; i--)
        {
            baseHrY = baseHrY-gapHeight;
            g.drawLine(x, baseHrY, baseHrEndX, baseHrY);
            
            s = (gapBtHr+gap)+"  ";
            lineValueWd = fm.stringWidth(s);
            lineValueHt = fm.getAscent();
            g.drawString(s, x-lineValueWd, baseHrY+lineValueHt/2);
            gap+=gapBtHr;
        }
        
        
        int sideforBar = initialBaseLineY-baseHrY; // 75% of the total side
        
        int wd = (baseHrEndX-x)/vals.length;
        int barWd = (int) (wd*80/100.0);
        int gapBtBar = x+(wd-barWd);

        int barStartX =0;
        
        Font fnt2 = new Font("", Font.PLAIN, 15);
        g.setFont(fnt2);
        FontMetrics fm2 = g.getFontMetrics();
        int labelStartY = initialBaseLineY+initialBaseLineY*5/100; // for labels
        
        // drawing bars
        for (int i = 0; i < vals.length; i++)
        {
            g.setColor(sliceColors[i]);
            barStartX+=gapBtBar;
            int barHeight = (int)(vals[i]*sideforBar/(maxValue));
            int barStartY = baseHrY+(sideforBar-barHeight);
            g.fillRect(barStartX, barStartY, barWd, barHeight);
            
            g.setColor(Color.black);
            int fntwd = fm2.stringWidth(labels[i]);
            g.drawString(labels[i], barStartX+(barWd/2)-(fntwd/2), labelStartY);
            
            barStartX+=barWd;
            gapBtBar = wd-barWd;
            
        }        
        
        
        
        //Footer
        String footer = "Bar Chart Example";
        g.setColor(Color.red);
        int footerWd = fm2.stringWidth(footer);
        int footerX = (getWidth()-footerWd)/2;
        int footerY = getHeight()*90/100;
        g.drawString(footer,footerX,footerY);

    }
    
}
