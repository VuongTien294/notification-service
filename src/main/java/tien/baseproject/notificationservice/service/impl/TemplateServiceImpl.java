package tien.baseproject.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.stringtemplate.v4.ST;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TemplateServiceImpl {
    private static final String TEXT_TEMPLATE_PREFIX = "/templates/text/";
    private static final String TEXT_TEMPLATE_SUFFIX = ".txt";

    private final SpringTemplateEngine springTemplateEngine;

    public String buildContent(String template, Map<String, Object> variables, boolean html, Locale locale) throws IOException {
        if (html) {
            Context context = new Context(locale, variables);
            return springTemplateEngine.process(template, context);
        } else {
            InputStream inputStream = TemplateServiceImpl.class.getResourceAsStream(TEXT_TEMPLATE_PREFIX + template + TEXT_TEMPLATE_SUFFIX);
            String templateContent = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            ST st = new ST(templateContent);
            variables.forEach(st::add);
            return st.render();
        }
    }
}
