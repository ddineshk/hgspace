package com.dinesh.piloting.struts.bean;
public class PunishBean {
    private int punish_Id;
    private int users_Id;
    private int books_Id;
    private int punish_Day;
    private int punish_Money;
    public PunishBean() {
    }

    

    public void setUsers_Id(int users_Id) {
        this.users_Id = users_Id;
    }

    public void setBooks_Id(int books_Id) {
        this.books_Id = books_Id;
    }

    public void setPunish_Day(int punish_Day) {
        this.punish_Day = punish_Day;
    }

    public void setPunish_Money(int punish_Money) {
        this.punish_Money = punish_Money;
    }

    

    /**
	 * @return the punish_Id
	 */
	public int getPunish_Id() {
		return punish_Id;
	}



	/**
	 * @param punish_Id the punish_Id to set
	 */
	public void setPunish_Id(int punish_Id) {
		this.punish_Id = punish_Id;
	}



	public int getUsers_Id() {
        return users_Id;
    }

    public int getBooks_Id() {
        return books_Id;
    }

    public int getPunish_Day() {
        return punish_Day;
    }

    public int getPunish_Money() {
        return punish_Money;
    }
}
