/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sukarna.db.DataAccess;
import sukarna.models.CartItem;

/**
 *
 * @author samsung
 */
public class appointment extends HttpServlet {

    int s,j;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String dname = (String) request.getParameter("dname");
        String pname = (String) request.getParameter("pname");
        String date = (String) session.getAttribute("date");
        System.out.println(dname+ "POP"+ pname +"kop ");
        if(dname==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("Appoints.jsp");
            rd.forward(request, response);
        }
        String query = "SELECT COUNT(*) FROM EMPLOYEES WHERE DEPARTMENT_ID= ?";
        String query1= "Select  DEPARTMENT_ID FROM EMPLOYEES where FIRST_NAME = ?";
        String query2= "Select  Employee_ID FROM EMPLOYEES where FIRST_NAME = ?";


        DataAccess db = new DataAccess();
        PreparedStatement stmt = null;
        try {
            stmt = db.conn.prepareStatement(query1);
            stmt.setString(1,dname );
            ResultSet rs = stmt.executeQuery();
            //int did= rs.getInt(1);
            while(rs.next()){
            stmt = db.conn.prepareStatement(query);
            s= rs.getInt(1);
            System.out.println(s);
            String a= ""+s;
                stmt.setString(1,a);
                rs=stmt.executeQuery();
                j=0;
                while (rs.next()){
                 j= rs.getInt(1);
                System.out.println(j);
                    break;}
                if(j>7){
                    RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                    rd.forward(request, response);
                }
                else{
                    String q= "INSERT into STUDENT VALUES ('muri',s,'m','muri',3.5 )";
                    stmt = db.conn.prepareStatement(q);
                    s=s+50;
                    String k= ""+s;
                    String m= ""+j;
                    //stmt.setString(1,k);
                    //stmt.setString(2,m);
                    //stmt.setString(3,m);
                    rs= stmt.executeQuery();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        //String product = request.getParameter("product");
        //String amount = request.getParameter("amount");
        //



        RequestDispatcher rd = request.getRequestDispatcher("done.jsp");
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("post");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}