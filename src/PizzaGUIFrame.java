import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import static java.awt.Color.black;

public class PizzaGUIFrame extends JFrame
{
    //Declarations

    //JPanels
    private JPanel mainPnl, sizePnl, crustPnl, toppingsPnl, receiptPnl, buttonPnl, bottomPnl;

    //JButtons
    private JButton orderbtn, clearbtn, quitbtn;

    //JRadioButtons
    private JRadioButton thinCrust, regularCrust, deepDishCrust, GFCrust, invisibleButton;

    //Button Group
    private ButtonGroup crustButtons;

    //JComboBox
    private JComboBox sizeSelect;

    //JCheckBoxes
    private JCheckBox pepBox, oliveBox, mushroomBox, pineappleBox, hamBox, pepperBox;

    //JScroller
    private JScrollPane scroller;

    //JTextAres
    private JTextArea receipt;

    //booleans
    boolean crustSelected;


    //for JoptionPane
    int reply;

    //variables
    double beforeTax = 0;
    double toppingsTotal = 0;
    double sizePrice = 0;
    double taxTotal = 0;
    double finalTotal = 0;


    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createSizePnl();
        mainPnl.add(sizePnl, BorderLayout.WEST);

        createCrustPnl();
        mainPnl.add(crustPnl, BorderLayout.CENTER);

        createToppingsPnl();
        mainPnl.add(toppingsPnl, BorderLayout.EAST);

