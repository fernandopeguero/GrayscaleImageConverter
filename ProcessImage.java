import edu.duke.*;
import java.io.*;
/**
 * Write a description of ProcessImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProcessImage {
    
    ImageResource makeGrayscale(ImageResource inImage) {
        
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel p: outImage.pixels()){
            // get the inImage current pixel 
            // add the rgb and divide by 3 to average variable set the variable 
            // set outImage pixel red ,green, blue to the color
            
            Pixel currentPixel = inImage.getPixel(p.getX() , p.getY());
            
            int average = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;
            
            p.setRed(average);
            p.setGreen(average);
            p.setBlue(average);
        }
        
        // draw image 
        outImage.draw();
        
        return outImage;
    }

   
    void testMakeGrayscale() {
    
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()) {
            
            ImageResource image = new ImageResource(f);
            ImageResource outImage = makeGrayscale(image);
            
            outImage.draw();
        }
        
    }
}
