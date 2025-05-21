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

    @Test
    public void shouldParse2() throws URISyntaxException, IOException {
        var fileContent = Files.readString(Path.of(this.getClass().getResource("/twos.txt").toURI()));
        Assert.assertEquals("222222222", parser.parse(fileContent));
    }

    @Test
    public void shouldParse3() throws URISyntaxException, IOException {
        var fileContent = Files.readString(Path.of(this.getClass().getResource("/three.txt").toURI()));
        Assert.assertEquals("333333333", parser.parse(fileContent));
    }
    @Test
    public void shouldParse123456789() throws URISyntaxException, IOException {
        var fileContent = Files.readString(Path.of(this.getClass().getResource("/123456789.txt").toURI()));
        Assert.assertEquals("123456789", parser.parse(fileContent));
    }
}
