/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 *
 * @author Js'Media
 */
public class engine extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet engine</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet engine at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        String saveMessage = "";
        
        
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String otherName = request.getParameter("otherName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String comment = request.getParameter("comment");

        String lastNameSqlRank = LexiconAnalyzer.analyzeInjection(lastName);
        String firstNameSqlRank = LexiconAnalyzer.analyzeInjection(firstName);
        String otherNameSqlRank = LexiconAnalyzer.analyzeInjection(otherName);
        String addressSqlRank = LexiconAnalyzer.analyzeInjection(address);
        String emailSqlRank = LexiconAnalyzer.analyzeInjection(email);
        String passwordSqlRank = LexiconAnalyzer.analyzeInjection(password);
        String commentSqlRank = LexiconAnalyzer.analyzeInjection(comment);

        String lastNameJsRank = LexiconAnalyzer.analyzeJavaScriptInjection(lastName);
        String firstNameJsRank = LexiconAnalyzer.analyzeJavaScriptInjection(firstName);
        String otherNameJsRank = LexiconAnalyzer.analyzeJavaScriptInjection(otherName);
        String addressJsRank = LexiconAnalyzer.analyzeJavaScriptInjection(address);
        String emailJsRank = LexiconAnalyzer.analyzeJavaScriptInjection(email);
        String passwordJsRank = LexiconAnalyzer.analyzeJavaScriptInjection(password);
        String commentJsRank = LexiconAnalyzer.analyzeJavaScriptInjection(comment);

        String lastNameFinalRank = Rank.compareRanks(lastNameSqlRank, lastNameJsRank);
        String firstNameFinalRank = Rank.compareRanks(firstNameSqlRank, firstNameJsRank);
        String otherNameFinalRank = Rank.compareRanks(otherNameSqlRank, otherNameJsRank);
        String addressFinalRank = Rank.compareRanks(addressSqlRank, addressJsRank);
        String emailFinalRank = Rank.compareRanks(emailSqlRank, emailJsRank);
        String passwordFinalRank = Rank.compareRanks(passwordSqlRank, passwordJsRank);
        String commentFinalRank = Rank.compareRanks(commentSqlRank, commentJsRank);

        int lowRankThreshold = LexiconAnalyzer.getLowRankThreshold();
        String overallRankingSql = Rank.calculateOverallRanking(
            lowRankThreshold, lastNameSqlRank, firstNameSqlRank, otherNameSqlRank,
            addressSqlRank, emailSqlRank, passwordSqlRank, commentSqlRank
        );

        String overallRankingJs = Rank.calculateOverallRanking(
            lowRankThreshold, lastNameJsRank, firstNameJsRank, otherNameJsRank,
            addressJsRank, emailJsRank, passwordJsRank, commentJsRank
        );

        String overallRanking = Rank.calculateOverallRankingSQLJs(
            lastNameFinalRank, firstNameFinalRank, otherNameFinalRank,
            addressFinalRank, emailFinalRank, passwordFinalRank, commentFinalRank
        );

        if (overallRanking.equals("low")) {
            Database.saveToDatabase(lastName, firstName, otherName, address, email, password, comment);
            saveMessage = "Data saved successfully!";
        } else {
            saveMessage = "Data rejected - Data might contain harmful Javascript or SQL Query!";
        }

        request.setAttribute("lastName", lastName);
        request.setAttribute("firstName", firstName);
        request.setAttribute("otherName", otherName);
        request.setAttribute("address", address);
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        request.setAttribute("comment", comment);

        request.setAttribute("lastNameSqlRank", lastNameSqlRank);
        request.setAttribute("firstNameSqlRank", firstNameSqlRank);
        request.setAttribute("otherNameSqlRank", otherNameSqlRank);
        request.setAttribute("addressSqlRank", addressSqlRank);
        request.setAttribute("emailSqlRank", emailSqlRank);
        request.setAttribute("passwordSqlRank", passwordSqlRank);
        request.setAttribute("commentSqlRank", commentSqlRank);

        request.setAttribute("lastNameJsRank", lastNameJsRank);
        request.setAttribute("firstNameJsRank", firstNameJsRank);
        request.setAttribute("otherNameJsRank", otherNameJsRank);
        request.setAttribute("addressJsRank", addressJsRank);
        request.setAttribute("emailJsRank", emailJsRank);
        request.setAttribute("passwordJsRank", passwordJsRank);
        request.setAttribute("commentJsRank", commentJsRank);

        request.setAttribute("lastNameFinalRank", lastNameFinalRank);
        request.setAttribute("firstNameFinalRank", firstNameFinalRank);
        request.setAttribute("otherNameFinalRank", otherNameFinalRank);
        request.setAttribute("addressFinalRank", addressFinalRank);
        request.setAttribute("emailFinalRank", emailFinalRank);
        request.setAttribute("passwordFinalRank", passwordFinalRank);
        request.setAttribute("commentFinalRank", commentFinalRank);

        request.setAttribute("overallRankingSql", overallRankingSql);
        request.setAttribute("overallRankingJs", overallRankingJs);
        request.setAttribute("overallRanking", overallRanking);
        request.setAttribute("saveMessage", saveMessage);

        request.getRequestDispatcher("/result.jsp").forward(request, response);
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
