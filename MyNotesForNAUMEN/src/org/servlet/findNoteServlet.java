package org.servlet;


import org.note.Note;
import org.utils.DBUtils;
import org.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/findNote"})
public class findNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public findNoteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/findNotePage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = MyUtils.getStoredConnection(request);
        String word = (String) request.getParameter("word");
        String errorString = null;
        List<Note> list1 = null;


        try
        {
            list1 = DBUtils.findNote(conn, word);
        } catch(
                SQLException e)
        {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("word", word);
        request.setAttribute("noteList", list1);


        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/findNotePage.jsp");
            dispatcher.forward(request, response);
        }

        else {
            doGet(request, response);
            response.sendRedirect(request.getContextPath() + "/findNote");
        }
    }






}
