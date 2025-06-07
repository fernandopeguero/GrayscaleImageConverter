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
            
            Pixel currentPixel = inImage.getPixel(p.getX() , p.getY());
            
            int average = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;
            
            p.setRed(average);
            p.setGreen(average);
            p.setBlue(average);
        }
        
        return outImage;
    }
    
    ImageResource invertColor(ImageResource inImage) {
        
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel p: outImage.pixels()){
        
            Pixel currentPixel = inImage.getPixel(p.getX(), p.getY());
            
            int invertedR = 255 - currentPixel.getRed();
            int invertedG = 255 - currentPixel.getGreen();
            int invertedB = 255 - currentPixel.getBlue();
            
            p.setRed(invertedR);
            p.setGreen(invertedG);
            p.setBlue(invertedB);
        }
    
        return outImage;
    }
    
      void testInvertColor() {
    
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()) {
            
            ImageResource image = new ImageResource(f);
            ImageResource outImage = invertColor(image);
            
            String name = image.getFileName();
            String newName = "inverted-" + name;
            outImage.setFileName(newName);
           
            outImage.draw();
             outImage.save();
        }
        
    }

   
    void testMakeGrayscale() {
    
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()) {
            
            ImageResource image = new ImageResource(f);
            ImageResource outImage = makeGrayscale(image);
            
            String name = image.getFileName();
            String newName = "gray-" + name;
            outImage.setFileName(newName);
           
            outImage.draw();
             outImage.save();
        }
        
    }
}
