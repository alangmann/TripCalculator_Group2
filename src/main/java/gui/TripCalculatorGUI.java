package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Corinna on 27.11.2014.
 */
public class TripCalculatorGUI {
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

    public TripCalculatorGUI() {
        btSubmitT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }


    public static void main(String[] args)
    {
        new TripCalculatorGUI()
    }


}
