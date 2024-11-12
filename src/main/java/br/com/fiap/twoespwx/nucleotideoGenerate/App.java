/*
 * Grupo: Nexos
 * Autores:
 *      - Anna Yagyu     -   rm550360
 *      - Breno Silva     -   rm99275
 *      - Danilo Urze    -   rm99465
 *      - Pedro Henrique  -   rm550689
 */

package br.com.fiap.twoespwx.nucleotideoGenerate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        String inputPath = "C:\\Users\\pedro\\Desktop\\Fiap\\DDD - Java\\Checkpoint1_Libunclepresser\\src\\input\\input1.txt";
        String outputPath = "C:\\Users\\pedro\\Desktop\\Fiap\\DDD - Java\\Checkpoint1_Libunclepresser\\src\\output\\OUTPUT1.TXT";

        try {
            String inputData = readInputFile(inputPath);
            String compressedData = runLengthEncode(inputData);
            writeOutputFile(outputPath, compressedData);

            Map<Character, Integer> frequencies = calculateFrequencies(inputData);

            displayInterface(inputPath, outputPath, inputData, compressedData, frequencies);

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

    public static String readInputFile(String inputPath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(inputPath));
        return new String(bytes, StandardCharsets.UTF_8).replaceAll("\\s+", "").toUpperCase();
    }

    public static String runLengthEncode(String data) {
        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (char c : data.toCharArray()) {
            if (c == 'A' || c == 'C' || c == 'T' || c == 'G') {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            result.append(entry.getValue()).append(entry.getKey());
        }

        return result.toString();
    }

    public static void writeOutputFile(String outputPath, String data) throws IOException {
        Files.write(Paths.get(outputPath), data.getBytes(StandardCharsets.UTF_8));
    }

    private static Map<Character, Integer> calculateFrequencies(String data) {
        Map<Character, Integer> frequencies = new LinkedHashMap<>();
        for (char c : data.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }

    private static void displayInterface(String inputPath, String outputPath, String inputData, String compressedData, Map<Character, Integer> frequencies) {
        int inputSize = inputData.length();
        int outputSize = compressedData.length();
        double compressionRate = 100 - (( (double) outputSize / inputSize) * 100);

        System.out.println(" -----------------------------------------------------------");
        System.out.println("           LIB UNCLE PRESSER - GRUPO Nexos                ");
        System.out.println("-----------------------------------------------------------");
        System.out.println(" INPUT FILENAME: " + inputPath.substring(inputPath.lastIndexOf("\\") + 1));
        System.out.println(" OUTPUT FILENAME: " + outputPath.substring(outputPath.lastIndexOf("\\") + 1));
        System.out.println("                                                           ");
        System.out.println(" INPUT FILE SIZE: " + inputSize + " characters            ");
        System.out.println("                                                           ");
        System.out.println(" FREQUENCIES:                                              ");
        frequencies.forEach((key, value) -> {
            double percentage = ((double) value / inputSize) * 100;
            System.out.printf(" %c: %d (%.2f%%)                                        \n", key, value, percentage);
        });
        System.out.println("                                                           ");
        System.out.println(" ALGORITHM: Run-Length Encoding (RLE)                      ");
        System.out.println(" TEXT-CODIFICATION: UTF-8                                  ");
        System.out.println(" COMPRESSION RATE: " + String.format("%.2f", compressionRate) + "%");
        System.out.println("                                                           ");
        System.out.println(" OUTPUT FILE SIZE: " + outputSize + " characters           ");
        System.out.println(" -----------------------------------------------------------");
        System.out.println("                                                           ");
        System.out.println(" SCORE: WELL-DONE                                          ");
        System.out.println("                                                           ");
        System.out.println(" -----------------------------------------------------------");
    }
}