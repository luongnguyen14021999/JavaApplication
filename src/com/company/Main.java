package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener {

     JLabel lbl;
     JButton btn1;
     JButton btn2;
     JButton btn3;
     JButton btn4;
     JButton btn5;
     String str;
    double[] weight = new double[100];
    double[] distance = new double[100];
    double[] money = new double[100];
    double[] finalmoney = new double[100];
    int[] freightID = new int[100];
    double[] valueOfVoucher = new double[50];
    String[] freightStatus = new String[100];
    int t = 0;
    int ID = 1961;
    private int v = 0;
    private double percent;

    public Main() {
        setLayout(null);
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl = new JLabel("Welcome to FastFreight Company. You can select an option from 1-5. ");
        btn1 = new JButton("1. Add Freight Order");
        btn2 = new JButton("2. Update Freight Status ");
        btn3 = new JButton("3. Display Freight Vouchers ");
        btn4 = new JButton("4. Display Freight Orders ");
        btn5 = new JButton("5. Exit the system ");
        lbl.setBounds(100, 30, 500, 30);
        btn1.setBounds(200, 80, 200, 20);
        btn2.setBounds(200, 130, 200, 20);
        btn3.setBounds(200, 180, 200, 20);
        btn4.setBounds(200, 230, 200, 20);
        btn5.setBounds(200, 280, 200, 20);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(lbl);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1) {
            str = JOptionPane.showInputDialog("Please enter your weight of the parcel(kg)");
            weight[t] = Double.parseDouble(str);
            while (weight[t] > 20) {
                JOptionPane.showMessageDialog(null, "The Company only accepts to deliver parcels 20kg or less. Please enter again");
                str = JOptionPane.showInputDialog("Please enter your weight of the parcel(kg)");
                weight[t] = Double.parseDouble(str);
            }
            str = JOptionPane.showInputDialog("PLease enter the distance to destination");
            distance[t] = Double.parseDouble(str);
            while (distance[t] > 5000) {
                JOptionPane.showMessageDialog(null, "Maximum distance for the destination is 5000km. Please enter again");
                str = JOptionPane.showInputDialog("PLease enter the distance to destination");
                distance[t] = Double.parseDouble(str);
            }
            v++;
            if (v < 51)
            {
                int k = JOptionPane.showConfirmDialog(null, "Your voucher code is" + " " + v, "Do you want to use your voucher", JOptionPane.YES_NO_OPTION);
                if (k == JOptionPane.YES_OPTION) {
                    int a;
                    str = JOptionPane.showInputDialog("Please enter your voucher code");
                    a = Integer.parseInt(str);
                    while (a != v) {
                        JOptionPane.showMessageDialog(null, "Your voucher code is not matched");
                        str = JOptionPane.showInputDialog("Please enter your voucher code");
                        a = Integer.parseInt(str);
                    }
                    str = JOptionPane.showInputDialog("How many percent of your voucher do you want to use?");
                    percent = Double.parseDouble(str);
                    JOptionPane.showMessageDialog(null,"You order successfully");
                    freightStatus[t] = "W";
                    valueOfVoucher[t] = 1 - (percent/100);
                    if (weight[t] <= 2) {
                        money[t] = (distance[t] * 5.1) / 5;
                        finalmoney[t] = money[t] - money[t] * (20 / 100) * (percent / 100);
                    } else if (weight[t] > 2 && weight[t] <= 6) {
                        money[t] = (distance[t] * 6.2) / 5;
                        finalmoney[t] = money[t] - money[t] * (20 / 100) * (percent / 100);
                    } else if (weight[t] > 6 && weight[t] <= 10) {
                        money[t] = (distance[t] * 8.7) / 5;
                        finalmoney[t] = money[t] - money[t] * (20 / 100) * (percent / 100);
                    } else {
                        money[t] = (distance[t] * 10.8) / 5;
                        finalmoney[t] = money[t] - money[t] * (20 / 100) * (percent / 100);
                    }
                }
                if (k == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null,"You order successfully");
                    valueOfVoucher[t] = 1;
                    if (weight[t] <= 2) {
                        money[t] = (distance[t] * 5.1) / 5;
                        finalmoney[t] = money[t];
                    } else if (weight[t] > 2 && weight[t] <= 6) {
                        money[t] = (distance[t] * 6.2) / 5;
                        finalmoney[t] = money[t];
                    } else if (weight[t] > 6 && weight[t] <= 10) {
                        money[t] = (distance[t] * 8.7) / 5;
                        finalmoney[t] = money[t];
                    } else {
                        money[t] = (distance[t] * 10.8) / 5;
                        finalmoney[t] = money[t];
                    }
                }
                freightID[t] = ID;
                t = t+1;
                freightID[t] = freightID[t-1] + 1;
                ID = freightID[t];
            } else
            {
                if (weight[t] <= 2) {
                    money[t] = (distance[t] * 5.1) / 5;
                    finalmoney[t] = money[t];
                } else if (weight[t] > 2 && weight[t] <= 6) {
                    money[t] = (distance[t] * 6.2) / 5;
                    finalmoney[t] = money[t];
                } else if (weight[t] > 6 && weight[t] <= 10) {
                    money[t] = (distance[t] * 8.7) / 5;
                    finalmoney[t] = money[t];
                } else {
                    money[t] = (distance[t] * 10.8) / 5;
                    finalmoney[t] = money[t];
                }
            }

        }
        if(e.getSource()  == btn2)
        {
            for(int z=0;z<t;z++)
            {
                if(freightStatus[z] == "W" || freightStatus[z] == "P")
                System.out.println(freightID[z]);
                System.out.println("\n");
            }
            int u;
            str = JOptionPane.showInputDialog("Please enter your freight ID");
            u = Integer.parseInt(str);
            if(u>1960+t || u < 1961)
            {
                JOptionPane.showMessageDialog(null,"Your freight ID is not matched with any existing ID. Please choose option 2 and enter again");
            }
            else {
                int x = u - 1961;
                String d = "D";
                String w = "W";
                String p = "P";
                str = JOptionPane.showInputDialog("Please update freight status");
                str = str.substring(0);
                if (str.equals(d) || str.equals(w) || str.equals(p)) {
                    freightStatus[x] = str;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Your status code is not valid. Please update again");

                }

            }

        }
        if(e.getSource() == btn3)
        {
          int r = 0;
          int k = 1;
          while(r<t)
          {
              System.out.println("Voucher number: "+ k +" ");
              System.out.println("The value of the voucher: "+ valueOfVoucher[r]);
              System.out.println("\n");
              r++;
              k++;
          }

        }
        if(e.getSource() == btn4)
        {
            int j;
            str = JOptionPane.showInputDialog("Please enter your freight ID");
            j = Integer.parseInt(str);
            if(j>1960+t || j < 1961)
            {
                JOptionPane.showMessageDialog(null,"Your freight ID is not matched with any existing ID. Please choose option 4 and enter again");
            }
            else
            {
                int p = j - 1961;
                JOptionPane.showMessageDialog(null,"ID: "+j+"\n"+"The status of your freight: "+freightStatus[p]+"\n"+"The final amount payable: "+"$"+finalmoney[p]);
            }
        }
        if(e.getSource() == btn5)
        {
            System.exit(0);
        }
    }
}