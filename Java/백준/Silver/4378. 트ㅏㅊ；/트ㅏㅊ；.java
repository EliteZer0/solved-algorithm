import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String result = line.replace("1", "`").replace("2", "1").replace("3", "2").replace("4", "3")
                .replace("5", "4").replace("6", "5").replace("7", "6").replace("8", "7")
                .replace("9", "8").replace("0", "9").replace("-", "0").replace("=", "-")
                .replace("W", "Q").replace("E", "W").replace("R", "E").replace("T", "R")
                .replace("Y", "T").replace("U", "Y").replace("I", "U").replace("O", "I")
                .replace("P", "O").replace("[", "P").replace("]", "[").replace("\\", "]")
                .replace("S", "A").replace("D", "S").replace("F", "D").replace("G", "F")
                .replace("H", "G").replace("J", "H").replace("K", "J").replace("L", "K")
                .replace(";", "L").replace("'", ";").replace("X", "Z").replace("C", "X")
                .replace("V", "C").replace("B", "V").replace("N", "B").replace("M", "N")
                .replace(",", "M").replace(".", ",").replace("/", ".");
            
            System.out.println(result);
        }
    }
}