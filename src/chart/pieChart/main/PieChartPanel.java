/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chart.pieChart.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import chart.tools.SquaredPanel;

/**
 *
 * @author Subhro Ghosh
 */
public class PieChartPanel extends SquaredPanel
{
    
    private Color sliceColors[];
    private double vals[];
    private String labels[];
    private int nSlices;
    private double avg[];
    private String header;
    private Color colors[];

    public PieChartPanel(double[] vals, String[] labels, String hdr, Color[] colors)
    {
        this.vals = vals;
        this.labels = labels;
        this.colors = colors;
        this.nSlices = vals.length;
        this.sliceColors = genColors(nSlices);
        this.avg = calculateAvg(vals);
        this.header = hdr;
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
        
         //Header
        Font fnt = new Font("Times New Roman", Font.BOLD+Font.ITALIC, 40);
        g.setFont(fnt);
        FontMetrics fm0 = g.getFontMetrics();
        int wda = fm0.stringWidth(header);
        g.setColor(Color.BLACK);
        int ax = (getWidth()-wda)/2;
        int ay = (getHeight()*8/100);
        g.drawString(header,ax,ay);
        
        side = side*60/100;  // this will make the original circle 40% smaller
        x = x+side*10/100;
        y = y+side*30/100;  // to bring the chart 30% downwards
        
        int l = side/2;
        int x0 = x+l;
        int y0 = y+l;
        double theta = 270; // this is equal to -90
        double rad;
        
        
        //For labeling color rect and name
        int xrect = x+side*130/100;
        int yrect = y+side*5/100;
        int xlang = xrect+side*5/100;
        int ylang = y+side*7/100;
        int rectlen = side*2/100; // length & height of the rectangle
        
        fnt = new Font("Garamont", Font.BOLD, 15);
        g.setFont(fnt);
        FontMetrics fm = g.getFontMetrics();
        
        // drawing of main piechart
        for(int i=0; i<avg.length; i++)
        {
            
            //drawing slice
            g.setColor(sliceColors[i]);
            
            int ceilAngle = (int)Math.ceil(avg[i]);
            theta = theta+ceilAngle;
            g.fillArc(x, y,side, side, -(int)theta,ceilAngle);
            

             // drawing label color
            g.fillRect(xrect, yrect, rectlen, rectlen);
            yrect+=side*8/100;
            
            
            //drawing percentage
            String s = String.format("%.2f %s", (float)avg[i]*100/360,"%");
            g.setColor(Color.black);
            int len = l*120/100;
            double theta2 =theta-avg[i]/2;
            rad = Math.toRadians(theta2);
            int x2 = (int)(x0+len*Math.cos(rad));
            int y2 = (int)(y0+len*Math.sin(rad));
            int wd = fm.stringWidth(s);
            int ht = fm.getHeight();
            g.drawString(s, x2-wd/2, y2+ht/3);
            
            
            // drawing side label
            g.setColor(Color.black);
            g.drawString(labels[i], xlang, ylang);
            ylang+=side*8/100;
            
        } 
        
        //Footer
        String b = "Pie Chart Example";
        g.setColor(Color.red);
        int wdb = fm.stringWidth(b);
        int bx = (getWidth()-wdb)/2;
        int by = getHeight()*90/100;
        g.drawString(b,bx,by);
        
        
    }
    
    private double[] calculateAvg(double vals[])
    {
        double sum = 0;
        double ar[] = new double[vals.length];
        for(int i=0; i<ar.length; i++)
        {
            sum+=vals[i];
        }
        
        for(int i=0 ;i<ar.length; i++)
        {
            ar[i] = vals[i]/sum*100;
            ar[i] = 360*ar[i]/100;
        }
        return ar;
    }
    
}
