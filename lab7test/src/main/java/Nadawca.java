import javax.naming.*;
import javax.jms.*;
import java.io.FileInputStream;
import java.util.Properties;

public class Nadawca {
    public static void main(String[] args) {
        try
        { //Tworzenie połączenie z infrastruktura JMS


            InitialContext ctx=new InitialContext();
//            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("java:/ConnectionFactory" );

            @Resource(mappedName="jms/ConnectionFactory")
            private static ConnectionFactory f;

            QueueConnection con=f.createQueueConnection();
            con.start();
//2) tworzymy sesje
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//3) dostep do kolejki
            Queue t=(Queue)ctx.lookup("SOA_Test");
            QueueSender sender=ses.createSender(t);
//5) Przygotowanie obiektu do wysyłki
            TextMessage msg=ses.createTextMessage();
            msg.setText("Ala ma kotka");
//7) wysyłka komunikatu
            sender.send(msg);
            System.out.println("Komunikat wysłany.");
            con.close();
        } catch (NamingException e1) {
            e1.printStackTrace();
        } catch (JMSException e1) {
            e1.printStackTrace();
        }
        finally {
        }
//8) zamknięcie połączenia



}
}