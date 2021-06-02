package com.ibanking.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.util.Properties;
import java.io.*;

@WebServlet(urlPatterns = { "/newAccount" })
public class NewAccountServlet extends HttpServlet {
    private String driverClassname;
    private String url;
    private String username;
    private String password;

    public void init() {
        Properties props = null;
        props = new Properties();
        try {
            props.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
            driverClassname = props.getProperty("db.driverClassname");
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException {
        int accountNo = 0;
        String accountHolderName = null;
        String accountType = null;
        float balance = 0;        
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            accountNo = Integer.parseInt(request.getParameter("accountNo"));
            accountHolderName = request.getParameter("accountHolderName");
            accountType = request.getParameter("accountType");
            balance = Float.parseFloat(request.getParameter("balance"));

            Class.forName(driverClassname);
            con = DriverManager.getConnection(url, username, password);
            pstmt = con.prepareStatement(
                    "insert into account(account_no, account_holder_nm, account_type, balance) values(?,?,?,?)");
            pstmt.setInt(1, accountNo);
            pstmt.setString(2, accountHolderName);
            pstmt.setString(3, accountType);
            pstmt.setFloat(4, balance);

            pstmt.executeUpdate();
            response.getWriter().print("account created");
        } catch (ClassNotFoundException | SQLException | NumberFormatException | IOException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (final SQLException e) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (final SQLException e) {
            }
        }
    }
}



