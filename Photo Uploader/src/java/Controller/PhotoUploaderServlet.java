package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author William
 */
@WebServlet(name = "PhotoUploaderServlet", urlPatterns = {"/PhotoUploaderServlet"})
@MultipartConfig
public class PhotoUploaderServlet extends HttpServlet {

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
            out.println("<title>Servlet PhotoUploaderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhotoUploaderServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
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
        //processRequest(request, response);
        System.out.println("INSIDE SERVLET POST");
        System.out.println("Upload Picture servlet");
        String name = "";
       
        HttpSession session = request.getSession();
        //path is hardcoded. I still haven't figured out how to make it dynamic
        String destination = "C:\\Users\\HKJ\\Documents\\PROSDEV-Photo-Uploader\\Photo Uploader\\web\\Images\\";
        if(ServletFileUpload.isMultipartContent(request)){
            try{
                
                Part filePart = request.getPart("uploadImage");
                String del = String.valueOf(request.getParameter("but"));
                System.out.println(del + "??");
                if(filePart!= null && del.equals("Upload New Picture")){
                    name = "";
                    name = filePart.getSubmittedFileName();
                    System.out.println("name is " +name);
                    System.out.println("Destination is " +destination);
                    InputStream fileContent = filePart.getInputStream();
                    OutputStream fileOutput = new FileOutputStream(new File(destination+name));
                    
                    int read = 0;
                    byte[] bytes = new byte[1024];

                    while ((read = fileContent.read(bytes)) != -1) {
			fileOutput.write(bytes, 0, read);
                    }
                }
                else if (filePart != null && del.equals("Delete")){
                    name = "";
                    name = filePart.getSubmittedFileName();
                    System.out.println("name : " + name);
                    File p;
                    p = new File(destination+name);
                    if (!(name.length() == 0) && p.exists())
                    p.delete();
                    else
                    throw new Exception("!");
                }
                response.sendRedirect("index.jsp");
            }catch(Exception e){
                response.sendRedirect("uploadfail.jsp");
                e.printStackTrace(); 
            }
        }
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
