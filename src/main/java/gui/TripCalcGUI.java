package gui;

import bl.Calculator;
import bl.FuelType;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Corinna on 27.11.2014.
 */
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

    private Calculator calc = new Calculator();

    public TripCalcGUI() throws HeadlessException
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 250);
        this.setLocationRelativeTo(null);
        init();
        datenAutoEinlesen();
    }

    public void init()
    {
        Container con = this.getContentPane();
        con.setLayout(new GridLayout(1,2));

        JPanel paRight = new JPanel();
        paRight.setLayout(new GridLayout(7,1));
        paRight.setBorder(new TitledBorder("Truck"));
        con.add(paLeft);
        paLeft.setLayout(new GridLayout(5, 1));
        paLeft.setBorder(new TitledBorder("Car"));
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

        paRight.add(pa1);
        paRight.add(pa2);
        paRight.add(pa3);
        paRight.add(pa4);
        paRight.add(pa5);
        paRight.add(btSubmitT);
        paRight.add(txOutputT);

        con.add(paRight);

        btSubmitCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calc.init();
            }
        });

    }

    public void datenAutoEinlesen()
    {
        String fuelConsumption = txFuelConsumptionCar.getText();
        String cargo = txCargoCar.getText();

        for(FuelType f : FuelType.values())
        {
            cbTypeOfFuelCar.addItem(f.toString());
        }

        String typeOfFuel = cbTypeOfFuelCar.getSelectedItem().toString();
    }

    public static void main(String[] args)
    {
        new TripCalcGUI().setVisible(true);

    }

    //ksdfdsfsdf


}
