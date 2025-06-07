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

    @Test
    public void calculChecksum1()
    {
        Assert.assertEquals(9+8+7+6+5+4+3+2+1,parser.checksum("111111111"));
    }

    @Test
    public void calculChecksum123456789()
    {
        Assert.assertEquals(1*9+2*8+3*7+4*6+5*5+4*6+7*3+8*2+9*1,parser.checksum("123456789"));
    }

    @Test
    public void calculChecksum345882865()
    {
        Assert.assertEquals(3*9+4*8+5*7+8*6+8*5+2*4+8*3+6*2+5*1,parser.checksum("345882865"));
    }

    @Test
    public void shoulValidAccount345882865()
    {
        Assert.assertTrue(parser.isValidAccount("345882865"));
    }

    @Test
    public void shoulInvalidAccount333333333()
    {
        Assert.assertFalse(parser.isValidAccount("333333333"));
    }

    @Test
    public void shouldHaveERRStatus()
    {
        Assert.assertEquals("333333333 ERR",parser.writeLineOut("333333333"));
    }

    @Test
    public void shouldHaveNoStatus()
    {
        Assert.assertEquals("345882865",parser.writeLineOut("345882865"));
    }

    @Test
    public void shoulInValidAccount111111111()
    {
        Assert.assertFalse(parser.isValidAccount("111111111"));
    }

    @Test
    public void shouldHaveStatusILL() throws URISyntaxException, IOException {
        var fileContent = Files.readString(Path.of(this.getClass().getResource("/123456789_ILL.txt").toURI()));
        Assert.assertEquals("1234?678? ILL",parser.writeLineOut("1234?678?"));Assert.assertFalse(parser.isValidAccount("1234?678?"));
    }
}
