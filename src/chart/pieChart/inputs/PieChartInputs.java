/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chart.pieChart.inputs;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Subhro Ghosh
 */
public class PieChartInputs
{
    public double values[];
    public String labels[];
    public String header;
    public Color colors[];
    
    
    public static PieChartInputs takeInputs()
    {
        PieChartInputs inp = new PieChartInputs();
        inp.values = new double[]{31.2,9.8,7.8,6.1,6.0,4.6,4.3,3.9,2.9,2.7,20.7};
//        inp.values = new double[]{3,4,5};
        inp.labels = new String[]{"Mandarin", "Spanish", "English", "Arabic", "Hindi", "Portuguese", "Bengali", "Russian", "Japanese", "Punjabi", "Others"};
        inp.colors = readColors("Big Color Table.txt",true,0);
        inp.header = "Top 10 Languages";
//        takeValue(inp);
        
        return inp;
    }
    
    private static void takeValue(PieChartInputs inp)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the header : ");
        inp.header = sc.nextLine();
        
        System.out.print("Enter how many values: ");
        int n = sc.nextInt();
        
        double vals[] = new double[n];
        String lbls[] = new String[n];
        
        for(int i=0; i<n; i++)
        {
            System.out.print("Enter the label : ");
            lbls[i] = sc.next();
            System.out.print("Enter the value : ");
            vals[i] = sc.nextDouble();
           
            System.out.println("");
        }
        
        inp.values = vals;
        inp.labels = lbls;
    }
    
    
    public static Color[] readColors(String fileName, boolean hasHeading, int colNo)
    {
        FileInputStream fin = null;
        Color colors[] = new Color[0];
        try
        {
            fin = new FileInputStream(fileName);
        } catch (FileNotFoundException ex)
        {
        }
        if(fin!=null)
        {
            Scanner sc = new Scanner(fin);
            if(hasHeading)
                sc.nextLine(); //Skip the heading

            ArrayList<Color> vl = new ArrayList();

            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String fields[] = line.split("\t");
                vl.add(new Color (Integer.parseInt(fields[colNo].substring(1), 16)));
            }

            sc.close();
            colors = new Color[vl.size()];
            for (int i = 0; i < colors.length; i++)
            {
                colors[i] = vl.get(i);
            }
            
        }
        
        return colors;
    }
}