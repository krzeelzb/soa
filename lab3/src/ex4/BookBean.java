package ex4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@SessionScoped
@ManagedBean(name = "book")
public class BookBean {
    private Double priceFrom=0.0;
    private Double priceTo=1000.0;
    private List<String> title=null;
    private List<String> author=new LinkedList<String>(Arrays.asList("Adam Mickiewicz","Lev Tolstoy","Shakespeare","Boleslaw Prus" ));
//    private List<String> author=null;
    private List<String> type=null;

    private String currency;
    private List<Integer> pages=null;

    private List<Book> select;

    public List<Book> getSelect() {
        return finalResult();
    }

    public void setSelect(List<Book> select) {
        this.select = select;
    }


    public void setTitle(List<String> title) {        this.title = title;    }

    public void setAuthor(List<String> author) {        this.author = author;    }

    public void setType( List<String>  type) {        this.type = type;    }

    public void setCurrency( String currency) {        this.currency = currency;    }

    public void setPages( List<Integer>  pages) {        this.pages = pages;    }

    public List<String> getTitle() {        return title;    }

    public List<String> getAuthor() {        return author;    }

    public  List<String>  getType() {        return type;    }

    public  String getCurrency() {        return currency;    }

    public  List<Integer>  getPages() {        return pages;    }
    public LinkedList<Book> getBooks() {        return books;    }



    private  LinkedList<Book> books = new LinkedList<Book>(Arrays.asList(
            new Book("Pan Tadeusz","Adam Mickiewicz", "dramat", "PLN", 1000, 30.99,false),
            new Book("Wojna i Pokoj","Lev Tolstoy", "novel", "EUR",2000, 50.0,false),
            new Book("Romeo i Julia","Shakespeare", "romans","GBP" ,150, 29.90,false),
            new Book("Lalka","Boleslaw Prus","novel", "PLN" ,1500, 45.90,false)
    ));

    public LinkedList<Book> getResult() {
        return filter();
    }

    public void setResult(LinkedList<Book> result) {
        this.result = result;
    }

    private  LinkedList<Book> result=books;

    public LinkedList<Book> filter(){
        LinkedList<Book> toReturn=new LinkedList<Book>();
        for (Book book:books
             ) {
            if(author.contains(book.author)
                    && book.price>=priceFrom
                    && book.price<= priceTo
                    && !(toReturn.contains(book))){
                if(currency!=null){
                    if(book.currency.equals("GBP")){
                        book.price=book.price*5.02;
                    }
                    if(book.currency.equals("EUR")){
                        book.price=book.price*4.29;
                    }
                    book.currency=currency;
                }
                toReturn.add(book);
            }
        }
        return toReturn;
    }

    public LinkedList<Book> finalResult(){
        LinkedList<Book> toReturn=new LinkedList<Book>();
        for (Book book:result
        ) {
            if(book.select==true){
                toReturn.add(book);
            }
        }
        return toReturn;
    }



    public static class Book {

        private String title;
        private String author;
        private String type;
        private String currency;
        private Integer pages;
        private Double price;
        private Boolean select;


        public Book(String title, String author, String type, String currency, Integer pages, Double price, Boolean select) {
            this.title = title;
            this.author = author;
            this.type = type;
            this.currency = currency;
            this.pages = pages;
            this.price = price;
            this.select=select;
        }


        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getType() {
            return type;
        }

        public String getCurrency() {
            return currency;
        }

        public Integer getPages() {
            return pages;
        }

        public Double getPrice() {
            return price;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public void setPrice(Double price) {
            this.price = price;
        }


        public Boolean getSelect() {
            return select;
        }

        public void setSelect(Boolean select) {
            this.select = select;
        }

    }
    public Double getPriceFrom() {
        return priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }
    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }


}
