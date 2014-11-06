package org.lazydoc.example.extended.doc;

import org.lazydoc.config.Config;
import org.lazydoc.LazyDoc;

public class ExampleDocParser {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.setDocumentationSuffix("Documentation");
        config.setBreakOnUndocumented(true);

        config.setPackageToSearchForControllers("org.lazydoc.example");
        new LazyDoc(config).document();
    }
}
