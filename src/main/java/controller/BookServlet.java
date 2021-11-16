package controller;

import model.Book;
import model.Category;
import service.book.BookService;
import service.book.IBookService;
import service.category.CategoryService;
import service.category.ICategory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();
    ICategory categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action == null) {
    action = "";
}
switch (action) {
    case "create":
        showCreateForm(request,response);
        break;
    case "delete":
        deleteBook(request,response);
        break;
    case "edit":
        editForm(request,response);
        break;
    default:
        showAllBook(request,response);

}
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.remove(id);
        try {
            response.sendRedirect("/books");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categories",categoryList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("book/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createBook(request,response);
                break;
            case "edit":
                break;
            default:

        }
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) {
        String name =request.getParameter("name");
        double price=Double.parseDouble(request.getParameter("price"));
        String[] categoriesStr= request.getParameterValues("category");
        int[] categories=new int[categoriesStr.length];
        for (int i = 0; i <categoriesStr.length ; i++) {
            categories[i]=Integer.parseInt(categoriesStr[i]);
        }
        Book book=new Book(name,price);
        bookService.save(book,categories);
        try {
            response.sendRedirect("/books");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
}
