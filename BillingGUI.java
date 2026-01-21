import javax.swing.*;
import java.awt.event.*;

public class BillingGUI extends JFrame implements ActionListener {
    

    JTextField txtOrder, txtCustomer, txtPhone, txtAddress;
    JTextField txtInvoiceNo, txtInvoiceDate, txtCashier;
    JTextArea txtItems;
    JTextField txtTotal, txtCash, txtChange;

    JButton btnCalculate, btnClear, btnExit;

    public BillingGUI() {

        setTitle("Billing System");
        setSize(800, 550);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Receipt Header
        JLabel title = new JLabel("CASH RECEIPT", JLabel.CENTER);
        title.setBounds(250, 10, 300, 30);
        add(title);

        JLabel shop = new JLabel("SUPERMARKET 123", JLabel.CENTER);
        shop.setBounds(250, 35, 300, 20);
        add(shop);

        JLabel addr = new JLabel("12, Milkyway Galaxy / Earth", JLabel.CENTER);
        addr.setBounds(250, 55, 300, 20);
        add(addr);

        JLabel tel = new JLabel("Tel : 123-456-7898", JLabel.CENTER);
        tel.setBounds(250, 75, 300, 20);
        add(tel);

        // Left side
        addLabel("Order ID", 40, 120);       txtOrder = addField(160, 120);
        addLabel("Customer Name", 40, 150);  txtCustomer = addField(160, 150);
        addLabel("Phone No", 40, 180);       txtPhone = addField(160, 180);
        addLabel("Address", 40, 210);        txtAddress = addField(160, 210);
        addLabel("Invoice No", 40, 240);     txtInvoiceNo = addField(160, 240);
        addLabel("Invoice Date", 40, 270);   txtInvoiceDate = addField(160, 270);
        addLabel("Cashier Name", 40, 300);   txtCashier = addField(160, 300);
       
         // Right side
        txtItems = new JTextArea();
        txtItems.setBounds(400, 120, 340, 200);
        txtItems.setText("Item               Qty                 Price");
        add(txtItems);

        addLabel("Total Amount", 400, 340);  txtTotal = addField(520, 340); 
        addLabel("Cash Given", 400, 370);    txtCash = addField(520, 370);
        addLabel("Change Amount", 400, 400); txtChange = addField(520, 400);

        // Buttons
        btnCalculate = new JButton("CALCULATE");
        btnCalculate.setBounds(200, 450, 120, 30);
        btnCalculate.addActionListener(this);
        add(btnCalculate);

        btnClear = new JButton("CLEAR");
        btnClear.setBounds(340, 450, 100, 30);
        btnClear.addActionListener(this);
        add(btnClear);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(460, 450, 100, 30);
        btnExit.addActionListener(this);
        add(btnExit);
    }
   
    void addLabel(String t, int x, int y) {
        JLabel l = new JLabel(t + " :");
        l.setBounds(x, y, 120, 25);
        add(l);
    }

    JTextField addField(int x, int y) {
        JTextField f = new JTextField();
        f.setBounds(x, y, 180, 25);
        add(f);
        return f;
    }

  public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCalculate) {
            double total = Double.parseDouble(txtTotal.getText());
            double cash = Double.parseDouble(txtCash.getText());
            txtChange.setText(String.valueOf(cash - total));
        }

        if (e.getSource() == btnClear) {
            txtItems.setText("Item               Qty                 Price");
            txtTotal.setText("");
            txtCash.setText("");
            txtChange.setText("");
        }

        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}