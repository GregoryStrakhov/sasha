/**
 * Created by Erizo on 06.12.2016.
 */
public class Main {

    public static void main(String[] args) {

        PrinterService printerService = new PrinterService();

        System.out.println(printerService.getPrinters());

        //print some stuff
        printerService.printString("EPSONTMT58", "\n\n testing testing 1 2 3eeeee \n\n");

        // cut that paper!
        byte[] cutP = new byte[] { 0x1d, 'V', 1 };

        printerService.printBytes("EPSONTMT58", cutP);

    }
}
