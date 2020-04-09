


package com.devcolibri.logic;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class LibrarianTest extends Assert {

    Book book1 = new Book("Kolobok", "Ded", 1641);
    Book book2 = new Book("Ded Moroz", "Ded", 1271);

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod – аннотированный метод будет выполняться перед каждым тестовым методом.");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod – аннотированный метод будет запускаться после каждого тестового метода.");
    }

    @BeforeGroups
    public void beforeGroups() throws Exception {
        System.out.println("BeforeGroups – аннотирует методы, которые будут выполняться перед первым методом в любой из указанных групп.");
    }

    @AfterGroups
    public void afterGroups() throws Exception {
        System.out.println("@AfterGroups – аннотируется методы, которые будут выполняться после всех методом в любом из указанных групп.");
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        System.out.println("@BeforeClass – указывает, что метод будет выполнен до всех тестовых методов тестового класса.");
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        System.out.println("@BeforeTest - аннотированный метод будет запускаться до всех тестовых методов.");
    }

    @AfterTest
    public void afterTest() throws Exception {
        System.out.println("@AfterTest – аннотированный метод будет запущен после всех тестовых методов, принадлежащих классам внутри тега <test>.");
    }

    @AfterClass
    public void afterClass() throws Exception {
        System.out.println("@AfterClass  – аннотированный метод будет запущен после всех тестовых методов в текущем классе.");
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        System.out.println("@BeforeSuite – указывает, что данный метод будет запускаться перед любым методом тестового класса.");
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        System.out.println("@AfterSuite – указывает, что данный метод, будет запускаться после всех методов тестового класса.");
    }

    @Test(groups={"unit1"})
    public void testAddBooks() throws Exception {
        List<Book> books = Book.getAllBooks();
        for (Book book:books
        ) {
            System.out.println(book.toString());
        }

        Assert.assertNotNull(books);
    }

    @Test(timeOut = 1000)
    public void testCompareBooks() throws Exception {
        List<Book> books = Book.getAllBooks();

        Librarian librarian = new Librarian();
        librarian.addBook(book1);
        librarian.addBook(book2);

        Assert.assertEquals(books, librarian.getAllBooks());
    }

    @Test(groups={"unit1"})
    public void testRemoveBook() throws NullPointerException{
        Librarian librarian = new Librarian();
        librarian.addBook(book1);

        librarian.removeBook(book1);
        Assert.assertNotNull(librarian.getAllBooks());
    }

    @Test(enabled = false)
    public void testAddBooksIgnor() throws Exception {
        List<Book> books = Book.getAllBooks();
        for (Book book:books
        ) {
            System.out.println(book.toString());
        }

        Assert.assertNotNull(books);
    }

}
