package View;

import Model.Symbol;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by berku on 14.1.2018.
 */

public class ImageManager {
    private static ImageManager instance;
    private Map<Symbol, Image> imageMap;
    private Image downSegmentImage;
    private Image upSegmentImage;
    private Image startSegmentImage;
    private Image endSegmentImage;

    private ImageManager() {
        System.out.println("FileManager created.");
        this.imageMap = new HashMap<>();
        try {
            setImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ImageManager getInstance() {
        if (instance == null) {
            instance = new ImageManager();
        }
        return instance;
    }

    private void setImages() throws IOException {
        downSegmentImage = ImageIO.read(new File("img/seg_02.png"));
        upSegmentImage = ImageIO.read(new File("img/seg_12.png"));
        startSegmentImage = ImageIO.read(new File("img/seg_start2.png"));
        endSegmentImage = ImageIO.read(new File("img/seg_start2.png"));
        Symbol[] symbols = Symbol.values();
        for (Symbol symbol : symbols) {
            imageMap.put(symbol, ImageIO.read(new File("img/symbols/" + symbol.toString() + ".png")));
        }
        System.out.println("ImageManager setImages completed.");
    }

    public Image getStartSegmentImage() {
        return startSegmentImage;
    }

    public Image getEndSegmentImage() {
        return endSegmentImage;
    }

    public Image getSegmentImage(int index) {
        return (index % 2 == 0) ? downSegmentImage : upSegmentImage;
    }

    public Image getSymbolImage(Symbol symbol) {
        return imageMap.get(symbol);
    }
}
