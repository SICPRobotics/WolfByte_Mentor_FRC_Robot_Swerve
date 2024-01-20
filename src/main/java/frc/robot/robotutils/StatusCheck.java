package frc.robot.robotutils;

// Java Utility Libraries
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// TaloxFX Libaries
import com.ctre.phoenix6.hardware.TalonFX;

//SmartDashboard Libraries
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// Robot Constant Values
import frc.robot.Constants;

/* Author: DFlowers 1/19/24
*  Class: Status Check
*  Description: Custom class to Check Power Status of motors
*/
public class StatusCheck {

    //Talonfx
    Map<String, Integer> motorIDList = new HashMap<>();
    ArrayList<String> keyList = new ArrayList<String>();
    ArrayList<Integer> idList = new ArrayList<Integer>();
    ArrayList<TalonFX> motors = new ArrayList<TalonFX>();

     /* Author: DFlowers 1/19/24
     *  Function: getConstants
     *  Description: Function that iterates through an array list of motors
     *  Parameter: None
     *  Return: void
     */
    public void getConstants(){
 
        // Get all motor id's and put in a hash map - DFlowers 1/19/24
        motorIDList.putAll(Constants.getComponentIDList());     
        
        keyList.addAll(motorIDList.keySet());
        idList.addAll(motorIDList.values());
        for(int i = 0; i < idList.size(); i ++){
            motors.add(new TalonFX(idList.get(i)));
        }
    }

     /* Author: DFlowers 1/19/24
     *  Function: update
     *  Description: Function that iterates through an array list of motors
     *  Parameter: None
     *  Return: void
     */
    public void update(){
        checkPowerList();
    }


     /* Author: DFlowers 1/19/24
     *  Function: checkPowerList
     *  Description: Function that iterates through an array list of motors
     *  Parameter: None
     *  Return: void
     */
    public void checkPowerList(){
        for (int i = 0; i < keyList.size(); i ++){
            if(checkPower(motors.get(i)) == true){
                
                // If motor is powered on, add motor id to smart dashboard with a true flag.  - DFlowers 1/19/24
                SmartDashboard.putBoolean(keyList.get(i) + " ID:" + motorIDList.get(keyList.get(i)), true);
            }
            else{
                // If motor is powered on, add motor id to smart dashboard with a false flag.  - DFlowers 1/19/24
                SmartDashboard.putBoolean(keyList.get(i) + " ID:" + motorIDList.get(keyList.get(i)), false);
            }
        }
    }


    /*  Author: DFlowers 1/19/24
     *  Function: checkPower
     *  Description: Check Power of a specifc Falcon Motor
     *  Parameter: TaloxFX (extended from CoreTalonFX)
     *  Return: Boolean
     */
    public boolean checkPower(TalonFX checkingFalcon){

         // Returns MotorVoltage Status Signal Object and check if it is false - DFlowers 1/19/24
        if(checkingFalcon.getMotorVoltage().getValueAsDouble() == 0){
            // return false if value is 0
            return false;
        }

        // Assume the power is on and return true 
        return true;
    }

}
