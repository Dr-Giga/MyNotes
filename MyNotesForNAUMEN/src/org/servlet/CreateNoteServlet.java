package org.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.note.Note;
import org.utils.DBUtils;
import org.utils.MyUtils;

@WebServlet(urlPatterns = { "/newNote" })
public class CreateNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public CreateNoteServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createNotePage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String titleNote = (String) request.getParameter("titleNote");
        String bodyNote = (String) request.getParameter("bodyNote");

        if ("".equals(titleNote) == true){
            titleNote = bodyNote;
        }


        Note note = new Note(titleNote, bodyNote);

        String errorString = null;

        if (errorString == null) {
            try {
                DBUtils.insertNote(conn, note);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("note", note);


        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createNotePage.jsp");
            dispatcher.forward(request, response);
        }

        else {
            response.sendRedirect(request.getContextPath() + "/mainPage");
        }
    }

}