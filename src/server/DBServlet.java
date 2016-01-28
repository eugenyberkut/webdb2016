package server;

import beans.AvtorService;
import beans.BookService;
import tables.Avtor;
import tables.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yevhen on 19.01.2016.
 */
@WebServlet(name = "DBServlet", urlPatterns = {"/main"})
public class DBServlet extends HttpServlet {
    @EJB
    AvtorService avtorService;

    @EJB
    BookService bookService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("addavtor")!=null) {
            String name = request.getParameter("avtorname");
            String comment = request.getParameter("avtorcomment");
            avtorService.createAvtor(name, comment);
            response.sendRedirect("main");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("booksbyavtor")!=null) {
            Integer avtorId = Integer.valueOf(request.getParameter("booksbyavtor"));
            Avtor avtor = bookService.findById(avtorId);
            request.setAttribute("avtor", avtor);
            request.getRequestDispatcher("/booksbyavtor.jsp").forward(request, response);
        } else
        if (request.getParameter("books")!=null) {
            List<Book> books = bookService.findAll();
            request.setAttribute("books", books);
            request.getRequestDispatcher("/books.jsp").forward(request, response);
        } else
        if (request.getParameter("findbooks")!=null) {
            Avtor avtor = avtorService.findAvtorByName(request.getParameter("avtorname"));
            if ("not found".equals(avtor.getName())) {
                request.getRequestDispatcher("/avtornotfound.jsp").forward(request, response);
            }else {
                request.setAttribute("avtor", avtor);
                request.getRequestDispatcher("/booksbyavtor.jsp").forward(request, response);
            }
        } else {
            List<Avtor> avtors = avtorService.findAll();
            request.setAttribute("avtors", avtors);
            request.getRequestDispatcher("/avtors.jsp").forward(request, response);
        }
    }
}
