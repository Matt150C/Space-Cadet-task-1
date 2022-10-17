import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String line;
        String email;
        char loop = 'x';
        int count = 0;
        String userId = "";
        String webAddress = "https://www.ecs.soton.ac.uk/people/";
        int index1;
        int index2;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter email: ");

        email = reader.readLine();

        while (loop != '@') {
            loop = email.charAt(count);
            if (loop != '@') {
                userId += loop;
            }
            count++;
        }

        System.out.println(userId);
        webAddress += userId;
        System.out.println(webAddress);

        URL url = new URL(webAddress);

        BufferedReader webpageReader = new BufferedReader(new InputStreamReader(url.openStream()));

        count = 0;

        while ((line = webpageReader.readLine()) != null) {
            if (count == 13) {
                index1 = line.lastIndexOf('=');
                index2 = line.lastIndexOf('"');
                System.out.println(line.substring(index1+2, index2));
            }
            count++;
        }

    }
}