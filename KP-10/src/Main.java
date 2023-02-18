import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder memory = new StringBuilder();
        try(InputStream input = new FileInputStream(sc.nextLine());OutputStream  output = new FileOutputStream(sc.nextLine())){
            while(input.available() > 0){
                int i = input.read();
                if (i <= (int) '9' && i >= (int) '0') {
                    memory.append((char) i);
                } else {
                    if (memory.length() > 0) {
                        output.write(memory.toString().getBytes());
                        output.write(' ');
                        memory.delete(0, memory.length());
                    }
                }
            }
            if (memory.length() > 0) {
                output.write(memory.toString().getBytes());
                memory.delete(0, memory.length());
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }





        String a = "https://ru.stackoverflow.com/questions/1084036/%D0%9F%D0%BE%D1%81%D1%87%D0%B8%D1%82%D0%B0%D1%82%D1%8C-%D0%BA%D0%BE%D0%BB%D0%B8%D1%87%D0%B5%D1%81%D1%82%D0%B2%D0%BE-%D0%B2%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D0%B9-%D0%BF%D0%BE%D0%B4%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%B2-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D1%83";
        URL url = null;
        try {
            url = new URL(a);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        BufferedReader br = null;
        int count = 0;
        try {
            URLConnection conn = url.openConnection();
            br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                Pattern p = Pattern.compile("<p>");
                Matcher m = p.matcher(inputLine);
                while (m.find()) {
                    count++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(count);

    }
}