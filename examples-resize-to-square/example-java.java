import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class JavaRethumbExample
{
    public static void main(String [] args) throws Exception
    {
        String paramOperation = "square";
        int paramValue = 100; // Square size in pixels.
        
        String imageURL = "http://images.rethumb.com/image_coimbra_600x300.jpg";
        String imageFilename = "resized-image.jpg";

        URL url = new URL(String.format("http://api.rethumb.com/v1/%s/%s/%s", paramOperation, paramValue, imageURL));
        FileOutputStream fos = new FileOutputStream(imageFilename);
        fos.getChannel().transferFrom(Channels.newChannel(url.openStream()), 0, Long.MAX_VALUE);
    }
}