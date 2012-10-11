package com.dinesh.piloting.struts.util;

public class MyString {

	public MyString() {
    }

    public static boolean checkParameter(String para) {
        int flag = 0;
        flag += para.indexOf("'") + 1;
        flag += para.indexOf(";") + 1;
        flag += para.indexOf("1=1") + 1;
        flag += para.indexOf("|") + 1;
        flag += para.indexOf("<") + 1;
        flag += para.indexOf(">") + 1;
        if (flag != 0) {
            return false;
        }
        return true;
    }

}
