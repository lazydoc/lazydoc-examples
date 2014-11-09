package org.lazydoc.example.simple.doc;

import org.lazydoc.config.Config;
import org.lazydoc.LazyDoc;
import org.lazydoc.config.PrinterConfig;

import java.util.HashMap;

public class ExampleDocParser {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.setDocumentationSuffix("Documentation");
        config.setBreakOnUndocumented(true);
        config.setPackageToSearchForControllers("org.lazydoc.example");

        String docExampleBasePath = args[0] + "/../lazydoc-swaggerexample/src/main/";
        HashMap<String, String> swaggerParams = new HashMap<String, String>();
        swaggerParams.put("swagger.basepath", "http://localhost:9999/lazydoc-spring");
        swaggerParams.put("swagger.views.properties.filename", docExampleBasePath + "resources/views.properties");
        swaggerParams.put("swagger.directory.name", "api");

        config.getPrinterConfigs().add(new PrinterConfig("org.lazydoc.printer.SwaggerDocumentationPrinter", docExampleBasePath + "webapp/WEB-INF/jsp/swagger/", swaggerParams));

        new LazyDoc(config).document();
    }
}
