package encryptdecrypt;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String mode = "";
        int key = 0;
        String toTranslate = "";
        String inputFileName = "";
        String outputFileName = "";
        String algorithm = "";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    toTranslate = args[i + 1];
                    break;
                case "-in":
                    inputFileName = args[i + 1];
                    break;
                case "-out":
                    outputFileName = args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                default:
                    break;
            }
        }

        if (mode.isEmpty()) {
            mode = "enc";
        }

        if (!inputFileName.isEmpty()) {
            try {
                toTranslate = new String(Files.readAllBytes(Paths.get(inputFileName)));
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }


        AlgorithmContext context = new AlgorithmContext();
        if (algorithm.equals("shift")) {
            context.setStrategy(new ShiftStrategy());
        } else if (algorithm.equals("unicode")) {
            context.setStrategy(new UnicodeStrategy());
        }


        if (!outputFileName.isEmpty()) {
            try {
                File file = new File(outputFileName);
                FileWriter writer = new FileWriter(file);

                if ("dec".equals(mode)) {
                    writer.write(context.decrypt(toTranslate, key));
                } else {
                    writer.write(context.encrypt(toTranslate, key));
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            if ("dec".equals(mode)) {
                System.out.println(context.decrypt(toTranslate, key));
            } else {
                System.out.println(context.encrypt(toTranslate, key));
            }
        }

    }
}
