package com.webDevelopment.solid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webDevelopment.solid.services.RaleyEmailSender;
import com.webDevelopment.solid.services.HTMLFormatter;
import com.webDevelopment.solid.services.JsonFormatter;
import com.webDevelopment.solid.services.XMLFormatter;
import com.webDevelopment.solid.useCases.BookCardFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookCardFinderTests{

    private BookCardFinder bookCardFinder;

    @BeforeEach
    public void setUp()
    {
//        bookCardFinder = new BookCardFinder();
    }

    @Test
    public void bookCardInHTMLFormatTest()
    {
        bookCardFinder = new BookCardFinder(new HTMLFormatter(), new RaleyEmailSender());
        String expected = "<p>The book 1984 has benn written by George Orwell and was " +
                "published in 1949. The book's price is 20.0</p>";
        assertEquals(expected, bookCardFinder.execute());
    }

    @Test
    public void bookCardInXMLFormatTest()
    {
        bookCardFinder = new BookCardFinder(new XMLFormatter(), new RaleyEmailSender());
        String expected = "<element att='bookCard'>The book 1984 has benn written by George Orwell and was " +
                "published in 1949. The book's price is 20.0</element>";
        assertEquals(expected, bookCardFinder.execute());
    }

    @Test
    public void bookCardInJSONFormatTest()
    {
        bookCardFinder = new BookCardFinder(new JsonFormatter(), new RaleyEmailSender());
        String expected = "{ 'bookCard' : 'The book 1984 has benn written by George Orwell and was " +
                "published in 1949. The book's price is 20.0' }";
        assertEquals(expected, bookCardFinder.execute());
    }
}
