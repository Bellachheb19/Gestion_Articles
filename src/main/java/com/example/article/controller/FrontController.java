package com.example.article.controller;
import com.example.article.model.Article;
import com.example.article.model.DaoArticle;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/app",
        "/app/list",
        "/app/new",
        "/app/create",
        "/app/edit",
        "/app/update",
        "/app/delete"
})
public class FrontController extends HttpServlet {
    private DaoArticle dao;
    @Override
    public void init() {
        dao = DaoArticle.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {

            // -------- LIST --------
            case "/app":
            case "/app/list":

                request.setAttribute("articles", dao.findAll());

                request.getRequestDispatcher(
                        "/WEB-INF/views/listesArticles.jsp"
                ).forward(request, response);

                break;


            // -------- NEW --------
            case "/app/new":

                request.getRequestDispatcher(
                        "/WEB-INF/views/Article.jsp"
                ).forward(request, response);

                break;


            // -------- EDIT --------
            case "/app/edit":

                String codeEdit = request.getParameter("code");

                Article article = dao.findByCode(codeEdit);

                if (article != null) {

                    request.setAttribute("article", article);

                    request.getRequestDispatcher(
                            "/WEB-INF/views/EditArticle.jsp"
                    ).forward(request, response);

                } else {

                    response.sendError(
                            HttpServletResponse.SC_NOT_FOUND
                    );
                }

                break;


            // -------- DELETE --------
            case "/app/delete":

                String codeDelete = request.getParameter("code");

                dao.delete(codeDelete);

                response.sendRedirect(
                        request.getContextPath() + "/app/list"
                );

                break;


            // -------- 404 --------
            default:

                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND
                );
        }
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {

            // -------- CREATE --------
            case "/app/create":

                String code = request.getParameter("code");
                String designation = request.getParameter("designation");
                double prix = Double.parseDouble(request.getParameter("prix"));

                // Vérifier si le code existe déjà
                if (dao.findByCode(code) != null) {

                    request.setAttribute(
                            "error",
                            "Un article avec le code " + code + " existe déjà."
                    );

                    request.getRequestDispatcher(
                            "/WEB-INF/views/Article.jsp"
                    ).forward(request, response);

                    break;
                }

                Article nouvelArticle =
                        new Article(code, designation, prix);

                dao.save(nouvelArticle);

                response.sendRedirect(
                        request.getContextPath() + "/app/list"
                );

                break;


            // -------- UPDATE --------
            case "/app/update":

                String codeUpdate =
                        request.getParameter("code");

                String designationUpdate =
                        request.getParameter("designation");

                double prixUpdate = Double.parseDouble(
                        request.getParameter("prix")
                );

                Article articleUpdate =
                        new Article(
                                codeUpdate,
                                designationUpdate,
                                prixUpdate
                        );

                dao.update(articleUpdate);

                response.sendRedirect(
                        request.getContextPath() + "/app/list"
                );

                break;


            // -------- 404 --------
            default:

                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND
                );
        }
    }
}