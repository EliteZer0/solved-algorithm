import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String transformed = input.replace("c=", "1")
            .replace("c-", "1")
                                 .replace("dz=", "1")
            .replace("d-", "1")
                                 .replace("lj", "1")
                                 .replace("nj", "1")
                                 .replace("s=", "1")
                                 .replace("z=", "1");
        System.out.print(transformed.length());
    }
}