package rights_db.rights;

import java.util.Date;

public class Rights {
    private int right_id;
    private String right_type;
    private Date start_date;
    private Date end_date;

    public int getRight_id() {
        return right_id;
    }

    public void setRight_id(int right_id) {
        this.right_id = right_id;
    }

    public String getRight_type() {
        return right_type;
    }

    public void setRight_type(String right_type) {
        this.right_type = right_type;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Rights{" +
                "right_id=" + right_id +
                ", right_type='" + right_type + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
