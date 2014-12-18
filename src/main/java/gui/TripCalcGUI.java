package gui;

import bl.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Created by Corinna on 27.11.2014.
 */

//hey yooooo
public class TripCalcGUI extends JFrame{



    private JPanel paLeft = new JPanel();
    private JPanel paRight = new JPanel();

    private JButton btSubmitT = new JButton();
    private JTextField txOutputT = new JTextField();
    private JTextField txFuelConT= new JTextField();
    private JTextField txCargoT= new JTextField();
    private JTextField txAxlesT= new JTextField();
    private JCheckBox chbAdBlueT = new JCheckBox();
    private JComboBox cbTypeFuelT = new JComboBox();
    private JLabel lbFuelConT = new JLabel();
    private JLabel lbTypeFuelT= new JLabel();
    private JLabel lbCargoT= new JLabel();
    private JLabel lbAxlesT= new JLabel();
    private JLabel lbAdBlue= new JLabel();
    private JPanel pa1 = new JPanel();
    private JPanel pa2 = new JPanel();
    private JPanel pa3 = new JPanel();
    private JPanel pa4 = new JPanel();
    private JPanel pa5 = new JPanel();
    private JButton btSubmitCar = new JButton("Submit");
    private JTextField txOutputCar = new JTextField();
    private JPanel paTop = new JPanel();
    private JPanel paMiddle = new JPanel();
    private JPanel paBottom = new JPanel();
    private JTextField txFuelConsumptionCar = new JTextField();
    private JTextField txCargoCar = new JTextField();
    private JComboBox cbTypeOfFuelCar = new JComboBox();
    private JLabel lbFuelConsumptionCar = new JLabel("Fuel consumption: ");
    private JLabel lbTypeOfFuelCar = new JLabel("Type of fuel: ");
    private JLabel lbCargoCar = new JLabel("Cargo in kg: ");
    private ButtonGroup gp = new ButtonGroup();
    private JRadioButton rbCar = new JRadioButton();
    private JRadioButton rbTruck = new JRadioButton();

    private Calculator calc = new Calculator();
    private LinkedList<Route> routeList = new LinkedList<Route>();
    private Vehicle v;
    private double co2 = 0;


    public TripCalcGUI() throws HeadlessException
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 250);
        this.setLocationRelativeTo(null);
        init();
    }

    public void init()
    {
        Container con = this.getContentPane();
        con.setLayout(new GridLayout(1,2));

        rbCar.setText("Car");
        rbTruck.setText("Truck");
        gp.add(rbCar);
        gp.add(rbTruck);
        rbCar.setSelected(true);

        rbCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbCar.isSelected())
                {
                    Component[] com = paLeft.getComponents();

                    for (int a = 0; a < com.length; a++) {
                        com[a].setEnabled(false);
                    }
                }
            }
        });
        //sdfsdfsdfs

        JPanel paRight = new JPanel();
        paRight.setLayout(new GridLayout(8,1));
        paRight.setBorder(new TitledBorder("Truck"));
        con.add(paLeft);
        paLeft.setLayout(new GridLayout(6, 1));
        paLeft.setBorder(new TitledBorder("Car"));
        paLeft.add(rbCar);
        paLeft.add(paTop);
        paLeft.add(paMiddle);
        paLeft.add(paBottom);
        paLeft.add(btSubmitCar);
        paLeft.add(txOutputCar);
        paTop.setLayout(new GridLayout(1,2));
        paMiddle.setLayout(new GridLayout(1,2));
        paBottom.setLayout(new GridLayout(1,2));
        paTop.add(lbFuelConsumptionCar);
        paTop.add(txFuelConsumptionCar);
        paMiddle.add(lbTypeOfFuelCar);
        paMiddle.add(cbTypeOfFuelCar);
        paBottom.add(lbCargoCar);
        paBottom.add(txCargoCar);

        pa1.setLayout(new GridLayout(1,2));
        pa2.setLayout(new GridLayout(1,2));
        pa3.setLayout(new GridLayout(1,2));
        pa4.setLayout(new GridLayout(1,2));
        pa5.setLayout(new GridLayout(1,2));


        lbFuelConT.setText("Average Fuel Consumption");
        lbTypeFuelT.setText("Type of Fuel");
        lbCargoT.setText("Cargo in kg");
        lbAxlesT.setText("Axles");
        lbAdBlue.setText("Use ad Blue");
        btSubmitT.setText("Submit");

        pa1.add(lbFuelConT);
        pa1.add(txFuelConT);
        pa2.add(lbTypeFuelT);
        pa2.add(cbTypeFuelT);
        pa3.add(lbCargoT);
        pa3.add(txCargoT);
        pa4.add(lbAxlesT);
        pa4.add(txAxlesT);
        pa5.add(lbAdBlue);
        pa5.add(chbAdBlueT);

        paRight.add(rbTruck);
        paRight.add(pa1);
        paRight.add(pa2);
        paRight.add(pa3);
        paRight.add(pa4);
        paRight.add(pa5);
        paRight.add(btSubmitT);
        paRight.add(txOutputT);

        con.add(paRight);
        readCSV();

        for(FuelType f : FuelType.values())
        {
            cbTypeOfFuelCar.addItem(f.toString());
        }


        btSubmitCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                datenAutoEinlesen();
                co2= 0;

                for(Route r : routeList)
                {
                    co2+= calc.calculateCo2Consumption(r, v);
                }

                txOutputCar.setText(co2+"");

            }
        });

    }


    public void readCSV()
    {
        BufferedReader br;
        int i = 0;
        try {

            String pathName = System.getProperty("user.dir")+ File.separator+ "src" + File.separator + "main"+
                    File.separator + "resources" + File.separator+"routes.csv";

            br = new BufferedReader(new FileReader(pathName));


            String str = "";
            String[] strArray;

            while ((str = br.readLine()) != null)
            {
                if(i!= 0)
                {
                    strArray = str.split(";");

                    Route r = new Route(Double.parseDouble(strArray[0].replace(",",".")), RouteType.valueOf(strArray[2]),
                            Double.parseDouble(strArray[3].replace(",",".")), Double.parseDouble(strArray[1].replace(",",".")));

                    routeList.add(r);

                }


                i++;


            }
            br.close();


        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }


    }
    public void datenAutoEinlesen()
    {
        double fuelConsumption = Double.parseDouble(txFuelConsumptionCar.getText().replace(",", "."));
        int cargo = Integer.parseInt(txCargoCar.getText());
        FuelType typeOfFuel = FuelType.valueOf(cbTypeOfFuelCar.getSelectedItem().toString());
        v = new Vehicle(typeOfFuel, cargo, fuelConsumption);
    }

    public static void main(String[] args)
    {
        new TripCalcGUI().setVisible(true);
    }

}
