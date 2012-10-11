package com.dinesh.piloting.struts.bean;


import java.sql.*;
import java.util.*;

import com.dinesh.piloting.struts.util.MyDate;
import com.dinesh.piloting.struts.util.MyString;

public class DataBean {
    private Connection conn = null;

    private ResultSet res = null;

    private java.sql.PreparedStatement prepar = null;

    private java.sql.CallableStatement proc = null;

    public int pagecount = 0;
    public DataBean() { 
        try {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager
                   .getConnection(
                           "jdbc:odbc:CustomeDSN");
            System.out.println("connected");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() );
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage() );
        }

    }

    public void Close() { 
        try {
            if (res != null) {
                res.close();
            }
            if (prepar != null) {
                prepar.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("closed");
    }

    public boolean checkAdminLogin(AdminBean ab) { 

        boolean result = false;
        if (!MyString.checkParameter(ab.getAdmin_Name()
                                     + ab.getAdmin_Pwd())) {
            return result;
        }
        try {
            String sql =
                    "select count(*) from Admin where Admin_Name=? and Admin_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ab.getAdmin_Name());
            prepar.setString(2, ab.getAdmin_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                if (res.getInt(1) > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public AdminBean getAdminBean(AdminBean ab) { 
        AdminBean admin = null;
        try {
            String sql =
                    "select * from Admin where Admin_Name=? and Admin_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ab.getAdmin_Name());
            prepar.setString(2, ab.getAdmin_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                admin = new AdminBean();
                admin.setAdmin_Id(res.getInt("Admin_Id"));
                admin.setAdmin_Name(res.getString("Admin_Name"));
                admin.setAdmin_Pwd(res.getString("Admin_Pwd"));
                admin.setAdmin_Flag(res.getString("Admin_Flag"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    public boolean checkUserLogin(UserBean ub) {

        boolean result = false;
        if (!MyString.checkParameter(ub.getUsers_Name()
                                     + ub.getUsers_Pwd())) {
            return result;
        }
        try {
            String sql =
                    "select count(*) from Users where Users_Name=? and Users_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                if (res.getInt(1) > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public UserBean getUserBean(UserBean ub) {
        UserBean user = null;
        try {
            String sql =
                    "select * from Users where Users_Name=? and Users_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                user = new UserBean();
                user.setUsers_Id(res.getInt("Users_Id"));
                user.setUsers_Name(res.getString("Users_Name"));
                user.setUsers_Pwd(res.getString("Users_Pwd"));
                user.setUsers_Adds(res.getString("Users_Adds"));
                user.setUsers_Dept(res.getString("Users_Dept"));
                user.setUsers_Count(res.getInt("Users_Count"));
                user.setUsers_Phone(res.getString("Users_Phone"));
                user.setUsers_Gender(res.getString("Users_Gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public UserBean getUserBean(int users_Id) {
        UserBean user = null;
        try {
            String sql =
                    "select * from Users where Users_Id=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, users_Id);
            res = prepar.executeQuery();
            if (res.next()) {
                user = new UserBean();
                user.setUsers_Id(res.getInt("Users_Id"));
                user.setUsers_Name(res.getString("Users_Name"));
                user.setUsers_Pwd(res.getString("Users_Pwd"));
                user.setUsers_Adds(res.getString("Users_Adds"));
                user.setUsers_Dept(res.getString("Users_Dept"));
                user.setUsers_Count(res.getInt("Users_Count"));
                user.setUsers_Phone(res.getString("Users_Phone"));
                user.setUsers_Gender(res.getString("users_Gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public boolean regUser(UserBean ub) {
        try {
            prepar = conn.prepareStatement(
                    "insert into Users (Users_Name,Users_Pwd,Users_Dept,Users_Gender,Users_Count,Users_Phone,Users_Adds) values(?,?,?,?,?,?,?)");
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            prepar.setString(3, ub.getUsers_Dept());
            prepar.setString(4, ub.getUsers_Gender());
            prepar.setInt(5, ub.getUsers_Count());
            prepar.setString(6, ub.getUsers_Phone());
            prepar.setString(7, ub.getUsers_Adds());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean isHasName(String userName) {
        try {
            prepar = conn.prepareStatement(
                    "select count(*) from Users where Users_Name = ?");
            prepar.setString(1, userName);
            res = prepar.executeQuery();
            res.next();
            if (res.getInt(1) != 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            this.Close();
        }
        return true;
    }

    public static boolean HasName(String userName) {

        return new DataBean().isHasName(userName);
    }

    public boolean updateUserInfo(UserBean ub) {
        try {
            prepar = conn.prepareStatement(
                    "update Users set Users_Name=?,Users_Pwd=?,Users_Dept=?,Users_Gender=?,Users_Phone=?,Users_Adds=? where Users_Id=?");
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            prepar.setString(3, ub.getUsers_Dept());
            prepar.setString(4, ub.getUsers_Gender());
            prepar.setString(5, ub.getUsers_Phone());
            prepar.setString(6, ub.getUsers_Adds());
            prepar.setInt(7, ub.getUsers_Id());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }
    public ArrayList<LendBean> getUsersLendList(int users_Id) {
        ArrayList<LendBean> list = new ArrayList<LendBean>();
        try {
            String sql =
                    "select * from BookLend where Users_Id=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, users_Id);
            res = prepar.executeQuery();
            while (res.next()) {
                LendBean lb = new LendBean();
                lb.setBookLend_Id(res.getInt("BookLend_Id"));
                lb.setBooks_Id(res.getInt("Books_Id"));
                lb.setBookLend_StarTime(res.getString("BookLend_StarTime"));
                lb.setBookLend_EndTime(res.getString("BookLend_EndTime"));
                lb.setUsers_Id(res.getInt("Users_Id"));
                list.add(lb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public ArrayList<UserBean> getUsersList(int count, int page) {
        ArrayList<UserBean> list = new ArrayList<UserBean>();
        try {
            proc = conn.prepareCall("{call UsersPage (?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.registerOutParameter(3, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                UserBean ub = new UserBean();
                ub.setUsers_Id(res.getInt(1));
                ub.setUsers_Name(res.getString(2));
                ub.setUsers_Pwd(res.getString(3));
                ub.setUsers_Dept(res.getString(4));
                ub.setUsers_Gender(res.getString(5));
                ub.setUsers_Count(res.getInt(6));
                ub.setUsers_Phone(res.getString(7));
                ub.setUsers_Adds(res.getString(8));
                list.add(ub);
            }
            pagecount = proc.getInt(3);
        } catch (SQLException ex) {
            System.out.println("exception in getUsersList()");
            ex.printStackTrace();
        }
        return list;
    }

    public boolean deleteUsers(int users_Id) {
        try {
            prepar = conn.prepareStatement(
                    "delete Users where Users_Id=?");
            prepar.setInt(1, users_Id);
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<BooksTypeBean> getBooksType() {
        ArrayList<BooksTypeBean> list = new ArrayList<BooksTypeBean>();
        try {
            String sql =
                    "select * from BookType";
            prepar = conn.prepareStatement(sql);
            res = prepar.executeQuery();
            while (res.next()) {
                BooksTypeBean btb = new BooksTypeBean();
                btb.setBookType_Id(res.getInt(1));
                btb.setBookType_Name(res.getString(2));
                list.add(btb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<BooksBean> getBooksList(int count, int page, String sqlstr) {
        ArrayList<BooksBean> list = new ArrayList<BooksBean>();
        try {
        	String mainsql = "select * from Books ";
            
            if(sqlstr!=null && !sqlstr.equals("")){
            	mainsql = mainsql.concat(sqlstr);
            }
        	prepar = conn.prepareStatement(mainsql);
            res = prepar.executeQuery();
            while (res.next()) {
                BooksBean bsb = new BooksBean();
                bsb.setBooks_Amount(res.getInt("Books_Amount"));
                bsb.setBooks_Company(res.getString("Books_Company"));
                bsb.setBooks_Count(res.getInt("Books_Count"));
                bsb.setBooks_Id(res.getInt("Books_Id"));
                bsb.setBooks_Name(res.getString("Books_Name"));
                bsb.setBooks_Time(res.getString("Books_Time"));
                bsb.setBookType_Id(res.getInt("BookType_Id"));
                list.add(bsb);
            }
            
        } catch (SQLException ex) {
            System.out.println("getBooksList()");
            ex.printStackTrace();
        }
        return list;
    }

    public BooksBean getBooksBean(int books_Id) {
        BooksBean bsb = new BooksBean();
        try {
            String sql =
                    "select * from Books where Books_Id=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, books_Id);
            res = prepar.executeQuery();
            if (res.next()) {
                bsb.setBooks_Amount(res.getInt("Books_Amount"));
                bsb.setBooks_Company(res.getString("Books_Company"));
                bsb.setBooks_Count(res.getInt("Books_Count"));
                bsb.setBooks_Id(res.getInt("Books_Id"));
                bsb.setBooks_Name(res.getString("Books_Name"));
                bsb.setBooks_Time(res.getString("Books_Time"));
                bsb.setBookType_Id(res.getInt("BookType_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bsb;
    }

    public String lendBooks(LendBean lb) {
        try {
            proc = conn.prepareCall("{call LendBook (?,?,?,?,?)}");
            proc.setInt(1, lb.getUsers_Id());
            proc.setInt(2, lb.getBooks_Id());
            proc.setString(3, lb.getBookLend_StarTime());
            proc.setString(4, lb.getBookLend_EndTime());
            proc.registerOutParameter(5, Types.VARCHAR);
            proc.executeUpdate();
            return proc.getString(5);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "success";
    }

    public int getDateCha(String stra, String end) {
        try {
            String sql =
                    "select datediff(day,?,?)";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, stra);
            prepar.setString(2, end);
            res = prepar.executeQuery();
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean insertBooks(BooksBean bsb) {
        try {
            prepar = conn.prepareStatement(
                    "insert into Books (Books_Name,Books_Company,Books_Time,BookType_Id) values(?,?,?,?)");
            prepar.setString(1, bsb.getBooks_Name());
            prepar.setString(2, bsb.getBooks_Company());
            prepar.setString(3, MyDate.getDate());
            prepar.setInt(4, bsb.getBookType_Id());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteBooks(int books_Id) {
        try {
            prepar = conn.prepareStatement(
                    "delete Books where Books_Id=?");
            prepar.setInt(1, books_Id);
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean updateBooks(BooksBean bsb) {
        try {
            prepar = conn.prepareStatement(
                    "update Books set Books_Name=?,Books_Company=?,Books_Count=?,BookType_Id=? where Books_Id=?");
            prepar.setString(1, bsb.getBooks_Name());
            prepar.setString(2, bsb.getBooks_Company());
            prepar.setInt(3, bsb.getBooks_Count());
            prepar.setInt(4, bsb.getBookType_Id());
            prepar.setInt(5, bsb.getBooks_Id());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public String giveBook(LendBean lb) {
        try {
            proc = conn.prepareCall("{call GiveBook (?,?,?,?,?,?)}");
            proc.setInt(1, lb.getUsers_Id());
            proc.setInt(2, lb.getBooks_Id());
            proc.setString(3, lb.getBookLend_StarTime());
            proc.setString(4, lb.getBookLend_EndTime());
            proc.setString(5, MyDate.getDate());
            proc.registerOutParameter(6, Types.VARCHAR);
            proc.executeUpdate();
            return proc.getString(6);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public LendBean getLendBean(int lend_Id) {
        LendBean lb = new LendBean();
        try {
            String sql =
                    "select * from BookLend where BookLend_Id=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, lend_Id);
            res = prepar.executeQuery();
            if (res.next()) {
                lb.setBookLend_Id(res.getInt(1));
                lb.setUsers_Id(res.getInt(2));
                lb.setBooks_Id(res.getInt(3));
                lb.setBookLend_StarTime(res.getString(4));
                lb.setBookLend_EndTime(res.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lb;
    }

    public LendBean getLendBean(int users_Id, int books_Id) {
        LendBean lb = new LendBean();
        try {
            String sql =
                    "select * from BookLend where Users_Id=? and Books_Id=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, users_Id);
            prepar.setInt(2, books_Id);
            res = prepar.executeQuery();
            if (res.next()) {
                lb.setBookLend_Id(res.getInt(1));
                lb.setUsers_Id(res.getInt(2));
                lb.setBooks_Id(res.getInt(3));
                lb.setBookLend_StarTime(res.getString(4));
                lb.setBookLend_EndTime(res.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lb;
    }


    public ArrayList<LendBean> getLendList(int count, int page) {
        ArrayList<LendBean> list = new ArrayList<LendBean>();
        try {
            proc = conn.prepareCall("{call LendPage (?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.registerOutParameter(3, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                LendBean lb = new LendBean();
                lb.setBookLend_EndTime(res.getString("BookLend_EndTime"));
                lb.setBookLend_Id(res.getInt("BookLend_Id"));
                lb.setBookLend_StarTime(res.getString("BookLend_StarTime"));
                lb.setBooks_Id(res.getInt("Books_Id"));
                lb.setUsers_Id(res.getInt("Users_Id"));
                list.add(lb);
            }
            pagecount = proc.getInt(3);
        } catch (SQLException ex) {
            System.out.println("Exception in getLendList()");
            ex.printStackTrace();
        }
        return list;
    }


    public ArrayList<PunishBean> getPunishList(int count, int page) {
        ArrayList<PunishBean> list = new ArrayList<PunishBean>();
        try {
            proc = conn.prepareCall("{call PunishPageAdmin (?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.registerOutParameter(3, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                PunishBean pb = new PunishBean();
                pb.setBooks_Id(res.getInt("Books_Id"));
                pb.setPunish_Day(res.getInt("Punish_Day"));
                pb.setPunish_Id(res.getInt("Punish_Id"));
                pb.setPunish_Money(res.getInt("Punish_Money"));
                pb.setUsers_Id(res.getInt("Users_Id"));
                list.add(pb);
            }
            pagecount = proc.getInt(3);
        } catch (SQLException ex) {
            System.out.println("Exception in getPunishList()");
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<PunishBean> getUserPunishList(int count, int page, int users_Id) {
        ArrayList<PunishBean> list = new ArrayList<PunishBean>();
        try {
            proc = conn.prepareCall("{call PunishPage (?,?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.setInt(3, users_Id);
            proc.registerOutParameter(4, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                PunishBean pb = new PunishBean();
                pb.setBooks_Id(res.getInt("Books_Id"));
                pb.setPunish_Day(res.getInt("Punish_Day"));
                pb.setPunish_Id(res.getInt("Punish_Id"));
                pb.setPunish_Money(res.getInt("Punish_Money"));
                pb.setUsers_Id(res.getInt("Users_Id"));
                list.add(pb);
            }
            pagecount = proc.getInt(4);
        } catch (SQLException ex) {
            System.out.println("Exception in getPunishList()");
            ex.printStackTrace();
        }
        return list;
    }

    public boolean deletePunish(int punish_Id) {
        try {
            prepar = conn.prepareStatement(
                    "delete Punish where Punish_Id=?");
            prepar.setInt(1, punish_Id);
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
