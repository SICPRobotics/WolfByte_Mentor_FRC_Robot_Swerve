package frc.robot.robotutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.SmartDashBoardClass;
import frc.robot.Constants;

/*
 * display status of motors and CAN signal from here
 */

public class StatusCheck {
    // add a name for each motor in constatnts

    //Talonfx
    Map<String, Integer> motorIDList = new HashMap<>();
    ArrayList<String> keyList = new ArrayList<String>();
    ArrayList<Integer> idList = new ArrayList<Integer>();
    ArrayList<TalonFX> motors = new ArrayList<TalonFX>();

    // NEED TO FIX  - DFlowers 1/19/24
    //ArrayList<SmartDashBoardClass<Boolean>> smartDashBoardClasses = new ArrayList<SmartDashBoardClass<Boolean>>();

    public void StatusCheck(){
    }

    public void getConstants(){

        // NEED TO FIX  - DFlowers 1/19/24
        //motorIDList.putAll(Constants.getComponentIDList());
        
        keyList.addAll(motorIDList.keySet());
        idList.addAll(motorIDList.values());
        for(int i = 0; i < idList.size(); i ++){
            motors.add(new TalonFX(idList.get(i)));
        }
    }

    public void update(){
        checkPowerList();
        checkCanList();
    }

    public void checkPowerList(){
        for (int i = 0; i < keyList.size(); i ++){
            if(checkPower(motors.get(i)) == true){
                
                // NEED TO FIX  - DFlowers 1/19/24
                // SmartDashboard.putBoolean(keyList.get(i) + " ID:" + motorIDList.get(keyList.get(i)), true);
            }
            else{
                // NEED TO FIX  - DFlowers 1/19/24
                // SmartDashboard.putBoolean(keyList.get(i) + " ID:" + motorIDList.get(keyList.get(i)), false);
            }
        }
    }

    public boolean checkPower(TalonFX checkingFalcon){
        if(checkingFalcon.getMotorVoltage().getValueAsDouble() == 0){
            return false;
        }
        return true;
    }

    public void checkCanList(){
        
    }

    public boolean checkCan(){
        //check to see if can frames are being received
        return true;
    }
}

//       autoDelay = new SmartDashBoardClass<Double>("autoDelay", 0.0);
