package model.aws;

import java.io.Serializable;

public class ELBStateChangeNotification implements Serializable{
    private static final long serialVersionUID = 1L;

    private String elbArn ;

    private String elbListenArn ;
    
    private String masterTargetGroupArn ;

    private int masterTargetGroupNewWeith = 100;

    private String slaveTargetGroupArn ;

    private int slaveTargetGroupNewWeith = 0;

    public String getElbListenArn() {
        return elbListenArn;
    }

    public void setElbListenArn(String elbListenArn) {
        this.elbListenArn = elbListenArn;
    }

    public String getElbArn() {
        return elbArn;
    }

    public String getMasterTargetGroupArn() {
        return masterTargetGroupArn;
    }

    public int getMasterTargetGroupNewWeith() {
        return masterTargetGroupNewWeith;
    }

    public String getSlaveTargetGroupArn() {
        return slaveTargetGroupArn;
    }

    public int getSlaveTargetGroupNewWeith() {
        return slaveTargetGroupNewWeith;
    }

    public void setElbArn(String elbArn) {
        this.elbArn = elbArn;
    }

    public void setMasterTargetGroupArn(String masterTargetGroupArn) {
        this.masterTargetGroupArn = masterTargetGroupArn;
    }

    public void setMasterTargetGroupNewWeith(int masterTargetGroupNewWeith) {
        this.masterTargetGroupNewWeith = masterTargetGroupNewWeith;
    }

    public void setSlaveTargetGroupArn(String slaveTargetGroupArn) {
        this.slaveTargetGroupArn = slaveTargetGroupArn;
    }

    public void setSlaveTargetGroupNewWeith(int slaveTargetGroupNewWeith) {
        this.slaveTargetGroupNewWeith = slaveTargetGroupNewWeith;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EC2InstanceStateChangeNotification {\n");

        sb.append("    elbListenArn: ").append(toIndentedString(elbListenArn)).append("\n");
        sb.append("    masterTargetGroupArn: ").append(toIndentedString(masterTargetGroupArn)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}