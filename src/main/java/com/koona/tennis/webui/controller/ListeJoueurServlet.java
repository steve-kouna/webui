/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.tennis.webui.controller;

import com.koona.tennis.core.dto.JoueurDto;
import com.koona.tennis.core.service.JoueurService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Steve KOUNA
 */
public class ListeJoueurServlet extends HttpServlet {
    
    private JoueurService joueurService;

    public ListeJoueurServlet() {
        this.joueurService = new JoueurService();
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
        List<JoueurDto> ListeJoueur = joueurService.getAll("H".charAt(0));
        List<JoueurDto> ListeJoueuxe = joueurService.getAll("F".charAt(0));
        
        request.setAttribute("ListeJoueur", ListeJoueur);
        request.setAttribute("ListeJoueuxe", ListeJoueuxe);
        
        RequestDispatcher disp = request.getRequestDispatcher("liste.jsp");
        disp.forward(request, response);
    }

}
