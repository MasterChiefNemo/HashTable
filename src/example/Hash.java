package example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings({"serial", "unused", "rawtypes", "unchecked", "deprecation"})
public class Hash extends JFrame implements ActionListener{
	public JLabel keyLabel, valueLabel;
	public JTextField keyField, valueField;
	public JButton submit, clear, printValues;
	
	public Hashtable balance = new Hashtable();
    public Enumeration names;
    public String str, nameValue;
    public double bal, balanceValue;
    
    public Container container = getContentPane();
	
	public Hash(){
		super("Hash Table Implementation");
		setSize(400, 400);
		setVisible(true);
		
		addInitialKayData();
		container.setLayout(null);
		
		keyLabel = new JLabel("Key");
		container.add(keyLabel);
		keyLabel.setBounds(10, 10, 100, 25);
		
		keyField = new JTextField("");
		container.add(keyField);
		keyField.addActionListener(this);
		keyField.setBounds(110, 10, 200, 25);
		
		valueLabel = new JLabel("Value");
		container.add(valueLabel);
		valueLabel.setBounds(10, 50, 100, 25);
		
		valueField = new JTextField("");
		container.add(valueField);
		valueField.addActionListener(this);
		valueField.setBounds(110, 50, 200, 25);
		
		submit = new JButton("Submit");
		container.add(submit);
		submit.addActionListener(this);
		submit.setBounds(10, 110, 100, 25);
		
		clear = new JButton("Clear");
		container.add(clear);
		clear.addActionListener(this);
		clear.setBounds(120, 110, 100, 25);
		
		printValues = new JButton("Print Data");
		container.add(printValues);
		printValues.addActionListener(this);
		printValues.setBounds(10, 140, 100, 25);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addInitialKayData(){
		balance.put("Zara", new Double(3434.34));
		balance.put("Mahnaz", new Double(123.22));
		balance.put("Ayan", new Double(1378.00));
		balance.put("Daisy", new Double(99.22));
		balance.put("Qadir", new Double(-19.08));
	}
	
	public void addKeyValue(String nameValue, double balanceValue){
		this.nameValue = nameValue;
		this.balanceValue = balanceValue;
		balance.put(nameValue, new Double(balanceValue));
	}
	
	public void printToConsole(){
		names = balance.keys();
		while(names.hasMoreElements()){
			str = (String) names.nextElement();
			System.out.println(str + ": " + balance.get(str));
		}        
		System.out.println();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == clear){
			keyField.setText("");
			valueField.setText("");
		}
		if(e.getSource() == submit){
			addKeyValue(keyField.getText().toString(), Double.parseDouble(valueField.getText()));
		}
		if(e.getSource() == printValues){
			printToConsole();
		}
	}
	
	public static void main(String args[]){
		Hash a = new Hash();
	}
}