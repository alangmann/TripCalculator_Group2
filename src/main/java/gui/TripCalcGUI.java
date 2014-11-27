package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Corinna on 27.11.2014.
 */
public class TripCalcGUI extends JFrame{



    private JPanel paLeft;
    private JPanel paRight;

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

    private JButton btSubmitCar;
    private JTextField txOutputCar;
    private JPanel paTop;
    private JPanel paMiddle;
    private JPanel paBottom;
    private JTextField txFuelConsumptionCar;
    private JTextField txCargoCar;
    private JComboBox cbTypeOfFuelCar;
    private JLabel lbFuelConsumptionCar;
    private JLabel lbTypeOfFuelCar;
    private JLabel lbCargoCar;


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
        con.setLayout(new GridLayout(2,1));



    }


    public static void main(String[] args)
    {
        new TripCalcGUI().setVisible(true);
    }


}
