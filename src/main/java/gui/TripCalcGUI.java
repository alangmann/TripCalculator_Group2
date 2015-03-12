/**
 * Created by Corinna on 27.11.2014.
 */
package gui;
import bl.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.LinkedList;

@org.springframework.stereotype.Component("GUI")
public class TripCalcGUI extends JFrame{



    //C:\Users\Yvonne\4CHIF\Java\Enterprise Application\TripCalculator_Group2\trunk\src\main\resources

    private static String rPath = System.getProperty("user.dir")+ "\\src\\main\\resources\\routes.csv";
    private static String sPath = System.getProperty("user.dir")+ "\\src\\main\\resources\\sprit_db.csv";
    private Calendar cal = Calendar.getInstance();
    private int weekDay = cal.get(Calendar.DAY_OF_WEEK);

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

    private JPanel paLabelsTruck = new JPanel();
    private JPanel paLabelsCar = new JPanel();

    private JPanel paUnterteilungTruck = new JPanel();
    private JPanel paUnterteilungCar = new JPanel();

    private JTextField txCostTruck = new JTextField();
    private JTextField txCostCar = new JTextField();
    private JLabel lbCostTruck = new JLabel();
    private JLabel lbCostCar = new JLabel();
    private JLabel lbOutputCar = new JLabel();
    private JLabel lbOutputTruck = new JLabel();

    private Calculator calc = new Calculator();
    private LinkedList<Route> routeList = new LinkedList<Route>();
    private LinkedList<FuelPrices> fuelPricesList = new LinkedList<FuelPrices>();

    @Resource(name = "Car")
    private Car c;
   // @Resource(name = "Truck")
    private Truck t;
    private double co2 = 0;
    private double cost = 0;