        createBottomPnl();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);


        add(mainPnl);
        setTitle("Pizza GUI Order");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createBottomPnl() //puts receipt panel and button panel together
    {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new BorderLayout());
        bottomPnl.setPreferredSize(new Dimension(900, 450));

        createReceiptPnl();
        createButtonPnl();

        bottomPnl.add(receiptPnl, BorderLayout.NORTH);
        bottomPnl.add(buttonPnl, BorderLayout.SOUTH);
    }

    private void createSizePnl()
    {
        sizePnl = new JPanel();

        //border created for SizePnl
        sizePnl.setBorder(new TitledBorder((new LineBorder(new Color(245, 12, 0), 6)), "Pick A Size!"));
        sizePnl.setBackground(new Color(245, 228, 153));
        sizePnl.setPreferredSize(new Dimension(300, 300));

        //Creates Selections
        String sizes[] = {"","Small","Medium", "Large", "Super"};
        sizeSelect = new JComboBox(sizes);
        sizeSelect.setFont(new Font("Dialog", Font.BOLD, 20));
        sizeSelect.setBackground(new Color(211, 211, 211));
        sizeSelect.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        sizePnl.add(sizeSelect);
    }


    private void createCrustPnl()
    {
        crustPnl = new JPanel();

        //border created for CrustPnl
        crustPnl.setBorder(new TitledBorder((new LineBorder(new Color(245, 12, 0), 6)),"Pick A Crust!"));
        crustPnl.setBackground(new Color(245, 228, 153));
        crustPnl.setPreferredSize(new Dimension(300, 300));

        //initialize the buttons
        thinCrust = new JRadioButton("Thin ");
        thinCrust.setFont(new Font("Dialog", Font.BOLD, 20));
        thinCrust.setBackground(new Color(245, 156, 32));
        thinCrust.setBorderPainted(true);
        thinCrust.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        regularCrust = new JRadioButton("Regular ");
        regularCrust.setFont(new Font("Dialog", Font.BOLD, 20));
        regularCrust.setBackground(new Color(245, 156, 32));
        regularCrust.setBorderPainted(true);
        regularCrust.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        deepDishCrust = new JRadioButton("Deep Dish ");
        deepDishCrust.setFont(new Font("Dialog", Font.BOLD, 20));
        deepDishCrust.setBackground(new Color(245, 156, 32));
        deepDishCrust.setBorderPainted(true);
        deepDishCrust.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        //I'm gluten intolerant. Little code easter egg ;)
        GFCrust = new JRadioButton("Gluten Free ");
        GFCrust.setFont(new Font("Dialog", Font.BOLD, 20));
        GFCrust.setBackground(new Color(245, 156, 32));
        GFCrust.setBorderPainted(true);
        GFCrust.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        //for when the board is cleared
        invisibleButton = new JRadioButton();
        invisibleButton.setVisible(false);
        invisibleButton.setSelected(false);

        //groups JRadioButtons
        crustButtons = new ButtonGroup();

        //adds to panels
        crustButtons.add(invisibleButton);
        crustButtons.add(thinCrust);
        crustButtons.add(regularCrust);
        crustButtons.add(deepDishCrust);
        crustButtons.add(GFCrust);

        crustPnl.add(thinCrust);
        crustPnl.add(regularCrust);
        crustPnl.add(deepDishCrust);
        crustPnl.add(GFCrust);

    }

    private void createToppingsPnl()
    {
        toppingsPnl = new JPanel();

        toppingsPnl.setBorder(new TitledBorder((new LineBorder(new Color(245, 12, 0), 6)), "Pick Some Toppings!"));
        toppingsPnl.setBackground(new Color(245, 228, 153));
        toppingsPnl.setPreferredSize(new Dimension(300, 300));

        toppingsPnl.setLayout(new FlowLayout());

        // creates CheckBoxes
        pepBox = new JCheckBox("Pepperoni ");
        pepBox.setFont(new Font("Dialog", Font.BOLD, 20));
        pepBox.setBackground(new Color(245, 156, 32));
        pepBox.setBorderPainted(true);
        pepBox.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        oliveBox = new JCheckBox("Olives ");
        oliveBox.setFont(new Font("Dialog", Font.BOLD, 20));
        oliveBox.setBackground(new Color(245, 156, 32));
        oliveBox.setBorderPainted(true);
        oliveBox.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        mushroomBox = new JCheckBox("Mushrooms ");
        mushroomBox.setFont(new Font("Dialog", Font.BOLD, 20));
        mushroomBox.setBackground(new Color(245, 156, 32));
        mushroomBox.setBorderPainted(true);
        mushroomBox.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        pineappleBox = new JCheckBox("Pineapple ");
        pineappleBox.setFont(new Font("Dialog", Font.BOLD, 20));
        pineappleBox.setBackground(new Color(245, 156, 32));
        pineappleBox.setBorderPainted(true);
        pineappleBox.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        hamBox = new JCheckBox("Ham ");
        hamBox.setFont(new Font("Dialog", Font.BOLD, 20));
        hamBox.setBackground(new Color(245, 156, 32));
        hamBox.setBorderPainted(true);
        hamBox.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        pepperBox = new JCheckBox("Peppers ");
        pepperBox.setFont(new Font("Dialog", Font.BOLD, 20));
        pepperBox.setBackground(new Color(245, 156, 32));
        pepperBox.setBorderPainted(true);
        pepperBox.setBorder(new LineBorder(new Color(245, 12, 0), 4));

        toppingsPnl.add(pepBox);
        toppingsPnl.add(oliveBox);
        toppingsPnl.add(mushroomBox);
        toppingsPnl.add(pineappleBox);
        toppingsPnl.add(hamBox);
        toppingsPnl.add(pepperBox);

    }


    private void createReceiptPnl()
    {
        receiptPnl = new JPanel();
        receiptPnl.setPreferredSize(new Dimension(900, 400));

        receipt = new JTextArea(20,40);
        receipt.setEditable(false);

        receiptPnl.setBorder(new TitledBorder((new LineBorder(new Color(245, 12, 0), 6)), "Receipt:"));
        receiptPnl.setBackground(new Color(245, 228, 153));


        scroller = new JScrollPane(receipt);
        scroller.setBorder(new LineBorder(new Color(245, 156, 32), 6));
        receiptPnl.add(scroller);

    }

    private void createButtonPnl()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));
        buttonPnl.setPreferredSize(new Dimension(900, 50));

        orderbtn = new JButton("Order Now!");
        orderbtn.setBorderPainted(true);
        orderbtn.setBorder(new LineBorder(new Color(245, 12, 0), 4));
        orderbtn.addActionListener((ActionEvent ae) ->
                validInput());

        clearbtn = new JButton("Clear Order");
        clearbtn.setBorderPainted(true);
        clearbtn.setBorder(new LineBorder(new Color(245, 12, 0), 4));
        clearbtn.addActionListener((ActionEvent ae) -> clearBoard());

        quitbtn = new JButton("Quit");
        quitbtn.setBorderPainted(true);
        quitbtn.setBorder(new LineBorder(new Color(245, 12, 0), 4));
        quitbtn.addActionListener((ActionEvent ae) -> quitProgram());

        buttonPnl.add(orderbtn);

        buttonPnl.add(clearbtn);

        buttonPnl.add(quitbtn);
    }

    private void makeReceipt() //makes the layout of the receipt and prints to JTextarea
    {
        beforeCalcTotal();
        plusTax();

        receipt.append("\n=======================================");

        receipt.append(String.format("\n%-10s%8s%36.2f", sizeSelect.getSelectedItem(),getJButton(), sizePrice));

        receipt.append("\n");

        if(pepBox.isSelected())
        {
            receipt.append("\nPepperoni"+ String.format("%51s", "1.00"));
        }
        if(mushroomBox.isSelected())
        {

            receipt.append("\nMushrooms"+ String.format("%49s", "1.00"));
        }
        if(pineappleBox.isSelected())
        {
            receipt.append("\nPineapple"+ String.format("%51s", "1.00"));
        }
        if(hamBox.isSelected())
        {
            receipt.append("\nHam"+ String.format("%60s", "1.00"));
        }
        if(oliveBox.isSelected())
        {
            receipt.append("\nOlives"+ String.format("%57s", "1.00"));
        }
        if(pepperBox.isSelected())
        {
            receipt.append("\nPeppers"+ String.format("%54s", "1.00"));
        }

        receipt.append("\n");
        receipt.append("\n");

        receipt.append("\n"+ String.format("%-25s%37.2f", "Sub Total: ", beforeTax));
        receipt.append("\n"+ String.format("%-25s%40.2f", "Tax: ", taxTotal));
        receipt.append("\n------------------------------------------------------------------------");
        receipt.append("\n"+ String.format("%-25s%40.2f", "Total: ", finalTotal));
        receipt.append("\n=======================================");

    }

    private String getJButton()
    {
        crustSelected = false; //to see if the user has selected a crust

        if (thinCrust.isSelected())
        {
            crustSelected = true;

            return "Thin";
        }

        if (regularCrust.isSelected())
        {
            crustSelected = true;

            return "Regular";
        }

        if (deepDishCrust.isSelected())
        {
            crustSelected = true;

            return "Deep Dish";
        }

        if (GFCrust.isSelected())
        {
            crustSelected = true;

            return "Gluten Free";
        }

        crustSelected = false;
        return "n/a";
    }

    private void beforeCalcTotal() //gets before tax total
    {
        toppingsTotal= 0;

        if(pepBox.isSelected())
        {
            toppingsTotal++;
        }

        if(oliveBox.isSelected())
        {
            toppingsTotal++;
        }

        if(mushroomBox.isSelected())
        {
            toppingsTotal++;
        }

        if(pineappleBox.isSelected())
        {
            toppingsTotal++;
        }

        if(hamBox.isSelected())
        {
            toppingsTotal++;
        }

        if(pepperBox.isSelected())
        {
            toppingsTotal++;
        }


        //gets price based on size
        if(sizeSelect.getSelectedItem()=="Small")
        {
            sizePrice = 8.00;
        }

        if(sizeSelect.getSelectedItem()=="Medium")
        {
            sizePrice = 12.00;
        }

        if(sizeSelect.getSelectedItem()=="Large")
        {
            sizePrice = 16.00;
        }

        if(sizeSelect.getSelectedItem()=="Super")
        {
            sizePrice = 20.00;
        }


        beforeTax = sizePrice + toppingsTotal;

    }

    private void validInput()// checks to see if the user has selected a crust, size, and ingredient
    {
        getJButton(); //checks to see if crust is selected
        beforeCalcTotal();//checks for sizePrice and toppingsTotal

        if(crustSelected==true && sizePrice > 0 && toppingsTotal > 0)
        {
            makeReceipt();// makes the receipt
        }

        else
        {
            JOptionPane.showMessageDialog(null,"Please Select a Size, Crust, and Topping");
        }
    }

    private void plusTax() //calculates the tax on the order
    {
        beforeCalcTotal(); //gets the sub-total

        taxTotal = beforeTax * 0.07;
        finalTotal = taxTotal + beforeTax;
    }

    private void quitProgram()//checks to see if the user want to quit the program
    {
        reply=JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");

        if (reply == JOptionPane.YES_OPTION) //exits form
        {
            System.exit(0);
        }

    }

    private void clearBoard()// clears the form
    {
        //clears sizeSelect
        sizeSelect.setSelectedIndex(0);

        //clears crust

        thinCrust.setSelected(false);
        regularCrust.setSelected(false);
        deepDishCrust.setSelected(false);
        GFCrust.setSelected(false);
        invisibleButton.setSelected(true);

        //clears toppings
        pepBox.setSelected(false);
        oliveBox.setSelected(false);
        pepperBox.setSelected(false);
        pineappleBox.setSelected(false);
        hamBox.setSelected(false);
        mushroomBox.setSelected(false);

        //clear JTextArea
        receipt.selectAll();
        receipt.replaceSelection("");

        beforeTax = 0;
        toppingsTotal = 0;
        sizePrice = 0;
        crustSelected = false;


    }




}