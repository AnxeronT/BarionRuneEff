package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launcher extends Application{
	final FontWeight normal = FontWeight.NORMAL;
	
	Values values = new Values();
	
	double eff;
	double tEff;

	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Barion's Rune Efficiency Calculator");
		
		//Gridding
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		
		//Beginning
		final Text scenetitle = new Text("Barion's Rune Efficiency Calculator");
		scenetitle.setFont(Font.font("Tahoma", normal, 20));
		
		//Rune -- Level
		final Label runeLevel = new Label("Rune Level: ");
		values.setFont(runeLevel);
		final ComboBox runeLevelBox = new ComboBox();
        runeLevelBox.getItems().addAll(
            "6",
            "5",
            "4",
            "3",
            "2",
            "1"
        );
        
        //Primary stat -- Type
        final Label primaryRT = new Label("Primary Rune Type");
        values.setFont(primaryRT);

        //Primary stat -- Value
        //final Label primaryRTTextLabel = new Label("Stat Value");
        //values.setFont(primaryRTTextLabel);
        //ComboBox primaryRTValueBox = new ComboBox();
        //createValueBox(primaryRTValueBox, 40);
        
        //Prefix Stat Label -- Stat Type
        final Label prefixRT = new Label("Prefix Rune Type");
        values.setFont(prefixRT);
        //Prefix Stat ComboBox -- StatType
        final ComboBox prefixRTBox = new ComboBox();
        prefixRTBox.getItems().addAll(
            "HP%",
            "DEF%",
            "ACC%",
            "RES%",
            "ATK%",
            "CD",
            "CR",
            "SPD"
        );
        //Prefix Stat Label -- Stat Value
        final Label prefixRTValueLabel = new Label("Stat Value");
        values.setFont(prefixRTValueLabel);
        //Prefix Stat ComboBox -- Stat Value
        ComboBox prefixRTValueBox = new ComboBox();
        createValueBox(prefixRTValueBox, 8);
        
        //Labels for the Secondary Stats
        Label[] RTBoxLabel;
        RTBoxLabel = new Label[4];
        for (int i=0;i < RTBoxLabel.length;i++){
        	RTBoxLabel[i] = new Label();
        	RTBoxLabel[i].setText((i+1)+ " Rune Type");
        	values.setFont(RTBoxLabel[i]);
        	if (i>=2){
        		grid.add(RTBoxLabel[i],3,(3+(i*2)),1,1);
        	}else{
        		grid.add(RTBoxLabel[i],0,(7+(i*2)),1,1);
        	}
        }
        
        //Combo Box for Secondary Stats
        ComboBox[] RTBox;
        RTBox = new ComboBox[4];
        for (int i=0; i< RTBox.length;i++){
        	RTBox[i] = new ComboBox();
        	RTBox[i].getItems().addAll(
                    "HP%",
                    "DEF%",
                    "ACC%",
                    "RES%",
                    "ATK%",
                    "CD",
                    "CR",
                    "SPD"
                );
        	if (i>=2){
        		grid.add(RTBox[i],4,(3+(i*2)),1,1);
        	}else{
        		grid.add(RTBox[i],1,(7+(i*2)),1,1);
        	}
        }
        
        //Label for "Stat Value"
        Label[] RTValueLabel;
        RTValueLabel = new Label[4];
        for (int i=0;i < RTValueLabel.length;i++){
        	RTValueLabel[i] = new Label();
        	RTValueLabel[i].setText("Stat Value");
        	values.setFont(RTValueLabel[i]); 
        	if (i>=2){
        		grid.add(RTValueLabel[i],3,(4+(i*2)),1,1);
        	}else{
        		grid.add(RTValueLabel[i],0,(8+(i*2)),1,1);
        	}
        }
        //Combo Box for Stat Value
        ComboBox[] RTValueBox;
        RTValueBox = new ComboBox[4];
        for (int i=0; i< RTValueBox.length;i++){
        	RTValueBox[i] = new ComboBox();
        	createValueBox(RTValueBox[i], 40);
        	RTValueBox[i].setMaxWidth(2);
        	if (i>=2){
        		grid.add(RTValueBox[i],4,(4+(i*2)),1,1);
        	}else{
        		grid.add(RTValueBox[i],1,(8+(i*2)),1,1);
        	}
        }
        //Final Label for the Calculation Result
        Label result = new Label("DAMNMIT ");
        values.setFont(result);
        
        //VBox -- Experimental, totally useless I guess.
        Button calculate = new Button("Calculate");
        VBox calulateButton = new VBox();
        calulateButton.setSpacing(10.0);
        calulateButton.setAlignment(Pos.BOTTOM_CENTER);
        calulateButton.getChildren().addAll(calculate,result);
        grid.add(calulateButton,0,13,5,3);
        
        //Add all Stuffs to here
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(runeLevel, 0,1);
        grid.add(runeLevelBox, 1, 1);
        //grid.add(primaryRT, 0,2);
        //grid.add(primaryRTBox,1,2);
        //grid.add(primaryRTTextLabel,0,3);
        //grid.add(primaryRTValueBox,1,3,1,1);
        
        grid.add(prefixRT,0,2);
        grid.add(prefixRTBox,1,2);
        grid.add(prefixRTValueLabel,0,3,1,1);
        grid.add(prefixRTValueBox,1,3,1,1);

        runeLevelBox.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
    		public void handle(ActionEvent e){
        		System.out.println(runeLevelBox.getValue());
    			//primaryRTValueBox.createValueBox(maxValue.getValue(actionPressed), value);
    		}
        });
        
        calculate.setOnAction(new EventHandler<ActionEvent>(){
        	
        	@Override
        	public void handle(ActionEvent e){
        		int[] error = {0,0};
        		// error[0] == 1 MEANS VALUE NOT SET
        		// error[1] == 
        		eff = 0;
        		//eff += values.runeEff(primaryRTBox,primaryRTValueBox);
        		eff += values.runeEff(prefixRTBox,prefixRTValueBox);
        		if (eff >= 100){
    				result.setText("ERROR : ONE OF THE VALUE NOT SET");
        		}else{
            		for (int i = 0;i < RTValueBox.length;i++){
            			eff += values.runeEff(RTBox[i],RTValueBox[i]);
            			if (eff >= 100 ){
            				System.out.println("ERROR : VALUE NOT SET");
            				result.setText("ERROR : ONE OF THE VALUE NOT SET");
            				error[0] = 1;
            				break;
            			}else{
            				System.out.println("eff : " + eff);
            			}
            		}
            		
            		if (error[0] == 1){
            			System.out.println("Error found -- Not proceeding result printing ");
            		}else{
            			if(runeLevelBox.getValue() == null){
            				System.out.println("ERROR : RUNE LEVEL NOT SET");
            				result.setText("Ya know you gotta set Rune Level right?");
            			}else{
            				tEff = Math.floor((((eff+values.runeLevel(runeLevelBox))/2.8)*100));
            				System.out.println(tEff);
                    		result.setText("Efficiency : " + tEff + "%" );
            			}
            			
            		}
            		
        		}
        		

        		//((TotalEff+runeLevel)/2.8)*100
        	}
        });
		//grid as root node
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void createValueBox(ComboBox<Integer> cb, int max){
		
		for (int i=1;i<=40;i++){
			cb.getItems().removeAll(i);
		}
		for (int i=1;i<=max;i++){
			cb.getItems().add(max+1-i);
		}
	}

}