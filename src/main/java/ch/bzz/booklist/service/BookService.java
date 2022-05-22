package ch.bzz.booklist.service;


import ch.bzz.booklist.data.DataHandler;
import ch.bzz.booklist.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * service for reading, adding, changng and deleting books
 */
@Path("book")
public class BookService {


    /**
     *
     * reads a list of all books
     */

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBook() {
        List<Book> bookList = DataHandler.getInstance().readAllBooks();
        return Response
                .status(200).entity(bookList).build();
    }

    /**
     *
     * reads a book by UUID
     */

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readBook(@QueryParam("uuid") String bookUUID) {
        Book book = DataHandler.getInstance().readBookByUUID(bookUUID);
        return Response .status(200).entity(book).build();
    }
}
