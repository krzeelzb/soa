import javax.jms.*;
import javax.naming.InitialContext;
public class MyReceiver {
    public static void main(String[] args) {
        try{
//1) Tworzenie I inichalizacja połaczenia do JMS
            InitialContext ctx=new InitialContext();
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("InVmConnectionFactory");
            QueueConnection con=f.createQueueConnection();
            con.start();
//2) stworzenie secji dla
           QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//3) Dostep do obiektu kolejki
            Queue t=(Queue)ctx.lookup("SOA_Test ");
//4)tworzenie QueueReceiver

            QueueReceiver receiver=ses.createReceiver(t);
//5) Tworzenie nasłuchu
            MyListener listener=new MyListener();
//6 rejstracja funkji nasłuchujacej
            receiver.setMessageListener(listener);
            System.out.println("Jestem gotowy, c zekam na komunikat...");
            while(true){
                Thread.sleep(1000);
            }
        }catch(Exception e){System.out.println(e);}
    }
}