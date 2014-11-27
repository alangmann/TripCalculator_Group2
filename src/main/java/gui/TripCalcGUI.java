package gui;

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

    private JButton btSubmitT;
    private JTextField txOutputT;
    private JTextField txFuelConT;
    private JTextField txCargoT;
    private JTextField txAxlesT;
    private JCheckBox chbAdBlueT;
    private JComboBox cbTypeFuelT;
    private JLabel lbFuelConT;
    private JLabel lbTypeFuelT;
    private JLabel lbCargoT;
    private JLabel lbAxlesT;
    private JLabel lbAdBlue;
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


    public TripCalcGUI() throws HeadlessException
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        init();
    }

    public void init()
    {
        Container con = this.getContentPane();
        con.setLayout(new GridLayout(1,2));

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

    }


    public static void main(String[] args)
    {
        new TripCalcGUI().setVisible(true);
    }


}
