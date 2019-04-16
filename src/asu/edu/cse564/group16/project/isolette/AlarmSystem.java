/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project Isolette
 */


package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Switch;

public class AlarmSystem {


    private Switch alarmSwtich;

    public Switch getAlarmSwtich() {
        return alarmSwtich;
    }

    public void setAlarmSwtich(Switch alarmSwtich) {
        this.alarmSwtich = alarmSwtich;
    }

    public AlarmSystem(Switch alarmSwtich) {
        this.alarmSwtich = alarmSwtich;
    }

    public void switchOnAlarm(){
       setAlarmSwtich(Switch.ON);
    }

    public void switchOffAlarm(){
        setAlarmSwtich(Switch.OFF);
    }


}
