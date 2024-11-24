package hust.dsai.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCollector
{
    public static void main(String[] args) {
        String filename = "/home/g0dz/schoolsj/java/lab/AimsProject/src/hust/dsai/dsai/garbage/test-100M.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;
        try{
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String output = "";
        for(byte b : inputBytes) output += (char)b;
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
