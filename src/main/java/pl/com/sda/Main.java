package pl.com.sda;

import picocli.CommandLine;
import picocli.CommandLine.*;
import pl.com.sda.compressor.Compressor;
import pl.com.sda.compressor.NaiveCompressor;
import pl.com.sda.compressor.OptimalCompressor;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    @Option(names = { "-m", "--message" }, description = "Text message [Please use \'\']", required = true)
    private static String message;

    @Option(names = { "-l", "--length" }, description = "Length of single text message [number of characters]",
            required = true)
    private static int length;

    @Option(names = { "-p", "--price" }, description = "Price of single text message [PLN]", required = true)
    private static double price;

    @Option(names = "-n", description = "Naive compressor turning on [Please use -n or -o]")
    private static boolean naiveCompressor;

    @Option(names = "-o", description = "Optimal compressor turning on [Please use -n or -o]")
    private static boolean optimalCompressor;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help and exit")
    private static boolean help;

    public static void main(String[] args) {

        Main app = CommandLine.populateCommand(new Main(), args);

        if (help || args.length == 0 || (naiveCompressor == optimalCompressor)) {
            CommandLine.usage(new Main(), System.out);
            return;
        }

        Paginator paginator = new Paginator(length);
        CostCalculator calculator = new CostCalculator(new BigDecimal(price));

        Compressor compressor = null;
        if (naiveCompressor) compressor = new NaiveCompressor();
        else if (optimalCompressor) compressor = new OptimalCompressor();

        String compressedMessage = compressor.compress(message);
        String[] paginatedMessage = paginator.paginate(compressedMessage);
        System.out.println("Your codded and splited message: " + Arrays.toString(paginatedMessage));
        System.out.println("Cost of your message(s): " + calculator.calculate(paginatedMessage.length));

        System.out.println("Uncompressed message: " + compressor.uncompress(compressedMessage));
    }

}
