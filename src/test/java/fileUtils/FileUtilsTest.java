package fileUtils;

import file.utils.FileTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {
    private final int NUMBER_OF_FILE_LINES = 2;
    private final String PATH_TO_FILE = getClass().getResource("/filesUtils/test.txt").getPath();
    private final String FIRST_LINE = "Ala ma kota, kot ma Alę.";

    @Test
    protected void testIfNumberOfLineAreEquals() { //najpierw wywołjemy metodę statyczną, alt enter, test do sprawdzenia ilości linii w Stringu po znaku
        String fileContent = FileTool.getFileContent(PATH_TO_FILE);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(NUMBER_OF_FILE_LINES, split.length);
    }

    @Test
    protected void testEqualContentsOnFirstLine() {
        String fileContent = FileTool.getFileContent(PATH_TO_FILE);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(FIRST_LINE, split[0]);    // (zmienna oczekiwana, zmienna porównywana)
    }

//

    @Test
    protected void howDoesSplitWorks() {
        String textToSplit = "ANANAS";
        String[] split = textToSplit.split("A");
        for (String s : split) {
            System.out.println(s + "!");
            /*zwraca
             !
            N!
            N!
            S!
            4*/
        }
        System.out.println(split.length);  //ZWRACA DŁUGOŚĆ TABLICY 4
    }
}
