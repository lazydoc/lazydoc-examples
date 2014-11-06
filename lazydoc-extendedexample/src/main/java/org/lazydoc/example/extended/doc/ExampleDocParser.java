package org.lazydoc.example.extended.doc;

import org.lazydoc.config.Config;
import org.lazydoc.config.PrinterConfig;
import org.lazydoc.LazyDoc;

import java.util.HashMap;

public class ExampleDocParser {

    public static void main(String[] args) throws Exception {
        Config config = new Config();

        config.setPackageToSearchForControllers("org.lazydoc.example");

        String docExampleBasePath = args[0] + "/../lazydoc-swaggerexample/src/main/";
        HashMap<String, String> swaggerParams = new HashMap<String, String>();
        swaggerParams.put("swagger.basepath", "http://localhost:9999/lazydoc-spring");
        swaggerParams.put("swagger.views.properties.filename", docExampleBasePath + "resources/views.properties");
        swaggerParams.put("swagger.directory.name", "api");

        config.getPrinterConfigs().add(new PrinterConfig("org.lazydoc.printer.SwaggerDocumentationPrinter", docExampleBasePath + "webapp/WEB-INF/jsp/swagger/", swaggerParams));

        HashMap<String, String> docbookParams = new HashMap<String, String>();
        docbookParams.put("docbook.filename", "lazydoc.xml");
        config.getPrinterConfigs().add(new PrinterConfig("org.lazydoc.printer.DocBookDocumentationPrinter", args[0] + "/../lazydoc-docbookexample/src/docbkx/lazydoc/", docbookParams));
        new LazyDoc(config).document();
    }
}