    @PostConstruct
    public void setUP() throws HeadlessException
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 250);
        this.setLocationRelativeTo(null);

        routeList = calc.readCSVRoutes(rPath);
        fuelPricesList = calc.readCSVSprit(sPath);

        init();

        Component[] comRight = paRight.getComponents();
        Component[] comLeft = paLeft.getComponents();


        for (int a = 0; a < comRight.length; a++) {
            comRight[a].setEnabled(false);

        }

        cbTypeFuelT.setEnabled(false);
        txAxlesT.setEnabled(false);
        txCargoT.setEnabled(false);
        txFuelConT.setEnabled(false);
        chbAdBlueT.setEnabled(false);

        for (int a = 0; a < comLeft.length; a++) {
            comLeft[a].setEnabled(true);
        }

        rbCar.setEnabled(true);
        rbTruck.setEnabled(true);

        txCostTruck.setEditable(false);
        txCostCar.setEditable(false);
        txOutputCar.setEditable(false);
        txOutputT.setEditable(false);
    }

    public String getCurrentWeekDay(int weekDay)
    {
        String curDay ="";

        switch(weekDay)
        {
            case 0: curDay="Monday";break;
            case 1:curDay="Tuesday";break;
            case 2:curDay="Wednesday";break;
            case 3:curDay="Thursday";break;
            case 4:curDay="Friday";break;
            case 5:curDay="Saturday";break;
            case 6:curDay="Sunday";break;
            default: curDay="Error";
        }
        return curDay;
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
            public void actionPerformed(ActionEvent e)
            {
                if(rbCar.isSelected())
                {
                    Component[] comRight = paRight.getComponents();
                    Component[] comLeft = paLeft.getComponents();


                    for (int a = 0; a < comRight.length; a++) {
                        comRight[a].setEnabled(false);

                    }

                    cbTypeFuelT.setEnabled(false);
                    txAxlesT.setEnabled(false);
                    txCargoT.setEnabled(false);
                    txFuelConT.setEnabled(false);
                    chbAdBlueT.setEnabled(false);

                    for (int a = 0; a < comLeft.length; a++) {
                        comLeft[a].setEnabled(true);
                    }

                    txFuelConsumptionCar.setEnabled(true);
                    txCargoCar.setEnabled(true);
                    cbTypeOfFuelCar.setEnabled(true);

                    rbCar.setEnabled(true);
                    rbTruck.setEnabled(true);

                }
            }
        });

        rbTruck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(rbTruck.isSelected())
                {
                    Component[] comRight = paRight.getComponents();
                    Component[] comLeft = paLeft.getComponents();


                    for (int a = 0; a < comRight.length; a++) {
                        comRight[a].setEnabled(true);

                    }
                    cbTypeFuelT.setEnabled(true);
                    txAxlesT.setEnabled(true);
                    txCargoT.setEnabled(true);
                    txFuelConT.setEnabled(true);
                    chbAdBlueT.setEnabled(true);


                    for (int a = 0; a < comLeft.length; a++) {
                        comLeft[a].setEnabled(false);
                        cbTypeOfFuelCar.setEnabled(false);
                    }

                    txFuelConsumptionCar.setEnabled(false);
                    txCargoCar.setEnabled(false);
                    cbTypeOfFuelCar.setEnabled(false);

                    rbCar.setEnabled(true);
                    rbTruck.setEnabled(true);

                }


            }
        });

        paLabelsCar.setLayout(new GridLayout(1, 2));
        paLabelsTruck.setLayout(new GridLayout(1, 2));
        paUnterteilungTruck.setLayout(new GridLayout(1, 2));
        paUnterteilungCar.setLayout(new GridLayout(1, 2));

        paUnterteilungTruck.add(txOutputT);
        paUnterteilungTruck.add(txCostTruck);
        paUnterteilungCar.add(txOutputCar);
        paUnterteilungCar.add(txCostCar);

        lbCostTruck.setText("Costs:");
        lbCostCar.setText("Costs:");
        lbOutputCar.setText("CO2  consumption:");
        lbOutputTruck.setText("CO2 consumption:");

        lbCostTruck.setHorizontalAlignment(SwingConstants.CENTER);
        lbCostCar.setHorizontalAlignment(SwingConstants.CENTER);
        lbOutputCar.setHorizontalAlignment(SwingConstants.CENTER);
        lbOutputTruck.setHorizontalAlignment(SwingConstants.CENTER);

        paLabelsTruck.add(lbOutputTruck);
        paLabelsTruck.add(lbCostTruck);
        paLabelsCar.add(lbOutputCar);
        paLabelsCar.add(lbCostCar);

        paRight.setLayout(new GridLayout(9,1));
        paRight.setBorder(new TitledBorder("Truck"));
        con.add(paLeft);
        con.add(paRight);
        paLeft.setLayout(new GridLayout(7, 1));
        paLeft.setBorder(new TitledBorder("Car"));
        paLeft.add(rbCar);
        paLeft.add(paTop);
        paLeft.add(paMiddle);
        paLeft.add(paBottom);
        paLeft.add(btSubmitCar);
        paLeft.add(paLabelsCar);
        paLeft.add(paUnterteilungCar);

        paRight.add(rbTruck);
        paRight.add(pa1);
        paRight.add(pa2);
        paRight.add(pa3);
        paRight.add(pa4);
        paRight.add(pa5);
        paRight.add(btSubmitT);
        paRight.add(paLabelsTruck);
        paRight.add(paUnterteilungTruck);

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
        pa5.setLayout(new GridLayout(1, 2));


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


        for(FuelType f : FuelType.values())
        {
            cbTypeOfFuelCar.addItem(f.toString());
            cbTypeFuelT.addItem(f.toString());
        }


        btSubmitCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String fuelConsumption = txFuelConsumptionCar.getText();
                String cargo = txCargoCar.getText();
                datenAutoEinlesen(fuelConsumption, cargo);
                co2= 0;
                cost = 0;


                berechnungCar();
            }
        });

        btSubmitT.addActionListener(new ActionListener(
        ) {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String fuelConsumption = txFuelConT.getText();
                String cargo = txCargoT.getText();
                String axles = txAxlesT.getText();
                datenTruckEinlesen(fuelConsumption, cargo, axles);
                co2= 0;
                cost = 0;
                String curDay = getCurrentWeekDay(weekDay);

                for(Route r : routeList)
                {
                    co2+= calc.calculateCo2Consumption(r, t);
                    cost+=calc.calculateTotalCostOfRoute(r, t, curDay, fuelPricesList);
                }
                txCostTruck.setText(String.format("%.2f Euro",cost));
                txOutputT.setText(String.format("%.2f kg",co2));
            }
        });

    }



    public double berechnungCar()
    {
        String curDay = getCurrentWeekDay(weekDay);
        for(Route r : routeList)
        {
            co2+= calc.calculateCo2Consumption(r, c);
            cost+=calc.calculateTotalCostOfRoute(r, c, curDay, fuelPricesList);
        }

        txCostCar.setText(String.format("%.2f Euro",cost));
        txOutputCar.setText(String.format("%.2f kg", co2));

        return co2;
    }

    public void datenAutoEinlesen(String fuelConsumption, String cargo)
    {

            double fuelConsumptionDouble = Double.parseDouble(fuelConsumption);
            int cargoInt = Integer.parseInt(cargo);
            FuelType typeOfFuel = FuelType.valueOf(cbTypeOfFuelCar.getSelectedItem().toString());
           // c = new Car(typeOfFuel, cargoInt, fuelConsumptionDouble); //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        c.setTypeOfFuel(typeOfFuel);
        c.setCargo(cargoInt);
        c.setAverageConsumption(fuelConsumptionDouble);
    }

    public void datenTruckEinlesen(String fuelConsumption, String cargo, String axles)
    {
            double fuelConsumptionDouble = Double.parseDouble(txFuelConT.getText().replace(",", "."));
            int cargoInt = Integer.parseInt(txCargoT.getText());
            FuelType typeOfFuel = FuelType.valueOf(cbTypeFuelT.getSelectedItem().toString());
            int axlesInt = Integer.parseInt(txAxlesT.getText());
            boolean adBlue = false;
            if (chbAdBlueT.isSelected()) {
                adBlue = true;
            } else {
                adBlue = false;
            }

           // t = new Truck(typeOfFuel, cargoInt, fuelConsumptionDouble, adBlue, axlesInt); //aaaaaaaaaaaaaaaaa

        t.setTypeOfFuel(typeOfFuel);
        t.setCargo(cargoInt);
        t.setAverageConsumption(fuelConsumptionDouble);
        t.setAdBlue(adBlue);
        t.setAxles(axlesInt);
    }

    public static void main(String[] args)
    {
       // new TripCalcGUI(routePath, spritPath).setVisible(true);
        System.out.println("aaaa");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/spring/spring-di-sample-annotation-context.xml");
        System.out.println("bbbb");

        context.getBean("GUI", JFrame.class).setVisible(true);
        System.out.println("cccc");
    }
}

