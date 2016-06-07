package engine.swing.graphics;

import java.awt.Composite;
import java.awt.CompositeContext;
import java.awt.RenderingHints;
import java.awt.image.ColorModel;

/**
 * There isn't a native additive composite, so we have to make our own.
 * @author Tom
 */
public class AdditiveComposite implements Composite {

    public AdditiveComposite() {
        super();
    }

    @Override
    public CompositeContext createContext(ColorModel srcColorModel, ColorModel dstColorModel, RenderingHints hints) {
        return new AdditiveCompositeContext();
    }
}
