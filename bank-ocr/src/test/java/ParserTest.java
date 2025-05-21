import kata.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParserTest {

    Parser parser = new Parser();
    @Test
    public void shouldParse0() throws URISyntaxException, IOException {
        var fileContent = Files.readString(Path.of(this.getClass().getResource("/zeros.txt").toURI()));
        Assert.assertEquals("000000000", parser.parse(fileContent));
    }

    @Test
    public void shouldParse1() throws URISyntaxException, IOException {
        var fileContent = Files.readString(Path.of(this.getClass().getResource("/ones.txt").toURI()));
        Assert.assertEquals("111111111", parser.parse(fileContent));
    }
}
