package org.liuchang.bean.finance;

import java.sql.Date;

/**
 * Created by liuchang on 2016/3/31.
 */
public class Pay {
    private int id;
    private String name;
    private int money;
    private int type;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pay pay = (Pay) o;

        if (id != pay.id) return false;
        if (money != pay.money) return false;
        if (type != pay.type) return false;
        if (name != null ? !name.equals(pay.name) : pay.name != null) return false;
        if (date != null ? !date.equals(pay.date) : pay.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + money;
        result = 31 * result + type;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
