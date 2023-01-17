package files;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesProj {
    public static void main(String[] args) throws IOException {
        // create file
        Files.createFile(Paths.get("myNewFile.txt"));

        // get the absolute path of file
        Path absolutePath = Paths.get("myNewFile.txt").toAbsolutePath();
        System.out.println(absolutePath.toString());

        // check if file exists
        if (Files.exists(Paths.get("randomFile"))){
            System.out.println("Files exists");
        } else {
            System.out.println("File does not exist");
        }

        // create directory
        Path directoryPath = Files.createDirectory(Paths.get("TestFolder"));

        // create a file in the directory
        Path filePath = Files.createFile(Paths.get(directoryPath.toAbsolutePath()+"/fileintest.txt"));

        // write to file using Files.write method
        byte[] teapotIntro = "I'm a little teapot\n".getBytes("UTF-8");
        Files.write(filePath, teapotIntro);

        // write to a file using a writer - with traditional try catch
        Writer writer1 = null;
        try {
            writer1 = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
            writer1.write("short and stout.\n");
        } catch (IOException e) {
            System.out.println("Failed to write file: " + e.getMessage());
        } finally {
            if (writer1 != null) writer1.close();
        }

        // write to a file - with traditional try-with-resources
        try (Writer writer2 = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.WRITE)){
             writer2.write("Here is my handle.");
        } catch (IOException e){
            System.out.println("Failed to write file: " + e.getMessage());
        }

        //write to console
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out)){
            outputStreamWriter.write("Hello to my console from outside");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
