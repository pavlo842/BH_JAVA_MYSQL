package rights_db.organizations;

import java.util.Date;

public class Organizations {
    private int org_id;
    private String name_org;
    private int utn;
    private Date start_date;

    public Organizations(int org_id, String name_org, int utn, Date start_date) {
        this.org_id = org_id;
        this.name_org = name_org;
        this.utn = utn;
        this.start_date = start_date;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getName_org() {
        return name_org;
    }

    public void setName_org(String name_org) {
        this.name_org = name_org;
    }

    public int getUtn() {
        return utn;
    }

    public void setUtn(int utn) {
        this.utn = utn;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Organizations{" +
                "org_id = " + org_id +
                ", name_org = '" + name_org + '\'' +
                ", utn = " + utn +
                ", start_date = " + start_date +
                '}';
    }
}
