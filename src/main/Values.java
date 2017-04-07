package main;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Values {
	final FontWeight normal = FontWeight.NORMAL;
	
	public void setFont(Label lb){
		lb.setFont(Font.font("Lato",normal, 16));
	}
	
	public double getMaxStat(ComboBox cb){
		double maxStat = 0;
		String type = new String();
		type = (String) cb.getValue();

			switch(type){
			case "HP%":
				maxStat = 40;
				break;
			case "DEF%":
				maxStat = 40;
				break;
			case "ACC%":
				maxStat = 40;
				break;
			case "ATK%":
				maxStat = 40;
				break;
			case "RES%":
				maxStat = 40;
				break;
			case "CD":
				maxStat = 35;
				break;
			case "CR":
				maxStat = 30;
				break;
			case "SPD":
				maxStat = 30;
				break;
			default:
				maxStat = 30;
				break;
			}
		
		System.out.println(maxStat);
		return maxStat;
	}
	
	public double runeLevel(ComboBox cb){
		//Returns multiplier number
		double statMain;
		switch((String)cb.getValue()){
			case "1":
				//NOT ACTUAL NUMBER
				statMain = 0.3;
				break;
			case "2":
				//NOT ACTUAL NUMBER
				statMain = 0.45;
				break;
			case "3":
				//NOT ACTUAL NUMBER
				statMain = 0.60;
				break;
			case "4":
				//NOT ACTUAL NUMBER
				statMain = 0.75;
				break;
			case "5":
				statMain = 0.85;
				break;
			case "6":
				statMain = 1;
				break;
			default:
				statMain = 0;
				break;
		}
		return statMain;
	}
	
	public double runeEff(ComboBox cbType, ComboBox<Integer> cbValue){
		double effN;
		if (cbValue.getValue() == null){
			System.out.println("ERROR : VALUE NOT SET");
			cbValue.setValue(1);
			return 100;
		}else{
			System.out.println("value : " + cbValue.getValue());
			//System.out.println("max stat :" +getMaxStat(cbType));
			if (cbType.getValue() == null){
				System.out.println("ERROR : STAT TYPE NOT SET, DEFAULTING TO HP%");
				cbType.setValue("HP%");
				return 100;
			}else{
				effN = cbValue.getValue()/getMaxStat(cbType);
				System.out.println("effN : " + effN);
				return effN;
			}
		}
	}
	
}
